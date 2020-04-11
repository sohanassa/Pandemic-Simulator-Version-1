
import edu.princeton.cs.introcs.StdDraw;

public class Grid {

	private int length;
	private int width;
	
	public Grid(int length,int width) {
		this.length=length;
		this.width=width;
	}
	
	public void drawgrid() {
		 StdDraw.setXscale(-1,length+1);                               
         StdDraw.setYscale(-1,width+1);
		for(int i=0;i<=this.length;i++) {                                
        	
   		 StdDraw.setPenRadius(0.2/(length*2));
   		 StdDraw.setPenColor(StdDraw.BLACK);
   		 StdDraw.line(0.0,0.0+i,0.0+length,0.0+i);
   		StdDraw.line(0.0+i,0.0,0.0+i,0.0+width);
   		 
   	   
   		
   	 
    }
		/*for(int i=0;i<=this.length;i++) {                                
        	
	   		 StdDraw.setPenRadius(0.2/(length*2));
	   		 StdDraw.setPenColor(StdDraw.BLACK);
	   		
	   		 StdDraw.line(0.0+i,0.0,0.0+i,0.0+width);
	   	     
	   	 
	    }*/
  
	}
	public static void main(String[] args) {
		Grid a=new Grid(20,10);
		a.drawgrid();
		
	}
}

