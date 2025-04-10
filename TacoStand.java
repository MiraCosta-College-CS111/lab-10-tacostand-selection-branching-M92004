public class TacoStand
{
    /* CONSTANT VARIABLES */
	public static final String BAR = "----------------------------------------";
	public static final int ASADA_OPTION = 1, POLLO_OPTION = 2, LENGUA_OPTION = 3, ULTIMATE_OPTION = 4;

	/* STATIC VARIABLES */
	private static int numAsada = 0, numPollo = 0, numLengua = 0, numUltimate = 0;
	private static double totalFunds = 0;

	/**
	 * Sets the store to zero for use in automated testing.
	 */
	public static void initialize()
	{
		numAsada = numPollo = numLengua = numUltimate = 0;
		totalFunds = 0.0D;
	}

	/**
	 * Outputs menu options (kinds of tacos) customer can use to order
	 */
	public static void printMenu()
	{
		System.out.println("Menu options:\n" + TacoStand.BAR);
		System.out.printf("%2d. %-21s [$%5.2f]%n", 1, "Carne Asada (Steak)", 2.5);
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
      "# of Asada Left:", TacoStand.numAsada,
			"# of Pollo Left:", TacoStand.numPollo,
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
	 * no variables are changed.
	 * 
	 * @param budget funds to use to order supplies
	 * 
	 * @return boolean representing if supplies could be ordered (within total funds)
	 */
	public static boolean orderSupplies(double budget)
	{
		if(budget <= TacoStand.totalFunds){
		
		//tacos cost 75 cents each in supplies, keeping it simple
	    int tacosEach = (int)(Math.round(budget / 0.75 / 4));

	    TacoStand.totalFunds -= budget; //similarly: totalFunds=totalFunds-budget;

	    TacoStand.numAsada += tacosEach;
	    TacoStand.numPollo += tacosEach;
	    TacoStand.numLengua += tacosEach;
	    TacoStand.numUltimate += tacosEach;

		return true; //you can also set a variable = true/false here
	}
		else
	{ 
		return false;
	}
		
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
		double cost; //now declared throughout whole method
	//ALGORITHM
	//CALC totalFunds += tacoOption cost (varying costs depending on option) * numTacos
	//CALC (four diff variables) tacoOption count -= numTacos
	switch(tacoOption){
		case 1: //runs option/case and displays below until it hits {}
		//asada
		cost = 2.5; //asada price //if dble cost: declared this variable within this block (switch stmt) that will only be used here
		TacoStand.numAsada -= numTacos; //Updated numAsada after purchase calculate for ea. case
		break; //BUT that's what the break statement is here for :3
		case 2: //it stops the switch from running after specific case is chosen
		//pollo 	//keeping it relevant
		cost = 1.75; //pollo price
		TacoStand.numPollo -= numTacos;
		break;
		case 3: //if using constant (that was initialized in comments for ex) you can make it case TacoStand.POLLO_OPTION
		//lengua //^^ self-documenting code
		cost = 3.0;
		TacoStand.numLengua -= numTacos;
		break;
		case 4:
		//ultimate
		cost = 18.0;
		TacoStand.numUltimate -= numTacos;
		break;
		default:
		//error
		cost = 0;
		break;
		}
		//calc customer's cost outside of switch stmt
		TacoStand.totalFunds += cost*numTacos;
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
	
		//complex boolean:
		return (tacoOption == TacoStand.ASADA_OPTION && numTacos <= TacoStand.numAsada) ||
				(tacoOption == TacoStand.POLLO_OPTION && numTacos <= TacoStand.numPollo)||
				(tacoOption == TacoStand.LENGUA_OPTION && numTacos <= TacoStand.numLengua)||
				(tacoOption == TacoStand.ULTIMATE_OPTION && numTacos <= TacoStand.numUltimate);
	
		//if else approach
		/* 
		if(	(tacoOption == TacoStand.ASADA_OPTION && numTacos <= TacoStand.numAsada)||
			(tacoOption == TacoStand.POLLO_OPTION && numTacos <= TacoStand.numPollo)||
			(tacoOption == TacoStand.LENGUA_OPTION && numTacos <= TacoStand.numLengua)||
			(tacoOption == TacoStand.ULTIMATE_OPTION && numTacos <= TacoStand.numUltimate)){

			return true;
		}
		else{
			return false;
		}
	
		//multiway if approach w/ AND: return true if any (OR) of the 4 "available scenarios"
		if(tacoOption == TacoStand.ASADA_OPTION){
			return numTacos <= TacoStand.numAsada;
		}
		else if(tacoOption == TacoStand.POLLO_OPTION){
			return numTacos <= TacoStand.numPollo;
		}
		else if(tacoOption == TacoStand.LENGUA_OPTION){
			return numTacos <= TacoStand.numLengua;
		}
		else if(tacoOption == TacoStand.ULTIMATE_OPTION){
			return numTacos <= TacoStand.numUltimate;
		}
		else{
			return false;
		}


		//swith approach
		/* 
		switch(tacoOption){
			case TacoStand.ASADA_OPTION:
				return numTacos <= TacoStand.numAsada;
				break;
				*/ //rest of cases
				// ...
				// default:
				//	return false;
				
		}
	}