package dsp;

public class CLL {

    class Node {

        Node next, prev;
        int data;
        int pir;

        public Node(int data, int pri) {

            this.data = data;
            this.pir = pri;//cc
        }
    }
    Node Head, Tail;
    private int lenCLL;

    public int getLenCLL() {
        return lenCLL;
    }

    Node Create_node(int data, int pir) {
        Node node = new Node(data, pir);
        if (node != null) {
            lenCLL++;
        }
        return node;
    }

    public boolean push_fbCll(int data, int pir) {
        Node node = Create_node(data, pir);
        if (node != null) {
            if (Head == null) {
                Head = Tail = node;
                Head.next = Head;
            } else if (pir < Head.pir) { //|| (Head.pir == pir && Head.data > data)) {//pir 2s8er mn head 7y isert 2blo cc
                node.next = Head;
                node.prev = Tail;
                Head.prev = node;
                Head = node;
                Tail.next = Head;
            } else if (pir > Tail.pir || (pir == Tail.pir)) {
                node.prev = Tail;
                node.next = Head;
                Tail.next = node;
                Tail = node;
                Head.prev = Tail;
            } else {
                Node temp = Head;
                do {
                    if (pir > temp.pir && pir < temp.next.pir || pir == temp.pir && temp.next.pir > pir) { // cc

                        temp = temp.next;
                        break;
                    }
                    temp = temp.next;
                } while (temp != Head);

                if (temp == Head) {
                    node.prev = Tail;
                    node.next = Head;
                    Tail.next = node;
                    Tail = node;
                    Head.prev = Tail;
                } else {

                    node.next = temp;
                    node.prev = temp.prev;
                    temp.prev.next = node;
                    temp.prev = node;
                }

            }
            return true;
        }
        return false;
    }

    Node popCLL() {// cc
        Node temp = Tail;
        if (Head != null) {
            if (Head == Tail) {
                Tail.next = Tail.prev = Head.next = Head.prev = Head = Tail = null;

            } else {
                Tail = Tail.prev;
                Tail.next = Head;
                Head.prev = Tail;//cc

            }
            lenCLL--;
        }
        return temp;
    }

    public int Dpopc() {
        return popCLL().data;
    }

    public boolean Queue_pushinto_Cll(Queue Q) {
        Queue.NodeQ temp = Q.dequeue();
        return push_fbCll(temp.data, temp.pir);

    }

    
}
