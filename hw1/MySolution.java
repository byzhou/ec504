import java.util.Arrays ;
public class MySolution {

    public static void main(String[] args) {
        // System.out.println("hello world") ;

        int A[], B[] ;

        A = new int[10] ;
        B = new int[3] ;

        for ( int i = 0 ; i < 10 ; i ++ ) {
            A[i] = i + 1 ;
        }

        for ( int i = 0 ; i < 3 ; i ++ ) {
            B[i] = i + 5 ;
        }

        System.out.println ( Arrays.toString(A) ) ;
        System.out.println ( Arrays.toString(B) ) ;

        MySolution testSolution = new MySolution () ;
        testSolution.findMedianSortedArrays ( A , B ) ;

    }

    public int findMedianSortedArrays ( int A[], int B[] ) {
        
        // use the long short format 
        int[] shortArray , longArray ;
        if ( A.length < B.length ) {
            shortArray          = A.clone() ;
            longArray           = B.clone() ;
        } else {
            shortArray          = B.clone() ;
            longArray           = A.clone() ;
        }
        
        // median index initialization 
        int medianIndex         = cutHalf ( A.length + B.length ) - 1 ;
        int medianShortIndex    = cutHalf ( shortArray.length ) - 1 ;
        int medianLongIndex     = cutHalf ( longArray.length ) - 1 ;

        // tmp size of current working sub-array
        int shortSubArraySize   = cutHalf ( shortArray.length ) ;
        int longSubArraySize    = cutHalf ( longArray.length ) ;

        // median initialization
        int medianValue         = A[medianShortIndex] ;

        // resolve non-convergence
        int case4LongIndexPrev  = 0 ;
        int case4ShortIndexPrev = 0 ;
        int case5LongIndexPrev  = 0 ;
        int case5ShortIndexPrev = 0 ;
        int case4DistancePrev   = shortArray[shortArray.length - 1] - longArray[0] ;
        int case5DistancePrev   = longArray[longArray.length - 1] - shortArray[0] ;

        while(true) {
            // The first 3 cases are the end case. In these cases, the algorithm stops searching for
            // the median anymore.
            if ( medianShortIndex < 0 ) {
                System.out.println ( "case 1 " ) ;
                medianValue         = longArray[medianIndex] ;
                break ;

            } else if ( medianShortIndex >= shortArray.length ) {
                System.out.println ( "case 2 " ) ;
                medianValue         = longArray[medianIndex - shortArray.length] ;
                break ;

            } else if ( shortArray[medianShortIndex] == longArray[medianLongIndex] ) {
                System.out.println ( "case 3 " ) ;
                medianValue         = shortArray[medianShortIndex] ;
                break ;

            // The rest of the cases, the algorithm implements the binary search for the median.
            } else if ( shortArray[medianShortIndex] > longArray[medianLongIndex] ) {
                System.out.println ( "case 4 " ) ;
                if ( ( case4LongIndexPrev == medianLongIndex )  && ( case4ShortIndexPrev == medianShortIndex ) 
                    && ( case4DistancePrev <= case5DistancePrev ) ) {
                    System.out.println ( "case 4 break condition" ) ;
                    if ( ( medianShortIndex + medianLongIndex + 2 ) == medianIndex ) {
                        // smaller one is median
                        medianValue = longArray[medianLongIndex] ;
                    } else {
                        // bigger one is median
                        medianValue = shortArray[medianShortIndex] ;
                    }
                    break ;
                }
                case4LongIndexPrev  = medianLongIndex ;
                case4ShortIndexPrev = medianShortIndex ;
                case4DistancePrev   = shortArray[medianShortIndex] - longArray[medianLongIndex] ;
                shortSubArraySize   = cutHalf ( shortSubArraySize ) ;
                longSubArraySize    = cutHalf ( longSubArraySize ) ;
                medianLongIndex     = medianLongIndex + shortSubArraySize ;
                medianShortIndex    = medianShortIndex - shortSubArraySize ;
                System.out.printf ( "case4LongIndexPrev %d " , case4LongIndexPrev ) ;
                System.out.printf ( "medianLongIndex %d " , medianLongIndex ) ;
                System.out.printf ( "case4ShortIndexPrev %d " , case4ShortIndexPrev ) ;
                System.out.printf ( "medianShortIndex %d " , medianShortIndex ) ;
                System.out.printf ( "case4DistancePrev %d" , case4DistancePrev ) ;
                System.out.println ( "\n" ) ;

            } else if ( shortArray[medianShortIndex] < longArray[medianLongIndex] ) {
                System.out.println ( "case 5 " ) ;
                if ( ( case5LongIndexPrev == medianLongIndex )  && ( case5ShortIndexPrev == medianShortIndex ) 
                    && ( case5DistancePrev < case4DistancePrev ) ) {
                    System.out.println ( "case 5 break condition" ) ;
                    if ( ( medianShortIndex + medianLongIndex + 2 ) == medianIndex ) {
                        // smaller one is median
                        medianValue = shortArray[medianShortIndex] ;
                    } else {
                        // bigger one is median
                        medianValue = longArray[medianLongIndex] ;
                    }
                    break ;
                }
                case5LongIndexPrev  = medianLongIndex ;
                case5ShortIndexPrev = medianShortIndex ;
                case5DistancePrev   = longArray[medianLongIndex] - shortArray[medianShortIndex] ;
                shortSubArraySize   = cutHalf ( shortSubArraySize ) ;
                longSubArraySize    = cutHalf ( longSubArraySize ) ;
                medianLongIndex     = medianLongIndex - shortSubArraySize ;
                medianShortIndex    = medianShortIndex + shortSubArraySize ;
                System.out.printf ( "case5LongIndexPrev %d " , case5LongIndexPrev ) ;
                System.out.printf ( "medianLongIndex %d " , medianLongIndex ) ;
                System.out.printf ( "case5ShortIndexPrev %d " , case5ShortIndexPrev ) ;
                System.out.printf ( "medianShortIndex %d " , medianShortIndex ) ;
                System.out.printf ( "case5DistancePrev %d" , case5DistancePrev ) ;
                System.out.println ( "\n" ) ;

            } 
        }

        System.out.println ( medianValue ) ;
        
        return 1; 
    }
    
    // If the input value is odd, then return half of the value and plus one.
    // If the input value is even, then return half of the value.
    public static int cutHalf ( int length ) {
        if ( ( length / 2 ) == ( ( double )  length / 2 ) ) {
            return ( length / 2 ) ;
        } else {
            return ( length / 2 + 1 ) ;
        }
    }

}
