package com.github.zipcodewilmington;

import org.junit.jupiter.api.Test;

public class TableuTest {
    @Test
    public void initTest(){
        //creates a proper tableu with everything in it
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
