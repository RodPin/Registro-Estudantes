package com.example.RegistroEstudantes;

import java.util.Scanner;

import com.example.RegistroEstudantes.exceptions.NotaInvalidaException;

public class main { 
	static String opcao;
	static int running = 1;
	static int MAX = 100;
	static int count = 0;
	static Aluno[] alunos= new Aluno[MAX];

	
	static Scanner s = new Scanner(System.in);
	
	private static float inputValidNote () throws NotaInvalidaException {
		String note = s.nextLine();
		if(!note.matches("[-+]?[0-9]*\\.?[0-9]+")) {
			throw new NotaInvalidaException("A nota informada tem caracteres invalidos");
		}
		Float noteFloat = Float.parseFloat(note);
		if(noteFloat < 0 || noteFloat >10) {
			throw new NotaInvalidaException("A nota deve estar no intervalo entre 0 e 10");
		}
		return noteFloat;
	}
	
	private static void registerStudent() {
		try {
			
			if(count+1 >= MAX) {
				throw new NotaInvalidaException("Maximo de alunos atingido");
			}
		
			System.out.println("Digite o primeiro nome do estudante");
			String name = s.nextLine();
			System.out.println("Digite o segundo nome do estudante");
			String name2 = s.nextLine();
			System.out.println("Digite o ultimo nome do estudante");
			String name3 = s.nextLine();
			
			System.out.println("Digite a AV1");
			float nota1 = inputValidNote();
			System.out.println("Digite a AV2");
			float nota2 = inputValidNote();
			Aluno aluno = new Aluno(name,name2,name3);
			aluno.setAv1(nota1);
			aluno.setAv2(nota2);
			alunos[count] = aluno;
			
			System.out.println("Aluno Cadastrado com sucesso! Seu codigo: "+count);
			count = count+1;
		}catch(NotaInvalidaException ex) {
			System.out.println("Erro: "+ ex.getMessage());
		}
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
			System.out.println("Aluno: " + alunos[codeInt].getNome());
			alunos[codeInt].printSituacao();
			
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
			System.out.println("["+i+"] Aluno:" + alunos[i].getNome()+" Nota 1:"+ alunos[i].av1 +" Nota 2:"+alunos[i].av2+" Media: "+ alunos[i].calculaMedia()+ " Situacao: "+alunos[i].checkSituacao()) ;
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
