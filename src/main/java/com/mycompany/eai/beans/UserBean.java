package com.mycompany.eai.beans;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.eai.model.User;
import com.mycompany.eai.repo.UserRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Component
@Transactional
public class UserBean {

	/**
	 * The Logger.
	 */
	public static final Logger LOGGER = LoggerFactory.getLogger(UserBean.class);

	@Autowired
	private UserRepository userRepository;

	/**
	 * Instantiates a new user bean.
	 */
	public UserBean() {
	}

	/**
	 * Find all.
	 *
	 * @param 
	 * @return all users
	 */
	public List<User> findAll() {
		LOGGER.info("UserBean:: getAllUsers()");
		List<User> userList = userRepository.findAll();
		return userList;
	}

	/**
	 * Find by id.
	 *
	 * @param id
	 *            the id
	 * @return the user
	 */
	public User findById(String id) {
		LOGGER.info("UserBean:: getUserById() id=" + id);
		User user = userRepository.findById(id);
		return user;
	}

	/**
	 * Save user.
	 *
	 * @param user
	 *            the user
	 * @return the user
	 */
	@Transactional
	public User createUser(User user) {
		LOGGER.info("UserBean:: saveUser()");
		user = userRepository.save(user);
		return user;
	}

	/**
	 * Delete user.
	 *
	 * @param user
	 *            the user
	 * @return 
	 */
	@Transactional
	public void deleteUser(User user) {
		LOGGER.info("UserBean:: deleteUserById()");
		userRepository.delete(user);
	}

	/**
	 * Delete user by Id.
	 *
	 * @param id
	 *            the userId
	 * @return 
	 */
	@Transactional
	public User deleteUserById(String id) {
		LOGGER.info("UserBean:: deleteUserById() id=" + id);
		return userRepository.deleteById(id);
	}
	
	/**
	 * Delete user.
	 *
	 * @param user
	 *            the user
	 * @return 
	 */
	@Transactional
	public User updateUser(String id, User user) {
		LOGGER.info("UserBean:: updateUser() id=" + id);
		return userRepository.update(user.getName(), user.getEmail(), user.getAddress(), user.getPassword(), id);
	}

	/**
	 * Find user by email & password.
	 *
	 * @param user
	 *            the user
	 * @return email, password
	 */
	public User findByEmailAndPassword(String email, String password) {
		LOGGER.info("UserBean:: findByEmailAndPassword() email=" + email);
		return userRepository.findByEmailAndPassword(email, password);
	}
	
	/**
	 * Sets the user repository.
	 *
	 * @param userRepository
	 *            the new user repository
	 */
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}	
}
