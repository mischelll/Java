package geometry;
public class Quadrangle {
	Point[] points = new Point[4];
	double[] sides = new double[4];
	
	
	
	public Quadrangle() {
		points[0] = new Point(0,0);
		points[1] = new Point(1,0);
		points[2] = new Point(1,1);
		points[3] = new Point(0,1);
		calculateSides();
		
	}
	
	public Quadrangle(Point point1, Point point2, Point point3, Point point4) {
		points[0] = new Point(point1);
		points[1] = new Point(point2);
		points[2] = new Point(point3);
		points[3] = new Point(point4);
		calculateSides();
	}
	
	public Quadrangle(Point[] points) {
		for(int i = 0; i< points.length; i++) {
			this.points[i] = points[i];
		}
		calculateSides();
	}
	
	public Quadrangle(Quadrangle otherQuadrangle) {
		for(int i = 0; i< points.length; i++) {
			points[i] = new Point(otherQuadrangle.points[i]);
			sides[i] = otherQuadrangle.sides[i];
		}
	}
	
	private void calculateSides() {
		sides[0] = Help.calculateDistance(points[0], points[1]);
		sides[1] = Help.calculateDistance(points[1], points[2]);
		sides[2] = Help.calculateDistance(points[2], points[3]);
		sides[3] = Help.calculateDistance(points[3], points[0]);
	}
	
	public boolean isValid() {
		double quadrangleArea = calculateArea();
		Triangle[] triangles = new Triangle[4];
		triangles[0] = new Triangle(points[0] , points[1] , points[2]);
		triangles[1] = new Triangle(points[1] , points[2] , points[3]);
		triangles[2] = new Triangle(points[2] , points[3] , points[0]);
		triangles[3] = new Triangle(points[3] , points[0] , points[1]);
		
		for(Triangle triangle : triangles) {
			boolean triangleNotValid = !triangle.isValid();
			boolean triangleAreaBigger = triangle.calculateArea() > quadrangleArea;
			if(triangleNotValid || triangleAreaBigger) {
				return false;
			}
			
			
		}
		return true;
		
	}
	
	public void initialize() {
		do {
			for(Point point : points) {
				point.initialize();
			}
			
		}while(!isValid());
		calculateSides();
	}
	
	public double calculatePerimeter() {
		return sides[0] + sides[1] + sides[2] + sides[3];
		
	}
	
	public double calculateArea() {
		double result1 = points[0].x * points[1].y - points[0].y * points[1].x;
		double result2 = points[1].x * points[2].y - points[1].y * points[2].x;
		double result3 = points[2].x * points[3].y - points[2].y * points[3].x;
		double result4 = points[3].x * points[0].y - points[3].y * points[0].x;
		return Math.abs(result1 + result2 + result3 + result4)/2;
	}
	
	public String getType() {
		double coefficient1 = Help.calculateCoefficient(points[0], points[1]);
		double coefficient2 = Help.calculateCoefficient(points[1], points[2]);
		double coefficient3 = Help.calculateCoefficient(points[2], points[3]);
		double coefficient4 = Help.calculateCoefficient(points[3], points[0]);
		if (Help.equal(coefficient1, coefficient3) && Help.equal(coefficient2, coefficient4)) {
			return "Parallelogram";
		} else if (Help.equal(coefficient1, coefficient3) || Help.equal(coefficient2, coefficient4)) {
			return "Trapez";
		} else {
			return "gewoehnliches Viereck";
		}

	}
	
	
	public String toString() {
		return points[0] + "-" + points[1] + "-" + points[2] + "-" + points[3];
 
	}
	
	public void print() {
		System.out.format("%s,%s, U=%s,F=%s\n", this, getType(), calculatePerimeter(), calculateArea());
	}
	
	public boolean equal(Quadrangle otherQuadrangle) {
		Triangle triangle1 = new Triangle(points[0], points[1], points[2]);
		Triangle triangle2 = new Triangle(points[0], points[2], points[3]);
		Point[] otherPoints = otherQuadrangle.points;
		Triangle otherTriangle1 = new Triangle(otherPoints[0], otherPoints[1], otherPoints[2]);
		Triangle otherTriangle2 = new Triangle(otherPoints[0], otherPoints[2], otherPoints[3]);
		return triangle1.equal(otherTriangle1) && triangle2.equal(otherTriangle2);
}


}
