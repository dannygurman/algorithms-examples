package algorithms.arrays.findMaxMeetingsInOneRoom;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxMeetingOneRoomFinderImpl implements MaxMeetingOneRoomFinder{

    MeetingEndTimeComparator  meetingEndTimeComparator = new MeetingEndTimeComparator();
    @Override
    public Set<Integer> findMaxMeetingsIds(List<Meeting> meetings) {

        Set <Integer> resultMeetingIds = new HashSet<>();

        int timeLimit = 0;

        // Sorting of meeting according to their finish time.
        Collections.sort(meetings, meetingEndTimeComparator);

        // Initially select first meeting (finished first).
        resultMeetingIds.add(meetings.get(0).positionIndex);

        // time_limit to check whether new meeting can be conducted or not.
        timeLimit = meetings.get(0).end;

        // Check for all meeting whether it can be selected or not.
        for (int i = 1; i < meetings.size(); i++) {

            if (meetings.get(i).start > timeLimit) {

                // Add selected meeting to arraylist
                resultMeetingIds.add(meetings.get(i).positionIndex);

                // Update time limit
                timeLimit = meetings.get(i).end;
            }
        }

        return resultMeetingIds;
    }
}
