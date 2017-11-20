using System;
using Gtk;
using System.Data;

namespace Serpis.Ad
{
    public class ComboBoxHelper
    {
        public const string NullLabel ="< sin asignar >"; //internalización y traducción
        public static void Fill (ComboBox comboBox, string selectSql, object id){
            id = id.ToString();
            CellRendererText cellRendererText = new CellRendererText();
            comboBox.PackStart(cellRendererText, false);
            comboBox.AddAttribute(cellRendererText,"text 1",1);

            IDbCommand dbCommand = App.Instance.Connection.CreateCommand();
            dbCommand.CommandText = selectSql;
            IDataReader dataReader = dbCommand.ExecuteReader();

            ListStore listStore = new ListStore(typeof(string), typeof(string));//creamos liststore con 2 columnas
            comboBox.Model = listStore;
            TreeIter initialTreeIter = listStore.AppendValues("0", NullLabel);
            while(dataReader.Read()){//leemos dataReader
                TreeIter treeIter = listStore.AppendValues(dataReader[0].ToString(), dataReader[1].ToString());
                if (id.Equals(dataReader[0]))//lo comparamos con la primera posición de id 
                    initialTreeIter = treeIter;//se lo asignamos a initialTreeIter
            }
            dataReader.Close();
            comboBox.SetActiveIter(initialTreeIter);//se lo pasamos al comboBox

            //TODO obtener el id del comboBox (similar a treeVierHelper de CSerpisAd
        }
    }
}
