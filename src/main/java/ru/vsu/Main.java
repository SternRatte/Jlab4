package ru.vsu;

import ru.vsu.beans.Person;
import java.io.File;
import java.net.URL;
import java.util.List;

public class Main {
    public static class GetFile {
        /**
         * getting a file from classpath, resource folder
         * @param fileName   the name of the required file from resources
         * @return required file from resources
         */
        protected File getFileFromResources(String fileName) {

            ClassLoader classLoader = getClass().getClassLoader();

            URL resource = classLoader.getResource("foreign_names.csv");
            if (resource == null) {
                throw new IllegalArgumentException("file is not found!");
            } else {
                return new File(resource.getFile());
            }
        }
    }

    public static void main(String[] args) throws Exception {
        File file = new GetFile().getFileFromResources("foreign_names.csv");
        String path = String.valueOf(file);
        List<Person> people = Parser.getPersonList(path);
        Parser.print(people);
    }
}

