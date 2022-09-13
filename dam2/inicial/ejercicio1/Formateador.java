package dam2.inicial.ejercicio1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Formateador {

  public static void main(String[] args) {
    String lineaErronea = "Tomás Pérez CamposTomás Pérez Campos";
//    String lineaErronea = "Tomás Pérez Campos Tomás Pérez Campos";
//    String lineaErronea = "Tomás Pérez CampoáTomás Pérez Campos";
//    String lineaErronea = "Tomás Pérez CamposÁomás Pérez Campos";
//    String lineaErronea = "";
//    String lineaErronea = "Tomás Pérez Campos";

    Pattern regex = Pattern.compile("\\p{Ll}\\p{Lu}");
    Matcher matcher = regex.matcher(lineaErronea);

    System.out.println(matcher.find() ? lineaErronea.substring(0, matcher.end() - 1)
        : "La línea introducida no es válida");
  }
}
