package ca.durhamcollege.oop3200f2022week13a.core;

public class Line
{
    // private instance members
    private Vector2 start;
    private Vector2 end;

    // public properties
    public Vector2 getStart()
    {
        return start;
    }

    public void setStart(Vector2 point)
    {
        start = point;
    }

    public Vector2 getEnd()
    {
        return end;
    }

    public void setEnd(Vector2 point)
    {
        end = point;
    }

    public void set(Vector2 start, Vector2 end)
    {
        setStart(start);
        setEnd(end);
    }

    // computed property
    public float getLength()
    {
        return Vector2.Distance(getStart(), getEnd());
    }

    // constructor(s)
    public Line()
    {
        set(Vector2.Zero(), Vector2.Zero());
    }

    public Line(Vector2 start, Vector2 end)
    {
        set(start, end);
    }

    // public methods
    @Override
    public String toString()
    {
        return "start: " + getStart().toString() + " end:" + getEnd().toString() + " length: " + getLength();
    }
}
