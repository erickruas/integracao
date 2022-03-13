package com.labs.integracao;

import com.labs.integracao.util.FileHandler;

public class IntegracaoApplication {

	public static void main(String[] args) {

		FileHandler fileHandler = new FileHandler();
		fileHandler.readFile("data_1.txt");
		fileHandler.writeFile("data_1.json");

	}
}
