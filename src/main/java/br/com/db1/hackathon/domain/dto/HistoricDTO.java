package br.com.db1.hackathon.domain.dto;

import java.io.Serializable;
import java.util.Date;

public class HistoricDTO implements Serializable {

    private static final long serialVersionUID = -4707892081517378859L;

    private Long id;

    private String code;

    private Date date;

    private String value;

    public HistoricDTO() {
        //Serializable
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
