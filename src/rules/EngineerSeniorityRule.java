package rules;

import employees.Engineer;


public class EngineerSeniorityRule extends SeniorityRule<Engineer> {
    /**
     * Constructor.
     */
    public EngineerSeniorityRule() {
        super("Engineer's Seniority", "Validates an Engineer seniority's value.");
    }

    /**
     * Validates the engineer's seniority value.
     *
     * @param employee The employee to validate his seniority.
     * @return <code>true</code> if the employee seniority's value is valid.
     *         <code>false</code> if the employee seniority's value is invalid.
     */
    @Override
    public boolean validate(Engineer eng) {
        String s = eng.getSeniority();

        return (s == "Trainee" || s == "Junior" || s == "Semi-Senior" || s == "Senior");
    }
}
