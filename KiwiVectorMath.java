import java.io.*;
import java.lang.Math;
import vector.Vector2D;

class KiwiVectorMath {

	//
	//	    /\ 
	//         /  \
	//        /    \
	//     l /      \ r
	//      /        \
	//     /          \
	//     ------------
	//	    m

	public static void main(String[] argv){
		Vector2D middleWheelVec = new Vector2D(1.0, 0.0);
		Vector2D rightWheelVec = new Vector2D(-1.0, 1.0);
		Vector2D leftWheelVec = new Vector2D(1.0, 1.0);

		double middleWheelOutput = 0.0;
		double rightWheelOutput = 0.0;
		double leftWheelOutput = 0.0;

		double xOutput = Vector2D.add(Vector2D.add(Vector2D.multiply(rightWheelOutput, new Vector2D(rightWheelVec.magnitude()*Math.toDegrees(Math.cos(Vector2D.angleBetween(rightWheelVec, new Vector2D(1,0)))), 0).normalize()), Vector2D.multiply(leftWheelOutput, new Vector2D(leftWheelVec.magnitude()*Math.toDegrees(Math.cos(Vector2D.angleBetween(leftWheelVec, new Vector2D(1,0)))), 0).normalize())), Vector2D.multiply(middleWheelOutput, middleWheelVec)).normalize().x;
		double yOutput = Vector2D.add(Vector2D.multiply(rightWheelOutput, new Vector2D(0,rightWheelVec.magnitude()*Math.toDegrees(Math.cos(Vector2D.angleBetween(rightWheelVec, new Vector2D(0,1))))).normalize()), Vector2D.multiply(leftWheelOutput, new Vector2D(0,leftWheelVec.magnitude()*Math.toDegrees(Math.cos(Vector2D.angleBetween(leftWheelVec, new Vector2D(0,1))))).normalize())).normalize().y;

		System.out.println(String.format("[%1$.1f, %2$.1f]", xOutput, yOutput));

	}

}
