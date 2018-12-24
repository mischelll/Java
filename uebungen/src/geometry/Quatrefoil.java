package default2;

import javafx.scene.shape.Shape;

public class Quatrefoil extends GeometricObject {
	private double a;
	private double b;
	private Rectangle rectangle;
	private Ellipse ellipse;
	private Ellipse ellipse2;
	private Ellipse ellipse3;
	private Ellipse ellipse4;
	
	
	
	
	public Quatrefoil() {
		super("Vierpass",1,0);
		points[0] = new Point(0,0);
		a = 1;
		b = 1;
		calculateFigure();
		
		
	}
	
	
	@Override
	public Shape createShape(int scale) {
		
		
		
		
		Shape s2= rectangle.createShape(scale);
		
		Shape s3 = ellipse.createShape(scale);
		Shape s4 = ellipse2.createShape(scale);
		Shape s6 = ellipse3.createShape(scale);
		Shape s7 = ellipse4.createShape(scale);
		
		ellipse2.createShape(scale);
		ellipse3.createShape(scale);
		ellipse4.createShape(scale);
		
		 Shape s1 = Shape.union(s2, s3);
		 Shape s5 = Shape.union(s1, s4);
		 Shape s8 = Shape.union(s5, s6);
		 Shape s9 = Shape.union(s8, s7);
		
		
		return s9;
	}
	
	public Quatrefoil(Point startPoint, double a, double b) {
		super("Vierpass",1,0);
		points[0] = new Point(startPoint);
		this.a = a;
		this.b = b;
		calculateFigure();
		
	}
	
	public Quatrefoil(Quatrefoil otherQuatrefoil) {
		super("Vierpass",1,0);
		points[0] = new Point(otherQuatrefoil.points[0]);
		a = otherQuatrefoil.a;
		b = otherQuatrefoil.b;
		calculateFigure();
		
		
	}
	public void calculateFigure() {
		
		double x=points[0].x;
		double y=points[0].y;
		Point p1 = new Point(x+a,y+b);
		rectangle  = new Rectangle(p1,a,b);
		
		Point p2 = new Point(x + a/2,y);
		Point p3 = new Point(x + a/2,y+b);
		Point p4 = new Point(x , y + b/2);
		Point p5 = new Point(x + a,y + b/2);
		
		ellipse = new Ellipse(p2,a,b);
		ellipse2 = new Ellipse(p3,a,b);
		ellipse3 = new Ellipse(p4,a,b);
		ellipse4 = new Ellipse(p5,a,b);
		
		
		
		
		
		
		
	}
	
	
	
	
	@Override
	public boolean isValid() {
		return a > 0 && b > 0;
	}
	
	
	@Override
	public void initialize() {
		do {
			System.out.println("Anfangspunkt: ");
			points[0].initialize();
			System.out.println("a: ");
			a = Help.INPUT.nextDouble();
			System.out.println("b: ");
			b = Help.INPUT.nextDouble();
		}while(!isValid());
	}
	
	@Override
	public double calculatePerimeter() {
		double rec = rectangle.calculatePerimeter();
		double el1 = ellipse.calculatePerimeter();
		double el2 = ellipse2.calculatePerimeter();
		double el3 = ellipse3.calculatePerimeter();
		double el4 = ellipse4.calculatePerimeter();
		double resultPerimeter = rec + el1 + el2 + el3 + el4;
		//2*a + 2*b + 2*Math.PI*a + 2*Math.PI*b
		return resultPerimeter;
	}
	
	
	@Override
	public double calculateArea() {
		double rec = rectangle.calculateArea();
		double el1 = ellipse.calculateArea();
		double el2 = ellipse2.calculateArea();
		double el3 = ellipse3.calculateArea();
		double el4 = ellipse4.calculateArea();
		double resultArea = rec + el1 + el2 + el3 + el4;
		//a*b + Math.PI*Math.pow(a/2, 2) + Math.PI*Math.pow(b/2, 2)
		return resultArea;
	}
	
	
	@Override
	public String getType() {
		return (a == b) ? "regulaer" : "irregulaer";
	}
	
	
	@Override
	public String toString() {
		return points[0] + "-["+ a + "," + b +"]";
	}
	
	
	@Override
	public boolean equal(GeometricObject otherGeometricObject) {
		if(otherGeometricObject instanceof Quatrefoil) {
			Quatrefoil otherQuatrefoil = (Quatrefoil) otherGeometricObject;
			boolean sameA = Help.equal(a, otherQuatrefoil.a);
			boolean sameB = Help.equal(b, otherQuatrefoil.b);
			
			return sameA || sameB;
			
		}
		
		else
		{
			return false;
		}
	}


	@Override
	public boolean contains(double x, double y) {
		//boolean xInside = points[0].x < x && x < (points[0].x+ a);
		//boolean yInside = points[0].y < y && y < (points[0].y + b);
		//double xCenter = points[0].x;
		//double yCenter = points[0].y;
		//boolean result = (Math.pow(x- xCenter, 2)/ (a*a)) + (Math.pow(y-yCenter, 2)/ (b*b)) <=1;
		
		return ellipse.contains(x, y) || ellipse2.contains(x, y) || ellipse3.contains(x, y) ||
				ellipse4.contains(x, y);
				
	}

	
	
	
	
	
	
	
	

}
