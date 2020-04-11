public abstract class Human {
  private boolean mask;
  private double pmove;
  
 
  public Human(boolean mask,double pmove) {
	  this.mask=mask;
	  this.pmove=pmove;
	  
  }
  
  
  public boolean getmask() {
	  return this.mask;
  }
  public double getpmove() {
	  return this.pmove;
  }
  abstract public double getPossibilityofInfectiion();
 
  abstract public double getPossibiltytoInfect();
  

	public static void main(String[] args) {
		// TODO Auto-generat  ed method stub

	}
	
	

}
