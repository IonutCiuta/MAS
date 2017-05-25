package cell;

import agents.AbstractAgent;
import agents.BookingAgent;
import environment.AbstractEnvironment;

import java.util.HashSet;
import java.util.Set;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public class Cell {
    /* Room details */
    private int day;
    private int timeslot;
    private Room room;

    /* Functional properties */
    private String occupyingAgentId;
    private Set<String> visitingAgentsIds;

    public Cell(int day, int timeslot, Room room) {
        this.day = day;
        this.timeslot = timeslot;
        this.room = room;
        this.visitingAgentsIds = new HashSet<>();
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getOccupyingAgentId() {
        return occupyingAgentId;
    }

    public void setOccupyingAgentId(BookingAgent occupyingAgent) {
        this.occupyingAgentId = occupyingAgent.getId();
    }

    public Set<String> getVisitingAgentsIds() {
        return visitingAgentsIds;
    }

    public void setVisitingAgentsIds(Set<String> visitingAgentsIds) {
        this.visitingAgentsIds = visitingAgentsIds;
    }

    public void addVisitingAgent(AbstractAgent agent) { this.visitingAgentsIds.add(agent.getId()); }

    public boolean isOccupied() {
        return this.occupyingAgentId != null;
    }

    @Override
    public String toString() {
        return  "Cell: " +
                "\n\tDay:"                + day +
                "\n\tTimeslot: "          + getPretyStlot() +
                "\n\t"                    + room +
                "\n\tOccupyingAgentId: "  + occupyingAgentId +
                "\n\tVisitingAgentsIds: " + visitingAgentsIds +
                "\n";
    }

    /* from 8000 - 18000*/
    private String getPretyStlot() {
        return (800 + 200*timeslot) + " - " + (800 + 200*(timeslot+1));
    }
}
