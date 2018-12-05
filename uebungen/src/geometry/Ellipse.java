package geometry;
import javafx.scene.shape.Shape;
public class Ellipse extends GeometricObject{
	
	private double a;
	private double b;
	
	public Ellipse() {
		super("Ellipse" , 1, 0);
	//	startPoint = new Point(0,0);
		a = 1;
		b = 1;
	}
	
	public Ellipse( Point startPoint, double a, double b) {
		super("Ellipse" , 1, 0);
		points[0] = new Point (startPoint);
		this.a = a;
		this.b = b;
	}
	
	public Ellipse (Ellipse otherEllipse) {
		super("Ellipse" , 1, 0);
		points[0] = new Point(otherEllipse.points[0]);
		a = otherEllipse.a;
		b = otherEllipse.b;
	}
	
	
	
	@Override
	public boolean isValid() {
		return a>0 && b>0;
		
	}
	@Override
	public void initialize() {
		do {
			System.out.println("Anfangspunkt: " );
			points[0].initialize();
			System.out.println("Halbachse A: ");
			a = Help.INPUT.nextDouble();
			System.out.println("Halbachse B: ");
			b = Help.INPUT.nextDouble();
			
					
		}while(!isValid());
	}
	@Override
	public double calculatePerimeter() {
		return Math.PI*(3*(a+b)-Math.sqrt((3*a +b)*(a + 3*b))) ;
	}
	@Override
	public double calculateArea() {
		return Math.PI*a*b;
	}
	@Override
	public String getType() {
		return (a == b)? "Kreis" : "Ellipse";
	}
	@Override
	public String toString() {
		return points[0] + "-[" + a +", " + b + "]";
	}
	
	
	@Override
	public boolean equal(GeometricObject otherGeometricObject) {
		if(otherGeometricObject instanceof Ellipse) {
			Ellipse otherEllipse = (Ellipse) otherGeometricObject;
			boolean sameA = Help.equal(a, otherEllipse.a);
			boolean sameB = Help.equal(b, otherEllipse.b);
			boolean sameAReserved = Help.equal(a, otherEllipse.b);
			boolean sameBReserved = Help.equal(b, otherEllipse.a);
			
			return (sameA && sameB) || (sameAReserved && sameBReserved);
		}
		else {
			return false;
		}
	}
	
	@Override
	public Shape createShape(int scale) {
		double scaledCenterX = (points[0].x + a) * scale;
		double scaledCenterY = (points[0].y + b) * scale;
		double scaledA = a * scale;
		double scaledB = b * scale;
		return new javafx.scene.shape.Ellipse(scaledCenterX, scaledCenterY, scaledA, scaledB);
	}
	
	
	@Override
	public boolean contains(double x, double y) {
		Point clickPoint= new Point(x,y);
		double xCenter= points[0].x+a;
		double yCenter= points[0].y+b;
		double result= (Math.pow(x- xCenter, 2)/ (a*a))+ (Math.pow(y-yCenter, 2)/ (b*b));
		return result <=1;
		
		
		
	}

}
