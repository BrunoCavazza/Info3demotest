package com.clases.clase4;
import java.util.Scanner;
import java.util.Random;

public class Node {

    private Integer data;
    private Node left;
    private Node right;
    private int height = 1; //avl

    public Node(Integer data) {
        this.data = data;
    }
    public Node(){

    }
    /**
     * Agregar un dato ordenado.
     * @param d
     */
    public void add(Integer d){

        //Si el valor a insertar es menor al valor del nodo se insertará a la izquierda.
        //Si el valor a insertar es mayor al valor del nodo se insertará a la derecha.
        if (d < this.data) {
            if (left != null) {
                left.add(d);
            } else {
                left = new Node(d);
            }
        } else {
            if (right != null) {
                right.add(d);
            } else {
                right = new Node(d);
            }
        }
    }
    public void addFirstValue(Integer data){
        if(this.data==null && this.getLeft()==null &&this.getRight()==null){
            this.data = data;
        }
    }
    /**
     * Buscar dato y retornar el nodo.
     * @param d
     * @return
     */
    public Integer find(Integer d){

        if (d == this.data){
            return this.data;
        } else if (d < this.data) {
            if (this.left != null) {
                return this.left.find(d);
            } else {
                return null;
            }
        } else {
            if (this.right != null) {
                return this.right.find(d);
            } else {
                return null;
            }
        }
    }

    public Node delete(Integer  el, Node node) {
        //Falta la implementación para cuando se quiere borrar la raíz.
        //TA COPY PASTEADO. PREGUNTAR DESPUES NASHEEEE
        if (node == null) {
            return null;
        }

        if (el.compareTo(node.data) > 0) {
            node.right = delete(el, node.right);
        } else if (el.compareTo(node.data) < 0) {
            node.left = delete(el, node.left);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            } else {
                node.data = findMax(node.left).data;
                node.left = delete(node.data, node.left);
            }
        }
        return node;
    }

    private Node findMax(Node node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }
    /**
     * Imprimir el arbol ordenando.
     */
    public void printInOrderBinaryTree() {
      
        if(left!=null){
            left.printInOrderBinaryTree();
        }

        System.out.println(data);

        if(right!=null){
            right.printInOrderBinaryTree();
        }
    }
    public void orderTreeAvl() {
        
        if(left!=null){
            left.printInOrderBinaryTree();
        }

        System.out.println(data);

        if(right!=null){
            right.printInOrderBinaryTree();
        }
    }
    
    public int depth(Node n) {

        if (n == null)
            return 0;

        int depthRight = this.depth(n.right);
        int depthLeft = this.depth(n.left);

        if (depthLeft > depthRight) {
            return 1 + depthLeft;
        } else {
            return 1 + depthRight;
        }
    }
    public void printAsTree(){
        System.out.println(data);
        if(left!=null){
            left.printAsTree(1);
        }

        if(right!=null){
            right.printAsTree(1);
        }
    }

    private void printAsTree(int i){
        for(int j=0;j<i;j++){
            if(i==1) System.out.print("├──");
            else if(j<i-1) System.out.print("│  ");
            else System.out.print("├── ");
        }
        if(this!=null){
            System.out.println(data);
            if(left!=null) left.printAsTree(i+1);
            if(right!=null) right.printAsTree(i+1);
        }
        else System.out.println();
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    //SECTOR AVL 
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public Avl randomAVL() {
        int cant;
        Avl avl = new Avl();
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        Integer temp;

        System.out.println("Arbol AVL aleatorio");
        System.out.println("Ingrese la cantidad de elementos del arbol AVL");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        for (int i = 0; i < cant; i++) {
           temp =ran.nextInt(100);
           System.out.print("\n" + i+1 + " Numero: " + temp);
           avl.add(temp);
        }
        System.out.print("\n");
        return avl;
    }

    public Avl manualAVL() {
        int cant, data;
        Avl avl = new Avl();
        Scanner sc = new Scanner(System.in);

        System.out.println("Arbol AVL manual");
        System.out.println("Ingrese la cantidad de total de los elementos del arbol AVL");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        System.out.println("Ingrese los valores del arbol AVL:");

        for (int i = 0; i < cant; i++) {
            System.out.print("\nValor: ");
            data = sc.nextInt();
            avl.add(data);
        }

        return avl;
    }
    
}