/**
 * 
 */
package tutorjade;

import jade.core.Agent;

/**
 * @author pedro
 *
 */
@SuppressWarnings("serial")
public class InserirPreferencia extends Agent {
	
	String nome;
	public String param(){
		Object[]args = getArguments();
		 if (args!= null && args.length>0)
		{
		nome = (String)args[0];}
		 return nome;}
		protected void setup(){
		addBehaviour(new iPreferencia(this, param()));}
//		 System.out.println( " Buscando pelo Ator: "+ nome+" "+sobrenome ) ;
		 
	

	protected void takeDown() {}

}