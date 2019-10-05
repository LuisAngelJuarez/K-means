/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kMeans;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author luis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        //crearemos 3 clases de puntos separados
        ArrayList <Punto> Puntos = new ArrayList<Punto>();
        Random  rnd = new Random();
        
        //8 puntos alrededor de 8,8
        for(int i=0;i<10;i++){
            ArrayList<Double> Coordenadas =new ArrayList<Double>();
            Coordenadas.add(8.0+rnd.nextDouble());
            Coordenadas.add(8.0+rnd.nextDouble());
            Puntos.add(new Punto(Coordenadas));
        }
        //8 puntos alrededor de -8,8
        for(int i=0;i<10;i++){
            ArrayList<Double> Coordenadas =new ArrayList<Double>();
            Coordenadas.add(-8.0+rnd.nextDouble());
            Coordenadas.add(8.0+rnd.nextDouble());
            Puntos.add(new Punto(Coordenadas));
        }
        
        //8 puntos alrededor de 8,-8
        for(int i=0;i<10;i++){
            ArrayList<Double> Coordenadas =new ArrayList<Double>();
            Coordenadas.add(8.0+rnd.nextDouble());
            Coordenadas.add(-8.0+rnd.nextDouble());
            Puntos.add(new Punto(Coordenadas));
        }
        
        Cluster Cluster1=new Cluster(3,2, Puntos);//Cluster de 3 clases, 2 dimensiones
        Cluster1.Itera();           //Se corre el algoritmo
        System.out.print(Cluster1);//Se imprimen las clases del cluster
    }
    
}
