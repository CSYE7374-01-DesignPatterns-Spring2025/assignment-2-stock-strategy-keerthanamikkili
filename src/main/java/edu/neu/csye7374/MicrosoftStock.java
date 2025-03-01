package edu.neu.csye7374;

public class MicrosoftStock extends Stock{
	public MicrosoftStock(double price) {
	    super("Microsoft", price, "Software Engineering Company");
	}
	
	@Override
	public int getMetric() { // I have overrided the getMetric() method
		double mean = (this.prevPrices.stream().mapToDouble(i -> i.doubleValue()).sum()) / this.prevPrices.size();
		double dev = 0.0;
		for (double num : this.prevPrices) {
			dev += mean - num/3;
		}
		dev = dev / this.prevPrices.size();
		return dev > 0.0 ? 1 : -1;
	}
	
	@Override
	public String toString() {
		return "Stock [name=" + this.getName() + ", price=" + this.getPrice() + ", description=" + this.getDescription() + "Metric : " + this.getMetric() + "]";
	}
}
