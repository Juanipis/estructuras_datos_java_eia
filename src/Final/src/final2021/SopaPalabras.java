package final2021;

import java.util.*;

public class SopaPalabras {
    
    // Complete    
    public ArrayList<String> todasPalabras(char[][] sopa) {
    	ArrayList<String> result = new ArrayList<>();
    	for (int i = 0; i < sopa.length; i++) {
    		char[] temp = new char[sopa[i].length];
    		recorrerSopaFil(temp,sopa,i,0);
    		String tempString = new String(temp);
    		result.add(tempString);
    		result.add(new StringBuilder(tempString).reverse().toString());
    		
		}
    	for (int i = 0; i < sopa[0].length; i++) {
    		char[] temp = new char[sopa[i].length];
    		recorrerSopaCol(temp,sopa,0,i);
    		String tempString = new String(temp);
    		result.add(tempString);
    		result.add(new StringBuilder(tempString).reverse().toString());
		}
    	return result;
    }
    public void recorrerSopaFil(char[] arr,char[][] sopa, int fil, int col) {
    	if(col != sopa[fil].length) {
    		arr[col] = sopa[fil][col];
    		recorrerSopaFil(arr,sopa,fil,++col);
    	}
    }
    
    public void recorrerSopaCol(char[] arr,char[][] sopa, int fil, int col) {
    	if(col != sopa.length) {
    		arr[fil] = sopa[fil][col];
    		recorrerSopaCol(arr,sopa,++fil,col);
    	}
    }
        
    // Complete
    public PriorityQueue<String> palabrasContenidas(char[][] sopa, String[] palabras){
    	PriorityQueue<String> pr = new PriorityQueue<>();
    	ArrayList<String> lines = todasPalabras(sopa);
    	for(String pl : palabras) {
    		for(String act : lines) {
    			if(act.contains(pl)) {
    				pr.add(pl);
    			}
    		}
    	}
    	return pr;
    }

    public static void main(String[] args) {
    	SopaPalabras sopaP=new SopaPalabras();
    	char[][] matriz = {{'1','2','3'},{'4','5','6','7'},{'4','5','6','7','p'}};
    	String[] palabras = {"123"};
    	System.out.println(sopaP.palabrasContenidas(matriz, palabras));
//        Scanner in = new Scanner(System.in);
//        String line= in.nextLine();
//        String[] palabras=line.split(",");
//        ArrayList<String> s=new ArrayList<String>();
//        while ((line=in.nextLine()).compareTo("")!=0)
//            s.add(line);
//        char[][] sopa= new char[s.size()][];
//        for (int i=0;i<s.size();i++)
//            sopa[i]=s.get(i).toCharArray();
//        SopaPalabras sopaP=new SopaPalabras();
//        PriorityQueue<String> p=sopaP.palabrasContenidas(sopa,palabras);
//        while (!p.isEmpty())
//            System.out.println(p.poll());
//        in.close();

    }

}
