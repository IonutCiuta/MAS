package agents;

import communication.Message;
import constraints.Constraint;
import environment.AbstractEnvironment;
import environment.Environment;
import environment.Timetable;

import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public class RepresentativeAgent extends AbstractAgent {
    private Set<String> delegateIds;

    public RepresentativeAgent(String id) {
        super(id);
        this.delegateIds = new HashSet<>();
    }

    public void addConstraint(Constraint constraint, Timetable env) {
        log("Add constraint: " + constraint.toString());
        this.constraints.add(constraint);
        env.getDelegates().stream()
                .filter(d -> delegateIds.contains(d.getId()))
                .forEach(d -> d.getConstraints().add(constraint));

    }

    public void removeConstraint(Constraint constraint, Timetable env) {
        log("Remove constraint: " + constraint.toString());
        this.constraints.remove(constraint);
        env.getDelegates().stream()
                .filter(d -> delegateIds.contains(d.getId()))
                .forEach(d -> d.getConstraints().remove(constraint));
    }

    public void addDelegate(BookingAgent agent) {
        this.delegateIds.add(agent.getId());
    }

    public void messageBA(Message message, Timetable env) {
        Optional<AbstractAgent> agent = env.getDelegates().stream()
                .filter(d -> delegateIds.contains(message.getReceiverId()))
                .findFirst();

        ((BookingAgent)agent.get()).addMessage(message);
    }

    @Override
    public String toString() {
        return "RepresentativeAgent{" +
                "id='" + id + '\'' +
                ", constraints=" + constraints +
                '}';
    }
}
