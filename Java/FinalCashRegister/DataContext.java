/*Junghwan Yang 
 * COMP1030 
 * This is an database file plus initializing, read, and save method*/
package FinalCashRegister;
import java.io.*;
import java.util.*;
public class DataContext {
	public List<Product> Products = new ArrayList<Product>(); //Make Product List
	public List<InvoiceItem> InvoiceItems = new ArrayList<InvoiceItem>();//Make InvoiceItem List
	public List<Invoice> Invoices = new ArrayList<Invoice>();//Make Invoice List
	public void Initialize() {//Initialize test Data // chosen data 
		Products.add(new Product(1, "Apple", 1.15f));
		Products.add(new Product(2, "Broccoli", 5.50f ));
		Products.add(new Product(3, "Cuccumber", 1.00f));
		Products.add(new Product(4, "Banana", 0.5f));
		
		Invoice invoice = new Invoice(1);
		/*Create InvoiceItems */
		InvoiceItem item1 = new InvoiceItem(1, 1, 2); /*Create InvoiceItems with Broccoli*/
		item1.setQuantity(10); //Set the quantity to 10 units
		InvoiceItem item2 = new InvoiceItem(2, 1, 1); // item2-> apple
		item2.setQuantity(2);
		InvoiceItem item3 = new InvoiceItem(3, 1, 3);
		item3.setQuantity(1);
		InvoiceItem item4 = new InvoiceItem(4, 1, 4);
		item4.setQuantity(4);
		
		InvoiceItems.add(item1);
		InvoiceItems.add(item2);
		InvoiceItems.add(item3);
		InvoiceItems.add(item4);
		
		Invoices.add(invoice); //add invoice to Invoices	
			
	}
	public String toSummaryString() {
		String ret = "";
		ret = String.format("Products: %d Invoices: %d, Items Sold : %d", 
				Products.size(), Invoices.size(), InvoiceItems.size() );
		
		return (ret);
	}
	
	public Boolean Save() {
		Boolean ret = true;
		try {
			List<List<? extends BaseModel>> baseModelListList = new ArrayList<List<? extends BaseModel>>();
			baseModelListList.add(Invoices);
			baseModelListList.add(InvoiceItems);
			baseModelListList.add(Products);
			for (List<? extends BaseModel> modelList : baseModelListList) {
				String fileName = modelList.get(0).getClass().getName() + "s.csv";
				File file1 = new File(fileName);
				if(!file1.exists()) {
					file1.createNewFile();
				}
				//Create a writer to send information to the stream
				FileWriter fw1 = new FileWriter(file1.getAbsoluteFile());
				BufferedWriter bw1 = new BufferedWriter(fw1);
				for(BaseModel item : modelList) {
					bw1.write(item.getFileOutput() + "\n");
				}
				bw1.close();
			}
		} catch (Exception e) {}
		return ret;
	}
//	@SuppressWarnings("unchecked")
	public Boolean Read() {
		Products.clear();
		InvoiceItems.clear();
		Invoices.clear();
		
		Boolean ret = true;
		BufferedReader br;
		BufferedReader br2;
		BufferedReader br3;
		try {
			File file3 = new File("FinalCashRegister.Products.csv");
			br3 = new BufferedReader( new FileReader(file3.getAbsolutePath()));
			StringBuilder sb3 = new StringBuilder();
			String line3 = br3.readLine();
			Product formatp = new Product();
            formatp.setFileOutput(line3);
            Products.add(formatp);
			while (line3 != null) {
				sb3.append(line3);
				sb3.append(System.lineSeparator());
				line3 = br3.readLine();
				Product tempro = new Product();
				if(line3 != null){
                    tempro.setFileOutput(line3);

                    Products.add(tempro);
                }
				
			}

			File file = new File("FinalCashRegister.Invoices.csv");
			br = new BufferedReader( new FileReader(file.getAbsolutePath()));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			Invoice formatI = new Invoice();
            formatI.setFileOutput(line);
            Invoices.add(formatI);
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = br.readLine();
				Invoice temI = new Invoice();
				if(line != null){
                    temI.setFileOutput(line);

                    Invoices.add(temI);
                }

			}
			
			File file2 = new File("FinalCashRegister.InvoiceItems.csv");
			br2 = new BufferedReader( new FileReader(file2.getAbsolutePath()));
			StringBuilder sb2 = new StringBuilder();
			String line2 = br2.readLine();
			InvoiceItem formatII = new InvoiceItem();
            formatII.setFileOutput(line2);
            InvoiceItems.add(formatII);
			while (line2 != null) {
				sb2.append(line2);
				sb2.append(System.lineSeparator());
				line2 = br2.readLine();
				InvoiceItem temII = new InvoiceItem();
				if(line2 != null){
                    temII.setFileOutput(line2);

                    InvoiceItems.add(temII);
                }
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		}
		return ret;	
			
		}
	public List<Product> SearchProducts(String search) {
		List<Product> items = new ArrayList<Product>();
		for(Product p : Products) {
			if(p.getName().contains(search)) {
				items.add(p);
			}
		}
		return(items);
	}
}
