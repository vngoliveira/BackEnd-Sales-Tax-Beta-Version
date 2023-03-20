package org.sales;
import org.junit.jupiter.api.Test;
import org.sales.exceptions.GoodsInvalidOptionExceptions;

import static org.junit.jupiter.api.Assertions.*;

public class GoodsTypesTest {

    @Test
    public void testFromValue_ValidOption_ReturnsGoodsType() throws GoodsInvalidOptionExceptions {
        assertEquals(GoodsTypes.UNTAXED, GoodsTypes.fromValue(0));
        assertEquals(GoodsTypes.TAXED, GoodsTypes.fromValue(1));
    }

    @Test
    public void testFromValue_InvalidOption_ThrowsGoodsInvalidOptionExceptions() {
        assertThrows(GoodsInvalidOptionExceptions.class, () -> GoodsTypes.fromValue(-1));
        assertThrows(GoodsInvalidOptionExceptions.class, () -> GoodsTypes.fromValue(2));
    }

}
