package doublyLinkedList;

import src.ua.ithillel.collections.customlinked.list.MyIterator;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
//        list.iterateForward();
//        list.removeLast();
//        list.iterateForward();
//        System.out.println(list.get(0));

        MyIterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
