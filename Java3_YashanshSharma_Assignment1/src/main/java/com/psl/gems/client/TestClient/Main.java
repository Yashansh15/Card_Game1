package com.psl.gems.client.TestClient;
import java.util.*;
import java.io.FileWriter;
import java.io.IOException;


class Card {
    private String suit;
    private String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }
    public String getsuit()
    {
    	return this.suit;
    }
    public String getrank()
    {
    	return this.rank;
    }
    public int getValue() {
        int suitWeight = 0;
        switch(suit) {
            case "CLUB":
                suitWeight = 0;
                break;
            case "DIAMOND":
                suitWeight = 1;
                break;
            case "HEART":
                suitWeight = 2;
                break;
            case "SPADE":
                suitWeight = 3;
                break;
        }

        int rankWeight = 0;
        switch(rank) {
            case "TWO":
                rankWeight = 0;
                break;
            case "THREE":
                rankWeight = 1;
                break;
            case "FOUR":
                rankWeight = 2;
                break;
            case "FIVE":
                rankWeight = 3;
                break;
            case "SIX":
                rankWeight = 4;
                break;
            case "SEVEN":
                rankWeight = 5;
                break;
            case "EIGHT":
                rankWeight = 6;
                break;
            case "NINE":
                rankWeight = 7;
                break;
            case "TEN":
                rankWeight = 8;
                break;
            case "JACK":
                rankWeight = 9;
                break;
            case "QUEEN":
                rankWeight = 10;
                break;
            case "KING":
                rankWeight = 11;
                break;
            case "ACE":
                rankWeight = 12;
                break;
        }
        return rankWeight * 4 + suitWeight;
    }
}
class Pack {
	    private ArrayList<Card> cards;

	    public void Deck() {
	        cards = new ArrayList<>();
	        String[] suits = {"CLUB", "DIAMOND", "HEART", "SPADE"};
	        String[] ranks = {"TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING", "ACE"};
	        for (String suit : suits) {
	            for (String rank : ranks) {
	                cards.add(new Card(suit, rank));
	            }
	        }
	       System.out.println(cards);
	    }
	    public void shuffle() {
	        Collections.shuffle(cards);
	    }
	    public List<Card> deal(int numCards) {
	        List<Card> hand = new ArrayList<Card>();
	        for (int i = 0; i < numCards; i++) {
	        	 int randomIndex = (int)(Math.random() * cards.size());
	 	        Card randomCard = cards.get(randomIndex);
	 	        cards.remove(randomIndex);
	            hand.add(randomCard);
	            System.out.println(randomCard.getsuit() +" "+randomCard.getrank());
	        } 
	        return hand;
	    }
 }
class Player
{
	 private String name;
	    private List<Card> hand;

	    public Player(String name) {
	        this.name = name;
	        hand = new ArrayList<Card>();
	    }

	    public String getName() {
	        return name;
	    }

	    public List<Card> getHand() {
	        return hand;
	    }

	    public void addCard(Card card) {
	        hand.add(card);
	    }

	    public Card getHighestCard() {
	        Card highestCard = hand.get(0);
	        for (int i = 1; i < hand.size(); i++) {
	            Card card = hand.get(i);
	            if (card.getValue() > highestCard.getValue()) {
	                highestCard = card;
	            }
	        }
	        return highestCard;
	    }
	 
}
class game
{
	    private Pack pack;
	    private List<Player> players;
        private List<String> str =new ArrayList();
	         public void Game() {
	        pack = new Pack();
	        pack.Deck();
	        pack.shuffle();
	        players = new ArrayList<Player>();
	    }
	         public List<String> getdata() {
	 	        return str;
	 	    }
	    public void register(Player player) {
	        players.add(player);
	    }
	    public void play() {
	        List<Card> cards = pack.deal(6);
	        System.out.println();
	        for (int i = 0; i < 6; i +=2) {
	            players.get(0).addCard(cards.get(i));
	            players.get(1).addCard(cards.get(i + 1));
	            System.out.println(cards.get(i).getsuit() +" "+cards.get(i).getrank());
	            String x=cards.get(i).getsuit()+cards.get(i).getrank();
	            String y=cards.get(i+1).getsuit()+cards.get(i+1).getrank();
	            str.add(x);
	            str.add(y);
	        }
	        Player player1 = players.get(0);
	        Player player2 = players.get(1);
	        Card player1HighestCard = player1.getHighestCard();
	        Card player2HighestCard = player2.getHighestCard();
	        System.out.println();
	        System.out.println(player1HighestCard.getsuit() +" "+player1HighestCard.getrank());
	        System.out.println(player2HighestCard.getsuit() +" "+player2HighestCard.getrank());
	        str.add(player1HighestCard.getsuit()+player1HighestCard.getrank());
	        str.add(player2HighestCard.getsuit()+player2HighestCard.getrank());
	        str.add(String.valueOf(player1HighestCard.getValue()));
	        str.add(String.valueOf(player2HighestCard.getValue()));
	        if (player1HighestCard.getValue() > player2HighestCard.getValue()) {
	            System.out.println(player1.getName() + " wins!");
	            str.add(player1.getName());
	            str.add(String.valueOf(player1HighestCard.getValue()));
	        } else if (player2HighestCard.getValue() > player1HighestCard.getValue()) {
	            System.out.println(player2.getName() + " wins!");
	            str.add(player2.getName());
	            str.add(String.valueOf(player2HighestCard.getValue()));
	        } 
	    }
	    
}
class htmladd
{
	
	    public void addhtml( List<String> s) 
	    {
	        String fileName = "pages/cardgame.html";
	        String htmlCode = "<!DOCTYPE html>\r\n"
	        		+ "<html lang=\"en\">\r\n"
	        		+ "\r\n"
	        		+ "<head>\r\n"
	        		+ "    <meta charset=\"UTF-8\">\r\n"
	        		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
	        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
	        		+ "    <title>Document</title>\r\n"
	        		+ "    <link rel=\"stylesheet\" href=\"index.css\" />\r\n"
	        		+ "</head>\r\n"
	        		+ "\r\n"
	        		+ "<body>\r\n"
	        		+ "    <div>\r\n"
	        		+ "        <marquee id=\"first\" direction=\"right\" behavior=\"alternate\">\r\n"
	        		+ "            <h3>Game Of Cards</h3>\r\n"
	        		+ "        </marquee>\r\n"
	        		+ "    </div>\r\n"
	        		+ "    <div class=\"grid-container-element\">\r\n"
	        		+ "        <div class=\"grid-child-element purple\">\r\n"
	        		+ "            <div> Player 1</div>\r\n"
	        		+ "            <br><br>\r\n"
	        		+ "            <div class=\"flex\">\r\n"
	        		+ "                <div class=\"i\">\r\n"
	        		+ "                    <img class=\"ii1\" id=\"img\" name="
	        		+ s.get(0)+".png"
	        		+ " src=\"img/i.png\" onclick=\"cimage1(this)\">\r\n"
	        		+ "                </div>\r\n"
	        		+ "                <div class=\"i\">\r\n"
	        		+ "                    <img class=\"ii1\" name="
	        		+ s.get(2)+".png"
	        		+ " src=\"img/i.png\" onclick=\"cimage1(this)\">\r\n"
	        		+ "                </div>\r\n"
	        		+ "                <div class=\"i\">\r\n"
	        		+ "                    <img class=\"ii1\" name="
	        		+ s.get(4)+".png"
	        		+ " src=\"img/i.png\" onclick=\"cimage1(this)\">\r\n"
	        		+ "                </div>\r\n"
	        		+ "            </div>\r\n"
	        		+ "           <br> <button id=\"g\" onclick=\"disphigh1()\" disabled>Show Highest Card</button>\r\n"
	        		+ "            <br>\r\n"
	        		+ "            <div id=\"score1\" name="
	        		+s.get(8)
	        		+ " > Highest Card</div>\r\n"
	        		+ "            <br>\r\n"
	        		+ "            <div id=\"hig1\" name="
	        		+ s.get(6)+".png"
	        		+ " > </div>\r\n"
	        		+ "        </div>\r\n"
	        		+ "        <div class=\"grid-child-element green\">\r\n"
	        		+ "           <div> Player 2</div><br><br>\r\n"
	        		+ "            <div class=\"flex\">\r\n"
	        		+ "                <div class=\"i\">\r\n"
	        		+ "                    <img class=\"ii2\" name="
	        		+ s.get(1)+".png"
	        		+ " src=\"img/i.png\" onclick=\"cimage2(this)\">\r\n"
	        		+ "                </div>\r\n"
	        		+ "                <div class=\"i\">\r\n"
	        		+ "                    <img class=\"ii2\" name="
	        		+ s.get(3)+".png"
	        		+ " src=\"img/i.png\" onclick=\"cimage2(this)\">\r\n"
	        		+ "                </div>\r\n"
	        		+ "                <div class=\"i\">\r\n"
	        		+ "                    <img class=\"ii2\" name="
	        		+ s.get(5)+".png"
	        		+ " src=\"img/i.png\" onclick=\"cimage2(this)\">\r\n"
	        		+ "                </div>\r\n"
	        		+ "            </div>\r\n"
	        		+ "\r\n"
	        		+ "            <br><button id=\"gg\" onclick=\"disphigh2()\" disabled>Show Highest Card</button>\r\n"
	        		+ "            <br>\r\n"
	        		+ "            <div id=\"score2\" name="
	        		+s.get(9)
	        		+ " > Highest Card</div>\r\n"
	        		+ "            <br>\r\n"
	        		+ "            <div id=\"hig2\" name="
	        		+ s.get(7)+".png"
	        		+ " ></div>\r\n"
	        		+ "        </div>\r\n"
	        		+ "        <div id=\"last\">\r\n"
	        		+ "            <button id=\"win\" onclick=\"winner()\" disabled>Declare Winner</button>\r\n"
	        		+ "        </div><br>\r\n"
	        		+ "    </div>\r\n"
	        		+ "     <br>   <div id=\"winner1\" name="
	        		+s.get(10)
	        		+ " value="
	        		+s.get(11)
	        		+ " ></div>\r\n"
	        		+ "</body>\r\n"
	        		+ "<script src=\"my.js\"></script>\r\n"
	        		+ "\r\n"
	        		+ "</html>";
	        try {
	            FileWriter writer = new FileWriter(fileName);
	            writer.write(htmlCode);
	            writer.close();
	            System.out.println("File created successfully.");
	        } catch (IOException e) {
	            System.out.println("An error occurred while creating the file.");
	            e.printStackTrace();
	        }
	    }
	
}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Player p1 = new Player("Player_1");
		 Player p2 = new Player("Player_2");
		 game g=new game();
		   g.Game();
	     	g.register(p1);
		   g.register(p2);
		Pack p=new Pack();
		// p.Deck();
	   //  p.shuffle();
		 g.play();
		 List<String> s=g.getdata();
		 
		 htmladd h=new htmladd();
		 h.addhtml(s);
	}

}
