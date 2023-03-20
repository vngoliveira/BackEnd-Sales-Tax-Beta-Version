package org.sales;
import org.sales.classes.GoodsStatusClass;
import org.sales.classes.GoodsTypesClass;
import org.sales.entity.Goods;
import org.sales.exceptions.GoodsInvalidOptionExceptions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Goods goods = new Goods();

        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        BigDecimal tax = new BigDecimal("0.0");
        BigDecimal totalPrice = new BigDecimal("0.0");

        ArrayList<BigDecimal> taxedPrice = new ArrayList<>();
        ArrayList<String> productName = new ArrayList<>();

        boolean exit;

        try{
            do {
                System.out.println("Only foods, books, or drugs are untaxed products. The others are taxed.");
                System.out.println();
                listTypes();
                System.out.println();
                System.out.print("Set the product type according to the specification above: ");
                String typeString = scanner.nextLine();
                int typeValue = isInteger(typeString);
                System.out.println();
                GoodsTypesClass goodsTypesClass = new GoodsTypesClass(typeValue);
                goodsTypesClass.chooseType(goods);

                listStatus();
                System.out.println();
                System.out.print("Set the product origin according to the options above: ");
                String originString = scanner.nextLine();
                int originValue = isInteger(originString);
                System.out.println();
                GoodsStatusClass goodsStatusClass = new GoodsStatusClass(originValue);
                System.out.println();
                if(typeValue == 1) {
                    goodsStatusClass.chooseStatusTaxed(goods);
                } else {
                    goodsStatusClass.chooseStatusUntaxed(goods);
                }
                tax = tax.add(goodsStatusClass.tax());
                taxedPrice.add(goodsStatusClass.taxedPrice());
                productName.add(goodsStatusClass.productName());

                System.out.println();
                System.out.print("Would you like to add some more? Set 1 to 'yes' or any other number to no: ");
                String outString = scanner.nextLine();
                int outValue = isInteger(outString);

                exit = outValue == 1;

            }while (exit);

        System.out.println();

        for (int i = 0; i < taxedPrice.size(); i++) {
            String name = productName.get(i);
            BigDecimal value = taxedPrice.get(i);

            System.out.println(name + ": " + value);

            totalPrice = totalPrice.add(value);
        }

        System.out.println("Sales Taxes: " + tax);
        System.out.println("Total: " + totalPrice);

        } catch (GoodsInvalidOptionExceptions e) {
            System.out.println(e.getMessage());
        }

    }

    public static void listStatus() {
        for (GoodsStatus goodsStatus : GoodsStatus.values()) {
            System.out.println(goodsStatus.ordinal() + " - " + goodsStatus);
        }
    }

    public static void listTypes() {
        for (GoodsTypes goodsTypes : GoodsTypes.values()) {
            System.out.println(goodsTypes.ordinal() + " - " + goodsTypes);
        }
    }

    public static int isInteger(String string) throws NumberFormatException {
        int value = 0;
        try {
             value = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            System.out.println();
            System.out.println("Invalid input, it's not a number! Only set integer numbers");
            System.exit(0);
        }
        return value;
    }
}