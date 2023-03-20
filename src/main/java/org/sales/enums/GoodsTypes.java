package org.sales;

import org.sales.exceptions.GoodsInvalidOptionExceptions;

public enum GoodsTypes {
    UNTAXED,
    TAXED;

    public static GoodsTypes fromValue(int goodsTypes) throws GoodsInvalidOptionExceptions {
        for (GoodsTypes type : values()) {
            if (type.ordinal() == goodsTypes) {
                return type;
            }
        }
        throw new GoodsInvalidOptionExceptions("Invalid input! The " + goodsTypes + " option doesn't exist for the product type.");
    }
}
