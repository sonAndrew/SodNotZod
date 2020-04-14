package edu.cpt187.jackson.participation2;

import java.util.Random; 

public class SodOrder {
	/////// ATTRIBUTES ///////
	// CONSTANTS
	private final String[] ITEM_NAMES = {"Premium Sod", "Special Sod", "Basic Sod"};
	private final double[] ITEM_PRICES = {9.95, 5.95, 1.95};
	private final String[] DISCOUNT_NAMES = {"Member", "Senior", "No Discount"};
	private final double[] DISCOUNT_RATES = {.25, .15, 0.0};
	private final String[] PRIZE_NAMES = {"Harry Potter: Box Set", "havit: Keyboard & Mouse", "Linux BIBLE: 9th EDITION"};
	private final double ZERO_TOTAL = 0.0;
	private final double TAX_RATE = .075;
	// VARIABLES
	private int[] itemCounts = new int[ITEM_NAMES.length];
	private int[] discountCounts = new int[DISCOUNT_NAMES.length];	
	private int[] prizeCounts = new int[DISCOUNT_NAMES.length];
	private char itemSelection = ' ';
	private char discountType = ' ';
	private String itemName = "";
	private double itemPrice = 0.0;
	private String discountName = "";
	private double discountRate = 0.0;
	private int howMany = 0;
	private Random prizeGenerator = new Random();
	private String prizeName = "";
	SodOrder() 
	{
		
	}
	/////////////////////////
	// SETTERS
	//////////////////////////
	public void setItemSelection(char borrowedItemMenu)
	{
		itemSelection = borrowedItemMenu;
	}
	public void setItemName()
	{
		if(itemSelection == 'A') 
		{
			itemName = ITEM_NAMES[0];
			itemCounts[0]++;
		}
		else if(itemSelection == 'B') 
		{
			itemName = ITEM_NAMES[1];
			itemCounts[1]++;
		}
		else if(itemSelection == 'C') 
		{
			itemName = ITEM_NAMES[2];
			itemCounts[2]++;
		}
		
	}
	public void setItemPrice()
	{
		if(itemSelection == 'A') 
		{
			itemPrice = ITEM_PRICES[0];
		}
		else if(itemSelection == 'B') 
		{
			itemPrice = ITEM_PRICES[1];
		}
		else 
		{
			itemPrice = ITEM_PRICES[2];
		}
	}
	public void setHowMany(int borrowedHowMany)
	{
		howMany = borrowedHowMany;
	}
	public void setDiscountType(char borrowedMenuSelection)
	{
		discountType = borrowedMenuSelection;
	}
	public void setDiscountName()
	{
		if(discountType == 'A') 
		{
			discountName = DISCOUNT_NAMES[0];
			discountCounts[0]++;
		}
		else if(discountType == 'B') 
		{
			discountName = DISCOUNT_NAMES[1];
			discountCounts[0]++;
		}
		else 
		{
			discountName = DISCOUNT_NAMES[2];
			discountCounts[0]++;
		}
		
	}
	public void setDiscountRate()
	{
		if(discountType == 'A') 
		{
			discountRate = DISCOUNT_RATES[0];
		}
		else if(discountType == 'B') 
		{
			discountRate = DISCOUNT_RATES[1];
		}
		else 
		{
			discountRate = DISCOUNT_RATES[2];
		}
	}
	public void setPrizeName()
	{
		int localRandomNumber = 0;
		localRandomNumber = getRandomNumber();
		prizeName = PRIZE_NAMES[localRandomNumber];
	}
	//////////////////////////
	// GETTERS
	//////////////////////////
	public String getItemName()
	{
		return itemName;
	}
	public double getItemPrice()
	{
		return itemPrice;
	}
	public int getHowMany()
	{
		return howMany;
	}
	public String getDiscountName()
	{
		return discountName;
	}
	public double getDiscountRate()
	{
		return discountRate;
	}
	public double getDiscountAmt()
	{
		return itemPrice * discountRate;
	}
	public double getDiscountPrice() 
	{
		return itemPrice - getDiscountAmt();
	} // END - getDiscountPrice
	public double getSubTotal() 
	{
		return howMany * getDiscountPrice();
	} // END - getSubTotal
	public double getTaxRate() 
	{
		return TAX_RATE;
	} // END - getTaxRate
	public double getTaxAmt() 
	{
		return TAX_RATE * getSubTotal();
	} // END - getTaxAmt
	public double getTotalCost() 
	{
		if(discountType == ' ') 
		{
			return ZERO_TOTAL;
		}
		else 
		{
			return getSubTotal() + getTaxAmt();
		}
	} // END - getTaxAmt
	public String[] getItemNames()
	{
		return ITEM_NAMES;
		
	}
	public double[] getItemPrices()
	{
		return ITEM_PRICES;
	}
	public String[] getDiscountNames()
	{
		return DISCOUNT_NAMES;
	}
	public double[] getDiscountRates()
	{
		return DISCOUNT_RATES;
	}
	public int[] getItemCounts()
	{
		return itemCounts;
		
	}
	public int[] getDiscountCounts()
	{
		return discountCounts;
	}
	public int[] getPrizeCounts()
	{
		return prizeCounts;
	}
	public String getPrizeName()
	{
		return prizeName;
	}
	public String[] getPrizeNames()
	{
		return PRIZE_NAMES;
	}
	public int getRandomNumber() 
	{
		return prizeGenerator.nextInt(PRIZE_NAMES.length);
	}
}