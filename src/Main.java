import employees.Skill;
import employees.Engineer;
import employees.SoftwareEngineer;
import validator.Rule;
import validator.ValidatorManager;

/**
 * Program's main class.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public class Main {
    /**
     * Application's entry point.
     *
     * @param args CLI's program arguments.
     */
    public static void main(String args[]) {
        ValidatorManager vm = new ValidatorManager();

        // Skill grade's rule definition
        Rule skillGradeRule = new Rule("Skill Grade");
        skillGradeRule.setExec((Skill skill) -> {
            return (skill.getGrade() > 0 && skill.getGrade() <= 100);
        });
        vm.addRuleFor(Skill.class, skillGradeRule);

        // Engineer's age rule definition
        Rule engAgeRule = new Rule("Engineer's Age");
        engAgeRule.setExec((Engineer engineer) -> {
            return (engineer.getAge() > 23 && engineer.getAge() <= 60);
        });
        vm.addRuleFor(Engineer.class, engAgeRule);

        // Engineer's seniority rule definition.
        Rule engSeniorityRule = new Rule("Engineer's Seniority");
        engSeniorityRule.setExec((Engineer eng) -> {
            String s = eng.getSeniority();
            return (s == "Trainee" || s == "Junior" || s == "Semi-Senior" || s == "Senior");
        });
        vm.addRuleFor(Engineer.class, engSeniorityRule);

        // Engineer's age rule definition
        Rule softEngSalaryRule = new Rule("Software Engineer's Salary");
        softEngSalaryRule.setExec((SoftwareEngineer eng) -> {
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
        });
        vm.addRuleFor(SoftwareEngineer.class, softEngSalaryRule);

        // Skills validations.
        Skill communicationSkill = new Skill("Communication", true, 60);
        vm.validate(communicationSkill);

        // Engineer's validations
        SoftwareEngineer engMagni = new SoftwareEngineer(
                "Matías", "Magni", 31, true, 70000, "Semi-Senior"
        );
        engMagni.addSkill(communicationSkill);
        vm.validate(engMagni);
    }
}