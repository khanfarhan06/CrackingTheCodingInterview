package ArraysAndStrings;

//QUESTION 1.2: Write code to reverse a C-Style String.
//              (C-String means that “abcd” is represented as five characters, including the null character.)

public class Question1_2 {

    private static char[] toCStyleString(String str){
        char[] cStyle = new char[str.length()+1];
        for(int i=0; i<str.length(); i++)
            cStyle[i] = str.charAt(i);
        cStyle[str.length()] = '\0';
        return  cStyle;
    }

    private static void reverse(char[] cStyle){
        if(cStyle==null) return;
        int end = 0, start=0;
        while (cStyle[end]!='\0')
            end++;
        end--;
        while(start<end){
            char temp = cStyle[start];
            cStyle[start] = cStyle[end];
            cStyle[end] = temp;
            end--;
            start++;
        }
    }

    private static void printCStyleString(char[] cStyle){
        int i =0;
        while(cStyle[i]!='\0')
            System.out.print(cStyle[i++]);
    }

    public static void main(String[] args) {
        String str = "farhan";
        char[] cStyle = toCStyleString(str);
        reverse(cStyle);
        printCStyleString(cStyle);
    }
}
