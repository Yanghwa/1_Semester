/*Junghwan Yang 
 * COMP1030 
 * This is an basemodel to use at invoice, invoiceitem, and product. Basic information*/

package FinalCashRegister;

import java.time.LocalDateTime;

public abstract class BaseModel {
	
	private LocalDateTime _CreateDate;
	private LocalDateTime _EditDate;
	private int _Id;
	
	public int getId() {	//get Product Id
		return (this._Id);
	}
	public void setId(int input) {
		this._Id = input;
	}
	public LocalDateTime getCreateDate() {
		return this._CreateDate;
	}
	public LocalDateTime setCreateDate(LocalDateTime input) {
		return this._CreateDate = input;
	}
	public LocalDateTime getEditDate() {
		return this._EditDate;
	}
	public LocalDateTime setEditDate(LocalDateTime input) {
		return this._EditDate = input;
	}
	
	abstract public String getFileOutput();
	abstract public void setFileOutput(String Line);
}
