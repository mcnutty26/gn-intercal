package mcnutty.utils.cat;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) {

        if (args.length >= 1) {
            if (args[0].equals("-u")) {
                for (int i = 1; i < args.length; i++) {
                    if (args[i].equals("-")) {
                        ucatstdin();
                    } else {
                        ucatfile(args[i]);
                    }
                }
            } else {
                for (String arg : args) {
                    if (arg.equals("-")) {
                        catstdin();
                    } else {
                        catfile(arg);
                    }
                }
            }
        } else {
            catstdin();
        }

    }

    private static void catfile(String arg) {
        try {
            System.out.write(Files.readAllBytes(Paths.get(arg)));
        } catch (IOException e) {
            System.out.println("cat: IOException");
        }
    }

    private static void ucatfile(String arg) {
        int line;
            try (BufferedReader br = new BufferedReader(new FileReader(new File(arg)))) {
                while ((line = br.read()) != -1) {
                    System.out.print((char)line);
                }
            } catch (IOException e) {
                System.out.println("cat: " + arg + " No such file or directory");
            }
    }

    private static void catstdin() {
        String line;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("cat: IOException");
        }
    }

    private static void ucatstdin() {
        int line;
        try {
            while ((line = System.in.read()) != -1) {
                    System.out.print((char)line);
                }
        } catch (IOException e) {
            System.out.println("cat: IOException");
        }
    }

}
