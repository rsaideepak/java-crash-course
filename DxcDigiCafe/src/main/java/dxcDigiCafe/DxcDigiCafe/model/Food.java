package dxcDigiCafe.DxcDigiCafe.model;

import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Food {
	
	String foodItem;
	int quantity;
	int bill;
	
	public String getFoodItem() {
		return foodItem;
	}
	public void setFoodItem(String foodItem) {
		this.foodItem = foodItem;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	
	
	

}
