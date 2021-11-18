package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tableu {
    //unblocked cards vs blockedcards
    //what data structure should i use to represent the septet  stacks
    //

    private final int NUMBER_OF_THINGS_IN_A_SEPTET = 7;
    private TableuStack[] stacks;
    public Tableu(Deck deck){
        init(deck);
    }

    private void init(Deck deck) {
        int j = 0;
        for(int h = 0; h < NUMBER_OF_THINGS_IN_A_SEPTET; h++){
            stacks[h] = new TableuStack();
        }
        for(int i = 0; j < NUMBER_OF_THINGS_IN_A_SEPTET; i++){
            stacks[i].addCard(deck.getCard());
            if(i == NUMBER_OF_THINGS_IN_A_SEPTET - 1){
                j++;
                i = j;
            }
        }
    }
}
