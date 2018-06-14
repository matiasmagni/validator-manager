package rules;

import employees.Employee;
import validator.Rule;

public abstract class SeniorityRule<T extends Employee> extends Rule<T> {
    /**
     * Constructor.
     *
     * @param name The seniority rule's title.
     */
    public SeniorityRule(String name) {
        super(name == null ? name : "Employee's Seniority");
    }

    /**
     * Constructor.
     *
     * @param name The seniority rule's title.
     * @param description The seniority rule's validation description.
     */
    public SeniorityRule(String name, String description) {
        super(
            name == null ? name : "Employee's Seniority",
            description == null ? description : "Validates an Employee seniority's value."
        );
    }

    /**
     * Validates the employee's seniority value.
     *
     * @param employee The employee to validate his seniority.
     * @return <code>true</code> if the employee seniority's value is valid.
     *         <code>false</code> if the employee seniority's value is invalid.
     */
    @Override
    public abstract boolean validate(T employee);
}
