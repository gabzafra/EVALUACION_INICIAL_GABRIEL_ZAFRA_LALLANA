package dam2.inicial.ejercicio2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CuentaEnteros {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> listaNumeros = new ArrayList<>();
    boolean flag = true;

    while (flag) {
      System.out.println("Escriba un entero positivo o -1 para terminar");
      int entrada = input.nextInt();
      if (entrada > 0) {
        listaNumeros.add(entrada);
      } else if (entrada == -1 && listaNumeros.size() > 0) {
        flag = false;
      } else {
        System.err.println("Debe introducir un entero mayor que 0");
      }
    }
    System.out.print("La suma de los números es: ");
    System.out.println(listaNumeros.stream().mapToInt(Integer::intValue).sum());

    double media = listaNumeros.stream().collect(Collectors.averagingInt(Integer::intValue));
    System.out.println("La media de los números es: " + media);

    listaNumeros.forEach(num -> System.out.println(
        "El número " + num + " es " + getNumberPosition(num, media) + " a la media."));
  }

  private static String getNumberPosition(int num, double media) {
    if (num < media) {
      return "menor";
    } else if (num == media) {
      return "igual";
    } else {
      return "superior";
    }
  }

}
