package cafe;

import java.math.BigDecimal;

public class Menu 
{
	//Instead of a text file IO here, we are making a constant menu instead:
	private Product[] allMenuItems = new Product[5];
	
	public Menu() 
	{
		allMenuItems[0] = new Beverage("Coffee", "B01", BigDecimal.valueOf(1.79), Beverage.SizeMultiplier.MEDIUM);
		allMenuItems[1] = new Beverage("Green Tea", "B11", BigDecimal.valueOf(1.29), Beverage.SizeMultiplier.MEDIUM);
		allMenuItems[2] = new Beverage("Black Tea", "B12", BigDecimal.valueOf(1.39), Beverage.SizeMultiplier.MEDIUM);
		allMenuItems[3] = new Food("Breakfast Wrap", "F01", BigDecimal.valueOf(2.49), false);
		allMenuItems[4] = new Food("Breakfast Sandwhich", "F02", BigDecimal.valueOf(1.99), false);
	}
	
	public Product getMenuItem(String id)
	{
		//Find the item based on the id the slowest method possible: linear search:
		for(int i = 0 ; i < allMenuItems.length ; i++)
		{
			if(allMenuItems[i].getID().equals(id))
			{
				return allMenuItems[i];
			}
		}
		return null;
	}
	@Override
	public String toString()
	{
		String str = "";

		//Find the item based on the id the slowest method possible: linear search:
		for(int i = 0 ; i < allMenuItems.length ; i++)
		{
			str += String.format("%s -- %s: $%.2f\n", allMenuItems[i].getID(), allMenuItems[i].getName(), allMenuItems[i].price());
		}
		
		return str;
	}
}
