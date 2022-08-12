package org.fundacionview.SGSST.repositories;

import java.util.ArrayList;

import org.fundacionview.SGSST.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryEmployee extends JpaRepository<Employee, Integer> {

	@Query(value ="SELECT * FROM empleados LIMIT 1", nativeQuery = true)
	public Employee nativeQuery();
	
	@Query(value = "FROM Employee WHERE LOWER(name) LIKE %:text%")
	public ArrayList<Employee> listEmployeeByName(@Param("text")String text);
	
	@Query("FROM Employee WHERE dni=:cc")
	public Employee queryById(@Param("cc")Long cc);
}
