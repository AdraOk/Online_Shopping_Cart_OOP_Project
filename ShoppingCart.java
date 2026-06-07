import java.util.*;

class ShoppingCart {
	private String customerName;
	private List<Product> items;
	
	public ShoppingCart(String customerName) {
		this.customerName = customerName;
		this.items = new ArrayList<>();
	}
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void addProduct(Product p) {
		if (p == null) {
	        System.out.println("Error: Invalid product. Cannot add to cart.");
	        return;
	    }
	    items.add(p);
	    System.out.println("Product added!");
	}
	
	public void removeProduct(String productName) {
        boolean removed = items.removeIf(p -> p.getName().equalsIgnoreCase(productName));
        if (removed) {
            System.out.println("Product removed!");
        } else {
            System.out.println("Product not found in cart.");
        }
    }
	
	public void listCart() {
		System.out.println("========== Cart for " + customerName + " ==========");
		if(items.isEmpty()) {
			System.out.println("Cart is empty.");
		}
		for(int i = 0; i < items.size(); i++) {
			System.out.println((i + 1) + ") " + items.get(i).toString());
		}
			
	}
	
	public double getSubtotal() {
        double total = 0;
        for (Product p : items) {
            total += p.getTotalPrice();
        }
        return total;
    }
	
	public double getTotalAfterDiscount() {
        double total = 0;
        for (Product p : items) {
            total += p.getDiscountedTotal();
        }
        return total;
    }
	
	public double getTotalSavings() {
        return getSubtotal() - getTotalAfterDiscount();
    }
	
}
