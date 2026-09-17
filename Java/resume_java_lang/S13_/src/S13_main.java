@SuppressWarnings ("all")
public class S13_main {
  static void main () {

    double total = 0.1 + 0.2;
    System.out.println (total);
    System.out.println ("total == 0.3  |  " + (total == 0.3));

    double infinite = (1.0 / 0.0);
    double undefined = (0.0/0.0);

    System.out.println ("Double.isFinite(infinite)  |  " + Double.isFinite (infinite));
    System.out.println ("Double.isInfinite(infinite)  |  " + Double.isInfinite (infinite));
    System.out.println ("Double.isNaN(undefined)  |  " + Double.isNaN (undefined));

    Double forty = 40D;
    Double fifty = 50D;
    System.out.println ("Double.compare(forty, fifty)  |  " + Double.compare (forty , fifty));
    System.out.println ("Double.toHexString (forty)  |  " + Double.toHexString (forty));

  }
}
