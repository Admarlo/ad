using System;
using Gtk;
using MySql.Data.MySqlClient;
using System.Data;

using CCategoria;

public partial class MainWindow: Gtk.Window
{
	public MainWindow () : base (Gtk.WindowType.Toplevel)
	{
		Build ();

        //Creacion de la conexion
		App.Instance.Connection = new MySqlConnection("server=localhost;database=bdprueba;user=root;password=sistemas");
		//connection = new MySqlConnection (connectionString);
		App.Instance.Connection.Open();//Abre la conexion

		//insertamos el metodo para visualizar las columnas en el treeView
		treeView.AppendColumn("id",new CellRendererText(),"text",0);
		treeView.AppendColumn("nombre",new CellRendererText(),"text",1);
		ListStore listStore = new ListStore (typeof(string), typeof(string));//creamos modelo. listStore contiene los datos a mostrar, un typeof por columna, total 2 cols
        treeView.Model = listStore;

        //Introducir datos manualmente
        //listStore.AppendValues("1","uno");
        //listStore.AppendValues("2","dos");

        //Introducimos los datos desde la BD automaticamente
		IDbCommand dbCommand = App.Instance.Connection.CreateCommand ();
		dbCommand.CommandText = "select * from categoria order by id";
        IDataReader dataReader = dbCommand.ExecuteReader ();

		while(dataReader.Read())//intenta leer si puede deuelve True, sino devolvera False
            listStore.AppendValues(dataReader["id"].ToString(),dataReader["nombre"]);
		Console.WriteLine("id={0} nombre={1}");
        dataReader.Close();

        newAction.Activated += delegate{
            new CategoriaWindow();

        };

		/*listStore.AppendValues("1","cat.1");//para rellenar las filas
		listStore.AppendValues("2","cat.2");*/
		treeView.Model=listStore;


	}

	protected void OnDeleteEvent (object sender, DeleteEventArgs a)//ejvento asociado a la X de cerrar ventana
	{
		App.Instance.Connection.Close();
		Application.Quit ();
		a.RetVal = true;
	}
}
