package D.S.Tree;

public class AVL {
    Node root;

    {
        root = null;
    }

    public int getHeigth(Node n) {
        if (n == null) return 0;
        else return n.height;
    }

    private int getbalance(Node n) {
        if (n == null) return 0;
        else return getHeigth(n.left) - getHeigth(n.right);
    }

    private int max(int a, int b) {
        return a > b ? a : b;
    }

    private Node leftRotate(Node n) {
        Node x = n.right;
        Node y = x.left;

        x.left = n;
        n.right = y;

        x.height = max(getHeigth(x.left), getHeigth(x.right)) + 1;
        n.height = max(getHeigth(n.left), getHeigth(n.right)) + 1;

        return x;
    }

    private Node rightRotate(Node n) {
        Node x = n.left;
        Node y = x.right;

        x.right = n;
        n.left = y;

        x.height = max(getHeigth(x.left), getHeigth(x.right)) + 1;
        n.height = max(getHeigth(n.left), getHeigth(n.right)) + 1;
        return x;
    }

    public void insert(int n) {
        this.root = insert(root, n);
    }

    private Node insert(Node root, int n) {
        if (root == null) return new Node(n);

        else {
            if (n <= root.data) {
                root.left = insert(root.left, n);
            } else {
                root.right = insert(root.right, n);
            }
        }
        root.height = max(getHeigth(root.left), getHeigth(root.right)) + 1;
        int balance = getbalance(root);


        if (balance > 1 && root.left.data > n) {
            return rightRotate(root);
        } else if (balance < -1 && root.right.data < n) {
            return leftRotate(root);
        } else if (balance > 1 && root.left.data < n) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        } else if (balance < -1 && root.right.data > n) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }


        return root;
    }

    private Node minD(Node root) {
        if (root.left == null) return root;
        else return minD(root);

    }

    public void delete(int n) {
        del(root, n);
    }

    private Node del(Node root, int n) {
        if (root.data != n) {
            if (root.data > n) {
                Node temp = del(root.left, n);
                if (temp == null) root.left = null;
            } else {
                Node temp = del(root.right, n);
                if (temp == null) root.right = null;
            }
        } else {
            if (root.right == null && root.left == null) return root = null;
            else if (root.left != null && root.right != null) {
                Node temp = minD(root.right);
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
        int balance = getbalance(root);


        if (balance > 1 && root.left.data > n) {
            return rightRotate(root);
        } else if (balance < -1 && root.right.data < n) {
            return leftRotate(root);
        } else if (balance > 1 && root.left.data < n) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        } else if (balance < -1 && root.right.data > n) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }


        return root;
    }

    public void preorder() {
        Preorder(root);
    }

    private void Preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }
    }

    private class Node {
        int data, height = 1;
        Node right = null;
        Node left = null;

        Node(int n) {
            this.data = n;
        }
    }

}
