package dxcDigiCafe.DxcDigiCafe.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import dxcDigiCafe.DxcDigiCafe.model.MenuDb;
import dxcDigiCafe.DxcDigiCafe.model.ShopOwnerDb;

@Component
public class MenuDbDao {

	@Autowired
	private MongoTemplate mongoTemplate;

	public ArrayList<MenuDb> getMenuById(String shopName) {
		Query query = new Query();
		query.addCriteria(Criteria.where("shopName").is(shopName));
		// return mongoTemplate.findOne(query, MenuDb.class);
		return (ArrayList<MenuDb>) mongoTemplate.find(query, MenuDb.class);
	}

	public MenuDb getMenuByName(String shopName, String foodItem) {

		Query query = new Query();
		query.addCriteria(new Criteria().andOperator(Criteria.where("shopName").is(shopName),
				Criteria.where("foodItem").is(foodItem)));
		return mongoTemplate.findOne(query, MenuDb.class);

	}

	public MenuDb saveShopMenus(MenuDb menuDb) {

		String id = menuDb.getShopName().substring(0, 2) + menuDb.getFoodItem().substring(0, 2);
		menuDb.setMenuId(id);
		mongoTemplate.save(menuDb);
		return menuDb;
	}

	public String updateFood(MenuDb menuDbOld, String foodItem) {
		Query query2 = new Query();
		query2.addCriteria(Criteria.where("foodItem").is(foodItem));

		MenuDb menuOld1 = mongoTemplate.findOne(query2, MenuDb.class);

		if (!(menuOld1.getPrice().equals(menuDbOld.getPrice()))) {
			menuOld1.setPrice(menuDbOld.getPrice());
			mongoTemplate.save(menuOld1);
		}

		return menuOld1.getPrice();
	}

}