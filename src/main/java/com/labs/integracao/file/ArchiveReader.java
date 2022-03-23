package com.labs.integracao.file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ArchiveReader {

    public static BufferedReader readFile(String readFileName) {

        try {
            var br = new BufferedReader(
                    new FileReader(readFileName));
            return br;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}