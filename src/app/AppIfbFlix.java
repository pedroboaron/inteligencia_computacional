package app;
import java.util.Scanner;

import Usuario.EscolheFilme;
import Usuario.MostraMelhoresOpcoes;
import conexao.ConexaoPostgres;
import conexao.Login;

/**
 * 
 */

/**
 * @author pedro
 *
 */
public class AppIfbFlix {

static String user =null;
static Scanner ler = new Scanner(System.in);
	public String getUser(){
		return this.user;
	}
	static int opcao;
	public static void main(String[] args){
		MostraMelhoresOpcoes m = new MostraMelhoresOpcoes();
		
		opcao=menuEntrada();
		switch(opcao){
		case 1: fazerLogin();break;
		case 2:addNovo();break;
		}

		switch(opcao){
		case 1: m.mostra();break;
		case 2:m.mostraAleatorio();break;
		}
		menu(1);
			
		}
	
	public static void menu(Integer valor){
		Integer x = 2;
		if (valor==0){
			System.out.println("encerrando aplicacao");
			System.exit(0);
		}else{
		int opcaoBusca;
		Login lo = new Login();
		EscolheFilme e = new  EscolheFilme();
	
		
		opcaoBusca=menuBusca();
		switch(opcaoBusca){
		case 1: e.escolha();break;
		case 2: e.buscaCategoria();break;
		case 3: e.buscaAtor();break;
		case 4: e.escolha();break;
		}
		while(x!=1 && x!=0){
		System.out.println("deseja fazer mais alguma operacao?");
		System.out.println("Se sim digite 1");
		System.out.println("Se deseja encerrar digite 0");
		Scanner lerint = new Scanner(System.in);
		x=lerint.nextInt();
		if(x!=1 && x!=0){
			System.out.println("opcao invalida tente novamente");
		}
		}
		menu(x);
			
		}}
	
	public static int menuEntrada(){
		int x = 9;
		while(x!=1 && x!=2 && x!=0){
		System.out.println("escolha dentre as opcoes abaixo ou digite 0 para fechar a aplicacao");
		System.out.println("1- fazer login");
		System.out.println("2- criar novo usuario");
		Scanner lerint = new Scanner(System.in);
		x=lerint.nextInt();
		
		if (x==0)
		{
			System.out.println("Encerrando a aplicacao");
			System.exit(0);
		}
		if(x!=1 && x!=2){
			System.out.println("opcao invalida tente novamente");
		}}
		return x;
	}
	
		public static void fazerLogin(){
			ConexaoPostgres con = new ConexaoPostgres();
			Login lo = new Login();
			boolean res = false;
			int cont=0;
			while(!res)
				try {System.out.println("digite seu usuario :");
				user=ler.nextLine();
					res=lo.entrar(user);
				} catch (Exception e) {
					// TODO: handle exception
				}
			if(!res){
				cont++;
				System.out.println("Usurio ou senha errados");}
			if(cont==3){
				System.out.println("muitas tentativas efetuadas");
				System.exit(0);
			}
		}
		
		public static void addNovo(){
			Login lo = new Login();
			System.out.println("digite seu usuario :");
				user=ler.nextLine();
					lo.novoUsuario(user);
		}
		public static int menuBusca(){
			int x = 9;
			while(x!=1 && x!=2 && x!=0 && x!=3 && x!=4){
			System.out.println("escolha dentre as opcoes abaixo ou digite 0 para fechar a aplicacao");
			System.out.println("1- Escolher dentre os filmes citados");
			System.out.println("2- Buscar por Genero");
			System.out.println("3- Buscar por ator");
			System.out.println("4- Buscar nome do filme");
			Scanner ler = new Scanner(System.in);
			x=ler.nextInt();
			
			if (x==0)
			{
				System.out.println("Encerrando a aplicacao");
				System.exit(0);
			}
			if(x!=1 && x!=2 && x!=3 && x!=4){
				System.out.println("opcao invalida tente novamente");
			}}
			return x;
		}

}
