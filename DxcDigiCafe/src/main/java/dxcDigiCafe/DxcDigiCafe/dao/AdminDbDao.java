package dxcDigiCafe.DxcDigiCafe.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import dxcDigiCafe.DxcDigiCafe.model.AdminDb;

@Component
public class AdminDbDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public AdminDb getAdmin(String userName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("userName").is(userName));
		return mongoTemplate.findOne(query, AdminDb.class);
		
	}
	
	public AdminDb saveAdmin(AdminDb adminDb)
	{
		mongoTemplate.save(adminDb);
		return adminDb;
	}
	/*
	 * public Object getAllAdminDetails(String userName) { Query query = new
	 * Query();
	 * 
	 * }
	 */

}
