package agents;

import constraints.Constraint;
import environment.Environment;
import tools.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public abstract class AbstractAgent implements Agent, Logger{
    protected String id;
    protected Set<Constraint> constraints;

    public AbstractAgent(String id) {
        this.id = id;
        this.constraints = new HashSet<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Constraint> getConstraints() {
        return constraints;
    }

    public void setConstraints(Set<Constraint> constraints) {
        this.constraints = constraints;
    }
}
