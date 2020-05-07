package com.opencsvandgsonproject;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class OpenCSVReader {
    private static final String CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\OpenCSVandGsonProject\\src\\main\\resources\\demo.csv";

    public static void main(String[] args) {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(CSV_FILE_PATH));
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
            System.out.println("No Record found");
        }
    }
}
