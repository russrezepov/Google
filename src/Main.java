import java.util.Random;
public class Main {

    public static class BinaryTree {
        public static class Node {
            int value;
            Node left;
            Node right;

            public Node(int value) {
                this.value = value;
                left = null;
                right = null;
            }
        }//Node

        public Node root;

        public Node addNodeRecursively(Node current, int value) {
            if (current == null) {
                return new Node(value);
            }

            if (value < current.value) {
                current.left = addNodeRecursively(current.left, value);
            } else if (value > current.value) {
                current.right = addNodeRecursively(current.right, value);
            } else {
                return current; //value already exists
            }

            return current;
        }

        public void addNode(int value) {
            root = addNodeRecursively(root, value);
        }

        public void printInOrder() { //prints all nodes in a Binary Tree
            inOrderRecursively(root);
        }

        private void inOrderRecursively(Node current) {
            if (current == null) {
                return;
            }

            inOrderRecursively(current.left);
            System.out.printf("%s ", current.value);
            inOrderRecursively(current.right);
        }

        public static BinaryTree create() {
            Random rand = new Random();
            BinaryTree bt = new BinaryTree();
            Node root = new Node(rand.nextInt(100));
            int nodesAmount = 10;

            bt.root = root;
            for (int i = 0; i < nodesAmount; i++) {
                bt.addNode(rand.nextInt(100));
            }

            return bt;
        }
    }//BinaryTree

    public static void main(String[] args) {

        BinaryTree bt = BinaryTree.create();
        bt.printInOrder();

    }
}
