package com.github.zipcodewilmington.casino;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Foundations {
    public static final int NUMBER_OF_FOUNDATIONS = 4;
    private List<LinkedList<Card>> foundations = new ArrayList<>();
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
            Card topCard = null;
            if((topCard = desiredStack.peek())==null){
                return false;
            }
            else if(topCard.getSuit().getValue() == card.getSuit().getValue()){
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

    public Card takeFromFoundation(int foundationNumber){
        if(foundations.get(foundationNumber) == null){
            //foundation is empty
            return null;
        }
        return foundations.get(foundationNumber).pop();
    }
    public boolean areAllFoundationsFull(){
        for (int i = 0; i < NUMBER_OF_FOUNDATIONS; i++) {
            Card topCard = foundations.get(i).peek();
            if(topCard == null){
                return false;
            }
            else{
                if(topCard.getRank().getValue() != Rank.KING.getValue()){
                    return false;
                }
            }
        }
        return true;
    }
}
