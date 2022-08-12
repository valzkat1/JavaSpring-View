<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:include page="navbar.jsp" />

<div class="container">
	<div class="container">
		<h3>Registro de Incapacidad</h3>
		<form:form class="row g-3" action="/wi_form" method="POST" modelAttribute="incapacity">
			<div class="col-md-4">
				<label for="inputText1" class="form-label">Tipo de Documento</label>
				<form:select class="form-select" path="tI">
					<form:option value="">Seleccionar</form:option>
					<form:option value="">Cédula de Ciudadanía</form:option>
					<form:option value="">Cédula Extranjera</form:option>
					<form:option value="">Pasaporte</form:option>
				</form:select>
				<form:errors path="tI"></form:errors>
			</div>
			<div class="col-8">
				<label for="inputText1" class="form-label">Identificación Empleado</label>
				<form:input type="text" class="form-control" id="nombreEmpleado" path="dni"/>
				<form:errors path="dni"></form:errors>
			</div>
			<div class="col-md-6">
				<label for="inputID1" class="form-label">Nombre Empleado</label>
				<form:input type="text" class="form-control" id="dataEmpleado" path="name"/>
				<form:errors path="name"></form:errors>
			</div>
			<div class="inputText1">
				<label for="inputID1" class="form-label">Apellido Empleado</label>
				<form:input type="text" class="form-control" id="dataEmpleado" path="lastName"/>
				<form:errors path="lastName"></form:errors>
			</div>
			<div class="col-12">
				<label for="dataDiagnosti" class="form-label">Cargo</label>
				<form:input type="text" class="form-control" id="cargo" path="position"/>
				<form:errors path="position"></form:errors>
			</div>
			<div class="col-md-6">
				<label for="dataDiagnosti" class="form-label">Salario</label>
				<form:input type="text" class="form-control" id="salario"  path="salary" onblur="calcularSalario()" />
				<form:errors path="salary"></form:errors>
			</div>
			<div class="col-md-6">
				<label for="dataDiagnosti" class="form-label">Salario Día</label>
				<form:input type="text" class="form-control" id="salarioDia" path="salaryPerDay"/>
				<form:errors path="salaryPerDay"></form:errors>
			</div>
			<div class="col-md-6">
				<label for="nombreDiagnosti" class="form-label">Diagnóstico</label>
				<form:input type="text" class="form-control" id="nombreDiagnosti" name="nombreDiagnosti" path="diagnostico"/>
				<form:errors path="diagnostico"></form:errors>
			</div>
			<div class="col-md-6">
				<label for="dataDiagnosti" class="form-label">Código CIE10</label>
				<form:input type="text" class="form-control" id="dataDiagnosti" name="dataDiagnosti" path="codigo"/>
				<form:errors path="codigo"></form:errors>
			</div>
			<div class="col-md-4">
				<label for="dataDiagnosti" class="form-label">EPS</label>
				<form:input type="text" class="form-control" id="eps" path="EPS"/>
				<form:errors path="EPS"></form:errors>
			</div>
			<div class="col-md-4">
				<label for="dataDiagnosti" class="form-label">Tipo De Incapacidad</label>
				<form:select class="form-select" path= "typeOfDisability">
					<form:option value="">---Seleccionar---</form:option>
					<form:option value="ec">Enfermedad Común</form:option>
					<form:option value="licm">Licencia de Maternidad</form:option>
					<form:option value="licp">Licencia de Paternidad</form:option>
					<form:option value="acct">Accidente de Trabajo</form:option>
					<form:option value="el">Enfermedad Laboral</form:option>
					<form:option value="fp">Fondo de Pensiones</form:option>
					<form:option value="act">Accidente de Tránsito</form:option>
				</form:select>
				<form:errors path="typeOfDisability"></form:errors>
			</div>
			<div class="col-md-4">
				<label for="dataDiagnosti" class="form-label">Clasificación</label>
				<form:select class="form-select" path="classification">
					<form:option value="">---Seleccionar---</form:option>
					<form:option value="ini">Inicial</form:option>
					<form:option value="pro">Prorroga</form:option>
				</form:select>
				<form:errors path="classification"></form:errors>
			</div>

			<div class="col-md-5">
				<label for="dataDiagnosti" class="form-label">Fecha Inicial</label>
				<form:input type="date" class="form-control" id="fechaInicio" path="startDate"/>
				<form:errors path="startDate"></form:errors>
			</div>
			<div class="col-md-5">
				<label for="dataDiagnosti" class="form-label">Fecha Fin</label>
				<form:input type="date" class="form-control" id="fechaFin" path="endDate" onchange="calcularDias()" onblur="calcularDias()"/>
				<form:errors path="endDate"></form:errors>
			</div>
			<div class="col-md-2">
				<label for="dataDiagnosti" class="form-label">Total Días</label>
				<form:input type="text" class="form-control" id="totalDias" path="totalDays"/>
				<form:errors path="totalDays"></form:errors>
			</div>
			<div class="col-12">
				<form:button type="submit" class="btn btn-primary">Enviar</form:button>
			</div>
		</form:form>
</div>
	<jsp:include page="footer.jsp" />

<script type="text/javascript">
function calcularDias(){
	var fechaIni = document.getElementById("fechaInicio").value;
	var fechaFin = document.getElementById("fechaFin").value;
	
	var fecha1= Date.parse(fechaIni);
	var fecha2= Date.parse(fechaFin);
	
	var diferencia=fecha2-fecha1;
	
	//var totalDias=(diferencia/1000)/60/60/24;
	var totalDias=(diferencia/(3600*1000*24));
	
	document.getElementById("totalDias").value=totalDias;
}

function calcularSalario(){
	var totalDia= (document.getElementById("salario").value)/30;
	
	document.getElementById("salarioDia").value=totalDia;
}

const autoCompleteConfig = [{
    name: 'Employee',
    debounceMS: 250,
    minLength: 3,
    maxResults: 20,
    inputSource: document.getElementById('nombreEmpleado'),
    targetID: document.getElementById('dataEmpleado'),
    fetchURL: 'http://localhost:8087/api/empleados?text={term}',
    fetchMap: {id: "id_user",
               name: "nombre"}
  },
  {
	    name: 'Diagnosticos',
	    debounceMS: 250,
	    minLength: 3,
	    maxResults: 20,
	    inputSource: document.getElementById('nombreDiagnosti'),
	    targetID: document.getElementById('dataDiagnosti'),
	    fetchURL: 'http://localhost:8087/api/diagnosticos?text={term}',
	    fetchMap: {id: "codigo",
	               name: "diagnostico"}
	  }
];
//console.log(autoCompleteConfig);
// Initiate Autocomplete to Create Listeners
autocompleteBS(autoCompleteConfig);
function resultHandlerBS(inputName, selectedData) {
  console.log(inputName);
  console.log(selectedData);
}
</script>