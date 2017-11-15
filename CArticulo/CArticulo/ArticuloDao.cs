using System;
using System.Data;

using Serpis.Ad;

namespace CArticulo
{
	public class ArticuloDao{
        
		public const string SelectAll = "select a.id,a.nombre,a.precio,c.nombre as categoria" +
							" from articulo left join categoria c on (a.categoria = c.id)" +
							"order by a.id";

		public static Articulo Load(object id){
            
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "select * from articulo where id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", id);
			IDataReader dataReader = dbCommand.ExecuteReader();
			dataReader.Read(); // TODO tratamiendo de excepciones
			string nombre = (string)dataReader["nombre"];
            decimal precio = (decimal)dataReader["precio"];
            long categoria = dataReader["categoria"] is DBNull ?
                0 : (long)dataReader["categoria"];
            //categoria is DBNull; //pregunta si categoria es nulo
            //categoria == DBNull.Value;
            dataReader.Close();
            Articulo articulo = new Articulo();
            articulo.Id = Convert.ToInt64(id);
			articulo.Nombre = nombre;
            articulo.Precio = precio;

			return articulo;
		}

        public static void Save(Articulo articulo)
		{
			if (articulo.Id == 0)
				insert(articulo);
			else
				update(articulo);

		}

		private static void insert(Articulo articulo)
		{

			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "insert into articulo (nombre, precio, categoria) values (@nombre,@precio,@categoria)";
			DbCommandHelper.AddParameter(dbCommand, "nombre", articulo.Nombre);
            DbCommandHelper.AddParameter(dbCommand, "precio", articulo.Precio);
            DbCommandHelper.AddParameter(dbCommand, "categoria",articulo.Categoria==0?(object)null:articulo.Categoria);

            //La linea de arriba es muy similar al if siguiente
            //object categoria = articulo.Categoria;
            //if (articulo.Categoria == 0)
            //  categoria = null;

			dbCommand.ExecuteNonQuery();
		}

		private static void update(Articulo articulo)
		{

			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "update articulo set nombre = @nombre where id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", articulo.Id);
			DbCommandHelper.AddParameter(dbCommand, "nombre", articulo.Nombre);
			dbCommand.ExecuteNonQuery();
		}

		public static void Delete(object id)
		{
			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = "delete from articulo where id = @id";
			DbCommandHelper.AddParameter(dbCommand, "id", id);
			dbCommand.ExecuteNonQuery();
		}
	}
}

