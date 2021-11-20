package com.github.zipcodewilmington.casino;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//3rd card is top of talon
public class Talon {
    //talon has hidden while display has displayed?
    private LinkedList<Card> talonStack;
    private static final int MAX_AMOUNT_IN_DISPLAY_QUEUE = 3;
    //stack of displayed cards? which puts the rest in the talon
    private LinkedList<Card> displayQueue;
    public Talon(){
        this.talonStack = new LinkedList<>();
        this.displayQueue = new LinkedList<>();
    }
    //how to display
    public void accept(Card card){
        if(displayQueue.size() > MAX_AMOUNT_IN_DISPLAY_QUEUE){
            System.out.println("overfilled display(accept)");
        }
        else if (displayQueue.size() == MAX_AMOUNT_IN_DISPLAY_QUEUE) {
            this.talonStack.push(this.displayQueue.poll());
        }
        this.displayQueue.push(card);
    }
    public Card preDonate(){
        if(displayQueue.size() > MAX_AMOUNT_IN_DISPLAY_QUEUE){
            System.out.println("overfilled display(donate)");
            return null;
        }
        else if(displayQueue.size() == 0){
            System.out.println("Error: Nothing to Donate");
            return null;
        }
        else{
            return displayQueue.peek();
        }
    }
    //check if able to donate in outside class
    public Card donate(){
        if(displayQueue.size() > MAX_AMOUNT_IN_DISPLAY_QUEUE){
            System.out.println("overfilled display(donate)");
            return null;
        }
        else if(displayQueue.size() == 0){
            System.out.println("Error: Nothing to Donate");
            return null;
        }
        else{
            Card donation = displayQueue.poll();
            if(!talonStack.isEmpty()){
                displayQueue.offer(talonStack.pop());
            }
            return donation;
        }
    }
    //to Stock;
    //**must be checked outside of method**
    public LinkedList<Card> toStock(){
        while(!displayQueue.isEmpty()){
            this.talonStack.push(displayQueue.pollLast());
        }
        LinkedList<Card> temp = talonStack;
        this.talonStack.clear();
        Collections.reverse(temp);
        return temp;
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("TALON");
        if(this.displayQueue.isEmpty()){
            sb.append("EMPTY");
            return sb.toString();
        }
        //double check this
        sb.append("(card available to draw is at the end):");
        return sb.toString();

    }
    //toString of Card //call every update?
    public List<Card> getCards(){
        return this.displayQueue;
    }
}
