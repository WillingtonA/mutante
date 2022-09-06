package com.caso.mutante.services.impl;

import org.springframework.stereotype.Service;

import com.caso.mutante.dto.MutantDTO;
import com.caso.mutante.services.MutanteService;

@Service
public class MutanteServiceImpl implements MutanteService{
	
	public Boolean mutant(MutantDTO mutantDto) {	
		String dna[][] = new String[6][6];
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				dna[i][j] = String.valueOf(mutantDto.dna[i].charAt(j));
			}
		}
		
		int reg = 0;
		reg += this.valHorizontal(dna);
		reg += this.valVertical(dna);
		reg += this.valOblicua(dna);
		
		return (reg  > 1) ? true : false;
	}
	
	private int valHorizontal(String[][] dna) {
		int mutante = 0;
		for(int i=0; i<6; i++) {
			mutante = this.valFila(dna[i]);
			if(mutante > 0) {
				break;
			}
		}
		return mutante;
	}
	
	private int valVertical(String[][] dna) {
		String dnaNew[][] = new String[6][6];
		for(int i=0; i<6; i++) {
			for(int j=0; j<6; j++) {
				dnaNew[i][j] = dna[j][i];
			}
		}
		return valHorizontal(dnaNew);
	}
	
	private int valOblicua(String[][] dna) {
		String x[] = new String[6];
		for(int i=0; i<6; i++) {
			x[i] = dna[i][i];
		}
		return valFila(x);
	}
	
	private int valFila(String[] fila) {
		int mutante = 0;
		int cantidadLetras = 1;
		for(int i=0; i<5; i++) {
			cantidadLetras = (fila[i].equals(fila[i+1])) ? cantidadLetras+1 : 1;
			if(cantidadLetras >= 4) {
				//System.out.println("ARR: "+ Arrays.toString(fila));
				mutante++;
			}
		}
		//System.out.println("mutante: "+ mutante);
		return mutante;
	}
}
