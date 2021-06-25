package com.sp.controllers;
import java.util.List;
import java.util.Optional;

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

import com.sp.entities.Customer;
import com.sp.entities.Employee;
import com.sp.entities.User;
import com.sp.services.EmployeeService;
//import com.sp.entities.CustomerResource;
import com.sp.services.UserService;
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,allowedHeaders={"Authorization","Access-Control-Request-Headers","Content-Type","Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Access-Control-Allow-Headers"})
@RestController
@RequestMapping("/rest")
public class CustomerController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private UserService userService;
	//@Autowired
	//private ProductService productservice
	
	
	@PostMapping("/employees")
		 public ResponseEntity<? extends Employee> addEmployee(@RequestBody Employee e)
		  {	
		System.out.println("in emp add service");
			 
		  employeeService.addEmployee(e);
			 return new ResponseEntity<Employee>((Employee) e,HttpStatus.CREATED);

	}
	@PutMapping("/employees")
	 public ResponseEntity<? extends Employee> updateEmployee(@RequestBody Employee e)
	  {	
		 
	  employeeService.updateEmployee(e);
		 return new ResponseEntity<Employee>((Employee) e,HttpStatus.CREATED);

}

	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmps(){
		  
		  List<Employee> emplist =  employeeService.listAllEmployees();
		    
		  return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);  }

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getAEmpById(@PathVariable  Long id){
		  
		 Employee emp =  employeeService.listEmployeeById(id);
		    
		  return new ResponseEntity<Employee>(emp, HttpStatus.OK);  }

	 @DeleteMapping("/employees/{id}")public ResponseEntity<Employee> deleteEm(@PathVariable Long id){
		 Employee c = employeeService.listEmployeeById(id);
		 employeeService.deleteEmployee(id);
	  	return new ResponseEntity<Employee>(c,HttpStatus.OK);
	  	}
	
	  @PostMapping("/customers")
  public ResponseEntity<? extends User> addUser(@RequestBody User customer)
  {
	  
	  userService.addUser(customer);
	  if(customer instanceof Customer) {
		  
		  return new ResponseEntity<Customer>((Customer) customer,HttpStatus.CREATED);
	  }
	  
	  return new ResponseEntity<User>(customer, HttpStatus.CREATED);
	  }
    @GetMapping("/customers")
  public ResponseEntity<List<User>> getAllCust(){
	  
	  List<User> custlist =  userService.listAllUsers();
	    
	  return new ResponseEntity<List<User>>(custlist, HttpStatus.OK);  }
 //below methods you will implement
    @PutMapping("/customers")public ResponseEntity<User> updateCustomer(@RequestBody User c){
    	 c = userService.updateUser(c);
    	return new ResponseEntity<User>(c,HttpStatus.OK);
    	}
  //in the request body you will send the object to be updated ,will have id
  
  @DeleteMapping("/customers/{id}")public ResponseEntity<User> deleteCustomerById(@PathVariable Integer id){
	 Optional<User> c = userService.listUserById(id);
	  User c1 =  c.get();
	  userService.deleteUser(id);
	 
  	return new ResponseEntity<User>(c1,HttpStatus.OK);
  	}
	  
  
  
  @DeleteMapping("/customers")public ResponseEntity<Customer> deleteCustomer(@RequestBody Customer c){return null;} 
  //which entity you want to delete as RequestBody
  
  @GetMapping("/customers/{id}")
    
  public  ResponseEntity<User> getCustomer(@PathVariable long id){
	  
	  Optional<User> c=  userService.listUserById(id);
	  User c1 =c.get();
	  
	 return new ResponseEntity<User>(c1,HttpStatus.OK);
	  
	  
  }
  @CrossOrigin(origins = "http://localhost:4200", maxAge = 3600,allowedHeaders={"Authorization","Access-Control-Request-Headers","Content-Type","Access-Control-Allow-Origin","Access-Control-Allow-Credentials","Access-Control-Allow-Headers"})

  @PostMapping("/login")
  public ResponseEntity<User> loginCustomer(@RequestBody User c){
	   
	 System.out.println("in controller for login");
	User u=   userService.findUser(c)  ;
	System.out.println(u + "valid user");
	return new ResponseEntity<User>(u,HttpStatus.OK);  
  }
	  
  } 
	
  


