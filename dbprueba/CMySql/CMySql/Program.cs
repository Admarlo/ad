using MySql.Data.MySqlClient;
using System;
using System.Data;

namespace CMySql
{
    class MainClass
    {
		private static IDbConnection connection;
        public static void Main(string[] args)
        {
            string connectionString = "server=localhost;database=bdprueba;user=root;password=sistemas";
			connection = new MySqlConnection (connectionString);
            connection.Open();
			nuevaCategoria ();
			leerCategorias ();
			modificarCategoria ();
			eliminarCategoria ();
			borrarCategoria ();
            connection.Close();
            
        }
		private static void leerCategorias(){
			IDbCommand dbCommand = connection.CreateCommand ();
			dbCommand.CommandText = "select * from categoria order by id";
			IDataReader dataReader = dbCommand.ExecuteReader();
			while (dataReader.Read())
				Console.WriteLine("id={0} nombre={1}", dataReader["id"],dataReader["nombre"]);
			dataReader.Close();
    	}
		private static void nuevaCategoria(){
			IDbCommand dbCommand = connection.CreateCommand ();
			//dbComand.CommandText = "insert into (nombre) values ('categoria 4')";
			dbCommand.CommandText="insert into (nombre) values (@nombre)";

			addParameter (dbCommand, "nombre", "categoria 6");

			dbCommand.ExecuteNonQuery ();
		}

		private static void addParameter(IDbCommand dbCommand, string name, object value){
		
			IDbDataParameter dbDataParameter= dbCommand.CreateParameter ();//crea param sobre db command de nueva categoria
			dbDataParameter.ParameterName = name;//indicar nombre del param @nombre
			dbDataParameter.Value = value;
			dbCommand.Parameters.Add (dbDataParameter);
		}
	

		private static void eliminarCategoria(){
			IDbCommand dbComand = connection.CreateCommand ();
			dbComand.CommandText = "delete from categoria where id=4";
			dbComand.ExecuteNonQuery (); //devuelve un numero entero de filas afectadas 
		}

		private static void modificarCategoria(){
			IDbCommand dbComand = connection.CreateCommand ();
			dbComand.CommandText = "update categoria set nombre='categoria 4' where id=4";
			dbComand.ExecuteNonQuery ();
		}
		private static void borrarCategoria(){
			IDbCommand dbComand = connection.CreateCommand ();
			dbComand.CommandText = "delete from categoria where id=4";


		}
	/* Ejercicio propuesto. CMenuCategoria
		0-salir
		1-Nuevo
		2-Modificar
		3-Eliminer
		4-Consultar
		5-Listar */
	
	}
}
	
