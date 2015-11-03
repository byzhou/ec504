public class MyBST extends BST {

	public MyBST (Integer num) {
		super ( num );
	}

	public static class MyRotation extends Rotation {
		public MyRotation ( Integer key, RotationType rot ) {
			super ( key, rot ) ;
		}
	}

    public static void main ( String[] args ) {
        System.out.println ( "test" ) ;
    }
}
