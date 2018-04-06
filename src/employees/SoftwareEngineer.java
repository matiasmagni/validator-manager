package employees;

/**
 * Software Engineer employee representation.
 *
 * @author Matías J. Magni <matias.magni@globallogic.com>
 */
public class SoftwareEngineer extends Engineer {
    /**
     * Constructor.
     *
     * @param name    The engineer's name.
     * @param surname The engineer's surname.
     */
    public SoftwareEngineer(String name, String surname) {
        super(name, surname);
    }

    /**
     * Constructor.
     *
     * @param name    The engineer's name.
     * @param surname The engineer's surname.
     * @param age     The engineer's age.
     * @param male    The engineer's genre. True if is male, otherwise false on female.
     * @param salary  The engineer's salary in dollars.
     */
    public SoftwareEngineer(String name, String surname, int age, boolean male, float salary) {
        super(name, surname, age, male, salary);
    }

    /**
     * Constructor.
     *
     * @param name      The engineer's name.
     * @param surname   The engineer's surname.
     * @param age       The engineer's age.
     * @param male      The engineer's genre. True if is male, otherwise false on female.
     * @param salary    The engineer's salary in dollars.
     * @param seniority The engineer's seniority level.
     */
    public SoftwareEngineer(String name, String surname, int age, boolean male, float salary, String seniority) {
        super(name, surname, age, male, salary, seniority);
    }
}
