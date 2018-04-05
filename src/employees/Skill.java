package employees;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSoft() {
        return soft;
    }

    public void setSoft(boolean soft) {
        this.soft = soft;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
