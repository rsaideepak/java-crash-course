package dxcDigiCafe.DxcDigiCafe.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dxcDigiCafe.DxcDigiCafe.dao.AdminDbDao;
import dxcDigiCafe.DxcDigiCafe.dao.EmployeeDbDao;
import dxcDigiCafe.DxcDigiCafe.dao.MenuDbDao;
import dxcDigiCafe.DxcDigiCafe.dao.OrderDbDao;
import dxcDigiCafe.DxcDigiCafe.dao.ShopOwnerDbDao;
import dxcDigiCafe.DxcDigiCafe.model.EmployeeDb;
import dxcDigiCafe.DxcDigiCafe.model.MenuDb;
import dxcDigiCafe.DxcDigiCafe.model.OrderDb;
import dxcDigiCafe.DxcDigiCafe.model.ShopOwnerDb;

@CrossOrigin
@RestController
public class Controller {

	@Autowired
	AdminDbDao adminDbDao;
	@Autowired
	MenuDbDao menuDbDao;
	@Autowired
	ShopOwnerDbDao shopOwnerDbDao;
	@Autowired
	EmployeeDbDao employeeDbDao;
	@Autowired
	OrderDbDao orderDbDao;
	
	/* ShopOwnerDb Functions */
	@PostMapping(value = "shops")
	public ShopOwnerDb saveShopOwner(@RequestBody ShopOwnerDb shopOwnerDb) {
		return shopOwnerDbDao.saveShopOwners(shopOwnerDb);
	}

	@GetMapping(value = "shops")
	public List<ShopOwnerDb> getAllShopOwners() {
		return shopOwnerDbDao.getAllShopOwners();
	}

	@GetMapping(value = "shops/{shopName}")
	public Object getShopOwner(@PathVariable String shopName) {
		return shopOwnerDbDao.getShopbyId(shopName);
	}
	
	@GetMapping(value = "shops/{usersName}/{password}")
	public Object getAuth(@PathVariable String usersName, @PathVariable String password) {
		ShopOwnerDb shop = shopOwnerDbDao.Authentication(usersName, password);

		return shop;
	}

	@PutMapping(value = "shops/{shopName}")
	public String updateShopOwners(@PathVariable String shopName, @RequestBody ShopOwnerDb shopOwnerDb) {

		shopOwnerDbDao.updateShopOwners(shopOwnerDb, shopName);

		return "Updated";
	}

	@DeleteMapping(value = "shops/{shopName}")
	public String deleteShopOwner(@PathVariable String shopName) {
		shopOwnerDbDao.deleteShopOwners(shopName);
		return "Record Deleted";
	}
	/* ShopOwner Functions Ends */
	
	
	/* MenuDb Functions */
	@PostMapping(value = "menu")
	public MenuDb saveMenu(@RequestBody MenuDb menuDb) {
		return menuDbDao.saveShopMenus(menuDb);
	}

	@GetMapping(value = "menu/{shopName}")
	public ArrayList<MenuDb> getAllmenu(@PathVariable @RequestBody String shopName) {
		return menuDbDao.getMenuById(shopName);
	}

	@GetMapping(value = "menu/{foodItem}/{shopName}")
	public MenuDb getAllmenus(@PathVariable String foodItem, @PathVariable String shopName) {
		return menuDbDao.getMenuByName(shopName, foodItem);
	}
	
	@PutMapping(value = "menu/{FoodItem}")
	public String updateFood(@PathVariable String FoodItem, @RequestBody MenuDb menuDb) {

		menuDbDao.updateFood(menuDb, FoodItem);

		return "Updated";
	}

	// @DeleteMapping(value="shops/{shopName}") public String
	// deletemenuu(@PathVariable String shopName,@PathVariable String foodItem) {
	// menuDbDao.deleteShopMenu(shopName, foodItem); return "Record Deleted"; }

	/* MenuDb Functions Ends */
	
	/* EmployeeDb Functions */
	@PostMapping(value = "employee")
	public EmployeeDb saveEmployee(@RequestBody EmployeeDb employeeDb) {
		return employeeDbDao.saveEmployee(employeeDb);
	}

	@GetMapping(value = "employee")
	public List<EmployeeDb> getAllEmployee() {
		return employeeDbDao.getAllEmployee();
	}

	
	@GetMapping(value = "employees/{employeeId}/{securityAnswer}")
	public Object getEmployeeById(@PathVariable String employeeId,@PathVariable String securityAnswer) {
		return employeeDbDao.getEmployeebyId(employeeId,securityAnswer);
	}

	@GetMapping(value = "employee/{employeeId}")
	public Object getEmployee(@PathVariable String employeeId) {
		return employeeDbDao.getEmployee(employeeId);
		
	}

	
	@PutMapping(value = "employee/{employeeId}/{password}")
	public String updatePassword(@PathVariable String employeeId, @PathVariable String password) {
		
		employeeDbDao.updateEmployee(employeeId,password);

		return "Updated";
	}
	
	@GetMapping(value = "employee/{employeeId}/{password}")
	public EmployeeDb getAuthe(@PathVariable String employeeId, @PathVariable String password) {
		EmployeeDb emp = employeeDbDao.Authentication(employeeId, password);

		return emp;
	}


	/* Employee Functions Ends */
	
	
	/* OrderDb Functions */
	@PostMapping(value = "order")
	public OrderDb saveOrder(@RequestBody OrderDb orderDb) {
		return orderDbDao.saveOrder(orderDb);
	}

	@GetMapping(value = "order/{shopName}")
	public Object getOrderbyId(@PathVariable String shopName) {
		return orderDbDao.getOrderbyId(shopName);
	}

	@GetMapping(value = "order")
	public ArrayList<OrderDb> getAllOrders() {

		return orderDbDao.getAllOrders();
	}

	@PutMapping(value = "order/{orderId}")
	public String updateOrder(@PathVariable String orderId, @RequestBody OrderDb orderDb) {

		orderDbDao.updateOrder(orderDb, orderId);

		return "Updated";
	}

	@GetMapping(value = "orders/{employeeId}")
	public ArrayList<OrderDb> getUserByName(@PathVariable String employeeId) {
		return orderDbDao.getOrderbyName(employeeId);
	}
	/* Order Function Ends */

	
}
