import java.util.concurrent.atomic.AtomicInteger;

@SuppressWarnings ("all")
public class S16_main {
  static int sum = 0;
  static volatile AtomicInteger concSafeSum = new AtomicInteger (0);

  static void main () throws InterruptedException {

    IO.println (Runtime.getRuntime ());
    IO.println (Runtime.getRuntime().availableProcessors ());
    IO.println (Runtime.getRuntime().totalMemory ());
    IO.println (Runtime.getRuntime().freeMemory ());
    IO.println (Runtime.getRuntime().maxMemory ());
    IO.println (Runtime.version ());



    Thread T1 = new Thread (
      () -> {
        synchronized (concSafeSum){
          for (int i = 0; i < 2000; i++) {
            sum += i;
            concSafeSum.getAndAdd (i);
            try { Thread.sleep (1);  }
            catch (InterruptedException e) {  throw new RuntimeException (e); }
          }
          System.out.println (sum);
        }
      }
    );

    T1.start ();
    //T1.join (); Join prevents everything else unless this Thread completes

    Thread T2 = new Thread (
      () -> {
        Runtime.getRuntime ().gc (); //Calls manually the Garbage Collector (not recommended)
        Runtime.getRuntime ().addShutdownHook (
          new Thread(() ->
            System.out.println("\nClosing...\nLast 'sum' value: " + sum + "\nLast 'concSafeSum' value: " + concSafeSum)
          ));
        System.exit (0);
      }
    );

    T2.start ();
    Thread.sleep (5000);


  }
}
