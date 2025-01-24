package LinkedList;

public class LL {
    public static void main(String[] args) {
        SLL n1= new SLL();
        n1.insertfirst(12);
        n1.insertfirst(10);
        n1.insertfirst(8);
        n1.insertfirst(7);
        n1.insertfirst(5);
        n1.disp();

    }
}
class SLL{
    Node head ;
    Node tail;

    void insertfirst(int val){
        Node node = new Node(val);
        node.next=head;
        head =node;
        if(tail==null){
            tail=head;
        }

    }
    void disp(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.print("null");
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
    Node(int val, Node next){
        this.val=val;
        this.next=next;
    }
}
