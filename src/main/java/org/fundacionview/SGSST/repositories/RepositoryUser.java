package org.fundacionview.SGSST.repositories;

import java.util.Optional;

import org.fundacionview.SGSST.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryUser extends JpaRepository<User, Integer> {

	@Query("FROM User WHERE username=:username AND pass=:pass")
	public User loginUser(@Param("username")String username, @Param("pass")String pass);
	
	@Query(value ="SELECT * FROM usuarios WHERE id_employee=:id_employee LIMIT 1", nativeQuery = true)
	public User checkUserExistence(@Param("id_employee")int id_employee);
	
	public Optional<User> findByUsername(String username);
}
