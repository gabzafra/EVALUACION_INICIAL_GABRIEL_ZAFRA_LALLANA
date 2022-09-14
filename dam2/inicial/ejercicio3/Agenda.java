package dam2.inicial.ejercicio3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Agenda {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    ArrayList<Contacto> agenda = initAgenda();

    boolean haTerminado = false;
    while (!haTerminado) {
      pintarMenu();
      switch (input.nextLine()) {
        case "1" -> showContactDetail(findContactByName(agenda));
        case "2" -> agenda.add(newContact());
        case "3" -> agenda = deleteContactByName(agenda);
        case "s" -> haTerminado = true;
        default -> System.out.println("Error");
      }
    }
  }

  private static Contacto findContactByName(ArrayList<Contacto> agenda) {
    Scanner input = new Scanner(System.in);
    Contacto contacto = new Contacto("", "", "", "");

    while (contacto.nombre().length() == 0) {
      listarContactos(agenda);
      System.out.println("Escriba el nombre del contacto que desea ver:");
      String entrada = input.nextLine();
      contacto = agenda.stream()
          .filter(record -> record.nombre().equals(entrada))
          .findFirst()
          .orElse(contacto);
    }
    return contacto;
  }

  private static Contacto newContact() {
    Scanner input = new Scanner(System.in);
    System.out.println("Escriba el nombre del contacto que desea crear:");
    String nombre = input.nextLine();
    System.out.println("Escriba los apellidos del contacto que desea crear:");
    String apellidos = input.nextLine();
    System.out.println("Escriba la dirección del contacto que desea crear:");
    String direccion = input.nextLine();
    System.out.println("Escriba el telefono del contacto que desea crear:");
    String telefono = input.nextLine();
    return new Contacto(nombre, apellidos, direccion, telefono);
  }

  private static ArrayList<Contacto> deleteContactByName(ArrayList<Contacto> agenda) {
    Scanner input = new Scanner(System.in);
    listarContactos(agenda);
    System.out.println("Escriba el nombre del contacto que desea eliminar:");
    String entrada = input.nextLine();
    return agenda.stream()
        .filter(record -> !record.nombre().equals(entrada))
        .collect(Collectors.toCollection(ArrayList::new));
  }

  private static void showContactDetail(Contacto contacto) {
    System.out.println("------------------");
    System.out.println("Nombre: " + contacto.nombre());
    System.out.println("Apellidos: " + contacto.apellidos());
    System.out.println("Dirección: " + contacto.direccion());
    System.out.println("Teléfono: " + contacto.telefono());
    System.out.println("------------------");
  }

  private static void pintarMenu() {
    System.out.println("Elija una opción :");
    System.out.println("1. Ver un contacto.");
    System.out.println("2. Añadir un nuevo contacto.");
    System.out.println("3. Borrar un contacto.");
    System.out.println("s. Salir del programa.");
  }

  private static void listarContactos(ArrayList<Contacto> lista) {
    System.out.println("LISTA DE CONTACTOS");
    System.out.println("------------------");
    lista.forEach(contacto -> System.out.println(contacto.nombre()));
    System.out.println("------------------");
  }

  private static ArrayList<Contacto> initAgenda() {
    ArrayList<Contacto> lista = new ArrayList<>();
    lista.add(new Contacto("Adam", "Archer", "Calle Falsa 1", "111111111"));
    lista.add(new Contacto("Betty", "Bell", "Calle Rara 32", "222222222"));
    lista.add(new Contacto("Charlie", "Cox", "Avenida Imposible 4", "333333333"));
    lista.add(new Contacto("Diane", "Davies", "Calle Insensata 3 F", "444444444"));
    lista.add(new Contacto("Erwin", "Ennis", "Plaza de la Constitución 5", "555555555"));
    return lista;
  }

}
