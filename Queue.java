package dsp;

public class Queue {

    class NodeQ {

        NodeQ next, prev;
        int data, pir;

        public NodeQ(int data, int pir) {
            this.data = data;
            this.pir = pir;
        }

    }
    NodeQ Front, Back;
    private int lenQ;

    public int getLenQ() {
        return lenQ;
    }

    public NodeQ Create_nodeq(int data, int pir) {
        NodeQ node = new NodeQ(data, pir);
        if (node != null) {
            lenQ++;
        }
        return node;
    }

    public boolean enqueue(int data, int pir) {
        NodeQ node = Create_nodeq(data, pir);
        if (node != null) {
            if (Back != null) {//law queue mosh fady
                node.prev = Back;
                Back.next = node;
                Back = node;

            } else {
                Back = node;
                Front = node;
            }
//            lenQ++; we already ++ it cc
            return true;

        }
        return false;
    }

    public NodeQ dequeue() {
        NodeQ temp = Front;
        if (Front != null) { // cc
            if (lenQ > 1) {
                Front = Front.next;
                Front.prev = null;
                temp.next = null;
            } else {
                Front = Back = null;
            }
            lenQ--;
        }
        return temp;
    }

    public int DpopQ() {
        return dequeue().data;
    }

    public boolean Stack_Pushinto_Queue(Stack s) {
        Stack.NodeS temp = s.popS();
        return enqueue(temp.data, temp.pir);

    }

    public boolean CLL_pushinto_Queue(CLL C) {
        CLL.Node temp = C.popCLL();
        return enqueue(temp.data, temp.pir);
    }

    
}
