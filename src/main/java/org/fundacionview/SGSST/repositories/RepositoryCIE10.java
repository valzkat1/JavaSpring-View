package org.fundacionview.SGSST.repositories;

import java.util.ArrayList;

import org.fundacionview.SGSST.models.CIE10;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCIE10 extends JpaRepository<CIE10, Integer>{

	@Query("FROM CIE10 WHERE LOWER(codigo) LIKE %:codig% OR LOWER(diagnostico) LIKE %:codig%")
	public ArrayList<CIE10> autocompleteDiagnoses(@Param("codig")String codig);
	
	@Query("FROM CIE10 WHERE LOWER(codigo)=:codi")
	public CIE10 getDiagnosis(@Param("codi")String codi);
}
