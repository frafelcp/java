/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doce21;

import java.awt.Event;
import java.util.Scanner;

/**
 *
 * @author estudiante
 */
public class Doce21 {
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String args[]) {
        int num;
        System.out.println("INGRESE UN NUMERO");
        num = sc.nextInt();
        home(num);
    }

    public static void home(int num) {
        //int num;
        //System.out.println("INGRESE UN NUMERO");
        //num = sc.nextInt();

        int vm[] = new int[120 + num];
        String mes[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        for (int k = 0; k < 10; k += 1) {
            for (int z = 0; z < 12; z += 1) {
                System.out.println("ingrese la venta del producto " + k + " del mes " + mes[z]);
                vm[num + (12 * k) + z] = sc.nextInt();
            }
        }

        mostrar(vm, num);
        venta_total(vm, num, mes);
    }

    public static void venta_total(int vm[], int n, String mes[]) {
        int sum = 0;
        int venta_total[] = new int[10];
        for (int k = 0; k < 10; k += 1) {
            for (int z = 0; z < 12; z += 1) {
                sum += vm[n + (12 * k) + z];
            }
            venta_total[k] = sum;
            sum = 0;
        }

        mostrar_vector(venta_total);
        peor_mes(vm, mes, n);
    }

    public static void mostrar_vector(int venta_total[]) {
        for (int i = 0; i < 10; i += 1) {
            System.out.println("Venta toatl del producto No. " + i + ": " + venta_total[i]);
        }

        int mayor = venta_total[9], pos = 0;
        for (int i = 0; i < 10; i += 1) {
            if (venta_total[i] > mayor) {
                mayor = venta_total[i];
                pos = i;
            }
        }

        System.out.println("El producto mas vendido es el No. " + pos + " con valor de: " + venta_total[pos]);
    }

    public static void peor_mes(int vm[], String mes[], int n) {
        int sum = 0;
        int venta_xmes[] = new int[12];
        for (int z = 0; z < 12; z += 1) {
            for (int k = 0; k < 10; k += 1) {
                sum += vm[n + (10 * z) + k];
            }
            venta_xmes[z] = sum;
            sum = 0;
        }

        int menor = venta_xmes[12], pos = 0;
        for (int i = 0; i < 12; i += 1) {
            if (venta_xmes[i] < menor) {
                menor = venta_xmes[i];
                pos = i;
            }
        }

        System.out.println("El peor mes fue: " + mes[pos] + " con valor de: " + venta_xmes[pos]);

        int mayor = venta_xmes[12];
        for (int i = 1; i <= 8; i += 1) {
            if (venta_xmes[i] < mayor) {
                mayor = venta_xmes[i];
                pos = i;
            }
        }

        System.out.println("El más vendido entre los mese " + mes[1] + " y " + mes[8] + " es: " + mes[pos]);
    }

    public static void mostrar(int vm[], int n) {
        for (int k = 0; k < 10; k += 1) {
            for (int z = 0; z < 12; z += 1) {
                System.out.print(vm[n + (12 * k) + z]);
            }

            System.out.println();
        }
    }

    public static void seguir() {
        Scanner sc = new Scanner(System.in);
        int r;
        boolean sw = true;
        do {
            System.out.println("Si desea continuar digite 1. de lo contrario digite 2.");
            r = sc.nextInt();
            switch (r) {
                case 1:
                    home();
                    break;
                case 2:
                    sw = false;
                    break;
                default:
                    System.out.println("Elija una opción válida!");
                    break;
            }
        } while (sw);
    }
}
