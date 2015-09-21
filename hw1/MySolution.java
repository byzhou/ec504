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
            B[i] = i + 1 ;
        }

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
        int medianIndex         = ( A.length + B.length + 1 ) / 2 ;
        int medianShortIndex    = shortArray.length / 2 ;
        int medianLongIndex     = longArray.length / 2 ;

        // tmp size of current working sub-array
        int shortSubArraySize   = shortArray.length / 2 ;
        int longSubArraySize    = longArray.length / 2 ;

        // median initialization
        int medianValue         = A[medianShortIndex] ;

        while(true) {
            if ( shortArray[medianShortIndex] == longArray[medianLongIndex] ) {
                medianValue         = shortArray[medianShortIndex] ;
                break ;
            } else if ( medianShortIndex == 0 ) {
                medianValue         = longArray[medianIndex] ;
                break ;
            } else if ( medianShortIndex == ( shortArray.length - 1 ) ) {
                medianValue         = longArray[medianIndex - shortArray.length] ;
                break ;
            } else if ( shortArray[medianShortIndex] > longArray[medianLongIndex] ) {
                shortSubArraySize   = shortSubArraySize / 2 ;
                longSubArraySize    = longSubArraySize / 2 ;
                medianLongIndex     = medianLongIndex + shortSubArraySize ;
                medianShortIndex    = medianShortIndex - shortSubArraySize ;
            } else if ( shortArray[medianShortIndex] < longArray[medianLongIndex] ) {
                shortSubArraySize   = shortSubArraySize / 2 ;
                longSubArraySize    = longSubArraySize / 2 ;
                medianLongIndex     = medianLongIndex - shortSubArraySize ;
                medianShortIndex    = medianShortIndex + shortSubArraySize ;
            } // no converging condition
        }

        System.out.println ( medianIndex ) ;
        
        return 1; 
    }
}
