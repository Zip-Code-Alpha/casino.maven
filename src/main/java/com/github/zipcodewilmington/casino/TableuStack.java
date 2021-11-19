package com.github.zipcodewilmington.casino;

import java.util.LinkedList;

public class TableuStack {
    private NodedLinkedList<Card> showing;
    private LinkedList<Card> hiddenStack; //stack
    public TableuStack(){
        hiddenStack = new LinkedList<>();
        showing = new NodedLinkedList<>();
    }
    //for initialization purposes only
    public void addCard(Card adder){
        hiddenStack.push(adder);
    }
    //flips the first card of the hidden stack if and only if the showing stack is null
    public void flipHidden(){
        if(showing.head == null &&  ! hiddenStack.isEmpty()){
            //System.out.println(hiddenStack.peek());
            showing.addNode(new Node<>(hiddenStack.pop(), null));
        }
        else if(hiddenStack.isEmpty()){
            //reveal a blank space ( how to represent a blank space?)(null suit and null rank)
            //maybe I should just have both be null
            System.out.println("Adding Blank Space Implementation");
        }
        else{
            //throw a custom exception?
            System.out.println("ExceptionPlaceHolder: the showing stack is not empty");
        }
        //logger perhaps?
    }
    //pre-conditions: cardsToOmit is less than length of sequence and greater than 0
    public Node<Card> emmigrateSequence(int cardsToOmit){
        return showing.retrieveSubList(cardsToOmit);
    }
    public void immigrateSequence(Node<Card> other){
        showing.addNode(other);
    }

    public NodedLinkedList<Card> peekShowing(){
        return this.showing;
    }
    //testing methods
    /*
    public boolean isHiddenStackEmpty(){
        return this.hiddenStack.isEmpty();
    }

     */
    /*
    public String printHiddenStack(){
        StringBuilder sb = new StringBuilder();
        for(Card card: this.hiddenStack){
            sb.append(card.toString());
        }
        return sb + "afdsjkl\n";
    }
     */
}
