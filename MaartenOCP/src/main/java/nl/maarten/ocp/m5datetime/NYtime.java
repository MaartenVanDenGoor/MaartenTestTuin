package nl.maarten.ocp.m5datetime;
import java.time.*;

public class NYtime {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime vertrek = LocalDateTime.of(2016,10,29,11,30);
		ZoneId zoneA = ZoneId.of("Europe/Amsterdam");
		ZonedDateTime vertrekZoneA = ZonedDateTime.of(vertrek, zoneA); 	
		ZoneId zoneN = ZoneId.of("America/New_York");
		ZonedDateTime vertrekZoneN= vertrekZoneA.withZoneSameInstant(zoneN);
		ZonedDateTime aankomstN = vertrekZoneN.plusHours(8)
				                              .plusMinutes(30);
		System.out.println("Aankomst in New York "+aankomstN);
		System.out.println("========================================");
		//
		vertrek = vertrek.plusDays(7);
		vertrekZoneN = ZonedDateTime.of(vertrek, zoneN);
		vertrekZoneA = vertrekZoneN.withZoneSameInstant(zoneA);		
		ZonedDateTime aankomstA = vertrekZoneA.plusHours(8)
		                                      .plusMinutes(30);
        System.out.println("Aankomst in Amsterdam " +aankomstA);
		
	} 
}
/*
(Optioneel) Een week later vertrekt een ander vliegtuig ook om half 11 ’s ochtends vanuit New York. 
Hoe laat komt dit vliegtuig aan in Schiphol? 
*/