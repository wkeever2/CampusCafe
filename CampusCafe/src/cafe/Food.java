package cafe;

import java.math.BigDecimal;


public class Food extends Product
{
	private boolean extraToppings = false;
	
	public Food(String name, String id, BigDecimal basePrice, boolean extraToppings)
	{
		super(name, id, basePrice);
		this.extraToppings = extraToppings;
	}
	public Food(Food foo)
	{
		super(foo.getName(), foo.getID(), foo.getBasePrice());
		this.extraToppings = foo.isExtraToppings();
	}
	
	public BigDecimal price()
	{
		//Messy code that is the base price times the size multiplier times the number of drinks. (BASE + EXTRA_TOPPINGS) * NUMBER
		return getBasePrice().add(extraToppings ? BigDecimal.valueOf(1.99) : BigDecimal.valueOf(0)).multiply(BigDecimal.valueOf(getNumber()));
	}

	public boolean isExtraToppings() {
		return extraToppings;
	}

	public void setExtraToppings(boolean extraToppings) {
		this.extraToppings = extraToppings;
	}
	
}
