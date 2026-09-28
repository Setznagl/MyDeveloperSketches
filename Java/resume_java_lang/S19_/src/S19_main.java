import java.util.ArrayList;
import java.util.List;

@SuppressWarnings ("all")
public class S19_main {
  static void main () throws InterruptedException {

    /*
    Virtual threads are threads managed by the JVM, suitable for large numbers
    of concurrent tasks that spend a significant amount of time blocked in I/O.
    */

    Thread PT1 = Thread.ofPlatform () //Creating an instance without Builder implies using Runnable interface, Throws excetion if uses T1.start()
      .name ("Platform Thread 01")
      .daemon (true) //thread.setDaemon(true). If the main Thread ends this one will also stop running.
      .start (
        () -> {
          for (int i = 0; i <= 5; i++) {
            IO.println ("Platform Thread 01 is printing " + i);
          }
        }
      );
    PT1.join ();

        IO.print ("\n\n");

    Thread.Builder.OfPlatform PT2 = Thread.ofPlatform ();
    PT2.name ("Platform Thread 02");
    PT2.start (
      () -> {
        for (int i = 0; i <= 5;  i++) {
          IO.println ("Platform Thread 02 is printing " + i);
        }
      }
    ).join ();

        IO.print ("\n\n");

    Thread VT1 = Thread.ofVirtual ()
      .name ("Virtual Thread 01")
      .start (
        () -> {
          for (int i = 0; i <= 5; i++) {
            IO.println ("Virtual Thread 01 is printing " + i);
          }
        }
      );VT1.join ();

        IO.print ("\n\n");

    Thread.Builder.OfVirtual VT2 = Thread.ofVirtual ();
    VT2.name ("Virtual Thread 02");
    VT2.start (
      () -> {
        for (int i = 0; i <= 5;  i++) {
          IO.println ("Virtual Thread 02 is printing " + i);
        }
      }).join ();

        IO.println ("\n\n");


    List<Thread> platformThreads = new ArrayList<> ();
    long platform_threads_test_start = System.nanoTime ();
      for (int i = 0; i <= 500; i++) {
        Thread t = Thread.ofPlatform ()
        .name ("MultiThread - PlatformThread - CPU-bound workload |  " + i)
        .start (
          () -> {
            IO.println (Thread.currentThread ().getName ());
            int sum = 0;
            for (int j = 0; j <= 1000000000; j++) {
              sum++;
            }
          }
        );
        platformThreads.add (t);
      }
    for(Thread t : platformThreads){  t.join(); }
    long platform_threads_test_end = System.nanoTime ();

        IO.print ("\n\n");

    List<Thread> virtualThreads = new ArrayList<> ();
    long virtual_threads_test_start = System.nanoTime ();
      for (int i = 0; i <= 500; i++) {
        Thread t = Thread.ofVirtual ()
        .name ("MultiThread - VirtualThread - CPU-bound workload |  " + i)
        .start (
          () -> {
            IO.println (Thread.currentThread ().getName ());
            int sum = 0;
            for (int j = 0; j <= 1000000000; j++) {
              sum++;
            }
          }
        );
        virtualThreads.add (t);
      }
    for(Thread t : virtualThreads){  t.join(); }
    long virtual_threads_test_end = System.nanoTime ();

        IO.print ("\n\n");

    IO.println ("\nPlatform Multithreading for 500 Threads counting from 0 to 1,000,000,000. Platform Threads took "
      + (platform_threads_test_end - platform_threads_test_start) / 1_000_000.0 + " ms");
    IO.println ("Virtual Multithreading for 500 Threads counting from 0 to 1,000,000,000. Virtual Threads took "
      + (virtual_threads_test_end - virtual_threads_test_start) / 1_000_000.0 + " ms (Less efficient on raw CPU-bounding tasks!)");


        IO.print ("\n");


    List<Thread> platformSleepThreads = new ArrayList<> ();
    long platform_sleep_threads_test_start = System.nanoTime ();
    for (int i = 0; i <= 500; i++) {
      Thread t = Thread.ofPlatform ()
        .name ("MultiThread - PlatformThread - with Sleep  |  " + i)
        .start (
          () -> {
            try { Thread.sleep (50);}
            catch (InterruptedException e) {  throw new RuntimeException (e); }
          }
        );
      platformSleepThreads.add (t);
    }
    for(Thread t : platformSleepThreads){  t.join(); }
    long platform_sleep_threads_test_end = System.nanoTime ();


    List<Thread> virtualSleepThreads = new ArrayList<> ();
    long virtual_sleep_threads_test_start = System.nanoTime ();
    for (int i = 0; i <= 500; i++) {
      Thread t = Thread.ofVirtual ()
        .name ("MultiThread - VirtualThread - with Sleep  |  " + i)
        .start (
          () -> {
            try { Thread.sleep (50);}
            catch (InterruptedException e) {  throw new RuntimeException (e); }
          }
        );
      virtualSleepThreads.add (t);
    }
    for(Thread t : virtualSleepThreads){  t.join(); }
    long virtual_sleep_threads_test_end = System.nanoTime ();


    IO.println ("\nPlatform Multithreading for 500 Threads with Thread.sleep(50). Platform Threads took "
      + (platform_sleep_threads_test_end - platform_sleep_threads_test_start) / 1_000_000.0 + " ms");
    IO.println ("Virtual Multithreading for 500 Threads with Thread.sleep(50). Virtual Threads took "
      + (virtual_sleep_threads_test_end - virtual_sleep_threads_test_start) / 1_000_000.0 + " ms (Very efficient on pending response tasks!)");



  }
}
