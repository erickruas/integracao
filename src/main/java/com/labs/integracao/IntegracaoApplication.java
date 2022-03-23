package com.labs.integracao;

import com.labs.integracao.file.ReadFile;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.util.Arrays;

@SpringBootApplication
public class IntegracaoApplication {

    public static void main(String[] args)  {
        SpringApplication.run(IntegracaoApplication.class, args);
    } {

        var files = new File("/root/app/files/");

        Arrays.stream(files.listFiles())
                .forEach(ReadFile::createJson);
    }
}
