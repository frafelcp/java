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
public class colas_opera {
    static Scanner leer = new Scanner(System.in);
    public static void main(String[] args) {
        //Variables
        byte max = 9;
        byte opcion = 0;
        int i = 0;
        int ini = -1;
        int fin = -1;
        byte l[] = new byte[10];
        
        //menu
        while (opcion != 4) {            
            System.out.println("Digite un numero\n1. Insertar\n2. Eliminar\n3. Mostrar"
                    + "\n4.Salir");
            
            System.out.println("Escoga un numero: ");
            opcion = leer.nextByte();
            
            switch (opcion){
                case 1:
                    insertar(max, ini, fin, l);
                    break;
                case 2:
                    eliminar(max, ini, fin, l);
                case 3:
                    mostrar(max, i, ini, fin, l);
                case 4:
                    System.out.println("Gracias");
                    break;
            }
        }
    }

    private static void insertar(byte max, int ini, int fin, byte[] l) {
        System.out.println("insertar datos pila");
        if (fin != max) {
            if (ini == -1) {
                fin = fin + 1;
                ini = ini + 1;
                l[fin] = leer.nextByte();
            } else {
                fin = fin + 1;
                l[fin] = leer.nextByte();
            }
        } else {
            System.out.println("overflow");
        }
    }

    private static void eliminar(byte max, int ini, int fin, byte[] l) {
        System.out.println("eliminar pila");
        if (fin != -1) {
            if (fin == ini) {
                fin = fin - 1;
                ini = ini - 1;
            } else {
                ini = ini + 1;
            }
        } else {
            System.out.println("underflow");
        }
    }

    private static void mostrar(byte max, int i, int ini, int fin, byte[] l) {
        System.out.println("Mostrar pila");
        if (fin != -1) {
            for (i = ini; i <= fin; i++) {
                System.out.println(l[i]);
            }
        } else {
            System.out.println("cola vacia");
        }
    }
}
