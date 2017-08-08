package com.butterfly;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) {
        String myText = "Rosemary Fell was not exactly beautiful. She was young, brilliant extremely modern, " +
                "well dressed and amazingly well read in the newest of the new books. " +
                "Rosemary had been married two years, and her husband was very fond of her! They were rich," +
                " really rich, not just comfortably well-off, so if Rosemary wanted to shop, she would go to" +
                " Paris as you and I would go to Bond Street.";
        ArrayList<String> textInWodrs = new ArrayList<String>();
        textInWodrs = breakTextIntoWords(myText);
        for (String e: textInWodrs) System.out.println(e);

        System.out.println("The number of words in the text: "+textInWodrs.size());

        System.out.println("The first unique in this text is: "+uniqueWodr(textInWodrs));

        ArrayList<String> textInSentences = new ArrayList<String>();
        textInSentences = breakTextIntoSentences(myText);
        for (String e: textInSentences) System.out.println(e);
        System.out.println("");
        System.out.println("And now change maxWord and minWord:");
        System.out.println("");

        for (int i = 0; i<textInSentences.size(); i++) {
            System.out.println(swapWords(textInSentences.get(i), maxWord(textInSentences.get(i)), minWord(textInSentences.get(i))));
        }

    }
    public static ArrayList<String> breakTextIntoSentences(String s) {
        ArrayList<String> myText = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[.!?]");
        String[] text = pattern.split(s);
        for (int i=0; i<text.length; i++) myText.add(text[i].trim());
        return myText;

    }

    public static ArrayList<String> breakTextIntoWords(String s) {
        ArrayList<String> myText = new ArrayList<String>();
        Pattern pattern = Pattern.compile("[,:;.!?\\s]+");
        String[] text = pattern.split(s);
        for (int i=0; i<text.length; i++) myText.add(text[i].trim());
        return myText;
    }

    public static String uniqueWodr(ArrayList<String> myText) {
        String result = "There are no unique words in this text";
        for (int i=0; i<myText.size(); i++) {
            if (myText.indexOf(myText.get(i)) ==  myText.lastIndexOf(myText.get(i))) {
                result = myText.get(i);
                break;
            }
        }
        return result;
    }
    public static String maxWord (String s) {
        ArrayList<String> hhh = new ArrayList<String>();
        hhh = breakTextIntoWords(s);
        String k = hhh.get(0);
        for (int i = 1; i<hhh.size(); i++) {
            if (hhh.get(i).length()>k.length()) k = hhh.get(i);
        }
        return k;
    }

    public static String minWord (String s) {
        ArrayList<String> hhh = new ArrayList<String>();
        hhh = breakTextIntoWords(s);
        String k = hhh.get(0);
        for (int i = 1; i<hhh.size(); i++) {
            if (hhh.get(i).length()<k.length()) k = hhh.get(i);
        }
        return k;
    }
    public static String swapWords(String s, String Word1, String Word2) {
        ArrayList<String> myText = new ArrayList<String>();
        myText = breakTextIntoWords(s);
        int k = myText.indexOf(Word1);
        myText.set(myText.indexOf(Word2), Word1);
        myText.set(k, Word2);
        String ss= "";
        for (String e: myText) ss=ss+e+" ";
        ss.trim();
        return ss;
    }
}
