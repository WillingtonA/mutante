package com.caso.mutante.dto;

import java.util.Arrays;

public class MutantDTO {
	public String dna[];

	@Override
	public String toString() {
		return "MutantDTO [dna=" + Arrays.toString(dna) + "]";
	}
	
}
