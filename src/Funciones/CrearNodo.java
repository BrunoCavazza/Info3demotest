package Funciones;
import Nodo.MonticuloMax;
import Nodo.MonticuloMin;
import Nodo.Node;
import Nodo.Avl;
import java.util.Scanner;
import java.util.Random;

public class CrearNodo {

    public static void creadorNodos(int tipo, Node<Integer> nodo){
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
    public static void randomAVL(Avl<Integer> avl) {
        int cant;
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        Integer temp;

        System.out.println("Arbol AVL aleatorio");
        System.out.println("Ingrese la cantidad a agregar aleatoriamente en arbol AVL");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        for (int i = 0; i < cant; i++) {
           temp =ran.nextInt(100);
           System.out.print("\n" + (i+1) + " Numero: " + temp);
           avl.add(temp);
        }
        System.out.print("\n ----------------------------------------");
        System.out.print("\n");
    }

    public static void manualAVL(Avl<Integer> avl) {
        int cant, data;
        Scanner sc = new Scanner(System.in);

        System.out.println("Arbol AVL manual");
        System.out.println("Ingrese la cantidad total a agregar en arbol AVL");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        System.out.println("Ingrese los valores del arbol AVL:");

        for (int i = 0; i < cant; i++) {
            System.out.print("\nValor: ");
            data = sc.nextInt();
            avl.add(data);
        }
    }

    public static void manualMontMax(MonticuloMax<Integer> mont){
        int cant, data;
        Scanner sc = new Scanner(System.in);
        System.out.println("Monticulo Maximo manual");
        System.out.println("Ingrese la cantidad total a agregar en Monticulo Maximo");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        System.out.println("Ingrese los valores al Monticulo Maximo:");

        for (int i = 0; i < cant; i++) {
            System.out.print("\nValor: ");
            data = sc.nextInt();
            mont.add(data);
        }
    }

    public static void manualMontMin(MonticuloMin<Integer> mont){
        int cant, data;
        Scanner sc = new Scanner(System.in);
        System.out.println("Monticulo Minimo manual");
        System.out.println("Ingrese la cantidad total a agregar en Monticulo Minimo");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        System.out.println("Ingrese los valores al Monticulo Minimo:");

        for (int i = 0; i < cant; i++) {
            System.out.print("\nValor: ");
            data = sc.nextInt();
            mont.add(data);
        }
    }

    public static void randomMontMax(MonticuloMax<Integer> mont) {
        int cant;
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        Integer temp;

        System.out.println("Arbol Monticulo Maximo aleatorio");
        System.out.println("Ingrese la cantidad a agregar aleatoriamente en arbol de Monticulo Maximo");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        for (int i = 0; i < cant; i++) {
            temp = ran.nextInt(100);
            System.out.print("\n" + (i+1) + " Numero: " + temp);
            mont.add(temp);
        }
        System.out.print("\n ----------------------------------------");
        System.out.print("\n");
    }

    public static void randomMontMin(MonticuloMin<Integer> mont) {
        int cant;
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        Integer temp;

        System.out.println("Arbol Monticulo Minimo aleatorio");
        System.out.println("Ingrese la cantidad a agregar aleatoriamente en arbol de Monticulo Minimo");
        System.out.print("\nCantidad: ");
        cant = sc.nextInt();

        for (int i = 0; i < cant; i++) {
            temp = ran.nextInt(100);
            System.out.print("\n" + (i+1) + " Numero: " + temp);
            mont.add(temp);
        }
        System.out.print("\n ----------------------------------------");
        System.out.print("\n");
    }
}
