﻿using System;
using Gtk;

public partial class MainWindow : Gtk.Window
{
    public MainWindow() : base(Gtk.WindowType.Toplevel)
    {
        Build();

        /*CellRendererText idCellRendererText = new CellRendererText();
        comboBox.PackStart(idCellRendererText, false);//para crear columnas
        comboBox.AddAttribute(idCellRendererText,"text",0);*///crea la primera columna

        CellRendererText labelCellRendererText = new CellRendererText();//para hacer la segunda columna
        comboBox.PackStart(labelCellRendererText, false);
        comboBox.AddAttribute(labelCellRendererText,"text",1);

        ListStore listStore = new ListStore(typeof(string));
        comboBox.Model = listStore;
        TreeIter treeIter = listStore.AppendValues("0", "<sin asignar>");
        listStore.AppendValues("1","cat 1");
        listStore.AppendValues("2", "cat 2");
        listStore.AppendValues("3", "cat 3");

        comboBox.SetActiveIter(treeIter);//Se posiciona en el valor seleccionado linea 20
    }

    protected void OnDeleteEvent(object sender, DeleteEventArgs a)
    {
        Application.Quit();
        a.RetVal = true;
    }
}
