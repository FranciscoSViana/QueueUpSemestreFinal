package com.queueup.queueup.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.queueup.queueup.utils.FilaCliente;

@Service
public class FilaService {

	public List<FilaCliente> filaList = new ArrayList<FilaCliente>();
	
	public Integer addFila(FilaCliente fila) {
		if (filaList.size() > 0) {
			int count = 1;
			for (FilaCliente filaCliente : filaList) {
				if (filaCliente.getIdRestaurante() == fila.getIdRestaurante())
					count++;
			}
			fila.setPosicao(count);
			filaList.add(fila);
			return count;
		} else {
			fila.setPosicao(1);
			filaList.add(fila);
			return filaList.size();
		}
	}

	public Integer posicaoFila(int restaurante, int cliente) {
		for (FilaCliente fila : filaList) {
			if (fila.getIdRestaurante() == restaurante && fila.getIdCliente() == cliente) {
				return fila.getPosicao();
			}
		}
		return 0;
	}

	public void removefila(int restaurante) {
		int index = 0;
		int count = 0;
		for (FilaCliente fila : filaList) {
			if (fila.getIdRestaurante() == restaurante && fila.getPosicao() == 1)
				index = count;
			count++;
		}
		filaList.remove(index);
		remanejar(restaurante);
	}

	public void remanejar(int restaurante) {
		for (FilaCliente fila : filaList) {
			if (fila.getIdRestaurante() == restaurante) {
				fila.setPosicao(fila.getPosicao() - 1);
			}
		}
	}
	
	public List<FilaCliente> getAll(int restaurante){
		List<FilaCliente> filaRestaurante = new ArrayList<FilaCliente>();
		for (FilaCliente fila : filaList) {
			if(fila.getIdRestaurante() == restaurante) {
				filaRestaurante.add(fila);
			}
		}
		return filaRestaurante;
	}

}
