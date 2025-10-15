import java.io.*;

public class Ej1_Basico {
    public static void main(String[] args) throws Exception {
        Utils.imprimeArgs(args);

        try {
            // Crea un proceso con el comando recibido
            Process proceso = new ProcessBuilder(Utils.sh(String.join(" ", args))).start();

            // Lee la salida del proceso
            InputStream flujo = proceso.getInputStream();
            InputStreamReader lector = new InputStreamReader(flujo);
            BufferedReader br = new BufferedReader(lector);

            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

            int return_code = proceso.waitFor(); // Espera a que acabe
            if (return_code != 0) {
                throw new Exception("El comando no es correcto");
            }

            System.out.println("Code: " + return_code);

            // Ejecuta un segundo proceso de ejemplo
            Process p = new ProcessBuilder(Utils.sh("echo hola")).start();
            int rc = p.waitFor();
            System.out.println("RC=" + rc);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}

