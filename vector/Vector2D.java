package vector;

import java.lang.Math;

public class Vector2D {

	public double x = -Double.MAX_VALUE;
	public double y = -Double.MAX_VALUE;

	public Vector2D(){
		;
	}

	public Vector2D(double x, double y){
		this.x = x;
		this.y = y;
	}

	public Vector2D(double[] vec){
		this.x = vec[0];
		this.y = vec[1];
	}

	public String toString(){
		return String.format("(%1$.1f, %2$.1f)", this.x, this.y);
	}

	public Vector2D invert(){
		return Vector2D.multiply(this, -1.0);
	}

	public double magnitude(){
		return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
	}

	public Vector2D normalize(){
		return Vector2D.divide(this, this.magnitude());
	}

	public Vector2D squish(){
		return new Vector2D(this.x > 1.0 && this.x > 0.0 ? 1.0 : this.x < -1.0 && this.x < 0.0 ? -1.0 : this.x, this.y > 1.0 && this.y > 0.0 ? 1.0 : this.y < -1.0 && this.y < 0.0 ? -1.0 : this.y);
	}

	public static Vector2D add (Vector2D v1, Vector2D v2){
		return new Vector2D(v1.x+v2.x, v1.y+v2.y);
	}

	public static Vector2D subtract (Vector2D v1, Vector2D v2){
		return new Vector2D(v1.x-v2.x, v1.y-v2.y);
	}

	public static Vector2D multiply(Vector2D v, double scalar){
		return new Vector2D(v.x*scalar, v.y*scalar);
	}

	public static Vector2D multiply(double scalar, Vector2D v){
		return new Vector2D(v.x*scalar, v.y*scalar);
	}

	public static Vector2D divide(Vector2D v, double scalar){
		return new Vector2D(scalar != 0.0 ? v.x/scalar : 0.0, scalar != 0.0 ? v.y/scalar : 0.0);
	}

	public static boolean equal(Vector2D v1, Vector2D v2){
		return v1.x == v2.x && v1.y == v2.y ? true : false;
	}

	public static Vector2D linearCombination(double k1, Vector2D v1, double k2, Vector2D v2){
		return Vector2D.add(Vector2D.multiply(k1, v1), Vector2D.multiply(k2, v2));
	}

	public static Vector2D linearCombination(double k1, double k2, Vector2D v1, Vector2D v2){
		return Vector2D.add(Vector2D.multiply(k1, v1), Vector2D.multiply(k2, v2));
	}

	public static double dot(Vector2D v1, Vector2D v2){
		return v1.x*v2.x + v1.y*v2.y;
	}

	public static double angleBetween(Vector2D v1, Vector2D v2){
		return Math.toDegrees(Math.acos(Vector2D.dot(v1, v2)/v1.magnitude()*v2.magnitude()));
	}

	public static Vector2D linearCombination(double[] k, Vector2D[] v){
		Vector2D r = new Vector2D(0.0, 0.0);
		int i = 0;
		for (Vector2D vi : v){
			r = Vector2D.add(r, Vector2D.multiply(k[i], vi));
			i++;
		}
		return r;
	}

	public static Vector2D normalize(Vector2D v){
		return Vector2D.divide(v, v.magnitude());
	}

	public static Vector2D squish(Vector2D v){
		return new Vector2D(v.x > 1.0 && v.x > 0.0 ? 1.0 : v.x < -1.0 && v.x < 0.0 ? -1.0 : v.x, v.y > 1.0 && v.y > 0.0 ? 1.0 : v.y < -1.0 && v.y < 0.0 ? -1.0 : v.y);
	}

}
