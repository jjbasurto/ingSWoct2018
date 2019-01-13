import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class Palabras {
    
   public static void main(String[] args){
       try{
           //Crea el archivo
           Formatter miarchivo = new Formatter ("archivo.txt");
           Scanner salida = new Scanner (System.in);
           
           //Permite ingresar el texto y lo guarda en una variable String
           System.out.println("Introduzca el texto: ");
           String texto = salida.nextLine();
           
           miarchivo.format("%s", texto);
           miarchivo.close();
           
           System.out.println("\nUsted ingreso el siguinte texto: ");
           
           Scanner leeArchivo = new Scanner (new File("archivo.txt"));
           String linea = "";
           
           //Imprime lo que se ingreso por teclado
           while(leeArchivo.hasNextLine()){
               linea += leeArchivo.nextLine();
               System.out.println(linea);
           }
           leeArchivo.close();
           
           //Muestra el total de palabras que se ingresaron
           String [] palabras = linea.split(" ");
           System.out.println("\nTotal palabras: " + palabras.length);
           
           //Proceso para buscar la palabra
           System.out.println("\nIntroduzca la palabra que desea buscar: ");
           
           String buscar = salida.nextLine();
           int repetida = 0;
           int cantidad = 0;
           
           //Localiza la palabra con un for mejorado
           for (String palabra : palabras){
               if (palabra.equals(buscar)){
                   repetida ++;
               }
           }
           System.out.printf("\nLa palabra %s se repite %d veces en el "
                   + "texto ingresado\n\n",buscar,repetida);
       }
       catch(FileNotFoundException ex){
           System.out.println(ex.getMessage());
       }
   }      
}