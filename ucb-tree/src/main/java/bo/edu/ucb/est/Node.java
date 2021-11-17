package bo.edu.ucb.est;

public class Node <D extends Comparable<D> > {
    private D data;
    private Node<D> left;
    private Node<D> right;

    public Node(D data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }

    public Node<D> getLeft() {
        return left;
    }

    public void setLeft(Node<D> left) {
        this.left = left;
    }

    public Node<D> getRight() {
        return right;
    }

    public void setRight(Node<D> right) {
        this.right = right;
    }
}
