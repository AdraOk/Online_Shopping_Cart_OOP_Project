import java.util.*;

abstract class Product {
	protected String name;
	protected double price;
	protected int quantity;
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public String getName() { 
		return name; 
	}
    public double getPrice() {
    	return price;
    }
    public int getQuantity() { 
    	return quantity;
    }
    
	public abstract double getDiscountRate();
	
	public double getDiscountedTotal() {
		return price * quantity * (1.0 - getDiscountRate());
	}
	
	public double getTotalPrice() {
		return price * quantity;
	}
	
}

class Electronics extends Product {
	
	public Electronics(String name, double price, int quantity) {
		super(name, price, quantity);
	}

	@Override
	public double getDiscountRate() {
		return 0.10;
	}
	
	@Override
	public String toString() {
		return String.format("[Electronics] %s - %.2f TL x %d = %.2f TL (10%% off -> %.2f)",
				name ,price, quantity, getTotalPrice(), getDiscountedTotal());
	}
}
class Clothing extends Product {
	public Clothing(String name, double price, int quantity) {
		super(name, price, quantity);
	}
	
	@Override
	public double getDiscountRate() {
		return 0.20;
	}
	
	@Override
	public String toString() {
		return String.format("[Clothing] %s - %.2f TL x %d = %.2f TL (20%% off -> %.2f)",
				name ,price, quantity, getTotalPrice(), getDiscountedTotal());
	}
}
class Grocery extends Product {
	public Grocery(String name, double price, int quantity) {
		super(name, price, quantity);
	}
	
	@Override
	public double getDiscountRate() {
		return 0.0;
	}
	
	@Override
	public String toString() {
		return String.format("[Grocery] %s - %.2f TL x %d = %.2f TL (0%% off -> %.2f)",
				name ,price, quantity, getTotalPrice(), getDiscountedTotal());
	}
}
