package algorithms.arrays.findMaxMeetingsInOneRoom;

import java.util.List;
import java.util.Set;

public interface MaxMeetingOneRoomFinder {

    /*
    Finds ids (array index) of max possible meetings
     */
    Set<Integer> findMaxMeetingsIds( List<Meeting> meetings);
}
