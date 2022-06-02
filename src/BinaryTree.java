import java.util.Random;

    public class BinaryTree {
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

        //prints all nodes in a Binary Tree left subtree Node right subtree
        public void printInOrder() {
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

        public void printPreOrder() {
            preOrderRecursively(root);
        }

        private void preOrderRecursively(Node current) {
            if (current == null) {
                return;
            }

            System.out.printf("%s ", current.value);
            inOrderRecursively(current.left);
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

            System.out.println("root " + bt.root.value + " " + bt.root.left.value);

            return bt;
        }

    public static void main(String[] args) {

        BinaryTree bt = BinaryTree.create();
        bt.printInOrder();
        System.out.println("\n");
        bt.printPreOrder();
    }
}
