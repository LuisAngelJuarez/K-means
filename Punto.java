/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kMeans;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author luis
 */
public class Punto {
    private ArrayList<Double> Coordenadas;
    
    public Punto(ArrayList<Double> cord){//crea un punto con las coordenadas
        Coordenadas=cord;
    }
    
    public Punto(int Dim){//crea punto aleatorio de tamaño Dim
        Coordenadas=new ArrayList<Double>();
        Random  rnd = new Random();
        for(int i=0;i<Dim;i++)
        {
            Coordenadas.add(rnd.nextDouble());
        }
    }
    
    public String toString() {
        int Dim;
        String cadena="[";
        Dim=Coordenadas.size();
        for(int i=0;i<Dim;i++){
            cadena+=Coordenadas.get(i);
            cadena+=" ";
        }
            cadena+="]";
        return cadena;
    }
    
    public void setPunto(ArrayList<Double> cord){//crea un punto con las coordenadas
        Coordenadas=cord;
    }
    
    public double Distancia(Punto a){
        int N;
        double dist = 0;
        N=a.getCoordenadas().size();
        for(int i=0;i<N;i++){
            dist+=Math.pow(Coordenadas.get(i)-a.getCoordenadas().get(i),2);
        }
            dist=Math.sqrt(dist);
        return dist;
    }
    public ArrayList<Double> getCoordenadas(){
        return Coordenadas;
    }
}