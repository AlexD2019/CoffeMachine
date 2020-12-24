import java.util.Scanner;

public class Main {

    public static long factorial(long n) {
    	if (n == 0) return 1;

    	long factorial = 1;

    	for (long i = 1; i <= n; i += 1) {
			factorial *= i;
	    }

    	return factorial;
    }

    /* Do not change code below */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = Integer.parseInt(scanner.nextLine().trim());
        System.out.println(factorial(n));
    }
}