public abstract class Human {
  private boolean mask;
  
 
  public Human(boolean mask) {
	  this.mask=mask;
	  
  }
  
  public boolean getMask() {
	  return this.mask;
  }
  abstract public double getPossibilityOfInfection();
 
  abstract public double getPossibilityToInfect();
  

	public static void main(String[] args) {
		// TODO Auto-generat  ed method stub

	}
	
	

}
