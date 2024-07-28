package algorithms.arrays.findMaxMeetingsInOneRoom;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class MaxMeetingOneRoomFinderTest {


    @Test
    public void testMaxMeetingOneRoomFinder() {
        // Starting time
        int starts[] =   {1, 3, 0, 5, 8, 5 };

        // Finish time
        int finishes[] = {2, 4, 6, 7, 9, 9 };

       /* First meeting [1, 2] - index 0
        Second meeting [3, 4] - index 1
        Fourth meeting [5, 7] - index 3
        Fifth meeting [8, 9] - index 4
        */
        Set<Integer> expectedIds = Set.of(0, 1, 3 ,4);

        // Defining an arraylist of meet type
        List<Meeting> meetings = new ArrayList<>();

        for (int i = 0; i < starts.length; i++) {
            // Creating object of meeting and adding in the list
            meetings.add(new Meeting(starts[i], finishes[i], i));
        }

        MaxMeetingOneRoomFinder finder = new MaxMeetingOneRoomFinderImpl();

        Set<Integer> foundMaxMeetingIds =  finder.findMaxMeetingsIds(meetings);

        Assert.assertEquals(expectedIds, foundMaxMeetingIds);




    }
}
