/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controller.ed.lista.ListaEnlazada;
import java.util.Random;
import modelo.Valor;

/**
 *
 * @author Kevin
 */
public class controladorDatos {

    private ListaEnlazada<Integer> valor;
    private Valor datos;

    public controladorDatos() {
        valor = new ListaEnlazada<>();
        Random numero = new Random();
        for (int i = 0; i < 20000; i++) {
            valor.insertar(numero.nextInt(30000));
        }

    }

    public ListaEnlazada<Integer> getValor() {
        if (valor == null) {
            valor = new ListaEnlazada<>();
        }
        return valor;
    }

    public void setValor(ListaEnlazada<Integer> valor) {
        this.valor = valor;
    }

    public Valor getDatos() {
        return datos;
    }

    public void setDatos(Valor datos) {
        this.datos = datos;
    }

    public ListaEnlazada<Integer> ordenar(ListaEnlazada<Integer> lista, int tipo) {

        Integer[] arregloLista = lista.toArray();

        quickSort(arregloLista, 0, arregloLista.length - 1, tipo);

        return lista.toList(arregloLista);
    }

    private void swap(Integer[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // This function takes last element as pivot,
    // places the pivot element at its correct position
    // in sorted array, and places all smaller to left
    // of pivot and all greater elements to right of pivot
    private int partition(Integer[] arr, int low, int high, int tipo) {
        // Choosing the pivot
        int pivot = arr[high];

        // Index of smaller element and indicates
        // the right position of pivot found so far
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {

            // If current element is smaller than the pivot
            if (tipo == 0 ? arr[j] < pivot : arr[j] > pivot) {

                // Increment index of smaller element
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }

    // The main function that implements QuickSort
    // arr[] --> Array to be sorted,
    // low --> Starting index,
    // high --> Ending index
    private void quickSort(Integer[] arr, int low, int high, int tipo) {
        if (low < high) {

            // pi is partitioning index, arr[p]
            // is now at right place
            int pi = partition(arr, low, high, tipo);

            // Separately sort elements before
            // partition and after partition
            quickSort(arr, low, pi - 1, tipo);
            quickSort(arr, pi + 1, high, tipo);
        }
    }

    public ListaEnlazada<Integer> ordenarMerge(ListaEnlazada<Integer> lista, int tipo) {
        Integer[] arregloLista = lista.toArray();
        mergeSort(arregloLista, 0, arregloLista.length - 1, tipo);
        return lista.toList(arregloLista);
    }

    private void mergeSort(Integer[] arr, int low, int high, int tipo) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid, tipo);
            mergeSort(arr, mid + 1, high, tipo);
            merge(arr, low, mid, high, tipo);
        }
    }

    private void merge(Integer[] arr, int low, int mid, int high, int tipo) {
        int leftLength = mid - low + 1;
        int rightLength = high - mid;

        Integer[] leftArray = new Integer[leftLength];
        Integer[] rightArray = new Integer[rightLength];

        for (int i = 0; i < leftLength; i++) {
            leftArray[i] = arr[low + i];
        }

        for (int j = 0; j < rightLength; j++) {
            rightArray[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = low;

        while (i < leftLength && j < rightLength) {
            if (tipo == 0 ? leftArray[i] <= rightArray[j] : leftArray[i] >= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < leftLength) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

}
