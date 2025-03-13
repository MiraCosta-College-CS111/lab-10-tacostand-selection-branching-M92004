public class TacoStand
{
    /* CONSTANT VARIABLES */ //public static final int NUMASADA = 0;
	public static final String BAR = "----------------------------------------";
	public static final String NUMASADA = String.format("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", 2.5);
	public static final String NUMPOLLO = String.format("%2d. %-21s [$%5.2f]%n", 2, "Pollo Asado (Chicken)", 1.75);
	public static final String 

	/* STATIC (to constant) VARIABLES */
	//public static int NUMASADA = 0, NUMPOLLO = 0, numLengua = 0, numUltimate = 0;
	//public static double totalFunds = 0;

	/**
	 * Sets the store to zero for use in automated testing.
	 */
	public static void initialize()
	{
		NUMASADA = NUMPOLLO = numLengua = numUltimate = 0;
		totalFunds = 0.0D;
	}

	/**
	 * Outputs menu options (kinds of tacos) customer can use to order
	 */
	public static void printMenu()
	{
		System.out.println("Menu options:\n" + TacoStand.BAR);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", 2.5); //replace w/ TacoStand.NUMASADA like the one above//
		System.out.printf("%2d. %-21s [$%5.2f]%n", 2, "Pollo Asado (Chicken)", 1.75);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 3, "Lengua (Beef Tongue)", 3.0);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 4, "Ultimate Taco", 18.0);
		System.out.println(TacoStand.BAR);
	}
	
	/**
	* Returns a summary (all static variables) of the CURRENT status of the taco stand
	*
	* @return String containing current values related to taco stand, no new line at end
	*/
	public static String getStatus()
	{
		return String.format("%s%nMCC Taco Stand Status%n%s%n" +
			"%-23s$%-7.2f%n%s%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n" +
			"%-23s%2d tacos%n%s",
			TacoStand.BAR, TacoStand.BAR, 
      "Funds Available:", TacoStand.totalFunds, TacoStand.BAR,
      "# of Asada Left:", TacoStand.NUMASADA,
			"# of Pollo Left:", TacoStand.NUMPOLLO,
      "# of Lengua Left:", TacoStand.numLengua,
      "# of Ultimate Left:",TacoStand.numUltimate, TacoStand.BAR);
	}

	/**
	 * Increases totalFunds static variable
	 * 
	 * @param funds assumes >0 value added to total funds available for cart
	 */
	public static void addTotalFunds(int funds)
	{
		TacoStand.totalFunds += funds;
	}
	
	/**
	 * Checks if proposed budget to order supplies can be used to buy more supplies. If within total funds,
	 * will update total funds and increment number of each option of tacos based on budget. Otherwise,
	 * no variables are changed. (IF-ELSE OR IF-THEN STMT)
	 * 
	 * @param budget funds to use to order supplies
	 * 
	 * @return boolean representing if supplies could be ordered (within total funds)
	 */
	public static boolean orderSupplies(double budget)
	{
		if(budget<=totalFunds){
			int tacosEach = (int)(Math.round(budget / 0.75 / 4)); //update num of tacos

	    TacoStand.totalFunds -= budget;

	    TacoStand.NUMASADA += tacosEach;
	    TacoStand.NUMPOLLO += tacosEach;
	    TacoStand.numLengua += tacosEach;
	    TacoStand.numUltimate += tacosEach;
		return true;

		}
		else{
			return false;
		}
		//tacos cost 75 cents each in supplies, keeping it simple
	    //int tacosEach = (int)(Math.round(budget / 0.75 / 4)); //update num of tacos

	    //TacoStand.totalFunds -= budget;

	    //TacoStand.numAsada += tacosEach;
	    //TacoStand.numPollo += tacosEach;
	    //TacoStand.numLengua += tacosEach;
	    //TacoStand.numUltimate += tacosEach;

		//return true; 
	}

	/**
	 * Adds funds to total (static variable) based on kind of taco (different prices) and number of tacos
	 * in order. Will also update appropriate number of tacos left (static variables).
	 * 
	 * @param tacoOption menu option (kind of taco)
	 * @param numTacos number of tacos as part of order, assume > 0
	 */
	public static void updateTotalFunds(int tacoOption, int numTacos)
	{
		//TODO: this is stubbed, replace this line with your actual code!
	}
	
	
	/**
	 * Determines if taco order can be fullfilled (number of tacos for specific kinda are available)
	 * 
	 * @param tacoOption menu option (kind of taco)
	 * @param numTacos number of tacos as part of order
	 * 
	 * @return boolean representing if specific kind of tacos, for the number in order, are available
	 */
	public static boolean areTacosAvailable(int tacoOption, int numTacos)
	{
		return false; //TODO: this is stubbed, replace this line with your actual code!
	}
}