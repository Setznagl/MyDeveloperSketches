import java.nio.charset.StandardCharsets;
import java.util.Base64;

@SuppressWarnings ("all")
public class S12_main {
  static void main () {

    byte[] text_bytes = "Hello, World!".getBytes(StandardCharsets.UTF_8);
    System.out.println ("text_bytes  |  " + text_bytes);
    String encoded = Base64.getEncoder ().encodeToString (text_bytes);
    System.out.println ("encoded  |  " + encoded);
    byte[] decoded = Base64.getDecoder ().decode (encoded);
    System.out.println ("decoded  |  " + decoded);
    String decodedStr = new String (decoded , StandardCharsets.UTF_8);
    System.out.println ("decodedStr  |  " + decodedStr);

    int decimal = Integer.parseInt ("11111111" , 2); System.out.println(decimal); //255
    String binary = Integer.toBinaryString (255); System.out.println (binary); //11111111
    String hex = Integer.toHexString (255); System.out.println (hex); //ff
    String octal = Integer.toOctalString (255); System.out.println (octal); //377

  }
}
