import java.io.*;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("sonnet18.txt"));

        ROT13 rot13 = new ROT13();
        rot13.readFileAndProcess(reader);
        BufferedReader reader2 = new BufferedReader(new FileReader("sonnet18.enc"));
        System.out.println(rot13.compareFiles(reader, reader2));
    }

    ROT13(Character cs, Character cf) {
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
       char[] newArr = text.toLowerCase().toCharArray();
        for (int i = 0; i< text.length(); i++){
            if (newArr[i] >='a' && newArr[i] <='z') {
                newArr[i] = (char) ('a' + (newArr[i] - 'a' + 13) % 26);
            }
        }
        String str = new String(newArr);
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        System.out.println(crypt(text));
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int shift = c - s.charAt(0); // this can be negative or positive
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i];
            if (ch >= 'A' && ch <= 'Z') {
                arr[i] = (char) ('A' + (ch - 'A' + shift) % arr.length);;
            }
        }

        String result = new String(arr);
        System.out.println(result);
        return result;
    }

    public void readFileAndProcess(BufferedReader reader) throws IOException {
//        BufferedReader reader = new BufferedReader(new FileReader("sonnet18.txt"));
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("sonnet18.enc"))){
            String line;
            while ((line = reader.readLine()) != null){
                String newLine = encrypt(line);
                writer.write(newLine);
                writer.newLine();
                System.out.println(newLine);
        }
        }
    }

    public boolean compareFiles(BufferedReader reader, BufferedReader reader2){
        try {
            String line1, line2;
            while ((line1 = reader.readLine()) != null & (line2 = reader2.readLine()) != null) {
                if (!line1.equals(line2)) return false;
            }
            return reader.readLine() == null && reader2.readLine() == null;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

}
