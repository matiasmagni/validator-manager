package validator;

import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

/**
 *
 */
public class ValidatorManager {
    private HashMap<Class, Set<Rule>> validations;

    /**
     * Constructor.
     */
    public ValidatorManager() {
        this.validations = new HashMap<>();
    }

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

    public void validate(Object object) {
        HashSet<Rule> rules = (HashSet<Rule>) this.validations.get(object.getClass());
        rules.forEach((Rule rule) -> {
            boolean res = (boolean) rule.getExec().apply(object);
            System.out.println(res);
        });
    }

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
