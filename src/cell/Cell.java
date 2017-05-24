package cell;

import agents.BookingAgent;
import tools.Logger;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    private BookingAgent occupyingAgent;
    private Set<BookingAgent> visitingAgents;

    public Cell(int day, int timeslot, Room room) {
        this.day = day;
        this.timeslot = timeslot;
        this.room = room;
        this.visitingAgents = new HashSet<>();
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

    public BookingAgent getOccupyingAgent() {
        return occupyingAgent;
    }

    public void setOccupyingAgent(BookingAgent occupyingAgent) {
        this.occupyingAgent = occupyingAgent;
    }

    public Set<BookingAgent> getVisitingAgents() {
        return visitingAgents;
    }

    public void setVisitingAgents(Set<BookingAgent> visitingAgents) {
        this.visitingAgents = visitingAgents;
    }

    public boolean isOccupied() {
        return this.occupyingAgent != null;
    }

    @Override
    public String toString() {
        return "Cell: " + "day=" + day + ", timeslot=" + timeslot +
                "\nroom: "           + room +
                "\noccupyingAgent: " + occupyingAgent +
                "\nvisitingAgents: " + visitingAgents;
    }
}
