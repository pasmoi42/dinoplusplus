package fr.univ_amu.iut;

public class Sillon 
{
	private static final int COUT_PAR_DEFAULT = 50;
	
	private boolean libre;
	private Train leTrainQuiOccupeCeSillon;
	private double position;	//0.1 = 10min , centaine de minute

	private int coututilisation;
	private boolean etatIncident;

	public Sillon() {
		libre = true;
		leTrainQuiOccupeCeSillon = null;
		coututilisation = COUT_PAR_DEFAULT;
		etatIncident = false;
		position = -1;
	}
	
	public boolean estLibre()
	{
		return libre;
	}
	
	public void setTrain(Train leTrain)
	{
		leTrainQuiOccupeCeSillon = leTrain;
		libre = false;
	}
	
	public void libere()
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
