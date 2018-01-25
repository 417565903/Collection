package Collection;

import com.sun.org.apache.xpath.internal.SourceTree;
import sun.applet.Main;

public class MyArrayList {

    private Object[] elementData;

    private int size;

    public MyArrayList(){
        this(10);
    }

    public MyArrayList(int initialGapacity){
        if(initialGapacity <0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialGapacity];
    }
    public void add(Object obj){
        //扩容
        if(size>=elementData.length){
            Object[] newArr = new Object[size*2+1];
            System.arraycopy(elementData,0,newArr,0,elementData.length);
            elementData = newArr;
        }
        elementData[size++] = obj;
    }
    public void add(int index,Object obj){
        rangeCheck(index);
        if(size>=elementData.length){
            Object[] newArr = new Object[size*2+1];
            System.arraycopy(elementData,0,newArr,0,elementData.length);
            elementData = newArr;
        }
        System.arraycopy(elementData,index,elementData,index+1,size-index-1);
        elementData[index] = obj;
    }
    private void rangeCheck(int index){
        if (index<0||index>=size){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void remove(int index){
        rangeCheck(index);
        System.arraycopy(elementData,index+1,elementData,index,size-index-1);
        elementData[--size] = null;
    }
    public void remove(Object obj){
        for(int i=0;i<size;i++){
            if(elementData[i].equals(obj)){
                remove(i);
            }
        }
    }
    public Object get(int index){
        rangeCheck(index);
        return elementData[index];
    }
    public boolean isEmty(){
        return  size == 0;
    }
    public void set(int index,Object obj){
        rangeCheck(index);
        elementData[index] = obj;
    }
    //test ArrayList
    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(10);
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
//        list.remove("1");
//        list.set(1,new String("替换2"));
        list.add(1,new String("增加1"));
        System.out.println(list.get(1));
    }
}