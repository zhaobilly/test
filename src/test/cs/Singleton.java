package test.cs;

import java.util.ArrayList;
import java.util.List;

public class Singleton {

    private static Singleton instance;

    private Singleton() {

        System.out.println("----Singleton---˽�й���Called---------");

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


        // ��ͨ�������� ��ȡMethod����

        // Method method = c.getDeclaredMethod("Singleton",

        // new Class[] {});

        // method.setAccessible(true); // ����Java�ķ��ʿ��Ƽ��

        // // ���������������䣬����Error: TestPrivate can not access a member of class
        // PrivateClass with modifiers "private"

        // method.invoke(c, new Object[] {});


        String sa = "tea";
        // ǿ�ƴ���һ���¶���
        String snew = new String("tea");
        System.out.println("-----------------------");
        List list = new ArrayList<String>();
        list.add("tea");
        System.out.println("tea" == list.get(0));
        System.out.println("tea".equals(list.get(0)));
        System.out.println(sa == list.get(0));
        System.out.println("ǿ�ƴ�������" + (snew == list.get(0)));
        System.out.println("�ȱȽϵ�ַ���ٱȽ����ݣ�" + snew.equals(list.get(0)));


        String s = new String("a");
        String s2 = "a";
        System.out.println(s2 == "a");
    }

}
