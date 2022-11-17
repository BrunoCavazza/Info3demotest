package Nodo;

import java.util.Arrays;

public class MonticuloMin <Anytype extends Comparable<Anytype>> {
    private Anytype monticulo[];
    private int posicion = -1; //indice para el ULTIMO valor, siempre empieza en -1 (vacio)

    public MonticuloMin(){
        monticulo = (Anytype[]) new Comparable[2]; //capacidad inicial predefinida, que se va a ir duplicando a medida sea necesario
    }

    public MonticuloMin<Anytype> add(Anytype data){
        if(isFull()){
            resize(2*monticulo.length); //el que incrementa el tamaño del array
        }
        monticulo[++posicion] = data;
        arregladoAscendente(); //cambiado de valores. el mayor siempre es padre de 2 valores menores
        return this; //devuelve todo el arbol
    }

    private boolean isFull(){
        return posicion == monticulo.length-1; //check si la posicion del ultimo elemento es igual al tamaño del arrray (significa que esta lleno)
    }

    public Anytype getMin() throws Exception {
        if(isEmpty()){
            throw new Exception("No hay arbol. No se puede realizar la operacion.");
        }
        return monticulo[0];
    }
    private void resize(int capacidad){
        System.arraycopy(monticulo,0,monticulo= (Anytype[]) new Comparable[capacidad] , 0, posicion+1);
        //esta cosa esta re dura pero ayuda a aumentar el tamaño. basicamente pasas el array
        //pasas un new array con el nuevo tamaño, y el posicion+1 que
        //es donde va a empezar a agregar el proximo array
    }

    private void arregladoAscendente(){ //te va reacomodando los valores hacia arriba
        int indice=posicion;
        int padre=(indice-1)/2;
        while( padre>=0 && monticulo[indice].compareTo(monticulo[padre])<0 ){
            cambio(indice, padre);
            indice = padre;
            padre = (indice-1/2);
        }
    }
    private void cambio(int indice, int padre){
        Anytype aux = monticulo[indice];
        monticulo[indice] = monticulo[padre];
        monticulo[padre] = aux;
    }


    public Anytype borrarMin(){
        if(isEmpty()){
            return null;
        }
        Anytype valor = monticulo[0];
        monticulo[0] = monticulo[posicion--];
        monticulo[posicion+1]= null;

        arregladoDescendente(posicion);
        return valor;
    }

    private void arregladoDescendente(int ultimoIndice){ //te va reacomodando los valores hacia abajo
        if(ultimoIndice==-1) return;
        int indice=0;
        while(indice <= ultimoIndice){
            int idIzq = 2*indice+1;
            int idDer= 2*indice+2;
            if(idIzq>ultimoIndice) break; //fuera de array si esto sucede, por eso el break
            int hijoPaCambiar= idDer>ultimoIndice? idIzq : monticulo[idIzq].compareTo(monticulo[idDer])<0 ? idIzq:idDer;
            //condiciones:
            //  si el indice derecha es mas grande que ultimo indice, entonces tengo que ir por el de la izquierda, porque no lo puedo elegir
            //  si tanto izquierda(visto en el break) y derecha(visto en el primer condicional) son mas chicos que el indice dado (ambos indices estan dentro de array), entonces:
            //              si el compareTo da mayor a 0 es porque el de izquierda es mas grande que el de derecha, asi que elijo el de izquierda
            //              si el compareTo da menor a 0 es porque el de izquierda es mas chico que el de derecha, asi que elijo el de derecha
            if(monticulo[indice].compareTo(monticulo[hijoPaCambiar])<0) break; //si el valor en el indice es mas grande que el child que toco, entonces hago break (no hay cambios que hacer)
            cambio(indice, hijoPaCambiar);//aca cambio si todo lo anterior funciono bien
            indice=hijoPaCambiar; //el hijopacambiar es el indice de cambio, por eso se lo reacomodo al indice
        }
    }
    public boolean isEmpty(){
        return monticulo.length==0;
    }

    public void printSort(){ //este printea en orden, ta medio buggiado preguntar
        for (int i = 0; i <= posicion; i++) {
            cambio(0,posicion-i);
            arregladoDescendente(posicion-1-i);
        }
        Arrays.stream(monticulo).forEach(System.out::println);//esto es un print nomas

    }

    public String printSortFormat(int indice, String prefix) {
        String salida = "";

        if (indice != 0) salida = prefix + "└──";

        if (indice <= monticulo.length - 1) {
            boolean isLeaf = indice > monticulo.length / 2;

            if (monticulo[indice] != null) salida += monticulo[indice] + "\n";
            else salida += "\n";

            String _prefix = prefix;

            if (indice != 0){
                if (indice % 2 == 1)
                    _prefix += "│  "; // one | and two spaces
                else
                    _prefix += "   "; // three spaces
            }


            if (!isLeaf) {
                salida += printSortFormat(2 * indice + 1, _prefix);
                salida += printSortFormat(2 * indice + 2, _prefix);
            }
        } else
            salida += "\n";

        return salida;
    }


}
