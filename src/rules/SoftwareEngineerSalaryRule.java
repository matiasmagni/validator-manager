package rules;

import employees.SoftwareEngineer;
import validator.Rule;

public class SoftwareEngineerSalaryRule extends Rule<SoftwareEngineer> {
    /**
     * Constructor.
     */
    public SoftwareEngineerSalaryRule() {
        super(
            "Software Engineer's Annual Salary",
            "Validates a Software Engineer's Annual Salary is in the correct" +
                    "range considering his seniority"
        );
    }

    /**
     * Validates that the skill grade is a percentage value.
     *
     * @param skill The skill to evalute.
     * @return <code>true</code> if the skill grade is a percentage value.
     *         <code>false</code> if the skill grade isn't a percentage value.
     */
    @Override
    public boolean validate(SoftwareEngineer eng) {
        boolean state = false;
        switch (eng.getSeniority()) {
            case "Trainee":
                state = eng.getSalary() >= 30000 && eng.getSalary() < 48000;
                break;
            case "Junior":
                state = eng.getSalary() >= 48000 && eng.getSalary() <= 67000;
                break;
            case "Semi-Senior":
                state = eng.getSalary() > 67000 && eng.getSalary() < 103000;
                break;
            case "Senior":
                state = eng.getSalary() >= 103000 && eng.getSalary() <= 119000;
                break;
        }

        return state;
    }
}
