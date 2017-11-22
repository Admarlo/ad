using System;
using Gtk;
using System.Data;

namespace Serpis.Ad
{
	public class ComboBoxHelper
	{
		public const string NullLabel = "< sin asignar >"; //internalización y traducción
		public static void Fill(ComboBox comboBox, string selectSql, object id)
		{
			id = id.ToString();

			IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
			dbCommand.CommandText = selectSql;
			IDataReader dataReader = dbCommand.ExecuteReader();
			init(comboBox);
			fill(comboBox, dataReader, id);
			dataReader.Close();

			TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);
			while (dataReader.Read())
			{//leemos dataReader
				TreeIter treeIter = listStore.AppendValues(dataReader[0].ToString(), dataReader[1].ToString());
				if (id.Equals(dataReader[0]))//lo comparamos con la primera posición de id 
					initialTreeIter = treeIter;//se lo asignamos a initialTreeIter
			}
			dataReader.Close();
			comboBox.SetActiveIter(initialTreeIter);//se lo pasamos al comboBox

			//TODO obtener el Get.id del comboBox (similar a treeVierHelper de CSerpisAd
		}

		private static void init(ComboBox comboBox)
		{
			CellRendererText cellRendererText = new CellRendererText();
			comboBox.PackStart(cellRendererText, false);
			comboBox.AddAttribute(cellRendererText, "text 1", 1);
			ListStore listStore = new ListStore(typeof(string), typeof(string));//creamos liststore con 2 columnas
			comboBox.Model = listStore;
		}

		private static void fill(ComboBox comboBox, IDataReader dataReader, object id)
		{
			id = id.ToString();
			ListStore listStore = (ListStore)comboBox.Model;
			TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);
			while (dataReader.Read())
			{
				TreeIter treeIter = listStore.AppendValues(dataReader[0].ToString(), dataReader[1].ToString());
				if (id.Equals(dataReader[0].ToString()))
					initialTreeIter = treeIter;
			}
			comboBox.SetActiveIter(initialTreeIter);
		}
		public static object GetId(ComboBox comboBox)
		{
			TreeIter treeIter;
			comboBox.SetActiveIter(treeIter);
			return comboBox.Model.GetValue(treeIter, 0);
		}
	}
}
