package com.company;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OpenCSVReadWrite {

    private static final String FILE_NAME = "test.csv";
    private static List<Person> createNewList = new ArrayList<Person>();

    public static void wtriteWithOpenCSV(Set<Person> people){
        File file = new File(FILE_NAME);
        try {
            // create FileWriter object with file as parameter
            FileWriter outputfile = new FileWriter(file);

            // create CSVWriter object filewriter object as parameter
            CSVWriter writer = new CSVWriter(outputfile);

            for (Person tmp : people){
                createNewList.add(tmp);
            }

            List<String[]> data = new ArrayList<String[]>();
            for (Person tmp2: createNewList){
                data.add(new String[] {tmp2.getName(),tmp2.getSurname(),tmp2.getPhoneNumber()});
            }

            writer.writeAll(data);
            writer.close();

        }    catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Set<Person> readWithOpenCSV() {

        Set<Person> readSet = new HashSet<Person>();
        Person fromBookPerson;
        List<String[]> records;

        try {
                Reader reader = Files.newBufferedReader(Paths.get(FILE_NAME));
                CSVReader csvReader = new CSVReader(reader);

                // Reading All Records at once into a List<String[]>
                records = csvReader.readAll();
                for (String[] record : records) {
                    fromBookPerson  = new Person(record[2],record[0],record[1]);
                    readSet.add(fromBookPerson);
                }
            }catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        return readSet;
    }

}
