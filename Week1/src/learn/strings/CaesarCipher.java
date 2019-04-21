/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learn.strings;

/**
 *
 * @author ashok
 */
public class CaesarCipher {

    public String encrypt(String input, int key) {
        StringBuilder output = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // find a shiftedAlphabet to use as replacement of original alphabet chars.
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        for (int i = 0; i < input.length(); i++) {
            char ch = Character.toUpperCase(input.charAt(i)); // get the char ch and convert to upperCase
            boolean flag = false;
            if (ch != input.charAt(i)) {
                flag = true; // checking if original char was lower case. if yes, set flag.
            }
            int indexOfChar = alphabet.indexOf(ch); // find its original index in alphabet
            if (indexOfChar < 0) {
                output.append(ch); // if its not alphabet character, append as is.
            } 
            else { // otherwise
                if (flag) { // if original char was lower case, append char from shifted alphabet after making it lowercase.
                    output.append(Character.toLowerCase(shiftedAlphabet.charAt(indexOfChar)));
                } 
                else { // else append as is from shifted alphabet
                    output.append(shiftedAlphabet.charAt(indexOfChar)); // add corresponding char from shifted alphabet to output
                }
            }
        }
        return output.toString();
    }

    private void testEncrypt() {
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
        System.out.println(encrypt("First Legion", 23));
        System.out.println(encrypt("First Legion", 17));
    }
    
    public String encryptTwoKeys(String input, int key1, int key2){
        StringBuilder output = new StringBuilder();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // find a shiftedAlphabet to use as replacement of original alphabet chars.
        String shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        String shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        for (int i = 0; i < input.length(); i++) {
            char ch = Character.toUpperCase(input.charAt(i)); // get the char ch and convert to upperCase
            boolean flag = false;
            if (ch != input.charAt(i)) {
                flag = true; // checking if original char was lower case. if yes, set flag.
            }
            int indexOfChar = alphabet.indexOf(ch); // find its original index in alphabet
            if (indexOfChar < 0) {
                output.append(ch); // if its not alphabet character, append as is.
            } 
            else { // otherwise
                if(i%2 == 0){ // at every odd indexed char, (index 0 is considered odd) use key1
                    if (flag) { // if original char was lower case, append char from shifted alphabet after making it lowercase.
                        output.append(Character.toLowerCase(shiftedAlphabet1.charAt(indexOfChar)));
                    } 
                    else { // else append as is from shifted alphabet
                        output.append(shiftedAlphabet1.charAt(indexOfChar)); // add corresponding char from shifted alphabet to output
                    }
                }
                else { // at every even indexed char use key2.
                    if (flag) { // if original char was lower case, append char from shifted alphabet after making it lowercase.
                        output.append(Character.toLowerCase(shiftedAlphabet2.charAt(indexOfChar)));
                    } 
                    else { // else append as is from shifted alphabet
                        output.append(shiftedAlphabet2.charAt(indexOfChar)); // add corresponding char from shifted alphabet to output
                    }
                }
            }
        }
        return output.toString();
    }
    
    private void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
        System.out.println(encryptTwoKeys("First Legion", 23, 17));
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher();
        cipher.testEncrypt();
        cipher.testEncryptTwoKeys();
    }

}
