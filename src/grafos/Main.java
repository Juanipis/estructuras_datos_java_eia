package grafos;

import java.util.Stack;

public class Main {

	public static void main(String[] args) {
		Vertice<Integer> v1= new Vertice<Integer>(1);
        Vertice<Integer> v2= new Vertice<Integer>(2);
        Vertice<Integer> v3= new Vertice<Integer>(3);
        Vertice<Integer> v4= new Vertice<Integer>(4);
        Vertice<Integer> v5= new Vertice<Integer>(5);
        Vertice<Integer> v6= new Vertice<Integer>(6);
        Vertice<Integer> v7= new Vertice<Integer>(7);
        Arista<Integer> a12= new Arista<Integer>(v2, 3);
        Arista<Integer> a13= new Arista<Integer>(v3, 10);
        Arista<Integer> a14= new Arista<Integer>(v4, 7);
        Arista<Integer> a25= new Arista<Integer>(v5, 8);
        Arista<Integer> a24= new Arista<Integer>(v4, 2);
        Arista<Integer> a36= new Arista<Integer>(v6, 5);
        Arista<Integer> a47= new Arista<Integer>(v7, 3);
        Arista<Integer> a57= new Arista<Integer>(v7, 1);
        Arista<Integer> a67= new Arista<Integer>(v7, 1);
        Arista<Integer> a46= new Arista<Integer>(v6, 1);
        v1.getAdyacentes().add(a12);v1.getAdyacentes().add(a14);v1.getAdyacentes().add(a13);
        v2.getAdyacentes().add(a25);v2.getAdyacentes().add(a24);
        v3.getAdyacentes().add(a36);
        v4.getAdyacentes().add(a47);v4.getAdyacentes().add(a46);
        v5.getAdyacentes().add(a57);
        v6.getAdyacentes().add(a67);
        Grafo<Integer> grafo= new Grafo<Integer>();
        grafo.getVertices().add(v1);
        grafo.getVertices().add(v2);
        grafo.getVertices().add(v3);
        grafo.getVertices().add(v4);
        grafo.getVertices().add(v5);
        grafo.getVertices().add(v6);
        grafo.getVertices().add(v7);
        
        Stack<Vertice<Integer>> s;

 

        s = grafo.MenorCaminoSinPesos(v1, v7);
		grafo.imprimirCamino(s);
		System.out.println(v7.getDistance());
		//s=grafo.dijkstra(v1, v7);
		grafo.imprimirCamino(s);
		System.out.println(v7.getDistance());
		//s=grafo.dijkstra(1, 7);
		grafo.imprimirCamino(s);
		System.out.println(v7.getDistance());

	}

}
