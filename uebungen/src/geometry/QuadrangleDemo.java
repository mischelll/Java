package geometry;
public class QuadrangleDemo {

	public static void main(String[] args) {
		Quadrangle q1 = new Quadrangle();
		Point point1= new Point(3,2);
		Point point2= new Point(9,3);
		Point point3= new Point(4,8);
		Point point4= new Point(6,4);
		Quadrangle q2 = new Quadrangle(point1, point2, point3, point4);
		
		Point[] points = {new Point(2,2) , new Point(13,2) , new Point(8,6) , new Point(4,6) }; 
		Quadrangle q3 = new Quadrangle(points);
		Quadrangle q4 = new Quadrangle(q3);
		Quadrangle q5 = new Quadrangle();
		q5.initialize();
		q1.print();
		q2.print();
		q3.print();
		q4.print();
		q5.print();
		
		System.out.println("Viereck 3 gleich Viereck 4: " + q3.equal(q4));
		System.out.println("Viereck 3 gleich Viereck 5: " + q3.equal(q5));

	}

}
