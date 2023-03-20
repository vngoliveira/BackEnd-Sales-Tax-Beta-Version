package org.sales;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sales.classes.GoodsStatusClass;
import org.sales.classes.GoodsTypesClass;
import org.sales.entity.Goods;
import org.sales.exceptions.GoodsInvalidOptionExceptions;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class MainTest {

    Main main;
    Goods goods;
    GoodsTypesClass goodsTypesClass1;
    GoodsTypesClass goodsTypesClass2;
    GoodsTypesClass goodsTypesClass3;
    GoodsTypesClass goodsTypesClass4;
    GoodsStatusClass goodsStatusClass1;
    GoodsStatusClass goodsStatusClass2;
    GoodsStatusClass goodsStatusClass3;
    GoodsStatusClass goodsStatusClass4;
    BigDecimal price1;
    BigDecimal price2;
    BigDecimal price3;
    BigDecimal price4;
    BigDecimal expectedPrice1;
    BigDecimal expectedPrice2;
    BigDecimal expectedPrice3;
    BigDecimal expectedPrice4;
    BigDecimal expectedTax;
    ArrayList<BigDecimal> expectedTaxedPrices;
    Scanner scanner;

    @BeforeEach
    void setUp(){
        scanner = new Scanner("product");
    }

    @Test
    void firstExampleInput() throws GoodsInvalidOptionExceptions {
        goods = new Goods();
        goodsTypesClass1 = new GoodsTypesClass(0);
        goodsTypesClass2 = new GoodsTypesClass(1);
        goodsTypesClass3 = new GoodsTypesClass(0);
        goodsStatusClass1 = new GoodsStatusClass(1);
        goodsStatusClass2 = new GoodsStatusClass(1);
        goodsStatusClass3 = new GoodsStatusClass(1);
        price1 = BigDecimal.valueOf(12.49);
        price2 = BigDecimal.valueOf(14.99);
        price3 = BigDecimal.valueOf(0.85);
        expectedTax = BigDecimal.valueOf(1.50);

        goodsTypesClass1.chooseType(goods);
        goods.setName(String.valueOf(scanner));
        goodsStatusClass1.chooseStatusUntaxed(goods);
        goods.setPrice(price1);
    }
}
