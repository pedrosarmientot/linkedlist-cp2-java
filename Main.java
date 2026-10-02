public class Main{

    public static void imprimir(LinkedList<String> lista){
        for(int i=0; i<lista.size(); i++){
            System.out.print(lista.get(i));
            if(i < lista.size()-1) System.out.print("-");
        }
        System.out.println();
    }

    public static void main(String args[]){
        System.out.println("=== Eliminar elementos repetidos ===");
        LinkedList<String> l1 = new LinkedList<String>();
        l1.add("A"); l1.add("B"); l1.add("C"); l1.add("A"); l1.add("D"); l1.add("B"); l1.add("E");
        System.out.print("Antes: "); imprimir(l1);
        l1.removeDuplicates();
        System.out.print("Despues (Esperado: A-B-C-D-E): "); imprimir(l1);

        System.out.println("\n=== Rotar una posicion a la derecha ===");
        LinkedList<String> l2 = new LinkedList<String>();
        l2.add("A"); l2.add("B"); l2.add("C"); l2.add("D"); l2.add("E"); l2.add("F");
        System.out.print("Antes: "); imprimir(l2);
        l2.rotateRight();
        System.out.print("Despues (Esperado: F-A-B-C-D-E): "); imprimir(l2);

        System.out.println("\n=== Concatenar dos listas ===");
        LinkedList<String> l3a = new LinkedList<String>();
        l3a.add("A"); l3a.add("B"); l3a.add("C"); l3a.add("D");
        LinkedList<String> l3b = new LinkedList<String>();
        l3b.add("E"); l3b.add("F"); l3b.add("G"); l3b.add("H"); l3b.add("I");
        System.out.print("Lista1: "); imprimir(l3a);
        System.out.print("Lista2: "); imprimir(l3b);
        l3a.concat(l3b);
        System.out.print("Resultado (Esperado: A-B-C-D-E-F-G-H-I): "); imprimir(l3a);
    }
}