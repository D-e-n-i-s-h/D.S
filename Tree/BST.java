package D.S.Tree;

import java.util.ArrayDeque;

public class BST {
    private node root;

    BST() {
        root = null;
    }


    public void insert(int i) {
        root = insert(root, i);
    }

    private node insert(node root, int i) {

        if (root == null) {
            root = new node();
            root.data = i;
        } else if (i <= root.data) {
            root.left = insert(root.left, i);
        } else {
            root.right = insert(root.right, i);
        }
        return root;
    }


    public int max() {
        int m = max(root);
        return m;
    }

    private int max(node root) {
        if (root.right == null) {
            return root.data;
        } else {
            return max(root.right);
        }
    }


    public void print() {
        printTree(root);
    }

    private void printTree(node root) {
        if (root != null) {
            printTree(root.left);
            System.out.print(root.data + ",");
            printTree(root.right);
        }
    }

    public int min() {
        int m = min(root);
        return m;
    }

    private int min(node root) {
        if (root.left == null) {
            return root.data;
        } else {
            return min(root.left);
        }
    }

    public boolean search(int n) {
        boolean se = search(root, n);
        return se;
    }

    private boolean search(node root, int n) {
        if (root == null) {
            return false;
        } else if (n == root.data) {
            return true;
        } else if (n <= root.data) {
            boolean a = search(root.left, n);
            return a;
        } else {
            boolean a = search(root.right, n);
            return a;
        }

    }

    public void levelOrderT() {
        ArrayDeque<node> add = new ArrayDeque<>();
        if (root == null) return;
        add.addFirst(root);
        while (!add.isEmpty()) {
            node current = add.getFirst();
            System.out.print(current.data + ",");
            if (current.left != null) add.addLast(current.left);
            if (current.right != null) add.addLast(current.right);
            add.removeFirst();
        }
    }


    public void preorder() {
        pre(root);
        System.out.println();
    }

    private void pre(node root) {
        if (root == null) return;
        System.out.print(root.data + ",");
        pre(root.left);
        pre(root.right);
    }

    public void inorder() {
        in(root);
        System.out.println();
    }

    private void in(node root) {
        if (root == null) return;
        in(root.left);

        System.out.print(root.data + ",");
        in(root.right);
    }

    public void postorder() {
        post(root);
        System.out.println();
    }

    private void post(node root) {
        if (root == null) return;
        post(root.left);
        post(root.right);

        System.out.print(root.data + ",");
    }

    public void delete(int n) {
        del(root, n);
    }

    private node del(node root, int n) {
        if (root.data != n) {
            if (root.data > n) {
                node temp = del(root.left, n);
                if (temp == null) root.left = null;
            } else {
                node temp = del(root.right, n);
                if (temp == null) root.right = null;
            }
        } else {
            if (root.right == null && root.left == null) return root = null;
            else if (root.left != null && root.right != null) {
                node temp = minD(root.right);
                root.data = temp.data;
                if (temp.right != null) root.right = temp;
                del(root.right, temp.data);
            } else {
                if (root.right != null) {
                    root.data = root.right.data;
                    root.right = root.right.right;

                } else {
                    root.data = root.left.data;
                    root.left = root.left.left;
                }
            }
        }

        return root;
    }

    private node minD(node root) {
        if (root.left == null) return root;
        else return minD(root);

    }

    private class node {
        int data = 0;
        node right = null;
        node left = null;
    }
}

