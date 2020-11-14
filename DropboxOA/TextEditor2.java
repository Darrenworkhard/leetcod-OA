import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextEditor2{
    // ORDER by timestamp
    // APPEND: append string
    // BACKSPACE: delete character
    // UNDO: undo last action. If action is less than undo, do nothing.
    // REDO: only work after UNDO, and immediately
    // SELECT: Given number is inclusive, end is exclusive, if select section range is larger than current text. Select all.
    //       : If start position is larger than text, ignored.
    //       : If mutiple select, use the recent one.
    //       : SELECT with APPEND, replace the word.
    
    
    public static String edit(String [][] input){
        Arrays.sort(input, (a, b)-> { return a[0].compareTo(b[0]); });
        List<String[]> curr = new ArrayList<String[]>();
        ArrayDeque<String[]> un = new ArrayDeque<String[]>();
        for(int i = 0;i < input.length;i++){
            String ins = input[i][1];
            if(ins.equals("APPEND") || ins.equals("BACKSPACE") || ins.equals("SELECT")){
                curr.add(input[i]);
            }else if (ins.equals("UNDO")){
                if (curr.size() > 0){
                    un.add(curr.remove(curr.size()-1));
                }
            }else if(  ins.equals("REDO")){
                if( i > 0 && input[i-1][1] =="UNDO" && un.size() > 0){
                    curr.add(un.pollLast());
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < curr.size(); i++){
            String[] in = curr.get(i);
            String ins = in[1];
            if(ins.equals("APPEND")){
                if( i > 0 && curr.get(i-1)[1].equals("SELECT")){
                    String[] last = curr.get(i-1);
                    select(sb, last[2], last[3]);
                    sb.insert( Integer.valueOf(last[2]) ,in[2].toCharArray());
                }else{
                    sb.append(in[2].toCharArray());
                }
            }else if(ins.equals("BACKSPACE")){
                if(i > 0 && curr.get(i-1)[1].equals("SELECT")){
                    String[] last = curr.get(i-1);
                    select(sb, last[2], last[3]);
                }else if(sb.length() > 0){
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }    

        return sb.toString();
    }
       
    public static void select(StringBuilder sb, String begin, String end){
        int i = Integer.valueOf(begin);
        int j = Integer.valueOf(end);
        if(i < 0 || i >= sb.length())
            return;
        sb.delete(i, j);
    }
    public static void main(String[] args){

        String[][] p1 = new String[][]{
            { String.valueOf(System.currentTimeMillis()) ,"APPEND", "H"},
            { String.valueOf(System.currentTimeMillis()) ,"APPEND", "ey!!!"},
        };
        String s1 = edit(p1);
        System.out.println(s1);

        String[][] p2 = new String[][]{
            { String.valueOf(System.currentTimeMillis()) ,"APPEND", "Hey you"},
            { String.valueOf(System.currentTimeMillis()) ,"BACKSPACE"},
        };
        String s2 = edit(p2);
        System.out.println(s2);

        String[][] p3 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey you 123"},
            {String.valueOf(System.currentTimeMillis()), "BACKSPACE"},
            {String.valueOf(System.currentTimeMillis()), "BACKSPACE"},
        };
        String s3 = edit(p3);
        System.out.println(s3);

        String[][] p4 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " You"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "!"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"}
        };
        String s4 = edit(p4);
        System.out.println(s4);

        String[][] p5 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"}
        };
        String s5 = edit(p5);
        System.out.println(s5);

        String[][] p6 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " yo yo yo"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"}
        };
        String s6 = edit(p6);
        System.out.println(s6);

        String[][] p7 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"}
        };
        String s7 = edit(p7);
        System.out.println(s7);

        String[][] p8 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " yo yo yo"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"}
        };
        String s8 = edit(p8);
        System.out.println(s8);

        String[][] p9 = new String[][]{
            {String.valueOf(System.currentTimeMillis()+ 1000000) , "APPEND", " Hey"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " you"}
        };
        String s9 = edit(p9);
        System.out.println(s9);

        String[][] p10 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hello"},
            {String.valueOf(System.currentTimeMillis()) , "SELECT", "1", "3"},
            {String.valueOf(System.currentTimeMillis()) , "BACKSPACE"}
        };
        String s10 = edit(p10);
        System.out.println(s10);

        String[][] p11 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hello"},
            {String.valueOf(System.currentTimeMillis()) , "SELECT", "2", "5"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "y tHERE"}
        };
        String s11 = edit(p11);
        System.out.println(s11);

        String[][] p12 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hello 5G! Iphone12"},
            {String.valueOf(System.currentTimeMillis()) , "SELECT", "2", "5"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "BACKSPACE"},
            {String.valueOf(System.currentTimeMillis()) , "BACKSPACE"},
            {String.valueOf(System.currentTimeMillis()) , "BACKSPACE"},
        };
        String s12 = edit(p12);
        System.out.println(s12);
    }
}