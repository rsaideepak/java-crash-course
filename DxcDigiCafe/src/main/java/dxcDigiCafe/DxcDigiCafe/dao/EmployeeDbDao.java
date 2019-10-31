package dxcDigiCafe.DxcDigiCafe.dao;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import dxcDigiCafe.DxcDigiCafe.model.EmployeeDb;
import dxcDigiCafe.DxcDigiCafe.model.ShopOwnerDb;

@Component
public class EmployeeDbDao {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public ArrayList<EmployeeDb> getAllEmployee(){
		return (ArrayList<EmployeeDb>) mongoTemplate.findAll(EmployeeDb.class);
	}
	
	public EmployeeDb getEmployeebyId(String employeeId,String securityAnswer)
	{		
		
		Query query = new Query();
		query.addCriteria(
				new Criteria().andOperator(
						Criteria.where("employeeId").is(employeeId),
						Criteria.where("securityAnswer").is(securityAnswer)
						));
		return mongoTemplate.findOne(query, EmployeeDb.class);
	}
	
	public EmployeeDb saveEmployee(EmployeeDb employeeDb) {
		mongoTemplate.save(employeeDb);
		return employeeDb;
	}
	
public EmployeeDb getEmployee(String employeeId) {
		
		Query query = new Query();
		query.addCriteria(Criteria.where("employeeId").is(employeeId));
//		EmployeeDb employee = 
				return mongoTemplate.findOne(query, EmployeeDb.class);
//		return employee;
		
	}

public String updateEmployee(String employeeId,String password)
{
	Query query2 = new Query();
	query2.addCriteria(Criteria.where("employeeId").is(employeeId));
	
	EmployeeDb employeeOld1=mongoTemplate.findOne(query2, EmployeeDb.class);
	
	employeeOld1.setPassword(password);
//	if( !(employeeOld1.getPassword().equals(employeeOld.getPassword())))
//	{
//		employeeOld1.setPassword(employeeOld.getPassword());
//		mongoTemplate.save(employeeOld1);
//	}
	mongoTemplate.save(employeeOld1);
	return  employeeOld1.getPassword();
}
	
	
public EmployeeDb Authentication(String employeeId,String password)
{
Query query = new Query();

query.addCriteria(
new Criteria().andOperator(
Criteria.where("employeeId").is(employeeId),
Criteria.where("password").is(password)
));


return mongoTemplate.findOne(query ,EmployeeDb.class);
}
	
	

}
