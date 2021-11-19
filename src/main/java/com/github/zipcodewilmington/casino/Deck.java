package com.github.zipcodewilmington.casino;

import java.util.*;

//make stack?
public class Deck {
    LinkedList<Card> cards;
    public Deck() {
        this.cards = new LinkedList<>();
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                cards.push(new Card(rank, suit));
            }
        }
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }
    public Card getCard(){
        return cards.pop();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return this.getDeck().equals(((Deck) o).cards);
    }
    //wipes out the rest of the deck;
    public LinkedList<Card> getDeck(){
        //dunno if these two lines will work
        LinkedList<?> temp = (LinkedList<?>) this.cards.clone();
        this.cards.clear();
        return this.cards;
    }

}
