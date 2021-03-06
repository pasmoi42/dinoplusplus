package fr.univ_amu.iut;

public class Sillon 
{
	//private static final int COUT_PAR_DEFAULT = 50;
	
	private boolean libre;
	private Train leTrainQuiOccupeCeSillon;
	private double position;	//0.1 = 10min , centaine de minute

	private int coututilisation;
	private boolean etatIncident;
	int heure;
	LigneFerroviaire ligneDeCeSillon;

	public Sillon(int paramHeure, int cout, LigneFerroviaire aQuiIlAppartient) {
		libre = true;
		leTrainQuiOccupeCeSillon = null;
		coututilisation = cout;
		etatIncident = false;
		position = -1;
		heure = paramHeure;
		ligneDeCeSillon = aQuiIlAppartient;
	}
	
	public boolean estLibre()
	{
		return libre;
	}
	
	public Train getTrain()
	{
		return leTrainQuiOccupeCeSillon;
	}
	
	public void setTrain(Train leTrain)
	{
		leTrainQuiOccupeCeSillon = leTrain;
		libre = false;
		leTrain.memoriseReservationDeSillon(this);
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
