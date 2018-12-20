package geometry;
import javafx.scene.shape.Shape;

public class Rhomboid extends GeometricObject {
	
	private double a;
	private double b;
	private Quadrangle quadrangle;
	
	
	public Rhomboid() {
		super("Rhomboid", 1,0);
		points[0] = new Point(0,0);
		a = 1;
		b = 1;
		calculateFigure();
		
	}
	
	
	public Rhomboid(Point point , double a, double b) {
		super("Rhomboid", 1, 0);
		this.points[0] = new Point(point);
		this.a = a;
		this.b = b;
		calculateFigure();
	}
	
	
	public Rhomboid(Rhomboid otherRhomboid) {
		super("Rhomboid" , 1, 0);
		this.points[0] = new Point(otherRhomboid.points[0]);
		a = otherRhomboid.a;
		b = otherRhomboid.b;
		calculateFigure();
	}
	
	private void calculateFigure() {
		Point p1 = new Point(points[0].x + a / 2, points[0].y);
		Point p2 = new Point(points[0].x + a, points[0].y + b/2);
		Point p3 = new Point(points[0].x + a / 2, points[0].y + b);
		Point p4 = new Point(points[0].x  , points[0].y + b/2);
		quadrangle = new Quadrangle(p1,p2,p3,p4);
	}
	
	
	@Override
	public boolean isValid() {
		return a > 0 && b > 0;
	}
	
	
	@Override
	public void initialize() {
		do {
			System.out.println("Anfangspunkts: ");
			points[0].initialize();
			System.out.println("Diagonal 1: ");
			a = Help.INPUT.nextDouble();
			System.out.println("Diagnonal 2: ");
			b  = Help.INPUT.nextDouble();
		}while(!isValid());
		calculateFigure();
	}
	
	
	@Override
	public double calculatePerimeter() {
		return quadrangle.calculatePerimeter();
	}

	@Override
	public double calculateArea() {
		return quadrangle.calculateArea();
	}
	
	
	@Override
	public String getType() {
		return (a == b) ? "Rhombus" : "Rhomboid";
	}
	
	
	@Override
	public String toString() {
		return points[0] + " - " + "{ " + a + " , " + b + " }";
	}
	
	@Override
	public boolean equal(GeometricObject otherGeometricObject) {
		if(otherGeometricObject instanceof Rhomboid) {
			Rhomboid otherRhomboid = (Rhomboid) otherGeometricObject;
			boolean sameDiagonalA = Help.equal(a, otherRhomboid.a);
			boolean sameDiagonalB = Help.equal(b, otherRhomboid.b);
			boolean sameDiagonalReversedA = Help.equal(a, otherRhomboid.b);
			boolean sameDiagonalReversedB = Help.equal(b, otherRhomboid.a);
			
			return (sameDiagonalA && sameDiagonalB) || (sameDiagonalReversedA && sameDiagonalReversedB);
		}
		else {
			return false;
		}
		
		
	}
	
	@Override
	public Shape createShape(int scale) {
		//double scaledX = points[0].x*scale;
		//double scaledY = points[0].y*scale;
		//double scaledDiagonalA = a * scale;
		//double scaledDiagonalB = b * scale;
		
		
		
		return quadrangle.createShape(scale);
		
	}


	@Override
	public boolean contains(double x, double y) {
		
		return quadrangle.contains(x, y);
	}
	
	

}
