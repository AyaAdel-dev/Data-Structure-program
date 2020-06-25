package dsp;

public class Stack {

    class NodeS {

        NodeS prev;
        int data;
        int pir;

        public NodeS(int data, int pir) {
            this.data = data;
            this.pir = pir;
        }
    }
    NodeS Top;
    private int lenS;

    public int getLenS() {
        return lenS;
    }

    NodeS Create_NodeS(int data, int pir) {
        NodeS node = new NodeS(data, pir);
        if (node != null) {
            lenS++;
        }
        return node;
    }

    public boolean pushS(int data, int pir) {
        NodeS node = Create_NodeS(data, pir);
        if (node != null) {
            if (Top == null) {
                Top = node;
            } else {
                node.prev = Top;
                Top = node;
            }

            return true;
        }
        return false;
    }

    NodeS popS() {
        NodeS temp = Top;
        if (Top != null) {
            Top = Top.prev;
            lenS--;// cc
        }
        return temp;
    }

    public int DpopS() {
        return popS().data;
    }

    public boolean Queue_pushinto_Stack(Queue Q) {
        Queue.NodeQ temp = Q.dequeue();
        return pushS(temp.data, temp.pir);
    }

    
}
