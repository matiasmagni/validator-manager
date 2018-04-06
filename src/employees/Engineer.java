package employees;

/**
 * Engineer employee representation.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public class Engineer extends Employee {
    // The engineer's seniority level.
    protected String seniority;

    /**
     * Constructor.
     *
     * @param name The engineer's name.
     * @param surname The engineer's surname.
     */
    public Engineer(String name, String surname) {
        super(name, surname);
    }

    /**
     * Constructor.
     *
     * @param name The engineer's name.
     * @param surname The engineer's surname.
     * @param age The engineer's age.
     * @param male The engineer's genre. True if is male, otherwise false on female.
     * @param salary The engineer's salary in dollars.
     */
    public Engineer(String name, String surname, int age, boolean male, float salary) {
        super(name, surname, age, male, salary);
    }

    /**
     * Constructor.
     *
     * @param name The engineer's name.
     * @param surname The engineer's surname.
     * @param age The engineer's age.
     * @param male The engineer's genre. True if is male, otherwise false on female.
     * @param salary The engineer's salary in dollars.
     * @param seniority The engineer's seniority level.
     */
    public Engineer(String name, String surname, int age, boolean male, float salary, String seniority) {
        super(name, surname, age, male, salary);
        this.seniority = seniority;
    }

    /**
     * Gets the engineer's seniority level.
     *
     * @return The engineer's seniority level.
     */
    public String getSeniority() {
        return seniority;
    }

    /**
     * Sets the engineer's seniority level.
     *
     * @param seniority The engineer's seniority level.
     */
    public void setSeniority(String seniority) {
        this.seniority = seniority;
    }
}
