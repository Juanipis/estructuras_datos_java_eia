/*Juan Pablo Díaz Correa @Juanipis*/
package semana1;

public class NComplejo{
	  private double PReal;
	  private double PImag;
	  
	  /*Constructor*/ /*
	  public NComplejo(double PReal, double PImag) {
		  this.PReal = PReal;
		  this.PImag = PImag;
	  }
	  */
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
	    else if(PReal < 0) {
	    	if(PImag >=0) {
	    		return Math.atan2(PImag, PReal) + Math.PI;
	    	} 
	    	else { /*PImag <0*/
	    		return Math.atan2(PImag, PReal) - Math.PI;
	    	}
	    }
	    
	    else if(PReal == 0 && PImag!=0) {
	    	if(PImag > 0) {
	    		return Math.PI/2;
	    	}
	    	/*PImag < 0*/
	    	else {
	    		return -Math.PI/2;
	    	}
	    }

	    /*PImag == 0 && PReal == 0*/
	    else {
	    	return Double.NaN;
	    }
	    
	    
	  }
	}


