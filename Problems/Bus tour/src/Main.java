import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	int height = scanner.nextInt();
    	int numberOfBridges = scanner.nextInt();
    	boolean flag = false;

    	for (int i = 0; i < numberOfBridges; i++) {
    		int bridgeHeight = scanner.nextInt();
    		if (bridgeHeight <= height) {
			    System.out.println("Will crash on bridge " + (i + 1));
			    flag = true;
			    break;
		    }
	    }

    	if (!flag) {
		    System.out.println("Will not crash");
	    }
    }
}