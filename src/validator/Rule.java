package validator;

/**
 * Validation rule.
 *
 * @author Matías J. Magni <matias.magni@gmail.com>
 */
public abstract class Rule<T> {
    protected String name;
    protected String description;

    /**
     * Constructor.
     *
     * @param name The rule's title.
     */
    public Rule(String name) {
        this.name = name;
    }

    /**
     * Constructor.
     *
     * @param name The rule's title.
     * @param description The rule's validation description.
     */
    public Rule(String name, String description) {
        this(name);
        this.description = description;
    }

    /**
     * Gets the rule's title.
     *
     * @return The rule's title.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the rule's title.
     *
     * @param name The rule's title.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the rule's purpose description.
     *
     * @return The rule's purpose description.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the rule's purpose description.
     *
     * @param description The rule's purpose description.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Validates an object against a set of validation's rules.
     *
     * @param object The object to be validated.
     * @return <code>true</code> if the object is valid.
     *         <code>false</code> if the object is invalid.
     */
    public abstract boolean validate(T object);

    /**
     * Gets a string representation of the Rule.
     *
     * @return The Rule's name.
     */
    @Override public String toString() {
        return name;
    }
}
