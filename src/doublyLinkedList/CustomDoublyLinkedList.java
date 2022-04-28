package doublyLinkedList;

public interface CustomDoublyLinkedList<E> {
    int size();

    void add(E element);

    E get(int index);

    E removeLast();

    public void iterateForward();
}