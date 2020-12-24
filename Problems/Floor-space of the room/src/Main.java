import java.util.Scanner;

class Main {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
    	String input = scanner.next();

    	switch (input) {
		    case "triangle":
		    	double a = scanner.nextDouble();
		    	double b = scanner.nextDouble();
		    	double c = scanner.nextDouble();
		    	double halfPerimeter = 0.5 * (a + b + c);

			    System.out.println(Math.sqrt(halfPerimeter * (halfPerimeter - a) * (halfPerimeter - b) * (halfPerimeter - c)));
			    break;
		    case "rectangle":
		    	a = scanner.nextDouble();
		    	b = scanner.nextDouble();

			    System.out.println(a * b);
			    break;
		    case "circle":
		    	double r = scanner.nextDouble();

			    System.out.println(3.14 * Math.pow(r, 2));
			    break;
		    default:
			    System.out.println("Error!");
	    }
    }
}