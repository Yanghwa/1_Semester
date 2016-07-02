/*Junghwan Yang 
 * COMP1030 
 * This is an product file, can see price, product name, etc*/

package FinalCashRegister;

import java.time.LocalDateTime;

public class Product extends BaseModel{
	public Product(int id, String name, float price) {
		this();
		setId(id);
		setName(name);
		setPrice(price);
	}
	public Product() {
		// TODO Auto-generated constructor stub
		setTaxable(true);
		setCreateDate(LocalDateTime.now());
		setEditDate(LocalDateTime.now());
	}
	private float _Price = 0.00f;
	private String _Name;
	private Boolean _Taxable;
	
	public void setPrice(float value) {	//make function to setPrice and getPrice
		_Price = value;
	}
	public float getPrice() {
		return(_Price);
	}
	public void setName(String value) {	//make function to setName and getName
		_Name = value;
	}
	public String getName() {
		return(_Name);
	}
	public void setTaxable(Boolean value) {	//make function to setTaxable and getTaxable
		_Taxable = value;
	}
	public Boolean getTaxable() {
		return(_Taxable);
	}
	public String getFileOutput() {
		String ret = "";
		ret = String.format("%d,%s,%f,%s,%s", getId(), getName(), getPrice(), getCreateDate(), getEditDate());
		return ret;
				
	}
	
	public void setFileOutput(String input) {
		String fileline[];
		
		fileline = input.split(",");
		
		setId(Integer.parseInt(fileline[0]));
		
		setName(fileline[1]);
		
		setPrice(Float.parseFloat(fileline[2]));
		
		setCreateDate(LocalDateTime.parse(fileline[3]));
		
		setEditDate(LocalDateTime.parse(fileline[4]));
	}
}
