
import javax.swing.JOptionPane;
import java.util.Scanner;

public class apliArbol {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Estudiante raiz = null, aux = null, auxil1 = null;
        String nom;
        int notl = 0, notB, c = 0, c2;
        boolean exit = false;
        String[] funciones = { "Ingresar notas", "Buscar estudiante", "Rama con mas estudiantes", "incrementar nota",
                "Mostrar nodos intermedios", "Numero de notas existentes", "Nodos hojas", "Promedio de notas", "Mayor",
                "Mostrar arbol", "exit" };
        do {
            String option = (String) JOptionPane.showInputDialog(null, "Selecciona una funcion", "Selecciona",
                    JOptionPane.QUESTION_MESSAGE, null, funciones, funciones[0]);
            switch (option) {

                case "Ingresar notas":
                    if (raiz == null) {
                        raiz = new Estudiante();
                        System.out.println("ingrese el nombre ");
                        raiz.nombre = leer.nextLine();
                        System.out.println("ingrese la nota ");
                        raiz.nota = leer.nextInt();
                        raiz.rig = null;
                        raiz.left = null;
                        JOptionPane.showMessageDialog(null, " SE HA CREADO EL ARBOL ");
                        System.out.println("SE HA CREADO EL ARBOL");
                        System.out.println();
                    } else {
                        aux = raiz;
                        System.out.println("ingrese el nombre ");
                        nom = leer.next();
                        System.out.println("ingrese la nota ");
                        notl = leer.nextInt();
                        insertar(notl, aux, nom);
                    }
                    break;
                case "Buscar estudiante":
                    if (raiz != null) {
                        aux = raiz;
                        int nivel = 1;
                        System.out.println("ingrese la nota del estudiante a buscar");
                        notB = leer.nextInt();
                        Buscar(notB, aux, nivel);
                    } else {
                        JOptionPane.showMessageDialog(null, " favor crear el arbol");
                    }
                    break;
                case "Rama con mas estudiantes":
                    aux = raiz;
                    int x = numNotas(aux.left);
                    int p = numNotas(aux.rig);
                    aux = raiz;

                    if (x > p) {
                        System.out.println("Rama izquierda");
                        mostrarA(aux.left);
                    } else {
                        System.out.println("Rama derecha");
                        mostrarA(aux.rig);
                    }
                    break;
                case "incrementar nota":
                    incrementar(aux);
                    break;
                case "Mostrar nodos intermedios":
                    showNodInter(aux);
                    break;

                case "Numero de notas existentes": // Numero de notas del Estudiante
                    if (raiz != null) {
                        aux = raiz;
                        int n = numNotas(aux);
                        JOptionPane.showMessageDialog(null, " hay " + n + " notas ");
                    } else {
                        JOptionPane.showMessageDialog(null, " favor crear el arbol");
                    }
                    break;

                case "Nodos hojas":
                    aux = raiz;
                    c = 0;
                    c = nodoshoja(aux);
                    JOptionPane.showMessageDialog(null, "CANTIDAD DE NODOS HOJA:  " + c);

                    break;

                case "Promedio de notas": // promedio de notas
                    aux = raiz;

                    double pro = promedio(aux, c);
                    System.out.println("el promedio de notas es: " + pro);

                    break;

                case "Mayor":
                    aux = raiz;
                    Estudiante f;
                    f = mayor(aux);
                    System.out.println("La nota mayor es: " + f.nota + " del estudiante " + f.nombre);
                    break;

                case "Mostrar arbol":
                    if (raiz != null) {
                        aux = raiz;
                        mostrarA(aux);
                    } else {
                        JOptionPane.showMessageDialog(null, " favor crear el Estudiante");
                    }

                    break;

                case "exit":
                    exit = true;
                    break;

            }

        } while (!exit);

    }

    public static void insertar(int notl, Estudiante aux, String nom) {
        Estudiante auxil1;

        if (aux.nota > notl) {
            if (aux.left == null) {
                auxil1 = new Estudiante();
                auxil1.nombre = nom;
                auxil1.nota = notl;
                auxil1.left = null;
                auxil1.rig = null;
                aux.left = auxil1;
                JOptionPane.showMessageDialog(null, " notas insertados ");
            } else {
                aux = aux.left;
                insertar(notl, aux, nom);
            }
        } else if (aux.rig == null) {
            auxil1 = new Estudiante();
            auxil1.nombre = nom;
            auxil1.nota = notl;
            auxil1.left = null;
            auxil1.rig = null;
            aux.rig = auxil1;
            JOptionPane.showMessageDialog(null, " notas insertados ");
        } else {
            aux = aux.rig;
            insertar(notl, aux, nom);
        }

    }

    public static void Buscar(int notB, Estudiante aux, int nivel) {
        int con;
        if (aux.nota == notB) {
            con = nivel;
            JOptionPane.showMessageDialog(null, " Se encontro al estudiante" + aux.nombre + " en el nivel " + con);

        } else if (notB < aux.nota) {
            if (aux.left == null) {
                JOptionPane.showMessageDialog(null, " no se encontro ");

            } else {
                Buscar(notB, aux.left, nivel + 1);
            }
        } else if (aux.rig == null) {
            JOptionPane.showMessageDialog(null, " no se encontro ");

        } else {
            Buscar(notB, aux.rig, nivel + 1);
        }
    }

    public static void incrementar(Estudiante aux) {
        if (aux == null) {

            return;

        } else {

            aux.nota = aux.nota + 1;
            incrementar(aux.left);
            incrementar(aux.rig);
        }
    }

    public static void showNodInter(Estudiante aux) {
        if ((aux.left == null) && (aux.rig == null)) {

            return;

        } else {

            JOptionPane.showMessageDialog(null, aux.nota);
            showNodInter(aux.left);
            showNodInter(aux.rig);
        }
    }

    public static int numNotas(Estudiante aux) {
        int cantI, cantD;
        if (aux == null) {
            return 0;
        } else {
            cantI = numNotas(aux.left);
            cantD = numNotas(aux.rig);
            return cantI + cantD + 1;
        }

    }

    public static int nodoshoja(Estudiante aux) {

        if (aux == null) {
            return 0;
        } else if (aux.left == null && aux.rig == null) {
            return 1;
        } else {
            return nodoshoja(aux.left) + nodoshoja(aux.rig);
        }

    }

    public static double promedio(Estudiante aux, int k) {
        int c = 0;
        double s1 = 0, s2 = 0;
        if (aux == null) {
            return 0;
        }
        s1 = promedio(aux.left, k + 1);
        c = c + 1;
        s2 = promedio(aux.rig, k + 1);
        c = c + 1;
        if (c >= 0) {
            return (s1 + s2 + (aux.nota)) / c;
        }
        return (s1 + s2) / c;

    }

    public static Estudiante mayor(Estudiante aux) {
        Estudiante may = null;
        Estudiante auxil1 = aux.left;
        Estudiante aux2 = aux.rig;

        if (aux == null) {
            return null;
        }
        if (auxil1 == null && aux2 == null) {
            return aux;

        } else {

            if (auxil1.nota > aux2.nota) {
                if (auxil1.nota > auxil1.rig.nota) {
                    may = auxil1;

                    mayor(auxil1);
                } else {
                    if (auxil1.left.nota > auxil1.rig.nota) {
                        may = auxil1.left;
                        mayor(auxil1.left);
                    } else {
                        may = auxil1.rig;
                        mayor(auxil1.rig);
                    }
                }

            } else {
                if (aux2.nota > aux2.rig.nota) {
                    may = aux2;

                    mayor(aux2);
                } else {
                    if (aux2.left.nota > aux2.rig.nota) {
                        may = aux2.left;
                        mayor(aux2.left);
                    } else {
                        may = aux2.rig;
                        mayor(aux2.rig);
                    }
                }

            }

        }

        return may;

    }

    public static void mostrarA(Estudiante aux) {
        if (aux == null) {

            return;

        } else {
            JOptionPane.showMessageDialog(null, aux.nombre);
            JOptionPane.showMessageDialog(null, aux.nota);
            mostrarA(aux.left);
            mostrarA(aux.rig);
        }
    }

    static class Estudiante {

        String nombre;
        int nota;
        Estudiante left;
        Estudiante rig;
    }

    public static Estudiante raiz;
}
