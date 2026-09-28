import java.io.IOException;
import java.util.Arrays;

@SuppressWarnings ("all")
public class S15_main {
  private static final System.Logger l = System.getLogger (S15_main.class.getName());

  static void main () throws IOException, InterruptedException {

    // System.out.println (System.in.readAllBytes ()); Unlimited reading flow

    Thread I1 = new Thread (
      () -> {
        try {
          input1();
        } catch (IOException e) {
          throw new RuntimeException (e);
        }
      }
    );

    Thread I2 = new Thread (
      () -> {
        try {
          input2();
        } catch (IOException e) {
          throw new RuntimeException (e);
        }
      }
    );

    I1.start (); I1.join ();
    I2.start (); I2.join ();

    IO.println ("\nEnter your name:");
    String name = IO.readln ();
    IO.println ("Hello!, " + name);

    System.out.println ("System.currentTimeMillis ()  | " + System.currentTimeMillis ());
    System.out.println ("System.nanoTime ()  | " + System.nanoTime ());
    System.setProperty ("java.specification.version" , "200"); // Altering to Java 200 :D
    System.out.println ("System.getProperties()  |\n " + System.getProperties() + "\n\n\n");
    System.out.println ("System.getenv()  | " + System.getenv() + "\n\n\n" );

    int[] arrayOne = {1 , 2 , 3 , 4};
    int[] arrayTwo = {0 , 0 , 0 , 0};
    System.arraycopy (arrayOne, 0, arrayTwo, 0, arrayOne.length);
    System.out.println (Arrays.toString (arrayTwo));
    System.out.println ("System.identityHashCode(arrayOne)  | " + System.identityHashCode (arrayOne));
    System.out.println ("System.identityHashCode(arrayTwo)  | " + System.identityHashCode (arrayTwo));
    l.log (System.Logger.Level.INFO, "I'm warning from a Logger!");
    l.log (System.Logger.Level.OFF, "I'm a message from a Logger!");

    System.out.write (' '); System.out.write ('\n');
    System.out.close ();
    System.out.println ("Trying to print after close!");

    System.err.println ("\nI'm an error message! Just kidding :P\n");
    System.err.close ();
    System.err.println ("I'm an error message! Just kidding :P");

  }

  public static void input1() throws IOException {
    IO.println ("Type 'A' one time, press 'enter' then type 'A' 5 times and press 'enter'. 65 is the unicode value of 'A', and 10 is for 'enter'");
    System.out.println (System.in.read ());
    // 10 it's the code for "enter" key, It'll polute the result unless we consume before
    System.out.println (System.in.read ());
  }

  public static void input2() throws IOException {
    System.out.println (Arrays.toString (System.in.readNBytes (5)));
    // 10 it's the code for "enter" key, It'll polute the result unless we consume before
    System.out.println (System.in.read ());
  }

}
