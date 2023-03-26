import java.util.Scanner;

public class Main {
    private static final int COST_OF_BASKETBALL = 10;
    private static final int MAX_TRIES = 3;
    private static final int LEAP_YEAR_DIVISOR = 4;

    public static void main(String[] args) {
        displayUserGuide();
        String username = getUserName();
        String password = getPassword();
        User user = new User(username, password);
        Calculator calculator = new Calculator();

        System.out.println("\nWelcome to the Penguin Game, " + user.getUsername() + "!");
        System.out.println("You are a green penguin and you want to play basketball with the seals.");
        System.out.println("Unfortunately, you don't have a basketball, and you need to buy one from the local store.");

        int numTries = 0;
        boolean hasBasketball = false;
        while (numTries < MAX_TRIES && !hasBasketball) {
            int money = user.getMoney();
            System.out.println("You have " + money + " fish.");
            System.out.println("A basketball costs " + COST_OF_BASKETBALL + " fish.");
            System.out.print("Do you want to buy a basketball? (y/n): ");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase().trim();
            if (input.equals("y")) {
                if (money >= COST_OF_BASKETBALL) {
                    user.setMoney(money - COST_OF_BASKETBALL);
                    hasBasketball = true;
                    System.out.println("You bought a basketball! Now you can play with the seals!");
                } else {
                    System.out.println("You don't have enough money to buy a basketball.");
                }
            } else {
                System.out.println("You decided not to buy a basketball.");
            }
            numTries++;
        }

        if (!hasBasketball) {
            System.out.println("You couldn't buy a basketball after " + MAX_TRIES + " tries. Game over.");
            return;
        }

        System.out.println("\nYou are now playing basketball with the seals!");
        System.out.println("Let's calculate the score!");
        int numPoints = 0;
        while (numPoints < 8) {
            System.out.println("Enter 'add', 'subtract', 'multiply', or 'divide' to perform a calculation, or 'score' to see your score:");
            String input = getInput().toLowerCase().trim();
            if (input.equals("add") || input.equals("subtract") || input.equals("multiply") || input.equals("divide")) {
                int num1 = (int) (Math.random() * 10) + 1;
                int num2 = (int) (Math.random() * 10) + 1;
                int result = calculator.calculate(input, num1, num2);
                System.out.println("What is " + num1 + " " + input + " " + num2 + "?");
                int answer = getNumberInput();
                if (answer == result) {
                    System.out.println("Correct! You earned one point!");
                    numPoints++;
                } else {
                    System.out.println("Incorrect. The correct answer was " + result + ".");
                }
            } else if (input.equals("score")) {
                System.out.println("Your score is " + numPoints + ".");
            } else {
                System.out.println("Invalid operation. Please enter 'add', 'subtract', 'multiply', 'divide', or 'score'.");
            }
        }

        System.out.println("You won the game! Congratulations!");
    }

    private static void displayUserGuide() {
    	System.out.println("Welcome to the Penguin Game!");
    	System.out.println("In this game, you are a green penguin who wants to play basketball with the seals.");
    	System.out.println("You need to buy a basketball from the local store before you can play with the seals.");
    	System.out.println("You have three tries to buy the basketball, and each try costs 10 fish.");
    	System.out.println("Once you have the basketball, you can play with the seals by answering math questions.");
    	System.out.println("You will be asked to perform a calculation, such as addition or subtraction.");
    	System.out.println("You will be given two random numbers to use in the calculation.");
    	System.out.println("If you answer correctly, you will earn one point.");
    	System.out.println("You need to earn 8 points to win the game and receive a congratulations message.");
    	System.out.println("You can check your score at any time by typing 'score' instead of a calculation.");
    	System.out.println("Have fun!");
    	}
    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your username: ");
        return scanner.nextLine().trim();
    }

    private static String getPassword() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your password: ");
        return scanner.nextLine().trim();
    }

    private static int getNumberInput() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter a number: ");
            try {
                int num = Integer.parseInt(scanner.nextLine().trim());
                return num;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    private static boolean isLeapYear(int year) {
        if (year % LEAP_YEAR_DIVISOR == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }
}
