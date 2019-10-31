package dxcDigiCafe.DxcDigiCafe.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public class OrderDb {
	
	String orderId;
	/*
	 * public int getOrderId() { return orderId; } public void setOrderId(int
	 * orderId) { this.orderId = orderId; }
	 */
	
	String employeeId;
	String total;
	
	
	
	
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	String shopName;
	
	
	
	@Field
	List<Food>  food;
	String status;
	
	
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	
	
	
	public String getStatus() {
		return status;
	}
	
	
	
	public List<Food> getFood() {
		return food;
	}
	public void setFood(List<Food> food) {
		this.food = food;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	

}
