/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DoubleLinkedList;

/**
 *
 * @author Theo
 * @param <E>
 */
public class DoubleLinkedList<E> implements IDoubleLinkedList<E> {

    private Node<E> _head;
    private Node<E> _tail;
    private int _size = 0;

    public DoubleLinkedList() {
        _head = new Node<E>(_tail, null);
        _tail = new Node<E>(null, _head);
    }

    @Override
    public void add(E element) {
        Node<E> newest = new Node<E>(element, _tail.getPrev(), _tail);
        _tail.getPrev().setNext(newest);
        _tail.setPrev(newest);
        _size++;
    }

    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        if (index == size()) {
            add(element);
            return;
        }
        Node<E> newNode = new Node<E>(element, _head, _head.getNext());
        if (index == 0) {
            _head.getNext().setPrev(newNode);
            _head.setNext(newNode);
        } else {
            Node<E> tempNode = _head.getNext();
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setNext(new Node<E>(element, tempNode, tempNode.getNext()));
        }
        _size++;

    }

    @Override
    public void clear() {
        _head.setNext(_tail);
        _tail.setPrev(_head);
        _size = 0;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }

        if (index == size() - 1) {
            return _tail.getPrev().getElement();
        }
        Node<E> tempNode = _head.getNext();
        if (index == 0) {
            return _head.getNext().getElement();
        } else {
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
        }
        return tempNode.getElement();
    }

    @Override
    public int indexOf(E element) {
        Node<E> tempNode = _head.getNext();
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if(tempNode.getElement().equals(element)){
                index = i;
                break;
            }
               tempNode = tempNode.getNext();
                        
        }
        return index;
    }

    @Override
    public int lastIndexOf(E element) {
        Node<E> tempNode = _head.getNext();
        int index = -1;
        for (int i = 0; i < size(); i++) {
            if(tempNode.getElement().equals(element)){
                index = i;
            }
               tempNode = tempNode.getNext();
                        
        }
        return index;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        E oldElem = get(index);
        Node<E> tempNode = _head.getNext();
        if (index == 0) {
            _head.setNext(tempNode.getNext());
            tempNode.getNext().setPrev(_head.getNext());
        }
        if (index == size() - 1) {
            _tail.getPrev().getPrev().setNext(_tail);
            _tail.setPrev(_tail.getPrev().getPrev());
        } else {
            for (int i = 0; i < index - 1; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.getNext().getNext().setPrev(tempNode);
            tempNode.setNext(tempNode.getNext().getNext());
        }
        _size--;
        return oldElem;
    }

    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        E oldElem = get(index);
        if (index == 0) {
            _head.getNext().setElement(element);
        }
        if (index == size() - 1) {
            _tail.getPrev().setElement(element);
        } else {
            Node<E> tempNode = _head.getNext();
            for (int i = 0; i < index; i++) {
                tempNode = tempNode.getNext();
            }
            tempNode.setElement(element);
        }

        return oldElem;
    }

    @Override
    public int size() {
        return _size;
    }

    @Override
    public String toString() {
        String ret = new String();
        if (!isEmpty()) {
            ret = "[";
            Node<E> elem = _head.getNext();
            for (int i = 0; i < size() - 1; i++) {
                ret += elem.getElement() + ", ";
                elem = elem.getNext();
            }

            ret += elem.getElement() + "]";
        } else if (isEmpty()) {
            ret = "[]";
        }
        return ret;
    }

    public boolean isEmpty() {
        return _head.getNext() == null;
    }

    @Override
    public E[] toArray() {
        Node<E> tempNode = _head.getNext();
        if (!isEmpty()) {
            Object[] tempArray = new Object[size()];
            for (int i = 0; i < size(); i++) {
                tempArray[i] = get(i);
            }

            return (E[]) tempArray;
        }

        return null;
    }

    public Node<E> getHead() {
        return _head;
    }

    public Node<E> getTail() {
        return _tail;
    }

}
