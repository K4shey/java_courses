package academy.devonline.java.oop.section031_polymorphism;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class FromClasspathResourceArrayElementsProvider implements ArrayElementsProvider {
    private BufferedReader reader;

    private String line;

    public FromClasspathResourceArrayElementsProvider(String resourceName) {
        this.reader = new BufferedReader(
                new InputStreamReader(
                        Objects.requireNonNull(
                                FromClasspathResourceArrayElementsProvider.class.getResourceAsStream(resourceName)
                        )
                )
        );
    }

    @Override
    public boolean hasMoreElements() {
        try {
            line = reader.readLine();
        } catch (IOException e) {
            line = null;
        } finally {
            if (line == null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return line != null;
    }

    @Override
    public int nextElement() {
        return Integer.parseInt(line);
    }
}
