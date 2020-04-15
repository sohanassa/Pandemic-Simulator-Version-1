
public class Healthy extends Human {
  private boolean immune;
  private double PossibilityofInfection;
  
  
	public Healthy(boolean immune, boolean mask) {
		super(mask);
		this.immune=immune;
		this.PossibilityofInfection=calcPossibilityofInfection();
	}
	
	private double calcPossibilityofInfection() {
		if(immune)
			return 0;
		if(getMask())
			return 1/2;
		return 1;
	}
	public boolean getImmune() {
		return immune;
	}
	public double getPossibilityOfInfection(){
		return PossibilityofInfection;
	}
	
	 public double getPossibilityToInfect() {
		return 0;
	}
	 
	public String toString() {
	   String S=super.toString();
	   S+= "and is healthy, with a "+(getPossibilityOfInfection()*100)+'%'+" of getting infected";
	   return S;
	}
	
	
}
