import Funciones.CrearNodo;
import com.clases.clase4.Node;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Node nodo = new Node();
        int opcion;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese primer nodo (a preguntar despues): ");
        nodo.addFirstValue(scanner.nextInt());
        System.out.println("Ingrese opcion de menu:");
        do{
            System.out.println(" 1- Agregar nodos por teclado\n 2- Agregar nodos aleatorio\n 3- Mostrar arbol ordenado\n 4- Mostrar arbol con formato\n 0- Salir");
            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                case 2:
                    CrearNodo.creadorNodos(opcion, nodo);
                    break;
                case 3:
                    nodo.printInOrderBinaryTree();
                    break;
                case 4:
                    nodo.printAsTree();
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