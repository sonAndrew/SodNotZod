/** AUTHOR		:	[ Andrew Jackson ]
 *  COURSE		:	[ CPT 187 ]
 *  PURPOSE		:	[ To calculate and generate a receipt for your purchase at SodNotZod.]
 *  STARTDATE	:	[ 03/17/2020 ] **/

package edu.cpt187.jackson.participation2;

import java.util.Scanner;

public class MainClass {
	/////// CONSTANTS ///////
	//NEW Scanner OPEN
	public static Scanner input = new Scanner(System.in);
	public static final String[] MENU_OPTIONS = {"Create Order", "Quit"};
	public static final String[] MENU_CHARS = {"[A] for", "[Q] for"};
	
	public static void main(String[] args) {
		// LOCAL VARIABLES
		String userName = "";
		char menuSelection = ' ';
		
		SodOrder mySodOrder = new SodOrder();
		displayWelcomeBanner();
		userName = getUserName(input);
		menuSelection = validateMainMenu(input);
		while(menuSelection != 'Q') 
		{
			mySodOrder.setItemSelection(
					validateItemMenu(
							input, 
							mySodOrder.getItemNames(), 
							mySodOrder.getItemPrices()
							)
					);
			mySodOrder.setItemName();
			mySodOrder.setItemPrice();
			mySodOrder.setHowMany(validateHowMany(input));
			mySodOrder.setDiscountType(
					validateDiscountMenu(
							input, 
							mySodOrder.getDiscountNames(), 
							mySodOrder.getDiscountRates()
							)
					);
			mySodOrder.setDiscountName();
			mySodOrder.setDiscountRate();
			mySodOrder.setPrizeName();
			displayItemReceipt(
					mySodOrder.getItemName(), 
					mySodOrder.getItemPrice(), 
					mySodOrder.getHowMany(), 
					mySodOrder.getDiscountName(), 
					mySodOrder.getDiscountRate(), 
					mySodOrder.getDiscountAmt(), 
					mySodOrder.getDiscountPrice(), 
					mySodOrder.getSubTotal(), 
					mySodOrder.getTaxRate(), 
					mySodOrder.getTaxAmt(), 
					mySodOrder.getTotalCost(),
					mySodOrder.getPrizeName()
					);
			menuSelection = validateMainMenu(input);
		}
		if(mySodOrder.getTotalCost() > 0.0) 
		{
			displayFinalReport(
					mySodOrder.getItemNames(), 
					mySodOrder.getItemCounts(), 
					mySodOrder.getDiscountNames(), 
					mySodOrder.getDiscountCounts(),
					mySodOrder.getPrizeNames(),
					mySodOrder.getPrizeCounts()
					);
		}
		displayFarewellMessage();
	} // END - main
	public static void displayWelcomeBanner() 
	{
		// WELCOME BANNER
		System.out.println("Hello and welcome to your local home improvement store,");
		System.out.println("SodNotZod. We look forward to addressing all your needs.");
	} // END - displayWelcomeBanner
	public static void displayFarewellMessage() 
	{
		// FAREWELL MESSAGE
		System.out.println("Thanks for using the SodNotZod program to,");
		System.out.println("calculate your purchases. Until next time, come again.");
	} // END - displayFarewellMessage
	public static void displayItemMenu(String[] borrowedItemNames, double[] borrowedItemPrices) 
	{
		// ITEM MENU
		System.out.println("\nITEM SELECTION MENU");
		System.out.println("_____________________");
		System.out.printf("\n%-5s%-5s%-15s%s%-5.2f","[A]","for ",borrowedItemNames[0],"$",borrowedItemPrices[0]);
		System.out.printf("\n%-5s%-5s%-15s%s%-5.2f","[B]","for ",borrowedItemNames[1],"$",borrowedItemPrices[1]);
		System.out.printf("\n%-5s%-5s%-15s%s%-5.2f\n","[C]","for ",borrowedItemNames[2],"$",borrowedItemPrices[2]);
	} // END - displayItemMenu
	public static void displayDiscountMenu(String[] borrowedDiscountNames, double[] borrowedDiscountRates) 
	{
		// DISCOUNT MENU
		System.out.println("\nDISCOUNT SELECTION MENU");
		System.out.println("_____________________");
		System.out.printf("\n%-5s%-5s%-15s%-5.2f%s","[A]","for ",borrowedDiscountNames[0],borrowedDiscountRates[0],"%");
		System.out.printf("\n%-5s%-5s%-15s%-5.2f%s","[B]","for ",borrowedDiscountNames[1],borrowedDiscountRates[1],"%");
		System.out.printf("\n%-5s%-5s%-15s%-5.2f%s\n","[C]","for ",borrowedDiscountNames[2],borrowedDiscountRates[2],"%");
	} // END - displayDiscountMenu
	public static void displayFinalReport(String[] borrowedItemNames, int[] itemCounts, String[] borrowedDiscountNames, int[] discountCounts, String[] borrowedPrizeNames, int[] prizeCounts) 
	{
		System.out.println("~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~");
		System.out.println("FINAL REPORT");
		System.out.println("~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~");
		System.out.printf("\n%-25s%-10s%-5s", borrowedItemNames[0], "count: ", itemCounts[0]);
		System.out.printf("\n%-25s%-10s%-5s", borrowedItemNames[1], "count: ", itemCounts[1]);
		System.out.printf("\n%-25s%-10s%-5s\n", borrowedItemNames[2], "count: ", itemCounts[2]);
		
		System.out.printf("\n%-25s%-10s%-5s", borrowedDiscountNames[0], "count: ", discountCounts[0]);
		System.out.printf("\n%-25s%-10s%-5s", borrowedDiscountNames[1], "count: ", discountCounts[1]);
		System.out.printf("\n%-25s%-10s%-5s\n", borrowedDiscountNames[2], "count: ", discountCounts[2]);
		
		System.out.printf("\n%-25s%-10s%-5s", borrowedPrizeNames[0], "count: ", prizeCounts[0]);
		System.out.printf("\n%-25s%-10s%-5s", borrowedPrizeNames[1], "count: ", prizeCounts[1]);
		System.out.printf("\n%-25s%-10s%-5s\n", borrowedPrizeNames[2], "count: ", prizeCounts[2]);
		System.out.println("~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~");
	} // END - displayFinalReport
	public static void displayItemReceipt(String borrowedItemName, double borrowedItemPrice, int borrowedHowMany, String borrowedDiscountName, double borrowedDiscountRate, double borrowedDiscountAmt, double borrowedDiscountPrice, double borrowedSubTotal, double borrowedTaxRate, double borrowedTax, double borrowedTotalCost, String prizeName) 
	{
		// LOCAL VARIABLES
		String localUserName = getUserName(input);
		System.out.println("~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~");
		System.out.println("ORDER REPORT");
		System.out.println("~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~");
		System.out.printf("\n%-25s%-5s\n", "Customer Name: ", localUserName);
		
		System.out.printf("\n%-25s%-5s", "Item Name: ", borrowedItemName);
		System.out.printf("\n%-25s%-5s%-5.2f\n", "Item Price: ", "$", borrowedItemPrice);
		
		System.out.printf("\n%-25s%-5s\n", "Discount Name: ", borrowedDiscountName);
		
		System.out.printf("\n%-30s%-5.2f%-2s", "Discount Rate: ", borrowedDiscountRate, "%");
		System.out.printf("\n%-25s%-5s%-5.2f", "Discount Amount: ", "$", borrowedDiscountAmt);
		System.out.printf("\n%-25s%-5s%-5.2f\n", "Discount Price: ","$", borrowedDiscountPrice);

		System.out.printf("\n%-25s%-5d\n", "Quantity: ", borrowedHowMany);
		
		System.out.printf("\n%-25s%-5s%-5.2f", "Subtotal: ", "$", borrowedSubTotal);
		System.out.printf("\n%-30s%-5.1f%-1s", "Tax Rate: ", borrowedTaxRate, "%");
		System.out.printf("\n%-25s%-5s%-5.2f\n", "Tax Amount: ", "$", borrowedTax);
		
		System.out.printf("\n%-25s%-5.2f", "Order Total", borrowedTotalCost);
		System.out.printf("\n%-25s%-5s\n", "Here is your prize!", prizeName);
		System.out.println("~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~ ~~~~");
	} // END - displayItemReceipt
	////////////////////////////////////
	// VALUE RETURN
	////////////////////////////////////
	public static String getUserName(Scanner borrowedInput) 
	{
		// LOCAL VARIABLES
		String localUserName = "";
		// FIRST NAME
	    System.out.println("\nWhat is your first name?");
	    localUserName = borrowedInput.nextLine();
	    return localUserName;
	} // END OF getUserName 
	public static char validateMainMenu(Scanner borrowedInput) 
	{
		// LOCAL VARIABLES
		char localSelection = ' ';
		// MAIN MENU
		System.out.println("\nMAIN SELECTION MENU");
		System.out.println("_____________________");
		System.out.printf("\n%-10s%-5s", MENU_CHARS[0], MENU_OPTIONS[0]);
		System.out.printf("\n%-10s%-5s\n", MENU_CHARS[1], MENU_OPTIONS[1]);
	    // LOCAL SELECTION
	    System.out.printf("\nPlease make your selection here: ");
	    localSelection = borrowedInput.next().toUpperCase().charAt(0);
	    // while localSelection
	    while(localSelection != 'A' && localSelection != 'Q') 
	    {
	    	// ERROR MESSAGE
			System.out.println("\n~~Unfortunately, that is not a valid selection.~~\n");
			// MAIN MENU
			System.out.println("\nMAIN SELECTION MENU");
			System.out.println("_____________________");
			System.out.printf("\n%-10s%-5s", MENU_CHARS[0], MENU_OPTIONS[0]);
			System.out.printf("\n%-10s%-5s\n", MENU_CHARS[1], MENU_OPTIONS[1]);
		    // LOCAL SELECTION
		    System.out.printf("\nPlease make your selection here: ");
		    localSelection = borrowedInput.next().toUpperCase().charAt(0);
	    } // END OF while localSelection
	    return localSelection;
	} // END OF validateMainMenu
	public static int validateHowMany(Scanner borrowedInput) 
	{
		// LOCAL VARIABLES
		int localHowMany = 0;
		// HOW MANY
		System.out.println("\nHow many did you get?");
		localHowMany = borrowedInput.nextInt();
		// while localHowMany 
		while(localHowMany <= 0) 
		{
			// ERROR MESSAGE
			System.out.print("\n~~Unfortunately, that is not a valid amount.~~\n");
			// HOW MANY
			System.out.println("\nHow many did you get?");
			localHowMany = borrowedInput.nextInt();
		} // END OF while localHowMany
		return localHowMany;
	} // END - validateHowMany
	public static char validateItemMenu(Scanner borrowedInput, String[] borrowedItemNames, double[] borrowedItemPrices) 
	{
		// LOCAL VARIABLES
		char localSelection = ' ';
		// ITEM MENU
		displayItemMenu(borrowedItemNames, borrowedItemPrices);
		// LOCAL SELECTION
	    System.out.printf("\nPlease make your selection here: ");
	    localSelection = borrowedInput.next().toUpperCase().charAt(0);
		while(localSelection != 'A' && localSelection != 'B' && localSelection != 'C' && localSelection != 'Q') 
		{
			// ERROR MESSAGE
			System.out.print("\n~~Unfortunately, that is not a valid amount.~~\n");
			// ITEM MENU
			displayItemMenu(borrowedItemNames, borrowedItemPrices);
			// LOCAL SELECTION
		    System.out.printf("\nPlease make your selection here: ");
		    localSelection = borrowedInput.next().toUpperCase().charAt(0);
		} // END OF while localHowMany
		return localSelection;
	} // END - validateItemMenu
	public static char validateDiscountMenu(Scanner borrowedInput, String[] borrowedDiscountNames, double[] borrowedDiscountRates) 
	{
		// LOCAL VARIABLES
		char localSelection = ' ';
		// DISCOUNT MENU
		displayDiscountMenu(borrowedDiscountNames, borrowedDiscountRates);
		// LOCAL SELECTION
	    System.out.printf("\nPlease make your selection here: ");
	    localSelection = borrowedInput.next().toUpperCase().charAt(0);
		while(localSelection != 'A' && localSelection != 'B' && localSelection != 'C' && localSelection != 'Q') 
		{
			// ERROR MESSAGE
			System.out.print("\n~~Unfortunately, that is not a valid amount.~~\n");
			// DISCOUNT MENU
			displayDiscountMenu(borrowedDiscountNames, borrowedDiscountRates);
			// LOCAL SELECTION
		    System.out.printf("\nPlease make your selection here: ");
		    localSelection = borrowedInput.next().toUpperCase().charAt(0);
		} // END OF while localHowMany
		return localSelection;
	} // END - validateDiscountMenu
}
