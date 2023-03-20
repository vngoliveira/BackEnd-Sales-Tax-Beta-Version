package org.sales.entity;

import org.sales.exceptions.GoodsNameIsEmptyOrNullExceptions;
import org.sales.exceptions.GoodsPriceLessThanZeroExceptions;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Goods {

    private BigDecimal price;
    private BigDecimal tax;
    private String name;

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        try {
            nullPrice(price);
        } catch (GoodsPriceLessThanZeroExceptions e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.exit(0);
        }
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        try {
            nullName(name);
        } catch (GoodsNameIsEmptyOrNullExceptions e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.exit(0);
        }
        this.name = name;
    }

    public BigDecimal resultSalesTax(BigDecimal price) {
        tax = price.multiply(BigDecimal.valueOf(0.1));
        tax = roundingRule(tax);
        return tax;
    }

    public BigDecimal resultImportedTax(BigDecimal price) {
        tax = price.multiply(BigDecimal.valueOf(0.05));
        tax = roundingRule(tax);
        return tax;
    }

    public BigDecimal resultAllTax(BigDecimal price) {
        tax = price.multiply(BigDecimal.valueOf(0.15));
        tax = roundingRule(tax);
        return tax;
    }

    public BigDecimal priceTaxed(BigDecimal price) {
        BigDecimal taxedPrice = price.add(tax);
        return taxedPrice;
    }

    public BigDecimal roundingRule(BigDecimal tax) {
        BigDecimal roundedTax = tax.multiply(BigDecimal.valueOf(20)).setScale(0, RoundingMode.CEILING);
        return roundedTax.multiply(BigDecimal.valueOf(0.05)).setScale(2, RoundingMode.CEILING);
    }

    public void nullName(String name) throws GoodsNameIsEmptyOrNullExceptions {
        if(name.isBlank() || name.isEmpty()) {
            throw new GoodsNameIsEmptyOrNullExceptions("A name is necessary for the product.");
        }
    }

    public void nullPrice(BigDecimal price) throws GoodsPriceLessThanZeroExceptions {
        if(price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new GoodsPriceLessThanZeroExceptions("Price should be than zero.");
        }
    }
}