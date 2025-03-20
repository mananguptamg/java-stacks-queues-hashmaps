import java.util.Stack;

public class SortingStack {
    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }

        int temp = stack.pop();
        sortStack(stack);

        insertAtCorrectPosition(stack, temp);
    }

    private static void insertAtCorrectPosition(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() < value) {
            stack.push(value);
        } else {
            int temp = stack.pop();
            insertAtCorrectPosition(stack, value);
            stack.push(temp);
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(3);
        stack.push(8);
        stack.push(1);
        stack.push(4);

        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
    }
}
