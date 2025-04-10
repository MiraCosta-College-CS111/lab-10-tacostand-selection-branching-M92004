// PARTNER NAME:
// PARTNER NAME:
// CS111 SECTION #:
// DATE:

public class Main
{

	/**
	 * ALGORITHM:
	 * - Add total funds to taco stand
	 * - Order supplies
	 * - Print status of stand (when it opens)
	 * - Print welcome message
	 * - Take customer order
	 * - Print status of stand (when its closed)
	 */
	public static void main(String[] args)
	{
		//DECLARATION + INITIALIZATION SECTION
		TacoStand.initialize();

		//INPUT + CALCULATION + OUTPUT SECTION
		TacoStand.addTotalFunds(20);
		TacoStand.orderSupplies(15);

		System.out.println("OPENING UP THE STAND...");
		System.out.println( TacoStand.getStatus() +"\n\n");

		Main.printWelcome();
		System.out.println("\n");
		
		Main.takeOrder();
		//call takeOrder more times if you'd like! (once everything works once though!)

		System.out.println("\n--------CART IS CLOSED---------\n\n" + TacoStand.getStatus());
	}

	/**
	 * Outputs/prints welcome message to start program that user sees
	 */
	public static void printWelcome()
	{
		UtilityBelt.printCentered(50, "Welcome to MCC Taco Stand!");
		UtilityBelt.printCentered(50, "┈┈┈┈╭╯╭╯╭╯┈┈┈┈┈");
		UtilityBelt.printCentered(50, "┈┈┈╱▔▔▔▔▔╲▔╲┈┈┈");
		UtilityBelt.printCentered(50, "┈┈╱┈╭╮┈╭╮┈╲╮╲┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈▂▂▂▂▂┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈▏┈╲▂▂▂╱┈▕╮▕┈┈");
		UtilityBelt.printCentered(50, "┈┈╲▂▂▂▂▂▂▂▂╲╱┈┈");
		//ascii art credit:
		//https://mizbizbby.tumblr.com/post/12937794639/happy-taco-ascii-art-for-taco-thursday
	}
	
	/**
	 * Prints menu and prompts user for input for kind of taco and number in order. If tacos are available,
	 * will update t5o2tal funds and confirm order with user, otherwise error message given
	 */
	public static void takeOrder() 
	{
		//DECLARATION + INITIALIZATION SECTION
		int option, numTacosOrdered;

		//INPUT SECTION
		TacoStand.printMenu();
		option = UtilityBelt.readInt("Enter choice> ", 1, 4);
		numTacosOrdered = UtilityBelt.readInt("Enter number of tacos you want> ", 1, 50);

		//CALCULATION + OUTPUT SECTION
		if(TacoStand.areTacosAvailable(option, numTacosOrdered)){

		
		TacoStand.updateTotalFunds(option, numTacosOrdered);
		Main.printConfirmation(numTacosOrdered);
		}
		else
		{
			System.out.print("We don't have that many tacos, sorry! Try again :(");
		}

	}

	/**
	 * Prints confirmation message that varies based on number of tacos in order (low 1-2; medium 3-5, large 6*)
	 * 
	 * @param numTacos
	 */
	public static void printConfirmation(int numTacosOrdered)
	{
		System.out.println("Here you go, buen provecho!");
		for(int i=0;i<numTacosOrdered;i++){
			System.out.print("🌮");

		}
		System.out.print("\n");

		//System.out.println("🌮🌮🌮🌮🌮\n");

	}
}