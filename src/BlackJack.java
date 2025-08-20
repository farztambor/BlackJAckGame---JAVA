import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.Random.*;
import javax.swing.*;
import javax.swing.border.Border;


public class BlackJack {

    ArrayList<Card> deck; // deck list
    Random random = new Random(); //shuffling the deck

    //dealer -- needs to get >17 to draw a card
    Card hiddenCard; // for the dealer Card
    ArrayList<Card> dealerHand; // for list of card in hands
    int dealerSum; // tract the dealer sum
    int getDealerAceCount; // tract the ace to switch it to 1 or eleven value

    // Player
    ArrayList<Card> playerHand;
    int playerSum;
    int playerAceCount;

    //window
    int boardWith =600;
    int bordHeight= boardWith;

    //Size of the cards in the panel
    int cardWidth=110; // ration should 1/1.4
    int cardHeight=154;


    JFrame frame = new JFrame("Black Jack"); // the window
    JPanel gamePanel = new JPanel(){
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            try{
                //draw hidden Card
                //Image hiddenCardImg = new ImageIcon(getClass().getResource("./cards/BACK.png")).getImage();
                Image hiddenCardImg = new ImageIcon(Objects.requireNonNull(getClass().getResource("./cards/BACK.png"))).getImage();
                g.drawImage(hiddenCardImg, 20, 20 , cardWidth, cardHeight,null);
                //draw dealers hand
                for (int i=0; i<dealerHand.size(); i++) {
                    Card card = dealerHand.get(i);
                    Image cardImage = new ImageIcon(Objects.requireNonNull(getClass().getResource(card.getImagePath()))).getImage();
                    g.drawImage(cardImage, cardWidth + 25 + (cardWidth+ 5)*i,20, cardWidth , cardHeight,null);
                }
                //draw players card
                for(int i=0; i<playerHand.size(); i++){
                    Card card = playerHand.get(i);
                    Image cardImage = new ImageIcon(Objects.requireNonNull(getClass().getResource(card.getImagePath()))).getImage();
                    g.drawImage(cardImage, 20 + (cardWidth+ 5)*i,320, cardWidth , cardHeight,null);
                }

            } catch (Exception e ){
                e.printStackTrace();
            }
        }
    };
    JPanel buttonPanel = new JPanel();
    JButton hitButton = new JButton("Hit");
    JButton stayButton = new JButton("Stay");


    BlackJack(){
        startGame();

        //Window or Frame
        frame.setVisible(true);
        frame.setSize(boardWith,bordHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Background Panel
        gamePanel.setLayout(new BorderLayout());
        gamePanel.setBackground(new Color(53,101,77));
        frame.add(gamePanel);

        //Button Panel
        hitButton.setFocusable(false);
        buttonPanel.add(hitButton);
        stayButton.setFocusable(false);
        buttonPanel.add(stayButton);
       // frame.add(buttonPanel);
        // Specify border layout so that it will appear at the bottom
        frame.add(buttonPanel, BorderLayout.SOUTH);

        hitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    Card card = deck.removeLast();
                    playerSum += card.getValue();
                    playerAceCount += card.isAce() ? 1:0;
                    playerHand.add(card);
                    gamePanel.repaint(); // render again the image
                }
            });
        gamePanel.repaint(); //  render again the image

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

        //Player
        playerHand = new ArrayList<Card>();
        playerSum = 0;
        playerAceCount=0;

        //loop 2 for player cards
        for (int i=0; i<2 ; i++){
            card = deck.removeLast();
            playerSum += card.getValue();
            playerAceCount += card.isAce() ? 1 : 0;
            playerHand.add(card);
        }
        System.out.println("Player");
        System.out.println(playerHand);
        System.out.println(playerSum);
        System.out.println(playerAceCount);

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
