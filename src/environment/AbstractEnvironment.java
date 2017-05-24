package environment;

import agents.AbstractAgent;
import agents.Agent;
import agents.BookingAgent;
import agents.RepresentativeAgent;
import cell.Cell;
import tools.Logger;

import java.util.HashSet;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public abstract class AbstractEnvironment implements Environment, Logger{
    protected Cell[][] grid;
    protected Set<AbstractAgent> proxies;
    protected Set<AbstractAgent> delegates;

    public AbstractEnvironment() {
        proxies = new HashSet<>();
        delegates = new HashSet<>();
    }

    public void addAgent(AbstractAgent agent) {
        if(agent instanceof RepresentativeAgent) {
            proxies.add(agent);
        }

        if(agent instanceof BookingAgent) {
            delegates.add(agent);
        }
    }

    private RepresentativeAgent getAR(String id) {
        return (RepresentativeAgent) proxies
                .stream().filter(ar -> ar.getId().equals(id))
                .findFirst().get();
    }

    private BookingAgent getBA(String id) {
        return (BookingAgent) delegates
                .stream().filter(ar -> ar.getId().equals(id))
                .findFirst().get();
    }

    public Set<AbstractAgent> getProxies() {
        return proxies;
    }

    public Set<AbstractAgent> getDelegates() {
        return delegates;
    }

    public Cell[][] grid() {
        return grid;
    }
}
