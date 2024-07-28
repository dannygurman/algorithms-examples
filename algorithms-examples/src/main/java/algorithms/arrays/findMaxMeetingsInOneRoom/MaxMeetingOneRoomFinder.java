package algorithms.arrays.findMaxMeetingsInOneRoom;

import java.util.List;
import java.util.Set;

public interface MaxMeetingOneRoomFinder {

    /*
    Finds ids of meetings when number of meetings in room are maximum
     */
    Set<Integer> findMaxMeetingsIds( List<Meeting> meetings);
}
