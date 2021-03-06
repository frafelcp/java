
package Arboles;

import javax.swing.JOptionPane;

public class Arboles {
     static class arbol{;
        arbol izq,der;
        int dato;
}
     
    static arbol raiz=null;
    
    public static void main(String[] args) {
        byte op = 0;
        arbol resultado;
        do {
            op = Byte.parseByte(JOptionPane.showInputDialog("Menu"
                    + "\n1.Crear árbol"
                    + "\n2. Insertar un nuevo nodo"
                    + "\n3. Salir"));
                    
            switch (op) {
                case 1:
                    crear_arbol();
                    break;

                case 2:
                    insertar();
                    break;



                default:
                    JOptionPane.showMessageDialog(null, "Por favor ingrese una opcion correcta");
                    break;
            }
        } while (op != 4);
    }
    
    public static void crear_arbol() {
        if (raiz == null) {
            raiz = new arbol();
            raiz.dato = Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato a insertar"));
            raiz.izq = null;
            raiz.der = null;
            JOptionPane.showMessageDialog(null, "Arbol creado");
        } else {
            JOptionPane.showMessageDialog(null, "El árbol ya esta creado\nProceda a insertar nodos");
            insertar();
        }
    }
    
    public static void insertar() {
        arbol aux;int dato_in;
        if (raiz!=null){
            arbol nuevonodo;
            nuevonodo=new arbol();
            dato_in=Integer.parseInt(JOptionPane.showInputDialog("Ingrese dato a insertar"));
            nuevonodo.dato=dato_in;
            nuevonodo.izq=null;
            nuevonodo.der=null;
            
            aux=raiz; // EMPEZAR A BUSCAR LA POSICION DESDE LA RAIZ
            while (aux!=null){
                if (dato_in<aux.dato){ // Si datos insertar es menor a AUX(RAIZ) se va hacia a la izquierda
                    if (aux.izq==null){ // Si AUX_IZQ es null se le asigna el nuevo nodo
                        aux.izq=nuevonodo;
                        JOptionPane.showMessageDialog(null, "Nodo insertado");
                        aux=null;  // salir del mientras que
                    }else{ // sino es porque ya hay algo en el nodo 
                        aux=aux.izq;
                    }
                }else{ // ES PORQUE EL DATOS ES MAYOR Y SE VA PARA LA DERECHA
                    if (aux.der==null){
                        aux.der=nuevonodo;
                        JOptionPane.showMessageDialog(null, "Nodo insertado");
                        aux=null; // salir del mientras que
                    }else{
                        aux=aux.der;
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, crear el árbol");
            crear_arbol();
        }
    }
    
    
   
      
      while (aux1.izq != null) {          
          padre=aux1;
          aux1=aux1.izq;
      }
      aux.dato = aux1.dato;
      
      
  }
    
    
   
    
    
}