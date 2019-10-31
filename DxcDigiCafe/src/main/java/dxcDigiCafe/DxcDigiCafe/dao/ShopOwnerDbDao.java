package dxcDigiCafe.DxcDigiCafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import dxcDigiCafe.DxcDigiCafe.model.ShopOwnerDb;

@Component
public class ShopOwnerDbDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public ArrayList<ShopOwnerDb> getAllShopOwners(){
		return (ArrayList<ShopOwnerDb>) mongoTemplate.findAll(ShopOwnerDb.class);
	}
	
	public ShopOwnerDb getShopbyId(String shopName)
	{
		Query query = new Query();
		query.addCriteria(Criteria.where("shopName").is(shopName));
		return mongoTemplate.findOne(query, ShopOwnerDb.class);
		
		
	}
	
	public ShopOwnerDb Authentication(String usersName,String password)
	{
		Query query = new Query();
		
		query.addCriteria(
			    new Criteria().andOperator(
			        Criteria.where("usersName").is(usersName),
			        Criteria.where("password").is(password)
			    ));
		
		
		
		
		
		return mongoTemplate.findOne(query ,ShopOwnerDb.class);
	}
	
	public ShopOwnerDb saveShopOwners(ShopOwnerDb shopOwnerDb) {
		mongoTemplate.save(shopOwnerDb);
		return shopOwnerDb;
	}
	
	public void deleteShopOwners(String shopName) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("shopName").is(shopName));
		ShopOwnerDb shopOwner = mongoTemplate.findOne(query, ShopOwnerDb.class);
		mongoTemplate.remove(shopOwner);
	}
		//mongoTemplate.up
	
	
	public String updateShopOwners(ShopOwnerDb shopOwnerOld,String shopName)
	{
		
		System.out.println("test data "+shopOwnerOld.getUsersName());
		System.out.println("test data "+shopOwnerOld.getCuisine());
		
		
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("shopName").is(shopName));
		
		ShopOwnerDb shopOwnerOld1=mongoTemplate.findOne(query2, ShopOwnerDb.class);
		
		System.out.println("old " +shopOwnerOld1.getCuisine());
		System.out.println("new "+shopOwnerOld.getCuisine());
		
		
		if( !(shopOwnerOld1.getCuisine().equals(shopOwnerOld.getCuisine())))
		{
			shopOwnerOld1.setCuisine(shopOwnerOld.getCuisine());
			mongoTemplate.save(shopOwnerOld1);
		}
		
		
		
	
		
		
		
		return  shopOwnerOld1.getCuisine();
	}
}
		
		
	