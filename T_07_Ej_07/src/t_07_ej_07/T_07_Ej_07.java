package t_07_ej_07;

import java.io.File;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileNotFoundException;

 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 10, 2019 10:23:52 PM<p>                                                              *
 * <p>nombre del proyecto: T_07_Ej_07.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>7. Mejorar el programa anterior para que además de mostrar el número de líneas, muestre                           *
 *       también el número de caracteres que componen el fichero (sin contar los espacios en blanco).</p>               *
 *       Hecho sin mirar apuntes ni recibir ayuda de NetBeans con atajos. (imports incluidos)                           *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: 0 horas 57 minutos 40 segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class T_07_Ej_07 {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Recoge una ruta a un archivo por parámetro, y muestra el número de caracteres que no son espacios en blanco    *
    *    y el número de líneas de dicho archivo.</p>                                                                    *
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) {
        
        int contadorLineas = 0;     //Almacena el numero de lineas del archivo
        int contadorCaracteres = 0; //Almacena el número de caracteres del archivo
        String lineaLeida;          //Linea que irá leyendo nuestro BufferedReader
        BufferedReader br; //NO PODEMOS DECLARARLO DENTRO DEL TRY-CATCH!//
        
      // CREAMOS EL OBJETO TIPO FILE //
        try
        {
            File archivo = new File(args[0]);
            //File archivo = new File(args[0]);
            br = new BufferedReader(new FileReader(archivo));
        }catch(FileNotFoundException chaos)
        {
            System.out.println("I AM THE LIGHTNING\nBUT I MISSED THE FILE\n" + chaos);
            System.err.println("I AM THE RED LIGHTNING\nBUT I MISSED THE FILE TOO!!\n" + chaos);
            System.err.println("WE ARE SO FKING FAST THAT WE SPEAK TOGETHER! AND WE STILL MISSED IT!");
            return; // ABORTA EL PROGRAMA SI NO SE ENCUENTRA EL ARCHIVO //
        }
        
        // INTENTAMOS LEER EL ARCHIVO //
        try
        {
            while((lineaLeida = br.readLine()) != null)
            {
                contadorLineas++;
                contadorCaracteres = contadorCaracteres + contadorCaracteres(lineaLeida);
            }
        }catch(IOException ioe)
        {
            System.out.println("Ha ocurrido un error de Entrada/Salida: " + ioe);
        }
        
        // MOSTRAMOS EL RESULTADO DE LA LECTURA DEL ARCHIVO //
        System.out.println("El numero de lineas de nuestro archivo es: " + contadorLineas);
        System.out.println("El numero de caracteres contenidos en nuestro archivo es de: " + contadorCaracteres);
    }
    
    // METODOS AUXILIARES //
    private static int contadorCaracteres(String linea)
    {
        int contador = 0;
        for(int i = 0; i < linea.length(); i++)
        {
            if(linea.charAt(i) != ' ')
                contador++;
        }
        System.out.println(contador);
        return contador;
    }
}