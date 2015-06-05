package exercise05;

import java.io.*;

/**
 * Changes:
 * 
 * - Added Writer
 * - changed for loop 
 * 
 * @author kelu
 */
public class CsvWriter {

    private Writer out;
    
    public CsvWriter() {
        out = new StringWriter();
    }
    
    public CsvWriter(Writer writer) {
        out = writer;
    }

    public void write(String[][] lines) throws IOException {
        for (String[] line : lines) {
            writeLine(line);
        }
    }

    private void writeLine(String[] fields) throws IOException {
        if (fields.length == 0) {
            out.write("\n");
        } else {
            writeField(fields[0]);

            for (int i = 1; i < fields.length; i++) {
                out.write(",");
                writeField(fields[i]);
            }
            out.write("\n");
        }
    }

    private void writeField(String field) throws IOException {
        if (field.indexOf(',') != -1 || field.indexOf('\"') != -1) {
            writeQuoted(field);
        } else {
            out.write(field);
        }
    }

    private void writeQuoted(String field) throws IOException {
        out.write('\"');
        for (int i = 0; i < field.length(); i++) {
            char c = field.charAt(i);
            if (c == '\"') {
                out.write("\"\"");
            } else {
                out.write(c);
            }
        }
        out.write('\"');
    }
    
    public Writer getWriter() {
        return out;
    }
    
    @Override
    public String toString() {
        return out.toString();
    }
}
