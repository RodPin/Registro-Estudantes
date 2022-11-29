package com.example.RegistroEstudantes;

public class Aluno extends Pessoa {
	float av1;
	float av2;
	public Aluno(String primeironome, String segundoNome, String terceiroNome) {
		super(primeironome, segundoNome, terceiroNome);		
	}
	
	public void setAv1(float av1) {
		this.av1 = av1;
	}
	public void setAv2(float av2) {
		this.av2 = av2;
	}
	public float calculaMedia() {
		return (this.av1+this.av2)/2;
	}
	public String checkSituacao() {
	Float media = calculaMedia();
		if(media < 4) {
			return "Reprovado";
		}
		if(media < 7) {
			return "Prova final";
		}
		return "Aprovado";
	}
	
	public void printSituacao() {
		Float media = calculaMedia();
		System.out.println("Nota1: "+this.av1);
		System.out.println("Nota2: "+this.av2);
		System.out.println("Media: "+media);
		System.out.print("Situacao: "+checkSituacao());		
	}
}
