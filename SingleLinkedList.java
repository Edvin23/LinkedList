public class SingleLinkedList <E> implements  BareBonesLinkedList<E>{

    //create nodes do create node class

    private class Node<F>{
        private F data;
        private Node<F> next;

        //Constructors

        public Node(F data, Node<F> next){
            this.data = data;
            this.next = next;
        }
        //when only the data is supplied, and the next is null
        public Node(F data){
            this(data, null);//This calls the other constructor to create the node
        }
    }
    //Data for method and linkedlist
    private Node<E> head;// reference to the head of the ll
    private int size;//how many nodes are there in the ll

    //constructor for the ll
    public SingleLinkedList(){
        this.head = new Node<E>(null);
        //the head has no data, or next value at the start
        this.size = 0;
    }
    @Override
    public void add(int index, E item) {//this method adds an element to the ll
        //depending on the index it adds to the first location using addFirst
        //or add after using addAfter

        if(index<0 || index > size){
            System.out.println("Invalid Index");
            return;
        }
        else if(index ==0){
            addFirst(item);
        }
        else{
            Node<E> node = getNode(index);
            addAfter(node, item);
        }

    }

    private void addFirst(E item) {
        //we create a node, with item as data, and head.next as the next
        //then we update the head.next to point to this newly created node

        //Node<E> temp = new Node<E>(item, head.next);
        //head.next = temp;
        head.next = new Node<E>(item, head.next);
        size++;

    }

    private void addAfter(Node<E> node, E item) {
        //ADD the item after the reference
        node.next = new Node<E>(item, node.next);
        size++;

    }

    private Node<E> getNode(int index) {
        if(index<0 || index > size){
            System.out.println("Invalid Index");
            return null;
        }
        //this method loops over the ll and returns the reference of the node at indez
        Node<E> node = head;
        for(int i = 0; i < index && node != null; i++){
            node = node.next;
        }
        return node;
    }

    @Override
    public E remove(int index) {
        //this method removes an element from the ll at given index
        //check if the index is valid
        if(index<0 || index > size){
            System.out.println("Invalid Index");
            return null;
        }
        else if(index == 0){
            return removeFirst();
        }
        else {
            Node<E> node = getNode(index);
            return removeAfter(node);
        }
    }

    private E removeAfter(Node<E> node) {
        Node<E> temp = node.next;
        if(temp != null){
            node.next = temp.next;
            size--;
            return temp.data;
        }
        return null;
    }

    private E removeFirst() {
        //delete the first node
        Node<E> temp = head;
        if(temp != null){
            head = head.next;
            size--;
            return temp.data;
        }
        return null;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size ){
          System.out.println("Invalid Index");
          return null;
        }
        else {
            Node<E> node = getNode(index);
            return node.data;
        }
    }

    @Override
    public E set(int index, E newValue) {
        if(index < 0 || index >= size){
           System.out.println("Invalid Index");
           return null;
        }
        else {
            Node<E> node = getNode(index);
            E result = node.data;
            node.data = newValue;
            return result;
        }
    }

    @Override
    public int size() {
        //this method returns the size of the list
        return this.size;
    }

    //Implement the toString()
    public String toString(){
        String s = "[";
        Node<E> p = head;
        if(p != null){
            while(p.next != null){
                //iterate over the nodes one by one
                s += p.next.data + "-> ";
                p=p.next;//go to the next Node

            }
        }
        //end the ll
        s += "]";
        return s;
    }
}
