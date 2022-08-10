<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<jsp:include page="navbar.jsp" />


<div class="container">
	<h3>Editar Empleado</h3>
	<c:if test="${employee !=null}">
		<form:form modelAttribute="employee" method="POST"
			action="/employeeForm">
			<div class="col-md-4">
				<label for="inputState" class="form-label">Tipo de Documento</label>
				<form:select class="form-select" path="tI">
					<form:option value="">Seleccionar</form:option>
					<form:option value="cc">Cédula de Ciudadanía</form:option>
					<form:option value="ce">Cédula Extranjera</form:option>
					<form:option value="pp">Pasaporte</form:option>
				</form:select>
				 <form:errors path="tI"></form:errors>
			</div>
			<div class="col-8">
				<label for="inputAddress" class="form-label">Número de
					Identificación</label>
				<form:input type="text" class="form-control" id="inputAddress"
					placeholder="" path="dni" />
				<form:errors path="dni"></form:errors>
			</div>
			<div class="col-md-6">
				<label for="inputEmail4" class="form-label">Nombre(s)</label>
				<form:input type="text" class="form-control" id="inputEmail4"
					path="name" />
				<form:errors path="name"></form:errors>
			</div>
			<div class="col-md-6">
				<label for="inputPassword4" class="form-label">Apellido</label>
				<form:input type="text" class="form-control" id="inputPassword4"
					path="lastName" />
				<form:errors path="lastName"></form:errors>
			</div>
			<div class="col-12">
				<label for="inputAddress" class="form-label">Fecha de
					Nacimiento</label>
				<form:input type="date" class="form-control" id="inputAddress"
					placeholder="" path="birthDate" />
				<form:errors path="birthDate"></form:errors>
			</div>

			<div class="col-md-4">
				<label for="inputState" class="form-label">Área de Trabajo</label>
				<form:select class="form-select" path="aT">
					<form:option value="">---Seleccionar---</form:option>
					<form:option value="administracion">Administración</form:option>
					<form:option value="contabilidad">Contabilidad</form:option>
					<form:option value="direccion">Dirección</form:option>
					<form:option value="produccion">Producción</form:option>
					<form:option value="sg">Seguridad y Salud en el Trabajo</form:option>
					<form:option value="sistemas">Sistemas</form:option>
				</form:select>
				<form:errors path="aT"></form:errors>
			</div>
			<div class="col-md-8">
				<label for="inputCity" class="form-label">Cargo</label>
				<form:input type="text" class="form-control" id="inputCity"
					path="position" />
				<form:errors path="position"></form:errors>
			</div>
			<div class="input-group ">
				<span class="input-group-text">$</span>
				<form:input type="text" class="form-control"
					aria-label="Amount (to the nearest dollar)" placeholder="Salario"
					path="salary" />
				<span class="input-group-text">.00</span>
				<form:errors path="salary"></form:errors>
			</div>
			<div class="col-12">
				<label for="inputCity" class="form-label">EPS</label>
				<form:input type="text" class="form-control" id="inputCity" path="EPS"/>
				<form:errors path="EPS"></form:errors>
			</div>
			<div class="col-12">
				<label for="inputCity" class="form-label">AFP</label> 
				<form:input type="text" class="form-control" id="inputCity" path="AFP"/>
				<form:errors path="AFP"></form:errors>
			</div>
			<div class="col-12">
				<label for="inputZip" class="form-label">ARL</label> 
				<form:input type="text" class="form-control" id="inputZip" path="ARL"/>
				<form:errors path="ARL"></form:errors>
			</div>
			<div class="col-12">
				<form:button type="submit" class="btn btn-primary">Enviar</form:button>
			</div>
		</form:form>
	</c:if>

</div>



<jsp:include page="footer.jsp" />