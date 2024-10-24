package se.pbt.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Stock {
    private final String name;
    private final String instrumentId;
    private final int riskLevel;


    @JsonCreator
    public Stock(
            @JsonProperty("name") String name,
            @JsonProperty("instrumentId") String instrumentId,
            @JsonProperty("riskLevel") int riskLevel) {
        this.name = name;
        this.instrumentId = instrumentId;
        this.riskLevel = riskLevel;
    }

    public String getName() {
        return name;
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public int getRiskLevel() {
        return riskLevel;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "name='" + name + '\'' +
                ", instrumentId='" + instrumentId + '\'' +
                ", riskLevel=" + riskLevel +
                '}';
    }
}
