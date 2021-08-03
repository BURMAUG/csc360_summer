package csc360_summer.assignment5;

/**
 * Instructor: Rasib Khan
 * @Author Burmau Garba
 * class: csc 364
 * */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyCircularLinkedList<E> implements MyList<E>{
    protected Node<E> tail = null ; // the tail node
    protected int size = 0;   //size of the linked list

    public MyCircularLinkedList() {
    }

    //Node as and inner class class
    private static class Node<E>{
        Node<E> next = null;
        E element;

        public Node(E element) {
            this.element = element;
        }
    }

    @Override
    public void add(int index, E e) {
        if (tail == null) {
            if (index == 0)
                addFirst(e);
        }
        else if (index == size){
            addLast(e);
        }else if (index < 0 || index > size)
            throw new IndexOutOfBoundsException();
        else
            {
              Node<E> newNode = new Node<>(e);
              Node<E> current = tail;
              for (int i = 0; i < index; i++)
                  current = current.next;
              Node<E> temp = current.next;
              current.next = newNode;
              newNode.next = temp;
              size++;
            }
    }

    @Override
    public E get(int index) {
        if (size == 0 || index > size-1)
            throw new IndexOutOfBoundsException("Index outta bounds");
        else
        {
            if (index == 0 )
                return getFirst();
            else if (index == size)
                return getLast();
            else if (index < 0 || index > size)
                throw new IndexOutOfBoundsException();
            else
            {
                Node<E> current = tail.next.next;
                for (int i = 1; i <= size-1; i++)
                {
                    if(i == index)
                    {
                        return current.element;
                    }
                    current  = current.next;
                }
            }
        }
        return null;
    }

    @Override
    public int indexOf(Object e) {
        if (size > 0){
            Node current = tail.next;
            for (int i = 0; i < size; i++) {
                if (current.element.equals(e)) {
                    return i;
                }
                current = current.next;
            }}
        // Implement it in this exercise
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {

        int idx = -1;
        if (size == 0 )
            return idx;
        Node<E> current = tail.next;
        for (int i = 0; i < size-1; i++) {
            if (current.element.equals(e))
                idx = i;
            current = current.next;
        }
        return idx;
    }

    //for now
    @Override
    public E remove(int index) throws UnsupportedOperationException {
        Node<E> current = tail.next;
        Node<E> temp ;
        if (index == 0)
            return removeFirst();
        else if (index == size)
            return removeLast();
        else{
            for (int i = 1; i < index; i++)
                current = current.next;
            temp = current.next;
            current.next = temp.next;
            size--;
        }
        return temp.element;
    }

    @Override
    public E set(int index, E e)
    {
        Node<E> newNode = new Node<>(e); //created a new node to store e
        if (index > size-1 || index < 0)
            throw new IndexOutOfBoundsException();
        else
        {
            if(index == 0) {
                E first = getFirst();
                addFirst(e);
                return first;
            }
            else if (index == size-1)
                return getLast();
            else
            {
                Node<E> current = tail.next;
                for (int i = 1; i <= size-1; i++) {
                    if (i == index)
                    {
                       Node<E> temp = current.next;
                       current.next = newNode;
                       newNode.next = temp.next;

                    }

                    current = current.next;
                }
            }
        }

        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        // Implement it in this exercise
        if (size > 0)
        {
            Node current = tail.next;
            for (int i = 0; i < size; i++)
            {

                if (current.element.equals(o))
                    return true;
            current = current.next;
            }
        }

        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new My_circular_LinkedList_Iterator();
    }

    @Override
    public void clear() {
        size = 0;
        tail.next = tail = null;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        Node<E> temp = tail;
        newNode.next = tail.next; //canada
        temp.next = newNode;
        tail = newNode;
        size++;
    }

    public E removeFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        else{
            Node<E> temp = tail.next;
            tail.next = tail.next.next;
            size--;
            return temp.element;
        }
    }

    public E getLast() {
        if (size == 0 )
            throw new NoSuchElementException();
        return tail.element;
    }

    public E removeLast() {
        if (size <= 0 )
            throw new NoSuchElementException();
        else {
        Node<E> current = tail.next;
        Node<E> last = tail;
        for (int i = 0; i < size-1; i++)
        {
            current = current.next;
            //System.out.println("bug" +current.element);
        }
        }
        return null;
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<>(element);
        if (size == 0)
        {
            tail = newNode;
            tail.next = newNode;
            size++;
        }else
        {
            Node<E> temp = tail.next;
            newNode.next = temp;
            tail.next = newNode;
            size++;
        }

    }

    public E getFirst() {
        if (size == 0)
            throw new NoSuchElementException();
        return  tail.next.element;
//        return null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        if (size == 0)
            return "[]";
        else{
        Node<E> current = tail.next;
        for (int i = 0; i < size; i++)
        {
            result.append(current.element);
            current = current.next;
            if (current != null && i < size -1)
                result.append(", ");
            else
                result.append("]");
        }}
        return result.toString();
    }


   private  class My_circular_LinkedList_Iterator implements Iterator<E>{
        Node<E> current = tail.next;

        @Override
       public boolean hasNext() {
           //create a temp node
           Node<E> it = current;
           Node<E> temp = tail;
           if(it.element.equals(temp.element)){
               return false;
           }
           return false;
       }

       @Override
       public E next() {
           E e = current.element;
           current = current.next;
           return e;
       }

       @Override
       public void remove() {
           Iterator.super.remove();
       }
   }

}
