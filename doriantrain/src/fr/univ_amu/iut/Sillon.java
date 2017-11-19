package fr.univ_amu.iut;

public class Sillon 
{
	private static final int COUT_PAR_DEFAULT = 50;
	
	boolean libre;
	Train leTrainQuiOccupeCeSillon;
	private int coututilisation;
	private boolean etatIncident;

	public Sillon() {
		libre = true;
		leTrainQuiOccupeCeSillon = null;
		coututilisation = COUT_PAR_DEFAULT;
		etatIncident = false;
	}
	
	void setTrain(Train leTrain)
	{
		leTrainQuiOccupeCeSillon = leTrain;
		libre = false;
	}
	
	void libere()
	{
		libre = true;
		leTrainQuiOccupeCeSillon = null;
	}
	
	public int getCoututilisation() {
        return coututilisation;
    }
	
	public void setCoututilisation (int cout)
	{
		this.coututilisation = cout;
	}
	 
	

}
