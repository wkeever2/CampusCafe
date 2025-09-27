package cafe;

import java.math.BigDecimal;

public abstract class Product 
{
	private String name;
	private String id;
	private BigDecimal basePrice;
	private int number = 1;
	protected Product(String name, String id, BigDecimal basePrice)
	{
		this.name = name;
		this.basePrice = basePrice;
		this.id = id;
	}
	protected Product(Product pro)
	{
		this.name = pro.getName();
		this.basePrice = pro.getBasePrice();
		this.id = pro.getID();
	}

	
	//Methods:
	public String getDisplayName()
	{
		return id + ": " + name + ". Price: " + basePrice;
	}
	public abstract BigDecimal price();
	

	//Getters:
	public BigDecimal getBasePrice()
	{
		return basePrice;
	}
	public String getID()
	{
		return id;
	}
	public String getName()
	{
		return name;
	}
	public int getNumber() {
		return number;
	}
	

	//Setters:
	protected void setBasePrice(BigDecimal basePrice)
	{
		this.basePrice = basePrice;
	}
	protected void setID(String id)
	{
		this.id = id;
	}
	protected void setName(String name)
	{
		this.name = name;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
