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


public class Customer {
	
	private String name;
	private int age;
	
	/**
	 * Constructor
	 * @param name
	 * @param age
	 */
	Customer(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * copy constructor
	 * @param c
	 */
	Customer(Customer c)
	{
		this.name = c.getName();
		this.age = c.getAge();
	}

	/**
	 * get method for name
	 * @return - name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set method for name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * get method for age
	 * @return - age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * set method for age
	 * @param age
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * String representation of the customer includes the name and age of the customer.
	 * @return - String containing the customer information
	 */
	@Override
	public String toString() 
	{
		return "Customer name= " + this.name + "\n age= " + this.age;
	}
	
	

}
