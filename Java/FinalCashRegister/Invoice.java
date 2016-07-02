/*Junghwan Yang 
 * COMP1030 
 * This is an invoice file using invoiceitem class*/

package FinalCashRegister;
import java.time.LocalDateTime;

public class Invoice extends BaseModel {
	private float _SubTotal;
	private float _Taxes;
	private float _Total;
	public Invoice() {
		// TODO Auto-generated constructor stub
		setCreateDate(LocalDateTime.now());
		setEditDate(LocalDateTime.now());
	}
	public Invoice(int id) {
		this();
		setId(id);
	}
	public void AddInvoiceItem(InvoiceItem item) {	//function - add to InvoiceItem
		Purchase.context.InvoiceItems.add(item);
	}
	public float getSubTotal() { 	//total price without taxes
		float ret = 0.00f;
		for (InvoiceItem item : Purchase.context.InvoiceItems) {
			ret += item.getSubTotal();
		}
		_SubTotal = ret;
		return (_SubTotal);
	}
	public float getTaxes() {	//total taxes
		float subtotal = getSubTotal();
		if (subtotal > 0) {
			_Taxes = subtotal * Common.TaxRate;
			return (_Taxes);
		}
		return (0);
	}
	public float getTotal() {	//total price
		float ret = 0.00f;
		ret = getSubTotal() + getTaxes();
		_Total = ret;
		return (_Total);
	}
	public String toStringSummary() {
		String ret = "";
		ret = String.format("%s\n\n", ret);
		for(InvoiceItem item : Purchase.context.InvoiceItems) {
			ret += String.format("%s\n", item.toString());
		}
		return ret;
	}
	public String toDetailString() {	
		String ret = "";
		ret = String.format("%s\n\n", ret);
		for (InvoiceItem item:Purchase.context.InvoiceItems) {
			ret += String.format("Item : %d - InvoiceItem : %s\n", getId(), item.toString());
		}
		
		return ret;

	}
	public String getFileOutput() {
		String ret = "";
		ret = String.format("%d,%s,%s", getId(), getCreateDate(), getEditDate());
		return ret;
				
	}
	
	public void setFileOutput(String input) {
		String fileline[];
		
		fileline = input.split(",");
		
		setId(Integer.parseInt(fileline[0]));
		
		setCreateDate(LocalDateTime.parse(fileline[1]));
		
		setEditDate(LocalDateTime.parse(fileline[2]));
		
	}
	
}
