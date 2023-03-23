package org.sales;

import org.junit.jupiter.api.Test;
import org.sales.enums.GoodsStatus;
import org.sales.exceptions.GoodsInvalidOptionExceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GoodsStatusTest {

    @Test
    public void testFromValue_ValidOption_ReturnsGoodsStatus() throws GoodsInvalidOptionExceptions {
        assertEquals(GoodsStatus.IMPORTED, GoodsStatus.fromValue(0));
        assertEquals(GoodsStatus.NATIONAL, GoodsStatus.fromValue(1));
    }
}
