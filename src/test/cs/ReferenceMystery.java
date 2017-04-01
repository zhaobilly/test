package test.cs;


public class ReferenceMystery {

    public static void main(final String[] args) {

        int a = 10;
        int b = 12;
        PointInfo p1 = new PointInfo();
        PointInfo p2 = new PointInfo(a, b);
        addToYTwice(a, p1);
        System.out.println(a + " " + b + " " + p1.y + " " + p2.y);
        addToYTwice(b, p2);
        System.out.println(a + " " + b + " " + p1.y + " " + p2.y);
    }

    public static void addToYTwice(int a, final PointInfo p1) {

        a = a + a;
        p1.y = a;
        System.out.println(a + " " + p1.y);
    }
}
