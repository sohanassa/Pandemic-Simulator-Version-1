public class Healthy extends Human {
  private boolean immune;
  private double PossibilityofInfectiion;
  
  
	public Healthy(boolean immune, boolean mask, double PossibilityofInfectiion) {
		super(mask);
		this.immune=immune;
		this.PossibilityofInfectiion=calcPossibilityofInfection(PossibilityofInfectiion);
	}
	
	private double calcPossibilityofInfection(double p) {
		if(immune)
			return 0;
		if(getMask())
			return p/2;
		return p;
	}
	public boolean getImmune() {
		return immune;
	}
	public double getPossibilityOfInfection(){
		return PossibilityofInfectiion;
	}
	
	 public double getPossibilityToInfect() {
		return 0;
	}
	public String toString() {
	   String S=super.toString();
	   S+="Human is healthy with a "+(getPossibilityOfInfection()*100)+'%'+" of getting infected";
	   return S;
	}
	
	
}
