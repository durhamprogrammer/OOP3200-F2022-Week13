package ca.durhamcollege.oop3200f2022week13a.core;

import java.lang.Math;

public class Mathf
{
    // Static constants
    public static final float Epsilon = 0.00001f;
    public static final float EpsilonNormalSqrt = 1e-15f;
    public static final float PI = 3.141593f;
    public static final float Infinity = Float.POSITIVE_INFINITY;
    public static final float NegativeInfinity = Float.NEGATIVE_INFINITY;
    public static final float Deg2Rad = 0.01745329f;
    public static final float Rad2Deg = 57.29578f;

    public static float Sin(final float f)
    {
        return (float)(Math.sin(f));
    }

    public static float Cos(final float f)
    {
        return (float)(Math.cos(f));
    }

    public static float Tan(final float f)
    {
        return (float)(Math.tan(f));
    }

    public static float Asin(final float f)
    {
        return (float)(Math.asin(f));
    }

    public static float Acos(final float f)
    {
        return (float)(Math.acos(f));
    }

    public static float Atan(final float f)
    {
        return (float)(Math.atan(f));
    }

    public static float Atan2(final float y, final float x)
    {
        return (float)(Math.atan2(y, x));
    }

    public static float Sqrt(final float f)
    {
        return (float)(Math.sqrt(f));
    }

    public static float Abs(final float f)
    {
        return Math.abs(f);
    }

    public static int Abs(int value)
    {
        return Math.abs(value);
    }

    public static float Min(final float a, final float b)
    {
        if ((double)a < (double)b)
        {
            return a;
        }
        return b;
    }

    public static int Min(final int a, final int b)
    {
        if (a < b)
        {
            return a;
        }
        return b;
    }

    public static float Max(final float a, final float b)
    {
        if ((double)a > (double)b)
        {
            return a;
        }
        return b;
    }

    public static int Max(final int a, final int b)
    {
        if (a > b)
        {
            return a;
        }
        return b;
    }

    public static float Pow(final float f, final float p)
    {
        return (float)(Math.pow(f, p));
    }

    public static float Exp(final float power)
    {
        return (float)(Math.exp(power));
    }

    public float Log(final float f)
    {
        return (float)(Math.log(f));
    }

    public static float Log10(final float f)
    {
        return (float)(Math.log10(f));
    }

    public static float Ceil(final float f)
    {
        return (float)(Math.ceil(f));
    }

    public static float Floor(final float f)
    {
        return (float)(Math.floor(f));
    }

    public static float Round(final float f)
    {
        return (float)(Math.round(f));
    }

    public static int CeilToInt(final float f)
    {
        return (int)(Math.ceil(f));
    }

    public static int FloorToInt(final float f)
    {
        return (int)(Math.floor(f));
    }

    public static int RoundToInt(final float f)
    {
        return (int)(Math.round(f));
    }

    public static float Sign(final float f)
    {
        return f >= 0.0 ? 1.0f : -1.0f;
    }

    public static float Clamp(float value, final float min, final float max)
    {
        if ((double)value < (double)(min))
        {
            value = min;
        }
        else if ((double)value > (double)max)
        {
            value = max;
        }
        return value;
    }

    public static int Clamp(int value, final int min, final int max)
    {
        if (value< min)
        {
            value = min;
        }
        else if (value > max)
        {
            value = max;
        }
        return value;
    }

    public static float Clamp01(final float value)
    {
        if ((double)value < 0.0)
        {
            return 0.0f;
        }
        if ((double)value > 1.0)
        {
            return 1.0f;
        }
        return value;
    }

    public static float Lerp(final float a, final float b, final float t)
    {
        return a + (b - a) * Clamp01(t);
    }

    public static float LerpUnclamped(final float a, final float b, final float t)
    {
        return a + (b - a) * t;
    }

    public static float LerpAngle(final float a, final float b, final float t)
    {
        float num = Repeat(b - a, 360.0f);
        if ((double)(num) > 180.0)
        {
            num -= 360.0f;
        }
        return a + num * Clamp01(t);
    }

    public static float MoveTowards(final float current, final float target, final float max_delta)
    {
        if ((double)(Abs(target - current)) <= (double)max_delta)
        {
            return target;
        }
        return current + Sign(target - current) * max_delta;
    }

    public static float MoveTowardsAngle(final float current, float target, final float max_delta)
    {
        target = current + DeltaAngle(current, target);
        return MoveTowards(current, target, max_delta);
    }

    public static float SmoothStep(final float from, final float to, float t)
    {
        t = Clamp01(t);
        t = (float)(-2.0 * (double)(t) * (double)(t) * (double)(t) + 3.0 * (double)(t) * (double)(t));
        return (float)((double)(to) * (double)(t) + (double)(from) * (1.0 - (double)(t)));
    }

    public static boolean Approximately(final float a, final float b)
    {
        return (double)(Abs(b - a)) < (double)(Max(1E-06f * Max(Abs(a), Abs(b)), Epsilon * 8.0f));
    }

    public static float Repeat(final float t, final float length)
    {
        return t - Floor(t / length) * length;
    }

    public static float PingPong(float t, final float length)
    {
        t = Repeat(t, length * 2.0f);
        return length - Abs(t - length);
    }

    public static float InverseLerp(final float a, final float b, final float value)
    {
        if ((double)a != (double)b)
        {
            return Clamp01((float)(((double)value - (double)a) / ((double)b - (double)a)));
        }
        return 0.0f;
    }

    public static float DeltaAngle(final float current, final float target)
    {
        float num = Repeat(target - current, 360.0f);
        if ((double)(num) > 180.0)
        {
            num -= 360.0f;
        }
        return num;
    }
}
