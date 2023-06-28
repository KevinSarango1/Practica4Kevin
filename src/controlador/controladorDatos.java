/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controller.ed.lista.ListaEnlazada;
import controller.ed.lista.exception.EmptyException;
import controller.ed.lista.exception.PositionException;
import java.util.Random;
import modelo.Valor;

/**
 *
 * @author Kevin
 */
public class controladorDatos {

    private ListaEnlazada<Valor> valor;
    private Valor datos;

    public controladorDatos() {
        valor = new ListaEnlazada<>();
        Random numero = new Random();
        for (int i = 0; i < 20000; i++) {
            datos = new Valor();
            datos.setDatos(numero.nextInt(30000));
            valor.insertar(datos);
        }

    }

    public ListaEnlazada<Valor> getValor() {
        if (valor == null) {
            valor = new ListaEnlazada<>();
        }
        return valor;
    }

    public void setValor(ListaEnlazada<Valor> valor) {
        this.valor = valor;
    }

    public Valor getDatos() {
        return datos;
    }

    public void setDatos(Valor datos) {
        this.datos = datos;
    }

    public ListaEnlazada<Valor> quickSort(ListaEnlazada<Valor> lista, Integer tipo) throws EmptyException, PositionException {
        ListaEnlazada<Valor> listaOrdenada = new ListaEnlazada<>();
        quickSortRecursivo(lista, 0, lista.getSize() - 1, listaOrdenada, tipo);
        return listaOrdenada;
    }

    private void quickSortRecursivo(ListaEnlazada<Valor> lista, int inicio, int fin, ListaEnlazada<Valor> listaOrdenada, Integer tipo) throws EmptyException, PositionException {
        if (inicio < fin) {
            int indiceParticion = particion(lista, inicio, fin, tipo);
            quickSortRecursivo(lista, inicio, indiceParticion - 1, listaOrdenada, tipo);
            listaOrdenada.insertar(lista.get(indiceParticion));
            quickSortRecursivo(lista, indiceParticion + 1, fin, listaOrdenada, tipo);
        } else if (inicio == fin) {
            listaOrdenada.insertar(lista.get(inicio));
        }
    }

    private int particion(ListaEnlazada<Valor> lista, int inicio, int fin, Integer tipo) throws EmptyException, PositionException {
        Valor pivot = lista.get(fin); // Elegir el último elemento como pivote
        int i = inicio - 1;

        for (int j = inicio; j <= fin - 1; j++) {
            if (tipo == 0) {
                if (lista.get(j).getDatos() <= pivot.getDatos()) {
                    i++;
                    swap(lista, i, j);
                }
            } else {
                if (lista.get(j).getDatos() >= pivot.getDatos()) {
                    i++;
                    swap(lista, i, j);
                }
            }
        }

        swap(lista, i + 1, fin);
        return i + 1;
    }

    private void swap(ListaEnlazada<Valor> lista, int indice1, int indice2) throws EmptyException, PositionException {
        Valor temp = lista.get(indice1);
        lista.update(indice1, lista.get(indice2));
        lista.update(indice2, temp);
    }

    public ListaEnlazada<Valor> mergeSort(ListaEnlazada<Valor> lista, Integer tipo) throws EmptyException, PositionException {
        if (lista.getSize() <= 1) {
            return null;
        }

        // Dividir la lista en dos mitades
        ListaEnlazada<Valor> leftHalf = new ListaEnlazada<>();
        ListaEnlazada<Valor> rightHalf = new ListaEnlazada<>();
        splitList(lista, leftHalf, rightHalf);

        // Recursivamente ordenar las mitades
        mergeSort(leftHalf, tipo);
        mergeSort(rightHalf, tipo);

        // Combinar las mitades ordenadas
        lista = merge(lista, leftHalf, rightHalf, tipo);
        return lista;
    }

    private void splitList(ListaEnlazada<Valor> lista, ListaEnlazada<Valor> leftHalf, ListaEnlazada<Valor> rightHalf) throws EmptyException, PositionException {
        int size = lista.getSize();
        int middle = size / 2;

        for (int i = 0; i < middle; i++) {
            leftHalf.insertar(lista.delete(0));
        }

        for (int i = middle; i < size; i++) {
            rightHalf.insertar(lista.delete(0));
        }
    }

    private ListaEnlazada<Valor> merge(ListaEnlazada<Valor> lista, ListaEnlazada<Valor> leftHalf, ListaEnlazada<Valor> rightHalf, Integer tipo) {
        int leftSize = leftHalf.getSize();
        int rightSize = rightHalf.getSize();

        int leftIndex = 0;
        int rightIndex = 0;
        int listIndex = 0;

        while (leftIndex < leftSize && rightIndex < rightSize) {
            try {
                Valor leftValue = leftHalf.get(leftIndex);
                Valor rightValue = rightHalf.get(rightIndex);
                if (tipo == 0) {
                    if (leftValue.getDatos() <= rightValue.getDatos()) {
                        lista.insertar(leftValue);
                        leftIndex++;
                    } else {
                        lista.insertar(rightValue);
                        rightIndex++;
                    }
                } else {
                    if (leftValue.getDatos() >= rightValue.getDatos()) {
                        lista.insertar(leftValue);
                        leftIndex++;
                    } else {
                        lista.insertar(rightValue);
                        rightIndex++;
                    }
                }

                listIndex++;
            } catch (EmptyException | PositionException e) {
                e.printStackTrace();
            }
        }

        while (leftIndex < leftSize) {
            try {
                Valor value = leftHalf.get(leftIndex);
                lista.insertar(value);
                leftIndex++;
                listIndex++;
            } catch (EmptyException | PositionException e) {
                e.printStackTrace();
            }
        }

        while (rightIndex < rightSize) {
            try {
                Valor value = rightHalf.get(rightIndex);
                lista.insertar(value);
                rightIndex++;
                listIndex++;
            } catch (EmptyException | PositionException e) {
                e.printStackTrace();
            }
        }
        return lista;
    }

}
