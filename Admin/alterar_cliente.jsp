<%@page import="Model.Cliente"%>
<%@page import="Dao.clienteDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="UTF-8">
<title>Alterar cliente</title>
</head>
<body>
	<%
	clienteDao c = new clienteDao();
	Cliente cliente = new Cliente();
	cliente = c.ListarClienteID(Integer.parseInt(request.getParameter("idcliente")));
	%>
	
	 <form action="alterando_cliente.jsp" method="post">
               
                <p style="font-weight: bold; font-size: 1.5cm; color: #fff;">Solicitar um serviço</p>
                <br>
                <br>
                 <label for="id"> Código</label>
                 <input type="text" name="idCliente" id="idCliente" disabled="disabled" value="<%=cliente.getId_cliente()%>">
				<input type="hidden" name="hidCliente" id="hidCliente" value="<%=cliente.getId_cliente()%>">
                
                <label for="nome" style="font-size: 0.7cm; ">Nome:</label>
                <input type="text" id="nome" name="nome" value="<%=cliente.getNome()%>" style="width: 7cm; height: 0.7cm" required><br><br>
                <label for="email" style="font-size: 0.7cm; ">Endereço de <i>e-mail</i>:</label>
                <input type="email" id="email" name="email" value="<%=cliente.getEmail()%>"  style="width: 7cm; height: 0.7cm" required><br><br>
                
                <input type="submit" value="Enviar">
            </form>
      
            
</body>
</html>