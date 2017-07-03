/**
 * 
 */
package tutorjade;

import java.sql.ResultSet;

import app.AppIfbFlix;
import conexao.ConexaoPostgres;
import conexao.Login;
import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

/**
 * @author pedro
 *
 */
public class iPreferencia extends OneShotBehaviour {
int i=0;
	/* (non-Javadoc)
	 * @see jade.core.behaviours.Behaviour#action()
	 */
private String nome;
 public iPreferencia(Agent a,String nome) {
	super(a);
	this.nome=nome;
}
	public void action() {
		AppIfbFlix  app = new AppIfbFlix();
		ConexaoPostgres con = new ConexaoPostgres();
		ResultSet rs;
		con.inserir(con.conecta(),"insert into preferencia_usuario values('"+app.getUser()+"','"+nome+"',1)");
			}
	
}
