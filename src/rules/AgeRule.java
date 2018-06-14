package rules;

import employees.Employee;
import validator.Rule;

public class AgeRule extends Rule<Employee> {
    /**
     * Constructor.
     *
     * @param name The rule's title.
     */
    public AgeRule(String name) {
        super(name, "Validates an Employee's age attribute.");
    }

    /**
     * Validates that the skill grade is a percentage value.
     *
     * @param skill The skill to evalute.
     * @return <code>true</code> if the skill grade is a percentage value.
     *         <code>false</code> if the skill grade isn't a percentage value.
     */
    @Override
    public boolean validate(Employee employee) {
        return (employee.getAge() > 23 && employee.getAge() <= 60);
    }
}
