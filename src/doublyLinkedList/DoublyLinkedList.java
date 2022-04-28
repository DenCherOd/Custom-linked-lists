package doublyLinkedList;

import src.ua.ithillel.collections.customlinked.list.MyIterator;

import java.util.NoSuchElementException;
import java.util.Objects;

public class DoublyLinkedList<E> implements CustomDoublyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> current = head;

        for (int i = 1; i <= index; i++) {
            current = current.next;
        }
        return current.element;
    }

    @Override
    public E removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Node<E> tmp = tail;
        tail = tail.prev;
        tail.next = null;
        size--;
        System.out.println("Deleted element: " + tmp.element);
        return tmp.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        Node<E> tmp = new Node(element, null, tail);
        if (tail != null) {
            tail.next = tmp;
        }
        tail = tmp;
        if (head == null) {
            head = tmp;
        }
        size++;
        System.out.println("Adding element: " + element);
    }

    @Override
    public void iterateForward() {
        System.out.println("Iterating forward.");
        Node<E> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.element);
            tmp = tmp.next;
        }
    }

    public MyIterator<E> iterator() {
        MyIterator<E> iterator = new MyIterator<E>() {

            private Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public E next() {
                if (!hasNext()) throw new NoSuchElementException();
                E tmp = (E) current.element;
                current = current.next;  // if next is null, hasNext will return false.
                return tmp;
            }

        };
        return iterator;
    }

    private class Node<E> {
        E element;
        Node next;
        Node prev;

        public Node(E element, Node next, Node prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }
}