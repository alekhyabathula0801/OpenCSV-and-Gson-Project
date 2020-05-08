package com.opencsvandgsonproject;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
// read from CSV file and write in Json file
public class OpenCSVAndGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\OpenCSVandGsonProject\\src\\main\\resources\\sample.csv";
    private static final String SAMPLE_JSON_FILE_PATH = "C:\\Users\\arun kumar\\IdeaProjects\\OpenCSVandGsonProject\\src\\main\\resources\\sample.json";

    public static void main(String[] args){
        try {
            Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                    .withType(CSVUser.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
            writer.write(json);
            writer.close();
            BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
            CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
            List<CSVUser> csvUserList = Arrays.asList(usrObj);

            for(CSVUser csvUser: csvUserList) {
                System.out.println(csvUser);
                System.out.println("Name : "+csvUser.getName());
                System.out.println("Email : "+csvUser.getEmail());
                System.out.println("Phone Number : "+csvUser.getPhoneNum());
                System.out.println("Country : "+csvUser.getCountry());
                System.out.println("---------------------------");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
