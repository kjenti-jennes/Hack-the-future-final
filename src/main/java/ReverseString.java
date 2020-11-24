import java.util.Scanner;

public class ReverseString {
    public void ReverseString(String input) {
        StringBuilder input1 = new StringBuilder();

        input1.append(input);
        input1 = input1.reverse();

        System.out.println(input1);

    }
}
