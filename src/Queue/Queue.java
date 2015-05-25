/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Queue;

import DoubleLinkedList.DoubleLinkedList;

/**
 *
 * @author Theo
 */
public class Queue<E> implements IQueue<E> {

    DoubleLinkedList<E> dll = new DoubleLinkedList<>();

    public Queue() {

    }

    @Override
    public void offer(E element) {
        dll.add(element);
    }

    @Override
    public E peek() {
        E elem = null;
        if (!dll.isEmpty()) {
            elem = dll.getHead().getNext().getElement();
        }
        return elem;
    }

    @Override
    public E poll() {
        E elem = null;
        if (!dll.isEmpty()) {
            elem = dll.remove(0);
        }
        return elem;

    }

    @Override
    public int size() {
        return dll.size();
    }

    @Override
    public E[] toArray() {
        return dll.toArray();
    }

    @Override
    public String toString() {
        return dll.toString();
    }
    
    public DoubleLinkedList asList(){
        
        return dll;
    }

}
