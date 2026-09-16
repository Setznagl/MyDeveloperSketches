public class S07_main {
    static void main() {

        String java = "java";
        String ja_va = "ja" + "va";

        /*
                         JVM
                          │
                     ┌────┴────┐
                     │  Heap   │
                     └────┬────┘
                          │
              String Pool / interned Strings
                    ┌───────────────┐
                    │    "java"     │
                    │    "ja"       │
                    │    "va"       │
                    └───────────────┘
                           ▲
                           │
                          java

             String x = new String("java")
             copy the literal value to instance a new object
             instead of use the reference which already exists.
         */
        String new_string_java = new String("java");

        System.out.println("Hash codes:");
        System.out.println(java.hashCode());
        System.out.println(ja_va.hashCode());
        System.out.println(new_string_java.hashCode());

            System.out.println("\n");

        System.out.println("Memory references:");
        System.out.println(System.identityHashCode(java) + "  | String Pool");
        System.out.println(System.identityHashCode(ja_va) + "  | String Pool");
        System.out.println(System.identityHashCode(new_string_java) + "  | String x = new String() reference");

        System.out.println("new String() doesn't avoid String Pool completely, just doesn't use the reference which" +
        " contains the literal, opting to create a new instance copying the value, thats why the reference is different.");

            System.out.println("\n");

        System.out.println("java == ja+va | " + (java == ja_va) );
        System.out.println("java == new_string_java | " + (java == new_string_java) );
        System.out.println("java.equals(ja+va) | " + (java.equals(ja_va)) );
        System.out.println("java.equals(new_string_java) | " + (java.equals(new_string_java)) );

            System.out.println("\n");

        String JAVA = "JAVA";
        System.out.println((JAVA) + "  |  " + JAVA.hashCode());
        System.out.println((JAVA) + "  |  " + System.identityHashCode(JAVA));
        System.out.println("JAVA.equals(java) " + JAVA.equals(java));
        System.out.println("JAVA.equalsIgnoreCase(java) " + JAVA.equalsIgnoreCase(java));

        System.out.println("\n");
        System.out.println("|     Sum the value of all the unicode char's to compare (only if they've the same lenght)       |");
        System.out.println("JAVA.compareTo(java) " + JAVA.compareTo(java));
        System.out.println("java.compareTo(java) " + java.compareTo(java));
        System.out.println("java.compareTo(ja_va) " + java.compareTo(ja_va));
        System.out.println("|     Otherwise uses length()        |");
        System.out.println("java.compareTo(javascript) " + java.compareTo("javascript"));
        System.out.println("javascript.compareTo(java) " + "javascript".compareTo(java));

    }
}
