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
           System.out.println("INTRODUZCA EL TEXTO: ");
           String texto = salida.nextLine();
           
           miarchivo.format("%s", texto);
           miarchivo.close();
           
           System.out.println("\nUSTED HA INGRESADO LO SIGUIENTE: ");
           
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
           System.out.println("\nTOTAL PALABRAS: " + palabras.length);
           
           //Proceso para buscar la palabra
           System.out.println("\nQUE PALABRA DESEAS BUSCAR?: ");
           
           String buscar = salida.nextLine();
           int repetida = 0;
           int cantidad = 0;
           
           //Localiza la palabra con un for mejorado
           for (String palabra : palabras){
               if (palabra.equals(buscar)){
                   repetida ++;
               }
           }
           System.out.printf("\nLA PALABRA %s SE REPITE %d VECES EN EL "
                   + "TEXTO INGRESADO\n\n",buscar,repetida);
       }
       catch(FileNotFoundException ex){
           System.out.println(ex.getMessage());
       }
   }      
}