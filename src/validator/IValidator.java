package validator;

import java.util.Set;

/**
 * Specific validator for a determined class prototype.
 */
public interface IValidator {
    /**
     * Adds a new validation's rule.
     *
     * @param rule The rule to add.
     */
    void addRule(Rule rule);

    /**
     * Validates an object against its own defined validations ruleset and returns true if it
     * passed the validation's tests.
     *
     * @param object The object to validate.
     * @return boolean Validation's boolean result.
     */
    boolean isValid(Object object);

    /**
     * Validates an object against its own defined validations ruleset and returns a list of
     * failed validation's rules.
     *
     * @param object The object to validate.
     */
    Set<Rule> validate(Object object);
}
