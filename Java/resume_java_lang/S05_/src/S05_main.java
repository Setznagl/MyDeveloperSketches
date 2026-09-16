public class S05_main {
    static void main() {

        String word = "Crate";
        String word2 = "Crate";
        System.out.println(word.hashCode());
        System.out.println(word2.hashCode());
        System.out.println(word.equals(word2));

            System.out.println("\n");

        Object word3 = "Cat";
        Object word4 = "Cat";
        System.out.println(word3.hashCode());
        System.out.println(word4.hashCode());
        System.out.println(word3.equals(word4));

            System.out.println("\n");

        AnimalRawClass animal1 = new AnimalRawClass("Medeia" , 7);
        AnimalRawClass animal2 = new AnimalRawClass("Medeia" , 7);
        System.out.println(animal1.hashCode());
        System.out.println(animal2.hashCode());
        System.out.println(animal1.equals(animal2));

            System.out.println("\n");

        AnimalClass animal3 = new AnimalClass("Medeia" , 7);
        AnimalClass animal4 = new AnimalClass("Medeia" , 7);
        System.out.println(animal3.hashCode());
        System.out.println(animal4.hashCode());
        System.out.println(animal3.equals(animal4));

            System.out.println("\n");

        // Using clone internface to replicate
        // clone() will set the memory pointer references
        // to attributes which it can't resolve when clone, which might be a problem.
        AnimalClass animal5 = animal4.clone();
        System.out.println(animal5.hashCode());
        System.out.println(animal5.equals(animal4));

    }
}
