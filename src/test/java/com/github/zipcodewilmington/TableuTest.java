package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TableuTest {
    private Tableu tableu = new Tableu(new Deck());
    @Test
    public void initTest(){
        //creates a proper tableu with everything in it
        Assertions.assertEquals(new Card(Rank.KING, Suit.DIAMONDS),tableu.peekTopCard(0));
        Assertions.assertEquals(new Card(Rank.QUEEN, Suit.CLUBS),tableu.peekTopCard(1));
        Assertions.assertEquals(new Card(Rank.TEN, Suit.HEARTS),tableu.peekTopCard(2));
        Assertions.assertEquals(new Card(Rank.NINE, Suit.SPADES),tableu.peekTopCard(3));
        Assertions.assertEquals(new Card(Rank.EIGHT, Suit.SPADES),tableu.peekTopCard(4));
        Assertions.assertEquals(new Card(Rank.SEVEN, Suit.HEARTS),tableu.peekTopCard(5));
        Assertions.assertEquals(new Card(Rank.SEVEN, Suit.CLUBS),tableu.peekTopCard(6));

    }
    @Test
    public void drawCardTest(){
        //when a TableuFaceUp is a depleted a TableuFaceDown auto donates a card to the FaceUp
    }
    @Test
    public void correctSequencingTest(){
        //does a valid sequence work
    }
    @Test
    public void outOfRankOrderSequencingTest(){
        //does an out of order rank sequence return an error
    }
    @Test
    public void nonOscillatingSequencingTest(){
        //does an in-order but non-oscillating sequence return an error
    }
    @Test
    public void faceUpToBlank(){
        //does a single FaceUp card properly transition to a blank space
    }
    @Test
    public void kingOnBlankTest(){
        //is a King on a blank tableu rightfully valid
    }
    @Test
    public void otherCardOnBlankTest(){
        //does any other card on blank tableu rightfully return an error
    }

}
