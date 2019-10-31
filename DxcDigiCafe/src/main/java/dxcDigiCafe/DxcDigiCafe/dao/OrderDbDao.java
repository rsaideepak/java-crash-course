package dxcDigiCafe.DxcDigiCafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import dxcDigiCafe.DxcDigiCafe.model.EmployeeDb;
import dxcDigiCafe.DxcDigiCafe.model.OrderDb;

@Component
public class OrderDbDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public OrderDb saveOrder(OrderDb orderDb) {
		mongoTemplate.save(orderDb);
		return orderDb;
	}
	
	public ArrayList<OrderDb> getOrderbyId(String shopName)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("shopName").is(shopName));
		return (ArrayList<OrderDb>)mongoTemplate.find(query, OrderDb.class);
	}
	
	
	public ArrayList<OrderDb> getOrderbyName(String employeeId)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("employeeId").is(employeeId));
		return (ArrayList<OrderDb>)mongoTemplate.find(query,OrderDb.class);
	}
	
	public ArrayList<OrderDb> getAllOrders(){
		return (ArrayList<OrderDb>) mongoTemplate.findAll(OrderDb.class);
	}
	
	
	public String updateOrder(OrderDb orderOld,String orderId)
	{
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("orderId").is(orderId));
		
		OrderDb orderOld1=mongoTemplate.findOne(query2, OrderDb.class);
		
		
		
		if( !(orderOld1.getStatus().equals(orderOld.getStatus())))
		{
			orderOld1.setStatus(orderOld.getStatus());
			mongoTemplate.save(orderOld1);
		}
		
		
		return  orderOld1.getStatus();
	}
		
		
	
	
	
	
	
	
	
	

}
