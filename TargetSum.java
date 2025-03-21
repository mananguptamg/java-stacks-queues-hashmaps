import java.util.HashMap;

public class TargetSum {
    public static void main(String[] args) {
        int arr[] = {2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> map = new HashMap<>();

        // Store array elements in HashMap with their indices
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], i);
        }

        boolean isPairExist = false;

        // Iterate through array to check if a valid pair exists
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // Check if complement exists in map and is not the same index
            if (map.containsKey(complement) && map.get(complement) != i) {
                isPairExist = true;
                break;
            }
        }

        System.out.println(isPairExist ? "true" : "false");
    }
}
