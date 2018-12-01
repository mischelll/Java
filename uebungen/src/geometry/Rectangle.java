package geometry;

public class Rectangle extends GeometricObject {
	
	private double height;
	private double width;
	
	public Rectangle() {
		super("Rectangle", 1, 0);
		points[0] = new Point(0,0);
		height = 1;
		width = 1;
	}
	
	public Rectangle(Point startPoint, double height, double width) {
		super("Rectangle", 1, 0);
		points[0] = new Point(startPoint);
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Rectangle otherRectangle) {
		super("Rectangle", 1, 0);
		points[0] = new Point(otherRectangle.points[0]);
		height = otherRectangle.height;
		width = otherRectangle.width;
	}
	
	@Override
	public Shape createShape(int scale) {
		double scaledX = points[0].x * scale;
		double scaledY = points[0].y * scale;
		double scaledHeight = height * scale;
		double scaledWidth = width * scale;
		return new javafx.scene.shape.Rectangle(scaledX, scaledY, scaledWidth, scaledHeight);
	}
	
	@Override
	public boolean isValid() {
		return height >0 && width <0;
	}
	@Override
	public void initialize() {
		do {
			System.out.println("Anfangspunkt: ");
			points[0].initialize();
			System.out.println("Hoehe: ");
			height = Help.INPUT.nextDouble();
			System.out.println("Breite: ");
			width = Help.INPUT.nextDouble();
		}while(!isValid());
	}
	@Override
	public double calculatePerimeter() {
		return height*2 + width*2;
	}
	@Override
	public double calculateArea() {
		return height*width;
	}

	@Override
	public String getType() {
		return (height == width)? "Quadrat" : "Rechteck";
	}
	@Override
	public String toString() {
		return points[0] + "-[" + height +", " + width + "]";
	}
	
	
	@Override
	public boolean equal(Rectangle otherRectangle) {
		if(otherGeometricObject instanceof Rectangle) {
			Rectangle otherRectangle = (Rectangle) otherGeometricObject;
			boolean sameHeight = Help.equal(height, otherRectangle.height);
			boolean sameWidth = Help.equal(width, otherRectangle.width);
			boolean sameHeightReserved = Help.equal(height, otherRectangle.width);
			boolean sameWidthReserved = Help.equal(width, otherRectangle.height);
			
			return (sameHeight && sameWidth) || (sameHeightReserved && sameWidthReserved);
		}else {
			return false;
		}
		
	}
	
	
}
