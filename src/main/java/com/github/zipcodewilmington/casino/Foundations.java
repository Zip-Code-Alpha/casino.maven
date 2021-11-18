package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Foundations {
    public static final int NUMBER_OF_FOUNDATIONS = 4;
    List<LinkedList<Card>> foundations = new ArrayList<>();
    public Foundations(){
        for (int i = 0; i < NUMBER_OF_FOUNDATIONS; i++) {
            foundations.add(new LinkedList<>());
        }
    }
    //check if ok?
    public boolean addToFoundation(Card card, int foundationNumber){
        LinkedList<Card> desiredStack = foundations.get(foundationNumber);
        if(desiredStack.isEmpty()) {
            if (card.getRank().getValue() == Rank.ACE.getValue()) {
                desiredStack.push(card);
                return true;
            }
            System.out.println("Invalid Move: try placing *ACES* on empty foundations");
            return false;
        }
        else if(desiredStack.peek().getRank().getValue() != Rank.KING.getValue()){
            Card topCard = desiredStack.pop();
            if(topCard.getSuit().getValue() == card.getSuit().getValue()){
                if(topCard.getRank().getValue() + 1 == card.getRank().getValue()){
                    desiredStack.push(card);
                    return true;
                }
                System.out.println("Invalid move: mismatched ranks");
                return false;
            }
            System.out.println("Invalid move: mismatched ranks");
            return false;
        }
        else{
            System.out.println("Invalid move: foundation is full");
            return false;
        }
    }
}
