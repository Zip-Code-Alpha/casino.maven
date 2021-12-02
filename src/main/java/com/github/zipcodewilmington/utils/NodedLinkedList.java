package com.github.zipcodewilmington.utils;

public class NodedLinkedList<E> {
    Node<E> head; //head is the top of the straight
    Node<E> tail; //tail is the exposed node
    int size = 0;
    public NodedLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public NodedLinkedList(Node<E> head){
        if(head == null){
            System.out.println("null head");
        }
        else if(head.next == null) {
            this.head = head;
            size++;
            this.tail = head;
        }
        else{
            addMultipleNodes(head);
            this.head = head;
        }
    }
    public Node<E> getHead(){
        return this.head;
    }
    public Node<E> getTail(){ //this is the end of the sequence
        return this.tail;
    }
    private void addMultipleNodes(Node<E> newbies){ //add to tailV
        Node<E> temp = newbies;
        if(tail != null){
            tail.next = newbies;
        }
        else if(head == null) {
            head = newbies;
        }
        while(temp.next != null){
            size++;
            temp = temp.next;
        }
        size++;
        this.tail = temp;
    }
    public void addNode(Node<E> newbie){ //add to tailV
        if(newbie == null) {
            System.out.println("parameter is null");
        }
        else if(newbie.next == null) {
            if (tail == null) {
                head = newbie;
            } else {
                tail.next = newbie;
            }
            tail = newbie;
            size++;
        }
        else {
            this.addMultipleNodes(newbie);
        }
    }
    public boolean isEmpty(){
        return head == null;
    }
    public int getSize(){
        return size;
    }
    public Node<E> retrieveSubList(Node<E> nodeToRemove){
        Node<E> curr = this.head;
        Node<E> prev = curr;
        if(new NodedLinkedList<E>(nodeToRemove).equals(this)){
            tail = null;
            head = null;
            size = 0;
            return curr;
        }
        size = 0;
        while(!curr.equals(nodeToRemove)){
            size++;
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        tail = prev;
        return curr;
    }
    public Node<E> peekSubList(Node<E> nodeToRemove){
        Node<E> curr = this.head;
        if(new NodedLinkedList<E>(nodeToRemove).equals(this)){
            return curr;
        }
        while(!curr.equals(nodeToRemove)){
            curr = curr.next;
        }
        return curr;
    }
    //pre-condition: nTO is not less than 0 and does not exceed or equal the size of the list
    public Node<E> peekSubList(int nodesToOmit){//start from head and go down // zero nTO is all cards //V
        int currInd = 0;
        Node<E> curr = this.head;
        Node<E> prev = curr;
        if(nodesToOmit == 0){
            return curr;
        }
        while(currInd < nodesToOmit){
            prev = curr;
            curr = curr.next;
            currInd++;
        }
        return curr;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodedLinkedList<?> olist = (NodedLinkedList<?>) o;
        if (olist.size != this.size) return false;
        Node<E> tempt = this.head; //temp this
        Node<?> tempo = olist.head; //temp olist
        while(tempt.next != null){
            if(!tempt.value.equals(tempo.value)){
                return false;
            }
            tempt = tempt.next;
            tempo = tempo.next;
        }
        return true;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.head == null) {
            return "";
        }
        Node<E> temp = this.head;
        while(temp != null){
            sb.append(temp);
            temp = temp.next;
            sb.append(",");
        }
        return sb.toString();
    }

}
