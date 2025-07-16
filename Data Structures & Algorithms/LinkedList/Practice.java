
class Practice {
    static Node head=null;static Node tail=null;
    public static void main(String[] args) {
       add(2);
       add(4);
       add(12);
       add(8);
       display();
       reverse();
       System.out.println();
       System.out.print("Reverse");
       System.out.println();
       display();
    }
    static void add(int val){
        Node node=new Node(val);
        if(head==null){
            head=node;
            tail=node;
        }
        else{
            node.next=head;
            head=node;
        }
    }
    static void display(){
        Node cur=head;
        while(cur!=null){
            System.out.print(cur.val+"->");
            cur=cur.next;
        }
        System.out.print("null");
    }
    static void reverse(){
        Node pre,cur,nex;
        pre=null;
        cur=head;
        Node temp=head;
        head=tail;
        tail=temp;
        while(cur!=null){
            nex=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nex;
        }
    }
}
class Node{
    int val;
    Node next;
    Node(int val){
        this.val=val;
        this.next=null;
    }
}
