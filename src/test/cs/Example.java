package test.cs;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Example {

    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("������һ��Ӣ���ַ���������ַ���");

        String password = scan.nextLine();// ��ȡ�û�����

        char[] array = password.toCharArray();// ��ȡ�ַ�����

        for (int i = 0; i < array.length; i++) {// �����ַ�����

            array[i] = (char) (array[i] ^ 200);// ��ÿ������Ԫ�ؽ����������

        }

        System.out.println("���ܻ���ܽ�����£�");

        System.err.println(new String(array));// �����Կ


        List<Integer> list = Arrays.asList(1, 2, 2, 4, 9, 8, 6);

        // ת��ΪTreeSet���ɾ���ظ����ݺ�����

        TreeSet<Integer> set = new TreeSet<Integer>(list);

        System.out.println(set.lower(set.last()));
        System.out.println("test git");
    }

}
