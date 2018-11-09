package geometry;

public class Rectangle {
	private Point startPoint;
	private double height;
	private double width;
	
	public Rectangle() {
		startPoint = new Point(0,0);
		height = 1;
		width = 1;
	}
	
	public Rectangle(Point startPoint, double height, double width) {
		this.startPoint = new Point(startPoint);
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Rectangle otherRectangle) {
		startPoint = new Point(otherRectangle.startPoint);
		height = otherRectangle.height;
		width = otherRectangle.width;
	}
	
	public boolean isValid() {
		return height >0 && width <0;
	}
	
	public void initialize() {
		do {
			System.out.println("Anfangspunkt: ");
			startPoint.initialize();
			System.out.println("Hoehe: ");
			height = Help.INPUT.nextDouble();
			System.out.println("Breite: ");
			width = Help.INPUT.nextDouble();
		}while(!isValid());
	}
	
	public double calculatePerimeter() {
		return height*2 + width*2;
	}
	
	public double calculateArea() {
		return height*width;
	}

	
	public String getType() {
		return (height == width)? "Quadrat" : "Rechteck";
	}
	
	public String toString() {
		return startPoint + "-[" + height +", " + width + "]";
	}
	
	public void print() {
		double perimeter = calculatePerimeter();
		System.out.format("%s,%s, U=%s, F=%s\n", this,getType(),perimeter, calculateArea());
	}
	
	public boolean equal(Rectangle otherRectangle) {
		boolean sameHeight = Help.equal(height, otherRectangle.height);
		boolean sameWidth = Help.equal(width, otherRectangle.width);
		boolean sameHeightReserved = Help.equal(height, otherRectangle.width);
		boolean sameWidthReserved = Help.equal(width, otherRectangle.height);
		
		return (sameHeight && sameWidth) || (sameHeightReserved && sameWidthReserved);
	}
}
