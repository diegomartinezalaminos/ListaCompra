
//exit 1 --> no exite el archivo
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.File;
import java.io.FilterWriter;
import java.util.Scanner;

public class ListaCompra {

  public static void main(String[] args) throws IOException {
    int opcion = 0;
    while (opcion != 4) {
      Scanner s = new Scanner(System.in);
      System.out.println("---------------Menu-----------------");
      System.out.println("1)---Crear Lista de la compra---");
      System.out.println("2)---Ver lista de la compra-----");
      System.out.println("3)---Borrar lista de la compra----");
      System.out.println("4)------------Salir---------------");
      System.out.println("------------------------------------");
      System.out.println("Seleccione una opcion del menú: ");
      opcion = Integer.parseInt(s.nextLine());

      switch (opcion) {
        case 1:
          System.out.println("--------------------------------------------------------------------------------");
          System.out.println("Introduce el nombre del la lista de la compra que desea crear (nombrelista.txt): ");
          String nomlista = s.nextLine();
          //Formatear el texto
          System.out.println("Introduzca el dia de la semana:");
          String dia = s.nextLine();
          System.out.println("Intruduce los que quieres comprar junto con la cantidad dividido por comas tal como se muestra(2 unidades de tomate,2 lechuga,400 gramos de etc):");
          String cosas = "," + s.nextLine();
          String lista = "--------------------------------\n" + dia + "\n--------------------------------" + cosas.replaceAll(",", "\n * ") + "\n--------------------------------\n";
          //Escribir
          BufferedWriter bw = new BufferedWriter(new FileWriter(nomlista));
          bw.write(lista);
          bw.close();
          break;
        case 2:
          System.out.println("----------------------------------------------------------------------");
          System.out.println("Introduce el nombre de la lista que desa leer (nombrelista.txt):");
          String leerlista = s.nextLine();
          File archivo = new File(leerlista);
          if (archivo.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(leerlista));
            String linea;
            do {
              linea = br.readLine();
              if (linea != null) {
                System.out.println(linea);
              }
            } while (linea != null);
            br.close();
          } else {
            System.out.println("El nombre de la lista introducido no existe");
            System.out.println("----------------------------------------------------------------------");
            System.exit(1);
          }
          break;
        case 3:
          System.out.println("----------------------------------------------------------------------");
          System.out.println("Introduce el nombre de la lista que deseas eliminar (nombrelista.txt):");
          String eliminarlista = s.nextLine();
          File archivo2 = new File(eliminarlista);
          if (archivo2.exists()) {
            archivo2.delete();
            System.out.println("La lista se ha eliminado con éxito");
            System.out.println("----------------------------------------------------------------------");
          } else {
            System.out.println("El nombre de la lista introducido no existe");
            System.out.println("----------------------------------------------------------------------");
            System.exit(1);
          }
          break;
        default:
          System.out.println("----------------------------------------------------------------------");
          System.out.println("Tienes que introducir una opcion correcta");
          System.out.println("----------------------------------------------------------------------");
          break;
      }
    }

  }

}
