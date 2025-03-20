package effectivejava.chapter2.item1;

import java.sql.Date;
import java.util.EnumSet;
import java.util.Set;

public class Item1 implements Runnable {

    private ThreadLocal<String> name = new ThreadLocal<>();

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public void run() {
        StringBuilder str = new StringBuilder();
        str.append("1");

        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        str.append("2");
        System.out.println(this.getName() + str);
    }

    public static void main(String... argc) {

//        boolean primBool = Boolean.valueOf(true);
//
//        Date f = Date.from(instant);
//
//        Set<String> strings = EnumSet.of("1", "2", "3");
        Item1 item = new Item1();

        int i = 0;
        while (i < 10) {
            Thread t1 = new Thread(item);
            item.setName("Thread " + i);
            t1.start();
            i++;
        }

    }


}
