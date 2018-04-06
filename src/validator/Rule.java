package validator;

import java.util.function.Function;

/**
 * Validation rule.
 *
 * @author Matías J. Magni <matias.magni@gmail.com>
 */
public class Rule {
    private String name;
    private String description;
    private Function<?, Boolean> exec;

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
     * @param exec Lambda expression with the validations to perform.
     */
    public Rule(String name, Function<?, Boolean> exec) {
        this(name);
        this.exec = exec;
    }

    /**
     * Constructor.
     *
     * @param name The rule's title.
     * @param exec Lambda expression with the validations to perform.
     * @param description The rule's validation description.
     */
    public Rule(String name, Function<?, Boolean> exec, String description) {
        this(name, exec);
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
     * Gets the validation's executable code.
     *
     * @return Lambda expression with the validations to perform.
     */
    public Function getExec() {
        return exec;
    }

    /**
     * Sets the validation's executable code.
     *
     * @param runnable Lambda expression with the validations to perform.
     */
    public void setExec(Function<?, Boolean> runnable) {
        this.exec = runnable;
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
     * Gets a string representation of the Rule.
     *
     * @return The Rule's name.
     */
    @Override public String toString() {
        return name;
    }
}
