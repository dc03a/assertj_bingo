package org.iesvdm;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class utilesArraysTest {
    @Test
    void testLimpiar() {
        int[] array = new int[0];
        assertThat(UtilesArrays.limpiar().equals(array));
    }

    @Test
    void testRellenar() {

    }
}
