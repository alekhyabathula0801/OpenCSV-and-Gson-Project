package com.opencsvandgsonproject;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriterAndReader {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\OpenCSVandGsonProject\\src\\main\\resources\\sample.csv";

    public static void readOpenCSV() {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<CSVUser> csvUsers = csvToBean.parse();

            for(CSVUser csvUser: csvUsers) {
                System.out.println(csvUser);
                System.out.println("Name : "+csvUser.getName());
                System.out.println("Email : "+csvUser.getEmail());
                System.out.println("Phone Number : "+csvUser.getPhoneNum());
                System.out.println("Country : "+csvUser.getCountry());
                System.out.println("---------------------------");
            }
        } catch (IOException e){
            System.out.println("No record found");
        }
    }

    private static void writeInOpenCSV() {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH));
        ) {
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder<CSVUser>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<CSVUser> CSVUsers = new ArrayList<>();
            CSVUsers.add(new CSVUser("Sweety","sweety@gmail.com","+923-2345678901","LONDON"));
            CSVUsers.add(new CSVUser("Satya","satya12@gmail.com","+21-54278190","USA"));
            CSVUsers.add(new CSVUser("Adhya","adhya12@gmail.com","+721-82354278190","USA"));

            beanToCsv.write(CSVUsers);

        } catch (Exception e) {
            System.out.println("No record found");
        }
    }

    public static void main(String[] args){
        writeInOpenCSV();
        readOpenCSV();
    }
}
