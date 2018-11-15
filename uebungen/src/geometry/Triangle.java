package geometry;

public class Triangle {
	private Point[] points = new Point[3];
	private double[] sides = new double[3];
	
	
	public Triangle() {
		points[0] = new Point(0,0);
		points[1] = new Point(1,0);
		points[2] = new Point(0,1);
		calculateSides();
	}
	
	public Triangle(Point point1, Point point2, Point point3) {
		points[0] = new Point(point1);
		points[1] = new Point(point2);
		points[2] = new Point(point3);
		calculateSides();
	}
	
	public Triangle(Triangle otherTriangle) {
		points[0] = new Point(otherTriangle.points[0]);
		points[1] = new Point(otherTriangle.points[1]);
		points[2] = new Point(otherTriangle.points[2]);
		sides[0] = otherTriangle.sides[0];
		sides[1] = otherTriangle.sides[1];
		sides[2] =otherTriangle.sides[2];
	}
	
	private void calculateSides() {
		sides[0] = Help.calculateDistance(points[0], points[1]);
		sides[1] = Help.calculateDistance(points[1], points[2]);
		sides[2] = Help.calculateDistance(points[2], points[0]);
	}
	
	public boolean isValid() {
		return !(Help.areCollinear(points[0], points[1], points[2]));
	}
	
	public void initialize() {
		do {
			points[0].initialize();
			points[1].initialize();
			points[2].initialize();
		}while(!isValid());
		calculateSides();
	}
	
	public double calculatePerimeter() {
		return sides[0] + sides[1] + sides[2];
	}
	
	public double calculateArea() {
		 double p=(sides[0] + sides[1] + sides[2])/2;
		return Math.sqrt(p*(p-sides[0])*(p-sides[1])*(p-sides[2]));
	}
	
	public double getMaxAngle() {
		double alpha = Help.calculateAngle(sides[0], sides[2], sides[1]);
		double beta = Help.calculateAngle(sides[0], sides[1], sides[2]);
		double gamma = Help.calculateAngle(sides[1], sides[2], sides[0]);
		double maxAngle = Math.max(alpha, beta);
		return Math.max(maxAngle, gamma);
	}
	
	public String getType() {
		String type;
		boolean firstSecondEqual = Help.equal(sides[0], sides[1]);
		boolean secondThirdEqual = Help.equal(sides[1], sides[2]);
		boolean firstThirdEqual = Help.equal(sides[0], sides[2]);
		if (firstSecondEqual && secondThirdEqual) {
			type = "gleichseitig";
		} else if (firstSecondEqual||secondThirdEqual||firstThirdEqual) {
			type = "gleichschenklig";
		} else {
			type = "ungleichseitig";
	}
		return type;
	
	

}
	
	
	public String toString() {
		return points[0] + "-" + points[1] + "-" + points[2];
	}
	
	public void print() {
		System.out.format("%s, U=%s, F=%s\n", getType(), calculatePerimeter(), calculateArea());
	}
	
	public boolean equal(Triangle otherTriangle) {
		double area = calculateArea();
		double otherArea = otherTriangle.calculateArea();
		return Help.equal(area, otherArea);
	}
	
	
}
