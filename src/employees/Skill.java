package employees;

/**
 * Represents an employee's skill.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public class Skill {
    private String name;
    private boolean soft;
    private int grade;

    /**
     * Constructor.
     *
     * @param name The skill's title.
     * @param soft True if it's a soft skill, otherwise false for hard skill.
     */
    public Skill(String name, boolean soft) {
        this.name = name;
        this.soft = soft;
    }

    /**
     * Constructor.
     *
     * @param name The skill's title.
     * @param soft True if it's a soft skill, otherwise false for hard skill.
     * @param grade Skill's grade development. Percentage value between 0 and 100.
     */
    public Skill(String name, boolean soft, int grade) {
        this(name, soft);
        this.grade = grade;
    }

    /**
     * Gets the skill's title.
     *
     * @return The skill's title.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the skill's title.
     *
     * @param name The skill's title.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Determines if it's a soft skill.
     *
     * @return True if it's a soft skill, otherwise, false for a hard skill.
     */
    public boolean isSoft() {
        return soft;
    }

    /**
     * Sets the skill as "soft" (true) or "hard" (false).
     *
     * @param soft True if it's a soft skill, otherwise, false for a hard skill.
     */
    public void setSoft(boolean soft) {
        this.soft = soft;
    }

    /**
     * Gets the skill's grade development. Percentage value between 0 and 100.
     *
     * @return The skill's grade development percentage.
     */
    public int getGrade() {
        return grade;
    }

    /**
     * Sets the skill's grade development. Percentage value between 0 and 100.
     *
     * @param grade The skill's grade development percentage.
     */
    public void setGrade(int grade) {
        this.grade = grade;
    }
}