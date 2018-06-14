package rules;

import validator.Rule;
import employees.Skill;


public class SkillRule extends Rule<Skill> {
    /**
     * Constructor.
     *
     * @param name The rule's title.
     */
    public SkillRule(String name) {
        super(name, "Validates an object as a valid skill");
    }

    /**
     * Validates that the skill grade is a percentage value.
     *
     * @param skill The skill to evalute.
     * @return <code>true</code> if the skill grade is a percentage value.
     *         <code>false</code> if the skill grade isn't a percentage value.
     */
    @Override
    public boolean validate(Skill skill) {
        return validateGrade(skill);
    }

    /**
     * Validates that the skill grade is a percentage value.
     *
     * @param skill The skill to evalute.
     * @return <code>true</code> if the skill grade is a percentage value.
     *         <code>false</code> if the skill grade isn't a percentage value.
     */
    public boolean validateGrade(Skill skill) {
        return (skill.getGrade() > 0 && skill.getGrade() <= 100);
    }
}
