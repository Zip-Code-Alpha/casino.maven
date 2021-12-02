package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.solitaire.*;
import com.github.zipcodewilmington.utils.Node;
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
        tableu.getStack(1).emmigrateSequence(new Node<Card>(new Card(Rank.QUEEN, Suit.CLUBS),null));
        tableu.getStack(1).immigrateSequence(new Node<Card>(new Card(Rank.KING,Suit.DIAMONDS),new Node<>(new Card(Rank.QUEEN,Suit.CLUBS),null)));
        tableu.getStack(0).emmigrateSequence(new Node<Card>(tableu.peekTopCard(0),null));
        System.out.println(tableu.peekTopCard(0) + "empty");
        System.out.println(tableu.peekTopCard(1) + "has stuff");
        if(tableu.putCardsInTableu(0, tableu.peekCardsFromTableu(1,0))){
            tableu.removeCardsFromTableu(1,tableu.peekCardsFromTableu(1,0));
        }
        System.out.println(tableu.peekTopCard(0)); //should have thing
        System.out.println(tableu.peekTopCard(1));
    }
    @Test
    public void correctSequencingTest(){
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
