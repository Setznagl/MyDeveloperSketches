@SuppressWarnings ("all")
public class S18_main {

  static void main () throws InterruptedException {

    Thread T1 = new Thread (
      () -> {
        int sum = 0;
        for (int i = 0; i < 2000000; i++) {
          if(Thread.currentThread ().isInterrupted () && sum >= 25000) {
            IO.println ("Interrupt signal was received!");
            break;
          }
          sum++;
          IO.println ("Last 'sum' value  | " + sum);
        }
      }
    );

    IO.println ("T1.isInterrupted ()  | " + T1.isInterrupted ());
    T1.start ();
    T1.interrupt ();
    IO.println ("T1.isInterrupted ()  | " + T1.isInterrupted ());


  }

  public static void interruptT1() throws InterruptedException {
     Runtime.getRuntime ().wait (3000);
  }
}
