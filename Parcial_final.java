
package Parcial_;

import Formativa;
import static Formativa.promedio;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class parcial {
    static class Estudiante {

        String name;
        int nota;
        Estudiante left;
        Estudiante righ;
    }
    public static Estudiante raiz;

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        Estudiante raiz = null, aux = null, aux1 = null;
        String nom;
        int nota1 = 0, notadb, c = 0, c2;
        boolean salir = false;
        String[] funciones = {"Ingresar nota",
            "a.Buscar  estudiante especifico ",
            "Rama con mas estudiantes",
            "Promedio de notas",
            "Aumentar notas",
            "Mostrar nodos intermedios",
            "Salir"};
        do {
            String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una funcion", "Selecciona", JOptionPane.QUESTION_MESSAGE, null, funciones, funciones[0]);
            switch (opcion) {
                case "Ingresar notas":
                     if (raiz == null) {
                        raiz = new Estudiante();
                        System.out.println("ingrese el name ");
                        raiz.name = l.nextLine();
                        System.out.println("ingrese la nota ");
                        raiz.nota = l.nextInt();
                        raiz.righ = null;
                        raiz.left = null;
                        JOptionPane.showMessageDialog(null, " SE HA CREADO EL ARBOL ");
                        System.out.println("SE HA CREADO EL ARBOL");
                        System.out.println();
                    } else {
                        aux = raiz;
                         System.out.println("ingrese el name ");
                         nom=l.next();
                        System.out.println("ingrese la nota ");
                        nota1 = l.nextInt();
                        insert(nota1, aux,nom);
                    }
                    break;
                case " A. Buscar estudiante":
                    if (raiz != null) {
                        aux = raiz;
                        int nivel = 1;
                        System.out.println("ingrese la nota a  del estudiante a buscar");
                        notadb = l.nextInt();
                        busqueda(notadb, aux, nivel);
                    } else {
                        JOptionPane.showMessageDialog(null, " favor crear el arbol");
                    }
                    break;
                    
                     case "Promedio de notas": // promedio de datos
                    aux = raiz;

                    double pro = promedio(aux, c);
                    System.out.println("el promedio de notas es: " + pro);

                    break;
                case "e . La rama con mas estudiantes":
                    aux = raiz;
                    int p = cantidad_righe(aux);
                    aux = raiz;
                        
                    if(x>p){
                        System.out.println("null");
                        mostrarA(aux.left);
                    }else{
                        System.out.println("Rama righecha del arbol");
                        mostrarA(aux.righ);
                    }
                    break;
                case "Aumentar notas":
                        Aumentar(aux);
                    break;
                case "Mostrar nodos intermedios y eliminarlo":
                     Mostranodosinter(aux);
                    break;
                case "Salir":
                    salir = true;
                    break;
            }
        } while (!salir);
    }
    
       public static void insert(int edadI, Estudiante aux,String nom) {
        Estudiante aux1;

        if (aux.nota > edadI) {
            if (aux.left == null) {
                aux1 = new Estudiante();
                 aux1.name = nom;
                aux1.nota = edadI;
                aux1.left = null;
                aux1.righ = null;
                aux.left = aux1;
                JOptionPane.showMessageDialog(null, " datos insertados ");
            } else {
                aux = aux.left;
                insert(edadI, aux, nom);
            }
        } else if (aux.righ == null) {
            aux1 = new Estudiante();
            aux1.name = nom;
            aux1.nota = edadI;
            aux1.left = null;
            aux1.righ = null;
            aux.righ = aux1;
            JOptionPane.showMessageDialog(null, " datos insertados ");
        } else {
            aux = aux.righ;
            insert(edadI, aux,nom);
        }

    }
       
        public static void busqueda(int notadb, Estudiante aux, int nivel) {
         int con;
        if (aux.nota == notadb) {
            con = nivel;
            JOptionPane.showMessageDialog(null, " Se encontro al estudiante"+aux.name+" en el nivel " + con);

        } else if (notadb < aux.nota) {
            if (aux.left == null) {
                JOptionPane.showMessageDialog(null, " no se encontro ");

            } else {
               busqueda(notadb, aux.left, nivel + 1);
            }
        } else if (aux.righ == null) {
            JOptionPane.showMessageDialog(null, " no se encontro ");

        } else {
            busqueda(notadb, aux.righ, nivel + 1);
        }
    }
        public static double promedio(parcial.Estudiante aux, int k) {
        int c = 0;
        double s1 = 0, s2 = 0;
        if (aux == null) {
            return 0;
        }
        s1 = promedio(aux.left, k + 1);
        c = c + 1;
        s2 = promedio(aux.righ, k + 1);
        c = c + 1;
        if (c >= 0) {
            return (s1 + s2 + (aux.nota)) / c;
        }
        return (s1 + s2) / c;

    }

    public static int cantidad_righe(Estudiante aux) {
        int cantD = 0;
        if (aux == null) {
            return 0;
        } else {
            cantD = numerodedatos(aux.righ);
            return cantD;
        }

    }
    
    public static int numerodedatos(Estudiante aux) {
        int cantI, cantD;
        if (aux == null) {
            return 0;
        } else {
            cantI = numerodedatos(aux.left);
            cantD = numerodedatos(aux.righ);
            return cantI + cantD + 1;
        }

    }
    
    public static void mostrarA(Estudiante aux) {
        if (aux == null) {

            return;

        } else {

            JOptionPane.showMessageDialog(null, aux.nota);
            mostrarA(aux.left);
            mostrarA(aux.righ);
        }
    }
    
    public static void Aumentar(Estudiante aux) {
        if (aux == null) {

            return;

        } else {

            aux.nota=(int) (aux.nota+0.2);
            Aumentar(aux.left);
            Aumentar(aux.righ);
        }
    }
    
    public static void Mostranodosinter(Estudiante aux) {
        if ((aux.left == null)&&(aux.righ == null)) {

            return;

        } else {

            JOptionPane.showMessageDialog(null, aux.nota);
            Mostranodosinter(aux.left);
            Mostranodosinter(aux.righ);
        }
    }
}
