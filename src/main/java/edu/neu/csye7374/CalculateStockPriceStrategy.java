package edu.neu.csye7374;

import java.util.List;

public interface CalculateStockPriceStrategy {
	double calculatePrice(List<Double> bid);
}
