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
    //check if this is empty
    public Node<Card> takeCardsFromTableu(int stackNumber, int cardsToOmit){
        TableuStack desiredStack = stacks.get(stackNumber);
        if(desiredStack.isEmpty()){
            //stack is empty
            return null;
        }
        //size parameter
        if(cardsToOmit >= desiredStack.getSize()){
            //too many cards to omit
            return null;
        }
        return desiredStack.brieflyEmmigrateSequence(cardsToOmit);
    }
    public boolean putCardsInTableu(int stackNumber,Node<Card> immigrant){
        if(immigrant == null){
            System.out.println("Immigrant is blank");
            return false;
        }
        Card headCardOfImmigrant = immigrant.getValue();
        TableuStack desiredStack = stacks.get(stackNumber);
        if(desiredStack.peekTailCard() == null && headCardOfImmigrant.getRank().getValue() == Rank.KING.getValue()){
            desiredStack.immigrateSequence(desiredStack.emmigrateSequence(immigrant));
            return true;
        }
        else if(desiredStack.peekTailCard() != null){
            if(desiredStack.peekTailCard().getRank().getValue() == headCardOfImmigrant.getRank().getValue() + 1){
                if(desiredStack.peekTailCard().getSuit().getColor() != headCardOfImmigrant.getSuit().getColor()){
                    desiredStack.immigrateSequence(immigrant);
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;

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
