package geometry;

public class RectangleDemo {

	public static void main(String[] args) {
		Rectangle rectangle1 = new Rectangle();
		Point startPoint2 = new Point (1,1);
		Rectangle rectangle2 = new Rectangle(startPoint2,2,3);
		Rectangle rectangle3 = new Rectangle(rectangle2);
		Rectangle rectangle4 = new Rectangle();
		rectangle4.initialize();
		rectangle1.print();
		rectangle2.print();
		rectangle3.print();
		rectangle4.print();
		System.out.println("Rectheck 2 gleich Rechteck 1: " + rectangle2.equal(rectangle1));
		System.out.println("Rectheck 2 gleich Rechteck 3: " + rectangle2.equal(rectangle3));

	}

}
