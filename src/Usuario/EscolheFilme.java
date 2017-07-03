/**
 * 
 */
package Usuario;

import java.sql.ResultSet;
import java.util.Scanner;

import acionaAgente.ChamaAgente;
import conexao.ConexaoPostgres;

/**
 * @author pedro
 *
 */
public class EscolheFilme {
	ConexaoPostgres con = new ConexaoPostgres();
	public void escolha(){
		Scanner ler = new Scanner(System.in);
		String filme = null;
		System.out.println("digite o nome do filme que escolheu: ");
		filme=ler.nextLine();
		String query="select c.name as category from category c, film f, film_category fc where f.title='"+filme+"' and " 
				+"fc.category_id = c.category_id and fc.film_id = f.film_id LIMIT 1";
		try {
			ResultSet rs; 
			rs=con.consulta(con.conecta(), query);
			while (rs.next()){
				ChamaAgente c = new ChamaAgente();
				c.chamaInserir(rs.getString("category"));
		} }catch (Exception e) {
			System.err.println(e);
		}
		
	}
		public void buscaAtor(){
		Scanner ler = new Scanner(System.in);
		String filme = null;
		System.out.println("digite o nome do ator: ");
		filme=ler.nextLine();
		String query="select distinct d.name as category, f.title as title, f.description as description, f.release_year as release_year,f.length as length from actor c, film f, film_actor fc, film_category j, category d where c.first_name='"+filme+"' and " 
				+"fc.actor_id = c.actor_id and fc.film_id = f.film_id and j.category_id = d.category_id LIMIT 10";
		try {
			ResultSet rs; 
			rs=con.consulta(con.conecta(), query);
			System.out.println("category| 	 title|			  description|				  release_year| 	 length");
			while(rs.next()){
				System.out.println(rs.getString("category")+"|  "+rs.getString("title")+"|		  "+rs.getString("description")+"|	  "+rs.getString("release_year")+"| 	 "+rs.getString("length"));
			}
			escolha();
		 }catch (Exception e) {
			System.err.println(e);
		}
		
		
		}
	
		public void buscaCategoria(){
		Scanner ler = new Scanner(System.in);
		String filme = null;
		System.out.println("digite o nome do genero: ");
		filme=ler.nextLine();
		String query="select d.name as category, f.title as title, f.description as description, f.release_year as release_year,f.length as length from film f,  film_category j, category d where d.name='"+filme+"' and " 
				+" j.category_id = d.category_id and j.film_id = f.film_id LIMIT 10";
		try {
			ResultSet rs; 
			rs=con.consulta(con.conecta(), query);
			System.out.println("category| 	 title|			  description|				  release_year| 	 length");
			while(rs.next()){
				System.out.println(rs.getString("category")+"|  "+rs.getString("title")+"|		  "+rs.getString("description")+"|	  "+rs.getString("release_year")+"| 	 "+rs.getString("length"));
			}
			escolha();
		 }catch (Exception e) {
			System.err.println(e);
		}
		
		}
	
		
}
