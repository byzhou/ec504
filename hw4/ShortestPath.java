//package shortestpath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class ShortestPath
{
    static int n, m; // num nodes, num edges
    static boolean isdigraph;
    static List<Node> nodeList = new ArrayList<Node>();

    static Node findNode(String name)
    {
        for (Node node : nodeList)
        {
            if (node.name.equals(name))
            {
                return node;
            }
        }
        return null;
    }

    static void input_graph(InputStream is) throws IOException
    {
        int x, y, l;
        String s;

        Reader r = new BufferedReader(new InputStreamReader(is));
        StreamTokenizer st = new StreamTokenizer(r);
        st.commentChar('#');
        st.nextToken();
        n = (int) st.nval;  // n nodes
        st.nextToken();
        m = (int) st.nval;  // m edges
        st.nextToken();
        s = st.sval;
        isdigraph = "digraph".equals(s);
        for (int i = 0; i < n; i++)
        {
            Node node = new Node();
            st.nextToken();
            node.name = st.sval;
            st.nextToken();
            node.x = (int) st.nval;
            st.nextToken();
            node.y = (int) st.nval;
            nodeList.add(i, node);
        }

        for (int i = 0; i < m; i++)
        {
            Edge edge = new Edge();
            st.nextToken();
            edge.name = st.sval;
            switch (st.nextToken())
            {
                case StreamTokenizer.TT_NUMBER:
                    //edge.start = (Node) nodeList.get((int) st.nval);
                    edge.start = nodeList.get((int) st.nval);
                    break;
                case StreamTokenizer.TT_WORD:
                    edge.start = findNode(st.sval);
                    break;
                default:
                    break;
            }
            switch (st.nextToken())
            {
                case StreamTokenizer.TT_NUMBER:
                    //edge.end = (Node) nodeList.get((int) st.nval);
                    edge.end = nodeList.get((int) st.nval);
                    break;
                case StreamTokenizer.TT_WORD:
                    edge.end = findNode(st.sval);
                    break;
                default:
                    break;
            }
            st.nextToken();
            edge.len = (int) st.nval;
            edge.start.out_list.add(edge);
            if (!isdigraph)
            {
                Edge edge2 = new Edge();
                edge2.name = edge.name + "_back";
                edge2.start = edge.end;
                edge2.end = edge.start;
                edge2.len = edge.len;
                edge2.start.out_list.add(edge2);
            }
        }
    }

    public static void main(String args[])
    {
        String filename = "g1.txt";
        Node nod;

        try
        {
            InputStream is = new FileInputStream(filename);
            input_graph(is);

        }
        catch (FileNotFoundException e)
        {
            System.err.println("File not found.");
        }
        catch (IOException e)
        {
            System.err.println("Cannot access file.");
        }

        Algorithm algo = new Algorithm(nodeList.get(0), nodeList);
        algo.modifiedDijkstra();

        System.out.println("number of nodes " + nodeList.size());
        for (Node node : nodeList)
        {
            System.out.println("Distance to node " + node.name + " is " + node.dist + " and there are "  
                /* your code here*/ + " shortest paths");
        }

        int endnode = nodeList.size() / 2 + 1;
        //nod = (Node) nodeList.get(endnode);
        nod = nodeList.get(endnode);
        while (nod != null)
        {
            if (nod.parent == null)
            {
                System.out.println("node " + nod.name + " has distance " + nod.dist
                        + " and is the root ");
            }
            else
            {
                System.out.println("node " + nod.name + " has distance " + nod.dist
                        + " and parent " + nod.parent.name);
            }
            nod = nod.parent;
        }
    }
}
