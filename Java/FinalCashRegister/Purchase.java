/*Junghwan Yang 
 * COMP1030 
 * This is a file to operate main method, main function is here*/

package FinalCashRegister;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Purchase {
	//Daily Summary -- if invoice was made in 1 day, it would be printed out
	//Invoice Recall - choose invoices, show detail
	//purchase 1. Product id, 2. Quantity 3. Receipt
			//First put product, make invoice, and continue to put product in the same invoice until type Enter, 
	public Purchase() {
		// TODO Auto-generated constructor stub
	}
	public static DataContext context = new DataContext();
	public void PurchaseMachine() {
		Scanner sc = new Scanner(System.in);
//		context.Initialize(); //at the first time it is necessary for setting, doesn't need at the second time
//		context.Save(); //to save initialized data
		context.Read();
		while(true) {
			
			int count = 0;
			for (Invoice item: context.Invoices) {
				for(InvoiceItem itemI: context.InvoiceItems) {
					if (itemI.getInvoiceId() == item.getId()) {
						count++;
					}
					else continue;
				}
				if (count == 0) {
					context.Invoices.remove(item);
				}
			}
			System.out.println("Choose what you want(If you stop, type Enter");
			System.out.println("1: Daily Summary");
			System.out.println("2: Invoice Recall");
			System.out.println("3: Add new purchase");
		
			String choice = sc.nextLine();
			if (choice.equals("")) {
				break;
			}
			if (choice.equals("1")) {
				System.out.println("You put these products today");
				System.out.println("===========================");
				String ret = String.format("%s\n\n", "");
				for (Invoice invo : context.Invoices) {
					LocalDateTime comparsiontime = LocalDateTime.now();
					LocalDateTime timeduisting = invo.getEditDate();
					
					if(Duration.between(comparsiontime, timeduisting).toDays() < 1) {
						for (InvoiceItem item : context.InvoiceItems) {
							ret += String.format("Item : %d - InvoiceItem : %s\n", item.getInvoiceId(), item.toString());
						}
					}
					System.out.println(ret);
					break;
				}
				System.out.println("===========================");
			}
			if (choice.equals("2")) {
				System.out.println("Which invoice do you want to see?");
				System.out.format("You can choose, invoices number in %d \n", context.Invoices.size() );
				String ii = sc.nextLine();
				while(true) {
					try {
							int iitemp = Integer.parseInt(ii);
							if(iitemp <= context.Invoices.size()) {
								System.out.println("===========================");
								String ret = String.format("%s\n\n", "");
								for (InvoiceItem item : context.InvoiceItems) {
									
									if(item.getInvoiceId() ==  iitemp) {
										ret += String.format("Item : %d - InvoiceItem : %s\n", item.getInvoiceId(), item.toString());
										
									}
								}
								System.out.println(ret);
								System.out.println("===========================");
								break;
							}
							else {
								System.out.println("You put the right number");
								break;
							}
					} catch (Exception e) { 
						System.out.println("You should put the number, not String");
						break;
					}
				}
			}
			if (choice.equals("3")) {
				
				context.Invoices.add(new Invoice(context.Invoices.size()+1));
				int itid = 0;
				while(true) {
					System.out.println("Enter a Product number(from 1 to 4)");
					System.out.println("If you want to back, type Enter");
					String pn = sc.nextLine();
					if(pn.equals("")) {
						break;
					}
					if(pn.equals("1") || pn.equals("2") || pn.equals("3") || pn.equals("4")) {
						System.out.println("Enter quntity");
						
						String pq = sc.nextLine();
						try {
							Integer.parseInt(pq);
						}catch(Exception e) {
							System.out.println("Need number, not string");
							break;
						}
						if(pq.equals("")) {
							break;
						}
						if(Integer.parseInt(pq) <= 0) {
							System.out.println("Need positive number");
							break;
						}
						else {
							int pntemp = Integer.parseInt(pn);
							int iq = Integer.parseInt(pq);
							if (itid == 0) {
								itid = context.InvoiceItems.size()+1;
							}
							else {
								itid +=1;
							}
							context.InvoiceItems.add(new InvoiceItem(itid,context.Invoices.get(context.Invoices.size()-1).getId(), pntemp));
							context.InvoiceItems.get(context.InvoiceItems.size()-1).setQuantity(iq);
							System.out.println("===========================");
							System.out.println("Product Receipt");
							System.out.println("Inovice number: " + context.Invoices.get(context.Invoices.size()-1).getId());
							System.out.format("InvoiceItem number: %d \n", itid);
							System.out.println("Product name: " + context.Products.get(pntemp-1).getName());
							System.out.println("Quantity : " + iq);
							System.out.println("SubTotal : " + context.InvoiceItems.get(context.InvoiceItems.size()-1).getSubTotal());
							System.out.println("Total : " +  context.InvoiceItems.get(context.InvoiceItems.size()-1).getTotal());
							System.out.println("===========================");
						}
						context.Save(); // save after work
					}
					else {
						System.out.println("Type correct numbers");
//						context.Invoices.remove(context.Invoices.get(context.Invoices.size()));
						break;
					}
				}
			}
			else {
				System.out.println("Need number from 1 to 3 \n" );
			}
			
			
		}
		sc.close();
		
	}
}	
