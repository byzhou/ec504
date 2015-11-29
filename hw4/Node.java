/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shortestpath;

import java.util.LinkedList;
import java.util.List;

public class Node implements Comparable {
	int	x;
	int	y;
	List<Edge> 	out_list = new LinkedList<Edge>();	/* edges that start from this node */
	int	dist;		/* distance from the start node */
	Node 	parent;		/* previous node of the shortest path */
	boolean inqueue; 	/* node is in Queue to be scanned */
	String	name;
    // something of my own
    int count ;
    boolean visited ;
	@Override
	public int compareTo(Object other)
        {
            if (dist < ((Node)other).dist)
                return -1;
            if (dist > ((Node) other).dist) 
                return 1;
            return 0;
	}	
}
