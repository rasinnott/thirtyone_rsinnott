package edu.guilford;

import java.util.LinkedList;

/**
 * This class extends the LinkedList class (which implements Queue for FIFO behavior). 
 * It represents the stockpile of of cards that the players draw from. 
 */
public class Stockpile extends LinkedList<Card> {


    /**
     * A contructor to build the Stockpile from a Deck.
     * @param deck The Deck to build the Stockpile from.
     */
    public Stockpile(Deck deck) {
        while (deck.size() > 0) {
            this.add(deck.deal());
        }
    }

    /**
     * Draws a card from the top of the stockpile.
     * @return The card drawn from the stockpile.
     */
    public Card draw() {
        return this.poll();
    }

    /**
     * toString method to return a string representation of the stockpile.
     * @return A string representation of the stockpile.
     */
    @Override
    public String toString() {
        String stockpileString = "";
        for (Card card : this) {
            stockpileString += card.toString() + "\n";
        }
        return stockpileString;
    }

}
