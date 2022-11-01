package Nodo;

public class Node <T extends Comparable<T>> {
    //la interface comparable es para hacer un T de cualquier tipo y que posea el compareTo
    private T data;
    private Node<T> left;
    private Node<T> right;
    private Node<T> raiz;

    private Node(T data){
        this.data=data;
    }
    public Node(){

    }
    public boolean isEmpty(){
        return raiz==null;
    }

    public void printTreeOrder() throws Exception {
        printTree(raiz);
    }
    public void printTree(Node<T> node) throws Exception {
        if (isEmpty())
            throw new Exception("No hay arbol. No se puede mostrar.");
        else {
            System.out.println(data);
            if(left!=null){
                left.printTree(1);
            }
            if(right!=null){
                right.printTree(1);
            }
        }
    }
    private void printTree(int i){
        for(int j=0;j<i;j++){
            if(i==1) System.out.print("├── ");
            else if(j<i-1) System.out.print("│  ");
            else System.out.print("├── ");
        }
        if(this!=null){
            System.out.println(data);
            if(left!=null) left.printTree(i+1);
            if(right!=null) right.printTree(i+1);
        }
        else System.out.println();
    }

    public void printInOrder() throws Exception {
        if(isEmpty())
            throw new Exception("No hay arbol. No se puede mostrar.");
        else
            printInOrder(raiz);
    }
    private void printInOrder(Node<T> node) throws Exception{
        if(node!=null){
            printInOrder(node.getLeft());
            System.out.println(node.getData());
            printInOrder(node.getRight());
        }
    }

    public void add(T data){
        if(isEmpty()){
            raiz = new Node<>(data);
        }else{
            add(data, raiz);
        }

    }

    private void add(T data, Node<T> node){
        if (data.compareTo(node.getData())<0) { //lado izquierdo
            if (node.getLeft() == null) {
                Node<T> newNode = new Node<>(data);
                node.setLeft(newNode);
            } else {
                add(data, node.getLeft());
            }
        } else if(data.compareTo(node.getData())>0){ //lado derecho
            if (node.getRight()==null) {
                Node<T> newNode = new Node<>(data);
                node.setRight(newNode);
            } else {
                add(data, node.getRight());
            }
        }

    }

    public void delete(T data) throws Exception {
        if(isEmpty())
            throw new Exception("No hay arbol. No se puede borrar.");
        else{
            raiz = delete(data, raiz); //guarda el nodo obtenido del delete en la raiz
        }
    }

    private Node<T> delete(T data, Node<T> node) throws Exception {
        if(node == null) {
            return null;
        }
        if(data.compareTo(node.getData())<0){
            node.setLeft(delete(data, node.getLeft())); //va buscando por izquierda hasta que la condicion no se cumpla
        }else if(data.compareTo(node.getData())>0){
            node.setRight(delete(data, node.getRight())); //va buscando por derecha hasta que la condicion no se cumpla
        }else if (data.compareTo(node.getData())==0){ //cuando ninguna de las 2 condiciones se cumple, es porque o llegue al valor, o no. si llegue:
            //CUANDO HAY 1 SOLO HIJO, CHECKEA SI ES NULL EN IZQ O DER:
            if(node.getLeft()==null)
                return node.getRight();
            else if(node.getRight()==null)
                return node.getLeft();
            //CUANDO EL NODO TIENE HIJO EN DERECHA E IZQUIERDA:
            node.setData(getMax(node.getLeft())); //busca el maximo valor
            node.setLeft(delete(node.getData(), node.getLeft()));
        }else { //si no es menor, mayor ni igual, es porque ni existe
            throw new Exception("El valor no se ha encontrado.");
        }
        return node;
    }

    private T getMax(Node<T> node){
        if(node.getRight()!=null){
            return getMax(node.getRight());
        }
        return node.getData();
    }

    private Node<T> getLeft() {
        return left;
    }
    private void setLeft(Node<T> left){
        this.left=left;
    }

    private Node<T> getRight(){
        return right;
    }
    private void setRight(Node<T> right){
        this.right=right;
    }

    private T getData() {
        return data;
    }
    private void setData(T data){
        this.data = data;
    }

}
