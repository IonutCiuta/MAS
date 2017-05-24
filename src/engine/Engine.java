package engine;

import environment.Timetable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ionutciuta24@gmail.com on 25.05.2017.
 */
public class Engine {
    private static Timetable timetable = new Timetable();

    /* Reproduction of input 1 */
    static {
        timetable.setDayCount(2);
        timetable.setRoomCount(3);
        timetable.setTimeSlots(4);
        timetable.setStudentGroupCount(3);
        timetable.setTeachersCount(3);
        initCourseCount(2);
    }

    private static void initCourseCount(int defaultCourseCountPerDay) {
        timetable.setCourseCount(new ArrayList<>());
        /* Each student group*/
        for(int sg = 0; sg < timetable.getStudentGroupCount(); sg++) {
            Map<Integer, Integer> courseCount = new HashMap<>();
            /* Has 2 course in each day */
            for(int d = 0; d < timetable.getDayCount(); d++) {
                courseCount.put(d, defaultCourseCountPerDay);
            }
            timetable.getCourseCount().add(sg, courseCount);
        }
    }

    public static void main(String[] args) {
        timetable.setup();
        timetable.showProxies();
        timetable.showDelegates();
    }
}
