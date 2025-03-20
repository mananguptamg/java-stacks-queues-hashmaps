import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Remove elements from the back of the deque that are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.removeLast();
            }

            // Add the current element to the deque
            deque.addLast(i);

            // Remove elements from the front of the deque that are out of the window
            if (deque.peekFirst() <= i - k) {
                deque.removeFirst();
            }

            // Add the maximum element of the current window to the result
            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        System.out.println("Maximum elements in each sliding window of size " + k + ":");
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
