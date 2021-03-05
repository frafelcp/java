/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estrucDatos;

import java.util.Scanner;

/**
 *
 * @author FELIX
 */
public class pilas_opera {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        //Variables
        byte max = 9;
        byte opcion = 0;
        int top = -1;
        int i = 0;
        byte l[] = new byte[10];
        
        //menu
        while (opcion != 4) {            
            System.out.println("Digite un numero\n1. Insertar\n2. Eliminar\n3. Mostrar"
                    + "\n4.Salir");
            
            System.out.println("Escoga un numero: ");
            opcion = leer.nextByte();
            
            switch (opcion){
                case 1:
                    insertar(max, top, l);
                case 2:
                    eliminar(top);
                case 3:
                    mostrar(max, top, l, i);
                case 4:
                    System.out.println("Gracias");
                    break;
            }
        }
    }

    private static void insertar(byte max, int top, byte[] l) {
        System.out.println("insertar datos pila");
        if (top != max) {
            top = top + 1;
            System.out.println("Ingrese un valor");
            l[top] = leer.nextByte();
        } else {
            System.out.println("pila llena");
        }
    }

    private static void eliminar(int top) {
        System.out.println("eliminar pila");
        if (top != -1) {
            top = top - 1;
        } else {
            System.out.println("pila vacia");
        }
    }

    private static void mostrar(byte max, int top, byte[] l, int i) {
        System.out.println("Mostrar pila");
        if (top != -1) {
            for (i = top; i >= 0; i--) {
                System.out.println(l[i]);
            }
        } else {
            System.out.println("Pila vacia");
        }
    }
}
