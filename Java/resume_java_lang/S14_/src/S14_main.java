import java.math.BigDecimal;
import java.util.Arrays;

@SuppressWarnings ("all")
public class S14_main {

  static class MathBenchmark {
    protected static int ITERATIONS = 10_000_000;
    static volatile double sink; //volatile unsure multithread reading

    public static void runBenchmark (){

      // Warm-up
      for (int i = 0; i < 2_000_000; i++) {
        Math.sin(i);
        StrictMath.sin(i);
      }

      double result = 0;

      long start = System.nanoTime();

      for (int i = 0; i < ITERATIONS; i++) {
        result += Math.sin(i);
      }

      long end = System.nanoTime();

      System.out.printf(
        "Math: %.3f ms%n",
        (end - start) / 1_000_000.0
      );

      start = System.nanoTime();

      for (int i = 0; i < ITERATIONS; i++) {
        result += StrictMath.sin(i);
      }

      end = System.nanoTime();

      System.out.printf(
        "StrictMath: %.3f ms%n",
        (end - start) / 1_000_000.0
      );

      sink = result;
    }

  }

  static void main () throws InterruptedException {

    Thread A1 = new Thread (
        () -> {
          Float zero_dot_one = 0.1f;
          Float zero_dot_three = 0.3f;
          System.out.println ("0.1 * 0.3  | " + zero_dot_one * zero_dot_three);
          System.out.println ("Math.abs (0.1 * 0.3)  | " + Math.abs (0.1 * 0.3));
          Integer[] numbers = {1 , 6 , 55 , 315};
          System.out.println (Arrays.toString (numbers));
          System.out.println ("Math.min(numbers[0] , numbers[3]  | " + Math.min(numbers[0] , numbers[3]));
          System.out.println ("Math.max(numbers[0] , numbers[3]  | " + Math.max(numbers[0] , numbers[3]));
          //Math.clamp() returns the number itself unless it's above the bounrdaries (min, max)
          System.out.println ("Math.clamp(122 , numbers[0] , numbers[3]  | " + Math.clamp (112 , numbers[0] , numbers[3]));
          System.out.println ("Math.clamp(5000 , numbers[0] , numbers[3]  | " + Math.clamp (5000 , numbers[0] , numbers[3]));
          //Math.signum() returns 1 for positive, -1 for negative or 0 for zero
          System.out.println ("Math.signum(14)  | " + Math.signum (14));
          System.out.println ("Math.signum(-400)  | " + Math.signum (-400));
          System.out.println ("Math.signum(0)  | " + Math.signum (0));
          System.out.println ("Math.signum('A')  | " + Math.signum ('A') + "  | Warning! It'll considerer Unicode numeric value (65 for A, whichs positive).");
          // System.out.println ("Math.signum('ABC')  | " + Math.signum ("ABC")); Compiler error
          System.out.println ("Math.copySign (400 , -3)  | " + Math.copySign (400 , -10) + "  | Copy the sign value from the second argument, applies to the first");
          System.out.println ("Math.sqrt(400)  | " + Math.sqrt (400));
          System.out.println ("Math.cbrt(27)  | " + Math.cbrt (27));
          System.out.println ("Math.pow(3 , 2)  | " + Math.pow (3 , 2));
          System.out.println ("Math.exp(3)  | " + Math.exp (3) + "  | Euler number (2.71828) pow(value) (specific applications, like radioctive decay calcs)");
          System.out.println ("Math.log (20.085536923187668)  | " + Math.log (20.085536923187668) + "  | Also using Euler number as the log basis");
          System.out.println ("Math.log10 (100)  | " + Math.log10 (100));

          double x = 1e-16;
          System.out.println ("Math.log (1.0 + 1e-16)  | " + Math.log (1.0 + x) + "  | Can't handle specific types of numbers");
          System.out.println ("Math.log1p (1e-16)  | " + Math.log1p (x) + "  | scientific precision");

          System.out.println ("Math.toRadians (60)  | " + Math.toRadians (60));
          System.out.println ("Math.toDegres (1.0471975511965976)  | " + Math.toDegrees (1.0471975511965976));
          System.out.println ("Math.sin (1.0471975511965976)  | " + Math.sin (1.0471975511965976));
          System.out.println ("Math.cos (1.0471975511965976)  | " + Math.cos (1.0471975511965976));
          System.out.println ("Math.tan (1.0471975511965976)  | " + Math.tan (1.0471975511965976));
          System.out.println ("Math.atan2( 0 , 0)  | " + Math.atan2 (0 , 0) + "  | angle value in radians");
          System.out.println ("Math.atan2( 0 , 1)  | " + Math.atan2 (0 , 1) + "  | angle value in radians");
          System.out.println ("Math.atan2( 1 , 1)  | " + Math.atan2 (1 , 1) + "  | angle value in radians");
          System.out.println ("Math.atan2( 1 , 0)  | " + Math.atan2 (1 , 0) + "  | angle value in radians");
          System.out.println ("Math.toDegrees (Math.atan2 (0 , 0))  | " + Math.toDegrees (Math.atan2 (0 , 0)) + "  | angle value in degrees");
          System.out.println ("Math.toDegrees (Math.atan2 (0 , 1))  | " + Math.toDegrees (Math.atan2 (0 , 1)) + "  | angle value in degrees");
          System.out.println ("Math.toDegrees (Math.atan2 (1 , 1))  | " + Math.toDegrees (Math.atan2 (1 , 1)) + "  | angle value in degrees");
          System.out.println ("Math.toDegrees (Math.atan2 (1 , 0))  | " + Math.toDegrees (Math.atan2 (1 , 0)) + "  | angle value in degrees");
          System.out.println ("Math.floor (2.333)  | " + Math.floor (2.333));
          System.out.println ("Math.ceil (2.1)  | " + Math.ceil (2.1));
          System.out.println ("Math.round (2.3982831821)  | " + Math.round (2.3982831821));
          System.out.println ("Math.round (2.6982831821)  | " + Math.round (2.6982831821));
          // Similar to round(), but uses a different logic. It'll prefer to return the closes pair int pair number whenever is possible.(Banking)
          System.out.println ("Math.rint (2.5)  | " + Math.rint (2.5));
          System.out.println ("Math.rint (3.5)  | " + Math.rint (3.5));
          System.out.println ("Math.rint (7.2)  | " + Math.rint (7.2) + "  | Apply tie-breaker logic only if decimal case is .5");
          System.out.println ("(321 + 9822) / 7217.0)  | " + (321 + 9822) / 7217.0);
          System.out.println ("Math.divideExact (Math.addExact (321 , 9822) , 7217)  | " + Math.divideExact (Math.addExact (321 , 9822) , 7217) + "  | Dedicated to operate integer values with greater safety");
          BigDecimal A = BigDecimal.valueOf (321); BigDecimal B = BigDecimal.valueOf (9822); BigDecimal C = BigDecimal.valueOf (7217);
          // System.out.println ((A.add (B)).divide (C)); - ArithmeticException: Non-terminating decimal expansion
          System.out.println ("Using BigDecimal throws - ArithmeticException: Non-terminating decimal expansion");

          System.out.println ("Math.fma (3f , 6f , 4.5f)  | " + Math.fma (3f , 6f , 4.5f) + "  | multiply a * b and then sum c");
          System.out.println ("Math.scalb (2000 , 3)  | " + Math.scalb (2000 , 3) + "  | numbers of iterations doing '* 2' to the argument");
          System.out.println ("\n\n\n");
        }
      );

    Thread A2 = new Thread (
      () -> {
        Float zero_dot_one = 0.1f;
        Float zero_dot_three = 0.3f;
        System.out.println ("0.1 * 0.3  | " + zero_dot_one * zero_dot_three);
        System.out.println ("StrictMath.abs (0.1 * 0.3)  | " + StrictMath.abs (0.1 * 0.3));
        Integer[] numbers = {1 , 6 , 55 , 315};
        System.out.println (Arrays.toString (numbers));
        System.out.println ("StrictMath.min(numbers[0] , numbers[3]  | " + StrictMath.min(numbers[0] , numbers[3]));
        System.out.println ("StrictMath.max(numbers[0] , numbers[3]  | " + StrictMath.max(numbers[0] , numbers[3]));
        //Math.clamp() returns the number itself unless it's above the bounrdaries (min, max)
        System.out.println ("StrictMath.clamp(122 , numbers[0] , numbers[3]  | " + StrictMath.clamp (112 , numbers[0] , numbers[3]));
        System.out.println ("StrictMath.clamp(5000 , numbers[0] , numbers[3]  | " + StrictMath.clamp (5000 , numbers[0] , numbers[3]));
        //Math.signum() returns 1 for positive, -1 for negative or 0 for zero
        System.out.println ("StrictMath.signum(14)  | " + StrictMath.signum (14));
        System.out.println ("StrictMath.signum(-400)  | " + StrictMath.signum (-400));
        System.out.println ("StrictMath.signum(0)  | " + StrictMath.signum (0));
        System.out.println ("StrictMath.signum('A')  | " + StrictMath.signum ('A') + "  | Warning! It'll considerer Unicode numeric value (65 for A, whichs positive).");
        // System.out.println ("Math.signum('ABC')  | " + Math.signum ("ABC")); Compiler error
        System.out.println ("StrictMath.copySign (400 , -3)  | " + StrictMath.copySign (400 , -10) + "  | Copy the sign value from the second argument, applies to the first");
        System.out.println ("StrictMath.sqrt(400)  | " + StrictMath.sqrt (400));
        System.out.println ("StrictMath.cbrt(27)  | " + StrictMath.cbrt (27));
        System.out.println ("StrictMath.pow(3 , 2)  | " + StrictMath.pow (3 , 2));
        System.out.println ("StrictMath.exp(3)  | " + StrictMath.exp (3) + "  | Euler number (2.71828) pow(value) (specific applications, like radioctive decay calcs)");
        System.out.println ("StrictMath.log (20.085536923187668)  | " + StrictMath.log (20.085536923187668) + "  | Also using Euler number as the log basis");
        System.out.println ("StrictMath.log10 (100)  | " + StrictMath.log10 (100));

        double x = 1e-16;
        System.out.println ("StrictMath.log (1.0 + 1e-16)  | " + StrictMath.log (1.0 + x) + "  | Can't handle specific types of numbers");
        System.out.println ("StrictMath.log1p (1e-16)  | " + StrictMath.log1p (x) + "  | scientific precision");

        System.out.println ("StrictMath.toRadians (60)  | " + StrictMath.toRadians (60));
        System.out.println ("StrictMath.toDegres (1.0471975511965976)  | " + StrictMath.toDegrees (1.0471975511965976));
        System.out.println ("StrictMath.sin (1.0471975511965976)  | " + StrictMath.sin (1.0471975511965976));
        System.out.println ("StrictMath.cos (1.0471975511965976)  | " + StrictMath.cos (1.0471975511965976));
        System.out.println ("StrictMath.tan (1.0471975511965976)  | " + StrictMath.tan (1.0471975511965976));
        System.out.println ("StrictMath.atan2( 0 , 0)  | " + StrictMath.atan2 (0 , 0) + "  | angle value in radians");
        System.out.println ("StrictMath.atan2( 0 , 1)  | " + StrictMath.atan2 (0 , 1) + "  | angle value in radians");
        System.out.println ("StrictMath.atan2( 1 , 1)  | " + StrictMath.atan2 (1 , 1) + "  | angle value in radians");
        System.out.println ("StrictMath.atan2( 1 , 0)  | " + StrictMath.atan2 (1 , 0) + "  | angle value in radians");
        System.out.println ("StrictMath.toDegrees (StrictMath.atan2 (0 , 0))  | " + StrictMath.toDegrees (StrictMath.atan2 (0 , 0)) + "  | angle value in degrees");
        System.out.println ("StrictMath.toDegrees (StrictMath.atan2 (0 , 1))  | " + StrictMath.toDegrees (StrictMath.atan2 (0 , 1)) + "  | angle value in degrees");
        System.out.println ("StrictMath.toDegrees (StrictMath.atan2 (1 , 1))  | " + StrictMath.toDegrees (StrictMath.atan2 (1 , 1)) + "  | angle value in degrees");
        System.out.println ("StrictMath.toDegrees (StrictMath.atan2 (1 , 0))  | " + StrictMath.toDegrees (StrictMath.atan2 (1 , 0)) + "  | angle value in degrees");
        System.out.println ("StrictMath.floor (2.333)  | " + StrictMath.floor (2.333));
        System.out.println ("StrictMath.ceil (2.1)  | " + StrictMath.ceil (2.1));
        System.out.println ("StrictMath.round (2.3982831821)  | " + StrictMath.round (2.3982831821));
        System.out.println ("StrictMath.round (2.6982831821)  | " + StrictMath.round (2.6982831821));
        // Similar to round(), but uses a different logic. It'll prefer to return the closes pair int pair number whenever is possible.(Banking)
        System.out.println ("StrictMath.rint (2.5)  | " + StrictMath.rint (2.5));
        System.out.println ("StrictMath.rint (3.5)  | " + StrictMath.rint (3.5));
        System.out.println ("StrictMath.rint (7.2)  | " + StrictMath.rint (7.2) + "  | Apply tie-breaker logic only if decimal case is .5");
        System.out.println ("(321 + 9822) / 7217.0)  | " + (321 + 9822) / 7217.0);
        System.out.println ("StrictMath.divideExact (StrictMath.addExact (321 , 9822) , 7217)  | " + StrictMath.divideExact (StrictMath.addExact (321 , 9822) , 7217) + "  | Dedicated to operate integer values with greater safety");
        BigDecimal A = BigDecimal.valueOf (321); BigDecimal B = BigDecimal.valueOf (9822); BigDecimal C = BigDecimal.valueOf (7217);
        // System.out.println ((A.add (B)).divide (C)); - ArithmeticException: Non-terminating decimal expansion
        System.out.println ("Using BigDecimal throws - ArithmeticException: Non-terminating decimal expansion");

        System.out.println ("StrictMath.fma (3f , 6f , 4.5f)  | " + StrictMath.fma (3f , 6f , 4.5f) + "  | multiply a * b and then sum c");
        System.out.println ("StrictMath.scalb (2000 , 3)  | " + StrictMath.scalb (2000 , 3) + "  | numbers of iterations doing '* 2' to the argument");
      }
    );

      A1.start (); A1.join ();
      A2.start (); A2.join ();
      System.out.println ("\n\n");
      MathBenchmark.runBenchmark();


  }
}
