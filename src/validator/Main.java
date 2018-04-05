package validator;

import employees.Skill;

public class Main {
    public static void main(String args[]) {
        ValidatorManager vm = new ValidatorManager();
        Rule gradeRule = new Rule("Skill Grade");

        gradeRule.setExec((Skill skill) -> {
            return (skill.getGrade() > 0 && skill.getGrade() <= 100);
        });

        vm.addRuleFor(Skill.class, gradeRule);

        Skill communicationSkill = new Skill("communication", true, 60);
        vm.validate(communicationSkill);
    }
}