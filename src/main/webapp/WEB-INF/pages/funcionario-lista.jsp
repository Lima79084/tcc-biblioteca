<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.108.0">
<title>Biblioteca</title>

</head>


<!-- Jquery / Datable Scripts -->
<!-- Javascript-->
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.13.2/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.13.2/js/dataTables.bootstrap5.min.js"></script> <!-- ? -->
<script src="https://cdn.datatables.net/fixedheader/3.3.1/js/dataTables.fixedHeader.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.4.0/js/dataTables.responsive.min.js"></script>
<script src="https://cdn.datatables.net/responsive/2.4.0/js/responsive.bootstrap.min.js"></script>

<!-- CSS -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.13.2/css/dataTables.bootstrap5.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/fixedheader/3.3.1/css/fixedHeader.bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/responsive/2.4.0/css/responsive.bootstrap.min.css">

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.inputmask/5.0.7/jquery.inputmask.min.js"></script>

<body>

	<c:import url="menu.jsp" />
	
	<div class="container">

		<div class="content-wrapper">

			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-12" align="right">
							<a href="novo" class="btn btn-primary">Cadastrar Funcion�rio</a>
						</div>
					</div>
				</div>
			</div>

			<c:if test="${sucesso == true}">
				<div class="alert alert-success alert-dismissible fade show" role="alert">
					<strong>Sucesso!</strong> Opera��o realizada com sucesso.
					<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
				</div>
			</c:if>


			<!-- Main content -->
			<section class="content">

				<div class="container-fluid">
					<div class="row">
						<div class="col-12">

							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Funcion�rios Cadastrados</h4>
								</div>
								<div class="card-body">
									<table id="tabela" class="table table-striped" style="width: 100%">
										<thead>
											<tr>
												<th width="20%">Matr�cula</th>
												<th width="30%">Nome</th>
												<th width="30%">E-mail</th>
												<th width="20%">A��es</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="funcionario" items="${listFuncionario}">
												<tr>
													<td>${funcionario.matricula}</td>
													<td>${funcionario.nome}</td>
													<td>${funcionario.email}</td>
													<td><a href="editar?id=${funcionario.id}">Editar</a> | 
														<a href="deletar?id=${funcionario.id}">Deletar</a> |
														<a href="editar-senha?id=${funcionario.id}">Alterar Senha</a>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>

	</div>

	<script type="text/javascript">
		$(function() {
			$("#tabela")
					.DataTable(
							{
								"responsive" : true,
								"autoWidth" : false,
								"language" : {
									"url" : "//cdn.datatables.net/plug-ins/1.10.19/i18n/Portuguese-Brasil.json"
								},
							});
		});
	</script>

	<c:import url="footer.jsp" />

</body>
</html>

