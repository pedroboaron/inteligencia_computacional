/**
 * 
 */
package tutorjade;

import jade.core.Agent;

/**
 * @author pedro
 *
 */
public class CompradorDeLivros extends Agent{
	private String livrosComprar ;
	protected void setup()
	{
	// imprime mensagem de Bem−Vindo
	System.out.println( "Ola !!! Eu sou o Agente Comprador "+ getLocalName ( )
	+" e estou pronto para comprar!" ) ;
	// c a p t u r a o t´ı t u l o do l i v r o que comprar´a , que f o i p a s s a d o como
	//argumento de inicializacao
	Object[]args = getArguments();
	 if (args!= null && args.length>0)
	{
	livrosComprar = (String)args[0];
	 System.out.println( " Pretendo comprar o livro: "+ livrosComprar ) ;
	} else
	{
	// f i n a l i z a o a g e n t e
	System.out.println( "Nao tenho livros para comprar!" ) ;
	doDelete( ) ; // inv oc a a execu¸c ˜a o do m´etodo takeDown ( )
	}
	}
	protected void takeDown ( ) {
	System.out.println( "Agente Comprador " + getAID ( ) . getName ( ) + "esta finalizado " ) ;
	}
	
	}
