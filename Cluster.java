/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kMeans;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class Cluster {
    private final int K;      //k=Numero de clases
    private final int N;      //N=Numero de dimensiones
    private List<List <Punto> > Clase = new ArrayList<List <Punto>>();//guarda los puntos de las clases
    private List<Punto > Centroides= new ArrayList<Punto>();//guarda los centroides de las clases
    
    public Cluster(int K, int N,ArrayList<Punto> vectorPuntos){ //k=Numero de clases, N=numero de dimensiones
        int numDatos;
        this.K=K;
        this.N=N;
        numDatos=vectorPuntos.size();
        for(int i=0;i<K;i++)
        {
            //se añade a la clase, un arreglo de Puntos
            Clase.add(new ArrayList<Punto>());
            //Se escoge como centroide un punto aleatorio de dimension N
            Centroides.add(new Punto(N));
        }
        for(int i=0;i<numDatos;i++)
        {
            addPunto(vectorPuntos.get(i));
        }
    }
    
    public String toString() {
        int numClases;
        int numPuntos;
        String cadena="";
        numClases=Clase.size();
        for(int i=0;i<numClases;i++){
            cadena+="\n Clase "+Integer.toString(i)+":\n \n";
            numPuntos=Clase.get(i).size();
            cadena+="[";
            for(int j=0;j<numPuntos;j++){
                cadena+=Clase.get(i).get(j);
                cadena+="\n";
            }
            cadena+="]";
        }
            
        return cadena;
    }
    
    public void Itera(){
        int M;
        int CMC;//Clase mas cercana
        double x, y;
        ArrayList<Double> Coordenada;
        int contador=0;
        do{
        contador=0;
        for(int i=0;i<K;i++)    //recorrido por las clases
        {
            M=Clase.get(i).size();
            for(int j=0;j<M;j++)    //recorrido por los elementos de la clase i
            {
                CMC=claseMasCercana(Clase.get(i).get(j));//obtiene la clase mas cercana al punto j de la clase i
                if(CMC!=i){
                    Coordenada=Clase.get(i).get(j).getCoordenadas();
                    Clase.get(i).remove(j);
                    Clase.get(CMC).add(new Punto(Coordenada));
                    M=Clase.get(i).size();
                    contador++;
                }
            }
        }
        }while(contador!=0);
    }
    
    private void addPunto(Punto newPunto)
    {
        int j;
        j=claseMasCercana(newPunto);
        Clase.get(j).add(newPunto);
        calculaCentroide(j);
    }
    
    private int claseMasCercana(Punto newPunto){
        double menor;
        double distancia;
        int j=0;//j indica la posicion de la clase mas cercana
        menor=newPunto.Distancia(Centroides.get(0));//distancia entre el nuevo punto y el centroide
        for(int i=1;i<K;i++){
            distancia=newPunto.Distancia(Centroides.get(i));
            if(distancia<menor){
                menor=distancia;
                j=i;
            }
        }
        return j;
    }
    
    private void calculaCentroide(int i){//calcula centroide de la clase i
        int numEl=Clase.get(i).size();//numero de elementos de la lista en cuestion
        double aux;
        ArrayList<Double> Coordenada=new ArrayList<Double>();
        Punto Centroide;
        
        for(int j=0;j<N;j++)    //for para el numero de dimensiones
        {
            aux=0;
            for(int k=0;k<numEl;k++){       //for para el numero de elementos
                //elemento de clase i, elemento k,coordenada j
                aux+=Clase.get(i).get(k).getCoordenadas().get(j)/numEl;
            }
            Coordenada.add(aux);
        }
        Centroide=new Punto(Coordenada);
        Centroides.set(i, Centroide);
    }
}