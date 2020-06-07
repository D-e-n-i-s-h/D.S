package D.S.LinkedList;


public class SinglyLinkedList<E> {
    private int pos = 0;
    private node<E> head = new node<>();

    public int getSize() {
        return pos;
    }

    public void insert(E i) {
        node<E> temp1 = new node<>();
        temp1.data = i;
        if (head.data == null) {
            head.data = i;
            head.next = null;
//            head=temp1;(if its possible is was working on other ds that why i did check it
        } else {
            node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = temp1;
            pos++;
        }
    }

    public void insertPos(E i, int posi) throws Exception {
        if (posi > pos || posi <= -1) {
            throw new Exception("You select wrong position ");

        } else {
            node<E> temp1 = new node<>();
            temp1.data = i;
            if (pos == 0 && head.data == null) {
                head = temp1;
            } else {
                node temp = head;
                for (int j = 0; j < posi; j++) {
                    temp = temp.next;
                }
                temp1.next = temp.next;
                temp.next = temp1;
                pos++;
            }
        }
    }

    public void display() {
        node temp = head;
        while (temp.next != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println(temp.data);
    }

    public boolean isEmpty() {
        if (head.data == null && pos == 0) {
            return true;
        } else {
            return false;
        }
    }

    private class node<E> {
        E data = null;
        node next = null;
    }


}



