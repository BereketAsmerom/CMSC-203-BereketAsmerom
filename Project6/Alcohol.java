package project66;

/*
 * Class: CMSC203 
 * Instructor: Prof. Ahmed Tarek
 * Description: The BevShop offers 3 types of beverages: Coffee, Alcoholic and Smoothie. Beverages can 
 * 				be ordered in 3 different sizes: Small, medium, and large. All the beverage types have a 
 * 				base price. In addition, there are additional charges depending on the size and specific 
 * 				add-ons for each type of beverage. Create a Program to run the BevShop.
 * Due: 22/04/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Naol Gobena
*/

public class Alcohol extends Beverage {
	
	
	static final double WEEKEND_PRICE = 0.6;
	private boolean isWeekend;
	
	/**
	 * Creates an Alcohol object using given values
	 * @param bevName
	 * @param size
	 * @param isWeekend
	 */
	
	public Alcohol(String bevName, SIZE size, boolean isWeekend)
	{
		super(bevName,TYPE.ALCOHOL,size);
		this.isWeekend = isWeekend;
	}

	
	/**
	 * Calculates the price of the alcohol
	 * @return - the price of an alcohol beverage
	 */
	@Override
	public double calcPrice() {
		if(isWeekend)
			return	(super.addSizePrice()+ WEEKEND_PRICE);
		
		return super.addSizePrice();
	}
	
	/**
	 * Checks if this Beverage equals to anotherBev
	 * @return - true if the name, type, size and base price and 
	 * 			 whether beverage is offered in weekend or not are the same, false otherwise
	 */
	@Override
	public boolean equals(Object anotherBev)
	{
		Beverage test = (Beverage)anotherBev;
		if(super.getBevName().equals(test.getBevName()) && super.getSize().equals(test.getSize()) 
				&& super.getType().equals(test.getType()))
		{
			Alcohol test2 = (Alcohol)anotherBev;
			if(this.isWeekend == test2.isWeekend )
				return true;
		}
					
		return false;
	}

	
	/**
	 * Checks if is weekend.
	 * @return - true, if is weekend
	 */
	public boolean isWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}

	
	/**
	 * String representation of Alcohol beverage, includes the name, size, 
	 * whether or not beverage is offered in weekend and the price
	 * @return - a string containing the information of an alcohol beverage
	 */
	@Override
	public String toString() 
	{
		if(isWeekend)
			return super.toString()+ "\n Drink is offered on weekends for 0.60$ extra\n Price: " + calcPrice() ;
		
		return super.toString()+"\n Price: "+ calcPrice() ;
	}
	
	

}