import java.util.*;

public class myStringAnalyser { 
    public static void main (String[] args) {
        System.out.println("hello World");
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
            System.out.println(ch + "\n");
            if (chaList.contains(ch)){
                modifiedValue = intList.get(chaList.indexOf(ch)) + 1;
                intList.set(chaList.indexOf(ch),modifiedValue);
                // System.out.println("this is index" + chaList.indexOf(ch));
            } else {
                chaList.add(ch);
                intList.add(1);
            }
        }
       
        // initialization of result array 
         for (int i = 0 ; i < size ; i ++ ) {
             resultInt[i]              = intList.get(i) ;
             resultCha[i]              = chaList.get(i) ;
         }
         for (int j = 0 ; j < size ; j ++ ) {
             if (resultInt[j] < resultInt[minIndex]){
                 minIndex       = j ;
                 minCount       = resultInt[j] ;
             }
         }
         // putting the result in the result array
         for (int i = 0 ; i < chaList.size() ; i ++ ) {
             boolean exist      = false ;
             for ( int k = 0; k < chaList.size() ; k++ ) {
                if (chaList.get(i) == resultCha[k]) {
                    exist               = true ;
                }
             }
             if ( intList.get(i) > minCount && exist == false ) {
                 resultInt[minIndex]    = intList.get(i); 
                 resultCha[minIndex]    = chaList.get(i); 
                 // update the result array
                 for (int j = 0 ; j < size ; j ++ ) {
                     if (resultInt[j] < resultInt[minIndex]){
                         minIndex       = j ;
                         minCount       = resultInt[j] ;
                     }
                 }
             }
         }
         // sorting
         for ( int i = 0 ; i < (size - 1) ; i ++ ) {
             int tmpInt = 0 ;
             char tmpCha = 'c' ;
             for ( int j = 1 ; j < size ; j ++ ) {
                 if ( resultInt[j] > resultInt[i] ) {
                     // exchange
                     tmpInt         = resultInt[j];
                     resultInt[i]   = resultInt[j];
                     resultInt[j]   = tmpInt;
                     tmpCha         = resultCha[j];
                     resultCha[i]   = resultCha[j];
                     resultCha[j]   = tmpCha;
                 }
             }
         }

        System.out.println(Arrays.toString(chaList.toArray()));
        System.out.println(Arrays.toString(intList.toArray()));
        System.out.println("This is results");
        for (int i = 0 ; i < size ; i ++ ) {
            System.out.println(resultCha[i]);
        }
        
    }
}
