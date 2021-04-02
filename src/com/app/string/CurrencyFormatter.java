package com.app.string;

import java.text.NumberFormat;
import java.util.Locale;

public class CurrencyFormatter {
	public static void main(String[] args) {
		int c=123345;
		NumberFormat uf=	NumberFormat.getCurrencyInstance(Locale.US);
		String us=uf.format(c);
		NumberFormat inf=	NumberFormat.getCurrencyInstance(new Locale("en","IN"));
		String in=inf.format(c);
		NumberFormat chf=	NumberFormat.getCurrencyInstance(Locale.CHINA);
		String ch=chf.format(c);
		NumberFormat ff=	NumberFormat.getCurrencyInstance(Locale.FRANCE);
		String fr=ff.format(c);

		System.out.println(us);
		System.out.println(in);
		System.out.println(ch);
		System.out.println(fr);

	}
}
