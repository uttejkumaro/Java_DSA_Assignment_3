import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> ranges = new ArrayList<>();

        // Calculate the starting range
        int start = lower;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > start) {
                ranges.add(formatRange(start, nums[i] - 1));
            }
            start = nums[i] + 1;
        }

        // Calculate the ending range if necessary
        if (start <= upper) {
            ranges.add(formatRange(start, upper));
        }

        return ranges;
    }

    private static String formatRange(int lower, int upper) {
        if (lower == upper) {
            return "[" + lower + "]";
        } else {
            return "[" + lower + "," + upper + "]";
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3, 50, 75};
        int lower = 0;
        int upper = 99;

        List<String> missingRanges = findMissingRanges(nums, lower, upper);
        for (String range : missingRanges) {
            System.out.println(range);
        }
    }
}
