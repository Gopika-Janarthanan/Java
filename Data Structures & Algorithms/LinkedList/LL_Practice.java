class LL {
    public static void main(String[] args) {
       
        addn(123);
        add1(24);
        add1(12);
        addn(33456);
        
        disp();
    }
    static Node  head=null ;
    static Node tail =null;
    static void add1(int val){
         Node node =new Node(val);
         if(head==null){
            head=node;
            tail=node;
        }
        else{
            node.next=head;
            head=node;
        }
    }
    static void addn(int val){
        Node node =new Node(val);
        if(head==null){
           add1(val);
        }
        else{
            tail.next=node;
            tail=node;
        }
    }
    static void disp(){
        Node current=head;
        while(current!=null){
            System.out.print(current.val + "-> ");
            current=current.next;
        }
        System.out.print("Null");
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
    }
}
