import java.util.*;

public class myStringAnalyser { 
    public static void main (String[] args) {
        // System.out.println("hello World");
        stringAnalyse(args[0],Integer.parseInt(args[1]));
    }

    public static void stringAnalyse (String str, int size) {
        // store all the data here
        List<Character> chaList     = new ArrayList<Character>();
        List<Integer> intList       = new ArrayList<Integer>();
        int modifiedValue           = 0 ;
        // find the largest results here
        char[] resultCha            = new char[size];
        int[] resultInt             = new int[size];
        int minIndex                = 0 ;
        int minCount                = 0 ;

        // read each character in the string
        for (char ch: str.toCharArray() ){
            //System.out.println(ch + "\n");
            if (chaList.contains(ch)){
                modifiedValue = intList.get(chaList.indexOf(ch)) + 1;
                intList.set(chaList.indexOf(ch),modifiedValue);
                // System.out.println("this is index" + chaList.indexOf(ch));
            } else {
                chaList.add(ch);
                intList.add(1);
            }
        }
        
        for ( int i = 0 ; i < size ; i ++ ) {
            if ( size < chaList.size() ) {
                int largestValueIndex       = 0 ;
                for ( int j = 0 ; j < intList.size() ; j ++ ) {
                    if ( intList.get(j) > intList.get(largestValueIndex) ) {
                        largestValueIndex = j ;
                    }
                }
                System.out.println ( chaList.get(largestValueIndex) ) ;    
                chaList.remove(largestValueIndex);
                intList.remove(largestValueIndex);

            }
        }

        // System.out.println(Arrays.toString(chaList.toArray()));
        // System.out.println(Arrays.toString(intList.toArray()));
        
    }
}
