package Dao;

import util.Conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.pagamento;
import model.comprovante;

public class PagamentoDao {
	public boolean EfetuarPagamento(pagamento p) {
		Conexao con = null;
		try {
			con = new Conexao();
			con.executeUpdate("INSERT INTO pagamentos( numCartao, vencimento, CVV, Bandeira, CPF, clienteid_pag, pacotes_cliente) VALUES ('"
					+ p.getNumCartao() + "','"
					+ p.getVencimento() + "','"
					+ p.getCVV() + "','"
					+ p.getBandeira() + "','"
					+ p.getCPF() + "','"
					+ p.getClienteID_pag() + "','"
					+ p.getPacote() + "');");
					
			return true;
		}catch(SQLException e) {
			System.out.println("Error ao realizar Pagamento");
			return false;
		}
	}
	
public ArrayList<comprovante> ListaComprovante(){
	Conexao con = null;
	try {
		con = new Conexao();
		ResultSet result = con.executeQuery("SELECT clientes.nome, pacotes.Horaviagem, pacotes.Dataviagem, pacotes.preco, CASE WHEN pagamentos.pacotes_cliente = pacotes.idpacotes THEN pacotes.pacote \r\n"
				+ "ELSE NULL END AS pacote\r\n"
				+ "FROM clientes, pacotes, pagamentos \r\n"
				+ "WHERE pagamentos.clienteid_pag = clientes.idclientes \r\n"
				+ "  AND pagamentos.pacotes_cliente = pacotes.idpacotes;");
		ArrayList<comprovante> comprovante = new ArrayList<comprovante>();
		
		int i = 0;
		
		while(result.next()) {
			comprovante comp = new comprovante();
			comp.setNome(result.getString("nome"));
			comp.setHora(result.getString("Horaviagem"));
			comp.setData(result.getString("Dataviagem"));
			comp.setPreco(result.getString("preco"));
			comp.setPacote(result.getString("pacote"));	
			comprovante.add(i, comp);
			i++;
		}
		return comprovante;
}catch (SQLException e) {
	System.out.println("Erro na função listar Comprovante DAO" + e);
	return null;
 }
}

public int ObterIDpag(String CPF){
	Conexao con = null;
	try{
	con = new Conexao();
	ResultSet result = con.executeQuery("SELECT * FROM clientes WHERE CPF = '" + CPF + "' ");  	
	 if (result.next()) {
            return result.getInt("idclientes");
        } else {
            return -1;
        }
	}catch(SQLException e){
		System.out.println("ERRO" + e);
	
	}
	return 0;
}

public boolean InserirIDpacote(int num) {
	  Conexao con = null;
		try {
			con = new Conexao();
			con.executeUpdate("INSERT INTO clientes (pacote_cliente) VALUES (" + num + ")");
			return true;
		}catch(SQLException e) {
			System.out.println("Error ao Inserir ID do pacote na tabela");
			return false;
		}
}
}

