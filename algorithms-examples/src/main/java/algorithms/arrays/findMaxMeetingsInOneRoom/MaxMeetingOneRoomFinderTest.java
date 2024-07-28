package algorithms.arrays.findMaxMeetingsInOneRoom;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MaxMeetingOneRoomFinderTest {


    @Test
    public void testMaxMeetingOneRoomFinder() {
        // Starting time
        int starts[] = { 1, 3, 0, 5, 8, 5 };

        // Finish time
        int finishes[] = { 2, 4, 6, 7, 9, 9 };

        // Defining an arraylist of meet type
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < starts.length; i++) {
            // Creating object of meeting and adding in the list
            meetings.add(new Meeting(starts[i], finishes[i], i));
        }

        MaxMeetingOneRoomFinder finder = new MaxMeetingOneRoomFinderImpl();


    }
}
