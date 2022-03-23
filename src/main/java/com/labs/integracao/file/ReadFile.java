package com.labs.integracao.file;

import com.labs.integracao.lineConfig.LineTreatment;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReadFile {

    public static void createJson(File file) {
        var br = ArchiveReader.readFile(file.getPath());

        var customerList = LineTreatment.readLinesFromBr(br);

        var objectMapper = JsonParser.configureMapper();

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
