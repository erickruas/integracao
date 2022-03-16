package com.labs.integracao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.integracao.lineConfig.LineTreatment;
import com.labs.integracao.domain.Customer;
import com.labs.integracao.file.ArchiveReader;
import com.labs.integracao.file.JsonParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class IntegracaoApplication {

    public static void main(String[] args)  {
        SpringApplication.run(IntegracaoApplication.class, args);
    } {

        ArchiveReader archiveReader = new ArchiveReader();
        BufferedReader br = archiveReader.readFile("/root/app/files/input.txt");

        LineTreatment lineTreatment = new LineTreatment();
        List<Customer> customerList = lineTreatment.readLinesFromBr(br);

        if(customerList != null){

            JsonParser jsonParser = new JsonParser();
            ObjectMapper objectMapper = jsonParser.configureMapper();

            String output = "/root/app/files/" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".json";

            try {
                objectMapper.writeValue(new File(output), customerList);
                System.out.print("JSON created. FileName = " + output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
