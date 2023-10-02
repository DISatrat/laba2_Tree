import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> node;

    public BinaryTree() {
        this.node = null;
    }

    public BinaryTreeNode<T> insertValue(BinaryTreeNode<T> node, T value) {

        if (node == null) {
            return new BinaryTreeNode<T>(value);
        }

        if (value.compareTo(node.getValue()) < 0) {
            node.setLeft(insertValue(node.getLeft(), value));
        } else if (value.compareTo(node.getValue()) > 0) {
            node.setRight(insertValue(node.getRight(), value));
        } else {
            return node;
        }
        return node;
    }

    public void insert(T value) {
        node = insertValue(node, value);
    }

    public void printTree() {
        printInOrder(node);
    }

    private void printInOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            return;
        }
        printInOrder(node.getLeft());
        System.out.println(node.getValue());
        printInOrder(node.getRight());
    }


    public static BinaryTree create() {
        BinaryTree<Integer> node = new BinaryTree<>();
        node.insert(6);
        node.insert(4);
        node.insert(8);
        node.insert(3);
        node.insert(5);
        node.insert(7);
        node.insert(9);
        return node;
    }

    public void breadthFirstSearch() {

        if (node == null) {
            return;
        }
        List<BinaryTreeNode> list = new ArrayList<>();
        list.add(node);

        while (!list.isEmpty()) {

            BinaryTreeNode root = list.remove(0);

            System.out.print(root.getValue() + " ");

            if (root.getLeft() != null) {
                list.add(root.getLeft());
            }

            if (root.getRight() != null) {
                list.add(root.getRight());
            }

        }
    }
}