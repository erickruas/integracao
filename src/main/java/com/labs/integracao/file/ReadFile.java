package com.labs.integracao.file;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.labs.integracao.domain.Customer;
import com.labs.integracao.lineConfig.LineTreatment;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ReadFile {

    public static void createJson(File file) {
        ArchiveReader archiveReader = new ArchiveReader();
        BufferedReader br = archiveReader.readFile(file.getPath());

        LineTreatment lineTreatment = new LineTreatment();
        List<Customer> customerList = lineTreatment.readLinesFromBr(br);

        JsonParser jsonParser = new JsonParser();
        ObjectMapper objectMapper = jsonParser.configureMapper();

        if(customerList !=null) {

            String output = "/root/app/files/" + new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".json";

            try {
                objectMapper.writeValue(new File(output), customerList);
                System.out.print("JSON created. FileName = " + file.getName() + output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
