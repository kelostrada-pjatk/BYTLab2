package exercise04;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Person {

    public String last;

    public String first;

    public String middle;

    public Person(String last, String first, String middle) {
        this.last = last;
        this.first = first;
        this.middle = middle;
    }

    public void printPerson(Writer out) throws IOException {
        out.write(first);
        out.write(" ");
        if (middle != null) {
            out.write(middle);
            out.write(" ");
        }
        out.write(last);
    }

    public String formatPerson() throws IOException {
        StringWriter writer = new StringWriter();
        display(writer);
        return writer.toString();
    }

    public void display(Writer out) throws IOException {
        out.write(last);
        out.write(", ");
        out.write(first);
        if (middle != null) {
            out.write(" ");
            out.write(middle);
        }
    }

    @Override
    public String toString() {
        try {
            return formatPerson();
        } catch (IOException ex) {
            return null;
        }
    }
}
