public abstract class Human {
  private boolean mask;
  private double pmove;
  
 
  public Human(boolean mask,double pmove) {
	  this.mask=mask;
	  this.pmove=pmove;
	  
  }
  
  public boolean getMask() {
	  return this.mask;
  }
  public double getPmove() {
	  return this.pmove;
  }
  abstract public double getPossibilityOfInfection();
 
  abstract public double getPossibilityToInfect();
  

	public static void main(String[] args) {
		// TODO Auto-generat  ed method stub

	}
	
	

}
