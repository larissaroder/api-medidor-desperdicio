package br.com.db1.hackathon.domain.dto;

import java.io.Serializable;

public class DashboardDTO implements Serializable {
    private static final long serialVersionUID = -1259175122559854720L;

    private PlaceDTO place;


    public DashboardDTO() {
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

}
