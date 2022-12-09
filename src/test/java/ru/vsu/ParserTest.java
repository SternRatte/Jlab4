package ru.vsu;

import ru.vsu.beans.Person;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ParserTest {

    @org.junit.jupiter.api.Test
    void getPersonList() {
        Parser temp = new Parser();
        String path = null;
        Throwable thrown = assertThrows(NullPointerException.class, () -> {
            temp.getPersonList(path);
        });
    }

    @org.junit.jupiter.api.Test
    void print() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Parser temp = new Parser();
        File file = new Main.GetFile().getFileFromResources("foreign_names.csv");
        String path = String.valueOf(file);
        List<Person> list = temp.getPersonList(path);
        temp.print(list);

        String expectedOutput = new String();
        for (Person i : list) {
            expectedOutput += i.toString();
            expectedOutput += "\n";
        }

        assertEquals(expectedOutput, outContent.toString());
    }
}
