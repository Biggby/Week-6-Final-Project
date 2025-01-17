package finalProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

	private int value;
	private String name;
	
	public Card(int value, String name) {
		this.setName(name);
		this.setValue(value);
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void describe() {
		System.out.println("Card Played:" + name);
	}
	
}

class Deck {
	private List<Card> cards;
	
	public Deck() {
		cards = new ArrayList<>();
		
		String[] suits = {"Spades", "Hearts", "Clubs", "Diamond"};
		String[] faces = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};

		
		for (String suit : suits) {
            for (int i = 0; i < faces.length; i++) {
                // Set proper value (Ace = 14, Jack = 11, Queen = 12, King = 13)
                int value;
                if (faces[i].equals("A")) {
                    value = 14;
                } else if (faces[i].equals("J")) {
                    value = 11;
                } else if (faces[i].equals("Q")) {
                    value = 12;
                } else if (faces[i].equals("K")) {
                    value = 13;
                } else {
                    value = Integer.parseInt(faces[i]);
                }
                
                cards.add(new Card(value, faces[i] + " of " + suit));
            }
        }
		
		for(int i = 0; i < faces.length; i++) {
			int cardValue = faces[i].equals("A") ? 14 : (i + 1);
            String cardName = faces[i] + " of " + suits;
			cards.add(new Card(cardValue, cardName));
		
		}
	}




	public void shuffle() {
	    Collections.shuffle(cards);
	}
	
	public Card draw() {
		if(cards.isEmpty()) {
			return null;
		}
		return cards.remove(0);
	}
}

class Player {
	private int score; // start of the score which stays private
	private String name; // player name
	private List<Card> hand;
	
	public Player(String name) {
		this.hand = new ArrayList<>();
		this.name = name;
		this.score = 0;
		
	}
	
	public void describe() {
		System.out.println(name + "' Hand: ");
		for(Card card : hand) {
			card.describe();
		}
		System.out.println("Score: " + score);
	}

	public Card flip() {
		if (hand.isEmpty()) {
			return null;
		}
		return hand.remove(0);
	}
	
	public void draw(Deck deck) {
	    Card card = deck.draw();
	    if (card != null) {
	        hand.add(card);
	    }
	}
	
	public void incrementScore() {
	    score++;
	}
	
	public int getScore() {
	    return score;
	}
	
	public String getName() {
	    return name;
	}
}



















