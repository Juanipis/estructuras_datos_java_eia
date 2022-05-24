package final20221;

import java.util.*;

class Video implements Comparable<Video>{
    private String autor;
    private String id;
    private int me_gusta;
    private int visualizaciones;
    private int comentarios;
    
    public Video(String autor, String id, int me_gusta, int visualizaciones, int comentarios) {
        super();
        this.autor = autor;
        this.id = id;
        this.me_gusta = me_gusta;
        this.visualizaciones = visualizaciones;
        this.comentarios = comentarios;
    }
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    
    public int getMe_gusta() {
        return me_gusta;
    }
    public void setMe_gusta(int me_gusta) {
        this.me_gusta = me_gusta;
    }
    public int getVisualizaciones() {
        return visualizaciones;
    }
    public void setVisualizaciones(int visualizaciones) {
        this.visualizaciones = visualizaciones;
    }
    public int getComentarios() {
        return comentarios;
    }
    public void setComentarios(int comentarios) {
        this.comentarios = comentarios;
    }
    @Override
    public String toString() {
        return  autor + ":"+ me_gusta ;
    }
    @Override
    public int compareTo(Video arg0) {
        if((this.getVisualizaciones() - arg0.getVisualizaciones()) != 0) {
            return arg0.getVisualizaciones() - this.getVisualizaciones();
        }else if ( (this.getMe_gusta() - arg0.getMe_gusta()) !=0){
            return arg0.getMe_gusta() - this.getMe_gusta();
        }else {
            return arg0.getComentarios() - this.getComentarios();
        }
        
    }
}




public class Tiktok {
    
    public Video[] videoOrdenado(Video[] videos) {
        PriorityQueue<Video> cola = new PriorityQueue<>();
        Video[] result = new Video[videos.length];
        for(Video vid : videos) {
            cola.add(vid);
        }
        for (int i = 0; i < result.length; i++) {
            result[i] = cola.poll(); 
        }
        return result;
        
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line;
        Video[] videos=new Video[0];
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] lineSplit=line.split(",");
            Video v=new Video(lineSplit[0],lineSplit[1], Integer.parseInt(lineSplit[2]),
                    Integer.parseInt(lineSplit[3]), Integer.parseInt(lineSplit[4]));
            videos=Arrays.copyOf(videos, videos.length+1);
            videos[videos.length-1]=v;
        }
        Tiktok t=new Tiktok();
        Video[] videosO=t.videoOrdenado(videos);
        for (Video v:videosO)
            System.out.println(v);
        in.close();
    
    }

}