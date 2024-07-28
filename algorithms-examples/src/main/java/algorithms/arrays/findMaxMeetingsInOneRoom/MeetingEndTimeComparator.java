package algorithms.arrays.findMaxMeetingsInOneRoom;

import java.util.Comparator;

public class MeetingEndTimeComparator implements Comparator<Meeting> {

    @Override
    public int compare(Meeting meeting1, Meeting meeting2) {
        if (meeting1.end < meeting2.end) {
            return -1;
        } else if (meeting1.end > meeting2.end) {
            return 1;
        } else {
            return 0;
        }
    }

}
