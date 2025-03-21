import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {2,7,11,15};
        int target = 9;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }

        int ans[] = new int[2];

        for(int i=0;i<ans.length;i++){
            if(map.containsKey(target-arr[i])){
                ans[0] = arr[i];
                ans[1] = target-arr[i];
                break;
            }
        }

        System.out.println(arr[0] +" " + arr[1]);

    }
}