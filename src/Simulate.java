public class Simulate {
	
	
	private static int maskUsePers;
	private static int immunePers;
	private static double humanInfP;
	private static double humanSpaceP;
	private static double movingP;
	
	public Simulate() {
		this(0,0,0,0,0);
	}
	
	public Simulate(int mask, int immune, double humanInf, double spaceInf, double moving){
		maskUsePers=mask;
		immunePers=immune;
		humanInfP=humanInf;
		humanSpaceP=spaceInf;
		movingP=moving;	
	}
		
}

