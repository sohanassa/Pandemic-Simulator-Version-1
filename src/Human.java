public class Human {
  private boolean mask;
  
 
  public Human(boolean mask) {
	  this.mask=mask;
	  
  }
  
  public boolean getMask() {
	  return this.mask;
  }
  public double getPossibilityOfInfection() {
	  return 0;
  }
 
  public double getPossibilityToInfect() {
	  return 0;
  }
  public String toString() {
	  String S="Human is ";
	  if(mask)
		  S+="wearing a mask ";
	  else
		  S+="not waring a mask ";
		  
	  return S;
  }
}
