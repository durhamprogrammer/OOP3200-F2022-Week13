package ca.durhamcollege.oop3200f2022week13a.core;

public class Vector2
{
    // Private Instance Variables
    private float m_x;
    private float m_y;

    // Public Properties

    /**
     * Returns the value of x
     * @return {float}
     */
    public float getX()
    {
        return m_x;
    }

    /**
     * Sets the value of x
     * @param x {float}
     */
    public void setX(float x)
    {
        m_x = x;
    }

    /**
     * Gets the value of y
     * @return {float}
     */
    public float getY()
    {
        return m_y;
    }

    /**
     * Sets the value of Y
     * @param y {float}
     */
    public void setY(float y)
    {
        m_y = y;
    }

    /**
     * Sets the values of X and Y
     * @param x {float}
     * @param y {float}
     */
    void set(float x, float y)
    {
        setX(x);
        setY(y);
    }

    // Constructor Function(s)
    // Default Constructor

    /**
     * This is the default constructor. This sets the value of x and y to 0.0f.
     */
    public Vector2()
    {
        set(0.0f, 0.0f);
    }

    // Paramaterized Constructors

    /**
     * This sets the values of x and y to "value"
     * @param value {float}
     */
    public Vector2(float value)
    {
        set(value, value);
    }

    /**
     * This sets the value of x and y
     * @param x {float}
     * @param y {float}
     */
    public Vector2(float x, float y)
    {
        set(x, y);
    }

    // public methods

    /**
     * This adds the rhs vector2 by performing component-wise addition
     * @param rhs {Vector2}
     */
    public void add(Vector2 rhs)
    {
        set(getX() + rhs.getX(), getY() + rhs.getY());
    }

    /**
     * This subtracts the rhs vector2 by performing component-wise subtraction
     * @param rhs
     */
    public void subtract(Vector2 rhs)
    {
        set(getX() - rhs.getX(), getY() - rhs.getY());
    }


    public void scale(float scalar)
    {
        set(getX() * scalar, getY() * scalar);
    }

    public void scale(Vector2 scalar)
    {
        set(getX() * scalar.getX(), getY() * scalar.getY());
    }


    // public static methods
    public static Vector2 add(Vector2 lhs, Vector2 rhs)
    {
        return new Vector2(lhs.getX() + rhs.getX(), lhs.getY() + rhs.getY());
    }

    public static Vector2 subtract(Vector2 lhs, Vector2 rhs)
    {
        return new Vector2(lhs.getX() - rhs.getX(), lhs.getY() - rhs.getY());
    }

    public static Vector2 scale(Vector2 lhs, float scalar)
    {
        return new Vector2(lhs.getX() * scalar, lhs.getY() * scalar);
    }

    public static Vector2 scale(Vector2 lhs, Vector2 scalar)
    {
        return new Vector2(lhs.getX() * scalar.getX(), lhs.getY() * scalar.getY());
    }

    public static Vector2 Zero()
    {
    return new Vector2(0.0f, 0.0f);
    }

    public static Vector2 One()
    {
    return new Vector2( 1.0f, 1.0f );
    }

    public static Vector2 Right()
    {
    return new Vector2( 1.0f, 0.0f );
    }

    public static Vector2 Left()
    {
    return new Vector2( -1.0f, 0.0f );
    }

    public static Vector2 Up()
    {
    return new Vector2( 0.0f, -1.0f );
    }

    public static Vector2 Down()
    {
    return new Vector2( 0.0f, 1.0f );
    }

    public static float Distance(Vector2 start, Vector2 end)
    {
        float diffXs = end.getX() - start.getX();
        float diffYs = end.getY() - start.getY();
        return (float) Math.sqrt(diffXs * diffXs + diffYs * diffYs);
    }

    // overridden methods
    @Override
    public String toString()
    {
        return "(" + getX() + ", " + getY() + ")";
    }

    @Override
    public boolean equals(Object obj)
    {
        // If the object is compared with itself then return true
        if (obj == this)
        {
            return true;
        }

        /* Check if obj is an instance of Vector2 or not
          "null instanceof [type]" also returns false */
        if (!(obj instanceof Vector2))
        {
            return false;
        }

        // typecast o to Complex so that we can compare data members
        Vector2 vector2 = (Vector2) obj;

        // Compare the data members and return accordingly
        return Float.compare(getX(), vector2.getX()) == 0 && Float.compare(getY(), vector2.getY()) == 0;
    }
}
