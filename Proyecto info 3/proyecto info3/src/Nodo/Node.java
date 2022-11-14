package Nodo;

public class Node <Integer extends Comparable<Integer>> {
    //la interface comparable es para hacer un T de cualquier tipo y que posea el compareTo
    private Integer data;
    private Node<Integer> left;
    private Node<Integer> right;
    private Node<Integer> raiz;

    private Node(Integer data){
        this.data=data;
    }
    public Node(){

    }
    public boolean isEmpty(){
        return raiz==null;
    }

    public void printTree() throws Exception {
        if (isEmpty())
            throw new Exception("No hay arbol. No se puede mostrar.");
        else {
            System.out.println(raiz.getData());
            if(raiz.getLeft()!=null){
                raiz.getLeft().printTree(1);
            }
            if(raiz.getRight()!=null){
                raiz.getRight().printTree(1);
            }
        }
    }
    private void printTree(int i){
        for(int j=0;j<i;j++){
            if(i==1) System.out.print("├── ");
            else if(j<i-1) System.out.print("│  ");
            else System.out.print("├── ");
        }
        System.out.println(data);
        if(left!=null) left.printTree(i+1);
        if(right!=null) right.printTree(i+1);
    }

    public void printInOrder() throws Exception {
        if(isEmpty())
            throw new Exception("No hay arbol. No se puede mostrar.");
        else
            printInOrder(raiz);
    }
    private void printInOrder(Node<Integer> node) throws Exception{
        if(node!=null){
            printInOrder(node.getLeft());
            System.out.println(node.getData());
            printInOrder(node.getRight());
        }
    }

    public void add(Integer data){
        if(isEmpty()){
            raiz = new Node<>(data);
        }else{
            add(data, raiz);
        }

    }

    private void add(Integer data, Node<Integer> node){
        if (data.compareTo(node.getData())<0) { //lado izquierdo
            if (node.getLeft() == null) {
                Node<Integer> newNode = new Node<>(data);
                node.setLeft(newNode);
            } else {
                add(data, node.getLeft());
            }
        } else if(data.compareTo(node.getData())>0){ //lado derecho
            if (node.getRight()==null) {
                Node<Integer> newNode = new Node<>(data);
                node.setRight(newNode);
            } else {
                add(data, node.getRight());
            }
        }

    }

    public void delete(Integer data) throws Exception {
        if(isEmpty())
            throw new Exception("No hay arbol. No se puede borrar.");
        else{
            raiz = delete(data, raiz); //guarda el nodo obtenido del delete en la raiz
        }
    }

    private Node<Integer> delete(Integer data, Node<Integer> node) throws Exception {
        if(node == null) {
            return null;
        }
        if(data.compareTo(node.getData())<0){
            node.setLeft(delete(data, node.getLeft())); //va buscando por izquierda hasta que la condicion no se cumpla
        }else if(data.compareTo(node.getData())>0){
            node.setRight(delete(data, node.getRight())); //va buscando por derecha hasta que la condicion no se cumpla
        }else if (data.compareTo(node.getData())==0){ //cuando ninguna de las 2 condiciones se cumple, es porque o llegue al valor, o no. si llegue:
            System.out.println("Valor encontrado.");
            //CUANDO HAY 1 SOLO HIJO, CHECKEA SI ES NULL EN IZQ O DER:
            if(node.getLeft()==null)
                return node.getRight();
            else if(node.getRight()==null)
                return node.getLeft();
            //CUANDO EL NODO TIENE HIJO EN DERECHA E IZQUIERDA:
            node.setData(getMax(node.getLeft())); //busca el maximo valor de la izquierda, que es mas chico que todos los de la derecha, pero mas grande de los de izq
            node.setLeft(delete(node.getData(), node.getLeft()));
        }else { //si no es menor, mayor ni igual, es porque ni existe
            throw new Exception("El valor no se ha encontrado.");
        }
        return node;
    }

    private Integer getMax(Node<Integer> node){
        if(node.getRight()!=null){
            return getMax(node.getRight());
        }
        return node.getData();
    }

    private Node<Integer> getLeft() {
        return left;
    }
    private void setLeft(Node<Integer> left){
        this.left=left;
    }

    private Node<Integer> getRight(){
        return right;
    }
    private void setRight(Node<Integer> right){
        this.right=right;
    }

    private Integer getData() {
        return data;
    }
    private void setData(Integer data){
        this.data = data;
    }

}
