package fr.univ_amu.iut;

public class Sillon 
{
	boolean libre;
	Train leTrainQuiOccupeCeSillon;

	public Sillon() {
		libre = true;
		leTrainQuiOccupeCeSillon = null;
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

}
