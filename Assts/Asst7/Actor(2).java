/**
 * @author Sam Dale 
 * @version 2/18/2014
 * AP Computer Science
 */
public class Actor extends Artist
{
	private boolean thespian;
	private int numPlays;

	public Actor(String lastName, String firstName, Address home1, Address home2, String phone, double gpa, int yrsExp, boolean thespian, int numPlays)
	{
		super(lastName, firstName, home1, home2, phone, gpa, yrsExp);
		this.thespian=thespian;
		this.numPlays=numPlays;
	}
	
	/************************************************************************************************
	 * Getters
	 ***********************************************************************************************/
	public boolean getThespian()
	{
		return this.thespian;
	}
	public int getNumPlays()
	{
		return this.numPlays;
	}

	/************************************************************************************************
	 * Setters
	 ***********************************************************************************************/
	public void setThespian(boolean thespian)
	{
		this.thespian=thespian;
	}
	public void setNumPlays(int numPlays)
	{
		this.numPlays=numPlays;
	}

	/************************************************************************************************
	 * toString()
	 ***********************************************************************************************/
	public String toString()
	{
		String tmpThespian="";
		if (thespian)
			tmpThespian="Thespian.";
		else
			tmpThespian="Not a Thespian.";
		return super.toString()+"\n"+
			   "Actor: "+"\n"+
			   "\t"+tmpThespian+"\n"+
			   "\tNumber of plays: "+numPlays;
	}
}
