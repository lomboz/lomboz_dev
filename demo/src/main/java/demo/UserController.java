package demo;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

	Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	UserRepository userRepo;
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@RequestMapping("/resource")
	public Map<String, Object> home() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("id", UUID.randomUUID().toString());
		model.put("content", "Hello World");
		return model;
	}
	
	@RequestMapping("/users")
	public Iterable<User> users(){
		logger.debug("DEBUG");
		logger.info("INFO");
		logger.warn("WARN");
		logger.error("ERROR");
		
		return userRepo.findAll(); 
	}
}
