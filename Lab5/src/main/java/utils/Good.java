package utils;

import java.util.concurrent.ThreadLocalRandom;

public class Good {

    private String name;
    private String price;
    private String count;
    private String goodURL;
    public Good() {
        this.name = generateString();
        this.count = generateInt(1, 100);
        this.price = generateDouble(0.1, 100);
    }
    public Good(String name, String price, String count) {
        this.name = name;
        this.count = count;
        this.price = price;
    }
    public Good(String name, String price, String count, String URL) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.goodURL = URL;
    }
    private static String generateString() {
        return Double.toString(Math.random());
    }

    private static String generateInt(int min, int max) {
        return Integer.toString(Math.round(ThreadLocalRandom.current().nextInt(min, max)));
    }

    private static String generateDouble(double min, double max) {
        return Double.toString(Math.round(ThreadLocalRandom.current().nextDouble(min, max)*100)/100.0);
    }

    public String getName() {
        return name;
    }

    public String getCount() {
        return count;
    }

    public String getPrice() {
        return price;
    }

    public String getGoodURL() {
        return goodURL;
    }
}
