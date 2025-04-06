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
        int shift = c - s.charAt(0); // this can be negative or positive
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch >= 'A' && ch <= 'Z') {
                //int base = 'A';
                //int rotated = (ch - base + shift + 26) % 26 + base;
                arr[i] = (char) ('A' + (ch - 'A' + shift) % arr.length);;
            }
        }

        String result = new String(arr);
        System.out.println(result);
        return result;
    }

}
