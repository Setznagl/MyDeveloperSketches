public class Puzzle {
  /*
    System.out.print(" ");
    System.out.print("a");
    System.out.print("n");
    System.out.print("an");
    System.out.print("noys");
    System.out.print("oise");
    System.out.print("oyster");
    System.out.print("annoys");
    System.out.print("noise");
    x > 0 ;
    x < 1 ;
    x > 1 ;
    x > 3 ;
    x < 4 ;
    x = x + 1 ;
    x = x + 2 ;
    x = x - 2 ;
    x = x -1 ;
  */
  static void main () {
    /*
      a noise
      annoys
      an oyster
    */
    int x = 0;
    while( x < 4){
      System.out.print ("a");
        if( x < 1){
          System.out.print (" ");
        }
      System.out.print ("n");

      if ( x > 1){
        System.out.print ("oyster");
        x = x + 2;
      }
      if ( x == 1 ){
        System.out.print ("noys");
      }
      if ( x < 1 ){
        System.out.print ("oise");
      }
      System.out.println ();

      x = x + 1;
    }

  }
}

/*
  while (___) {
     __________
      if ( x < 1 ) {
       __________
      }
       __________
      if ( ______ ) {
       __________
      }
      if ( x == 1 ) {
       __________
      }
      if ( ______ ) {
       __________
      }
    System.out.println();
    _____________
  }
*/
