import java.util.Scanner;

import Nodo.Avl;
import Nodo.Node;
import Funciones.CrearNodo;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) throws Exception {

        Node<Integer> nodo = new Node<>();
        Avl<Integer> avl = new Avl<>();
        int opcion;
        Scanner scanner = new Scanner(System.in);


        System.out.print("Ingrese primer nodo (a preguntar despues): ");
        System.out.println("Ingrese opcion de menu:");
        do{
            System.out.println(" 1- Agregar nodos por teclado\n 2- Agregar nodos aleatorio\n 3- Mostrar arbol ordenado\n 4- Mostrar arbol con formato\n 5- Agregar nodos aleatorio AVL\n 6- Agregar nodos manual AVL\n 7- Ordenados avl\n 8- Dibujo Avl\n 0- Salir");
            opcion = scanner.nextInt();

            switch(opcion){
                case 1:
                case 2:
                    CrearNodo.creadorNodos(opcion, nodo);
                    break;
                case 3:
                    nodo.printInOrder();
                    break;
                case 4:
                    nodo.printTree(nodo);
                    break;
                case 5:
                    avl = CrearNodo.randomAVL();
                    break;
                case 6:
                    avl = CrearNodo.manualAVL();
                    break;
                case 7:
                    avl.printInOrderAvl();
                    break;
                case 8:
                    avl.printTreeAvl(new PrintStream(System.out));
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Dale pibe pone bien los numeritos.");
                    break;
            }
        }while (opcion!=0);
    }
}