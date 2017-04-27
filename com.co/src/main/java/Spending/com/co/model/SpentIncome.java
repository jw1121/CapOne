package Spending.com.co.model;

public class SpentIncome {

	String spent;
	String income;
	
	public SpentIncome(String spent, String income) {
		this.spent = spent;
		this.income = income;
	}
	
	public String getSpent() {
		return spent;
	}
	public void setSpent(String spent) {
		this.spent = spent;
	}
	public String getIncome() {
		return income;
	}
	public void setIncome(String income) {
		this.income = income;
	}
	
	
}
