<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
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

			<section class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="col-12">

							<div class="card">
								<div class="card-header">
									<h4 class="card-title">Empr�stimos Realizados</h4>
								</div>
								<!-- /.card-header -->
								<div class="card-body">
									<table id="table" class="table table-striped"
										style="width: 100%">
										<thead>
											<tr>
												<th>Identificador</th>
												<th>Cliente</th>
												<th>Data Empr�stimo</th>
												<th>Data P/ Entrega</th>
												<th>Data Entrega</th>
												<th>Status</th>
												<th>A��es</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="emprestimo" items="${lista}">
												<tr>
													<td>${emprestimo.identificador}</td>
													<td>${emprestimo.cliente.nome}</td>
													<td>${emprestimo.dataEmprestimoFormatada}</td>
													<td>${emprestimo.dataPrevisaoEntregaFormatada}</td>
													<td>${emprestimo.dataEntregaFormatada}</td>
													<td>${emprestimo.statusStr}</td>
													<td><a href="vizualizar?id=${emprestimo.id}">Vizualizar</a></td>
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
			$("#table")
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

