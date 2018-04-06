package validator;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

/**
 * Versatile and adaptable validator. Receives and stores validation rules for a particular class of objects.
 */
public class ValidatorManager {
    // Validations map.
    private HashMap<Class, Set<Rule>> validations;

    /**
     * Constructor.
     */
    public ValidatorManager() {
        this.validations = new HashMap<>();
    }

    /**
     * Adds a new validation's rule for the specific class prototype.
     *
     * @param prototype
     * @param rule
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
    public void validate(Object object) {
        System.out.println(object.getClass());
        this.validateAgainstClassType(object, object.getClass());
    }

    private void validateAgainstClassType(Object object, Class prototype) {
        HashSet<Rule> rules = (HashSet<Rule>) this.validations.get(prototype);
        // Loop over all the object's validation ruleset.
        if (rules != null) {
            rules.forEach((Rule rule) -> {
                boolean res = (boolean) rule.getExec().apply(object);
                System.out.println(rule.getName() + ": " + res);
            });
        }
        // Hierarchy tree recursion's termination.
        if (prototype.getSuperclass() != Object.class) {
            System.out.println(prototype.getSuperclass());
            this.validateAgainstClassType(object, prototype.getSuperclass());
        }
    }

    /**
     * Validates an object against its own defined validations ruleset and returns true if it
     * passed the validation's tests.
     *
     * @param object The object to validate.
     * @return boolean Validation's boolean result.
     */
    public boolean isValid(Object object) {
        return true;
    }

    public Validator buildValidatorFor(Object prototype) {
        return new Validator();
    }

    public class Validator extends ValidatorManager {
        /**
         * Constructor.
         *
         * @param prototype Class type.
         * @param rule
         */
        public Validator() {
            super();
        }
    }
}
