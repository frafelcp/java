
package arb;

import javax.swing.JopttionPane;

public class arb {
     static class arbol{;
        arbol left,rig;
        int date;
}
     
    static arbol raiz=null;
    
    public static void main(String[] args) {
        byte opt = 0;
        arbol result;
        do {
            opt = Byte.parseByte(JOptionPane.showInputDialog("Menu selecciona"
                    + "\n1.Crear árbol"
                    + "\n2. Insertar un nuevo nodo"
                    + "\n3. Buscar un nodo"
                    + "\n4. Eliminar" 
                    + "\n5. Salir"));
                    
            switch (opt) {
                case 1:
                    createArbol();
                    break;

                case 2:
                    insert();
                    break;

                case 3:
                    result = searchNodo();
                    if (result != null) {
                        JOptionPane.showMessageDialog(null, "dato encontrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "dato no encontrado");
                    }
                    break;

                case 4:
                    System.out.close();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "ingrese una opcion");
                    break;
            }
        } while (opt != 4);
    }
    
    public static void createArbol() {
        if (raiz == null) {
            raiz = new arbol();
            raiz.date = Integer.parseInt(JOptionPane.showInputDialog("Ingrese date a insertar"));
            raiz.left = null;
            raiz.rig = null;
            JOptionPane.showMessageDialog(null, "Arbol creado");
        } else {
            JOptionPane.showMessageDialog(null, "El árbol ya esta creado\nProceda a insertar nodos");
            insert();
        }
    }
    
    public static void insert() {
        arbol aux;int date_in;
        if (raiz!=null){
            arbol newNodo;
            newNodo=new arbol();
            date_in=Integer.parseInt(JOptionPane.showInputDialog("Ingrese date a insertar"));
            newNodo.date=date_in;
            newNodo.left=null;
            newNodo.rig=null;
            
            aux=raiz; // EMPEZAR A BUSCAR LA POSICION DESDE LA RAIZ
            while (aux!=null){
                if (date_in<aux.date){ // Si dates insertar es menor a AUX(RAIZ) se va hacia a la leftuierda
                    if (aux.left==null){ // Si AUX_left es null se le asigna el nuevo nodo
                        aux.left=newNodo;
                        JOptionPane.showMessageDialog(null, "Nodo insertado");
                        aux=null;  // salir del mientras que
                    }else{ // sino es porque ya hay algo en el nodo 
                        aux=aux.left;
                    }
                }else{ // ES PORQUE EL dateS ES MAYOR Y SE VA PARA LA rigECHA
                    if (aux.rig==null){
                        aux.rig=newNodo;
                        JOptionPane.showMessageDialog(null, "Nodo insertado");
                        aux=null; // salir del mientras que
                    }else{
                        aux=aux.rig;
                    }
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Por favor, crear el árbol");
            createArbol();
        }
    }
    
    public static arbol searchNodo() {
        arbol aux;int date;
        aux=raiz;
        date=Integer.parseInt(JOptionPane.showInputDialog("Ingrese date a buscar"));
        while (aux!=null){
            if (aux.date==date){
                return aux;
            }else{
                if (aux.date>date){
                    aux=aux.left;
                }else{
                    aux=aux.rig;
                }
            }
        }
        return null;
    }    
    
  public static void eliminar (){
      arbol padre= raiz, aux=raiz, aux1=null; 
      int date_in; 
      if (aux.rig.left != null) {
          aux.date=aux1.date;
          aux1=aux1.rig;   
      }
      
      while (aux1.left != null) {          
          padre=aux1;
          aux1=aux1.left;
      }
      aux.date = aux1.date;
      
      
  }
    
    
    public void Inorden(Nodo date) {
            if (date != null) {
                Inorden(date.left);
                System.out.print(date.valor + " ");
                Inorden(date.rig);
            }
        }
    
    
}