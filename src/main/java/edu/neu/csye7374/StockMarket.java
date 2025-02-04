package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
	private static StockMarket instance;
	private List<Stock> stocks = new ArrayList<>();
	private StockMarket() {

		instance = null;
	}
	private static List<Double> bidList = new ArrayList<>();
	public static StockMarket getInstance() {

		if (instance == null) {
			instance = new StockMarket();
		}
		return instance;
	}
	public Stock getStockItem(String name, double price, String description) {

		return new Stock(name, price, description);
	}
	public void add(Stock stock) {

		stocks.add(stock);
	}
	public void remove(Stock s) {

		boolean removed = this.stocks.remove(s);
		if (!removed) {
			System.out.println("stock not found");
		}
	}
	public void displayStocks() {

		for (Stock s : this.stocks) {
			System.out.println(s.toString());
		}
		//this.stocks.clear();
	}
	public void updatePrice(Stock s, double price) {

		if (this.stocks.contains(s)) {
			s.setPrice(price);
			return;
		}
		System.out.println("stock not found");
	}
	public static void demo() {

		System.out.println("");
		BearMarketStrategy bearMarketStrategy = new BearMarketStrategy();
		BullMarketStrategyLazySingleTon bullMarketStrategyLazySingleTon = BullMarketStrategyLazySingleTon.getInstance();
		/*MicrosoftStock microsoftStock = new MicrosoftStock(100);
		WalmartStock walmartStock = new WalmartStock(60);
		StockMarket.getInstance().add(walmartStock);
		StockMarket.getInstance().add(microsoftStock);*/

		/*
		 *
		 * Stock Strategy assignment
		 */
		Stock walmartStock1 = new WalmartStockFactory().getObject(100.0);
		Stock microsoftStock1 = new MicrosoftStockFactory().getObject(87.0);
		StockMarket.getInstance().add(walmartStock1);
		StockMarket.getInstance().add(microsoftStock1);
		System.out.println("\nStock strategy demo...");
		System.out.println("\nBearish...");
		bidList.add(10.0);
		bidList.add(20.0);
		bidList.add(14.0);
		bidList.add(18.0);
		walmartStock1.setBid(bidList,bearMarketStrategy);
        bidList.clear();
		bidList.add(15.0);
		bidList.add(35.0);
		bidList.add(55.0);
		bidList.add(47.0);
		microsoftStock1.setBid(bidList,bearMarketStrategy);

		StockMarket.getInstance().displayStocks();
		bidList.clear();
		System.out.println("\nBullish...");
		bidList.add(25.0);
		bidList.add(37.0);
		bidList.add(65.0);
		bidList.add(56.0);
		walmartStock1.setBid(bidList,bearMarketStrategy);
		bidList.clear();
		bidList.add(60.0);
		bidList.add(80.0);
		bidList.add(74.0);
		bidList.add(65.0);
		microsoftStock1.setBid(bidList,bullMarketStrategyLazySingleTon);
		StockMarket.getInstance().displayStocks();
		bidList.clear();






/*		walmartStock.setBid(10);
		
		walmartStock.setBid(40);
		
		walmartStock.setBid(50);

		walmartStock.setBid(60);
		
		walmartStock.setBid(70);
		
		walmartStock.setBid(80);
		
		walmartStock.getMetric();
		
		microsoftStock.setBid(10);
		
		microsoftStock.setBid(40);
		
		microsoftStock.setBid(50);

		microsoftStock.setBid(60);
		
		microsoftStock.setBid(70);
		
		microsoftStock.setBid(80);
		
		microsoftStock.getMetric();
		
		StockMarket.getInstance().displayStocks();*/

		/*
		 * 
		 * Lazy and Eager Factory assignment
		 */
		System.out.println("\nLazy and Eager Factory demo...");
		Stock walStock = WalmartStockFactoryLazy.getInstance().getObject(100.0);
		Stock microStock = MicrosoftStockFactoryEager.getInstance().getObject(87.0);
		StockMarket.getInstance().add(walStock);
		StockMarket.getInstance().add(microStock);
		walStock.setBid(10);
		walStock.setBid(40);
		walStock.setBid(50);
		walStock.setBid(60);
		walStock.setBid(70);
		walStock.setBid(80);
		walStock.getMetric();
		microStock.setBid(10);
		microStock.setBid(40);
		microStock.setBid(50);
		microStock.setBid(60);
		microStock.setBid(70);
		microStock.setBid(80);
		microStock.getMetric();
		StockMarket.getInstance().displayStocks();

		/*
		 * 
		 * Factory assignment
		 */
		System.out.println("\nFactory demo...");
		Stock wallStock = new WalmartStockFactory().getObject(100.0);
		Stock microoStock = new MicrosoftStockFactory().getObject(87.0);
		StockMarket.getInstance().add(wallStock);
		StockMarket.getInstance().add(microoStock);
		wallStock.setBid(10);
		wallStock.setBid(40);
		wallStock.setBid(50);
		wallStock.setBid(60);
		wallStock.setBid(70);
		wallStock.setBid(80);
		wallStock.getMetric();
		microoStock.setBid(10);
		microoStock.setBid(40);
		microoStock.setBid(50);
		microoStock.setBid(60);
		microoStock.setBid(70);
		microoStock.setBid(80);
		microoStock.getMetric();
		StockMarket.getInstance().displayStocks();
	}
}
