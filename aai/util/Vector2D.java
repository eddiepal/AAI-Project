package aai.util;

/**
 * Created by gh0073874 on 13-2-2017.
 */
public class Vector2D {

    public double x;
    public double y;

    public Vector2D() {
        x = 0;
        y = 0;
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double length() {
        return Math.pow(Math.pow(this.x,2) + Math.pow(this.y,2),1/2);
    }

    public Vector2D add(Vector2D v) {
        this.x += v.x;
        this.y += v.y;
        return this;
    }

    public Vector2D sub(Vector2D v) {
        this.x -= v.x;
        this.y -= v.y;
        return this;
    }

    public Vector2D multiply(double value) {
        this.x *= value;
        this.y *= value;
        return this;
    }

    public Vector2D divide(double value) {
        this.x /= value;
        this.y /= value;
        return this;
    }

    public Vector2D normalize() {
        if(this.x > this.y){
            this.y /= this.length();
            this.x /= this.length();
        }
        else{
            this.x /= this.length();
            this.y /= this.length();
        }
        return this;
    }

    public Vector2D truncate(double max) {
        if (length() > max) {
            normalize();
            multiply(max);
        }
        return this;
    }

    public double dot(Vector2D v){
        return (this.x * v.x) + (this.y * v.y);
    }

    @Override
    public Vector2D clone() {
        return new Vector2D(this.x, this.y);
    }

    @Override
    public String toString() {
        return String.format("(%s,%s)", x, y);
    }
}