package dsp;

import java.util.*;

public class DSP {

    public static void main(String[] args) {


//        Scanner A = new Scanner(System.in);
//        CLL C = new CLL();
//        Queue Q1 = new Queue();
//        Queue Q2 = new Queue();
//        Queue Q3 = new Queue();
//        Stack S = new Stack();
//        Random R = new Random();
//        int g = 1;
//
//        Queue.NodeQ temp = Q1.dequeue();
//        S.pushS(temp.data, temp.pir);
//        S.printS();
        //for loop besor3a for+tab,♣♥♦♣♠•◘○☻☺ dol alt w mn 1 l 9
        Scanner A = new Scanner(System.in);
        CLL C = new CLL();
        Queue Q1 = new Queue();
        Queue Q2 = new Queue();
        Queue Q3 = new Queue();
        Stack S = new Stack();
        Random R = new Random();
//        int num = A.nextInt();
        int num;
        int generator = 1;
        int printed = 0;
        while (printed < 100) {
            num = R.nextInt(4) + 1;
            switch (num) {

                //insert from generator number in the queue "Q1"
                case 1:

                    if (generator <= 100) {
                        Q1.enqueue((generator++), R.nextInt(5) + 1);

                    }

                    break;

                //it consist of stack queue &CLL will insert in the smallest one in size 
                //if the are equal insert random 
                case 2:
                    if (Q1.getLenQ() > 0) {
                        if (S.getLenS() < Q2.getLenQ() && S.getLenS() < C.getLenCLL()) {
                            Queue.NodeQ temp = Q1.dequeue();
                            S.pushS(temp.data, temp.pir);
                        } else if (Q2.getLenQ() < S.getLenS() && Q2.getLenQ() < C.getLenCLL()) {
                            Queue.NodeQ temp = Q1.dequeue();
                            Q2.enqueue(temp.data, temp.pir);

                        } else if (C.getLenCLL() < Q2.getLenQ() && C.getLenCLL() < S.getLenS()) {
                            Queue.NodeQ temp = Q1.dequeue();
                            C.push_fbCll(temp.data, temp.pir);
                        } else if (C.getLenCLL() == S.getLenS() && C.getLenCLL() == Q2.getLenQ()) {
                            Queue.NodeQ temp = Q1.dequeue();
                            int F = R.nextInt(3) + 1;
                            switch (F) {
                                case 1:
                                    S.pushS(temp.data, temp.pir);
                                    break;
                                case 2:
                                    Q2.enqueue(temp.data, temp.pir);
                                    break;
                                case 3:
                                    C.push_fbCll(temp.data, temp.pir);
                                    break;
                            }

                        } else if ((Q2.getLenQ() == C.getLenCLL()) && C.getLenCLL() < S.getLenS()) {
                            Queue.NodeQ temp = Q1.dequeue();
                            int F = R.nextInt(2) + 1;
                            switch (F) {
                                case 1:
                                    Q2.enqueue(temp.data, temp.pir);
                                    break;
                                case 2:
                                    C.push_fbCll(temp.data, temp.pir);
                                    break;
                            }
                        } else if ((S.getLenS() == C.getLenCLL()) && C.getLenCLL() < Q2.getLenQ()) {
                            Queue.NodeQ temp = Q1.dequeue();
                            int F = R.nextInt(2) + 1;
                            switch (F) {
                                case 1:
                                    S.pushS(temp.data, temp.pir);
                                    break;
                                case 2:
                                    C.push_fbCll(temp.data, temp.pir);
                                    break;
                            }

                        } else { //if((S.getLenS() == Q2.getLenQ()) && C.getLenCLL() > Q2.getLenQ()) {
                            Queue.NodeQ temp = Q1.dequeue();
                            int F = R.nextInt(2) + 1;
                            switch (F) {
                                case 1:
                                    S.pushS(temp.data, temp.pir);
                                    break;
                                case 2:
                                    Q2.enqueue(temp.data, temp.pir);
                                    break;
                            }
                        }
                    }

                    break;
                //whats poped from case2 will be pushed in Q3 according to greater in size from case 2 if they are equal pop random 
                case 3:
                    if (S.getLenS() > 0 || Q2.getLenQ() > 0 || C.getLenCLL() > 0) {
                        if (S.getLenS() > Q2.getLenQ() && S.getLenS() > C.getLenCLL()) {
//                            Stack.NodeS temp = S.popS();
//                            Q3.enqueue(temp.data, temp.pir);
                            Q3.Stack_Pushinto_Queue(S);
                        } else if (Q2.getLenQ() > S.getLenS() && Q2.getLenQ() > C.getLenCLL()) {
                            Queue.NodeQ temp = Q2.dequeue();
                            Q3.enqueue(temp.data, temp.pir);

                        } else if (C.getLenCLL() > S.getLenS() && C.getLenCLL() > Q2.getLenQ()) {
//                        
                            Q3.CLL_pushinto_Queue(C);
                        } else if (C.getLenCLL() == S.getLenS() && C.getLenCLL() == Q2.getLenQ() && C.getLenCLL() > 0) {// cc

                            int F = R.nextInt(3) + 1;
                            switch (F) {
                                case 1:
                                    Queue.NodeQ temp = Q2.dequeue();
                                    Q3.enqueue(temp.data, temp.pir);
                                    break;
                                case 2:
                                    Stack.NodeS temp1 = S.popS();
                                    Q3.enqueue(temp1.data, temp1.pir);
                                    break;
                                case 3:
//                                   
                                    Q3.CLL_pushinto_Queue(C);
                                    break;
                            }
                        } else if ((S.getLenS() == Q2.getLenQ()) && S.getLenS() > C.getLenCLL()) {
                            int F = R.nextInt(2) + 1;
                            switch (F) {
                                case 1:
                                    Stack.NodeS temp = S.popS();
                                    Q3.enqueue(temp.data, temp.pir);
                                    break;
                                case 2:
                                    Queue.NodeQ temp1 = Q2.dequeue();
                                    Q3.enqueue(temp1.data, temp1.pir);
                                    break;
                            }
                        } else if ((S.getLenS() == C.getLenCLL()) && S.getLenS() > Q2.getLenQ()) {
                            int F = R.nextInt(2) + 1;
                            switch (F) {
                                case 1:
                                    Stack.NodeS temp = S.popS();
                                    Q3.enqueue(temp.data, temp.pir);
                                    break;
                                case 2:
                                    CLL.Node temp1 = C.popCLL();
                                    Q3.enqueue(temp1.data, temp1.pir);
                                    break;
                            }
                        } else if ((Q2.getLenQ() == C.getLenCLL()) && C.getLenCLL() > S.getLenS()) {//if((Q2.getLenQ() == C.getLenCLL()) && C.getLenCLL() > S.getLenS()){
                            int F = R.nextInt(2) + 1;
                            switch (F) {
                                case 1:
                                    Q3.CLL_pushinto_Queue(C);
                                    break;
                                case 2:
                                    Queue.NodeQ temp = Q2.dequeue();
                                    Q3.enqueue(temp.data, temp.pir);
                                    break;
                            }
                        }
                    }

                    break;
                //print Q3 data 
                case 4:
                    if (Q3.getLenQ() != 0) {
                        Queue.NodeQ temp = Q3.dequeue();
                        System.out.println("printed " + printed + "  number  " + temp.data);
                        printed += 1;
                    }


                    break;
            }
        }
    }
}
