package geometry;

public class Ellipse extends GeometricObject{
	 // private Point startPoint;
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
		this.startPoint = new Point (startPoint);
		this.a = a;
		this.b = b;
	}
	
	public Ellipse (Ellipse otherEllipse) {
		super("Ellipse" , 1, 0);
		startPoint = new Point(otherEllipse.startPoint);
		a = otherEllipse.a;
		b = otherEllipse.b;
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
	boolean isValid() {
		return a>0 && b>0;
		
	}
	@Override
	void initialize() {
		do {
			System.out.println("Anfangspunkt: " );
			startPoint.initialize();
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
		return startPoint + "-[" + a +", " + b + "]";
	}
	
	/*public void print() {
		double perimeter = calculatePerimeter();
		System.out.format("%s,%s, U=%s, F=%s\n", this,getType(),perimeter, calculateArea());
	} */
	@Override
	public boolean equal(GeometricObject otherGeometricObject) {
		if(otherGeometricObject instanceof Ellipse) {
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

}
