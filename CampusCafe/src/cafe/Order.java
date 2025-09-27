package cafe;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Order 
{
	private final BigDecimal TAX_AMOUNT = BigDecimal.valueOf(0.0725);
	
	private ArrayList<Product> cartItems = new ArrayList<Product>();
	private BigDecimal subTotal;
	private BigDecimal total;
	private BigDecimal tax;
	
	public Order() {}
	
	public void computeCartAmount()
	{
		//Add up all of the item prices:
		subTotal = BigDecimal.valueOf(0);
		for(Product item : cartItems)
		{
			subTotal = subTotal.add(item.price());
		}
		
		//Now do the tax:
		tax = subTotal.multiply(TAX_AMOUNT);
		
		//Finally the total:
		total = tax.add(subTotal);
	}
	public String getReceipt()
	{
		computeCartAmount();

		//Now grab it all into info:
		String str = "";

		for(Product item : cartItems)
		{
			str += item.getNumber() + "x " + item.getName() + " (" + item.getID() + String.format(") $%.2f\n", item.price());
		}
		
		str += String.format("Subtotal: $%.2f\n", subTotal);
		str += String.format("Tax: $%.2f\n", tax);
		str += String.format("Total: $%.2f\n", total);
		return str;
	}
	
	//Basically make this a wrapper for the arrayList:
	public void addItem(Product item)
	{
		cartItems.add(item);
	}
	public Product getItem(int index)
	{
		return cartItems.get(index);
	}
	public int size()
	{
		return cartItems.size();
	}
}
