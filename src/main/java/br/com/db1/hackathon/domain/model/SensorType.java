package br.com.db1.hackathon.domain.model;

public enum SensorType {

    PLUVIOMETER(0, "Pluviômetro", ""),
    ELETRIC_CURRENT(1, "Energia Elétrica", "A"),
    DISTANCE(2, "Distância", "cm");

    private Integer code;
    private String description;
    private String unit;

    SensorType(Integer code, String description, String unit) {
        this.code = code;
        this.description = description;
        this.unit = unit;
    }

    public Integer getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getUnit() {
        return unit;
    }
}
