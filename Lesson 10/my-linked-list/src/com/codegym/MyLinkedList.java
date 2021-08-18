package com.codegym;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }
    public void addLast(Object data) {
        Node temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        numNodes++;
        temp.next = new Node(data);
    }
    public void add(int index, Object data) {
        Node temp = head;
        Node holder;
        for(int i=1;i<index;i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes++;
    }
    public void remove(int index) {
        Node temp = head;
        for(int i=0;i<index-1;i++) {
            temp = temp.next;
        }
        Node holder = temp.next;
        temp.next = holder.next;
        numNodes--;
    }

    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
