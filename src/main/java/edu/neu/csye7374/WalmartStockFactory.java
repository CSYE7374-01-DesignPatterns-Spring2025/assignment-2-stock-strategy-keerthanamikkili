package edu.neu.csye7374;

public class WalmartStockFactory extends AbstractFactory {

	@Override
	public Stock getObject(double price) {
		return new WalmartStock(price);
	}
}
