package multiplicacion_rusa;
 /***********************************************************************************************************************
 * @author baha                                                                                                         *
 * <p>fecha de inicializacion: Aug 14, 2019 6:58:50 PM<p>                                                               *
 * <p>nombre del proyecto: Multiplicacion_Rusa.java<p>                                                                           *
 * <p>Anteriores versiones en:</p>                                                                                      *
 * <p><a href="https://github.com/BahamutEscarlata/Ejercicios_JAVA_T_07_Ficheros">GIT</a></p>                           *
 ************************************************************************************************************************
 *                                                                                                                      *
 * <h1>Función del proyecto:</h1>                                                                                       *
 * <p>Para realizar la multiplicación rusa deberemos generar un vector bidimensional de la siguiente                    *
 *    manera: Vamos a multiplicar 34x12 = 408                                                                           *
 *                                                                                                                      *
 *      A   32  17  8   4   2   1                                                                                       *
 *      B   12  24  48  96  192 384                                                                                     *
 *    Ahora deberemos sumar las celdas correspondientes de la columna B en las que su respectivo valor                  *
 *    de la columna A sea impar. Luego 24+384 = 408, correspondiendo al resultado de la multiplicación clásica.         *
 *      (a) Implementar un método que realice la multiplicación rusa.</p>                                               *
 *                                                                                                                      *
 * @version 1.0                                                                                                         *
 * <p>Tiempo invertido en esta versión: ? horas ?? minutos ?? segundos</p>                                              *
 *                                                                                                                      *
 ***********************************************************************************************************************/
public class Multiplicacion_Rusa {

    /********************************************************************************************************************
    *                                                                                                                   *
    * <h1>MÉTODO MAIN</h1>                                                                                              *
    * <p>Funcion:</p>                                                                                                   *
    * <p>Acceder al método multiplicacionRusa y dar el resultado de multiplicar dos números.</p>
    *                                                                                                                   *
    ********************************************************************************************************************/
    public static void main(String[] args) {
      // CONSTANTES //
        final int A = 34;
        final int B = 12;
      
      // VARIABLES LOCALES //
        int numero1 = A;
        int numero2 = B;
        int resultado;

        System.out.println("El resultado de multiplicar " + numero1 + " * " + numero2 + " es:  " + multiplicacionRusa(numero1, numero2));
    }
    

    //Metodos suplementarios de la clase principal//

    /**_________________________________________________________________________________________________________________
     | ~~~~<p>Función del metodo:</p>~~~~                                                                               |
     | <p></p>
     | ~~~~<p>Parámetros:</p>~~~~                                                                                       |
     | @param 
     | @return 
     | ~~~~<p>Método dirigido a: FrontEnd //  BackEnd</p>~~~~                                                                      |
     |_________________________________________________________________________________________________________________*/
    static int multiplicacionRusa(int numero1, int numero2)
    {
        //VARIABLES LOCALES//
        int resultado = 0;
        //CUERPO DEL METODO//
        while(numero1 >= 1)
        {
            if(numero1%2 == 1)
            {
                resultado += numero2;
            }
            numero1 /= 2;
            numero2 *= 2;
        }
        return resultado;
    }
}