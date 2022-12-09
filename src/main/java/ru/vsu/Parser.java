package ru.vsu;

import au.com.bytecode.opencsv.CSVReader;
import ru.vsu.beans.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    /**
     * reading data from a file to a list
     * @param path - the path to the file containing the data
     * @return list of people
     * @throws IOException
     */
    static List<Person> getPersonList(String path) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(path), ';');
        if (reader == null) {
            throw new FileNotFoundException(path);
        }
        List<Person> people = new ArrayList<>();
        String[] nextLine = reader.readNext();
        while ((nextLine = reader.readNext()) != null) {
            if (nextLine != null) {
                people.add(new Person(Integer.parseInt(nextLine[0]), nextLine[1], nextLine[2], Integer.parseInt(nextLine[5]), nextLine[3], getDepartmentID(nextLine[4], people), nextLine[4]));
            }
        }
        return people;
    }

    /**
     * list output
     * @param list list of people
     */
    static void print(List<Person> list) {
        for (Person i : list) {
            System.out.println(i.toString());
        }
    }

    /**
     * id generation for Departments
     * @param name  name of Departments
     * @param list list of people
     * @return id Department
     */
    private static int getDepartmentID(String name, List<Person> list) {
        int id = -1, maxId = -1;
        for (Person i : list) {
            if (i.getDepartment().getName().compareTo(name) == 0) {
                id = i.getDepartment().getID();
                break;
            }
            if (i.getDepartment().getID() > maxId) {
                maxId = i.getDepartment().getID();
            }
        }
        if (id == -1) {
            return maxId + 1;
        }
        return id;
    }
}
