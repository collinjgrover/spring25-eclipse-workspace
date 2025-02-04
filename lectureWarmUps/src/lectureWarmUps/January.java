package lectureWarmUps;

public class January {

	double price;
	
	cupcakeFlavors[] types = cupcakeFlavors.values();
	
	


	public enum cupcakeFlavors {
		PLAIN(2.5), GF(2.75), Chocolate(3.00), Vanilla(3.00), BirthdayCake(3.00);
		private final double price;
		private cupcakeFlavors(double d) {
			this.price = d;
		}
		
	
		
	public double getPrice() {
		return price;
		}
		
	}
	
}
