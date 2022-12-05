package ca.durhamcollege.oop3200f2022week13a.core;

import javafx.scene.paint.Color;

public class Line
{
    // private instance members
    private Vector2 start;
    private Vector2 end;

    private float width;

    private Color color;

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

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void set(Vector2 start, Vector2 end)
    {
        setStart(start);
        setEnd(end);
    }

    public void set(Vector2 start, Vector2 end, float width, Color color)
    {
        setStart(start);
        setEnd(end);
        setWidth(width);
        setColor(color);
    }

    // computed property
    public float getLength()
    {
        return Vector2.Distance(getStart(), getEnd());
    }

    // constructor(s)
    public Line()
    {
        set(Vector2.Zero(), Vector2.Zero(), 1.0f, Color.BLACK);
    }

    public Line(Vector2 start, Vector2 end)
    {
        set(start, end, 1.0f, Color.BLACK);
    }

    public Line(Vector2 start, Vector2 end, float width, Color color)
    {
        set(start, end, width, color);
    }

    // public methods
    @Override
    public String toString()
    {
        return "start: " + getStart().toString() + " end:" + getEnd().toString() + " length: " + getLength();
    }
}
