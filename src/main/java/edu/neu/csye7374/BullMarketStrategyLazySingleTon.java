package edu.neu.csye7374;

import java.util.List;

public class BullMarketStrategyLazySingleTon implements CalculateStockPriceStrategy {
    private static BullMarketStrategyLazySingleTon instance = null;

    private BullMarketStrategyLazySingleTon() {

    }
    public static BullMarketStrategyLazySingleTon getInstance() {
        if(instance == null) {
            instance = new BullMarketStrategyLazySingleTon();
        }
        return instance;

    }
    @Override
    public double calculatePrice(List<Double> bid) {

        double avg = 0.0;
        for(double b : bid) {
            avg+= b;
        }
        avg = avg/bid.size() * 1.3;
        return avg;
    }
}
