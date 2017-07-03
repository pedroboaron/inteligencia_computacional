package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoPostgres
{
	Connection db = null;
	    public Connection conecta(){

	    	String url = "jdbc:postgresql://localhost:5432/dvdrental";
	    	//System.out.println(	"Esta é a URL: " + url);
	    	try
	    	{

	    	Class.forName( "org.postgresql.Driver");
	    	}
	    	catch ( java.lang.ClassNotFoundException e )
	    	{ 	System.err.print( "ClassNotFoundException:" );

	    	System.err.println( e.getMessage () );
	    	}
	    	//System.out.println("Driver do PostgreSQL selecionado. ");

	    	try
	    	{

	    	db = DriverManager.getConnection(url,"postgres","admin");
	    	}
	    	catch ( SQLException ex )
	    	{System.err.println( "SQLException: " + ex.getMessage());
	    	return null;}
	    	//System.out.println("Conexão aberta. ");
	    	return db;}

	    public ResultSet consulta(Connection con, String query){
	    	Statement sq_stmt;
	    	try {
	    		sq_stmt = con.createStatement();
	    		ResultSet rs = sq_stmt.executeQuery(query);
	    	return rs;
	    	} catch (SQLException e) {
	    		// TODO Auto-generated catch block
	    		e.printStackTrace();
	    		return null;
	    	}
	    }

	    public void inserir(Connection con, String query){
	    	Statement sq_stmt;
	    	try {
	    		sq_stmt = con.createStatement();
	    		sq_stmt.execute(query);
	    	} catch (SQLException e) {
	    		e.printStackTrace();
	    	}
	    }
}

