package com.example.RegistroEstudantes;

public class Pessoa {
	String primeiroNome;
	String segundoNome;
	String ultimoNome;
	 public Pessoa(String primeironome,String segundoNome,String terceiroNome) {
			this.primeiroNome = primeironome;
			this.segundoNome = segundoNome;
			this.ultimoNome = terceiroNome;
	    }
	 public String getNome() {
		 return this.primeiroNome+ " "+ this.segundoNome+' '+ this.ultimoNome;
	 }
}
