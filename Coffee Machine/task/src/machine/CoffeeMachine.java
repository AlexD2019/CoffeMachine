package machine;

import java.util.Scanner;
public class CoffeeMachine {
	private static int WATER = 400;
	private static int MILK = 540;
	private static int COFFEE_BEANS = 120;
	private static int CUPS = 9;
	private static int MONEY = 550;

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);

    	while (true) {
		    System.out.println("Write action (buy, fill, take, remaining, exit): ");
		    String input = scanner.next();

		    switch (input) {
			    case "buy":
				    buy();
				    break;
			    case "fill":
				    fill();
				    break;
			    case "take":
				    take();
				    break;
			    case "remaining":
			    	currentState();
			    	break;
			    case "exit":
			    	System.exit(0);
			    default:
				    System.out.println("Error!");
		    }
	    }
    }

    private static void currentState() {
	    System.out.println("The coffee machine has: ");
	    System.out.println(WATER + " of water");
	    System.out.println(MILK + " of milk");
	    System.out.println(COFFEE_BEANS + " of coffee beans");
	    System.out.println(CUPS + " of disposable cups");
	    System.out.println(MONEY + " of money");
    }

    private static void buy() {
		Scanner scanner = new Scanner(System.in);

	    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, " +
			    "3 - cappuccino, back - to main menu: ");
		String input = scanner.next();

		switch (input) {
			case "1":
				Espresso espresso = new Espresso();
				makeCoffee(espresso.water, 0, espresso.coffeeBeans, espresso.price);
				break;
			case "2":
				Latte latte = new Latte();
				makeCoffee(latte.water, latte.milk, latte.coffeeBeans, latte.price);
				break;
			case "3":
				Cappuccino cappuccino = new Cappuccino();
				makeCoffee(cappuccino.water, cappuccino.milk, cappuccino.coffeeBeans, cappuccino.price);
				break;
			case "back":
				break;
		}
    }

    private static void makeCoffee(int water, int milk, int coffeeBeans, int price) {
    	if (WATER >= water && MILK >= milk && COFFEE_BEANS >= coffeeBeans && CUPS > 0) {
		    System.out.println("I have enough resources, making you a coffee");

    		WATER -= water;
    		MILK -= milk;
    		COFFEE_BEANS -= coffeeBeans;
    		CUPS--;
    		MONEY += price;
	    } else if (WATER < water) {
		    System.out.println("Sorry, not enough water!");
	    }else if (MILK < milk) {
		    System.out.println("Sorry, not enough milk!");
	    }else if (COFFEE_BEANS < coffeeBeans) {
		    System.out.println("Sorry, not enough coffee beans!");
	    }else {
		    System.out.println("Sorry, not enough cups!");
	    }
    }

    private static void fill() {
    	Scanner scanner = new Scanner(System.in);
	    System.out.println("Write how many ml of water do you want to add: ");
		WATER += scanner.nextInt();
	    System.out.println("Write how many ml of milk do you want to add: ");
	    MILK += scanner.nextInt();
	    System.out.println("Write how many grams of coffee beans do you want to add: ");
	    COFFEE_BEANS += scanner.nextInt();
	    System.out.println("Write how many disposable cups of coffee do you want to add: ");
	    CUPS += scanner.nextInt();
    }

    private static void take() {
	    System.out.println("I gave you $" + MONEY);
	    MONEY = 0;
    }

    static class Espresso {
    	int water = 250;
    	int coffeeBeans = 16;
    	int price = 4;
    }

    static class Latte {
    	int water = 350;
    	int milk = 75;
    	int coffeeBeans = 20;
    	int price = 7;
    }

    static class Cappuccino {
    	int water = 200;
    	int milk = 100;
    	int coffeeBeans = 12;
    	int price = 6;
    }
}
//	private static int WATER_NEEDED_FOR_COFFEE = 200;
//	private static int MILK_NEEDED_FOR_COFFEE = 50;
//  private static int COFFEE_BEANS_NEEDED_FOR_COFFEE = 15;
//        Scanner scanner = new Scanner(System.in);
//        int water;
//        int milk;
//        int coffeeBeans;
//        int cups;
//
//        System.out.println("Write how many ml of water the coffee machine has: ");
//        water = scanner.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has: ");
//        milk = scanner.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
//        coffeeBeans = scanner.nextInt();
//        System.out.println("Write how many cups of coffee you will need: ");
//        cups = scanner.nextInt();
//
//        if (cups * WATER_NEEDED_FOR_COFFEE <= water
//                && cups * MILK_NEEDED_FOR_COFFEE <= milk
//                && cups * COFFEE_BEANS_NEEDED_FOR_COFFEE <= coffeeBeans) {
//            int[] array = {(water - cups * WATER_NEEDED_FOR_COFFEE) / WATER_NEEDED_FOR_COFFEE,
//                    (milk - cups * MILK_NEEDED_FOR_COFFEE) / MILK_NEEDED_FOR_COFFEE,
//                    (coffeeBeans - cups * COFFEE_BEANS_NEEDED_FOR_COFFEE) / COFFEE_BEANS_NEEDED_FOR_COFFEE};
//            Arrays.sort(array);
//            int additionalCups = array[0];
//            if (additionalCups != 0) {
//                System.out.println("Yes, I can make that amount of coffee (and even "
//                        + additionalCups + " more than that)");
//            } else {
//                System.out.println("Yes, I can make that amount of coffee");
//            }
//        } else {
//            int[] array = {water / WATER_NEEDED_FOR_COFFEE,
//                    milk / MILK_NEEDED_FOR_COFFEE,
//                    coffeeBeans / COFFEE_BEANS_NEEDED_FOR_COFFEE};
//            Arrays.sort(array);
//            System.out.println("No, I can make only " + array[0] + " cup(s) of coffee");
//        }
