import java.util.Scanner;

public class Disarium {

    public void Disarium(int nummer) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int copy = num;
        int d = 0;
        int sum = 0;
        String s = Integer.toString(num);
        int len = s.length();

        while (copy > 0) {
            d = copy % 10;
            sum = sum + (int) Math.pow(d, len);
            len--;
            copy = copy / 10;
        }

        if (sum == num)
            System.out.println("Disarium Number.");
        else
            System.out.println("Not a Disarium Number.");
    }
}

