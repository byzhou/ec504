import java.util.Hashtable;

public class myStringAnalyser { 
    public static void main (String[] args) {
        System.out.println("hello World");
        stringAnalyse(args[0],Integer.parseInt(args[1]));
    }

    public static void stringAnalyse (String str, int size) {
        System.out.println("hello stringAnalyse");
        Hashtable<String,int> hashtableobj = new Hashtable<String,int>();
        for (String c: str){
            hashtableobj.put(c,1);
        }
    }
}
