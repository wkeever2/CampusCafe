package cafe;

import java.math.BigDecimal;

public class Beverage extends Product
{
	public enum SizeMultiplier
	{
		SMALL(BigDecimal.valueOf(0.7)),
		MEDIUM(BigDecimal.valueOf(1)),
		LARGE(BigDecimal.valueOf(1.3));
		
		private BigDecimal priceMultiplier;
		private SizeMultiplier(BigDecimal priceMultiplier)
		{
			this.priceMultiplier = priceMultiplier;
		}
		
		public BigDecimal getPriceMultiplier()
		{
			return priceMultiplier;
		}
	}
	
	private SizeMultiplier size;
	
	public Beverage(String name, String id, BigDecimal basePrice, SizeMultiplier size)
	{
		super(name, id, basePrice);
		this.size = size;
	}
	public Beverage(Beverage bev)
	{
		super(bev.getName(), bev.getID(), bev.getBasePrice());
		this.size = bev.getSize();
	}
	
	public BigDecimal price()
	{
		//Messy code that is the base price times the size multiplier times the number of drinks. BASE * SIZE * NUMBER
		return getBasePrice().multiply(size.getPriceMultiplier()).multiply(BigDecimal.valueOf(getNumber()));
	}

	public SizeMultiplier getSize() {
		return size;
	}

	public void setSize(SizeMultiplier size) {
		this.size = size;
	}
}
