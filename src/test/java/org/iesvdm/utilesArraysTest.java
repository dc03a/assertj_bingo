package org.iesvdm;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class utilesArraysTest {
    @Test
    public void testLimpiar() {
        int[] arrayVacio = UtilesArrays.limpiar();
        assertThat(arrayVacio).isEmpty();
    }

    @Test
    public void testRellenarConCeros() {
        int[] arrayCeros = UtilesArrays.rellenar(new int[5], 0);

        for (int i = 0; i < arrayCeros.length; i++) {
            if (arrayCeros[i] != 0) {
                fail("Error: El valor en la posición " + i + " es " + arrayCeros[i] + ", no 0");
            }
        }
    }

    @Test
    public void testRellenarConValorEspecifico() {
        int[] arraySiete = UtilesArrays.rellenar(new int[10], 7);

        for (int i = 0; i < arraySiete.length; i++) {
            if (arraySiete[i] != 7) {
                fail("Error: El valor en la posición " + i + " es " + arraySiete[i] + ", no 7");
            }
        }
    }

    @Test
    public void testInsertarAlFinal() {
        int[] arrayOriginal = {1, 2, 3, 4};
        int elementoNuevo = 5;
        int[] arrayConElementoNuevo = UtilesArrays.insertarAlFinal(arrayOriginal, elementoNuevo);

        assertThat(arrayConElementoNuevo).hasSize(5);
        for (int i = 0; i < arrayOriginal.length; i++) {
            assertThat(arrayConElementoNuevo[i]).isEqualTo(arrayOriginal[i]);
        }
        assertThat(arrayConElementoNuevo[arrayConElementoNuevo.length - 1]).isEqualTo(elementoNuevo);
    }

    @Test
    public void testInsertarAlPrincipio() {
        int[] arrayOriginal = {1, 2, 3, 4};
        int elementoNuevo = 0;
        int[] arrayConElementoNuevo = UtilesArrays.insertarAlPrincipio(arrayOriginal, elementoNuevo);

        assertThat(arrayConElementoNuevo).hasSize(5);
        assertThat(arrayConElementoNuevo[0]).isEqualTo(elementoNuevo);
        for (int i = 1; i < arrayConElementoNuevo.length; i++) {
            assertThat(arrayConElementoNuevo[i]).isEqualTo(arrayOriginal[i - 1]);
        }
    }

    @Test
    public void testInsertarEnPosicion() {
        int[] arrayOriginal = {1, 2, 3, 4};
        int elementoNuevo = 5;
        int posicion = 2;
        int[] arrayConElementoNuevo = UtilesArrays.insertarEnPosicion(arrayOriginal, elementoNuevo, posicion);

        assertThat(arrayConElementoNuevo).hasSize(5);
        for (int i = 0; i < posicion; i++) {
            assertThat(arrayConElementoNuevo[i]).isEqualTo(arrayOriginal[i]);
        }
        assertThat(arrayConElementoNuevo[posicion]).isEqualTo(elementoNuevo);
        for (int i = posicion + 1; i < arrayConElementoNuevo.length; i++) {
            assertThat(arrayConElementoNuevo[i]).isEqualTo(arrayOriginal[i - 1]);
        }
    }

    @Test
    public void testInsertarOrdenado() {
        int[] arrayOriginal = {3, 1, 5, 4, 2};
        int elementoNuevo = 0;
        int[] arrayConElementoNuevoOrdenado = UtilesArrays.insertarOrdenado(arrayOriginal, elementoNuevo);

        assertThat(arrayConElementoNuevoOrdenado).hasSize(6);
        assertThat(arrayConElementoNuevoOrdenado).isSorted();
    }

    @Test
    public void testEliminarUltimo() {
        int[] arrayOriginal = {1, 2, 3, 4};
        int[] arraySinUltimoEsperado = {1, 2, 3};

        int[] arraySinUltimo = UtilesArrays.eliminarUltimo(arrayOriginal);
        assertThat(arraySinUltimo).isEqualTo(arraySinUltimoEsperado);
    }


    @Test
    public void testEliminarPrimero() {
        int[] arrayOriginal = {1, 2, 3, 4};
        int[] arraySinPrimerEsperado = {2, 3, 4};
        int[] arraySinPrimero = UtilesArrays.eliminarPrimero(arrayOriginal);

        assertThat(arraySinPrimero).isEqualTo(arraySinPrimerEsperado);
    }

    @Test
    public void testEliminarPosicion() {
        int[] arrayOriginal = {1, 2, 3, 4};
        int posicion = 2;
        int[] arraySinPosicionEsperado = {1, 2, 4};
        int[] arraySinPosicion = UtilesArrays.eliminarPosicion(arrayOriginal, posicion);

        assertThat(arraySinPosicion).hasSize(3);
        assertThat(arraySinPosicion).isEqualTo(arraySinPosicionEsperado);
    }

    @Test
    public void testEliminar() {
        int[] arrayOriginal = {1, 2, 3, 4, 3, 2};
        int elemento = 3;
        int[] arraySinElementoEsperado = {1, 2, 4, 2};
        int[] arraySinElemento = UtilesArrays.eliminar(arrayOriginal, elemento);

        assertThat(arraySinElemento).hasSize(arraySinElementoEsperado.length);
        assertThat(arraySinElemento).containsExactlyInAnyOrder(arraySinElementoEsperado);
    }

    @Test
    public void testOrdenar() {
        int[] arrayDesordenado = {5, 1, 4, 3, 2};
        int[] arrayOrdenado = UtilesArrays.ordenar(arrayDesordenado);

        assertThat(arrayOrdenado).isSorted();
    }

    @Test
    public void testDesordenar() {
        int[] arrayOrdenado = {1, 2, 3, 4, 5};
        UtilesArrays.desordenar(arrayOrdenado);

        assertThat(arrayOrdenado).isNotEqualTo(UtilesArrays.ordenar(arrayOrdenado));
    }

    @Test
    public void testInvertir() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int[] arrayInvertidoEsperado = {5, 4, 3, 2, 1};
        int[] arrayInvertido = UtilesArrays.invertir(arrayOriginal);

        assertThat(arrayInvertido).isEqualTo(arrayInvertidoEsperado);
    }

    @Test
    public void testEstaOrdenado() {
        int[] arrayOrdenado = {1, 2, 3, 4, 5};
        int[] arrayDesordenado = {5, 1, 4, 3, 2};

        assertThat(UtilesArrays.estaOrdenado(arrayOrdenado)).isTrue();
        assertThat(UtilesArrays.estaOrdenado(arrayDesordenado)).isFalse();
    }

    @Test
    public void testBuscarElementoExistente() {
        int[] array = {1, 2, 3, 4, 5};
        int elemento = 3;

        int posicion = UtilesArrays.buscar(array, elemento);
        assertThat(posicion).isEqualTo(2);
    }

    @Test
    public void testBuscarElementoNoExistente() {
        int[] array = {1, 2, 3, 4, 5};
        int elemento = 6;

        int posicion = UtilesArrays.buscar(array, elemento);
        assertThat(posicion).isEqualTo(-1);
    }

    @Test
    public void testPartirPor() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int posicionInicio = 2;
        int posicionCorte = 4;

        int[] arrayParcial = UtilesArrays.partirPor(arrayOriginal, posicionInicio, posicionCorte);
        assertThat(arrayParcial).hasSize(2);
        assertThat(arrayParcial).containsExactly(3, 4);
    }

    @Test
    public void testPartirPorPosicionFinalFueraDeRango() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int posicionInicio = 2;
        int posicionCorte = 6;

        int[] arrayParcial = UtilesArrays.partirPor(arrayOriginal, posicionInicio, posicionCorte);
        assertThat(arrayParcial).hasSize(0);
    }

    @Test
    public void testPartirPorPosicionInicioFueraDeRango() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int posicionInicio = 6;
        int posicionCorte = 4;

        int[] arrayParcial = UtilesArrays.partirPor(arrayOriginal, posicionInicio, posicionCorte);
        assertThat(arrayParcial).hasSize(0);
    }

    @Test
    public void testPartirPorPosicionInicioIgualPosicionCorte() {
        int[] arrayOriginal = {1, 2, 3, 4, 5};
        int posicionInicio = 3;
        int posicionCorte = 3;

        int[] arrayParcial = UtilesArrays.partirPor(arrayOriginal, posicionInicio, posicionCorte);
        assertThat(arrayParcial).hasSize(0);
    }

    @Test
    public void testSonIguales() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        int[] array3 = {4, 5, 6};

        assertThat(UtilesArrays.sonIguales(array1, array2)).isTrue();
        assertThat(UtilesArrays.sonIguales(array1, array3)).isFalse();
    }

    @Test
    public void testConcatenarArrays() {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5, 6};

        int[] arrayConcatenado = UtilesArrays.concatenarArrays(array1, array2);
        assertThat(arrayConcatenado).hasSize(6);
        assertThat(arrayConcatenado).containsSequence(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void testConcatenarArraysNoModificaOriginales() {
        int[] array1Original = {1, 2, 3};
        int[] array2Original = {4, 5, 6};

        int[] arrayConcatenado = UtilesArrays.concatenarArrays(array1Original.clone(), array2Original.clone());

        assertThat(array1Original).hasSize(3);
        assertThat(array1Original).containsSequence(1, 2, 3);
        assertThat(array2Original).hasSize(3);
        assertThat(array2Original).containsSequence(4, 5, 6);
        assertThat(arrayConcatenado).hasSize(6);
        assertThat(arrayConcatenado).containsSequence(1, 2, 3, 4, 5, 6);
    }
}
