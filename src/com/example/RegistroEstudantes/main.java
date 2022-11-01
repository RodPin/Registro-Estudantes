package com.example.RegistroEstudantes;

import java.util.Scanner;

public class main { 
	static String opcao;
	static int running = 1;
	static int MAX = 100;
	static int count = 0;
	static String[] nomes = new String[MAX];
	static Float[] av1s = new Float[MAX];
	static Float[] av2s = new Float[MAX];
	
	static Scanner s = new Scanner(System.in);
	
	private static float inputValidNote () {
		String note = s.nextLine();
		if(!note.matches("[-+]?[0-9]*\\.?[0-9]+")) {
			return -1;
		}
		Float noteFloat = Float.parseFloat(note);
		if(noteFloat < 0 || noteFloat >10) {
			System.out.println("A nota deve estar no intervalo entre 0 e 10");
			return -1;
		}
		return noteFloat;
	}
	
	private static void registerStudent() {
		if(count+1 >= MAX) {
			System.out.println("Maximo de alunos atingido");
			return;
		}
		System.out.println("Digite o nome do estudante");
		String name = s.nextLine();
		System.out.println("Digite a AV1");
		float nota1 = inputValidNote();
		if(nota1<0) {
			System.out.println("Nota 1 invalida");
			return;
		}
		System.out.println("Digite a AV2");
		float nota2 = inputValidNote();
		if(nota2<0) {
			System.out.println("Nota 2 invalida");
			return;
		}
		
		
		nomes[count] = name;
		av1s[count] =  nota1;
		av2s[count] = nota2;
		
		System.out.println("Aluno Cadastrado com sucesso! Seu codigo: "+count);
		count = count+1;
	}
	
	private static float calculaMedia(float nota1,float nota2) {
		return (nota1+nota2)/2;
	}
	private static String checkSituacao(float media) {
		if(media < 4) {
			return "Reprovado";
		}
		if(media < 7) {
			return "Prova final";
		}
		return "Aprovado";
	}
	
	private static void printSituacao(float nota1,float nota2) {
		Float media = calculaMedia(nota1,nota2);
		System.out.println("Nota1: "+nota1);
		System.out.println("Nota2: "+nota2);
		System.out.println("Media: "+media);
		System.out.print("Situacao: "+checkSituacao(media));		
	}
	
	private static void checkStudent() {
		System.out.println("Digite o codigo do aluno: ");
		String code = s.nextLine();
		try {
			int codeInt = Integer.parseInt(code);
			System.out.println("codeInt: "+codeInt);
			System.out.println("Aluno: "+nomes[codeInt]);
			printSituacao(av1s[codeInt],av2s[codeInt]);
			
		}catch(Exception e) {
			System.out.println("Codigo invalido, Aluno nao encontrado");
		}
	}
	
	private static void listStudents() {
		if(count == 0) {
			System.out.println("Nao ha alunos");
			return;
		}
		for ( int i = 0; i < count ; i++ ) {
			float media = calculaMedia(av1s[i],av2s[i]); 
			System.out.println("["+i+"] Aluno:" + nomes[i]+" Nota 1:"+ av1s[i] +" Nota 2:"+av2s[2]+" Media: "+ media + " Situacao: "+checkSituacao(media)) ;
		}
		System.out.println("Pressione qualquer teclap para sair");
		s.nextLine();
	}
	
	public static void main(String args[]) {
		while (running == 1) {
		     menu.showMenu();
		     opcao = s.nextLine();
		     
		     switch(opcao) {
		     	case "1":
		     		registerStudent();	
		     		break;
		     	case "2":
		     		checkStudent();
		     		break;
		     	case "3":
		     		listStudents();
		     		break;
		     	case "4":
		     		running = 0;
		     		break;
		     }
		     
		     
		}
		
	}
}
