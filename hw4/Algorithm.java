/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package shortestpath;

import java.util.List;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Algorithm
{

    Node source;
    List<Node> nodeList;

    Algorithm(Node source, List<Node> v)
    {
        this.source = source;
        this.nodeList = v;
    }

    void modifiedDijkstra()
    {
        // This is where you write your version of Dijkstra's modified algorithm
        // new priorityqueue
        PriorityQueue<Node> unscannedNodes = new PriorityQueue<Node>(nodeList.size(), 
                                               new Comparator<Node>() {
            public int compare ( Node node1, Node node2 ) {
                return node1.compareTo ( node2 ) ;
            }
                                               });
        // Initialization of the graph. Distance from all the nodes to the source is infinity. And
        // the distance from the source to the source is 0.
        for ( Node currNode : nodeList ) {
            currNode.parent = null ;
            if ( currNode == source )
                currNode.dist   = 0 ;
            else
                currNode.dist   = 999999;
            unscannedNodes.offer ( currNode ) ;
        }

        while ( true ) {
            Node currNode = unscannedNodes.poll() ;
            if ( currNode == null ) 
                break ;

            for ( Edge edgeToCurrNode : currNode.out_list ) {
                // update the current distance. This distance has not been relaxed.
                if ( edgeToCurrNode.end.dist > ( currNode.dist + edgeToCurrNode.len ) ) {
                    edgeToCurrNode.end.dist     = currNode.dist + edgeToCurrNode.len ;
                    edgeToCurrNode.end.parent   = currNode ;
                }
                //System.out.println ( edgeToCurrNode.name ) ;
            }

        }
    }

}
