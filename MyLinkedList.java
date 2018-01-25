package Collection;

//import com.sun.org.apache.xpath.internal.operations.String;

import java.time.temporal.Temporal;

public class MyLinkedList {
    private Node first;
    private Node last;

    private int size;

    public void add(Object obj){
        Node n = new Node();
        if(first == null){
            n.setPre(null);
            n.setObj(obj);
            n.setNext(null);
            first = n;
            last = n;   //建立第一个节点时.第一个也就是最后一个
        }else{
            n.setPre(last);
            n.setObj(obj);
            n.setNext(null);

            last.setNext(n);
            last = n;
        }
        size++;
    }
    public void add(Object obj,int index){
        Node n = new Node();
        Node temp = node(index);
        if(first == null||index>size-1){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            if(temp.pre == null){
                n.pre = null;
                n.obj = obj;
                n.next = temp;
                temp.pre = n;
                first = n;
            }else if(temp.next == null){
                n.pre = temp;
                n.obj = obj;
                n.next = null;
                temp.next = n;
                last = n;
            }else {
                Node up = temp.pre;

                n.pre = up;
                n.obj = obj;
                n.next = temp;
                temp.pre = n;
                up.next = n;
            }
        }
        size++;
    }

    public int size() {
        return size;
    }
    public void remove(int index){
        Node temp = node(index);
        if(temp!=null){
            if(temp == first){
                Node down = temp.next;
                down.pre = null;
                first = down;
            }else if(temp == last){
                Node up = temp.pre;
                up.next = null;
                last = up;
            }else {
                Node up = temp.pre;
                Node down = temp.next;
                up.next = down;
                down.pre = up;
            }
        }
        size--;
    }

    public Node node(int index) {
        Node temp = null;
        if(first!=null){
            temp = first;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
        }
        return temp;
    }

    public Object get(int index){
        Node temp = node(index);
        return temp.obj;
    }
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.add(("aaaa"));
        list.add(("bbbb"));
        list.add(("cccc"));
        list.add(("dddd"));
        list.add(("eeee"));
        list.add(("ffff"));

        //System.out.println(list.get(3));
        //list.remove(5);
        list.add(("11111"),5);
        list.add(("11111"),6);
        Node temps = list.first;
        for(int i=0;i<list.size();i++){
            System.out.println(temps.obj);
            temps = temps.next;
        }
        System.out.println("get-----"+list.get(5));
    }
}
