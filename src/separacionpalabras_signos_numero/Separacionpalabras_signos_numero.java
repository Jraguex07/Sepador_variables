
package separacionpalabras_signos_numero;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Separacionpalabras_signos_numero {

    public static void main(String[] args) {
        String nombreArchivo = "D:\\SEMESTRE 6\\COMPILADORES\\JAVA\\DATA.txt";
        List<String> numeros = new ArrayList<>();
        List<String> signos = new ArrayList<>();
        List<String> palabras = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                separarElementos(linea, numeros, signos, palabras);
            }

            System.out.println("Numeros encontrados en el archivo: " + numeros);
            System.out.println("Signos encontrados en el archivo: " + signos);
            System.out.println("Palabras encontradas en el archivo: " + palabras);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    }

    private static void separarElementos(String linea, List<String> numeros, List<String> signos, List<String> palabras) {
        if (linea == null || linea.isEmpty()) {
            return;
        }

        String[] elementos = linea.trim().split("\\s+");

        for (String elemento : elementos) {
            if (esNumero(elemento)) {
                numeros.add(elemento);
            } else if (esSigno(elemento)) {
                signos.add(elemento);
            } else {
                palabras.add(elemento);
            }
        }
    }

    private static boolean esNumero(String elemento) {
        return elemento.matches("-?\\d+(\\.\\d+)?"); 
    }

    private static boolean esSigno(String elemento) {
        return elemento.matches("[^a-zA-Z0-9]+"); 
    }
}

