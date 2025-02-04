package edu.neu.csye7374;

public class MicrosoftStockFactory extends AbstractFactory {
	@Override
	public Stock getObject(double price) {
		return new MicrosoftStock(price);
	}
}
