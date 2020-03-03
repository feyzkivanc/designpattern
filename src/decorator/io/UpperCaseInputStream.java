package decorator.io;



import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

    public class UpperCaseInputStream extends FilterInputStream {


        public UpperCaseInputStream(InputStream in) {
            super(in);
        }

        @Override
        public int read() throws IOException {
            int x = super.read();
            return x == -1 ? x : Character.toUpperCase(x);
        }

        @Override
        public int read(byte b[]) throws IOException {
            byte x[] = new byte[b.length];
            int total = in.read(x, 0, x.length);
            if (total != -1) {
                for (int i = 0; i < total; i++) {
                    b[i] = (byte) Character.toUpperCase(x[i]);
                }
            }
            return total;
        }

        @Override
        public int read(byte b[], int off, int len) throws IOException {
            byte x[] = new byte[b.length];
            int total = in.read(x, off, len);
            if (total != -1) {
                for (int i = off; i < off + total; i++) {
                    b[i] = (byte) Character.toUpperCase(x[i]);
                }
            }
            return total;
        }
    }
