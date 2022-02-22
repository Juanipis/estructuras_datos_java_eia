package quiz;

import java.util.*;


class NoHayBarrio extends Exception{
    public NoHayBarrio(){
        super("El barrio no ha reciclado vidrio");
    }
}

// Complete todo lo que necesiten estas clases
abstract class PaqueteReciclaje{
    private String barrio;
    private double kg;
    private boolean aceptable;
    private double kgmalos; // kg que clasificaron mal o no tienen buen estado
    
    public PaqueteReciclaje(String barrio, double kg, boolean aceptable, double kgmalos) {
        super();
        this.barrio = barrio;
        this.kg = kg;
        this.aceptable = aceptable;
        this.kgmalos = kgmalos;
    }
    
    public String getBarrio(){
        return this.barrio;
    }
    
    public boolean getAceptable(){
        return this.aceptable;
    }
    
    public double getKg(){
        return this.kg;
    }
    
}

class PaqueteVidrio extends PaqueteReciclaje{  
    private double kgVerde;
    private double kgAmbar;
    private double kgIncoloro;
    
    public PaqueteVidrio(String barrio, double kg, boolean aceptable, double kgmalos, double kgVerde, double kgAmbar, double kgIncoloro){
        super(barrio, kg, aceptable, kgmalos);
        this.kgVerde = kgVerde;
        this.kgAmbar = kgAmbar;
        this.kgIncoloro = kgIncoloro;
    }
    
    public double getKgVerde(){
        return this.kgVerde;
    }
     public double getKgAmbar(){
        return this.kgAmbar;
    }
     public double getKgIncoloro(){
        return this.kgIncoloro;
    }
    
}

class PaquetePlastico extends PaqueteReciclaje{
    private double kgDuro;
    private double kgBlando;
    
    public PaquetePlastico(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro, double kgBlando){
        super(barrio, kg, aceptable, kgmalos);
        this.kgDuro = kgDuro;
        this.kgBlando = kgBlando;
    }
    
    public double getKgDuro(){
        return this.kgDuro;
    }
}

class PaqueteCarton extends PaqueteReciclaje{
    public PaqueteCarton(String barrio, double kg, boolean aceptable, double kgmalos){
        super(barrio, kg, aceptable, kgmalos);
    }
}

class UnidadReciclaje{
    private PaqueteReciclaje[] paquetes;
    NoHayBarrio errNoBarrio = new NoHayBarrio();
    
    public UnidadReciclaje(PaqueteReciclaje[] paquetes) {
        this.paquetes = paquetes;
    }

    // buscarPaquetes de vidrio de un barrio determinado y devolver el total de kgAmbar, kgVerde, kgIncoloro, en ese orden
    public double [] buscarPaqueteVidrio(String barrio) throws NoHayBarrio{
        boolean existeBarrio = false;
        double [] totalVidrios = new double[3];
        for(PaqueteReciclaje pq : this.paquetes){
            if(pq != null && pq.getBarrio().equalsIgnoreCase(barrio)){  
                existeBarrio = true;
                if(pq.getAceptable() && pq instanceof PaqueteVidrio){ 
                    totalVidrios[0] = totalVidrios[0] + pq.getKgAmbar();
                    totalVidrios[1] = totalVidrios[1] + pq.getKgVerde();
                    totalVidrios[2] = totalVidrios[1] + pq.getKgIncoloro();
                }
            }
        }
        if(existeBarrio){
            return totalVidrios;
        } else{
            throw errNoBarrio;
        } 
    }
    
    // Lista barrios sin repetir en el orden de aparicion que estan en la lista de paquetes
    public String[] barriosConPaquetes() {
        String[] brrPaquetes = new String[0];
        for(PaqueteReciclaje pq : this.paquetes){
            if(pq != null){
                boolean existeBarrio = false;
                for(String brr : brrPaquetes){
                    if(pq.getBarrio().equals(brr)){
                        existeBarrio = true;
                    }
                }
                if(!existeBarrio){
                    brrPaquetes = Arrays.copyOf(brrPaquetes, brrPaquetes.length+1);
                    brrPaquetes[brr.brrPaquetes.length-1] = pq.getBarrio();
                }
            }
        }
        return brrPaquetes;
    }
    
    
    // Lista de kg buenos para cada uno de los barrios
    public double[] kgPorBarrios() {
        String [] barrios = this.barriosConPaquetes();
        double [] kgBarrios = new double[barrios.length];
        for(PaqueteReciclaje pq : this.paquetes){
            if(pq != null){
                for(int i = 0; i < barrios.length; i++){
                    if(pq.getBarrio().equalsIgnoreCase(barrios[i])){
                        kgBarrios[i] = kgBarrios[i] + pq.getKg();
                    }
                }
            }
        }
        return kgBarrios;
    }
    
    public double[] kgPlasticoDuro() {
        String [] barrios = this.barriosConPaquetes();
        double [] kgPlastico = new double[barrios.length];
        for(PaqueteReciclaje pq : this.paquetes){
            if(pq != null && pq instanceof PaquetePlastico){
                for(int i = 0; i < barrios.length; i++){
                    if(pq.getBarrio().equalsIgnoreCase(barrios[i])){
                        kgPlastico[i] = kgPlastico[i] + pq.getKgDuro();
                    }
                }
            }
        }
        return kgPlastico;
    
    }
}
public class Quiz1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);        
        String ejercicio=in.nextLine();
        String barrio = null;
        if (ejercicio.equals("0"))
            barrio=in.nextLine();
        String line;
        PaqueteReciclaje[] paquetes=new PaqueteReciclaje[0];
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(" ");
            paquetes=Arrays.copyOf(paquetes, paquetes.length+1);
            //PaqueteVidrio(String barrio, double kg, boolean aceptable, double kgmalos, double kgIncoloro, double kgVerde, double kgAmbar)
            if (lineSplit[0].equals("V"))
                paquetes[paquetes.length-1]=new PaqueteVidrio(lineSplit[1], Float.parseFloat(lineSplit[2]), 
                        Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]), Float.parseFloat(lineSplit[5]), Float.parseFloat(lineSplit[6]), Float.parseFloat(lineSplit[7]));
            
            //PaquetePlastico(String barrio, double kg, boolean aceptable, double kgmalos, double kgDuro, double kgBlando)
            if (lineSplit[0].equals("P"))
                paquetes[paquetes.length-1]=new PaquetePlastico(lineSplit[1], Float.parseFloat(lineSplit[2]), 
                        Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]), Float.parseFloat(lineSplit[5]), Float.parseFloat(lineSplit[6]));
            if (lineSplit[0].equals("C"))
                paquetes[paquetes.length-1]=new PaqueteCarton(lineSplit[1], Float.parseFloat(lineSplit[2]), 
                        Boolean.parseBoolean(lineSplit[3]), Float.parseFloat(lineSplit[4]));
            
        }
        UnidadReciclaje u=new UnidadReciclaje(paquetes);
        if (ejercicio.equals("0")) {
            try{
                double [] pvidrio= u.buscarPaqueteVidrio(barrio); //El metodo buscar paquetes de vidrio
                for (int i=0;i<pvidrio.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(pvidrio[i]);            
                }
            } catch(NoHayBarrio e){
                System.out.println(e.getMessage());
            }
            
            System.out.println();
        }else if (ejercicio.equals("1.0")) {
            //Barrios
            String[] barrios=u.barriosConPaquetes();
            System.out.print("Barrios: ");
            for (int i=0;i<barrios.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(barrios[i]);            
            }
            System.out.println();
        }
        else if (ejercicio.equals("1.1")) {
            //Barrios y kgs totales
            String[] barrios=u.barriosConPaquetes();
            double[] kgsBarrios= u.kgPorBarrios();
            System.out.print("Barrios: ");
            for (int i=0;i<barrios.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(barrios[i]+"-"+kgsBarrios[i]);            
            }
            System.out.println();
        }else if (ejercicio.equals("1.2")) {
            //Barrios y kgs de plastico duro
            String[] barrios=u.barriosConPaquetes();
            double[] kgsBarrios= u.kgPlasticoDuro();
            System.out.print("Barrios: ");
            for (int i=0;i<barrios.length;i++) {
                if (i!=0)
                    System.out.print(", ");
                System.out.print(barrios[i]+"-"+kgsBarrios[i]);            
            }
            System.out.println();
        }
        
        in.close();
    }
}