/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Henry y Fernando
 */
public class NodoMemoria {

    private int id;
    private int tamaño;
    private boolean ocupado;
    private String proceso;

    public NodoMemoria(int id, int tamaño) {

        this.id = id;
        this.tamaño = tamaño;
        this.ocupado = false;
        this.proceso = "";
    }

    public int getId() {
        return id;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public String getProceso() {
        return proceso;
    }

    public void asignarProceso(String proceso) {

        this.proceso = proceso;
        this.ocupado = true;
    }

    @Override
    public String toString() {

        if (ocupado) {

            return "Nodo " + id +
                    " | BUSY | " +
                    tamaño + " MB | " +
                    proceso;

        } else {

            return "Nodo " + id +
                    " | FREE | " +
                    tamaño + " MB";
        }
    }
}
