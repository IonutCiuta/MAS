package environment;

import agents.BookingAgent;
import agents.RepresentativeAgent;
import cell.Cell;
import cell.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public class Timetable extends AbstractEnvironment {
    private static final int DEFAULT_ROOM_SIZE = 30;

    /* Grid dimension */
    private int dayCount, timeSlots, roomCount;

    /* Agent details */
    private int studentGroupCount, teachersCount;
    private List<Map<Integer, Integer>> courseCount = new ArrayList<>();

    public void setup() {
        log("Setting up the timetable");
        this.grid = new Cell[timeSlots][dayCount * roomCount];

        for(int timeslot = 0; timeslot < timeSlots; timeslot++) {
            for(int day = 0; day < dayCount; day++) {
                for(int room = 0; room < roomCount; room++) {
                    Room roomObj = new Room("room-" + room, DEFAULT_ROOM_SIZE);
                    grid[timeslot][day * roomCount + room] = new Cell(day, timeslot,roomObj);
                }
            }
        }

        for(int sg = 0; sg < studentGroupCount; sg++) {
            String sgId = "SG-" + sg;
            RepresentativeAgent ra = new RepresentativeAgent(sgId);

            int totalBAs = 0;
            for(Integer day : courseCount.get(sg).keySet()) {
                totalBAs += courseCount.get(sg).get(day);
            }

            for (int baIdx = 0; baIdx < totalBAs; baIdx++) {
                String baId = "BAS-" + sg + "-" + baIdx;
                BookingAgent ba = new BookingAgent(baId);
                ba.setProxyId(sgId);
                ra.addDelegate(ba);
                delegates.add(ba);
            }

            proxies.add(ra);
        }

        for(int t = 0; t < teachersCount; t++) {
            String sgId = "T-" + t;
            RepresentativeAgent ra = new RepresentativeAgent(sgId);

            //TODO: fix harcoded data
            for (int baIdx = 0; baIdx < 6; baIdx++) {
                String baId = "BAT-" + t + "-" + baIdx;
                BookingAgent ba = new BookingAgent(baId);
                ba.setProxyId(sgId);
                ra.addDelegate(ba);
                delegates.add(ba);
            }

            proxies.add(ra);
        }
    }

    public int getDayCount() {
        return dayCount;
    }

    public void setDayCount(int dayCount) {
        this.dayCount = dayCount;
    }

    public int getTimeSlots() {
        return timeSlots;
    }

    public void setTimeSlots(int timeSlots) {
        this.timeSlots = timeSlots;
    }

    public int getRoomCount() {
        return roomCount;
    }

    public void setRoomCount(int roomCount) {
        this.roomCount = roomCount;
    }

    public int getStudentGroupCount() {
        return studentGroupCount;
    }

    public void setStudentGroupCount(int studentGroupCount) {
        this.studentGroupCount = studentGroupCount;
    }

    public int getTeachersCount() {
        return teachersCount;
    }

    public void setTeachersCount(int teachersCount) {
        this.teachersCount = teachersCount;
    }

    public List<Map<Integer, Integer>> getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(List<Map<Integer, Integer>> courseCount) {
        this.courseCount = courseCount;
    }

    public void showProxies() {
        log(proxies.toString());
    }

    public void showDelegates() {
        log(delegates.toString());
    }
}
