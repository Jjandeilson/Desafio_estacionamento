package br.com.compay.model;

//enum com todos os estados para cadastro do veiculo
public enum EnumEstado {
	AC ("AC"), AL ("AL"), AP ("AP"), AM ("AM"), BA ("BA"), CE ("CE"), DF ("DF"), ES ("ES"), GO ("GO"), MA ("MA"), 
	MT ("MT"), MS ("MS"), MG ("MG"), PA ("PA"), PB ("PB"), PR ("PR"), PE ("PE"), PI ("PI"), RJ ("RJ"), RN ("RN"), 
	RS ("RS"), RO ("RO"), RR ("RR"), SC ("SC"), SP ("SP"), SE ("SE"), TO ("TO");
	
	private final String nome;
	
	EnumEstado(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
}
