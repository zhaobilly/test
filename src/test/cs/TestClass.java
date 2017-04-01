package test.cs;


public class TestClass {

    public static void main(final String[] args) {

        String res = shortestName("gfdgfgszgagfassss", "ggsfgsgfs", "fafafafafa");
        System.out.println(res);
    }

    public static int mystery(final int a, final int b) {

        int c;
        if (a > b) {
            c = a;
        } else if (b % a == 0) {
            c = b;
        } else {
            c = b + (a - (b % a));
        }
        return c;
    }


    public static String shortestName(final String name1, final String name2, final String name3) {

        String result = null;
        if (name1.length() > name2.length()) {
            result = name2;
        } else {
            result = name1;
        }

        if (result.length() > name3.length()) {
            result = name3;
        }


        return result;
    }
}

