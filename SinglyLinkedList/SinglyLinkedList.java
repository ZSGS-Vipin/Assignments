package linkedlist;

public class SinglyLinkedList {

    private Node head;
    private Node tail;
    private int size;
    public SinglyLinkedList(){
        this.size = 0;
    }
    public static void main(String[] args) {
        SinglyLinkedList l = new SinglyLinkedList();
//        l.insertFirst(1);
//        l.insertFirst(2);
//        l.printFun();
//        l.insertLast(90);
//        l.insertLast(78);
//        l.printFun();
//        l.printReverse();
        l.insertFirst(1);
        l.insertFirst(2);
        l.insertFirst(3);
        l.insertFirst(4);
        l.insertFirst(5);
        //binaryMethod();
    }
    public void insertFirst(int value){
        Node node = new Node(value);
        node.next = head;
        head = node;
        if(tail==null)
            tail = head;
        size=size+1;
    }
    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail =node;
        size++;
    }
    public void printReverse(){
        Node last = head;
        while(last.next!=null){
            if(last.next==null){
                System.out.println(last.value);
            }
        }
    }
    public void insert(int value, int index){
        if(index==0) {
            insertFirst(value);
            return;
        }
        if(index == size) {
            insertLast(value);
            return;
        }
        Node temp = head;
        for(int i = 0; i < size;i++){
            temp = temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;

    }
    public int deleteFirst(){
        int value = head.value;
        head = head.next;
        if(head==null)
            tail=null;
        size--;
        return value;
    }

    public int deleteLast(){
        if(size<=1)
            return deleteFirst();
        Node secondLast = get(size-2);
        int value = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return value;
    }
    public Node get(int index){
        Node node = head;
        for(int i = 0; i < index;i++){
            node= node.next;
        }
        return node;
    }
    public void printFun(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.value+" ->");
            temp = temp.next;
        }
    }
    class Node{
        int value;
        Node next;
        public Node(int value){
            this.value = value;
        }
        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
    public static  Node reverseList(Node head) {
        if(head==null||head.next==null)
            return head;
        Node p1 = head;
        Node p2 = p1.next;
        while(p1!=null&&p2!=null){
            Node t = p2.next;
            p2.next=p1;
            p1=p2;
            p2=t;
        }
        return p1;
    }
    public static void binaryMethod(){
        int a = 2;
        while(a>0){
            a = a<<1;
            System.out.println(Integer.toBinaryString(a) + " " + a);
        }
    }

}
