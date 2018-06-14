package validator;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Versatile and adaptable validator. Receives and stores validation rules for a particular class of objects.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public class ValidatorManager {
    // Validations map.
    private HashMap<Class, Set<Rule>> validations;
    // Logs.
    private static final Logger LOGGER = Logger.getLogger("InfoLogging");

    /**
     * Constructor.
     */
    public ValidatorManager() {
        this.validations = new HashMap<>();
    }

    /**
     * Adds a new validation's rule for the specific class prototype.
     *
     * @param prototype The class prototype.
     * @param rule The rule to add.
     */
    public void addRuleFor(Class prototype, Rule rule) {
        // Get the rules set for that kind of object.
        HashSet rules = (HashSet) this.validations.get(prototype);
        // If no rules exists for that object, create a new set. Otherwise, add the rule the existing set.
        if (rules == null) {
            rules = new HashSet<>();
            rules.add(rule);
            this.validations.put(prototype, rules);
        } else {
            rules.add(rule);
        }
    }

    /**
     * Validates an object against its own defined validations ruleset and returns a list of
     * failed validation's rules.
     *
     * @param object The object to validate.
     */
    public Set<Rule> validate(Object object) {
        LOGGER.info(object.getClass().toString());

        return this.validateAgainstClassType(object, object.getClass());
    }

    /**
     * Validates an object against to the specified class prototype's ruleset and returns a list
     * containing the failed ruleset.
     *
     * @param object The object to validate.
     * @param prototype The class prototype to which the object will be validate against to.
     * @return The failed ruleset list.
     */
    private Set<Rule> validateAgainstClassType(Object object, Class prototype) {
        HashSet<Rule> failedRules = new HashSet<>();
        HashSet<Rule> rules = (HashSet<Rule>) this.validations.get(prototype);
        // Loop over all the object's validation ruleset.
        if (rules != null) {
            rules.forEach((Rule rule) -> {
                boolean valid = rule.validate(object);
                if (!valid) {
                    failedRules.add(rule);
                }
                LOGGER.info(rule.getName() + ": " + valid);
            });
        }
        // Inheritance hierarchy tree recursion's termination.
        if (prototype.getSuperclass() != Object.class) {
            LOGGER.info(prototype.getSuperclass().toString());
            this.validateAgainstClassType(object, prototype.getSuperclass());
        }

        return failedRules;
    }

    /**
     * Validates an object against its own defined validations ruleset and returns true if it
     * passed the validation's tests.
     *
     * @param object The object to validate.
     * @return boolean Validation's boolean result.
     */
    public boolean isValid(Object object) {
        return (this.validate(object).size() == 0);
    }

    /**
     * Builds a specific validator for a determined class prototype.
     *
     * @param prototype The class prototype of the validator.
     * @return The validator for the specify class prototype.
     */
    public IValidator buildValidatorFor(Class prototype) {
        return new IValidator() {

            public void addRule(Rule rule) {
                addRuleFor(prototype, rule);
            }

            public boolean isValid(Object object) {
                return (this.validate(object).size() == 0);
            }

            public Set<Rule> validate(Object object) {
                LOGGER.info(object.getClass().toString());

                return validateAgainstClassType(object, object.getClass());
            }
        };
    }
}
