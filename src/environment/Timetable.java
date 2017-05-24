package environment;

import cell.Cell;

import java.util.ArrayList;
import java.util.List;

/**
 * ionutciuta24@gmail.com on 24.05.2017.
 */
public class Timetable extends AbstractEnvironment {
    /* Grid dimension */
    private int dayCount, timeSlots, roomCount;

    /* Agent details */
    private int studentGroupCount, teachersCount;
    private List<Integer> courseCount = new ArrayList<>();

    public void setup() {
        this.grid = new Cell[timeSlots][dayCount * roomCount];
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

    public List<Integer> getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(List<Integer> courseCount) {
        this.courseCount = courseCount;
    }
}
