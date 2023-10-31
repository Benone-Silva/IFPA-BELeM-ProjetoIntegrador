package model;

public class comprovante {
	
    String nome;
    String CPF;
    String Pacote;
    String horaViagem;
    String data;
    String preco;
    
    public String getNome(){
  	  return nome;
    }
    public void setNome(String nome) {
  	  this.nome = nome;
    }
    public String getCPF() {
  	   return CPF;
    }
    
    public void setCPF(String CPF) {
  	   this.CPF = CPF;
    }
    public String getPacote() {
  	  return Pacote;
    }
    public void setPacote(String Pacote) {
    	this.Pacote = Pacote;
    }
    public String getHora() {
  	  return horaViagem;
    }
    public void setHora(String horaViagem) {
  	  this.horaViagem = horaViagem;
    }
    public String getData() {
  	  return data;
    }
    public void setData(String data) {
  	  this.data = data;
    }
   
    public String getPreco() {
    	return preco;
    }
    public void setPreco(String preco) {
    	this.preco = preco;
    }

}
