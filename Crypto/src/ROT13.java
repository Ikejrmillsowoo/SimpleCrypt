import java.util.Arrays;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    ROT13(Character cs, Character cf) {
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
       char[] newArr = text.toLowerCase().toCharArray();
        for (int i = 0; i< text.length(); i++){
            if (newArr[i] >122 || newArr[i] <97) {
                newArr[i] = newArr[i];
            }
            else if ((newArr[i]-13)>=97){
                newArr[i] = (char) (newArr[i] -13);
            } else if ((newArr[i]-13)<97){
                newArr[i] = (char) (123-(97-(newArr[i]-13)));
            }
        }
        String str = String.valueOf(newArr);
        str = String.valueOf(str.charAt(0)).toUpperCase() +str.substring(1);

        return str;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
//        String newStr = s.toLowerCase();
        int numToRotateBy = c - s.charAt(0);
        char[] arr = s.toCharArray();

        for (int i = 0; i< arr.length; i++){
            if (arr[i] >'Z' || arr[i] <'A') {
                arr[i] = arr[i];
            }
            else if ((arr[i]+numToRotateBy)>='A'){
                arr[i] = (char) (arr[i] +numToRotateBy);
            } else if ((arr[i]+numToRotateBy)<'Z'){
                arr[i] = (char) ('Z'-('A'-(arr[i]+numToRotateBy)));
            }
        }

        String str = String.valueOf(arr);
       // str = String.valueOf(str.charAt(0)).toUpperCase() +str.substring(1);
        System.out.println(str);
        return str;
    }

}
