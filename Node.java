package Collection;

public class Node {
    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    Node pre;
         Object obj;
         Node next;

        public Node(){}
        public Node(Node pre,Object obj,Node next){
            this.pre = pre;
            this.obj = obj;
            this.next = next;
        }
}
