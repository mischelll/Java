package geometry;

public class EllipseDemo {

	public static void main(String[] args) {
		Ellipse e1 = new Ellipse();
		Point startPoint2 = new Point (2,3);
		Ellipse e2 = new Ellipse(startPoint2,5,6);
		Ellipse e3 = new Ellipse(e2);
		Ellipse e4 = new Ellipse();
		e4.initialize();
		e1.print();
		e2.print();
		e3.print();
		e4.print();
		System.out.println("Rechteck 2 gleich Rechteck 1: " + e2.equal(e1));

		System.out.println("Rechteck 2 gleich Rechteck 3: " + e2.equal(e3));

	}

}
