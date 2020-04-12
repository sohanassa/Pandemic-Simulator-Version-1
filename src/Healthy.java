public class Healthy extends Human {
  private boolean immune;
  private double PossibilityofInfectiion;
  
  
	public Healthy(boolean immune, boolean mask, double Pmove,double PossibilityofInfectiion) {
		super(mask,Pmove);
		this.immune=immune;
		this.PossibilityofInfectiion=calcPossibilityofInfection(PossibilityofInfectiion);
	}
	
	private double calcPossibilityofInfection(double p) {
		if(immune)
			return 0;
		if(getmask())
			return p/2;
		return p;
	}
	public boolean getimmune() {
		return immune;
	}
	public double getPossibilityofInfectiion(){
		return PossibilityofInfectiion;
	}
	
	 public double getPossibiltytoInfect() {
		return 0;
	}
	
	
	
}
