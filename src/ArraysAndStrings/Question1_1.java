package ArraysAndStrings;

//Implement an algorithm to determine if a string has all unique characters.
//What if you can not use additional data structures?

import java.util.HashSet;

public class Question1_1 {

    private static boolean hasUniqueCharacters(String str) {
        HashSet<Character> found = new HashSet<>();
        for(char c: str.toCharArray()){
            if(found.contains(c))
                return  false;
            found.add(c);
        }
        return true;
    }

    private  static  boolean hasUniqueCharactersWithoutExtraSpace(String str){
        int checker = 0;
        for(char c: str.toCharArray()){
            int index = c - 'a';
            if((checker & (1<<index))!=0)
                return false;
            checker = checker | (1<<index);
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "abcda";

        System.out.println("Has unique characters: "+hasUniqueCharacters(str));
    }
}
