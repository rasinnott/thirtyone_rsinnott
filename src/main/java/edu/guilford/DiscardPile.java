package edu.guilford;

import java.util.Stack;

/**
 * This class extends the Stack class (which implements Queue for FIFO behavior). 
 * It represents the pile of cards where the players discard cards at the end of a turn.
 */
public class DiscardPile extends Stack<Card> {
    
    /**
     * A constructor that takes a Card as an argument and adds it to the top of the DiscardPile.
     * The Card will be drawn from the Stockpile by the Game class at the begining of each round.
     * 
     * @param card The Card to be added to the DiscardPile.
     */
    public DiscardPile(Card card) {
        this.push(card);
    }

    /**
     * Draws a card from the top of the DiscardPile.
     * @return The card drawn from the DiscardPile.
     */
    public Card draw() {
        return this.pop();
    }

    /**
     * toString method to return a string representation of the DiscardPile.
     * @return A string representation of the DiscardPile.
     */
    @Override
    public String toString() {
        String discardPileString = "";
        for (Card card : this) {
            discardPileString += card.toString() + "\n";
        }
        return discardPileString;
    }

}
