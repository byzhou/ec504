//Boyou Zhou

import java.io.BufferedReader ;
import java.io.FileReader ;
import java.io.IOException ;
import java.util.ArrayList;
import java.io.File ;
import java.io.FileInputStream ;

public class MyBST extends BST {

	public static ArrayList<BST.Rotation> rotationRecord = new ArrayList<BST.Rotation>();

	public MyBST (Integer num) {
		super ( num );
	}

	public MyBST ( Integer[] nums ) {
		super ( nums ) ;
	}

	public static class MyRotation extends Rotation {
		public MyRotation ( Integer key, RotationType rot ) {
			super ( key, rot ) ;
		}
	}

	public static Integer[] inputData ( String fileName ) {
		try {
			File file = new File(fileName);
			byte[] bytes = new byte[(int) file.length()];
			FileInputStream fis = new FileInputStream(file);
			fis.read(bytes);
			fis.close();
			String[] valueStr = new String(bytes).trim().split("\\s+");
			Integer[] outputData = new Integer[valueStr.length];
			for (int i = 0; i < valueStr.length; i++) 
					outputData[i] = Integer.parseInt(valueStr[i]);
			return outputData ;
		} catch ( IOException e) {
			System.out.println ( "file cannot be read." ) ; 	
			return null ;
		}
	}

	public static void preOrderPrint (BST root) {
		
		if ( root == null ) return ;
		
		System.out.println ( root.key ) ;
		System.out.printf ( "L " ) ;
		preOrderPrint ( root.left ) ;
		System.out.printf ( "R " ) ;
		preOrderPrint ( root.right ) ;	
	}

	public static BST rotateRight ( BST y ) {

		rotationRecord.add ( new BST.Rotation ( y.key, BST.Rotation.RotationType.ZIG ) ) ;
		if ( y == null ) 
			return null ;
		if ( y.left == null && y.right == null ) 
			return y;
		if ( y.left == null )
			return y;
		BST tmp = y.left ;
		y.left = tmp.right ;
		tmp.right = y ;
		y = tmp ;
		return y;

	}

	public static BST rotateLeft ( BST x ) {

		rotationRecord.add ( new BST.Rotation ( x.key, BST.Rotation.RotationType.ZAG ) ) ;

		if ( x == null ) 
			return null ;
		if ( x.left == null && x.right == null ) 
			return x;
		if ( x.right == null )
			return x; 
		BST tmp = x.right ;
			//System.out.println ( "print tmp" ) ;
			//preOrderPrint ( tmp ) ;
		x.right = tmp.left == null ? null : tmp.left ;
			//System.out.println ( "print x.right" ) ;
			//preOrderPrint ( x.right ) ;
		tmp.left = x ;
			//System.out.println ( "print tmp.left" ) ;
			//preOrderPrint ( tmp.left ) ;
		return tmp;

	}

	public static boolean equal ( BST T1, BST T2 ) {
		if ( T1 == null && T2 == null ) 
			return true ;
		if ( T1 == null || T2 == null ) 
			return false ;
		return T1.key == T2.key && equal ( T1.left, T2.left ) 
				&& equal ( T1.right, T2.right ) ;

	}

	public static BST getKeyTop ( BST T1, Integer key ) {

		//System.out.println ( "Get Key top." ); 
		//preOrderPrint ( T1 ) ;

		if ( T1.left == null && T1.right == null ) {
			//System.out.println ( "Point to dead end." ); 
			return T1 ;
		} else if ( T1.left != null && T1.left.key == key ) {
			//System.out.println ( "Key FOUND!" ); 
			return rotateRight ( T1 ) ;
		} else if ( T1.right != null && T1.right.key == key ) {
			//System.out.println ( "Key FOUND!" ); 
			return rotateLeft ( T1 ) ;
		} else if ( key > T1.key ) {
			//System.out.println ( "Key on the right!" ); 
			T1.right = getKeyTop ( T1.right, key ) ;
			T1 = rotateLeft ( T1 ) ;
		} else if ( key < T1.key ) {
			//System.out.println ( "Key on the left!" ); 
			T1.left = getKeyTop ( T1.left, key ) ;
			T1 = rotateRight ( T1 ) ;
		}

		//System.out.println ( "Could not find the key." ); 
		return T1 ; // key == T1.key
	}
	
	public static BST debugTrans ( BST T1, BST T2 ) {

		if ( equal ( T1, T2 ) ) {
			//System.out.println ( "Trans finished!" ) ;
			return T1;
		}
		
		T1 = getKeyTop ( T1, T2.key ) ;
		//System.out.println ( "Updated version" ) ;
		//preOrderPrint ( T1 ) ;	
		
		if ( T1.left != null ) {
			//System.out.println ( "Go left" ) ;
			T1.left = debugTrans ( T1.left, T2.left ) ;
		} 
		if ( T1.right != null ) {
			//System.out.println ( "Go right" ) ;
			T1.right = debugTrans ( T1.right, T2.right ) ;
		}
		//System.out.println ( "Key reached top! root is " + T1.key ) ;
		//preOrderPrint ( T1 ) ;
		return T1 ;

	}

    public static ArrayList<Rotation> transform(BST first, BST second) {
		first = debugTrans ( first, second ) ;
		return rotationRecord ;
	}
	

    public static void main ( String[] args ) {
		BST BSTT1 = new BST ( inputData ( "T1.txt" ) ) ;
		BST BSTT2 = new BST ( inputData ( "T2.txt" ) ) ;
		
		System.out.println ( "T1 BST init status." ); 
		preOrderPrint ( BSTT1 ) ;
		System.out.println ( "T2 BST init status." ); 
		preOrderPrint ( BSTT2 ) ;
		BSTT1 = debugTrans ( BSTT1, BSTT2 ) ;

		System.out.println ( "over " +rotationRecord.size() ) ;
		
		for ( int i = 0 ; i < rotationRecord.size() ; i++ )  
			System.out.println ( rotationRecord.get(i).print() ) ;

		//BSTT1 = rotateLeft ( BSTT1 ) ;
		//BSTT1 = getKeyTop ( BSTT1, 5 ) ;

		System.out.println ( "T1 BST rotation status. root is " + BSTT1.key ); 
		preOrderPrint ( BSTT1 ) ;
		System.out.println ( "T2 BST rotation status. root is " + BSTT2.key ); 
		preOrderPrint ( BSTT2 ) ;
    }

}
