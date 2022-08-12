<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navbar.jsp" />

<div class="container">
	<h3>Lista de Empleados</h3>
	<a href="/employeeForm">Crear Empleado</a>
	<table class="table">
		<thead>
			<th>Tipo ID</th>
			<th>No Identificacion</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Cargo</th>
			<th>Fecha Nacimiento</th>
			<th>Salario</th>
			<th>Editar</th>
			<th>Eliminar</th>
			<th>Usuario</th>
		</thead>
		<tbody>
			<c:forEach items="${employeeList}" var="emp">
				<tr>
					<td>${emp.gettI()}</td>
					<td>${emp.getDNi()}</td>
					<td>${emp.getName()}</td>
					<td>${emp.getlastName()}</td>
					<td>${emp.getposition()}</td>
					<td>${emp.getBirthDate()}</td>
					<td>${emp.getSalary()}</td>
					<td><a href="/update_employee?id=${emp.getId()}"><button
								type="button" class="btn btn-primary">Editar</button></a></td>
					<td><a href="/delete_employee?id=${emp.getId()}"><button
								type="button" class="btn btn-danger">Eliminar</button></a></td>
					<td><a href="/create_user?id=${emp.getId()}"><button
								type="button" class="btn btn-success">Usuario</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="footer.jsp" />