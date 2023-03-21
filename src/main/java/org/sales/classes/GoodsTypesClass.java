package org.sales.classes;
import org.sales.GoodsTypes;
import org.sales.entity.Goods;
import org.sales.exceptions.GoodsInvalidOptionExceptions;

import java.util.Scanner;

public class GoodsTypesClass {

    GoodsTypes goodsTypes;

    public GoodsTypesClass(int goodsTypes) throws GoodsInvalidOptionExceptions {
        this.goodsTypes = GoodsTypes.fromValue(goodsTypes);
  }

    public void chooseType(Goods goods) {
        Scanner scanner = new Scanner(System.in);
        switch (goodsTypes) {
            case UNTAXED -> {
                System.out.println("Non-taxable product");
                System.out.print("Set a name to product: ");
                goods.setName(scanner.nextLine());
                System.out.println();
            }
            case TAXED -> {
                System.out.println("Taxable product");
                System.out.print("Set a name to product: ");
                goods.setName(scanner.nextLine());
                System.out.println();
            }
        }
    }
}
