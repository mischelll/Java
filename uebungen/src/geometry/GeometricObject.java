import com.sun.javafx.scene.paint.GradientUtils.Point;

public abstract class GeometricObject implements GeometricDrawing{

	protected String name;
	protected Point[] points;
	protected double[] sides;
	
	protected GeometricObject(String name, int pointsCount , int sidesCount) {
		this.name = name;
		points = new Point[pointsCount];
		sides  =new double[sidesCount];
	}
	
	public abstract boolean isValid();
	public abstract void initialize();
	public abstract double calculatePerimeter();
	public abstract double calculateArea();
	public abstract String gerType();
	public abstract String toString();
	public abstract boolean(GeometricObject otherGeometricObject);
	
	public void print() {
		System.out.println("%s: %s, %s, %s, U = %s, F = %s\n" , name, this, getType(), calculatePerimeter(),
				calculateArea());
	}
	
	protected void calculateSides() {
		for(int index = 0; index < points.length; index++) {
			int nextIndex = (index == points.length -1) ? 0 : index +1;
			sides[index] = Help.calculateDistance(points[index], points[nextIndex]);
		}
	}
}
