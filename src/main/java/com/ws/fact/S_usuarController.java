package com.ws.fact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class S_usuarController {

	
	@Autowired
    private S_usuarRepositoryDao s_usuarRepositoryDao;
     
    @GetMapping("/customers")
    public String listAll(Model model) {
        List<S_usuar> listCustomers = s_usuarRepositoryDao.findAll();
        model.addAttribute("listCustomers", listCustomers);  
        for (S_usuar elem : listCustomers) {
			listCustomers.toString();
			System.out.println("elemento"+elem.toString());
			System.out.println("usuario"+elem.getUsuario()+"descripcion"+elem.getDescrip());
		}
        
        return listCustomers.toString();
        //return "customers";
    }    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public String postBody(@RequestBody S_usuar user ) {
    	//System.out.println(user.toString());
    	//System.out.println(pass.toString());
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
    	//return user.toString();
    	return "ok";
    }
    
    
    @RequestMapping(value = "/login1", method = RequestMethod.POST, consumes = "application/json")
    public String postBody1(@RequestBody S_usuar user ) {
    	
    	S_usuar returnValue = new S_usuar() ; 
         returnValue.setUsuario(user.getUsuario());
         returnValue.setDescrip(user.getDescrip());
//    	    UserDto userDto = new UserDto () ; 
//    	    BeanUtils. copyProperties ( requestUserDetails, userDto ) ;
//    	    UserDto createdUser = userService. createUser ( userDto ) ;
//    	    BeanUtils. copyProperties ( createdUser, returnValue ) ;
    	//System.out.println(user.toString());
    	//System.out.println(pass.toString());
        //return new ResponseEntity(userCreated, HttpStatus.CREATED);
    	//return user.toString();
         return returnValue.toString();
    	//return "ok";
    }
    
    
    
    @RequestMapping(value = "/login3", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<LoginWS> Login(@RequestBody LoginWS login ) {
    	
    	LoginWS loginws = new LoginWS();
    	loginws.setTipo(login.getTipo());    	    
    	Integer aux=0;    	
    	loginws.setS_usuar(login.getS_usuar());
    	S_usuar s_usuar = new S_usuar();
    	s_usuar.setUsuario(loginws.getS_usuar().getUsuario());   
    	
    	List<S_usuar> listCustomers = s_usuarRepositoryDao.findAll();
       	for (S_usuar elem : listCustomers) {
    		if ((loginws.getS_usuar().getUsuario().equals((elem.getUsuario())) && 
    			(loginws.getS_usuar().getClave().equals((elem.getClave())) ))) {
    			aux=1;
    			System.out.println(loginws.getS_usuar().getUsuario());
    			
    			//return new ResponseEntity<LoginWS>(HttpStatus.ACCEPTED);    			
    		}
			System.out.println("elemento"+elem.toString());
			System.out.println("usuario"+elem.getUsuario()+"descripcion"+elem.getDescrip());
		}
            	        	
        return new ResponseEntity<LoginWS>(HttpStatus.BAD_REQUEST);

       	
    }
    
    
    @RequestMapping(value = "/login4", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> Login4(@RequestBody LoginWS login ) {
    	
    	Map<String, Object> response = new HashMap<>();
    	Map<String, Object> response1 = new HashMap<>();
    	
    	LoginWS loginws = new LoginWS();
    	loginws.setTipo(login.getTipo());    	    
    	Integer aux=0;    	
    	loginws.setS_usuar(login.getS_usuar());
    	S_usuar s_usuar = new S_usuar();
    	s_usuar.setUsuario(loginws.getS_usuar().getUsuario());   
    	
    	String[] value1 = new String[] { "value11", "value12", "value13" };
    	
    	List<S_usuar> listCustomers = s_usuarRepositoryDao.findAll();
       	for (S_usuar elem : listCustomers) {
    		if ((loginws.getS_usuar().getUsuario().equals((elem.getUsuario())) && 
    			(loginws.getS_usuar().getClave().equals((elem.getClave())) ))) {
    			aux=1;
    			response1.put("descripcion", elem);
    			response1.put("code", "1");
    			
    			System.out.println(loginws.getS_usuar().getUsuario());
    			response.put("response", response1);

    			return new ResponseEntity<Map<String,Object>>(response, HttpStatus.ACCEPTED);    		  			
    		}
			//System.out.println("elemento"+elem.toString());
			//System.out.println("usuario"+elem.getUsuario()+"descripcion"+elem.getDescrip());
		}
            	        	
        return new ResponseEntity<Map<String,Object>>(response, HttpStatus.BAD_REQUEST);

       	
    }
    
    
    
}
