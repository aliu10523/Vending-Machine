package problems;

import java.util.Scanner; //allow for user input

// loop to let user insert money until the user enters 0
//       If entered amount is valid, add it to the total money
//
// ask the user enter the production selection 1-5 or 0 for cancel
// If user enters 0, return total money in coins
//
// Find the product price using product number selected by user
// 
// If the total money is less than product price
//      Loop to let the user make another product selection 
//      until user selects 0 for cancel 
//            or max 4 selections is reached 
//            or total money >= product price
// 
// If user selected 0 for cancel or total money < product price, return total  money in coins
// Otherwise
//       change = total money - product price
//       return change in coins
//       print out message to let the user pick up product


public class Vendingmachine {
	
	public static void main(String[] args) {
			
           vendingMachine();
           	
	}
 
     public static void vendingMachine(){
           Scanner input = new Scanner(System.in);
		
		float totalMoney = insertMoney(input);		
				
		int productNumber = makeProductSelection(input);
        if (productNumber == 0) {
        	 System.out.println("Transaction Cancelled");
        	returnMoney((int) (totalMoney * 100));
        	return;
        }

		float productPrice = getProductPrice(productNumber);
		
		
		if (totalMoney < productPrice) {
                for (int i=0;i<4;i++) {
		     System.out.println("Not enough money. Please select a different product.");
		     productNumber = makeProductSelection(input);
		     if (productNumber==0) break;
		     productPrice = getProductPrice(productNumber);
		     if (totalMoney >= productPrice) break;
	          }
		}

           int changeMoney;
           if (productNumber == 0) {
                // user cancelled transaction
                // return all the money
                System.out.println("Transaction Cancelled");
                
                changeMoney= (int) (totalMoney*100);
			returnMoney(changeMoney);
           }
           else {

                 System.out.println("Product price: " + productPrice);
                 System.out.println("Total money: " + totalMoney);
                 
		       if (totalMoney < productPrice) {
			   // return money to user
                      System.out.println("Not enough money!!");
                      changeMoney= (int) (totalMoney*100);
			      returnMoney(changeMoney);
                  } 
                  else {
                      System.out.println("Please pick up your product " + productNumber);
                       changeMoney = (int) (totalMoney*100) - (int) (productPrice*100);
			      returnMoney(changeMoney);
		       }
           }
	

     }
 
	
	public static void returnMoney(int change) {
           System.out.println("your change is " + change + " cents");
		// int change = (int)(money *100);
		int quarters = change / 25;
		change = change % 25;
		int dimes = change / 10;
		change = change % 10;
		int nickel = change / 5;
		change = change % 5;
		int penny = change;
		System.out.println("Here is your return money: ");
	if (quarters != 0) { //return money
		System.out.println(quarters + " quarters");
	}
	if (dimes != 0) {
		System.out.println(dimes + " dimes");
		}	
	if (nickel != 0) {
		System.out.println(nickel + " nickels");
		}
	if (penny != 0) {
		System.out.println(penny + " pennies");
		}
	}
	
	
	
	public static int makeProductSelection(Scanner input) {
		// Scanner input = new Scanner(System.in);
           System.out.println("product 1: $1.50");
		System.out.println("product 2: $1.20");
		System.out.println("product 3: $0.70");
		System.out.println("product 4: $0.65");
		System.out.println("product 5: $0.50");

           System.out.print("Please select your product (1-5). Enter 0 to cancel transaction: ");
		int productSelection = input.nextInt();
		while ( productSelection !=0 && (productSelection > 5 || productSelection < 1)){
			System.out.print("Invalid Selection. Please select a number between 1-5: ");
			productSelection = input.nextInt();
		}
		return productSelection;
	}
	public static float getProductPrice(int selection) {
		float productOne = 1.50f;
		float productTwo = 1.20f;
		float productThree = 0.70f;
		float productFour = 0.65f;
		float productFive = 0.5f;
		
		float productPrice=0;
		switch (selection) {
		case 1: productPrice = productOne;
				break;
		case 2: productPrice = productTwo;
				break;
		case 3: productPrice = productThree;
				break;
		case 4: productPrice = productFour;
				break;
		case 5: productPrice = productFive;
                      break;
		default: System.out.println("Invalid Selection");
				System.exit(1);
	   }
		return productPrice;
	}

     public static float insertMoney(Scanner input) {
      
		System.out.println("Please insert money (0.01,0.05,0.10,0.25,1,5). Enter 0 to end insert money");
		float enterMoney = input.nextFloat();
		float totalMoney = 0;
		while (enterMoney != 0) {
                System.out.println("entered money = " + enterMoney);
			if (enterMoney != 0.01f && enterMoney != 0.05f && enterMoney != 0.10f && enterMoney != 0.25f && enterMoney != 1f && enterMoney != 5f)
					System.out.println("Invalid Amount");
			else totalMoney += enterMoney;
		      System.out.println("Total Money is " + totalMoney);
			enterMoney = input.nextFloat();
		}
		return totalMoney;

     }
     
	
}
