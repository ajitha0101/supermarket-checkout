package org.checkout;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Main class that contains the main method to run the supermarket checkout system.
 */
public class Main {
	public static void main(String[] args) {
		// Initialize the pricing rules
		Map<Character, Item> pricingRules = new HashMap<>();
        pricingRules.put('A', new Item('A', 50, 3, 130));
        pricingRules.put('B', new Item('B', 30, 2, 45));
        pricingRules.put('C', new Item('C', 20, 0, 0));
        pricingRules.put('D', new Item('D', 15, 0, 0));
	    
        try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("New Checkout Transaction");
			    System.out.println("Enter new pricing rules (Y/N)?");
			    String input = scanner.next();
			    if ("Y".equals(input.toUpperCase())) {
			        // Update pricing rules here and create a new pricingRules map
			    	while(true) {
			    		System.out.println("Enter itemname, price, special quantity, special price ");
			    		char SKU= scanner.next().charAt(0);
			    		pricingRules.put(SKU, new Item(SKU,scanner.nextInt(),scanner.nextInt(),scanner.nextInt()));
			    		System.out.println("Add new rule? Y/N");
			    		input=scanner.next();
			    		if(!"Y".equals(input)) 
			    			break;
			    	}
			    		
			    }
			    // Create a new checkout instance with the updated pricing rules
			    Checkout checkout = new Checkout(pricingRules);			    
			    System.out.println("Scan an item --- Item names(A,B,C,D,...)/NO");			    
			    while (true) {
			    	input=scanner.next();
			        if(input.toUpperCase().equals("NO")) {
			        	System.out.println("Total price: " + checkout.getTotal() + " pence");
			        	break;
			        }
			        else if (input.length() == 1) {
			            try {
			                checkout.scan(input.charAt(0));
			                System.out.println("Scanned item: " + input);
			                System.out.println("Running Total Price : " + checkout.getTotal());
			                System.out.println("Scan another item (item name/NO)");
			            } catch (InvalidItemException e) {
			                System.out.println(e.getMessage());
			            }
			        } 
			        else {
			        System.out.println("Invalid input. Please enter items (A, B, C, D) or type 'total'.");
			        }
			    }
			    System.out.println("Another Checkout Transaction (Y/N)?");
			    if(!scanner.next().toUpperCase().equals("Y")){
			    	break;
			    }
			}
		}
	}

}

