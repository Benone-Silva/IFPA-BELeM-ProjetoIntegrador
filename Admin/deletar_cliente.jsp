<%@page import="Dao.clienteDao"%>
<%@page import="Model.Cliente"%>
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
clienteDao clientedao = new clienteDao();
int id = Integer.parseInt(request.getParameter("idcliente"));
resultado = clientedao.DeletarCliente(id);
  
if(resultado){ %>
<script language="JavaScript">
	alert('Cliente Deletado com sucesso!');
	window.location.href="http://localhost:8080/najafighter/Admin/listaSolicitacao.jsp"
</script>
<% }else{ %>
<script language="JavaScript">
	alert('Não foi possível deletar o cliente!');
	window.location.href="http://localhost:8080/najafighter/Admin/listaSolicitacao.jsp"
</script>
<%}%>



</body>
</html>