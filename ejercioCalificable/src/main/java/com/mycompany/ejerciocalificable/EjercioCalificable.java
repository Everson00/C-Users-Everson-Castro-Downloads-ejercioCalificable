package com.mycompany.ejerciocalificable;

import java.util.Scanner;
import java.util.ArrayList;


public class EjercioCalificable {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
       
        System.out.println("Ingrese el tamaño de la pila: ");
        int tamaño = teclado.nextInt();
        Pila pila = new Pila(tamaño);
        
        while (true){
            System.out.println("Seleccione una opcion: ");
            System.out.println("1. Apilar.");
            System.out.println("2. Desapilar.");
            System.out.println("3. Mostrar el tope.");
            System.out.println("4. Mostrar elementos.");
            System.out.println("5. Verificar si esta vacia.");
            System.out.println("6. verifacer si esta llena.");
            System.out.println("7. Obtener tamaño de la pila.");
            System.out.println("8. Vaciar.");
            
            int opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el elemento");
                    String elemento = teclado.nextLine();
                    pila.apilar(elemento);
                    break;
                case 2:
                    pila.desapilar();
                    break;
                case 3:
                    Object tope = pila.tope();
                    if (tope != null) {
                        System.out.println("El tope de la pila es de: " + tope);
                    }
                    break;
                case 4:
                    pila.mostrar();
                    break;
                case 5:
                    System.out.println(pila.estaVacia()?" la pila esta vacia." : "la pila no esta vacia.");
                    break;
                case 6:
                    System.out.println(pila.estaVacia()?" la pila esta llena." : "la pila no esta llena.");
                    break;
                case 7:
                    System.out.println("El tamaño es: "+ pila.tamañoPila());
                    break;
                case 8:
                    pila.vaciar();
                    break;
                default:
                    System.out.println("¡OPCION NO VALIDA!");
                    System.out.println("Intente de nuevo.");
                    break;
            }
        }
    }
}

class Pila {
    int tamaño;
    ArrayList<Object> elementos;
    
    public Pila (int tamaño) {
        this.tamaño = tamaño;
        this.elementos = new ArrayList<>();
    }
    
    public void apilar (Object elemento) {
        if (!estaLlena()) {
            elementos.add(elemento);
            System.out.println("Elemento " + elemento + " apilodo");  
        }
        else {
            System.out.println("La pila esta llena.");
        }
    }
    public boolean estaLlena() {
        return elementos.size() >= tamaño;
    }
    public Object desapilar () {
        if (!estaVacia()) {
            Object elemento = elementos.remove(elementos.size() -1);
            System.out.println("Elemento " + elemento + " desapilado");
            return elemento;
        }
        else {
            System.out.println("La pila esta vacia.");
            return null;
        }    
    }
    public Object tope (){
        if (!estaVacia()) {
            return elementos.get(elementos.size() -1);
        }
        else {
            System.out.println("La pila esta vacia");
            return null;
        }
    }
    public void mostrar (){
        if (!estaVacia()) {
            System.out.println("Elementos apilados: " +elementos);
        }
        else {
            System.out.println("La pila esta vacia.");
        }
    }
    public boolean estaVacia() {
        return elementos.isEmpty();
    }
    public int tamañoPila () {
        return elementos.size();
    }
    public void vaciar () {
        elementos.clear();
        System.out.println("La pila ha sido vaciada.");
    }
    
}
