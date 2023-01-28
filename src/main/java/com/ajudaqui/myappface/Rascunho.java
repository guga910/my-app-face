package com.ajudaqui.myappface;

import java.math.BigDecimal;

public class Rascunho {
	public static void main(String[] args) {
		
//		km \ real
		Double distancia= 10.0;
		BigDecimal valor= new BigDecimal("50.00");
		
		BigDecimal resultado;
		
		resultado=valor.divide(new BigDecimal("2.6"));
		
		System.out.println(resultado);
		
	}

}
