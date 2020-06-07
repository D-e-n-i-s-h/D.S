package D.S.Queue;

public class queue<E> {
    E[] arr;
    private int head = -1, tail = -1;
    private int size = 4;

    public queue() {
        arr = (E[]) new Object[size];
    }

    public queue(int size) {
        this.size = size;
        arr = (E[]) new Object[size];
    }

    public int getHead() {
        return head;
    }

    public int getTail() {
        return tail;
    }

    public int get_size() {
        return size;
    }


    public void insert(E i) throws Exception {
        if (head == -1 && tail == -1) {
            head++;
            tail++;

            arr[tail] = i;
        } else if (tail == size - 1) {
            increasesize();
            arr[++tail] = i;
        } else {
            arr[++tail] = i;
        }
    }

    public E delete() throws Exception {
        if (head == tail && tail != -1 && head != -1) {
            E i = arr[head];
            head = -1;
            tail = -1;
            return i;
        } else if (head == -1 && tail == -1) {
            throw new Exception("Queue is empty already");
        } else {
            E i = arr[head];
            head++;
            return i;
        }
    }

    public boolean isEmtpy() {
        if (head == -1 && tail == -1) {
            return true;
        } else {
            return false;
        }
    }

    private void increasesize() {
        int size1 = 2 * size;
        E arr1[] = (E[]) new Object[size1];
        for (int i = 0; i < size; i++) {
            arr1[i] = arr[i];
        }
        arr = arr1;
        size = size1;
    }


}


