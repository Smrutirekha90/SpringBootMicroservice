package com.in28minutes.microservices.currencyexchangeservice.bean;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "EXCHANGE_VALUE")
public class ExchangeValue {
    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "FROM_VALUES")
    private String from;

    @Column(name = "TO_VALUES")
    private String to;

    @Column(name = "CONVERSION_MULTIPLE")
    private BigDecimal conversionMultiple;

    @Transient
    private int port;

    public ExchangeValue(Long id,String from, String to, BigDecimal conversionMultiple) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
    }
    public ExchangeValue(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversionMultiple() {
        return conversionMultiple;
    }

    public void setConversionMultiple(BigDecimal conversionMultiple) {
        this.conversionMultiple = conversionMultiple;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
