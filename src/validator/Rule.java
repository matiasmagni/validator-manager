package validator;

import java.util.function.Function;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Function getExec() {
        return exec;
    }

    public void setExec(Function<?, Boolean> runnable) {
        this.exec = runnable;
    }

    @Override
    public String toString() {
        return name;
    }
}
