package edu.neu.csye7374;

public class WalmartStockFactoryLazy extends AbstractFactory {
	private WalmartStockFactoryLazy() {

	}

	private static AbstractFactory instance = null;

	public static AbstractFactory getInstance() {
		if (instance == null) {
			synchronized (WalmartStockFactoryLazy.class) {

				instance = new WalmartStockFactoryLazy();

			}

		}
		return instance;
	}

	public Stock getObject(double price) {
		return new WalmartStock(price);
	}
}
