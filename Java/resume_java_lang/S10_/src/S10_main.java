@SuppressWarnings ("all")
public class S10_main {
  static void main () {

    //Strings are imutable, variants will also be added to the StringPool

    StringBuilder builder = new StringBuilder ();
    builder.append ("Home"); builder.append (" Wi-fi"); builder.append (" Router"); System.out.println (builder);
    builder.insert (5 , "( .insert middle-string) "); System.out.println (builder);
    builder.delete (0 , 5); System.out.println (builder);
    builder.deleteCharAt (0); builder.deleteCharAt (22);  System.out.println (builder);
    builder.setCharAt (0 , '0'); builder.setCharAt (builder.length ()-1 , '0');  System.out.println (builder);
    builder.replace (0 , 8 , "REPLACED TEXT"); System.out.println (builder);
    builder.reverse (); System.out.println (builder);

      System.out.println ("\n");

    // Shared StringBuffer object
    StringBuffer sharedBuffer = new StringBuffer("Start");
    StringBuilder sharedBuilder = new StringBuilder ("Start");
    StringBuilder synchronizedSharedBuild = new StringBuilder ("Start");
    StringBuilder synchronizedSharedBuildWithSynchronizedMethods = new StringBuilder ("Start");

    // Thread 1 appends " - Thread1"
    Thread t1 = new Thread(() -> {
      for (int i = 0; i < 9; i++) {
        sharedBuilder.append(" - T1(" + i + ")");
        sharedBuffer.append(" - T1(" + i + ")");
        try { Thread.sleep(50); } catch (InterruptedException e) {}
      }
    }, "Thread-1");

    // Thread 2 appends " - Thread2"
    Thread t2 = new Thread(() -> {
      for (int i = 0; i < 9; i++) {
        sharedBuilder.append(" - T2(" + i + ")");
        sharedBuffer.append(" - T2(" + i + ")");
        try { Thread.sleep(50); } catch (InterruptedException e) {}
      }
    }, "Thread-2");

    // Thread 3 appends " - Synchronized Thread 3"
    Thread t3 = new Thread (
      () -> {
        synchronized (synchronizedSharedBuild){
          for (int i = 0 ; i < 9; i++){
            synchronizedSharedBuild.append (" - T3(" + i + ")");
            try { Thread.sleep(50); } catch (InterruptedException e) {}
          }
        }
      }, "Thread-3"
    );

    // Thread 4 appends " - Synchronized Thread 4"
    Thread t4 = new Thread (
      () -> {
        synchronized (synchronizedSharedBuild){
          for (int i = 0 ; i < 9; i++){
            synchronizedSharedBuild.append (" - T4(" + i + ")");
            try { Thread.sleep(50); } catch (InterruptedException e) {}
          }
        }
      }, "Thread-4"
    );

    // Thread 3 appends " - Synchronized Thread 3"
    Thread t5 = new Thread (
      () -> {
          for (int i = 0 ; i < 9; i++){
            synchronized (synchronizedSharedBuildWithSynchronizedMethods){
              synchronizedSharedBuildWithSynchronizedMethods.append (" - T5(" + i + ")");
            }
            try { Thread.sleep(50); } catch (InterruptedException e) {}
          }
      }, "Thread-5"
    );

    // Thread 4 appends " - Synchronized Thread 4"
    Thread t6 = new Thread (
      () -> {
          for (int i = 0 ; i < 9; i++){
            synchronized (synchronizedSharedBuildWithSynchronizedMethods){
              synchronizedSharedBuildWithSynchronizedMethods.append (" - T6(" + i + ")");
            }
            try { Thread.sleep(50); } catch (InterruptedException e) {}
          }
      }, "Thread-6"
    );

    // Start both threads
    t1.start();
    t2.start();
    t3.start ();
    t4.start ();
    t5.start ();
    t6.start ();

    // Wait for both threads to finish
    try {
      t1.join();
      t2.join();
      t3.join ();
      t4.join ();
      t5.join ();
      t6.join ();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    // Print final result
    System.out.println("Final Builder Result:             " + sharedBuilder.toString());
    System.out.println("Final Sync Builder Result:        " + synchronizedSharedBuild.toString()); //Synchronized access, but without synchronized edit methods
    System.out.println("Final Builder Sync Append Result: " + synchronizedSharedBuildWithSynchronizedMethods.toString()); //Synchronized access, with synchronized edit methods
    System.out.println("Final Buffer Result:              " + sharedBuffer.toString()); //Synchronized access and synchronized edit by default
  }

}
