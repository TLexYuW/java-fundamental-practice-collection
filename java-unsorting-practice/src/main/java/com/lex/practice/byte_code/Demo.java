package com.lex.practice.byte_code;

/**
 * @author : Lex Yu
 */
public class Demo {
    public static void main(String[] args) {
        // Binary representation of "Hello World!"
        String binary = """
                01001000 01100101 01101100 01101100 01101111 00100000 01010111 01101111 01110010 01101100 01100100 00100001""";

        binary = binary.replace(" ", "");

        byte[] bytes = new byte[binary.length() / 8];
        for (int i = 0; i < binary.length(); i += 8) {
            String byteString = binary.substring(i, i + 8);
            bytes[i / 8] = (byte) Integer.parseInt(byteString, 2);
        }

        String str = new String(bytes);

        System.out.println(str);
    }
}
