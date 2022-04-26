package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Main {
	  
    public static void main(String[] args) {
        String numeros = "37";
        String comparador = "307";
        ArrayList<Integer> numerosCon = new ArrayList<>();
        int contador = 0;
        for (int i = 100; i <= 999; i++) {
			if(losTiene(Integer.toString(i))) {
				contador++;
				numerosCon.add(i);
			}
		}
        System.out.println(numerosCon);
        System.out.println(numerosCon.size());
        System.out.println(contador);
    }
    public static boolean losTiene(String msg) {
    	boolean cond1 = false;
    	boolean cond2 = false;
    	for(int i = 0; i < msg.length() ; i++) {
    		if(msg.charAt(i) == '3') {
    			cond1 = true;
    		}
    		if(msg.charAt(i)== '7') {
    			cond2 = true;
    		}
    	}
    	return cond1 && cond2;
    	
    }
}