package com.github.zipcodewilmington.casino.games.solitaire;

import com.github.zipcodewilmington.utils.Node;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

public class Tableu {
    //unblocked cards vs blockedcards
    //what data structure should i use to represent the septet  stacks
    //
    private final IOConsole tableuConsole = new IOConsole(AnsiColor.GREEN);
    private final IOConsole blackCardPrinter = new IOConsole(AnsiColor.BLACK);
    private final IOConsole redCardPrinter = new IOConsole(AnsiColor.RED);
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
    public Node<Card> peekCardsFromTableu(int stackNumber, Node<Card> nodeToTake){
        TableuStack desiredStack = stacks.get(stackNumber);
        if(desiredStack.isEmpty()){
            //stack is empty
            return null;
        }
        return desiredStack.brieflyEmmigrateSequence(nodeToTake);
    }
    public Node<Card> peekCardsFromTableu(int stackNumber, int cardsToOmit){
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
    //used in conjunction with putCards in Tableu
    public void removeCardsFromTableu(int stackNumber,Node<Card>immigrant){
        this.stacks.get(stackNumber).emmigrateSequence(immigrant);
        if(this.stacks.get(stackNumber).peekShowing().isEmpty() && !(this.stacks.isEmpty())){
            this.stacks.get(stackNumber).flipHidden();
        }
    }
    public boolean putCardsInTableu(int stackNumber,Node<Card> immigrant){
        if(immigrant == null){
            System.out.println("Immigrant is blank");
            return false;
        }
        Card headCardOfImmigrant = immigrant.getValue();
        TableuStack desiredStack = stacks.get(stackNumber);
        if(desiredStack.peekTailCard() == null && headCardOfImmigrant.getRank().getValue() == Rank.KING.getValue()){
            desiredStack.immigrateSequence(immigrant);
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
        if(stacks.get(stackNumber).peekShowing().getTail()== null){
            return null;
        }
        return stacks.get(stackNumber).peekShowing().getTail().getValue();
    }
    public void display(){
        tableuConsole.println("TABLEU:");
        for(int i = 0; i < NUMBER_OF_THINGS_IN_A_SEPTET; i++){
            tableuConsole.print("\tT" + i + ": ");
            stacks.get(i).display();
            tableuConsole.print("\n");
        }

    }
    public boolean isTableuClear(){
        for (int i = 0; i < NUMBER_OF_THINGS_IN_A_SEPTET; i++) {
            if(!stacks.get(i).isAllExposed()){
                return false;
            }
        }
        return true;
    }
    //testing methods
    public TableuStack getStack(int index){
        return stacks.get(index);
    }

}
