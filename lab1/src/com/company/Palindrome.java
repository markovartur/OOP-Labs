package com.company;
//import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String s = scan.nextLine(); // args[i];
        s = s.replaceAll("[^A-Za-z0-9\\s]", "");  //("\\p{Punct}", "");  //("(,)", "");
        //s = s.replaceAll("\\p{Punct}", "");  //("(,)", "");
        String[] sp = s.split("\\s+|, \\s*");
        System.out.println(Arrays.toString(sp));

        String s2 = reverseString(s);//s.replaceAll("\\s+","");
        //s2 = s2.replaceAll("[^A-Za-z0-9\\s]", "");
        String[] sp2 = s2.split("\\s+|, \\s*");
        System.out.println(Arrays.toString(sp2));

        isPalindrome(sp, sp2);
        //s, ss,, ,,, ,s,
    }

    public static String reverseString(String sp) {
        //sp = sp;  //.replaceAll("\\s+", "");
        String str = "";
        for (int i = sp.length(); i > 0; i--){
            str += sp.charAt(i-1);
        }
        return str;
    }

    public static boolean isPalindrome(String[] sp, String[] sp2){
        int j = sp2.length;//Array.getLength(sp2);

        for (int i=0; i < sp2.length; i++) {
            j--;
            String a = sp[i];
            String b = sp2[j];

            if(a.equals(b)) { System.out.println(a + " является палиндромом");}
            else{ System.out.println(a + " НЕ является палиндромом"); }

        }
        return true;
    }

//    public static void /*boolean*/ ffff(String[] sp, String[] sp2) {
//        //sp = reverseString(sp); //ArrayUtil.reverse(sp);//reverseString(sp);
//        //sp = sp;
//        //sp2 = sp2;
//        //String c = sp[i];//Arrays.toString(sp);
//        //System.out.println(Array.getLength(sp));
//        //System.out.println(Array.getLength(sp2));
//        int j = Array.getLength(sp2)-1;
//        for (int i = 0; i < Array.getLength(sp2); i++) {
//            j--;
//            //for (int j = Array.getLength(sp2); j > 0; j--) {
//            String a = sp[i];//Arrays.toString(sp[i]); //sp[i];
//            String b = sp2[j];//Arrays.toString(sp2[j]); //sp2[j];
//            //System.out.println(Array.getLength(sp));
//            //System.out.println(Array.getLength(sp2));
//            if (a.equals(b)) {//(sp.equals(sp2)) {  //(s.equalsIgnoreCase(s2)){    /*(2<3)*/
//                System.out.println("i"+i);
//                System.out.println(j);
//                System.out.println(sp[i] + " является палиндромом");
//                //return true;
//
//            }
//            //System.out.println("i"+i);
//        }
//
//        //return false;
//    }
}