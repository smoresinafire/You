import java.util.Random;
import java.util.Scanner;

public class WAR_starter {
    public static void main(String[] args){
        Scanner myObj = new Scanner(System.in);
        String userName;
        
        System.out.println("Enter Username");
        userName = myObj.nextLine();
        System.out.println("hi "+userName);
        // Generation of 2 random cards (1-52)
        Random rand = new Random();
        int computerCARD = rand.nextInt(52);
        int userCARD = rand.nextInt(52); 
        if(computerCARD == 0){
            computerCARD += 1;
        }
        if(userCARD == 0){
            userCARD += 1;
        }

        //My Code
        int playerCardsLeft = 26;
        int ComputersCardsLeft = 26;
        char suitForComputer;
        int cardNumberForComputer;
        if (computerCARD <= 13) {
            suitForComputer = 'C';
            ComputersCardsLeft --;
        } else if (computerCARD >= 14 && computerCARD <= 26) {
            suitForComputer = 'D';
            ComputersCardsLeft --;
        } else if (computerCARD >= 26 && computerCARD <= 39) {
            suitForComputer = 'H';
            ComputersCardsLeft --;
        } else {
            suitForComputer = 'S';
            ComputersCardsLeft --;
        }
        char suitForPlayer;
        int cardNumberForPlayer;
        if (userCARD <= 13) {
            suitForPlayer = 'C';
        } else if (userCARD >= 14 && userCARD <= 26) {
            suitForPlayer = 'D';
        } else if (userCARD >= 26 && userCARD <= 39) {
            suitForPlayer = 'H';
        } else {
            suitForPlayer = 'S';
        }
        cardNumberForComputer = computerCARD % 13;
        cardNumberForPlayer = userCARD % 13;

        //dont delete this :)
        printAsciiEval("" + suitForComputer + cardNumberForComputer, "" + suitForPlayer + cardNumberForPlayer);

        if (cardNumberForComputer == cardNumberForPlayer){
            System.out.println("WAR!!!");
        }else if (cardNumberForPlayer == 1) {
            System.out.println("You Win");
        }else if (cardNumberForComputer == 1) {
            System.out.println("You lose");
        }else if (cardNumberForComputer > cardNumberForPlayer) {
            System.out.println("You lose");
        }else if (cardNumberForPlayer > cardNumberForComputer) {
            System.out.println("You win");
        }
        
        System.out.println(playerCardsLeft);
        System.out.println(ComputersCardsLeft);

        // Final send of 2 cards value (suit + value) to be outputted as ASCII cards
      
    }
    public static void printAsciiEval(String computerCard, String userCard) {

        if(computerCard.length() == 2){
            printAscii_2Char_card(computerCard);
        }else {
            printAscii_3Char_card(computerCard);
        }

        System.out.println("------------");
        System.out.println("--COMPUTER--");
        System.out.println("------------");
        System.out.println("-----VS-----");
        System.out.println("------------");
        System.out.println("----USER----");
        System.out.println("------------");

        if(userCard.length() == 2){
            printAscii_2Char_card(userCard);
        }else {
            printAscii_3Char_card(userCard);
        }
    }

    public static void printAscii_2Char_card(String card){
        // Top of the computer card
        System.out.println("┌─────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│         │");
        System.out.println("│         │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│         │");
        System.out.println("│         │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└─────────┘");
    }

    public static void printAscii_3Char_card(String card){
        // Top of the computer card
        System.out.println("┌──────────┐");
        // Upper part of the card with the character
        System.out.println("│" + card + "       │"); // top-left corner of the card
        System.out.println("│          │");
        System.out.println("│          │");
        System.out.println("│    " + card + "   │"); // middle of the card
        System.out.println("│          │");
        System.out.println("│          │");
        // Bottom part of the card with the character mirrored
        System.out.println("│       " + card + "│"); // bottom-right corner of the card
        // Bottom of the card
        System.out.println("└──────────┘");
    }
}
