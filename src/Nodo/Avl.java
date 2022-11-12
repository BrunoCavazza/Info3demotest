package Nodo;

import java.io.PrintStream;

public class Avl<AnyType extends Comparable<AnyType>> {
    public Node<AnyType> raiz;

  
    public Avl<AnyType> add(AnyType data) {
        raiz = add(data, raiz);
        return this;
    }

    private Node<AnyType> add(AnyType data, Node<AnyType> node) {
        if (node == null) {
            return new Node<>(data);
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(add(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(add(data, node.getRight()));
        } else {
            return node;
        }
        updateHeight(node);
        return applyRotation(node);
    }

    public void delete(AnyType data) {
        raiz = delete(data, raiz);
    }

    private Node<AnyType> delete(AnyType data, Node<AnyType> node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            
            node.setData(getMax(node.getLeft()));
            node.setLeft(delete(node.getData(), node.getLeft()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    public AnyType getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(raiz);
    }

    private AnyType getMax(Node<AnyType> node) {
        if (node.getRight() != null) {
            return getMax(node.getRight());
        }
        return node.getData();
    }

    public AnyType getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(raiz);
    }

    private AnyType getMin(Node<AnyType> node) {
        if (node.getLeft() != null) {
            return getMin(node.getLeft());
        }
        return node.getData();
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    public void makeEmpty() {
        raiz = null;
    }





    private Node<AnyType> applyRotation(Node<AnyType> node) { // rotaciones de los nodos
        int balance = balance(node);
        if (balance > 1) {
            if (balance(node.getLeft()) < 0) {
                node.setLeft(rotateLeft(node.getLeft()));
            }
            return rotateRight(node);
        }
        if (balance < -1) {
            if (balance(node.getRight()) > 0) {
                node.setRight(rotateRight(node.getRight()));
            }
            return rotateLeft(node);
        }
        return node;
    }

    private Node<AnyType> rotateRight(Node<AnyType> node) {
        Node<AnyType> leftNode = node.getLeft();
        Node<AnyType> centerNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node<AnyType> rotateLeft(Node<AnyType> node) {
        Node<AnyType> rightNode = node.getRight();
        Node<AnyType> centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }





    private void updateHeight(Node<AnyType> node) { // balance
        int maxHeight = Math.max(
                height(node.getLeft()),
                height(node.getRight())
        );
        node.setHeight(maxHeight + 1);
    }

    private int balance(Node<AnyType> node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }

    private int height(Node<AnyType> node) {
        return node != null ? node.getHeight() : 0;
    }

   




    public void printInOrderAvl() { // Case 7 Imprimir en orden el Avl
        System.out.println("Arbol ordenado:");
        if (raiz.getLeft() != null) {
            printInOrderAvl(raiz.getLeft());
        }

        System.out.print(raiz.getData() + " - ");

        if (raiz.getRight() != null) {
            printInOrderAvl(raiz.getRight());
        }

        System.out.println();
    }

    private void printInOrderAvl(Node<AnyType> node) {// Case 7 Imprimir en orden el Avl
        if (node != null) {
            printInOrderAvl(node.getLeft());
            System.out.print(node.getData() + " - ");
            printInOrderAvl(node.getRight());
        }
    }



    
    public void printTreeAvl(PrintStream os) {// Case 8 Imprimir el dibujo del Avl
        os.print(traversePreOrder(raiz));
    }

    public String traversePreOrder(Node<AnyType> raiz) {

        if (raiz == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(raiz.getData());

        String pointerRight = "└──";
        String pointerLeft = (raiz.getRight() != null) ? "├──" : "└──";

        traverseNodes(sb, "", pointerLeft, raiz.getLeft(), raiz.getRight() != null);
        traverseNodes(sb, "", pointerRight, raiz.getRight(), false);

        return sb.toString();
    }

    public void traverseNodes(StringBuilder sb, String padding, String pointer, Node<AnyType> node,
                              boolean hasRightSibling) {
        if (node != null) {
            sb.append("\n");
            sb.append(padding);
            sb.append(pointer);
            sb.append(node.getData());

            StringBuilder paddingBuilder = new StringBuilder(padding);
            if (hasRightSibling) {
                paddingBuilder.append("│  ");
            } else {
                paddingBuilder.append("   ");
            }

            String paddingForBoth = paddingBuilder.toString();
            String pointerRight = "└──";
            String pointerLeft = (node.getRight() != null) ? "├──" : "└──";

            traverseNodes(sb, paddingForBoth, pointerLeft, node.getLeft(), node.getRight() != null);
            traverseNodes(sb, paddingForBoth, pointerRight, node.getRight(), false);
        }
    }
}
