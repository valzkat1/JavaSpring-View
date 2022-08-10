package org.fundacionview.SGSST.repositories;

import java.util.ArrayList;

import org.fundacionview.SGSST.models.Permissions;
import org.fundacionview.SGSST.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RepositoryPermissions extends JpaRepository<Permissions, Integer>{

	public ArrayList<Permissions> findByRolesAndWorkspaceIn(Roles roles, String... sworkspace);
	
	@Query(value = "SELECT * FROM permisos WHERE workspace=:modulo AND roles=:rol", nativeQuery = true)
	public Permissions queryRolPermissions(@Param("rol")String rol, @Param("module")String module);
}
