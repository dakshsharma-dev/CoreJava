package Projects;

import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args){
        // Math.random() returns a double value in the range: 0.0 <= Math.random() < 1.0

        Scanner scn = new Scanner(System.in);
        boolean play = true;

        while(play){
            int num = (int)(Math.random() * 100) + 1;

            System.out.print("You will get 5 attempts to guess a number between 1 and 100. Hit Enter to continue.");
            scn.nextLine();

            boolean correctGuess = false;

            for(int i = 1; i <= 5; i++){
                if(i == 1) System.out.print("Make a wish & enter a number from 1 to 100: ");

                int guess = Integer.parseInt(scn.nextLine());

                if(guess == num) {
                    correctGuess = true;
                    System.out.println("Congrats!!🎉, You got it in" + i + " attempts");
                    break;
                }
                else if(i == 5) break;
                else if(guess > num) System.out.print("You guessed more than expected! Try Again. ");
                else System.out.print("Make a bigger guess and Try Again. ");
            }

            if(!correctGuess){
                System.out.println();
                System.out.println("Attempts exhausted. Better luck next time☺️");
                System.out.println("Correct guess would be: " + num);
            }

            System.out.println("Play Again?");

            String playAgain = scn.nextLine();
            play = playAgain.equalsIgnoreCase("yes");
        }

        scn.close();

        /*
            FUTURE IMPROVEMENTS

            1. Input validation using exception handling.
            2. Validate user input range (1–100).
            3. Add difficulty levels (Easy/Medium/Hard).
            4. Track statistics:
               - Games played
               - Games won
               - Win percentage
            5. Refactor into methods to improve code organization.
            6. Use Random class instead of Math.random().
        */
    }
}
