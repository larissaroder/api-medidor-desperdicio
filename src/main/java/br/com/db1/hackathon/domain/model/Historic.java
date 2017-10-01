package br.com.db1.hackathon.domain.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "historic")
public class Historic implements Serializable {

    private static final long serialVersionUID = 232687659085191775L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String code;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column
    private String value;

    public Historic() {
        //Serializable
    }

    private Historic(Builder builder) {
        id = builder.id;
        code = builder.code;
        date = builder.date;
        value = builder.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public Date getDate() {
        return date;
    }

    public String getValue() {
        return value;
    }

    public static class Builder {

        private Long id;

        private String code;

        private Date date;

        private String value;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withCode(String code) {
            this.code = code;
            return this;
        }

        public Builder withDate(Date date) {
            this.date = date;
            return this;
        }

        public Builder withValue(String value) {
            this.value = value;
            return this;
        }

        public Historic build() {
            return new Historic(this);
        }
    }
}
