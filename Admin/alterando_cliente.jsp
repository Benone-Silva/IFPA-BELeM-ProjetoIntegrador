<%@page import="Model.Cliente"%>
<%@page import="Dao.clienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
      
       <%
		boolean resultado = false;
		int id = Integer.parseInt(request.getParameter("hidCliente"));
		
		Cliente Cliente = new Cliente();
		Cliente.setId_cliente(id);
		Cliente.setNome(request.getParameter("nome"));
		Cliente.setEmail(request.getParameter("email"));
			
		clienteDao clienteDao = new clienteDao();
		resultado = clienteDao.AlterarCliente(Cliente);
		
		if(resultado){ %>
		<script language="JavaScript">
			alert('Cliente Alterado com sucesso!');
			window.location.href="lista_cadastro.jsp"
		</script>
		<% }else{ %>
		<script language="JavaScript">
			alert(' nao foi possível alterar o cliente!');
			window.location.href="lista_cadastro.jsp"
		</script>
		<%} %>     
</body>
</html>