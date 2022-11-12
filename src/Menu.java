
import java.util.Scanner;

import Nodo.Avl;
import Nodo.Node;
import Funciones.CrearNodo;
import java.io.PrintStream;

public class Menu {
    
    public static void ShowMenu() throws Exception{
        Node<Integer> nodo = new Node<>();
        Avl<Integer> avl = new Avl<>();
        int opcion;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese primer nodo (a preguntar despues): ");

        do{
        System.out.println("\n-----------------------------------");
        System.out.println("Ingrese el tipo de arbol a trabajar:");
        System.out.println("-----------------------------------");
        System.out.println("[1] Arbol Abb");
        System.out.println("[2] Arbol Avl");
        System.out.println("[3] Arbol Monticulo");
        System.out.println("[0] Salir");
        System.out.println("-----------------------------------");

        opcion = scanner.nextInt();
        switch(opcion){
            
            case 1: // Arbol abb
            do{
            
                System.out.println("\n-----------------------------------");
                System.out.println("Arbol Abb");
                System.out.println("-----------------------------------");
                System.out.println("[1] Agregar nodos por teclado");
                System.out.println("[2] Agregar nodos aleatorio");
                
                if(nodo.getRaiz() == null){
                System.out.println("[#] Crear arbol para mas opciones");
                }else {
                    System.out.println("[3] Mostrar arbol ordenado");
                    System.out.println("[4] Mostrar arbol con formato");
                };
                
                System.out.println("[5] Volver");
                System.out.println("-----------------------------------");

                opcion = scanner.nextInt();
                System.out.println("-----------------------------------\n");

                switch(opcion){
                    case 1:
                    case 2:
                        CrearNodo.creadorNodos(opcion, nodo);
                    break;
                    
                    case 3:
                    if(nodo.getRaiz() == null){
                        System.out.println("Opcion no valida");
                        }else {
                            nodo.printInOrder();
                        };
                       
                    break;

                    case 4:
                    if(nodo.getRaiz() == null){
                        System.out.println("Opcion no valida");
                        }else {
                            nodo.printTree(nodo);
                        };
                        
                        break;
                    case 5:
                         System.out.println("Volviendo al menu...");
                        break;

                    default:
                        System.out.println("Dale pibe pone bien los numeritos.");
                    break;
                    }
                }while (opcion!=5);
            break;
            
            case 2:// Arbol Avl
                do{
                System.out.println("\n-----------------------------------");
                System.out.println("Arbol Avl");
                System.out.println("-----------------------------------");
                System.out.println("[1] Agregar nodos por teclado");
                System.out.println("[2] Agregar nodos aleatorio");
                
                if(avl.isEmpty()){
                    System.out.println("[#] Crear arbol para mas opciones");
                    }else {
                        System.out.println("[3] Mostrar arbol ordenado");
                        System.out.println("[4] Mostrar arbol con formato");
                    };
                    
                System.out.println("[5] Volver");
                System.out.println("-----------------------------------");
               
                opcion = scanner.nextInt();
                System.out.println("-----------------------------------\n");

                switch(opcion){
                    case 1:
                        avl = CrearNodo.randomAVL();
                        break;

                    case 2:
                        avl = CrearNodo.manualAVL();
                        break;
                        
                    case 3:
                    if(avl.isEmpty()){
                        System.out.println("Opcion no valida");
                        }else {
                            avl.printInOrderAvl();
                        };
                       
                        break;

                    case 4:
                    if(avl.isEmpty()){
                        System.out.println("Opcion no valida");
                        }else {
                        avl.printTreeAvl(new PrintStream(System.out));
                        };
                       
                        break;
                    case 5:
                         System.out.println("Volviendo al menu...");
                        break;
                    }
                }while (opcion!=5);
            break;
            
            case 3: // Arbol Monticulo
                do{
                System.out.println("\n-----------------------------------");
                System.out.println("Arbol Monticulo");
                System.out.println("-----------------------------------");
                System.out.println("[1] Agregar nodos por teclado");
                System.out.println("[2] Agregar nodos aleatorio");

                if(avl.isEmpty()){//CAMBIAR POR MONTICULO EMPTY DESPUES
                    System.out.println("[#] Crear arbol para mas opciones");
                    }else {
                        System.out.println("[3] Mostrar arbol ordenado");
                        System.out.println("[4] Mostrar arbol con formato");
                    };
                System.out.println("[5] Volver");
                System.out.println("-----------------------------------");

                opcion = scanner.nextInt();
                System.out.println("-----------------------------------\n");
                switch(opcion){
                    case 1:
                    
                        break;

                    case 2:
                        
                        break;
                        
                    case 3:
                    /*if( ){
                        System.out.println("Opcion no valida");
                        }else {
                        
                        };
                       
                    
                    
                        */
                        break;
                        
                    case 4:
                         /*if( ){
                        System.out.println("Opcion no valida");
                        }else {
                        
                        };
                       
                    
                    
                        */
                        break;
                    case 5:
                        System.out.println("Volviendo al menu...");
                       break;
                    }
                }while (opcion!=5);
            break;
            }
        }while (opcion!=0);
    }
}