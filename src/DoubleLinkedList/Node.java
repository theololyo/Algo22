/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;

/**
 *
 * @author Theo
 */
public class Node<E> {

    private E _element;
    private Node<E> _nextNode;
    private Node<E> _prevNode;

    public Node(E element, Node<E> prevNode, Node<E> nextNode) {
        _element = element;
        _nextNode = nextNode;
        _prevNode = prevNode;
    }
    public Node(Node<E> nextNode, Node<E> prevNode) {
        _nextNode = nextNode;
        _prevNode = prevNode;
    }

    public E getElement() {
        return _element;
    }

    public Node<E> getNext() {
        return _nextNode;
    }

    public Node<E> getPrev() {
        return _prevNode;
    }

    public void setPrev(Node<E> n) {
        _prevNode = n;
    }

    public void setNext(Node<E> n) {
        _nextNode = n;
    }

    public void setElement(E element) {
        _element = element;
    }

}
