package org.iesvdm;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class bingoTest {
    @Test
    void testRellenarNumerosCarton() {
        int[][] carton = new int[9][3];
        Bingo.rellenarNumerosCarton(carton);

        for (int i = 0; i < carton.length; i++) {
            assertTrue(isSorted(carton[i]));
        }
    }

    @Test
    void testPonerBlancos() {
        int[][] carton = new int[9][3];
        Bingo.rellenarNumerosCarton(carton);
        Bingo.ponerBlancos(carton);

        for (int i = 0; i < carton[0].length; i++) {
            int contadorBlancos = 0;
            for (int j = 0; j < carton.length; j++) {
                if (carton[j][i] == -1) {
                    contadorBlancos++;
                }
            }
            assertEquals(4, contadorBlancos);
        }
    }

    //En el test PonerBlancos creo que hay un error en el metodo porque se sale
    //rango del array y creo que se estan mezclando las filas con las columnas.

    //En los tests de BuscarFila y BuscarColumna hay un fallo que
    // no se a que se refiere en IntelliJ en clase te preguntare.

    @Test
    void testBuscarFila() {
        int[][] carton = {{1, 2, 3}, {-1, 5, 6}, {7, -1, 9}, {10, 11, 12}, {13, 14, 15}, {16, 17, 18}, {19, 20, 21}, {22, 23, 24}, {25, 26, 27}};
        assertTrue(Bingo.buscarFila(carton, 1, 0));
        assertFalse(Bingo.buscarFila(carton, 2, 1));
    }

    @Test
    void testBuscarColumna() {
        int[][] carton = {{1, 2, -1}, {4, -1, 6}, {7, 8, 9}, {-1, 11, -1}, {13, 14, 15}, {16, -1, 18}, {19, 20, 21}, {22, 23, 24}, {25, 26, 27}};
        assertTrue(Bingo.buscarColumna(carton, 0));
        assertFalse(Bingo.buscarColumna(carton, 1));
    }

    @Test
    void testBuscarValorRepetido() {
        int[] array = {1, 2, 3, 4, 5};
        assertTrue(Bingo.buscarValorRepetido(array, 3));
        assertFalse(Bingo.buscarValorRepetido(array, 6));
    }

    @Test
    void testPintarCarton() {
        int[][] carton = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}, {16, 17, 18}, {19, 20, 21}, {22, 23, 24},  {25, 26, 27}};
        int[] bolas = {1, 3, 5, 7, 9};
        int aciertos = Bingo.pintarCarton(carton, bolas);
        assertEquals(5, aciertos);
    }

    @Test
    void testInsertarAlFinal() {
        int[] array = {1, 2, 3};
        int[] nuevoArray = Bingo.insertarAlFinal(array, 4);
        assertArrayEquals(new int[]{1, 2, 3, 4}, nuevoArray);
    }

    private boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
