import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ParsingInExpression {
    public static void main(String[] args) {

        String expression = "52-";
        List<Character> operations = new ArrayList<>();
        LinkedList<Integer> numbers = new LinkedList<>();

        char[] arrayExp = expression.toCharArray();

        for (int i = 0; i < arrayExp.length; i++) {
            char c = arrayExp[i];
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operations.add(c);
            } else {
                numbers.add(Integer.parseInt(String.valueOf(c)));
            }
        }

        while (!operations.isEmpty()) {
            int numbLast = numbers.removeLast();
            int numbLast2 = numbers.removeLast();

            for (int a = 0; a < operations.size(); a++) {
                char v = operations.get(a);
                operations.remove(0);

                if (v == '+') {
                    numbers.add(numbLast + numbLast2);
                }
                if (v == '-') {
                    numbers.add(numbLast - numbLast2);
                }
                if (v == '/') {
                    numbers.add(numbLast / numbLast2);
                }
                if (v == '*') {
                    numbers.add(numbLast + numbLast2);
                }
            }
        }
        System.out.println(numbers.get(0));

    }
}