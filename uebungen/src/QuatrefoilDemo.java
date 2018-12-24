package default2;

public class QuatrefoilDemo {

	public static void main(String[] args) {
		Quatrefoil q1 = new Quatrefoil();
		Point startPoint2 = new Point(1,2);
		Quatrefoil q2 = new Quatrefoil(startPoint2,2,3);
		Quatrefoil q3 = new Quatrefoil(q2);
		Quatrefoil q4 = new Quatrefoil();
		q4.initialize();
		q1.print();
		q2.print();
		q3.print();
		q4.print();
		
		
		
		System.out.println("Vierpass 2 gleich Vierpass 1: " + q2.equal(q1));
		System.out.println("Vierpass 2 gleich Vierpass 3: " + q2.equal(q3));
	}

}
