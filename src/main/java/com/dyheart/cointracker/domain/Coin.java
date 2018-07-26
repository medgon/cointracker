package com.dyheart.cointracker.domain;


import javax.persistence.*;

@Entity
@Table(name = "coin")
public class Coin {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "coin_id")
    private Long coinId;

    @Column(name = "coin_name")
    private String coinName;

    @Column(name = "coin_abbreviation")
    private String coinAbbreviation;


    public Coin() {

    }

    public Long getCoinId() {
        return coinId;
    }

    public void setCoinId(Long coinId) {
        this.coinId = coinId;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinAbbreviation() {
        return coinAbbreviation;
    }

    public void setCoinAbbreviation(String coinAbbreviation) {
        this.coinAbbreviation = coinAbbreviation;
    }

    @Override
    public String toString() {
        return "Coin{" +
                "coinId=" + coinId +
                ", coinName='" + coinName + '\'' +
                ", coinAbbreviation='" + coinAbbreviation + '\'' +
                '}';
    }
}
