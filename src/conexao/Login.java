package conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Login {
	
	
	public boolean entrar(String user) throws SQLException{
	Scanner ler = new Scanner(System.in);
	
	String senha = null;
	
	System.out.println("digite a senha :");
	senha=ler.nextLine();
		ConexaoPostgres con =new ConexaoPostgres();
		ResultSet rs=null;
		rs = con.consulta(con.conecta(), "select senha from usuario u where u.usuario= '"+user+"'");
		while(rs.next())
		if(senha.equals(rs.getString("senha"))){
			return true;
		}
		return false;
	}
	
	public void novoUsuario(String user){
		Scanner ler = new Scanner(System.in);
		String senha = null;
		System.out.println("digite a senha :");
		senha=ler.nextLine();
			ConexaoPostgres con =new ConexaoPostgres();try {
				con.inserir(con.conecta(), "insert into usuario values ('"+user+"','"+senha+"')");
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
}
