import java.nio.charset.StandardCharsets;

public class S08_main {
  static void main (String[] args) {

    String blank = "   ";
    System.out.println (blank.length ());
    System.out.println ("blank.isEmpty() " + blank.isEmpty());
    System.out.println ("blank.isBlank() " + blank.isBlank());

      System.out.println ("\n");

    String hospital = "Hospital";
    System.out.println (hospital);
    System.out.println ("charAt(3) " + hospital.charAt(3));
    System.out.println ("codePointAt(5) " + hospital.codePointAt (5));
    System.out.println ("hospital.substring(3 , 7) " + hospital.substring (3 , 7));
    System.out.println ("hospital.subSequence(3 , 7) " + hospital.subSequence (3 , 7)); //return CharSequence instead of String
    System.out.println ("hospital.contains('Hospital') " + hospital.contains("Hospital")); //receives a CharSequence
    System.out.println ("hospital.indefOf('H') " + hospital.indexOf ('H'));

      System.out.println ("\n");

    String ambulance = "ambulance";
    System.out.println ("ambulance.lastIndexOf('a') " + ambulance.lastIndexOf ('a'));
    System.out.println ("ambulance.startsWith('amb')" + ambulance.startsWith ("amb"));
    System.out.println ("ambulance.endsWith('nce')" + ambulance.endsWith ("nce"));

      System.out.println ("\n");

    String ambulanceWhitespaces = "\u2003ambulance\u2003";
    System.out.println ("ambulanceWhitespaces.strip()  |" + ambulanceWhitespaces.strip() + "|"); //Abrange multiplos caracteres unicodes
    System.out.println ("ambulanceWhitespaces.trim()   |" + ambulanceWhitespaces.trim () + "|"); //Legado, menos abrangências
    System.out.println ("ambulanceWhitespaces.replace('lance','lance-lance') " + ambulanceWhitespaces.replace ("lance" , "lance-lance"));
    System.out.println ("ambulanceWhitespaces.repeat(5) " + ambulanceWhitespaces.repeat (5));
    System.out.println ("ambulanceWhitespaces.indent(65) " + ambulanceWhitespaces.indent (65));

      System.out.println ("\n");

    String house_and_dog = "house&dog";
    System.out.println ("house_and_dog_array = house_and_dog.split ('&') " + "   returns an Array, using & as the separator ");
    String[] house_and_dog_array = house_and_dog.split ("&");
    for (String item : house_and_dog_array){System.out.println (item);}

    System.out.println ("text.lines() " + " returns a Stream, needs to be transformed to a List or other group before consume");
    String text = "first-line\nsecond-line\r\nthird-line";
    System.out.println (text.lines()); //Return a Stream<String> separated by the line divisors
    System.out.println (text.lines().toList ());

      System.out.println ("\n");

    System.out.println ("String.valueOf(1) " + String.valueOf (1) + " | "); //Convert primity types to String
    String[] data = {"Gabriel", "26"};
    System.out.println ("Name: %s, age: %s years old.".formatted (data[0] , data[1])); // %s to String %d to int values

    char[] nameChar = data[0].toCharArray ();
    System.out.println (nameChar);
    System.out.println (nameChar[0] + " " + nameChar[1]);
    byte[] nameBytes = data[0].getBytes(StandardCharsets.UTF_8);
    System.out.println (nameBytes);
    System.out.println (nameBytes[0] + " " + nameBytes[1] + " " + nameBytes[2]);

    System.out.println ("hospital.concat(data[0)) | " + hospital.concat (data[0]));
    //String.join( delimiter , text , text)
    System.out.println ("String.join(delimiter , text , text)");
    System.out.println (String.join (" |___I'M THE DELIMITER :D___| " , data[0] , " bird " , data[1] , " fox "));

    System.out.println ("String.format(text containing %s , %d for example , value , value)");
    System.out.println (String.format ("first argument is %s , second is %s" , "eagle" , "whale"));

  }
}
