package com.app.patterns;

public class Diwali {
	public static void main(String ...DeepawaliWhisehesByKarunakar) {
		int from=40;
		int karunakar=from,to=1;
		for(int everyone=1;everyone<=from;everyone++) {
			System.out.print(to>=1&&to<=3?" ":to==4&&everyone>19&&everyone<=20||to==5&&everyone>=19&&everyone<=21||to>=6&&to<=8&&everyone>=18&&everyone<=22||to==9&&everyone>=19&&everyone<=21||to==10&&everyone>19&&everyone<=20||to>=11&&to<=15&&everyone>=to&&everyone<=40-to?"*":" ");
			if(everyone==karunakar) {
				everyone=0;
				karunakar=from;to++;
				System.out.println("");
			}
			if(to==15)
				break;
		}
		System.out.println("\n============Happy Deepawali=======");
	}
}
