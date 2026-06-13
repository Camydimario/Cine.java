package Cine;

import java.util.Arrays;
//dada una clase cine se desea armar un programa que realize diferentes operaciones y devuelva lo que se necesita

/**
 * se crea una clase Cine que tiene como atributos un arrays de asientos int
 * [][] asientos.
 **/
public class Cine {

	private int[][] asientos;

//pre: los numeros de asientos no pueden ser negativos, todos deben ser mayores a cero
	public Cine() {

	}

//post: devuelve la suma total de todos los asientos
	public int sumarTodos(int[][] asientos) {
		int suma = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				suma += asientos[i][j];
				if (asientos[i][j] < 0) {
					throw new Error("no pueden haber asientos negativos");
				}
			}
		}
		return suma;
	}

//post:  devuelve la suma de cada fila de asientos
	public int[] sumarFilas(int[][] asientos) {

		int[] sumador = new int[asientos.length];

		for (int i = 0; i < asientos.length; i++) {
			int sumar = 0;
			for (int j = 0; j < asientos[i].length; j++) {
				sumar += asientos[i][j];

				sumador[i] = sumar;
			}

		}
		return sumador;

	}

//post : devuleve la suma de cada columna de asientos
	public int[] sumarColumnas(int[][] asientos) {

		int[] sumadorColumnas = new int[asientos[0].length];
		for (int j = 0; j < asientos[0].length; j++) {
			int sumar = 0;
			for (int i = 0; i < asientos.length; i++) {
				sumar += asientos[i][j];
			}
			sumadorColumnas[j] = sumar;
		}

		return sumadorColumnas;

	}

//pre : se calcula el promedio de los asientos, un promedio nunca puede ser negativo
//post: devuleve el promedio total de asientos
	public double promediarTodos(int[][] asientos) {
		double suma = 0;
		int cantidad = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				suma += asientos[i][j];
				cantidad++;
			}

		}

		return (double) suma / cantidad;
	}

//post: se promedian las filas 
	public int[] promediarFilas(int[][] asientos) {
		int[] promediarFilas = new int[asientos.length];
		for (int i = 0; i < asientos.length; i++) {
			int suma = 0;
			for (int j = 0; j < asientos[i].length; j++) {
				suma += asientos[i][j];
			}
			promediarFilas[i] = suma / asientos[i].length;
		}
		return promediarFilas;
	}

//post : se promedian las columnas
	public int[] promediasColumnas(int[][] asientos) {
		int[] promediarColumnas = new int[asientos[0].length];

		for (int j = 0; j < asientos[0].length; j++) {
			int sumar = 0;
			for (int i = 0; i < asientos.length; i++) {
				sumar += asientos[i][j];
			}
			promediarColumnas[j] = sumar / asientos.length;
		}

		return promediarColumnas;
	}

//pre: los promedios tienen un numero , pero se intenta saber la cantidad de aseintos que estan por ensima del promedio
//post : devuleven la cantidad de asientos que estan por ensima del promedio

	public int ensimaDelPromedio(int[][] asientos) {

		double suma = 0;
		int totalAsientos=0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				suma += asientos[i][j];
				totalAsientos++;
			}
		}
		double promedios = suma / totalAsientos ;

		int cantidadPorEnsima = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] > promedios) {
					cantidadPorEnsima++;
				}
			}
		}
		return cantidadPorEnsima;
	}

//pre: los numeros de asientos deben ser mayores a cero, nunca pueden ser negativos
//post: devuelve la cantidad de asientos del cine 

	public int cantidadDeAsientos(int[][] asientos) {
		int cantidadAsientos = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				
					cantidadAsientos++;
					if (asientos[i][j] < 0) {
						throw new Error("asiento invalid0");
					}

				}
			
		}
		return cantidadAsientos;
	}

//post: devueleve la cantidad de filas del cine 
	public int cantidadDeFilas(int[][] asientos) {
		int cantidadFilas = 0;
		for (int i = 0; i < asientos.length; i++) {

				cantidadFilas++;
			}

		return cantidadFilas;

	}

//post: devuelve la cantidad de Columnas del cine
	public int cantidadDeCOlumnas(int[][] asientos) {
		int cantidadColumnas = 0;
		for (int j = 0; j < asientos[0].length; j++) {
			cantidadColumnas++;
		}
		return cantidadColumnas;

	}

//pre: se calcula la suma de todos los asientos que tiene el cine, pero se ignora el asiento con el numero mas alto ya que ese es reserbao
//post : se devuelve la suma  de los asinentos menos el maximo

	public int SumarTodosMenosElMinimos(int[][] asientos) {

		int minimo = asientos[0][0];
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] < minimo) {
					minimo = asientos[i][j];
				}
			}
		}

		int sumar = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] != minimo) {
					sumar += asientos[i][j];
				}
			}
		}

		return sumar;

	}

//post: devolver la cantidad de asientos continuos

	public int CantidadDeAsientosContinuos(int[][] asientos) {
		int coontinuos = 0;
		int libres = 0;
		for (int i = 0; i < asientos.length; i++) {
			int filaActual = 0;
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] == libres) {
					filaActual++;
					if (filaActual > coontinuos) {
						coontinuos = filaActual;
					}
				} else {
					filaActual = 0;
				}
			}

		}
		return coontinuos;
	}

//post : devolver la posicion del asiento con el numero mas bajo
	public int[] posicionDelMasBajo(int[][] asientos) {
		int masbajo = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] < masbajo) {
					masbajo = asientos[i][j];
				}
			}
		}

		int[] posicionBajo = new int[2];
		posicionBajo[0] = 0;
		posicionBajo[1] = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] == masbajo) {
					posicionBajo[0] = i;
					posicionBajo[1] = j;
				}
			}

		}
		return posicionBajo;

	}

//post: devolver el asiento con el numero minimo
	public int minimo(int[][] asientos) {

		int minimo = asientos[0][0];
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] < minimo) {
					minimo = asientos[i][j];
				}
			}
		}
		return minimo;
	}

//post: devolver el asiento  con el nnumero maximo
	public int maximo(int[][] asientos) {

		int maximo = asientos[0][0];;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] > maximo) {
					maximo = asientos[i][j];
				}
			}
		}
		return maximo;

	}

//post: devolver la posicion del anteUtimo asiento del cine

	public int[] PosAnteUlitmo(int[][] asientos) {
		int buscarAnteUltimo = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] == asientos.length && asientos[i][j] == asientos[i].length - 1) {
					buscarAnteUltimo++;
				}
			}

		}
		int[] posicion = new int[2];
		posicion[0] = 0;
		posicion[1] = 0;
		for (int i = 0; i < asientos.length; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos[i][j] == buscarAnteUltimo) {
					posicion[0] = i;
					posicion[1] = j;
				}
			}
		}
		return posicion;
	}

//post: verifica si el cine es cuadrada

	public boolean esCuadrada(int[][] asientos) {
		boolean esCuadrada = false;
		for (int i = 0; i < asientos.length && !esCuadrada; i++) {
			for (int j = 0; j < asientos[i].length; j++) {
				if (asientos.length == asientos[i].length) {
					esCuadrada = true;
				}
			}
		}
		return esCuadrada;
	}

	public static void main(String[] args) {
		Cine cinesito = new Cine();
		int[][] asientos = {

				{ 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 9, 11, 13, 15 }, { 10, 12, 14, 16 },

		};

		System.out.println("Sumar Todos:" + cinesito.sumarTodos(asientos));

		int[] sumador = cinesito.sumarFilas(asientos);
		System.out.println("Sumar Filas:" + Arrays.toString(sumador));
		int[] sumadorColumnas = cinesito.sumarColumnas(asientos);
		System.out.println("Sumar Columnas:" + Arrays.toString(sumadorColumnas));

		System.out.println("Promedio Total:" + cinesito.promediarTodos(asientos));
		int[] promediarFilas = cinesito.promediarFilas(asientos);
		System.out.println("Promedio Filas:" + Arrays.toString(promediarFilas));

		int[] promediarColumnas = cinesito.promediasColumnas(asientos);

		System.out.println("Promediar Columnas:" + Arrays.toString(promediarColumnas));
		System.out.println("Cantidad Ensima Del promedio:" + cinesito.ensimaDelPromedio(asientos));

		System.out.println("Cantidad Total de asientos:" + cinesito.cantidadDeAsientos(asientos));
		System.out.println("Cantidad de filas del cine:" + cinesito.cantidadDeFilas(asientos));
		System.out.println("Cantidad de columnas del cine:" + cinesito.cantidadDeCOlumnas(asientos));
		System.out.println("Cantidad de asientos continuos:" + cinesito.CantidadDeAsientosContinuos(asientos));

		System.out.println("La suma de todos menos el minimo:" + cinesito.SumarTodosMenosElMinimos(asientos));

		int[] posicionBajo = cinesito.posicionDelMasBajo(asientos);
		System.out.println("Posicion del mas bajo:" + Arrays.toString(posicionBajo));

		System.out.println("Asiento minimo:" + cinesito.minimo(asientos));
		System.out.println("Asiento maximo:" + cinesito.maximo(asientos));
		int[] posicion = cinesito.PosAnteUlitmo(asientos);
		System.out.println("Posicion del ante ultimo :" + Arrays.toString(posicion));

		System.out.println("Es caudrada?:" + cinesito.esCuadrada(asientos));
//realizar las preubas correspondiente


package Cine;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CineTest {

	Cine cinesito;
	int[][] asientos = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 9, 11, 13, 15 }, { 10, 12, 14, 16 } };

	@BeforeEach
	void inicializar() {
		cinesito = new Cine();
	}

	@Test
	void testamosSumas() {
		assertEquals(136, cinesito.sumarTodos(asientos));
	}

	@Test
	void testearMinimo() {
		int minimo = 1;
		int esperado = cinesito.minimo(asientos);
		assertEquals(minimo, esperado);
	}
	
   @Test
   void esCuadrada () {
	   boolean esCuadrada = cinesito.esCuadrada(asientos);
	   assertTrue(esCuadrada);
   }
	
	@Test
	
	void noEsCaudrada() {
		boolean NoesCuadrada = cinesito.esCuadrada(asientos);
		assertTrue(NoesCuadrada);
	}
	
	
	@Test
	void testeamosPromedio() {
		assertEquals(8.5, cinesito.promediarTodos(asientos), 0.01);
	}
	
	@Test
	
	void testeamosError() {
		Cine cinesito2 = new Cine();
		
		int [][] asientos = { {1,0,-1,9}};
	
		assertThrows (Error.class , () -> cinesito2.sumarTodos(asientos));
		
	}
	
	@Test
	void testearEnsimaDelPromedio () {
		int hay = 8;
		int esperado = cinesito.ensimaDelPromedio(asientos);
		
		assertEquals(hay, esperado);
	}
	
	
}


    
	}

}








