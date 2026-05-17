package center.jhub.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;

public class FileUtils {

    public static void doOnFile(String fileName, FileTransformer transformer) {
        doOnFile(fileName, transformer, transformer);
    }

    public static void doOnFile(String fileName, FileTransformer transformer, FileTransformer transformer2) {
        try {
            Enumeration<URL> enumeration = ClassLoader.getSystemResources(fileName);
            if (!enumeration.hasMoreElements()) {
                File f = new File(fileName);
                if (f.exists()) {
                    try (BufferedReader bf = new BufferedReader(new FileReader(f))) {
                        String json = bf.lines().reduce(String::concat).orElse("");
                        transformer.transform(json);
                    }
                    return;
                }
                try (BufferedReader bf = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName)))) {
                    String json = bf.lines().reduce(String::concat).orElse("");
                    transformer.transform(json);
                }
            } else {
                URL url = enumeration.nextElement();
                try (BufferedReader bf = new BufferedReader(new FileReader(url.getFile()))) {
                    String json = bf.lines().reduce(String::concat).orElse("");
                    transformer2.transform(json);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static interface FileTransformer {
        void transform(String json) throws IOException;
    }
}
