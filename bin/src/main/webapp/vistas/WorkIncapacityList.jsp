<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="navbar.jsp" />

<div class="container">
	<h3>Lista de Incapacidades</h3>
	<a href="/wi_form">Regitro de Incapacidades</a>
	<table class="table">
		<thead>
			<th>No Identificacion</th>
			<th>Nombre</th>
			<th>Apellidos</th>
			<th>Cargo</th>
			<th>Salario</th>
			<th>Salario/Día</th>
			<th>EPS</th>
			<th>Diagnostico</th>
			<th>Fecha Inicial</th>
			<th>Fecha Final</th>
			<th>Total Dias</th>
			<th>Clasificacion</th>
			<th>Valor Incapacidad</th>
			<th>Total Empresa</th>
			<th>Total EPS</th>
			<th>Total ARL</th>
			<th>Total Pensiones</th>
 			<th>Editar</th>
		</thead>
		<tbody>
			<c:forEach items="${listdisability}" var="emp">
				<tr>
					<td>${emp.getIdEmployee()}</td>
					<td>${emp.getName()}</td>
					<td>${emp.getLastName()}</td>
					<td>${emp.getPosition()}</td>
					<td>${emp.getSalary()}</td>
					<td>${emp.getSalaryPerDay()}</td>
					<td>${emp.getEPS()}</td>
					<td>${emp.getDiagnosis()}</td>
					<td>${emp.getStartDate()}</td>
					<td>${emp.getEndDate()}</td>
					<td>${emp.getTotalDays()}</td>
					<td>${emp.getClassification()}</td>
					<td>${emp.getDisabilityValue()}</td>
					<td>${emp.getValueForTheCompany()}</td>
					<td>${emp.getEPSTotal()}</td>
					<td>${emp.getARLTotal()}</td>
					<td>${emp.getPensionsTotal()}</td>
					<td><a href="/update_disability?id=${emp.getId()}"><button
								type="button" class="btn btn-primary">Editar</button></a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<jsp:include page="footer.jsp" />