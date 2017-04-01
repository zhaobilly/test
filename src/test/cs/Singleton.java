package test.cs;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private static Singleton instance;

    private Singleton() {

        System.out.println("----Singleton---私有构造Called---------");

    }

    public static Singleton getInstance() {

        if (Singleton.instance == null) {

            Singleton.instance = new Singleton();

        }

        return Singleton.instance;

    }


    public static void main(final String[] args) throws Exception {

        // Singleton ss = Singleton.getInstance();
        // Singleton ss2 = Singleton.getInstance();
        //
        // System.out.println(ss);
        // System.out.println(ss2);

        // Class c = Class.forName("test.cs.Singleton");
        //
        // Constructor constructor = c.getDeclaredConstructor(null);
        //
        // constructor.setAccessible(true);
        //
        // Singleton ss1 = (Singleton) constructor.newInstance(null);
        //
        // System.out.println(ss1);
        //
        // ss1 = (Singleton) constructor.newInstance(null);
        //
        // System.out.println(ss1);


        // 普通方法调用 获取Method对象

        // Method method = c.getDeclaredMethod("Singleton",

        // new Class[] {});

        // method.setAccessible(true); // 抑制Java的访问控制检查

        // // 如果不加上上面这句，将会Error: TestPrivate can not access a member of class
        // PrivateClass with modifiers "private"

        // method.invoke(c, new Object[] {});


        String sa = "tea";
        // 强制创建一个新对象
        String snew = new String("tea");
        System.out.println("-----------------------");
        List list = new ArrayList<String>();
        list.add("tea");
        System.out.println("tea" == list.get(0));
        System.out.println("tea".equals(list.get(0)));
        System.out.println(sa == list.get(0));
        System.out.println("强制创建对象：" + (snew == list.get(0)));
        System.out.println("先比较地址，再比较内容：" + snew.equals(list.get(0)));


        String s = new String("a");
        String s2 = "a";
        System.out.println(s2 == "a");
    }

}
