import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
       // int arr[] = {100,4,200,1,3,2};
        int arr[] = {0,3,7,2,5,8,4,6,0,1};

        HashSet<Integer> set = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            set.add(arr[i]);
        }

        int maxConsec = 0;

        for(int i=0;i<arr.length;i++){
            int cons=0;
            int currentEle = arr[i];
            while(set.contains(currentEle)){
                currentEle+=1;
                cons++;
            }
            maxConsec = Math.max(cons,maxConsec);
        }

        System.out.println(maxConsec);
    }
}