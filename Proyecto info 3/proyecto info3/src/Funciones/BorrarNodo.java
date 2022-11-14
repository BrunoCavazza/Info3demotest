package Funciones;
import Nodo.Node;
import java.util.Scanner;

public class BorrarNodo {
    public static void borrarNodo(Node<Integer> nodo){
        int borrado;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese valor a borrar: ");
        try {
            nodo.delete(scanner.nextInt());
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }

    }
}
