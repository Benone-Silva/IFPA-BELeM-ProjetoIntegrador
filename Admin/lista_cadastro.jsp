<%@page import="Dao.clienteDao"%>
<%@page import="Model.Cliente"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Listagem de Clientes</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f2f2f2;
		}

		.container {
			max-width: 800px;
			margin: 0 auto;
			padding: 20px;
			background-color: #fff;
			border-radius: 5px;
			box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
		}

		h1 {
			text-align: center;
		}

		table {
			width: 100%;
			border-collapse: collapse;
			margin-bottom: 20px;
		}
	</style>
</head>

<body>
	<div class="container">

		<h1> Listagem de Clientes </h1>

		<section>
			<form action="#" name="formCliente" id="formCliente" method="POST">

				<table border="1px">
					<tr>
						<th> Código </th>
						<th> Nome </th>
						<th> Email </th>
						<th> Editar </th>
						<th> Deletar </th>
					</tr>
<%
clienteDao clienteDao = new clienteDao();
ArrayList<Cliente> cliente = clienteDao.ArrayListaCliente();
for(Cliente c: cliente){%>
	<tr>
		<td><%= c.getId_cliente() %></td>
		<td><%= c.getNome() %></td>
		<td><%= c.getEmail() %></td>
	
		
		
		<td> <a href="alterar_cliente.jsp?idcliente=<%=c.getId_cliente()%>"> <img src="Imagens/edit.png" width="30px" height="30px"> </a></td>
		<td> <a href="deletar_cliente.jsp?idcliente=<%=c.getId_cliente()%>"><img src="Imagens/delete.png" width="30px" height="30px"> </a></td>
	</tr>
<%} %>
				</table>
			</form>
		</section>
	</div>
</body>
</html>