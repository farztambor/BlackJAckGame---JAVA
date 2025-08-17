import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random.*;
import javax.swing.*;


public class BlackJack {

    ArrayList<Card> deck;

    BlackJack(){
        startGame();
    }

    //Starting the BlackJack game
    public void startGame(){
        //deck
        buildDeck();
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

}
