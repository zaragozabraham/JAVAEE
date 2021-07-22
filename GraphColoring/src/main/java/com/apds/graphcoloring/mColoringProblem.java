package com.apds.graphcoloring;

public class mColoringProblem 
{
    final int V = 4;
    int color[];
 
    boolean isSafe(
        int v, int graph[][], int color[],
        int c)
    {
        for (int i = 0; i < V; i++)
            if (
                graph[v][i] == 1 && c == color[i])
                return false;
        return true;
    }
 
    boolean graphColoringUtil(
        int graph[][], int m,
        int color[], int v)
    {
        if (v == V)
            return true;
        for (int c = 1; c <= m; c++) 
        {
            if (isSafe(v, graph, color, c))
            {
                color[v] = c;
 
                if (
                    graphColoringUtil(
                        graph, m,
                        color, v + 1))
                    return true;
 
                color[v] = 0;
            }
        }
 
        return false;
    }
    
    boolean graphColoring(int graph[][], int m)
    {
        color = new int[V];
        for (int i = 0; i < V; i++)
            color[i] = 0;
 
        // Call graphColoringUtil() for vertex 0
        if (
            !graphColoringUtil(
                graph, m, color, 0)) 
        {
            System.out.println(
                "Solution does not exist");
            return false;
        }
 
        // Print the solution
        printSolution(color);
        return true;
    }
 
    void printSolution(int color[])
    {
        System.out.println(
            "Solution Exists: Following"
            + " are the assigned colors");
        for (int i = 0; i < V; i++)
            System.out.print(" " + color[i] + " ");
        System.out.println();
    }
 
    // driver program to test above function
    public static void main(String args[])
    {
        mColoringProblem Coloring 
               = new mColoringProblem();
        int graph[][] = {
            { 0, 1, 1, 1 },
            { 1, 0, 1, 0 },
            { 1, 1, 0, 1 },
            { 1, 0, 1, 0 },
        };
        int m = 3; // Number of colors
        Coloring.graphColoring(graph, m);
    }
}