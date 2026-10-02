public class LinkedList<E> implements IList<E>{
    private Node<E> first;
    private int size;

    public LinkedList(){
        this.first = null;
        this.size = 0;
    }

    @Override 
    public void add(E e){
        Node<E> node = new Node<E>(e);
        if(isEmpty()){
            first = node;
        } else {
            Node<E> cursor = first;
            while(cursor.getNext() != null){
                cursor = cursor.getNext();
            }
            cursor.setNext(node);
        }
        size++;
    }

    @Override 
    public void add(E e, int index){
        if(index >= 0 && index <= size){
            if(index == 0){
                first = new Node<E>(e,first);
            } else {
                Node<E> cursor = first;
                for(int i=0; i<index-1; i++) {
                    cursor = cursor.getNext();
                }
                Node<E> node = new Node<E>(e);
                node.setNext(cursor.getNext());
                cursor.setNext(node);
            }
            size++;
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    @Override
    public E remove(int index){
        if(index >= 0 && index < size){
            Node<E> aux;
            if(index == 0){
                aux = first;
                first = first.getNext();
            } else {
                Node<E> cursor = first;
                for(int i=0; i<index-1; i++) {
                    cursor = cursor.getNext();
                }
                aux = cursor.getNext();
                cursor.setNext(aux.getNext());
            }
            size--;
            aux.setNext(null);
            return aux.getInfo();
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }

    @Override 
    public E get(int index){
        if(index >= 0 && index < size){
            Node<E> cursor = first;
            for(int i=0; i<index; i++) {
                cursor = cursor.getNext();
            }            
            return cursor.getInfo();
        } else {
            throw new IndexOutOfBoundsException("Index out of range");
        }
    }
    
    public void removeDuplicates(){
        Node<E> current = first;
        while(current != null){
            Node<E> anterior = current;
            Node<E> cursor = current.getNext();
            while(cursor != null){
                if(cursor.getInfo().equals(current.getInfo())){
                    anterior.setNext(cursor.getNext());
                    size--;
                } else {
                    anterior = cursor;
                }
                cursor = cursor.getNext();
            }
            current = current.getNext();
        }
    }

    public void rotateRight(){
        if(size <= 1) return;

        Node<E> cursor = first;
        while(cursor.getNext().getNext() != null){
            cursor = cursor.getNext();
        }
        Node<E> last = cursor.getNext();
        cursor.setNext(null);
        last.setNext(first);
        first = last;
    }
    
    public void concat(LinkedList<E> secondList){
        if(secondList.isEmpty()) return;

        if(this.isEmpty()){
            this.first = secondList.first;
        } else {
            Node<E> cursor = this.first;
            while(cursor.getNext() != null){
                cursor = cursor.getNext();
            }
            cursor.setNext(secondList.first);
        }
        this.size += secondList.size;re
    }

    @Override 
    public int size(){
        return size;
    }

    @Override 
    public void clear(){
        first = null;
        size = 0;
    }

    @Override 
    public boolean isEmpty(){
        return size == 0;
    }
}