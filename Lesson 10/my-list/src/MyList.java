import java.lang.reflect.Array;
import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public Object[] getElements() {
        return  this.elements;
    }
    public int size() {
        return this.size;
    }
    public boolean add(E e) {
        ensureCapacity();
        elements[size] = e;
        size++;
        return true;
    }
    public void add(int index, E e) {
        ensureCapacity();
        Object[] newArray = new Object[elements.length];
        checkIndex(index);
        for(int i=0;i<size+1;i++) {
            if(i<index) {
                newArray[i] = elements[i];
            }else if(i==index) {
                newArray[i] = e;
            }else if(i>index) {
                newArray[i] = elements[i-1];
            }
        }
        elements = newArray;
        size++;
    }
    public E remove(int index) {
        Object[] newArray = new Object[elements.length];
        checkIndex(index);
        for(int i=0;i<size;i++) {
            if(i<index) {
                newArray[i] = elements[i];
            }else if(i>index) {
                newArray[i-1] = elements[i];
            }
        }
        Object deleteElement = elements[index];
        elements = newArray;
        size--;
        return (E) deleteElement;
    }
    public void ensureCapacity() {
        if(size==elements.length) {
            int newLength = elements.length*2;
            elements = Arrays.copyOf(elements,newLength);
        }
    }
    public MyList<E> clone() {
        MyList<E> newList = new MyList<>();
        newList.elements = this.elements;
        newList.size = this.size;
        return newList;
    }
    public boolean contains(E o) {
        boolean isContain = false;
        for(Object i : elements) {
            if((E) i == o) {
                isContain = true;
                break;
            }
        }
        return isContain;
    }
    public int indexOf(E o) {
        int index = -1;
        for(int i=0;i<size;i++) {
            if((E) elements[i] == o) {
                index = i;
                break;
            }
        }
        return index;
    }
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    private void checkIndex(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index Wrong");
        }
    }
    public void clear() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }
}
