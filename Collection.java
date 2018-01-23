package Collection;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("aaaa");
        list.add(new Date());
        list.add(new Dog());
        System.out.println(list);
        String a = (String) list.get(0);
        System.out.println(a);
    }

}

class Dog{

}
