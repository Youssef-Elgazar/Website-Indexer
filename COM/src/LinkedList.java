

public class LinkedList implements LinkedListInterface{

    public class node {

        String data ;
        node next ;

        public node (String data){
            this.data = data;
        }
    }

    node head;
    node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void insert(String value) {
        node newNode = new node(value);

        if(head == null) {
            head = newNode;
            tail = newNode;
        }
        else {
            tail.next = newNode;
            tail=newNode;
        }
    }

    public void display() {
        System.out.print(head.data + " // IP addresses => ");
        node current = head.next;
        while(current != null) {
            System.out.print(current.data + " , ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public boolean search (String value ){
        node current = head ;
        boolean x = false ;

        while( current != null ){
            if (current.data.equals(value)){
                x = true ;
                break ;
            }
            current = current.next;
        }
        return x ;
    }

}



