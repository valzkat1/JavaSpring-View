<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="navbar.jsp" />
<div class="container">
	<h3>Lista de Usuarios</h3>
	<table class="table">
		<thead>
			<th>Nombre Usuario</th>
			<th>Contraseña</th>
			<th>Editar</th>
			<th>Eliminar</th>
		</thead>
		<tbody>
			<c:forEach items="${listaUsuario}" var="user">
				<tr>
					<td>${user.getUsername}</td>
					<td>${user.getPass}</td>
					<td><a href="/delete_user?id=${user.getId()}"><button type="button" class="btn btn-primary">Editar</button></a></td>
					<td><button type="button" onclick="confirmDeleteUser(${user.getId()})" class="btn btn-danger">Eliminar</button></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<script>
function confirmDeleteUser(idEm){
	if(confirm("¿Esta seguro de elimiar Usuario?")){
		window.location.href="/delete_user?id="+idEm;
	}
	 //return Confirm("Esta seguro de eliminar usuario?")
}
</script>
<jsp:include page="footer.jsp" />
