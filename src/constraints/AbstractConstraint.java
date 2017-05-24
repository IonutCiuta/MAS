package constraints;

import tools.Logger;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public abstract class AbstractConstraint implements Constraint, Logger {
    private String name;

    public AbstractConstraint(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
