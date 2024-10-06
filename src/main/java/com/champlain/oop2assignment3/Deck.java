package com.champlain.oop2assignment3;

import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Represents a deck of playing cards.
 * <p>
 * This class allows for creating a standard deck, shuffling it, drawing cards,
 * and checking if the deck is empty.
 * </p>
 */
public class Deck extends CardCollection implements CardSource {
    /**
     * The list of cards in the deck.
     */
    private final List<Card> aCards = new ArrayList<>();

    /**
     * Constructs a new Deck containing all standard playing cards.
     * The deck is initialized with one of each rank and suit combination.
     */
    public Deck() {
        for (Rank currentRank : Rank.values()) {
            for (Suit currentSuit : Suit.values()) {
                this.aCards.add(new Card(currentRank, currentSuit));
            }
        }
    }

    /**
     * Shuffles the cards in this deck randomly.
     */
    public void shuffle() {
        Collections.shuffle(this.aCards);
    }

    public void sort(SortOption option) {
        if (this.aCards.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("No Cards in Deck");
            alert.showAndWait();
        } else {
            switch (option) {
                case SUIT_FIRST:
                    // Sort by suit first
                    Collections.sort(this.aCards, Card::compareBySuitFirst);
                    break;
                case RANK_FIRST:
                default:
                    // Sort by rank first (default)
                    Collections.sort(this.aCards);
                    break;
            }
        }
    }


    public Card draw() {
        int last = this.aCards.size()-1;
        Card myCard = this.aCards.get(last);
        this.aCards.remove(last);
        return myCard;
    }

    public boolean isEmpty() {
        return this.aCards.isEmpty();
    }

    /**
     * Returns an iterator over the cards in this deck.
     *
     * @return an iterator for the cardszzzzzs
     */
    public Iterator<Card> iterator() {
        return this.aCards.iterator();
    }

}
