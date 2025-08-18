import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Random.*;
import javax.swing.*;


public class BlackJack {

    ArrayList<Card> deck; // deck list
    Random random = new Random(); //shuffling the deck

    //dealer -- needs to get >17 to draw a card
    Card hiddenCard; // for the dealer Card
    ArrayList<Card> dealerHand; // for list of card in hands
    int dealerSum; // tract the dealer sum
    int getDealerAceCount; // tract the ace to switch it to 1 or eleven value

    BlackJack(){
        startGame();
    }

    //Starting the BlackJack game
    public void startGame(){
        //deck
        buildDeck();
        shuffleDeck();

        //dealer
        dealerHand = new ArrayList<Card>();
        dealerSum =0;
        getDealerAceCount=0;


        assert deck != null; // check if the deck is not null
//        hiddenCard = deck.remove(deck.size()-1); // remove the last card
        hiddenCard = deck.removeLast(); // draw 1st card
        dealerSum += hiddenCard.getValue(); // get the hidden card value
        getDealerAceCount += hiddenCard.isAce() ? 1 : 0 ;

        Card card = deck.removeLast(); // draw 2nd card
        dealerSum +=card.getValue(); // get the value of the card
        getDealerAceCount += card.isAce() ? 1 : 0; // add 1 if Ace
        dealerHand.add(card); // add to dealers hand array

        System.out.println("Dealer");
        System.out.println(hiddenCard);
        System.out.println(dealerHand);
        System.out.println(dealerSum);
        System.out.println(getDealerAceCount);
    }

    // Creating the deck
    public void buildDeck(){
        //for List of Cards
        deck = new ArrayList<Card>();
        String[] values = {"A","2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q","K" };
        String[] types = {"C", "D", "H", "S"};

        // Assigning the types to the values
        for (String t : types){
            for(String v : values){
                Card card = new Card(t, v);
                deck.add(card);
            }
        }

        System.out.println("Build Deck: ");
        System.out.println(deck);

    }

    public void shuffleDeck(){
        for(Card d : deck){
            int position = 0; // to get the position with the array
            int j =random.nextInt(deck.size());
            Card randomCard = deck.get(j);
            deck.set(position,randomCard);
            deck.set(j, d);
            position++; // add 1 to position
        }

        System.out.println("After the shuffle");
        System.out.println(deck);
    }
}
