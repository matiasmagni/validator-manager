import employees.Skill;
import employees.Engineer;
import employees.SoftwareEngineer;
import rules.AgeRule;
import rules.EngineerSeniorityRule;
import rules.SkillRule;
import rules.SoftwareEngineerSalaryRule;
import validator.Rule;
import validator.ValidatorManager;
import java.util.HashSet;
import validator.IValidator;


/**
 * Program's main class.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public class Main {

    private static final String NEW_LINE = System.getProperty("line.separator");
    
    /**
     * Application's entry point.
     *
     * @param args CLI's program arguments.
     */
    public static void main(String args[]) {
        ValidatorManager vm = new ValidatorManager();

        // Skill grade's rule definition.
        Rule skillGradeRule = new SkillRule("Skill Grade");
        vm.addRuleFor(Skill.class, skillGradeRule);

        // Engineer's age rule definition.
        Rule engAgeRule = new AgeRule("Engineer's Age");
        vm.addRuleFor(Engineer.class, engAgeRule);

        // Engineer's seniority rule definition.
        Rule engSeniorityRule = new EngineerSeniorityRule();
        vm.addRuleFor(Engineer.class, engSeniorityRule);

        // Engineer's age rule definition.
        Rule softEngSalaryRule = new SoftwareEngineerSalaryRule();
        vm.addRuleFor(SoftwareEngineer.class, softEngSalaryRule);

        // Skills validations.
        Skill communicationSkill = new Skill("Communication", true, 110);
        HashSet<Rule> failedRules = (HashSet<Rule>) vm.validate(communicationSkill);

        // Engineer's validations.
        SoftwareEngineer engMagni = new SoftwareEngineer(
                "Matías", "Magni", 31, true, 30000, "Semi-Senior"
        );
        engMagni.addSkill(communicationSkill);
        failedRules.addAll(vm.validate(engMagni));

        // Print the failed ruleset list.
        System.out.println(NEW_LINE + "Failed ruleset list:");
        System.out.println("--------------------" + NEW_LINE);
        failedRules.forEach((Rule rule) -> {
            System.out.println("* " + rule.getName());
        });

        // isValid() check.
        System.out.println(NEW_LINE + "Validation results:");
        System.out.println("---------------------" + NEW_LINE);
        System.out.println(communicationSkill.getName() + ": " + vm.isValid(communicationSkill) + NEW_LINE);
        System.out.println(engMagni.getName() + ": " + vm.isValid(engMagni) + NEW_LINE);

        // Specific validator.
        IValidator validator = vm.buildValidatorFor(SoftwareEngineer.class);
        validator.validate(engMagni);
        validator.isValid(engMagni);

    }
}