package com.example.demo;


import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.demo.model.Transaction;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TestController {

	@Autowired
    private BudgetController controller;

	public TestController()
	{
		
	}
	
    @Autowired
    UserRepository userRepository;
    
    
     
    @Test
    public void testAddEmployee() 
    {
         
        //when(userRepository.addEmployee(any(User.class))).thenReturn(true);
         
        //User user = new User("5f5b2e6f1cbb0c73811dba4d","Priya", { "Utilities" : [ { "name" : "Water", "expense" : 10000 } ], "Insurance" : [ { "name" : "Medical", "expense" : 1000 } ] }, { "Utilities" : 2000, "Insurance" : 1000 }`);
        //User user = new User(new ObjectId("5f5b2e6f1cbb0c73811dba4d"), "Snigdha", new HashMap<String, List<Transaction>>(), new HashMap<String, Double>());
        //User user = new User("priya");
//        User user = new User();
//        user.setName("priya");
//        User response = controller.createUser(user);
//         
//        //assert(response == null);
//        assert(response.getName().equals("priya"));
        //assertThat(response.getStatusCodeValue()).isEqualTo(201);
        //assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
        
//        User user = new User("priya");
//        // when
//        User found = userRepository.findBy_id(user.getId());
//	  
//	     // then
//	     assertThat(found.getName())
//	       .isEqualTo(alex.getName());
//         User user = new User(new ObjectId("5f5b40e412880b4eb92e95f6"), "vasu", null, null) ;
//         User user1 = userRepository.findBy_id(user._id);
//         assert(user1.getName()).equals("vasu");
        
        User user = new User();
        user.setName("priya");
        User response = controller.createUser(user);
       
        //assert(user.getName().equals("priya"));
        assert(response.getName().equals("priya"));

    }
     
    @Test
    public void testFindAll() 
    {
        // given
//        Employee employee1 = new Employee(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
//        Employee employee2 = new Employee(2, "Alex", "Gussin", "example@gmail.com");
//        Employees employees = new Employees();
//        employees.setEmployeeList(Arrays.asList(employee1, employee2));
// 
//        when(employeeDAO.getAllEmployees()).thenReturn(employees);
// 
//        // when
//        Employees result = employeeController.getEmployees();
// 
//        // then
//        assertThat(result.getEmployeeList().size()).isEqualTo(2);
//         
//        assertThat(result.getEmployeeList().get(0).getFirstName())
//                        .isEqualTo(employee1.getFirstName());
//         
//        assertThat(result.getEmployeeList().get(1).getFirstName())
//                        .isEqualTo(employee2.getFirstName());
    }

}
