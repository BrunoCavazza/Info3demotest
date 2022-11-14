package Nodo;

public class Node <AnyType extends Comparable<AnyType>> {
    //la interface comparable es para hacer un T de cualquier tipo y que posea el compareTo
    private AnyType data;
    public Node<AnyType> getRaiz() {
        return raiz;
    }
    public void setRaiz(Node<AnyType> raiz) {
        this.raiz = raiz;
    }

    private Node<AnyType> left;
    private Node<AnyType> right;
    private Node<AnyType> raiz;
    private int height = 1;//avl

    public Node(AnyType data){
        this.data=data;
        this.left = null;
        this.right = null;
    }
    public Node(){

    }
    public boolean isEmpty(){
        return raiz==null;
    }

    public void printTreeOrder() throws Exception {
        printTree(raiz);
    }
    public void printTree(Node<AnyType>    node) throws Exception {
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
    private void printInOrder(Node<AnyType> node) throws Exception{
        if(node!=null){
            printInOrder(node.getLeft());
            System.out.println(node.getData());
            printInOrder(node.getRight());
        }
    }

    public void add(AnyType data){
        if(isEmpty()){
            raiz = new Node<>(data);
        }else{
            add(data, raiz);
        }

    }

    private void add(AnyType data, Node<AnyType> node){
        if (data.compareTo(node.getData())<0) { //lado izquierdo
            if (node.getLeft() == null) {
                Node<AnyType> newNode = new Node<>(data);
                node.setLeft(newNode);
            } else {
                add(data, node.getLeft());
            }
        } else if(data.compareTo(node.getData())>0){ //lado derecho
            if (node.getRight()==null) {
                Node<AnyType> newNode = new Node<>(data);
                node.setRight(newNode);
            } else {
                add(data, node.getRight());
            }
        }

    }

    public void delete(AnyType data) throws Exception {
        if(isEmpty())
            throw new Exception("No hay arbol. No se puede borrar.");
        else{
            raiz = delete(data, raiz); //guarda el nodo obtenido del delete en la raiz
        }
    }

    private Node<AnyType> delete(AnyType data, Node<AnyType> node) throws Exception {
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

    public AnyType getMax(Node<AnyType> node){
        if(node.getRight()!=null){
            return getMax(node.getRight());
        }
        return node.getData();
    }

    public Node<AnyType> getLeft() {
        return left;
    }
    public void setLeft(Node<AnyType> left){
        this.left=left;
    }

    public Node<AnyType> getRight(){
        return right;
    }
    public void setRight(Node<AnyType> right){
        this.right=right;
    }

    public AnyType getData() {
        return data;
    }
    public void setData(AnyType data){
        this.data = data;
    }
 
    public int getHeight() {  //set-get avl
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
}


