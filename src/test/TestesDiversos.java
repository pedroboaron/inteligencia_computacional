/**
 * 
 */
package test;

import java.sql.ResultSet;
import java.sql.SQLException;

import conexao.ConexaoPostgres;
import conexao.Login;

/**
 * @author pedro
 *
 */
public class TestesDiversos {
//	static String  nome =null;
//	static String sobrenome = null;
	public static void main(String[] args) throws SQLException {
//		ConexaoPostgres con = new ConexaoPostgres();
//		Login lo = new Login();
//		boolean res=false;
//		res=lo.entrar();
//		if (res){
//			System.out.println("login com sucesso");}
//		else{
//			System.out.println("senha ou usuario incorretos");
//		}
//////		con.consulta(con.conecta(),"select * from actor");
//////		Object[]args = "penelope guiness";
//////		 if (args!= null && args.length>0)
//////		{
//////			 int i = 0;
//////			 for (Object s : args ) {
//////				 s.toString();
//////				 i++;
//////				 if(s.equals(" ")){
//////					 break;
//////				 }
//////				 
//////			 }
//////		String nome = (String)args[0].toString().substring(0, i);
//////		String sobrenome = (String)args[0].toString().substring(i,args.length);
////		 if (args!= null && args.length>0)
////		{
////			 nome = (String)args[0];
////			 sobrenome = (String)args[1];
//////		System.out.println(nome);
//////		System.out.println(sobrenome);
////	}
////		 ResultSet rs;
////			try {
////				rs=con.consulta(con.conecta(),"select title from film where film_id in (select film_id from film_actor where actor_id in(select actor_id from actor where first_name ='"+nome+"')LIMIT 10)");
////				while(rs.next()){
////					System.out.println(rs.getString("title"));
////				}
////			} catch (SQLException e) {
////				e.printStackTrace();
////			}
//			}
		Login lo = new Login();
		String query="select distinct c.name as category , f.title as title, f.description as description, f.release_year as release_year,f.length as length from category c, film f, film_category fc, preferencia_usuario pu where " 
				+"fc.category_id = c.category_id and fc.film_id = f.film_id LIMIT 10";
		ResultSet rs;
		try {
			ConexaoPostgres con = new ConexaoPostgres();
			rs=con.consulta(con.conecta(), query);
			
			while(rs.next()){
				System.out.println(rs.getString("category")+"|  	"+rs.getString("title")+"|	  "+rs.getString("description")+"|	  "+rs.getString("release_year")+"| 	 "+rs.getString("length"));
			}
			
		} catch (Exception e) {System.err.println(e);
		}
	}
}

