package com.labs.integracao;

import com.labs.integracao.util.FileHandler;

import java.io.IOException;

public class IntegracaoApplication {

	public static void main(String[] args) throws IOException {

		FileHandler fileHandler = new FileHandler();

		fileHandler.readFile();
		fileHandler.printJSON();

	}

}
