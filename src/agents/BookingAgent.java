package agents;

import cell.Cell;
import cell.XYCell;
import communication.Message;
import environment.Timetable;

import java.util.*;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public class BookingAgent extends AbstractAgent {
    private String proxyId;
    private Queue<Message> messages;
    private boolean active;

    /* Memory */
    private Set<String> knownAgentsIds;
    private Set<XYCell> knowCells;

    public BookingAgent(String id) {
        super(id);
        this.messages = new PriorityQueue<>();
        this.knownAgentsIds = new HashSet<>();
        this.knowCells = new HashSet<>();
    }

    public void exploreCell(int x, int y, Timetable timetable) {
        knowCells.add(new XYCell(x, y));
        Cell currentCell = timetable.cell(x, y);
        knownAgentsIds.addAll(currentCell.getVisitingAgentsIds());
        currentCell.addVisitingAgent(this);
    }

    public void processCell(int x, int y, Timetable timetable) {
        Cell currentCell = timetable.cell(x, y);

        if(currentCell.isOccupied()) {
            log(getId() + " is in occupied cell " + currentCell);
        } else {
            log(getId() + " occupied cell " + currentCell);
            occupyCell(currentCell);
        }
    }

    private void occupyCell(Cell cell) {
        cell.setOccupyingAgentId(this);
        deactiveAgent();
    }

    private void move(Timetable timetable) {
        //find x, y of agent
        //compute possible moves
        //decide where to move based on memory and new possibilities
        //should move random at first
    }

    public String getProxyId() {
        return proxyId;
    }

    public void setProxyId(String proxyId) {
        this.proxyId = proxyId;
    }

    public void addMessage(Message message) {
        this.messages.add(message);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void deactiveAgent() {
        this.active = false;
    }

    @Override
    public String toString() {
        return "BookingAgent{" +
                "proxyId='" + proxyId + '\'' +
                ", id='" + id + '\'' +
                ", constraints=" + constraints +
                '}';
    }
}
