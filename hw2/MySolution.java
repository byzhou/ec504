import java.util.*;

public class MySolution { 
    public static void main (String[] args) {
        RunningMedian test = new RunningMedian () ;
        for ( int ii = 0 ; ii < 100000000 ; ii ++ ) {
            test.RunningMedian (ii ^ (2*ii) ) ;
        }
        
    }
}
