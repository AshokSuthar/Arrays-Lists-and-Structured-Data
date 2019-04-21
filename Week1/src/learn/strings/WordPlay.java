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
public class WordPlay {

    public boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        if ("aeiou".indexOf(ch) < 0) {
            return false;
        }
        return true;
    }

    private void testIsVowel() {
        System.out.println(isVowel('F') + " " + isVowel('A'));
    }

    public String replaceVowels(String phrase, char ch) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            if (isVowel(phrase.charAt(i))) { // if this char is a vowel
                str.append(ch); // replace it with ch. i.e. append ch.
            } else {
                str.append(phrase.charAt(i)); // else append original char itself
            }
        }
        return str.toString();
    }

    private void testReplaceVowels() {
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < phrase.length(); i++) {
            // if charAt(i) == given char ch
            if (Character.toLowerCase(phrase.charAt(i)) == Character.toLowerCase(ch)) {
                if(i%2 == 0){ // check if its at odd position, index 0 is odd position
                    str.append('*'); // if at odd position, replace with *
                }
                else{
                    str.append('+'); // else replace with +
                }
            } else {
                str.append(phrase.charAt(i)); // if charAt(i) is not given char ch, append as it is.
            }
        }
        return str.toString();
    }
    
    private void testEmphasize() {
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
    
    public static void main(String[] args) {
        WordPlay wp = new WordPlay();
        //wp.testIsVowel();
        //wp.testReplaceVowels();
        wp.testEmphasize();
    }

}
