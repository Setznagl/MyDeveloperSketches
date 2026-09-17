@SuppressWarnings ("all")
public class S09_main {
  static void main () {

    String text = "A\uD83D\uDE00";  System.out.println (text);

    System.out.println ("text.length() | " + text.length ());
    System.out.println ("text.codePointAt(1)  |  " + text.codePointAt (0)); //two code points
    System.out.println ("text.codePointCount(0 , text.length())  |  " + text.codePointCount (0 , text.length ())); //two code points

    Character number3 = '3';
    System.out.println ("number3.isLetter() " + Character.isLetter (number3));
    System.out.println ("number3.isDigit() " + Character.isDigit (number3));
    System.out.println ("number3.isWhitespace() " + Character.isWhitespace (number3));

    Character letter_a = 'a';
    System.out.println ("letter_a.toUpperCase() " + Character.toUpperCase (letter_a));
    System.out.println ("letter_a.toLowerCase() " + Character.toLowerCase (letter_a));

    int number_344 = 344;
    char[] number_344_chars = Character.toChars (number_344);
    char[] number_5786_chars = Character.toChars (5786);
    System.out.println (number_344_chars[0] + "  |  Representation of 344 in decimal notation");
    System.out.println (number_5786_chars[0] + "  |  Representation of 5786 in decimal notation");
    System.out.println (Character.getName (number_344_chars[0]) + "  |  Decimal notation name for 344");
    System.out.println (Character.getName (number_5786_chars[0]) + "  |  Decimal notation name for 5786");


  }
}
