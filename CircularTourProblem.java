import java.util.Queue;
import java.util.LinkedList;

public class CircularTourProblem {
    public static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalPetrol = 0;
        int totalDistance = 0;
        int startingPoint = 0;
        int currentPetrol = 0;

        for (int i = 0; i < n; i++) {
            totalPetrol += petrol[i];
            totalDistance += distance[i];
        }

        if (totalPetrol < totalDistance) {
            return -1; // No possible starting point
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            currentPetrol += petrol[i] - distance[i];
            queue.add(currentPetrol);

            if (currentPetrol < 0) {
                // Reset queue and update starting point
                queue.clear();
                startingPoint = i + 1;
                currentPetrol = 0;
            }
        }

        return startingPoint;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};

        int startingPoint = findStartingPoint(petrol, distance);
        if (startingPoint != -1) {
            System.out.println("Starting point: " + startingPoint);
        } else {
            System.out.println("No possible starting point");
        }
    }
}