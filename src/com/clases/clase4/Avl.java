package com.clases.clase4;

public class Avl {
    public Node raiz;

    /*
     *
     * Agregar y borrar
     *
     */

    public Avl add(Integer data) {
        raiz = add(data, raiz);
        return this;
    }

    private Node add(Integer data, Node node) {
        if (node == null) {
            return new Node(data);
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

    public void delete(Integer data) {
        raiz = delete(data, raiz);
    }

    private Node delete(Integer data, Node node) {
        if (node == null) {
            return null;
        }
        if (data.compareTo(node.getData()) < 0) {
            node.setLeft(delete(data, node.getLeft()));
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRight(delete(data, node.getRight()));
        } else {
            // One Child or Leaf Node (no children)
            if (node.getLeft() == null) {
                return node.getRight();
            } else if (node.getRight() == null) {
                return node.getLeft();
            }
            // Two Children
            node.setData(getMax(node.getLeft()));
            node.setLeft(delete(node.getData(), node.getLeft()));
        }
        updateHeight(node);
        return applyRotation(node);
    }

    /*
     *
     * Para imprimir (prints)
     *
     */

    public void print() {
        printInOrder(raiz);
    }

    private void printInOrder(Node node) {
        if (node != null) {
            printInOrder(node.getLeft());
            System.out.print(node.getData() + "\t");
            printInOrder(node.getRight());
        }

        System.out.println();
    }

    public void printAsTree() {
        System.out.println(raiz.getData());
        if (raiz.getLeft() != null) printAsTree(raiz.getLeft(), 1);
        else System.out.print(" ├─");
        if (raiz.getRight() != null) printAsTree(raiz.getRight(), 1);
        else System.out.print(" ├─");
    }

    private void printAsTree(Node node, int i) {
        for (int j = 0; j < i; j++) {
            if (i == 1) System.out.print("├─");
            else if (j < i - 1) System.out.print("│  ");
            else System.out.print("├─ ");
        }
        if (node != null) {
            System.out.println(node.getData());
            printAsTree(node.getLeft(), i + 1);
            printAsTree(node.getRight(), i + 1);
        } else System.out.println();
    }

    /*
     *
     * Get min y max
     *
     */

    public Integer getMax() {
        if (isEmpty()) {
            return null;
        }
        return getMax(raiz);
    }

    private Integer getMax(Node node) {
        if (node.getRight() != null) {
            return getMax(node.getRight());
        }
        return node.getData();
    }

    public Integer getMin() {
        if (isEmpty()) {
            return null;
        }
        return getMin(raiz);
    }

    private Integer getMin(Node node) {
        if (node.getLeft() != null) {
            return getMin(node.getLeft());
        }
        return node.getData();
    }

    public boolean isEmpty() {
        return raiz == null;
    }

    /*
     *
     * Rotaciones
     *
     */

    private Node applyRotation(Node node) {
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

    private Node rotateRight(Node node) {
        Node leftNode = node.getLeft();
        Node centerNode = leftNode.getRight();
        leftNode.setRight(node);
        node.setLeft(centerNode);
        updateHeight(node);
        updateHeight(leftNode);
        return leftNode;
    }

    private Node rotateLeft(Node node) {
        Node rightNode = node.getRight();
        Node centerNode = rightNode.getLeft();
        rightNode.setLeft(node);
        node.setRight(centerNode);
        updateHeight(node);
        updateHeight(rightNode);
        return rightNode;
    }

    /*
     *
     * Altura y balance
     *
     */

    private void updateHeight(Node node) {
        int maxHeight = Math.max(
                height(node.getLeft()),
                height(node.getRight())
        );
        node.setHeight(maxHeight + 1);
    }

    private int balance(Node node) {
        return node != null ? height(node.getLeft()) - height(node.getRight()) : 0;
    }

    private int height(Node node) {
        return node != null ? node.getHeight() : 0;
    }
}