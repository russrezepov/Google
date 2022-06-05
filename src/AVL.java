public class AVL {
    public class Node {
        int key;
        int height;
        Node left;
        Node right;
    }//Node

    public class AVLTree {

        private Node root;

        void updateHeight(Node n) {
            n.height = 1 + Math.max(height(n.left), height(n.right));
        }

        int height(Node n) {
            return n == null ? -1 : n.height;
        }

        int getBalance(Node n) {
            return (n == null) ? 0 : height(n.right) - height(n.left);
        }


        Node rotateRight(Node y) {
            Node x = y.left;
            Node z = x.right;
            x.right = y;
            y.left = z;
            updateHeight(y);
            updateHeight(x);
            return x;
        }

        Node rotateLeft(Node y) {
            Node x = y.right;
            Node z = x.left;
            x.left = y;
            y.right = z;
            updateHeight(y);
            updateHeight(x);
            return x;
        }

        Node rebalance(Node z) {
            updateHeight(z);
            int balance = getBalance(z);
            if (balance > 1) {
                if (height(z.right.right) > height(z.right.left)) {
                    z = rotateLeft(z);
                } else {
                    z.right = rotateRight(z.right);
                    z = rotateLeft(z);
                }
            } else if (balance < -1) {
                if (height(z.left.left) > height(z.left.right))
                    z = rotateRight(z);
                else {
                    z.left = rotateLeft(z.left);
                    z = rotateRight(z);
                }
            }
            return z;
        }

        Node insert(Node node, int key) {
            if (node == null) {
                return new Node(key);
            } else if (node.key > key) {
                node.left = insert(node.left, key);
            } else if (node.key < key) {
                node.right = insert(node.right, key);
            } else {
                throw new RuntimeException("duplicate Key!");
            }
            return rebalance(node);
        }

        Node delete(Node node, int key) {
            if (node == null) {
                return node;
            } else if (node.key > key) {
                node.left = delete(node.left, key);
            } else if (node.key < key) {
                node.right = delete(node.right, key);
            } else {
                if (node.left == null || node.right == null) {
                    node = (node.left == null) ? node.right : node.left;
                } else {
                    Node mostLeftChild = mostLeftChild(node.right);
                    node.key = mostLeftChild.key;
                    node.right = delete(node.right, node.key);
                }
            }
            if (node != null) {
                node = rebalance(node);
            }
            return node;
        }

        Node find(int key) {
            Node current = root;
            while (current != null) {
                if (current.key == key) {
                    break;
                }
                current = current.key < key ? current.right : current.left;
            }
            return current;
        }
    }//AVLTree
}
