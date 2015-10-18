import java.util.*;
import java.lang.Math;

public class MySolution { 
    public static void main (String[] args) {
        RunningMedian test = new RunningMedian () ;
        for ( int ii = 0 ; ii <= 10000759 ; ii ++ ) {
            System.out.println ( test.RunningMedian ( ii ) ) ;
        }
        
    }
}
