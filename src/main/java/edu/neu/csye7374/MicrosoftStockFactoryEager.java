package edu.neu.csye7374;

public class MicrosoftStockFactoryEager extends AbstractFactory{
	private MicrosoftStockFactoryEager() {

	}

	private static final AbstractFactory instance = new MicrosoftStockFactoryEager();

	public static AbstractFactory getInstance() {
		return instance;
	}

	public Stock getObject(double price) {
		return new MicrosoftStock(price);
	}
}
