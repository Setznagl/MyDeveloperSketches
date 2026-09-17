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


  }
}
