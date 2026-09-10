package Projects;

import java.util.Scanner;
// Invalid non-numeric input handling is pending and will be implemented after learning exception handling.
public class TicTacToe {
    public static void printBoard(char[] board){
        System.out.println(board[0] + " " + board[1] + " " + board[2]);
        System.out.println(board[3] + " " + board[4] + " " + board[5]);
        System.out.println(board[6] + " " + board[7] + " " + board[8]);
    }
    public static char checkWin(char[] board){
        if(board[0] == board[1] && board[1] == board[2]) return board[0];
        else if(board[3] == board[4] && board[4] == board[5]) return board[3];
        else if(board[6] == board[7] && board[7] == board[8]) return board[6];
        else if(board[0] == board[3] && board[3] == board[6]) return board[0];
        else if(board[1] == board[4] && board[4] == board[7]) return board[1];
        else if(board[2] == board[5] && board[5] == board[8]) return board[2];
        else if(board[0] == board[4] && board[4] == board[8]) return board[0];
        else if(board[2] == board[4] && board[4] == board[6]) return board[2];
        return '0';
    }
    public static boolean playNextMatch(Scanner scn){
        System.out.println("Wanna play again?(Yes/No)");
        String s = scn.nextLine().toLowerCase();
        return s.equals("yes");
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Welcome to 3x3 Tic-Tac-Toe:");

        char[] board = new char[9];
        // for(int i = 0; i < 9; i++) board[i] = (char)(i + 1 + '0');

        boolean playAgain = true;
        while(playAgain){
            for(int i = 0; i < 9; i++) board[i] = (char)(i + 1 + '0');
            TicTacToe.printBoard(board);
            int ctr = 1;
            boolean xTurn = true;
            while (ctr <= 9) {
                if (xTurn) System.out.print("Insert a position to write X: ");
                else System.out.print("Insert a position to write O: ");
                int idx = Integer.parseInt(scn.nextLine());
                if(idx > 9 || idx < 1){
                    System.out.println("Enter number from 1 to 9!!");
                    continue;
                }
                if(board[idx - 1] == 'o' || board[idx - 1] == 'x') {
                    System.out.println("The entered box is already filled!!");
                    continue;
                }
                if (xTurn) board[idx - 1] = 'x';
                else board[idx - 1] = 'o';

                System.out.println();
                char res = TicTacToe.checkWin(board);
                if (res != '0') {
                    System.out.println("Player " + res + " wins");
                    TicTacToe.printBoard(board);
                    playAgain = TicTacToe.playNextMatch(scn);
                    break;
                }
                TicTacToe.printBoard(board);
                xTurn = !xTurn;
                ctr++;
                if(ctr > 9) {
                    System.out.println("Its a draw");
                    playAgain = TicTacToe.playNextMatch(scn);
                }
            }
        }

        scn.close();
    }
}
