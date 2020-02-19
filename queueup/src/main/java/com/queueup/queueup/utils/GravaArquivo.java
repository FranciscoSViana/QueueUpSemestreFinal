package com.queueup.queueup.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.FormatterClosedException;

import com.queueup.queueup.controller.Credenciais;

public class GravaArquivo {

	public static void gravaArquivo(ListaObj<Credenciais> lista) {
		FileWriter arq = null;
		Formatter saida = null;
		boolean error = false;
		String nomeArquivo;
		
		nomeArquivo= "Acessos.csv";
		
		try {
			arq = new FileWriter(nomeArquivo, true);
			saida = new Formatter(arq);
		}
		catch (IOException erro) {
			System.err.println("Erro ao abrir arquivo.");
			System.exit(1);
		}
		
		try {
			for (int i=0; i < lista.getTamanho(); i++) {
				Credenciais a = lista.getElemento(i);
					saida.format("%s;%s;%n",a.getLogin()
											,a.getSenha());
			}
		}
		catch (FormatterClosedException erro )
        {
           System.err.println("Erro ao gravar no arquivo.");
           error= true;
        }
		finally {
			saida.close();
			try {
				arq.close();
			}
			catch (IOException erro) {
				System.err.println("Erro ao fechar arquivo.");
				error = true;
			}
			if (error) {
				System.exit(1);
			}
		}
	}
}
