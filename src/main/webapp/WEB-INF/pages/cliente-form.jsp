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
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.108.0">
<title>Biblioteca</title>

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

.b-example-divider {
	height: 3rem;
	background-color: rgba(0, 0, 0, .1);
	border: solid rgba(0, 0, 0, .15);
	border-width: 1px 0;
	box-shadow: inset 0 .5em 1.5em rgba(0, 0, 0, .1), inset 0 .125em .5em
		rgba(0, 0, 0, .15);
}

.b-example-vr {
	flex-shrink: 0;
	width: 1.5rem;
	height: 100vh;
}

.bi {
	vertical-align: -.125em;
	fill: currentColor;
}

.nav-scroller {
	position: relative;
	z-index: 2;
	height: 2.75rem;
	overflow-y: hidden;
}

.nav-scroller .nav {
	display: flex;
	flex-wrap: nowrap;
	padding-bottom: 1rem;
	margin-top: -1px;
	overflow-x: auto;
	text-align: center;
	white-space: nowrap;
	-webkit-overflow-scrolling: touch;
}
</style>

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
				<div class="bancoiner-fluid">
					<div class="row">

						<div class="col-md-12">
							<div class="card">

								<div class="card-header">
									<c:choose>
										<c:when test="${cliente.id == null}">
											<h4 class="card-title">Cadastrar Cliente</h4>
										</c:when>
										<c:otherwise>
											<h4 class="card-title">Alterar Cliente</h4>
										</c:otherwise>
									</c:choose>
								</div>
								
								<form:form action="salvar" method="post" modelAttribute="cliente">

									<input type="hidden" id="id" name="id" value="${cliente.id}">

									<div class="card-body">
										
										<c:if test="${erro == true}">
											<div class="alert alert-danger alert-dismissible fade show" role="alert">
												<strong>Cadastro não realizado!</strong>
												<ul>
													 <c:forEach var="erroVar" items="${erros}">
													 	<li>
													 		<font>${erroVar}</font>
													 	</li>
													 </c:forEach>
												</ul>
												<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
											</div>
										</c:if>

										<div class="form-row">

											<div class="row mb-4">
											
												<div class="col-md-12">
													<div class="form-outline">
														<label class="form-label" for="nome">Nome</label>
														<input type="text" class="form-control" id="nome" name="nome" value="${cliente.nome}" required="required"  />
													</div>
												</div>
												
											</div>
											
											<div class="row mb-4">
												
												<div class="col-md-6">
													<div class="form-outline">
														<label class="form-label" for="email">E-mail</label>
														<input type="email" class="form-control" id="email" name="email" value="${cliente.email}" required="required"/>
													</div>
												</div>
													
												<div class="col-md-2">
													<div class="form-outline">
														<label class="form-label" for="matricula">Matrícula</label>
														<input type="text" class="form-control" id="matricula" name="matricula" value="${cliente.matricula}" required="required"/>
													</div>
												</div>
												
												<div class="col-md-2">
													<div class="form-outline">
														<label class="form-label" for="cpf">CPF</label>
														<input type="text" class="form-control" id="cpf" name="cpf" value="${cliente.cpf}" required="required" 
															data-inputmask='"mask": "999.999.999-99"' data-mask />
													</div>
												</div>
												
												<div class="col-md-2">
													<div class="form-outline">
														<label class="form-label" for="telefone">Telefone</label>
														<input type="text" class="form-control" id="telefone" name="telefone" value="${cliente.telefone}" required="required" />
													</div>
												</div>
												
											</div>
												
										</div>

									</div>

									<div class="card-footer">
										<button type="submit" class="btn btn-primary">Salvar</button>
										<a class="btn btn-secondary" href="/biblioteca/cliente/lista" role="button">Cancelar</a>
									</div>

								</form:form>
							</div>
						</div>
					</div>
				</div>
			</section>
		</div>

	</div>
	
	<script type="text/javascript">
	
		$('[data-mask]').inputmask()
	
	    // Selecionar os elementos dos campos de email e login
	    var emailInput = document.getElementById("email");
	    var loginInput = document.getElementById("login");
	
	    // Adicionar um ouvinte de evento ao campo de email para monitorar a saída
	    emailInput.addEventListener("blur", function() {
	        // Verificar se o campo de login já está preenchido
	        if (loginInput.value === "") {
	            // Preencher o campo de login com o valor do campo de email
	            loginInput.value = emailInput.value;
	            // Desativar o campo de login
	            // loginInput.disabled = true;
	        }
	    });
	    
	</script>
	
	<c:import url="footer.jsp" />
	
</body>
</html>

