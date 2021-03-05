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
public class listasColasOper {
    public static void main(String[] args) {
        byte max = 9;
        byte opcion = 0;
        int top = -1;
        int i = 0;
        byte l[] = new byte[10];
        
        Scanner leer = new Scanner(System.in);
        
        while (opcion != 4) {            
            System.out.println("Digite un numero\n1. Insertar\n2. Eliminar\n3. Mostrar"
                    + "\n4.Salir");
            
            opcion = leer.nextByte();
            
            switch (opcion){
                case 1:
                    if (top != max) {
                        top += 1;
                        System.out.println("Ingrese un valor");
                        l[top] = leer.nextByte();
                    } else {
                        System.out.println("pila llena");
                    }
                case 2:
                    if (top != -1) {
                        top -= 1;
                    } else {
                        System.out.println("pila vacia");
                    }
                case 3:
                    if (top != -1) {
                        for (i = top; i >= 0; i--) {
                            System.out.println(l[i]);
                        }
                    } else {
                        System.out.println("Pila vacia");
                    }
                case 4:
                    System.out.println("Gracias");
                    break;
            }
        }
    }
}
