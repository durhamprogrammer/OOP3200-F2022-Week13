package ca.durhamcollege.oop3200f2022week13a.core;

import java.util.ArrayList;

public abstract class Shape extends ArrayList<Vector2>
{
    // private instance members
    //protected ArrayList<Vector2> vertices;
    private ArrayList<Line> edges;

    // public properties
    public void setVertices(Vector2[] vertices)
    {
        build(vertices);
    }

    public void setVertex(Vector2 vertex)
    {
        Vector2[] vertices = {vertex};
        build(vertices);
    }

    // constructor(s)
    public Shape()
    {
        super();
        initialize();
    }

    public Shape(Vector2[] vertices)
    {
        super();
        initialize();
        setVertices(vertices);
    }

    // private methods
    private void initialize()
    {
        //vertices = new ArrayList<Vector2>(); // creates an empty container
        edges = new ArrayList<Line>(); // creates an empty container
    }


    private void build(Vector2[] vertices)
    {
        this.clear();
        this.edges.clear();

        // add all vertices to the shape
        for (int i = 0; i < vertices.length; i++)
        {
            this.add(vertices[i]);
        }

        // build edges
        for (int i = 0; i < this.size(); i++)
        {
            if(i < this.size() - 1)
            {
                this.edges.add(new Line(this.get(i), this.get(i + 1)));
            }
            else
            {
                this.edges.add(new Line(this.get(i), this.get(0)));
            }
        }
    }


    // public methods
    @Override
    public String toString()
    {
        String outputString = "";
        outputString += "-------------------------\n";
        outputString += " Vertices: \n";
        outputString += "-------------------------\n";
        for (var vertex : this)
        {
            outputString += vertex.toString() + "\n";
        }
        outputString += "-------------------------\n";
        outputString += "Edges: \n";
        outputString += "-------------------------\n";
        for (var edge : edges)
        {
            outputString += edge.toString() + "\n";
        }

        return outputString;
    }
}
