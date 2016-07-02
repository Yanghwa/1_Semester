/*Junghwan Yang 
 * COMP1030 
 * This is an invoiceitem file using product class*/

package FinalCashRegister;
import java.time.LocalDateTime;


public class InvoiceItem extends BaseModel {
	
	private int _Quantity; //make variable quantity
	private Product _Product; //make Product object 
	private Invoice _Invoice; //make Invoice object
	private int _InvoiceId;
	private int _ProductId;
	public InvoiceItem(int id, int invoiceid, int productid) {
		this();
		setId(id);
		setInvoiceId(invoiceid);
		setProductId(productid);
	}
	public InvoiceItem() {
		// TODO Auto-generated constructor stub
		setCreateDate(LocalDateTime.now()); // save time
		setEditDate(LocalDateTime.now());
	}
	public int getInvoiceId() {
		return (_InvoiceId);
	}
	public int getProductId() {
		return (_ProductId);
	}
	public void setProductId(int value) {
		_ProductId = value;
		_Product = setProduct(value);  //from invoiceitem
	}
	public void setInvoiceId(int value) {
		_InvoiceId = value;
		_Invoice = setInvoice(value);
	}
	public Product getProduct() {  //set product inside of invoiceitem
		return(_Product);
	}
	
	public void setQuantity(int value) {	//set quantity
		_Quantity = value;
	}
	
	private Product setProduct(int value) {
		if (value > 0) {
			for (Product p : Purchase.context.Products) {
				if (p.getId() == value) {
					return p;
				}
			}
		}
		throw new RuntimeException("No Product item~!!!");
		//return (null);
	}
	private Invoice setInvoice(int value) {
		if (value > 0) {
			for (Invoice p : Purchase.context.Invoices) {
				if (p.getId() == value) {
					return p;
				}
			}
		}
		return (null);
	}
	public int getQuantity() { 	//get quantity
		return (_Quantity);
	}
	public float getSubTotal() {	//get this invoiceitem price total before tax 
		return (getQuantity() * getProduct().getPrice());	
	}
	public float getTaxes() {	//calculate tax
		float subtotal = getSubTotal();
		if (subtotal > 0) {
			return (subtotal * Common.TaxRate);
		}
		else {
			return (0);
		}
	}
	public float getTotal() {	//calculate total price about this invoiceitem
		return getSubTotal() + getTaxes();
	}
	public String toString() {
		String ret = "";
		ret = String.format("%d, Product : %d - %s, Quantity : %d, SubTotal : %f, Taxes : %f, Total : %f", 
				getId(), getProductId(), getProduct().getName(), getQuantity(), getSubTotal(), getTaxes(), getTotal());
		return (ret);
		
	}
	public String getFileOutput() {
		String ret = "";
		ret = String.format("%d,%d,%d,%d,%s,%s", getId(), getInvoiceId(), getProductId(), getQuantity(), getCreateDate(), getEditDate());
		return ret;
				
	}
	
	public void setFileOutput(String input) {
		String fileline[];
		
		fileline = input.split(",");
		
		setId(Integer.parseInt(fileline[0]));
		
		setInvoiceId(Integer.parseInt(fileline[1]));
		
		setProductId(Integer.parseInt(fileline[2]));
		
		setQuantity(Integer.parseInt(fileline[3]));
		
		setCreateDate(LocalDateTime.parse(fileline[4]));
		
		setEditDate(LocalDateTime.parse(fileline[5]));
		
		
	}
}
