import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

@SuppressWarnings ("all")
public class S17_main {
  static void main (String[] args) throws IOException, InterruptedException {
    Path absolutePath = Path.of ("").toAbsolutePath ();
    Path dynamicPath = Path.of(absolutePath.toString ().concat ("/resume_java_lang/S17_/src/"));
    String dynamicPathString = dynamicPath.toString ();

    Thread T1 = new Thread (
      () -> {
        String dynamicPath_sumsh = dynamicPathString.concat ("/sum.sh");
        IO.println (dynamicPath_sumsh);

        IO.println ("Choose two numbers, their sum will be the status code value from 'curl --head www.google.com' !");
        String arg1 = IO.readln ();
        String arg2 = IO.readln ();
        ProcessBuilder BuildedP1 = new ProcessBuilder (
          "bash",
          dynamicPath_sumsh,
          arg1,
          arg2
        );
        Process P1 = null;
        try { P1 = BuildedP1.start ();}
        catch (IOException e) {throw new RuntimeException (e);}
        IO.println ("pid " + P1.pid ());
        ProcessHandle.Info p1_info = P1.info ();
        IO.println (p1_info);


        // Read script output (stdout)
    /*
    try (BufferedReader reader = new BufferedReader(
      new InputStreamReader(P1.getInputStream()))) {

      String line;
      System.out.println("--- Reading script output ---");
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    }
    */

        //Same thing, but more optimized to capture the text responses
        try { P1.getInputStream ().transferTo (System.out);}
        catch (IOException e) { throw new RuntimeException (e);}

        // Await process conclusion
        int exitCode = 0; // Wait process end and return an exitCode
        try { exitCode = P1.waitFor(); }
        catch (InterruptedException e) { throw new RuntimeException (e);}

        int exitCodeAlt = P1.exitValue ();
        System.out.println("Process ended with code: " + exitCode + "\nvalue from 'exitCodeAlt " + exitCodeAlt);
      }
    );

    Thread T2 = new Thread (
      () -> {
        IO.print ("\n\n\n");
        String dynamicPath_hellosh = dynamicPathString.concat ("/hello.sh");
        IO.println (dynamicPath_hellosh);
        ProcessBuilder BuildedP2 = new ProcessBuilder (
          "bash"
        );
        BuildedP2.redirectInput (new File (dynamicPath_hellosh)); //Using other file as the input source
        BuildedP2.redirectOutput (new File (dynamicPathString.concat ("/hello.txt"))); //Redirecting output to a .txt file
        try {
          Process P2 = BuildedP2.start ();
          IO.println ("pid " + P2.pid ());
          String output = new String (P2.getInputStream ().readAllBytes ());
          if (
            output.isEmpty ()){ IO.println ("Stream is completely empty!");
          }
          P2.getInputStream ().transferTo (System.out);
        } catch (RuntimeException | IOException e) {throw new RuntimeException (e);}//Nothing happens as the Stream is empty.

        }
    );

    T1.start ();
    T1.join ();
    T2.start ();
    T2.join ();


  }

}
