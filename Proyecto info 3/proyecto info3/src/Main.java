import java.util.Scanner;

import Funciones.BorrarNodo;
import Nodo.Node;
import Funciones.CrearNodo;

public class Main {
    public static void main(String[] args) throws Exception {
        Node<Integer> nodo = new Node<>();
        int opcion;
        //Avl avl;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese primer nodo (a preguntar despues): ");
        System.out.println("Ingrese opcion de menu:");
        do{
            System.out.println(" 1- Agregar nodos por teclado\n 2- Agregar nodos aleatorio\n 3- Mostrar arbol ordenado\n 4- Mostrar arbol con formato\n 5- Borrar nodo\n 6- Agregar nodos manual AVL\n 0- Salir");
            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                case 2:
                    CrearNodo.creadorNodos(opcion, nodo);
                    break;
                case 3:
                    try {
                        nodo.printInOrder();
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 4:
                    try {
                        nodo.printTree();
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 5:
                    try {
                        BorrarNodo.borrarNodo(nodo);
                    } catch (Exception e) {
                        System.out.print(e.getMessage());
                    }
                    break;
                case 6:
                    //avl = nodo.manualAVL();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Dale pibe poneme bien los numeritos.");
                    break;
            }
        }while (opcion!=0);
    }
}