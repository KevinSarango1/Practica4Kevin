/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controller.ed.lista.ListaEnlazada;
import javax.swing.table.AbstractTableModel;
import modelo.Valor;

/**
 *
 * @author Kevin
 */
public class modeloTablaAle extends AbstractTableModel{
  ListaEnlazada<Valor> datos = new ListaEnlazada<>();

    public ListaEnlazada<Valor> getDatos() {
        return datos;
    }

    public void setDatos(ListaEnlazada<Valor> datos) {
        this.datos = datos;
    }
    
    
    @Override
    public int getRowCount() {
    return datos.getSize();
}

    @Override
    public int getColumnCount() {
       return 1;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        Valor a = null;
        try{
            a = datos.get(arg0);
        }catch(Exception e){
            
        }
        switch(arg1){
            case 0: return a.getDatos();
            
            default: return null;
        }
        
    }
    
    public void invertir() {
        datos.invertir();
    }
    public String getColumnName(int Column){
        switch (Column) {
            case 0:
              return "Datos aleatorios";
            default:
                return null;
        }
    }
}

