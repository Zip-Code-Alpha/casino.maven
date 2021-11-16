package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Card;
import com.github.zipcodewilmington.casino.Deck;
import com.github.zipcodewilmington.casino.Rank;
import com.github.zipcodewilmington.casino.Suit;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    //@Test
    /**
    public void testDeckConstructor(){
        //given
        Deck deck = new Deck();

    }
     */
    @Test
    public void testDeckConstructor(){
        //given / when
        Deck deck = new Deck();
        Card expected = new Card(Rank.ACE,Suit.CLUBS);
        //when
        for(int i = 0; i < 51; i++){
            deck.getCard();
        }
        Card actual = deck.getCard();
        //then
        Assert.assertEquals(actual,expected);


    }
    @Test
    public void testGetCard(){
        //given
        Deck deck = new Deck();
        Card expected = new Card(Rank.KING, Suit.DIAMONDS);
        //when
        Card actual = deck.getCard();
        //then
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void testShuffle(){
        //given
        Deck deck = new Deck();
        Deck deck2 = new Deck();
        //when
        deck.shuffle();
        deck2.shuffle();
        //then
        Assert.assertNotEquals(deck, deck2);
    }
}
