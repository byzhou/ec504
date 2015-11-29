/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package shortestpath;

import java.util.List;

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
        // Initialization of the graph. Distance from all the nodes to the source is infinity. And
        // the distance from the source to the source is 0.
        for ( Node currNode : nodeList ) {
            if ( currNode == source )
                currNode.dist   = 0 ;
            else
                currNode.dist   = 999999;
        }

        for ( Node currNode : nodeList ) {

            for ( Edge edgeToCurrNode : currNode.out_list ) {
                // update the current distance. This distance has not been relaxed.
                if ( edgeToCurrNode.end.dist > ( currNode.dist + edgeToCurrNode.len ) )
                    edgeToCurrNode.end.dist     = currNode.dist + edgeToCurrNode.len ;
                //System.out.println ( edgeToCurrNode.name ) ;
            }

        }
    }

}
