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

        int medianIndex     = ( A.length + B.length + 1 ) / 2 ;
        int medianAIndex    = A.length / 2 ;
        int medianBIndex    = B.length / 2 ;

        // median initialization
        int medianValue     = A[medianAIndex] ;

        while(true) {
            if ( A[medianAIndex] == B[medianBIndex] ) {
                medianValue     = A[medianAIndex] ;
                break ;
            } else if ( A[medianAIndex] > B[medianBIndex] ) {
                // in the loop 
                medianBIndex    = medianBIndex +  ;
                medianAIndex    = medianAIndex / 2 ;
            } else if ( A[medianAIndex] < B[medianBIndex] ) {
                // in the loop
                medianAIndex    = ( medianAIndex + A.length ) / 2 ;
                medianBIndex    = medianBIndex / 2 ;
            }
        }

        System.out.println ( medianIndex ) ;
        
        return 1; 
    }
}
