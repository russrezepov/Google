import java.util.LinkedList;
import java.util.Queue;
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

        private boolean containsNodeRecursive(Node current, int value) {
            if (current == null) {
                return false;
            }
            if (value == current.value) {
                return true;
            }
            return value < current.value
                    ? containsNodeRecursive(current.left, value)
                    : containsNodeRecursive(current.right, value);
        }

        public boolean containsNode(int value) {
            return containsNodeRecursive(root, value);
        }

//        Another common operation is the deletion of a node from the tree.
//        First, we have to find the node to delete in a similar way as before:

        private Node deleteRecursive(Node current, int value) {
            if (current == null) {
                return null;
            }

            if (value == current.value) {

                //LEAF NODE
                if (current.left == null && current.right == null) {
                    return null;
                }

                //ONE CHILD
                if (current.right == null) {
                    return current.left;
                }

                if (current.left == null) {
                    return current.right;
                }

                //Finally, we have to handle the case where the node has two children.

                //First, we need to find the node that will replace the deleted node.
                // We'll use the smallest node of the soon to be deleted node's right sub-tree:


                    int smallestValue = findSmallestValue(current.right);
                    current.value = smallestValue;
                    current.right = deleteRecursive(current.right, smallestValue);
                    return current;


                //Then we assign the smallest value to the node to delete, and after that, we'll delete it from the right sub-tree:
            }
            if (value < current.value) {
                current.left = deleteRecursive(current.left, value);
                return current;
            }

            current.right = deleteRecursive(current.right, value);
            return current;
        }
        private int findSmallestValue(Node root) {
            return root.left == null ? root.value : findSmallestValue(root.left);
        }
//        Once we find the node to delete, there are 3 main different cases:
//        a node has no children – this is the simplest case; we just need to replace this node with null in its parent node
//        a node has exactly one child – in the parent node, we replace this node with its only child.
//        a node has two children – this is the most complex case because it requires a tree reorganization

        public void deleteNode(int value) {
            root = deleteRecursive(root, value);
        }

        public void BFS() {
            if (root == null) {
                return;
            }

            Queue<Node> nodes = new LinkedList<>();
            nodes.add(root);

            while (!nodes.isEmpty()) {

                Node node = nodes.remove();

                System.out.print(" " + node.value);

                if (node.left != null) {
                    nodes.add(node.left);
                }

                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
        }//BFS

    public static void main(String[] args) {

        BinaryTree bt = BinaryTree.create();
        bt.printInOrder();
        System.out.println("\n");
        bt.printPreOrder();
    }
}
