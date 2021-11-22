package com.github.zipcodewilmington;

import com.github.zipcodewilmington.utils.Node;
import com.github.zipcodewilmington.utils.NodedLinkedList;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class NodedLinkedListTest {
    protected NodedLinkedList<Integer> listOf2;
    protected NodedLinkedList<Integer> listOf3;

    @Before
    public void beforeTest(){
        //1 is the head, 0 is the tail
        listOf2 = new NodedLinkedList<>(new Node<Integer>(1,null));
        listOf2.addNode( new Node<Integer>(0,null));
        listOf3 = new NodedLinkedList<>(new Node<Integer>(2,null));
        listOf3.addNode(new Node<Integer>(1,null));
        listOf3.addNode(new Node<Integer>(0,null));
    }
    @Test
    public void equalsTest(){
        beforeTest();
        NodedLinkedList<Integer> eq = new NodedLinkedList<Integer>(new Node<Integer>(0,null));
        Assertions.assertEquals(new NodedLinkedList<Integer>(new Node<Integer>(0,null)), eq);
    }
    @Test
    public void addToNullTest(){
        beforeTest();
        NodedLinkedList<Integer> actual = new NodedLinkedList<>();
        actual.addNode(listOf3.getHead());

    }
    @Test
    public void notEqualsLengthTest(){
        beforeTest();
        Assertions.assertNotEquals(listOf2,listOf3);
    }
    @Test
    public void addNodeTestLeng1(){
        beforeTest();
        Assertions.assertEquals(new NodedLinkedList<>(new Node<>(1,new Node<>(0,null))),listOf2);
    }
    @Test
    public void addNodeTestLeng2(){
        beforeTest();
        NodedLinkedList<Integer> actual = new NodedLinkedList<>(new Node<>(2, null));
        actual.addNode(listOf2.getHead());
        Assertions.assertEquals(actual,listOf3);
    }
    @Test
    public void retrieveSubListTest(){
        beforeTest();
        NodedLinkedList<Integer> expected= new NodedLinkedList<>(new Node<>(1, null));
        listOf2.retrieveSubList(new Node<Integer>(0,null));
        Assertions.assertEquals(expected,listOf2);
    }
    @Test
    public void retrieveSubListTest2(){
        beforeTest();
        NodedLinkedList<Integer> expected= new NodedLinkedList<>(new Node<>(2, null));
        listOf3.retrieveSubList(listOf2.getHead());
        Assertions.assertEquals(expected,listOf3);
    }
    @Test
    public void peekSubListTest(){
        beforeTest();
        Node<Integer> expected= new Node<Integer>(1, new Node<Integer>(0,null));
        Node<Integer> actual = listOf3.peekSubList(listOf2.getHead());
        Assertions.assertEquals(expected,actual);
    }
}
