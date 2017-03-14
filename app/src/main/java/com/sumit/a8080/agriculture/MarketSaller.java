package com.sumit.a8080.agriculture;

/**
 * Created by DELL on 29-01-2017.
 */

public class MarketSaller {
    private String Mandi;
    private String price;
    private String date;
    private String Commodity;

    public MarketSaller(String Mandi, String price, String date, String Commodity) {
        this.Mandi = Mandi;
        this.price = price;
        this.date = date;
        this.Commodity = Commodity;
    }

    public String getCommodity() {
        return Commodity;
    }

    public String getDate() {
        return date;
    }

    public String getMandi() {
        return Mandi;
    }

    public String getPrice() {
        return price;
    }

}
