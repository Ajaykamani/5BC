package com.cts.employeeService.controller;


import java.nio.charset.StandardCharsets;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.employeeService.entityClass.User;
import com.cts.employeeService.modelClass.ResponseData;
import com.cts.employeeService.repository.UserRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin("http://localhost:4200")
@Api(value="Employee management System")
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@ApiOperation(value="requesting login page and to check credentials")
	@GetMapping("/login")
	public ResponseEntity<ResponseData> login(HttpServletRequest request) {
		// if called then credentials are valid
		
		String authorization = request.getHeader("Authorization");
		String[] values = null;
		
		if (authorization != null && authorization.startsWith("Basic")) {
		    // Authorization: Basic base64credentials
		    String base64Credentials = authorization.substring("Basic".length()).trim();
		    byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
		    String credentials = new String(credDecoded, StandardCharsets.UTF_8);
		    // credentials = username:password
		    values = credentials.split(":", 2);
		}
		
		
		logger.info("Logged In...");
		logger.info(values[0]);
		logger.info(values[1]);
        
        User user = this.userRepository.findByuserName(values[0]).get(0);
        logger.info("User : " + user);
        // add any additional information like firstname, lastname, profilepic etc
		
        ResponseData data = new ResponseData("Welcome!!!", System.currentTimeMillis(), user.getUserId(),user.getUserName(),user.getRole());

		ResponseEntity<ResponseData> response = 
					new ResponseEntity<ResponseData>(data, HttpStatus.OK);
		
		return response;
		
	}

}
