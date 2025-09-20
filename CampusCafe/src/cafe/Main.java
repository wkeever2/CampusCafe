package cafe;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		System.out.println("Welcome to the cafe! Please wait while we set up our menu!");
		Menu menu = new Menu();
		System.out.println(menu);
		
		Scanner sc = new Scanner(System.in);
		boolean stillOrdering = true;
		Order userOrder = new Order();
		
		while(stillOrdering)
		{
			System.out.println("\nPlease make a menu selection or /'done/' to exit");
			String selection = sc.nextLine();
			if(selection.toLowerCase().equals("done"))
			{
				stillOrdering = false; //Probably not necessary but its fun!
				break;
			}
			else
			{
				Product selectedItem = menu.getMenuItem(selection);
				if(selectedItem == null)
				{
					System.out.println("That is an invalid menu selection!");
					continue;
				}
				//Test depending on the type of the item:
				if(selectedItem instanceof Beverage)
				{
					selectedItem = new Beverage((Beverage)selectedItem);
					System.out.println("Please choose a size, note that a small or large will influnce the price:");
					System.out.println("SMALL -> 70%");
					System.out.println("MEDIUM -> 100%");
					System.out.println("LARGE -> 130%");
					String size = sc.nextLine();
					if(size.equalsIgnoreCase("small"))
					{
						((Beverage)selectedItem).setSize(Beverage.SizeMultiplier.SMALL);
					}
					else if(size.equalsIgnoreCase("large"))
					{
						((Beverage)selectedItem).setSize(Beverage.SizeMultiplier.LARGE);
					}
					//Because the menu item already assumes this is a medium cup size, there is no need to then check and set to me
				}
				else //Its a food!
				{
					selectedItem = new Food((Food)selectedItem);
					System.out.println("Double the toppings (Adds 1.99 per item)? <y/n>");
					String size = sc.nextLine();
					if(size.toLowerCase().equals("y"))
					{
						((Food)selectedItem).setExtraToppings(true);
					}
					//Already assume that there are no extra toppings.
				}
				
				//Ask for the number of items:
				System.out.println("How many do you want?");
				int number = sc.nextInt();
				selectedItem.setNumber(number);
				
				//Then add the item to the order:
				userOrder.addItem(selectedItem);
			}
		}
		
		//Give the total and take all their money, I mean what?
		System.out.println("\nThank you for ordering with us! Your receipt is printed below:");
		System.out.println(userOrder.getReceipt());
	}

}
