package com.mycompany.eai.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mycompany.eai.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, String>{
	
		
	/**
	 * Find all.
	 *
	 * @param 
	 * @return all users
	 */
	@Query("select c from User c")
	List<User> findAll();

	/**
	 * Find by userId.
	 *
	 * @param userId
	 *            the user id
	 * @return the user
	 */
	@Query("select c from User c where  c.id = :id")
	User findById(@Param("id") String id);

	
	/**
	 * Find by email and password.
	 *
	 * @param email
	 * @param password
	 * @return the User
	 */
	@Query("select s from User s where s.email = :email and s.password = :password")
	User findByEmailAndPassword(@Param("email") String email,
			@Param("password") String password);

	/**
	 * Update by userId.
	 *
	 * @param userId
	 *            the user id
	 * @return the user
	 */
	@Query("update User s SET s.name = :name, s.email = :email, s.address = :address, s.password = :password where  c.id = :id")
	User update(@Param("id") String id, @Param("name") String name, @Param("email") String email, @Param("address") String address, @Param("password") String password);
	
	/**
	 * Delete by userId.
	 *
	 * @param userId
	 *            the user id
	 * @return the user
	 */	
	@Query("Delete c from User c where  c.id = :id")
	User deleteById(@Param("id") String id);
}
