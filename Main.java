import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter your name: ");
		String name = scanner.nextLine();
		
		ShoppingCart cart = new ShoppingCart(name);
		
		Product p = null;
		
		while(true) {
			System.out.println("--- Shopping Cart Menu ---");
            System.out.println("1. Add a product");
            System.out.println("2. Remove a product");
            System.out.println("3. View cart");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");
            
            int choice = 0;
            
            try {
            	choice = scanner.nextInt();
            	scanner.nextLine();
            } catch(InputMismatchException e) {
            	System.out.println("Invalid input. Please enter a number.");
            	scanner.nextLine();
            	continue;
            } 
            if(choice == 1) {
            	System.out.print("Enter category (electronics/clothing/grocery): ");
                String category = scanner.nextLine().trim().toLowerCase();
                
                System.out.print("Enter product name: ");
                String prodName = scanner.nextLine();
                
                System.out.print("Enter price (TL): ");
                double price = 0;
                
                try {
                	price = scanner.nextDouble();
                		while(price <= 0) {
                			System.out.println("Please enter positive value");
                				price = scanner.nextDouble();
                			}
                		scanner.nextLine();
                } catch (InputMismatchException e) {
                	System.out.println("Invalid input. Please enter a number.");
                	scanner.nextLine();
                	continue;
                }
                System.out.print("Enter quantity: ");
                int quantity = 0;
                
                try {
                	quantity = scanner.nextInt();
                		while(quantity <= 0) {
                			System.out.println("Please enter positive value");
                				quantity = scanner.nextInt();
                			}
                		scanner.nextLine();
                } catch (InputMismatchException e) {
                	System.out.println("Invalid input. Please enter a number.");
                	scanner.nextLine();
                	continue;
                }
       
                switch(category) {
                case "electronics":
                	p = new Electronics(prodName, price, quantity);
                	break;
                case "clothing":
                	p = new Clothing(prodName, price, quantity);
                	break;
                case "grocery":
                	p = new Grocery(prodName, price, quantity);
                	break;
                default:
                	System.out.println("Unknown category. Skipping...");
                	continue;
                }
                
            cart.addProduct(p);
            }
            
            else if(choice == 2) {
            	System.out.print("Enter product name to remove: ");
            	String prodName = scanner.nextLine();
            	cart.removeProduct(prodName);
            }
            
            else if(choice == 3) {
            	cart.listCart();
            }
            
            else if(choice == 4) {
            	System.out.println("========== Checkout ==========");
                System.out.printf("Subtotal: %.2f TL\n", cart.getSubtotal());
                System.out.printf("Total After Discounts: %.2f TL\n", cart.getTotalAfterDiscount());
                System.out.printf("You Saved: %.2f TL\n", cart.getTotalSavings());
                System.out.println("Thank you for shopping, " + cart.getCustomerName() + "!");
            }
            
            else if(choice == 5) {
            	System.out.println("Exiting. Goodbye!");
                break;
            }
            
            else {
                System.out.println("Invalid option. Please enter a number between 1 and 5.");
            }
		}
		
		scanner.close();
	}
}
