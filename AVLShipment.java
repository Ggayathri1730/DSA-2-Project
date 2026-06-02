class Node {
    int shipmentID, height;
    Node left, right;

    Node(int id) {
        shipmentID = id;
        height = 1;
    }
}

public class AVLShipment {

    Node root;

    int height(Node n) {
        return (n == null) ? 0 : n.height;
    }

    int getBalance(Node n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    Node rightRotate(Node y) {
        Node x = y.left;
        Node t2 = x.right;

        x.right = y;
        y.left = t2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    Node leftRotate(Node x) {
        Node y = x.right;
        Node t2 = y.left;

        y.left = x;
        x.right = t2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    Node insert(Node node, int shipmentID) {

        if (node == null)
            return new Node(shipmentID);

        if (shipmentID < node.shipmentID)
            node.left = insert(node.left, shipmentID);
        else if (shipmentID > node.shipmentID)
            node.right = insert(node.right, shipmentID);
        else
            return node;

        node.height = 1 + Math.max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && shipmentID < node.left.shipmentID)
            return rightRotate(node);

        if (balance < -1 && shipmentID > node.right.shipmentID)
            return leftRotate(node);

        if (balance > 1 && shipmentID > node.left.shipmentID) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && shipmentID < node.right.shipmentID) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.shipmentID + " ");
            inorder(node.right);
        }
    }

    public static void main(String[] args) {

        AVLShipment tree = new AVLShipment();

        int shipments[] = {120, 105, 150, 110, 140};

        for (int id : shipments)
            tree.root = tree.insert(tree.root, id);

        System.out.println("Sorted Shipment Records:");
        tree.inorder(tree.root);
    }
}