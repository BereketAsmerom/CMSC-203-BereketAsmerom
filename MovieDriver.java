
import java.util.Scanner;

public class MovieDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String userChoice;

        do {
            Movie movie = new Movie();

            System.out.print("Please enter the movie title: ");
            movie.setTitle(input.nextLine());

            System.out.print("Please enter the movie rating: ");
            movie.setRating(input.nextLine());

            System.out.print("Please enter the number of tickets sold: ");
            while (!input.hasNextInt()) {
                System.out.print("Invalid input. Please enter a valid number: ");
                input.next();
            }
            movie.setSoldTickets(input.nextInt());
            input.nextLine();

            System.out.println("\nMovie Details:");
            System.out.println(movie.toString());

            System.out.print("\nWould you like to enter another movie? (yes/no): ");
            userChoice = input.nextLine().trim().toLowerCase();

        } while (userChoice.equals("yes"));

        System.out.println("\nThank you for using the Movie Driver program!");
        input.close();
    }
}
