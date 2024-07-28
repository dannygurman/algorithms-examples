package algorithms.arrays.findMaxMeetingsInOneRoom;

public class Meeting {

    public int start;
    public int end;
    public int positionIndex;

    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.positionIndex = pos;
    }
}
