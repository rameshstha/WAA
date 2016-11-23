/**
 * 
 */
package managedbeans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * @author Ramesh Shrestha
 *
 */
@ManagedBean
@RequestScoped
public class calcManagedBean {
 private int firstNumber;
 private int secondNumber;
 private String result;
 	
	public calcManagedBean() {}

	public int getFirstNumber() {
		return firstNumber;
	}

	public void setFirstNumber(int firstNumber) {
		this.firstNumber = firstNumber;
	}

	public int getSecondNumber() {
		return secondNumber;
	}

	public void setSecondNumber(int secondNumber) {
		this.secondNumber = secondNumber;
	}

	public String getResult() {
		return result;
	}
	
	public String add(){
		result=Integer.toString(firstNumber+secondNumber);
		return "";
	}
	public String subtract(){
		result=Integer.toString(firstNumber-secondNumber);
		return "";
	}
	public String multiply(){
		result=Integer.toString(firstNumber*secondNumber);
		return "";
	}
	public String divide(){
		result=Integer.toString(firstNumber/secondNumber);
		return "";
	}
	
}
