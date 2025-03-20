import java.util.Stack;

public class StockSpanProblem {
    public static int[] calculateSpans(int[] prices) {
        int n = prices.length;
        int[] spans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            int span = stack.isEmpty() ? i + 1 : i - stack.peek();
            spans[i] = span;
            stack.push(i);
        }

        return spans;
    }

    public static void main(String[] args) {
        int[] prices = {10, 4, 5, 90, 120, 80};
        int[] spans = calculateSpans(prices);

        System.out.println("Prices: ");
        for (int price : prices) {
            System.out.print(price + " ");
        }

        System.out.println("\nSpans: ");
        for (int span : spans) {
            System.out.print(span + " ");
        }
    }
}

