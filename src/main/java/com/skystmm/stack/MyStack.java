package com.skystmm.stack;

/**
 * 225. Implement Stack using Queues
 * AC time:101 ms beats:33.75 % use linklist
 * Created by Administrator on 2018/1/8.
 */

public class MyStack {

    private Node head ;
    private Integer length;

    /** Initialize your data structure here. */
    public MyStack() {
        head = new Node();
        length = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Node now = new Node(x);
        Node next = head.getNext();
        head.setNext(now);
        now.setNext(next);
        length +=1;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(empty()){
            return 0;
        }else{
            Node cur = head.getNext();
            head.setNext(head.getNext().getNext());
            length -=1;
            return cur.getValue();
        }
    }

    /** Get the top element. */
    public int top() {
        if(empty()){
            return 0;
        }else{
            return head.getNext().getValue();
        }
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return head.getNext() == null;
    }

    class Node{
        private Integer value;
        private Node next;

        public Node(){
            this.next = null;
            this.value = 0;
        }
        public Node(Integer value){
            this.next = null;
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
    /**
     * best solution
    Queue<Integer> queue;
    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        int size = queue.size();
        queue.offer(x);
        while (size-- > 0) {
            queue.offer(queue.poll());
        }

    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
     */
}
