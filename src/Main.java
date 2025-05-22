import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Password pass = new Password();

        // Variables
        String cifrated = "";
        String generatedPass;
        int choice;

        do {
            System.out.println("\n>>> Password Generator App <<<");
            System.out.println("1 >> Generate Password");
            System.out.println("2 >> Check Password Strength");
            System.out.println("3 >> Exit");
            System.out.print("Choose any option -> ");
            choice = read.nextInt();
            read.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n>>> Password Generator <<<");
                    System.out.print("Enter length of your password -> ");
                    int size = read.nextInt();
                    read.nextLine();
                    System.out.print("Do you want to include UpperCase Letters (y/n) -> ");
                    char upperCaseIncluded = read.next().toLowerCase().charAt(0);
                    System.out.print("Do you want to include special Symbols? (y/n) -> ");
                    char symbolsIncluded = read.next().toLowerCase().charAt(0);

                    generatedPass = pass.generate(size, upperCaseIncluded, symbolsIncluded);
                    System.out.println("Password Created! -> " + generatedPass);
                    break;
                case 2:
                    System.out.println("\n>>> Password Strength Checker <<<");
                    System.out.println("Type your password:");
                    System.out.print(">>> ");
                    String password = read.next();
                    pass.strength(password);
                    break;
                case 3:
                    System.out.println(">>> Exiting...");
                    break;
                default:
                    System.out.println("You typed an invalid choice. Try Again!");
                    break;
            }
        } while (choice !=3 );
    }
}