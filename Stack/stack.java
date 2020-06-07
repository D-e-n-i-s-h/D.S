package D.S.Stack;


public class stack<E> {
    private E[] arr;
    private int size = 10;
    private int top = -1;
    //in java generic array can't be created so we have to create an object

    stack() {
        arr = (E[]) new Object[size];
    }


    public int getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }

    public void push(E i) throws Exception {
        if (top == size - 1) {
            increase_size();

        }
        arr[++top] = i;
    }

    public E pop() throws Exception {
        if (top == -1) {
            throw new Exception("Data_Structure.Stack is All ready empty");
        } else {

            E p = arr[top];
            top--;
            return p;
        }
    }

    public E peek() throws Exception {
        if (top == -1) {
            throw new Exception("Data_Structure.Stack is empty");
        } else {

            return arr[top];
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public void emptyAll() {
        top = -1;

    }

    private void increase_size() {
        int size1 = 2 * size;

        E arr1[] = (E[]) new Object[size1];

        for (int i = 0; i < size; i++) {
            arr1[i] = arr[i];
        }
        size = size1;
        arr = arr1;

    }


}


