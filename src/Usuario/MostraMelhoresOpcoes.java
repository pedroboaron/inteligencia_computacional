package Usuario;

import java.sql.ResultSet;

import app.AppIfbFlix;
import conexao.ConexaoPostgres;
import conexao.Login;

public class MostraMelhoresOpcoes {
public void mostra(){
	AppIfbFlix  app = new AppIfbFlix();
	String query="select distinct c.name as category , f.title as title, f.description as description, f.release_year as release_year,f.length as length from category c, film f, film_category fc, preferencia_usuario pu where " 
		+"c.name=(select category from preferencia_usuario where usuario='"+app.getUser()+"' group by category order by sum(cont) desc LIMIT 1) and " 
		+"fc.category_id = c.category_id and fc.film_id = f.film_id LIMIT 10";
	ResultSet rs;
	try {
		ConexaoPostgres con = new ConexaoPostgres();
		rs=con.consulta(con.conecta(), query);
		System.out.println("category| 	 title|			  description|				  								release_year| 	 length");
		while(rs.next()){
			System.out.println(rs.getString("category")+"|  "+rs.getString("title")+"|		  "+rs.getString("description")+"|	  "+rs.getString("release_year")+"| 	 "+rs.getString("length"));
		}
		
	} catch (Exception e) {System.err.println(e);
	}
	}

	public void mostraAleatorio(){
		AppIfbFlix  app = new AppIfbFlix();
		String query="select distinct c.name as category , f.title as title, f.description as description, f.release_year as release_year,f.length as length from film f, category c, film_category fc where f.film_id =fc.film_id and c.category_id = fc.category_id " 
			+"LIMIT 10";
		ResultSet rs;
		try {
			ConexaoPostgres con = new ConexaoPostgres();
			rs=con.consulta(con.conecta(), query);
			System.out.println("category| 	 title|			  description|											  release_year| 	 length");
			while(rs.next()){
				System.out.println(rs.getString("category")+"|  "+rs.getString("title")+"|		  "+rs.getString("description")+"|	  "+rs.getString("release_year")+"| 	 "+rs.getString("length"));
			}
			
		} catch (Exception e) {System.err.println(e);
		}
}
	
}
