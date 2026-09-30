class MinStack {
    Node head;

    public MinStack() {
    }
    
    public void push(int val) {
        if(this.head == null) this.head = new Node(val, val,null);
        else {
            Node curr = new Node(val, Math.min(this.head.min, val),null);
            curr.next = this.head;
            head = curr;
            
        }
    }
    
    public void pop() {
        this.head = this.head.next;
    }
    
    public int top() {
        return this.head.val;
    }
    
    public int getMin() {
        return this.head.min;
    }
}

class Node {
    int min; 
    Node next;
    int val;

    public Node(int val, int min, Node node){
        this.val = val;
        this.min = min;
        this.next = node;
    }
}
