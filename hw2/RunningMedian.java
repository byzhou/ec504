// a) 1076
// b) 1027.5992341648289
// c) 5000379.5


import java.util.*;


public class RunningMedian {

    private ArrayList<Double> leftList ;
    private ArrayList<Double> rightList ;

    double      median                   ;
    int         leftListLargestIndex     ;
    int         rightListLargestIndex    ;   

    public RunningMedian ( ) {

        leftList                = new ArrayList<Double> ()  ;
        rightList               = new ArrayList<Double> ()  ;

        median                  = -999999 ;
        leftListLargestIndex    = 0 ;
        rightListLargestIndex   = 0 ;   

    }

    public double RunningMedian ( double input ) {

        // if the entire database only has one element
        if ( leftList.size () == 0 && rightList.size() == 0 && median == -999999 ) {
            median = input ;
            return median ;
        } 

        // if the entire database has two elements 
        if ( leftList.size () == 0 && rightList.size() == 0 ) {
            if ( input < median ) {
                leftList.add ( input ) ;
                leftListLargestIndex = 0 ;
            } else {
                rightList.add ( input ) ;
                rightListLargestIndex = 0 ;
            }
            return ( input + median ) / 2 ;
        } 
        
        double pushedValue = 0 ;
        // if the entire database has three or more
        if ( leftList.size() < rightList.size() ) {
            pushedValue     = median > input ? input : median ;
            median          = median > input ? median : input ;
            leftList.add ( pushedValue ) ;
            if ( pushedValue > leftList.get ( leftListLargestIndex ) ) {
                leftListLargestIndex = leftList.size() - 1 ;
            }
            //System.out.println ( "case 1" ) ;
            //System.out.println ( "leftList" ) ;
            //System.out.println ( leftList ) ;
            //System.out.println ( "rightList" ) ;
            //System.out.println ( rightList ) ;
            return median ;
        } else if ( leftList.size() > rightList.size() ) {
            pushedValue     = median < input ? input : median ;
            median          = median < input ? median : input ;
            rightList.add ( pushedValue ) ;
            if ( pushedValue < rightList.get ( rightListLargestIndex ) ) {
                rightListLargestIndex = rightList.size() - 1 ;
            }
            //System.out.println ( "case 2" ) ;
            //System.out.println ( "leftList" ) ;
            //System.out.println ( leftList ) ;
            //System.out.println ( "rightList" ) ;
            //System.out.println ( rightList ) ;
            return median ;
        } else {
            if ( input < median ) {
                pushedValue     = median > input ? input : median ;
                median          = median > input ? median : input ;
                leftList.add ( pushedValue ) ;
                if ( pushedValue > leftList.get ( leftListLargestIndex ) ) {
                    leftListLargestIndex = leftList.size() - 1 ;
                }
            //System.out.println ( "case 3" ) ;
            //System.out.println ( "leftList" ) ;
            //System.out.println ( leftList ) ;
            //System.out.println ( "rightList" ) ;
            //System.out.println ( rightList ) ;
                return ( median + leftList.get ( leftListLargestIndex ) ) / 2 ;
            } else {
                pushedValue     = median < input ? input : median ;
                median          = median < input ? median : input ;
                rightList.add ( pushedValue ) ;
                if ( pushedValue < rightList.get ( rightListLargestIndex ) ) {
                    rightListLargestIndex = rightList.size() - 1 ;
                }
            //System.out.println ( "case 4" ) ;
            //System.out.println ( "leftList" ) ;
            //System.out.println ( leftList ) ;
            //System.out.println ( "rightList" ) ;
            //System.out.println ( rightList ) ;
                return ( median + rightList.get ( rightListLargestIndex ) ) / 2 ;
            }

        }
        
    }
}
