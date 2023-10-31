package model;

public class pagamento {
	int clienteid_pag;
	int pacote;
   String numCartao;
   String CVV;
   String vencimento;
   String bandeira;
   String CPF;
   
   public int getClienteID_pag() {
   	return clienteid_pag;
   }
   public void setClienteID_pag(int clienteid_pag) {
   	this.clienteid_pag = clienteid_pag;
   }
   public int getPacote() {
	   return pacote;
   }
   public void setPacote(int pacote) {
	   this.pacote = pacote;
   }
   public String getNumCartao() {
	   return numCartao;
   }
   public void setNumCartao(String numCartao) {
	    this.numCartao = numCartao;
   }
   public String getCVV() {
	   return CVV;
   }
   public void setCVV(String CVV) {
	    this.CVV = CVV;
   }
   public String getVencimento() {
	   return vencimento;
   }
   public void setVencimento(String vencimento) {
	    this.vencimento = vencimento;
   }
   public String getBandeira() {
	   return bandeira; 
   }
   public void setBandeira(String bandeira) {
	   this.bandeira = bandeira;
   }
   public String getCPF() {
	   return CPF;
   }
   public void setCPF(String CPF) {
	    this.CPF = CPF;
   }
}
