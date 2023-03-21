package org.sales.classes;

import org.sales.GoodsStatus;
import org.sales.entity.Goods;
import org.sales.exceptions.GoodsInvalidOptionExceptions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class GoodsStatusClass {

    GoodsStatus goodsStatus;

    public GoodsStatusClass(int goodsStatus) throws GoodsInvalidOptionExceptions {
        this.goodsStatus = GoodsStatus.fromValue(goodsStatus);
    }

    Scanner scanner = new Scanner(System.in);

    ArrayList<BigDecimal> tax = new ArrayList<>();
    ArrayList<BigDecimal> taxedPrice = new ArrayList<>();
    ArrayList<String> productName = new ArrayList<>();

    public void chooseStatusUntaxed(Goods goods) {
        switch (goodsStatus) {
            case IMPORTED -> {
                System.out.println("Non-taxable imported product");
                System.out.print("Set the product price: ");
                String string = scanner.nextLine();
                BigDecimal input = isDouble(string);
                goods.setPrice(input);
                tax.add(goods.resultImportedTax(goods.getPrice()));
                taxedPrice.add(goods.priceTaxed(goods.getPrice()));
                goods.setName("imported " + goods.getName());
                productName.add(goods.getName());
            }
            case NATIONAL -> {
                System.out.println("Non-taxable national product");
                System.out.print("Set the product price: ");
                String string = scanner.nextLine();
                BigDecimal input = isDouble(string);
                goods.setPrice(input);
                taxedPrice.add(goods.getPrice());
                productName.add(goods.getName());
            }
        }
    }

    public void chooseStatusTaxed(Goods goods) {

        switch (goodsStatus) {
            case IMPORTED -> {
                System.out.println("Taxable imported product");
                System.out.print("Set the product price: ");
                String string = scanner.nextLine();
                BigDecimal input = isDouble(string);
                goods.setPrice(input);
                tax.add(goods.resultAllTax(goods.getPrice()));
                taxedPrice.add(goods.priceTaxed(goods.getPrice()));
                goods.setName("imported " + goods.getName());
                productName.add(goods.getName());
            }
            case NATIONAL -> {
                System.out.println("Taxable national product");
                System.out.print("Set the product price: ");
                String string = scanner.nextLine();
                BigDecimal input = isDouble(string);
                goods.setPrice(input);
                tax.add(goods.resultSalesTax(goods.getPrice()));
                taxedPrice.add(goods.priceTaxed(goods.getPrice()));
                productName.add(goods.getName());
            }
        }
    }

    public BigDecimal tax() {
        BigDecimal rate = new BigDecimal("0");
        for (BigDecimal value : tax) {
            rate = value;
        }
        return rate;
    }

    public BigDecimal taxedPrice() {
        BigDecimal taxed = new BigDecimal("0");
        for (BigDecimal value : taxedPrice) {
            taxed = value;
        }
        return taxed;
    }

    public String productName() {
        String name = null;
        for (String value : productName) {
            name = value;
        }
        return name;
    }

    public static BigDecimal isDouble(String string) throws NumberFormatException {
        try {
            double input = Double.parseDouble(string);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid input, it's not a number! Only set integer numbers or decimal numbers.");
            System.exit(0);
        }
        BigDecimal value = new BigDecimal(string);
        return value;
    }
}
