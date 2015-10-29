package com.mycompany.eai.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.mycompany.eai.beans.UserBean;
import com.mycompany.eai.model.User;

/**
 * Operation for retrieving User details.
 * 
 */

@Path("/user")
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
public class UserResource {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserResource.class);
	
	@Autowired
	private UserBean userBean;

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	@GET
    @Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public User findById(@PathParam("id")String id) {
		LOGGER.info("UserResource: findById()");
		return userBean.findById(id);
	}
	
	@GET
    @Path("/all")
	public List<User> findAll() {
		LOGGER.info("UserResource: findAll()");
		return userBean.findAll();
	}
	
    /**
     * Create User
     * 
     * @param User
     *     user 
     */	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public User createUser(User user) {
		LOGGER.info("UserResource: createUser()");
		userBean.createUser(user);
		return user;
	}
	
    /**
     * Update User
     * 
     * @param id, User
     *     id, user 
     */		
	@PUT
    @Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public User updateUser(@PathParam("id")String id, User user) {
		LOGGER.info("UserResource: updateUser()");
		return userBean.updateUser(id, user);
	}
	
    /**
     * Delete User
     * 
     * @param id
     *     User Identifier
     */
    @Path("{id}")
    @DELETE
	public Response deleteUser(@PathParam("id") String id) {	
		    	
		LOGGER.info("UserResource: deleteUser()");
    	User result = userBean.findById(id);
		if (result!=null) {
			if (userBean.deleteUserById(id)!=null){
				return Response.status(Status.OK)
				        	.entity("Record deleted.")
				        	.type(MediaType.APPLICATION_JSON)
				        	.build();
			}
		}
		return Response.status(Status.NOT_FOUND)
				        .entity("No record found!")
				        .type(MediaType.APPLICATION_JSON)
				        .build();
    }
    /**
     * Login User by email & password
     * 
     * @param email, password
     *     
     */
    @Path("email/{email}/password/{password}")
    @GET
	public Response loginUser(@PathParam("email") String email, @PathParam("password") String password) {	
		LOGGER.info("UserResource: loginUser()");
    	User result = userBean.findByEmailAndPassword(email, password);
    	if (result!=null) {
			return Response.status(Status.OK)
		        	.entity("Login passed.")
		        	.type(MediaType.APPLICATION_JSON)
		        	.build();    		
    	}else{
    		return Response.status(Status.FORBIDDEN)
			        .entity("Invalid credentials!")
			        .type(MediaType.APPLICATION_JSON)
			        .build();    		
    	}
        
    }
}
