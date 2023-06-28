import java.util.Arrays;

public class MeetingScheduler {
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); // Sort intervals based on the start time
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false; // Overlapping intervals found
            }
        }
        return true; // No overlapping intervals found
    }

    public static void main(String[] args) {
        MeetingScheduler scheduler = new MeetingScheduler();

        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
        boolean canAttendAllMeetings = scheduler.canAttendMeetings(intervals);
        System.out.println(canAttendAllMeetings); // Output: false
    }
}
