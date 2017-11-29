package serpis.ad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaMySql {

	public static void main(String[] args) throws SQLException {
		// TODO conectar
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/dbprueba", "root", "sistemas");
		
		Statement statement=connection.createStatement();
		ResultSet resultSet = statement.executeQuery( "SELECT * from categoria" )
			while ( resultSet.next() ) {
			        System.out.printf( "%5s %s\n " + i + " = " + resultSet.getObject());
			        }
			    }
					
		connection.close();
	}
	
	

}
