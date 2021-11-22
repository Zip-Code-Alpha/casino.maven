package com.github.zipcodewilmington.utils;

public class Node<E> {
    E value;
    Node<E> next;
    public Node(E value, Node<E> next){
        this.value = value;
        this.next = next;
    }
    public E getValue(){
        return this.value;
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return this.value.equals(node.value);
    }
    @Override
    public String toString(){
        return this.value.toString();
    }

    public Node<E> getNext() {
        return this.next;
    }
}
