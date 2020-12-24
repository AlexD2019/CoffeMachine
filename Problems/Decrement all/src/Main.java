import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            int a = scanner.nextInt();
            System.out.print(--a + " ");
        }
    }
}