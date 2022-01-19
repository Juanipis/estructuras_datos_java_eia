package semana1;

public class NComplejo{
	  private double PReal;
	  private double PImag;

	  /*Setters*/
	  public void setPReal(double PReal){
	    this.PReal = PReal;
	  }
	  public void setPImag(double PImag){
	    this.PImag = PImag;
	  }

	  /*Getters*/
	  public double getPReal(){
	    return this.PReal;
	  }
	  public double getPImag(){
	    return this.PImag;
	  }

	  /*OP Complejos*/
	  public double getModulo(){
	    return Math.sqrt(Math.pow(PReal,2) + Math.pow(PImag, 2));
	  }

	  public double getArgumento(){
	    if(PReal > 0){
	      return Math.atan2(PImag, PReal);
	    }
	    else if(PImag >= 0 && PReal < 0){
	      return Math.atan2(PImag, PReal) + Math.PI;
	    }
	    else if(PImag < 0 && PReal < 0){
	      return Math.atan2(PImag, PReal) - Math.PI; 
	    }
	    else if(PImag > 0 && PReal == 0){
	      return Math.PI/2;
	    }
	    else if(PImag<0 && PReal==0){
	      return -Math.PI/2;
	    }
	    
	    /*PImag == 0 && PReal == 0*/
	    else {
	    	return Double.NaN;
	    }
	    
	    
	  }
	}


