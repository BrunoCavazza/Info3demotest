
import java.util.Scanner;

import Nodo.Avl;
import Nodo.MonticuloMax;
import Nodo.MonticuloMin;
import Nodo.Node;
import Funciones.CrearNodo;
import java.io.PrintStream;

public class Menu {
    
    public static void ShowMenu() throws Exception{
        Node<Integer> nodo = new Node<>();
        Avl<Integer> avl = new Avl<>();
        MonticuloMax<Integer> montMax = new MonticuloMax<>();
        MonticuloMin<Integer> montMin = new MonticuloMin<>();
        int opcion;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese primer nodo (a preguntar despues): ");

        do{
        System.out.println("\n-----------------------------------");
        System.out.println("Ingrese el tipo de arbol a trabajar:");
        System.out.println("-----------------------------------");
        System.out.println("[1] Arbol Abb");
        System.out.println("[2] Arbol Avl");
        System.out.println("[3] Arbol Monticulo (Maximo)");
        System.out.println("[4] Arbol Monticulo (Minimo)");
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
                            throw new Exception("Opcion no valida.");
                        }else {
                            nodo.printInOrder();
                        };
                       
                    break;

                    case 4:
                    if(nodo.getRaiz() == null){
                            throw new Exception("Opcion no valida.");
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
                        CrearNodo.randomAVL(avl);
                        break;

                    case 2:
                        CrearNodo.manualAVL(avl);
                        break;
                        
                    case 3:
                        if(avl.isEmpty()){
                            throw new Exception("Opcion no valida.");
                        }else {
                            avl.printInOrderAvl();
                        };
                       
                        break;

                    case 4:
                        if(avl.isEmpty()){
                            throw new Exception("Opcion no valida.");
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
            
            case 3: // Arbol Monticulo con raiz MAXIMO
                do{
                System.out.println("\n-----------------------------------");
                System.out.println("Arbol Monticulo Maximo");
                System.out.println("-----------------------------------");
                System.out.println("[1] Agregar nodos por teclado");
                System.out.println("[2] Agregar nodos aleatorio");

                if(montMax.isEmpty()){//CAMBIAR POR MONTICULO EMPTY DESPUES
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
                        CrearNodo.manualMontMax(montMax);
                        break;

                    case 2:
                        CrearNodo.randomMontMax(montMax);
                        break;
                        
                    case 3:
                        if(montMax.isEmpty()){
                            throw new Exception("Opcion no valida.");
                        }else {
                            montMax.printSort();
                        };
                        break;
                        
                    case 4:
                        if(montMax.isEmpty()){
                            throw new Exception("Opcion no valida.");
                        }else {
                            System.out.println(montMax.printSortFormat(0,""));
                        };
                        break;
                    case 5:
                        System.out.println("Volviendo al menu...");
                       break;
                    }
                }while (opcion!=5);

            case 4: // Arbol Monticulo con raiz MINIMO
                do{
                    System.out.println("\n-----------------------------------");
                    System.out.println("Arbol Monticulo Minimo");
                    System.out.println("-----------------------------------");
                    System.out.println("[1] Agregar nodos por teclado");
                    System.out.println("[2] Agregar nodos aleatorio");

                    if(montMin.isEmpty()){//CAMBIAR POR MONTICULO EMPTY DESPUES
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
                            CrearNodo.manualMontMin(montMin);
                            break;

                        case 2:
                            CrearNodo.randomMontMin(montMin);
                            break;

                        case 3:
                            if(montMin.isEmpty()){
                                throw new Exception("Opcion no valida.");
                            }else {
                                montMin.printSort();
                            };
                            break;

                        case 4:
                            if(montMin.isEmpty()){
                                throw new Exception("Opcion no valida.");
                            }else {
                                System.out.println(montMin.printSortFormat(0,""));
                            };
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