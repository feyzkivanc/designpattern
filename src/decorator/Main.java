package decorator;
import decorator.io.UpperCaseInputStream;
import decorator.io.LowerCaseInputStream;
import java.io.*;
import java.io.IOException;
import java.io.FilePermission;
import java.io.File;
public class Main {
    FilePermission permission;




    public Main() throws IOException {
    }

    public static void main(String[] args) throws FileNotFoundException {
        String description = new String();



            int i;
            FileInputStream input = null;
            FileOutputStream output = null;

            try {
                input = new FileInputStream("C:\\\\Users\\\\Lenovo\\\\Desktop\\\\hw1\\\\input.txt");
                output = new FileOutputStream("C:\\\\Users\\\\Lenovo\\\\Desktop\\\\hw1\\\\output.txt");

                do {
                    i = input.read();
                    if (i != -1) {
                        output.write(i);
                    }
                } while (i != -1);
            } catch (final IOException f) {
                f.printStackTrace();
            } finally {
                try {
                    if (input != null) {
                        input.close();
                    }

                } catch (final IOException f) {
                    f.printStackTrace();
                }
                try {
                    if (output != null) {
                        output.close();
                    }
                } catch (final IOException e2) {
                    e2.printStackTrace();
                }
                PrintStream out = new PrintStream
                        (new FileOutputStream
                                ("output.txt"));
                System.setOut(out);
            }




        testLowerCaseInputStream();
        testUpperCaseInputStream();
    }

    private static void testUpperCaseInputStream() {
        int x;
        try {
            InputStream in = new UpperCaseInputStream(
                    new BufferedInputStream (
                            new FileInputStream("input.txt")));

            while( ( x = in.read() ) >= 0 ) {
                System.out.print( (char) x );
            }

            in.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }

    private static void testLowerCaseInputStream() {
        int c;
        try {
            InputStream in = new LowerCaseInputStream(
                    new BufferedInputStream (
                            new FileInputStream("input.txt")));

            while( ( c = in.read() ) >= 0 ) {
                System.out.print( (char) c );
            }

            in.close();
        } catch( IOException e ) {
            e.printStackTrace();
        }
    }
}


