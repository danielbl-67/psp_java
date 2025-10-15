public class Ej1_InheritIO {
    public static void main(String[] args) throws Exception {
        int return_code = new ProcessBuilder(Utils.sh(String.join(" ", args)))
                .inheritIO()
                .start()
                .waitFor();
    }
}
