class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Node [data=" + data + ", next=" + next + "]";
    }
    
}
public class linkedlist {
    public static void main(String[] args) {
        Node head = new Node(20);
        Node node = new Node(23);
        Node n2 = new Node(45);
        head.next = node;
        head.next.next = n2;

        Node mynode = head;
        while (mynode.next != null) {
            System.out.println(mynode.data);
            mynode = mynode.next;
        }
    }
}