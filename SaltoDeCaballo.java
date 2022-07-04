import java.text.DecimalFormat;




public class SaltoDeCaballo {

    // Se sustituyeron los arreglos horizontal[] y vertical[] por una matriz solucion[][] que ahora líneas de código

	int[][] solucion; 
	int paso = 0;

	public SaltoDeCaballo(int n) { 
        solucion = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                solucion[i][j] = 0;
            }
        }
	}
    
	public void resuelve() { 
        if (encontrarPosicion(5, 6, 0, solucion.length)) 
            mostrarResultado();
        else {
            System.out.println("NO HAY SOLUCIÓN POSIBLE");
        }
	}

	private boolean encontrarPosicion(int fila, int columna, int index, int n) {
        if (solucion[fila][columna]!=0){
            return false; 
        }
        solucion[fila][columna] = paso++;
        if (index==n*n-1){ 
            return true;
        }
        
        if (esMovimientoPosible(fila + 2, columna + 1, n) && encontrarPosicion(fila + 2, columna + 1, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila + 1, columna + 2, n) && encontrarPosicion(fila + 1, columna + 2, index + 1, n)) 
            return true; 
        if (esMovimientoPosible(fila - 1, columna + 2, n) && encontrarPosicion(fila - 1, columna + 2, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila - 2, columna + 1, n) && encontrarPosicion(fila - 2, columna + 1, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila - 2, columna - 1, n) && encontrarPosicion(fila - 2, columna - 1, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila - 1, columna - 2, n) && encontrarPosicion(fila - 1, columna - 2, index + 1, n))
            return true; 
        if (esMovimientoPosible(fila + 1, columna - 2, n) && encontrarPosicion(fila + 1, columna - 2, index + 1, n))
            return true;
        if (esMovimientoPosible(fila + 2, columna - 1, n) && encontrarPosicion(fila + 2, columna - 1, index + 1, n))
            return true; 
        
        solucion[fila][columna] = 0;
        paso--;
        return false;
	}

	private boolean esMovimientoPosible(int fila, int col, int N){
        if (fila>=0 && col>=0 && fila<N && col<N){ 
            return true; 
        }
        return false; 
	}

	private void mostrarResultado() { 
        DecimalFormat dosDigitos = new DecimalFormat("00"); 
        for (int i=0; i<solucion.length; i++){ 
            for (int j=0; j<solucion.length; j++){
                System.out.print("   " + dosDigitos.format(solucion[i][j]));
            }
            System.out.println();
        }
	}

	public static void main(String[] args) {
        int n = 8;
        SaltoDeCaballo i = new SaltoDeCaballo(n);
        i.resuelve();
	}

}