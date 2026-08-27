package Basics;

import java.util.Scanner;

//Scanner's handy methods to read the response:
//
//nextInt() for whole numbers
//nextLine() for full text lines
//nextDouble() for decimal numbers
//next() for single words

public class _02_TakingInput {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter teamSize: ");
        int teamSize = sc.nextInt();

        if(teamSize < 3 || teamSize > 6) {
            System.out.println("Error !! Team size can be 3 to 6 only.");
            return ;
        }

        sc.nextLine();
        System.out.println("Enter team Name: ");
        String teamName = sc.nextLine();

        System.out.println("Enter team leader name: ");
        String leaderName = sc.next();

        System.out.println("Registration Successful.");
        System.out.println("Team: " + teamName);
        System.out.println("Leader: " + leaderName);

        sc.close();
    }
}
