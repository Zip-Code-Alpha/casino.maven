package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.List;

public class Tableu {
    //unblocked cards vs blockedcards
    //what data structure should i use to represent the septet  stacks
    //

    private final int NUMBER_OF_THINGS_IN_A_SEPTET = 7;
    private List<TableuStack> stacks = new ArrayList<>();
    public Tableu(Deck deck){
        init(deck);
    }

    private void init(Deck deck) {
        int j = 0;
        //initialize the stacks
        for(int h = 0; h < NUMBER_OF_THINGS_IN_A_SEPTET; h++){
            stacks.add(new TableuStack());
        }
        //populate the stacks
        for(int i = 0; i < NUMBER_OF_THINGS_IN_A_SEPTET; i++){
            stacks.get(i).addCard(deck.getCard());
            if(i == NUMBER_OF_THINGS_IN_A_SEPTET - 1){
                i = j;
                j++;
            }
        }
        //flip the cards
        for (int i = 0; i < NUMBER_OF_THINGS_IN_A_SEPTET; i++) {
            stacks.get(i).flipHidden();
        }
    }
    //how will moving the cards work? (s
    //pre-condition: stack number must not be greater than 6 (will probably only be used for testing purposes)
    public Card peekTopCard(int stackNumber){
        return stacks.get(stackNumber).peekShowing().getTail().getValue();
    }

    //testing methods
    /**
    public TableuStack getStack(int stackNumber){
        return stacks.get(stackNumber);
    }
     **/

}
