import java.io.IOException;

@SuppressWarnings("ALL")
public class S04_main {
    void main(String[] args) throws IOException {

        String example01 = "A thing!";
        Class<? extends String> example01_class = example01.getClass();
        System.out.println(example01_class);

        AnimalClass example02 = new AnimalClass("Medeia" , 7);
        Class<? extends AnimalClass> example02_class = example02.getClass();
        System.out.println(example02_class);

            System.out.println("\n");

        Package S04_package = AnimalClass.class.getPackage();
        System.out.println(S04_package);
        System.out.println("Possível extrair muitos metadados do pacote");

            System.out.println("\n");

        Module S04_module = AnimalClass.class.getModule();
        System.out.println(S04_module);
        System.out.println(S04_module.getPackages());
        System.out.println("Possível extrair metadados, configurações e estados do módulo");

            System.out.println("\n");

        System.out.println(Runtime.getRuntime());
        System.out.println(Runtime.getRuntime().availableProcessors());
        System.out.println(Runtime.getRuntime().freeMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().version());
        //Chamando garbage collector expressamente
        Runtime.getRuntime().gc();

        System.out.println(Runtime.getRuntime()
                .exec(new String[]
                        {
                                "brave" ,
                                "brave-origin" ,
                                "https://www.youtube.com/watch?v=FNYA82Fn5m4"
                        }));

            System.out.println("\n");

        System.out.println(ProcessHandle.allProcesses());
        System.out.println(ProcessHandle.current());
        System.out.println(ProcessHandle.of(Runtime.getRuntime().availableProcessors()));

    }

}
