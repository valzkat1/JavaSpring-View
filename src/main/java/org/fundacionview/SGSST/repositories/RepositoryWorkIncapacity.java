package org.fundacionview.SGSST.repositories;

import org.fundacionview.SGSST.models.WorkIncapacity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryWorkIncapacity extends JpaRepository<WorkIncapacity, Integer>{

}
