import java.util.*;

//https://docs.google.com/document/d/1--zldFgpA-1okMH7gT3SzkbyER7u5wHmy73MaDuHDyg/edit
public class TextEditor {
    public static void main(String[] args) {
        String[][] p1 = new String[][]{
            { String.valueOf(System.currentTimeMillis()) ,"APPEND", "H"},
            { String.valueOf(System.currentTimeMillis()) ,"APPEND", "ey!!!"},
        };
        String s1 = Editor(p1);
        System.out.println(s1);
        
        String[][] p2 = new String[][]{
            { String.valueOf(System.currentTimeMillis()) ,"APPEND", "Hey you"},
            { String.valueOf(System.currentTimeMillis()) ,"BACKSPACE"},
        };
        String s2 = Editor(p2);
        System.out.println(s2);

        String[][] p3 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey you 123"},
            {String.valueOf(System.currentTimeMillis()), "BACKSPACE"},
            {String.valueOf(System.currentTimeMillis()), "BACKSPACE"},
        };
        String s3 = Editor(p3);
        System.out.println(s3);

        String[][] p4 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " You"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "!"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"}
        };
        String s4 = Editor(p4);
        System.out.println(s4);

        String[][] p5 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"}
        };
        String s5 = Editor(p5);
        System.out.println(s5);

        String[][] p6 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " yo yo yo"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"}
        };
        String s6 = Editor(p6);
        System.out.println(s6);

        String[][] p7 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"}
        };
        String s7 = Editor(p7);
        System.out.println(s7);

        String[][] p8 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hey"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " yo yo yo"},
            {String.valueOf(System.currentTimeMillis()) , "REDO"}
        };
        String s8 = Editor(p8);
        System.out.println(s8);

        String[][] p9 = new String[][]{
            {String.valueOf(System.currentTimeMillis()+ 1000000) , "APPEND", " Hey"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", " you"}
        };
        String s9 = Editor(p9);
        System.out.println(s9);

        String[][] p10 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hello"},
            {String.valueOf(System.currentTimeMillis()) , "SELECT", "1", "3"},
            {String.valueOf(System.currentTimeMillis()) , "BACKSPACE"}
        };
        String s10 = Editor(p10);
        System.out.println(s10);

        String[][] p11 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hello"},
            {String.valueOf(System.currentTimeMillis()) , "SELECT", "2", "5"},
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "y there"}
        };
        String s11 = Editor(p11);
        System.out.println(s11);

        String[][] p12 = new String[][]{
            {String.valueOf(System.currentTimeMillis()) , "APPEND", "Hello 5G! Iphone12"},
            {String.valueOf(System.currentTimeMillis()) , "SELECT", "2", "5"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
            {String.valueOf(System.currentTimeMillis()) , "BACKSPACE"},
            {String.valueOf(System.currentTimeMillis()) , "BACKSPACE"},
            {String.valueOf(System.currentTimeMillis()) , "UNDO"},
        };
        String s12 = Editor(p12);
        System.out.println(s12);

    }
    public static String Editor(String[][] input)
    {
        if(input.length == 0) return "";
        
        Arrays.sort(input, (x,y) -> { return x[0].compareTo(y[0]); });
        List<String[]> lists = new ArrayList<>();
        for(int i = 0; i < input.length; i++)
        {
           if(input[i][1].equals("UNDO"))
           {    
               if(lists.size() > 0 && (i == input.length-1 || !input[i+1][1].equals("REDO")))
               {
                    String[] s = lists.get(lists.size()-1);
                    while(lists.size() > 0 && !s[1].equals("APPEND") && !s[1].equals("BACKSPACE"))
                    {
                        lists.remove(lists.size()-1);
                        s = lists.get(lists.size()-1);
                    }
                    if(lists.size() > 0)
                        lists.remove(lists.size()-1);
               }
           }
           else if(!input[i][1].equals("REDO"))
           {
                lists.add(input[i]);
           }
        }
        StringBuilder sB = new StringBuilder();
        int[] select = new int[2];
        boolean isSelect = false;
        for(String[] s : lists)
        {
            if(s[1].equals("APPEND"))
            {
                if(isSelect)
                {
                    DeleteSelect(sB, select);
                    if(sB.length() > select[0])
                    {
                        sB.insert(select[0],s[2]);
                    }
                    else
                    {
                        sB.append(s[2]);
                    }
                    isSelect = false;
                }
                else if(!s[2].equals(""))
                {
                    sB.append(s[2]);
                }
            }
            else if(sB.length() > 0)
            {
                if(s[1].equals("SELECT")){
                    select[0] = Integer.valueOf(s[2]);
                    select[1] = Integer.valueOf(s[3]);
                    isSelect = true;
                }
                else if(s[1].equals("BACKSPACE"))
                {
                    if(isSelect)
                    {
                        DeleteSelect(sB, select);
                    }
                    else
                        sB.delete(sB.length() - 1,sB.length());
                    isSelect = false;
                }
            }           
        }

        return sB.toString();

    }

    public static void DeleteSelect(StringBuilder sB, int[] select)
    {
        int len = select[1] - select[0];
        if(len < sB.length())
        {
            sB.delete(select[0] ,select[1]);
        }
        else
            sB = new StringBuilder();
    }

    String[][] TestCase(int index)
    {
        if(index == 0)
            return new String[][]{{"0","APPEND","Hey"},{"1","APPEND"," there"},{"2","APPEND","!"}};

        return new String[0][];
            
    }




}


