package com.grokonez.spring.restapi.mysql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.grokonez.spring.restapi.mysql.model.*;
import com.grokonez.spring.restapi.mysql.repo.MenuRepository;
import com.grokonez.spring.restapi.mysql.repo.OptionRepository;
import com.grokonez.spring.restapi.mysql.util.TreeUtil;
import com.grokonez.spring.restapi.mysql.util.TreeUtil2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.spring.restapi.mysql.repo.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	CustomerRepository repository;

	@Autowired
	OptionRepository optionRepo;

	@Autowired
	MenuRepository menuRepo;

	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		System.out.println("Get all Customers...");

		List<Customer> customers = new ArrayList<>();
		repository.findAll().forEach(customers::add);

		return customers;
	}


	@GetMapping("/options")
	public List<Option> getAllOptions() {
		List<Option> options = new ArrayList<>();
		optionRepo.findAll().forEach(options::add);

		return options;
	}


	/**
	 * 根据数据返回树型结构
	 * @return
	 */
	@GetMapping("/menu2")
	public List<MenuItem> getMenuItems() {

		List<MenuEntity> data0 = new ArrayList<>();
		menuRepo.findAll().forEach(data0::add);

		System.out.println("E#####=" + data0.size());
		List<MenuItem> data = new ArrayList<>();
		for (MenuEntity e : data0) {
			MenuItem ee = new MenuItem();
			ee.setEntity(e);


			data.add(ee);
		}


		List<MenuItem> list = new ArrayList<>();//返回的最终集合，可根据自己返回类型更改。
		List<MenuItem> tree = TreeUtil2.getTreeList(0L, data );//调用工具类，第一个参数是默认传入的顶级id，和查询出来的数据

		return tree;
	}

	/**
	 * 根据数据返回树型结构
	 * @return
	 */
	@GetMapping("/menu")
	public List<MenuOption> getparticipants() {

		List<MenuEntity> data0 = new ArrayList<>();
		menuRepo.findAll().forEach(data0::add);

		System.out.println("E#####=" + data0.size());
		List<MenuOption> data = new ArrayList<>();
		for (MenuEntity e : data0) {
			System.out.println(e);
			MenuOption ee = new MenuOption();
			ee.setId(e.getId());
			ee.setName(e.getName());
			ee.setParentId(e.getParentId());
			ee.setParentFlag(e.isParentFlag());
			ee.setAlias(e.getName());
			data.add(ee);
		}


		List<MenuOption> list = new ArrayList<>();//返回的最终集合，可根据自己返回类型更改。
		List<MenuOption> tree = TreeUtil.getTreeList(0L, data );//调用工具类，第一个参数是默认传入的顶级id，和查询出来的数据

/*		MenuOption result = new MenuOption();//我在已经生成好的树形结构外面有包了一层。视情况而定，可以不用写
		result.setId(0L);
		result.setName("请选择参与部门");
		result.setChildList(tree);
		list.add(result);//把对象放到list中，前台element-ui中的树形控件需要的是数组的集合

		return list;*/

		return tree;

	}


	@PostMapping("/customer")
	public Customer postCustomer(@RequestBody Customer customer) {

		Customer _customer = repository.save(new Customer(customer.getName(), customer.getAge()));
		return _customer;
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") long id) {
		System.out.println("Delete Customer with ID = " + id + "...");

		repository.deleteById(id);

		return new ResponseEntity<>("Customer has been deleted!", HttpStatus.OK);
	}

	@GetMapping("customers/age/{age}")
	public List<Customer> findByAge(@PathVariable int age) {

		List<Customer> customers = repository.findByAge(age);
		return customers;
	}

	@PutMapping("/customer/{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long id, @RequestBody Customer customer) {
		System.out.println("Update Customer with ID = " + id + "...");

		Optional<Customer> customerData = repository.findById(id);

		if (customerData.isPresent()) {
			Customer _customer = customerData.get();
			_customer.setName(customer.getName());
			_customer.setAge(customer.getAge());
			_customer.setActive(customer.isActive());
			return new ResponseEntity<>(repository.save(_customer), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
