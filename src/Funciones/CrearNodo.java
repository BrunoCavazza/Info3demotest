package Funciones;
import java.util.Scanner;
import com.clases.clase4.Node;

public class CrearNodo {
    public static void creadorNodos(int tipo, Node nodo){
        Scanner scanner = new Scanner(System.in);
        int contador=0, max, min, random;
        if (tipo == 1){
            System.out.print("Ingrese cantidad de nodos a agregar a mano: ");
            contador = scanner.nextInt();
            for (int i = 0; i < contador; i++) {
                System.out.print("Ingrese nodo: ");
                nodo.add(scanner.nextInt());
            }
        }
        if(tipo==2){
            System.out.print("Ingrese maximo valor posible: ");
            max = scanner.nextInt();
            System.out.print("Ingrese minimo valor posible: ");
            min = scanner.nextInt();
            System.out.print("Ingrese cantidad a agregar: ");
            contador = scanner.nextInt();
            System.out.println("Ingresando valores aleatorios...");
            for (int i = 0; i < contador; i++) {
                random = (int)Math.floor(Math.random()*(max-min+1) + min);
                System.out.println("Agregando "+random+".");
                nodo.add(random);
            }

        }

    }
}
