package Dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Cliente;
import util.Conexao;

public class ClienteDao {
	
	public boolean InserirCliente(Cliente c) {
		Conexao con = null;
		try {
			con = new Conexao();
			con.executeUpdate("INSERT INTO clientes(nome, email, senha, CPF) VALUES ('"
					+ c.getNome() + "','"
					+ c.getEmail() + "','"
					+ c.getSenha() + "','"
					+ c.getCPF() + "');");
			return true;
		}catch(SQLException e) {
			System.out.println("Error ao Inserir Cliente");
			return false;
		}
	}
	
	public ArrayList<Cliente> ArrayListarCliente(){
		Conexao con = null;
		try {
			con = new Conexao();
			ResultSet result = con.executeQuery("SELECT * FROM clientes;");
			ArrayList<Cliente> listarCliente = new ArrayList<Cliente>();
			int i = 0;
			
			while(result.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(result.getInt("idclientes"));
				cliente.setNome(result.getString("nome"));
				cliente.setCPF(result.getString("CPF"));
				cliente.setEmail(result.getString("email"));
				cliente.setSenha(result.getString("senha"));
				listarCliente.add(i, cliente);
				i++;
			}
			return listarCliente;
		}catch (SQLException e) {
			System.out.println("Erro na função listar cliente DAO" + e);
			return null;
		}
	} 
	
	public Cliente ListarClienteID(int id){
		 Conexao con = null;
		 Cliente cliente = new Cliente();
		try{
		 con = new Conexao();
		ResultSet result = con.executeQuery("SELECT * FROM cliente Where idcliente =" + id);
		result.next();

		cliente.setId_cliente(result.getInt("idcliente"));
		cliente.setNome(result.getString("nome"));
		cliente.setEmail(result.getString("email"));

		} catch(SQLException e) {
		  System.out.println("Erro na função listar ClienteID DAO" + e);
		 return null;
		}
		return cliente;
		}
	public boolean AlterarCliente(Cliente cliente){
		 Conexao con = null;
		try{
			con = new Conexao();
	        con.executeUpdate("UPDATE clientes SET nome = '"
	                + cliente.getNome() + "', email = '"
	                + cliente.getCPF() + "', CPF = '"
	                + cliente.getEmail() + "', senha = '"
	                + cliente.getSenha() + "' "
	                + "WHERE idcliente = " + cliente.getId_cliente()); 
	        return true;
		
		}
		catch(SQLException e) {
		  System.out.println("Erro na função listar ClienteID DAO" + e);
		 return false;
		}

		}
	
	   public boolean DeleteCliente(int id) {
		   Conexao con = null;
		   try {
			   con = new Conexao();
			   con.executeUpdate("DELETE FROM clientes WHERE idcliente=" + id);
			   return true;
		   }catch(SQLException e) {
			   System.out.println("Erro na função deletar cliente DAO" + e);
			   return false;
		   }
	   }
	
	   public boolean ADM(String senha) {
			Conexao con = null;
			   try {
				   con = new Conexao();
				   ResultSet result = con.executeQuery("SELECT * FROM adm Where ADM ='" + senha +"'");
				   
				   if(result.next()) {
					   System.out.print("Logado");
					   return true;
				   }
				   else {
					   System.out.print("Esqueceu a Senha??");
					   
				   }
				   
		   }catch(SQLException e) {
			 
		   }
			   return false;
		   }
	   
	   public boolean VerificarLogin( String Email, String senha) {
		   Conexao con = null;
		   try {
			   con = new Conexao();
			   ResultSet result = con.executeQuery("SELECT * FROM clientes Where email = '"+ Email +"' AND senha ='" + senha +"'");
			   
			   if(result.next()) {
				   System.out.print("Bem-vindo!");
				   return true;
			   }
			   else {
				   System.out.print("Email ou senha Incorretos!");
				   
			   }
			   
	   }catch(SQLException e) {
		 
	   }
		   return false;
	   }
	
}
