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
		
		try (Statement stmt = connection.createStatement();
			    ResultSet rs = stmt.executeQuery( "SELECT * from categoria" )
			) {
			    while ( rs.next() ) {
			        int numColumns = rs.getMetaData().getColumnCount();
			        for ( int i = 1 ; i <= numColumns ; i++ ) {
			           // Column numbers start at 1.
			           // Also there are many methods on the result set to return
			           //  the column as a particular type. Refer to the Sun documentation
			           //  for the list of valid conversions.
			           System.out.println( "COLUMN " + i + " = " + rs.getObject(i) );
			        }
			    }
			}
		
		connection.close();
	}
	
	

}
