import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    	int a;
    	do {
    	    Scanner scanner = new Scanner(System.in);
    	    a = scanner.nextInt();
    	    if (a % 2 == 0) {
		        System.out.println("even");
	        } else {
		        System.out.println("odd");
	        }
        } while (a != 0);
    }
}