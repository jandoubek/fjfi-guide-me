package cz.fjfi.guideme.core;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import cz.fjfi.guideme.core.GMMap;

public class TrojankaMap {

	/**
	 * @param args
	 */
	public static GMMap Trojanka(UUID guid1,	 UUID guid2)
	{
		int timeCard = 8000; // k ‹emu??
		int spd = 1000; // sekunda ma 1000 milisekund - cas pak doplnovat v sekundach nasoben touto konstantou  
		GMMap myMap = new GMMap();
		myMap.setAuthorName("KBen");
		myMap.setAuthorEmail("email@email.com");
		myMap.setDescription("Mapa budovy FJFI ÈVUT, Trojanova 13, Praha 2");
		myMap.setGuid(Utility.generateGUID());
		myMap.setName("Trojanka");
		
		UUID locguid = Utility.generateGUID();
		List<UUID> loclist = new LinkedList<UUID>();
		loclist.add(locguid);
		Location l01 = new Location(Utility.generateGUID(),	 "l01",	 "chodba",	 myMap);
		Location l02 = new Location(Utility.generateGUID(),	 "l02",	 "severní chodba KM",	 myMap);
		Location l03 = new Location(Utility.generateGUID(),	 "l03",	 "hlavní chodba KM",	 myMap);
		Location l04 = new Location(Utility.generateGUID(),	 "l04",	 "jižní chodba KM",	 myMap);
		Location l05 = new Location(Utility.generateGUID(),	 "l05",	 "západní chodba u vrátnice",	 myMap);
		Location l06 = new Location(Utility.generateGUID(),	 "l06",	 "vrátnice",	 myMap);
		Location l07 = new Location(Utility.generateGUID(),	 "l07",	 "východní chodba u vrátnice",	 myMap);
		Location l08 = new Location(Utility.generateGUID(),	 "l08",	 "severní chodba u vrátnice",	 myMap);
		Location l09 = new Location(Utility.generateGUID(),	 "l09",	 "chodba vedoucí k T-101",	 myMap);
		Location l10 = new Location(Utility.generateGUID(),	 "l10",	 "chodba vedoucí k T-101",	 myMap);
		Location l11 = new Location(Utility.generateGUID(),	 "l11",	 "chodba vedoucí k T-101",	 myMap);
		Location l12 = new Location(Utility.generateGUID(),	 "l12",	 "chodba pøed T-101",	 myMap);
		Location l13 = new Location(Utility.generateGUID(),	 "l13",	 "jižní chodba KFE",	 myMap);
		Location l14 = new Location(Utility.generateGUID(),	 "l14",	 "hlavní chodba KFE",	 myMap);
		
		Location lr01 = new Location(Utility.generateGUID(),	 "lr01",	 "WC",	 myMap);
		Location lr02 = new Location(Utility.generateGUID(),	 "lr02",	 "T-116",	 myMap);
		Location lr03 = new Location(Utility.generateGUID(),	 "lr03",	 "T-115",	 myMap);
		Location lr04 = new Location(Utility.generateGUID(),	 "lr04",	 "T-115B,	 katedra matematiky",	 myMap);
		Location lr05 = new Location(Utility.generateGUID(),	 "lr05",	 "T-112",	 myMap);
		Location lr06 = new Location(Utility.generateGUID(),	 "lr06",	 "T-111",	 myMap);
		Location lr07 = new Location(Utility.generateGUID(),	 "lr07",	 "T-110",	 myMap);
		Location lr08 = new Location(Utility.generateGUID(),	 "lr08",	 "T-109",	 myMap);
		Location lr09 = new Location(Utility.generateGUID(),	 "lr09",	 "T-108",	 myMap);
		Location lr10 = new Location(Utility.generateGUID(),	 "lr10",	 "T-107",	 myMap);
		Location lr11 = new Location(Utility.generateGUID(),	 "lr11",	 "T-106",	 myMap);
		Location lr12 = new Location(Utility.generateGUID(),	 "lr12",	 "T-105",	 myMap);
		Location lr13 = new Location(Utility.generateGUID(),	 "lr13",	 "T-104",	 myMap);
		Location lr14 = new Location(Utility.generateGUID(),	 "lr14",	 "vchod",	 myMap);
		Location lr15 = new Location(Utility.generateGUID(),	 "lr15",	 "T-101",	 myMap);
		Location lr16 = new Location(Utility.generateGUID(),	 "lr16",	 "...",	 myMap);
		Location lr17 = new Location(Utility.generateGUID(),	 "lr17",	 "WC",	 myMap);
		Location lr18 = new Location(Utility.generateGUID(),	 "lr18",	 "T-118",	 myMap);
		Location lr19 = new Location(Utility.generateGUID(),	 "lr19",	 "T-119,	 katedra fyzikální elektroniky",	 myMap);
		Location lr20 = new Location(Utility.generateGUID(),	 "lr20",	 "T-120",	 myMap);
		Location lr21 = new Location(Utility.generateGUID(),	 "lr21",	 "T-121",	 myMap);
		Location lr22 = new Location(Utility.generateGUID(),	 "lr22",	 "T-122",	 myMap);
		Location lr23 = new Location(Utility.generateGUID(),	 "lr23",	 "T-123",	 myMap);
		Location lr24 = new Location(Utility.generateGUID(),	 "lr24",	 "T-124",	 myMap);
		Location lr25 = new Location(Utility.generateGUID(),	 "lr25",	 "T-125",	 myMap);
		Location lr26 = new Location(Utility.generateGUID(),	 "lr26",	 "T-126",	 myMap);
		Location lr27 = new Location(Utility.generateGUID(),	 "lr27",	 "...",	 myMap);
		
		myMap.addLocation(l01); myMap.addLocation(l02); myMap.addLocation(l03); myMap.addLocation(l04);
		myMap.addLocation(l05); myMap.addLocation(l06); myMap.addLocation(l07); myMap.addLocation(l08);
		myMap.addLocation(l09); myMap.addLocation(l10); myMap.addLocation(l11); myMap.addLocation(l12);
		myMap.addLocation(l13); myMap.addLocation(l14); myMap.addLocation(lr01); myMap.addLocation(lr02); 
		myMap.addLocation(lr03); myMap.addLocation(lr04); myMap.addLocation(lr05); myMap.addLocation(lr06);
		myMap.addLocation(lr07); myMap.addLocation(lr08); myMap.addLocation(lr09); myMap.addLocation(lr10);
		myMap.addLocation(lr11); myMap.addLocation(lr12); myMap.addLocation(lr13); myMap.addLocation(lr14);
		myMap.addLocation(lr15); myMap.addLocation(lr16); myMap.addLocation(lr17); myMap.addLocation(lr18);
		myMap.addLocation(lr19); myMap.addLocation(lr20); myMap.addLocation(lr21); myMap.addLocation(lr22);
		myMap.addLocation(lr23); myMap.addLocation(lr24); myMap.addLocation(lr25); myMap.addLocation(lr26);
		myMap.addLocation(lr27);
 
		GMNode r01 = new GMNode(guid1,						"r01",	 loclist,	 l01.getDescription(),	 myMap);
		GMNode s01 = new GMNode(Utility.generateGUID(),	 "s01",	 loclist,	 l01.getDescription(),	 myMap);
		GMNode l01l03 = new GMNode(Utility.generateGUID(),	 "l01l03",	 loclist,	 "pøechod mezi " + l01.getDescription() + " a " + l03.getDescription(),	 myMap);
		GMNode r02 = new GMNode(Utility.generateGUID(),	 "r02",	 loclist,	 l02.getDescription(),	 myMap);
		GMNode r03 = new GMNode(Utility.generateGUID(),	 "r03",	 loclist,	 l02.getDescription(),	 myMap);
		GMNode r04 = new GMNode(Utility.generateGUID(),	 "r04",	 loclist,	 l02.getDescription(),	 myMap);
		GMNode l02l03 = new GMNode(Utility.generateGUID(),	 "l02l03",	 loclist,	 "pøechod mezi " + l02.getDescription() + " a " + l03.getDescription(),	 myMap);
		GMNode r05 = new GMNode(Utility.generateGUID(),	 "r05",	 loclist,	 l03.getDescription(),	 myMap);
		GMNode r06 = new GMNode(Utility.generateGUID(),	 "r06",	 loclist,	 l03.getDescription(),	 myMap);
		GMNode r07 = new GMNode(Utility.generateGUID(),	 "r07",	 loclist,	 l03.getDescription(),	 myMap);
		GMNode r08 = new GMNode(Utility.generateGUID(),	 "r08",	 loclist,	 l03.getDescription(),	 myMap);
		GMNode r09 = new GMNode(guid2,	 				 "r09",	 loclist,	 l03.getDescription(),	 myMap);
		GMNode r10 = new GMNode(Utility.generateGUID(),	 "r10",	 loclist,	 l03.getDescription(),	 myMap);
		GMNode r11 = new GMNode(Utility.generateGUID(),	 "r11",	 loclist,	 l03.getDescription(),	 myMap); 
		GMNode l03l04 = new GMNode(Utility.generateGUID(),	 "l03l04",	 loclist,	 "pøechod mezi " + l03.getDescription() + " a " + l04.getDescription(),	 myMap);
		GMNode r12 = new GMNode(Utility.generateGUID(),	 "r12",	 loclist,	 l04.getDescription(),	 myMap);
		GMNode r13 = new GMNode(Utility.generateGUID(),	 "r13",	 loclist,	 l04.getDescription(),	 myMap);
		GMNode l04l05 = new GMNode(Utility.generateGUID(),	 "l04l05",	 loclist,	 "pøechod mezi " + l04.getDescription() + " a " + l05.getDescription(),	 myMap);
		GMNode l05l08 = new GMNode(Utility.generateGUID(),	 "l05l08",	 loclist,	 "pøechod mezi " + l05.getDescription() + " a " + l08.getDescription(),	 myMap);
		GMNode r14 = new GMNode(Utility.generateGUID(),	 "r14",	 loclist,	 l06.getDescription(),	 myMap);
		GMNode l06l08 = new GMNode(Utility.generateGUID(),	 "l06l08",	 loclist,	 "pøechod mezi " + l06.getDescription() + " a " + l08.getDescription(),	 myMap);
		GMNode r16 = new GMNode(Utility.generateGUID(),	 "r16",	 loclist,	 l07.getDescription(),	 myMap);
		GMNode r17 = new GMNode(Utility.generateGUID(),	 "r17",	 loclist,	 l07.getDescription(),	 myMap);
		GMNode l07l08 = new GMNode(Utility.generateGUID(),	 "l07l08",	 loclist,	 "pøechod mezi " + l07.getDescription() + " a " + l08.getDescription(),	 myMap);
		GMNode l07l13 = new GMNode(Utility.generateGUID(),	 "l07l13",	 loclist,	 "pøechod mezi " + l07.getDescription() + " a " + l13.getDescription(),	 myMap);
		GMNode l08l09 = new GMNode(Utility.generateGUID(),	 "l08l09",	 loclist,	 "pøechod mezi " + l08.getDescription() + " a " + l09.getDescription(),	 myMap);
		GMNode l08l10 = new GMNode(Utility.generateGUID(),	 "l08l10",	 loclist,	 "pøechod mezi " + l08.getDescription() + " a " + l10.getDescription(),	 myMap);
		GMNode l09l11 = new GMNode(Utility.generateGUID(),	 "l09l11",	 loclist,	 "pøechod mezi " + l09.getDescription() + " a " + l11.getDescription(),	 myMap);
		GMNode l10l11 = new GMNode(Utility.generateGUID(),	 "l10l11",	 loclist,	 "pøechod mezi " + l10.getDescription() + " a " + l11.getDescription(),	 myMap);
		GMNode l11l12 = new GMNode(Utility.generateGUID(),	 "l11l12",	 loclist,	 "pøechod mezi " + l11.getDescription() + " a " + l12.getDescription(),	 myMap);
		GMNode r15 = new GMNode(Utility.generateGUID(),	 "r15",	 loclist,	 l12.getDescription(),	 myMap);
		GMNode r18 = new GMNode(Utility.generateGUID(),	 "r18",	 loclist,	 l13.getDescription(),	 myMap);
		GMNode r19 = new GMNode(Utility.generateGUID(),	 "r19",	 loclist,	 l13.getDescription(),	 myMap);
		GMNode r20 = new GMNode(Utility.generateGUID(),	 "r20",	 loclist,	 l13.getDescription(),	 myMap);
		GMNode l13l14 = new GMNode(Utility.generateGUID(),	 "l13l14",	 loclist,	 "pøechod mezi " + l13.getDescription() + " a " + l14.getDescription(),	 myMap);
		GMNode r21 = new GMNode(Utility.generateGUID(),	 "r21",	 loclist,	 l14.getDescription(),	 myMap);
		GMNode r22 = new GMNode(Utility.generateGUID(),	 "r22",	 loclist,	 l14.getDescription(),	 myMap);
		GMNode r23 = new GMNode(Utility.generateGUID(),	 "r23",	 loclist,	 l14.getDescription(),	 myMap);
		GMNode r24 = new GMNode(Utility.generateGUID(),	 "r24",	 loclist,	 l14.getDescription(),	 myMap);
		GMNode r25 = new GMNode(Utility.generateGUID(),	 "r25",	 loclist,	 l14.getDescription(),	 myMap);
		GMNode r26 = new GMNode(Utility.generateGUID(),	 "r26",	 loclist,	 l14.getDescription(),	 myMap);
		GMNode r27 = new GMNode(Utility.generateGUID(),	 "r27",	 loclist,	 l14.getDescription(),	 myMap);

		myMap.addNode(r01); myMap.addNode(s01); myMap.addNode(l01l03); myMap.addNode(r02);
		myMap.addNode(r03); myMap.addNode(r04); myMap.addNode(l02l03); myMap.addNode(r05);
		myMap.addNode(r06); myMap.addNode(r07); myMap.addNode(r08); myMap.addNode(r09);
		myMap.addNode(r10); myMap.addNode(r11); myMap.addNode(l03l04); myMap.addNode(r12);
		myMap.addNode(r13); myMap.addNode(l04l05); myMap.addNode(l05l08); myMap.addNode(r14);
		myMap.addNode(l06l08); myMap.addNode(r16); myMap.addNode(r17); myMap.addNode(l07l08);
		myMap.addNode(l07l13); myMap.addNode(l08l09); myMap.addNode(l08l10); myMap.addNode(l09l11);
		myMap.addNode(l10l11); myMap.addNode(l11l12); myMap.addNode(r15); myMap.addNode(r18);
		myMap.addNode(r19); myMap.addNode(r20); myMap.addNode(l13l14); myMap.addNode(r21);
		myMap.addNode(r22); myMap.addNode(r23); myMap.addNode(r24); myMap.addNode(r25);
		myMap.addNode(r26); myMap.addNode(r27);
		
		
		//lokace l01 - cas doplnovt v sekundach nasobeny konstantou spd ktera prevede na sekundy (default 10 s)
		GMEdge l01er01s01 		= new GMEdge(Utility.generateGUID(), "l01er01s01", 10*spd, r01, s01, 	new Direction(Direction.Compass.Southeast), 	l01.getDescription(), myMap);
		GMEdge l01er01l01l03 	= new GMEdge(Utility.generateGUID(), "l01er01l01l03", 10*spd, r01, l01l03, new Direction(Direction.Compass.South), 		l01.getDescription(), myMap);
		GMEdge l01es01r01 		= new GMEdge(Utility.generateGUID(), "l01es01r01", 10*spd, s01, r01, 	new Direction(Direction.Compass.Northeast), 	l01.getDescription(), myMap);
		GMEdge l01es01l01l03 	= new GMEdge(Utility.generateGUID(), "l01es01l01l03", 10*spd, s01, l01l03, new Direction(Direction.Compass.Southwest), 	l01.getDescription(), myMap);
		GMEdge l01el01l03r01 	= new GMEdge(Utility.generateGUID(), "l01el01l03r01", 10*spd, l01l03, r01, new Direction(Direction.Compass.North), 		l01.getDescription(), myMap);
		GMEdge l01el01l03s01 	= new GMEdge(Utility.generateGUID(), "l01el01l03s01", 10*spd, l01l03, s01, new Direction(Direction.Compass.Northwest), 	l01.getDescription(), myMap);
		//lokace l02
		GMEdge l02el02l03r02	= new GMEdge(Utility.generateGUID(), "l02el02l03r02", 10*spd, l02l03, r02,	new Direction(Direction.Compass.East), 	l02.getDescription(), myMap);
		GMEdge l02el02l03r03 	= new GMEdge(Utility.generateGUID(), "l02el02l03r03", 10*spd, l02l03, r03,	new Direction(Direction.Compass.East), 	l02.getDescription(), myMap);
		GMEdge l02el02l03r04 	= new GMEdge(Utility.generateGUID(), "l02el02l03r04", 10*spd, l02l03, r04,	new Direction(Direction.Compass.East), 	l02.getDescription(), myMap);
		GMEdge l02er04r02 		= new GMEdge(Utility.generateGUID(), "l02er04r02", 10*spd, r04, r02, 	new Direction(Direction.Compass.East), 	l02.getDescription(), myMap);
		GMEdge l02er04r03 		= new GMEdge(Utility.generateGUID(), "l02er04r03", 10*spd, r04, r03, 	new Direction(Direction.Compass.East), 	l02.getDescription(), myMap);
		GMEdge l02er02r03 		= new GMEdge(Utility.generateGUID(), "l02er02r03", 10*spd, r02, r03, 	new Direction(Direction.Compass.Southwest),l02.getDescription(), myMap);
		GMEdge l02er02l02l03	= new GMEdge(Utility.generateGUID(), "l02er02l02l03", 10*spd, r02, l02l03,	new Direction(Direction.Compass.West), 	l02.getDescription(), myMap);
		GMEdge l02er03l02l03 	= new GMEdge(Utility.generateGUID(), "l02er03l02l03", 10*spd, r03, l02l03,	new Direction(Direction.Compass.West), 	l02.getDescription(), myMap);
		GMEdge l02er04l02l03 	= new GMEdge(Utility.generateGUID(), "l02er04l02l03", 10*spd, r04, l02l03,	new Direction(Direction.Compass.West), 	l02.getDescription(), myMap);
		GMEdge l02er02r04 		= new GMEdge(Utility.generateGUID(), "l02er02r04", 10*spd, r02, r04, 	new Direction(Direction.Compass.West), 	l02.getDescription(), myMap);
		GMEdge l02er03r04 		= new GMEdge(Utility.generateGUID(), "l02er03r04", 10*spd, r03, r04, 	new Direction(Direction.Compass.West), 	l02.getDescription(), myMap);
		GMEdge l02er03r02 		= new GMEdge(Utility.generateGUID(), "l02er03r02", 10*spd, r03, r02, 	new Direction(Direction.Compass.Northeast),l02.getDescription(), myMap);
		//lokace l03
		GMEdge l03el01l03l02l03		= new GMEdge(Utility.generateGUID(), "l03el01l03l02l03", 10*spd, l01l03, l02l03,	new Direction(Direction.Compass.Southeast), 	l03.getDescription(), myMap);
		GMEdge l03el01l03r05		= new GMEdge(Utility.generateGUID(), "l03el01l03r05", 10*spd, l01l03, r05,		new Direction(Direction.Compass.Southwest), 	l03.getDescription(), myMap);
		GMEdge l03el01l03r06		= new GMEdge(Utility.generateGUID(), "l03el01l03r06", 10*spd, l01l03, r06,		new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el01l03r07		= new GMEdge(Utility.generateGUID(), "l03el01l03r07", 10*spd, l01l03, r07,		new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el01l03r08		= new GMEdge(Utility.generateGUID(), "l03el01l03r08", 10*spd, l01l03, r08,		new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el01l03r09		= new GMEdge(Utility.generateGUID(), "l03el01l03r09", 10*spd, l01l03, r09,		new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el01l03r10		= new GMEdge(Utility.generateGUID(), "l03el01l03r10", 10*spd, l01l03, r10,		new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el01l03r11		= new GMEdge(Utility.generateGUID(), "l03el01l03r11", 10*spd, l01l03, r11,		new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el01l03l03l04		= new GMEdge(Utility.generateGUID(), "l03el01l03l03l04", 10*spd, l01l03, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el02l03r05		= new GMEdge(Utility.generateGUID(), "l03el02l03r05", 10*spd, l02l03, r05,	new Direction(Direction.Compass.West), 	l03.getDescription(), myMap);
		GMEdge l03el02l03r06		= new GMEdge(Utility.generateGUID(), "l03el02l03r06", 10*spd, l02l03, r06,	new Direction(Direction.Compass.Southwest), 	l03.getDescription(), myMap);
		GMEdge l03el02l03r07		= new GMEdge(Utility.generateGUID(), "l03el02l03r07", 10*spd, l02l03, r07,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el02l03r08		= new GMEdge(Utility.generateGUID(), "l03el02l03r08", 10*spd, l02l03, r08,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el02l03r09		= new GMEdge(Utility.generateGUID(), "l03el02l03r09", 10*spd, l02l03, r09,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el02l03r10		= new GMEdge(Utility.generateGUID(), "l03el02l03r10", 10*spd, l02l03, r10,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el02l03r11		= new GMEdge(Utility.generateGUID(), "l03el02l03r11", 10*spd, l02l03, r11,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03el02l03l03l04		= new GMEdge(Utility.generateGUID(), "l03el02l03l03l04", 10*spd, l02l03, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er05r06		= new GMEdge(Utility.generateGUID(), "l03er05r06", 10*spd, r05, r06,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er05r07		= new GMEdge(Utility.generateGUID(), "l03er05r07", 10*spd, r05, r07,	new Direction(Direction.Compass.Southeast), 	l03.getDescription(), myMap);
		GMEdge l03er05r08		= new GMEdge(Utility.generateGUID(), "l03er05r08", 10*spd, r05, r08,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er05r09		= new GMEdge(Utility.generateGUID(), "l03er05r09", 10*spd, r05, r09,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er05r10		= new GMEdge(Utility.generateGUID(), "l03er05r10", 10*spd, r05, r10,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er05r11		= new GMEdge(Utility.generateGUID(), "l03er05r11", 10*spd, r05, r11,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er05l03l04	= new GMEdge(Utility.generateGUID(), "l03er05l03l04", 10*spd, r05, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er06r07		= new GMEdge(Utility.generateGUID(), "l03er06r07", 10*spd, r06, r07,	new Direction(Direction.Compass.Southeast), 	l03.getDescription(), myMap);
		GMEdge l03er06r08		= new GMEdge(Utility.generateGUID(), "l03er06r08", 10*spd, r06, r08,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er06r09		= new GMEdge(Utility.generateGUID(), "l03er06r09", 10*spd, r06, r09,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er06r10		= new GMEdge(Utility.generateGUID(), "l03er06r10", 10*spd, r06, r10,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er06r11		= new GMEdge(Utility.generateGUID(), "l03er06r11", 10*spd, r06, r11,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er06l03l04	= new GMEdge(Utility.generateGUID(), "l03er06l03l04", 10*spd, r06, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er07r08		= new GMEdge(Utility.generateGUID(), "l03er07r08", 10*spd, r07, r08,	new Direction(Direction.Compass.Southwest), 	l03.getDescription(), myMap);
		GMEdge l03er07r09		= new GMEdge(Utility.generateGUID(), "l03er07r09", 10*spd, r07, r09,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er07r10		= new GMEdge(Utility.generateGUID(), "l03er07r10", 10*spd, r07, r10,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er07r11		= new GMEdge(Utility.generateGUID(), "l03er07r11", 10*spd, r07, r11,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er07l03l04	= new GMEdge(Utility.generateGUID(), "l03er07l03l04", 10*spd, r07, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er08r09		= new GMEdge(Utility.generateGUID(), "l03er08r09", 10*spd, r08, r09,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er08r10		= new GMEdge(Utility.generateGUID(), "l03er08r10", 10*spd, r08, r10,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er08r11		= new GMEdge(Utility.generateGUID(), "l03er08r11", 10*spd, r08, r11,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er08l03l04	= new GMEdge(Utility.generateGUID(), "l03er08l03l04", 10*spd, r08, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er09r10		= new GMEdge(Utility.generateGUID(), "l03er09r10", 10*spd, r09, r10,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er09r11		= new GMEdge(Utility.generateGUID(), "l03er09r11", 10*spd, r09, r11,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er09l03l04	= new GMEdge(Utility.generateGUID(), "l03er09l03l04", 10*spd, r09, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er10r11		= new GMEdge(Utility.generateGUID(), "l03er10r11", 10*spd, r10, r11,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er10l03l04	= new GMEdge(Utility.generateGUID(), "l03er10l03l04", 10*spd, r10, l03l04,	new Direction(Direction.Compass.South), 	l03.getDescription(), myMap);
		GMEdge l03er11l03l04	= new GMEdge(Utility.generateGUID(), "l03er11l03l04", 10*spd, r11, l03l04,	new Direction(Direction.Compass.East), 	l03.getDescription(), myMap);
		GMEdge l03el02l03l01l03 	= new GMEdge(Utility.generateGUID(), "l03el02l03l01l03", 10*spd, l02l03, l01l03, 		new Direction(Direction.Compass.Northwest), 	l03.getDescription(), myMap);
		GMEdge l03er05l01l03		= new GMEdge(Utility.generateGUID(), "l03er05l01l03", 10*spd, r05, l01l03, 	new Direction(Direction.Compass.Northeast), 	l03.getDescription(), myMap);
		GMEdge l03er06l01l03		= new GMEdge(Utility.generateGUID(), "l03er06l01l03", 10*spd, r06, l01l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er07l01l03		= new GMEdge(Utility.generateGUID(), "l03er07l01l03", 10*spd, r07, l01l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er08l01l03		= new GMEdge(Utility.generateGUID(), "l03er08l01l03", 10*spd, r08, l01l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er09l01l03		= new GMEdge(Utility.generateGUID(), "l03er09l01l03", 10*spd, r09, l01l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er10l01l03		= new GMEdge(Utility.generateGUID(), "l03er10l01l03", 10*spd, r10, l01l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11l01l03		= new GMEdge(Utility.generateGUID(), "l03er11l01l03", 10*spd, r11, l01l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04l01l03 	= new GMEdge(Utility.generateGUID(), "l03el03l04l01l03", 10*spd, l03l04, l01l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er05l02l03 		= new GMEdge(Utility.generateGUID(), "l03er05l02l03", 10*spd, r05, l02l03, 	new Direction(Direction.Compass.East), 	l03.getDescription(), myMap);
		GMEdge l03er06l02l03 		= new GMEdge(Utility.generateGUID(), "l03er06l02l03", 10*spd, r06, l02l03, 	new Direction(Direction.Compass.Northeast), 	l03.getDescription(), myMap);
		GMEdge l03er07l02l03 		= new GMEdge(Utility.generateGUID(), "l03er07l02l03", 10*spd, r07, l02l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er08l02l03 		= new GMEdge(Utility.generateGUID(), "l03er08l02l03", 10*spd, r08, l02l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er09l02l03 		= new GMEdge(Utility.generateGUID(), "l03er09l02l03", 10*spd, r09, l02l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er10l02l03 		= new GMEdge(Utility.generateGUID(), "l03er10l02l03", 10*spd, r10, l02l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11l02l03 		= new GMEdge(Utility.generateGUID(), "l03er11l02l03", 10*spd, r11, l02l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04l02l03 	= new GMEdge(Utility.generateGUID(), "l03el03l04l02l03", 10*spd, l03l04, l02l03, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er06r05 		= new GMEdge(Utility.generateGUID(), "l03er06r05", 10*spd, r06, r05, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er07r05 		= new GMEdge(Utility.generateGUID(), "l03er07r05", 10*spd, r07, r05, 	new Direction(Direction.Compass.Northwest), 	l03.getDescription(), myMap);
		GMEdge l03er08r05 		= new GMEdge(Utility.generateGUID(), "l03er08r05", 10*spd, r08, r05, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er09r05 		= new GMEdge(Utility.generateGUID(), "l03er09r05", 10*spd, r09, r05, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er10r05 		= new GMEdge(Utility.generateGUID(), "l03er10r05", 10*spd, r10, r05, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11r05 		= new GMEdge(Utility.generateGUID(), "l03er11r05", 10*spd, r11, r05, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04r05 	= new GMEdge(Utility.generateGUID(), "l03el03l04r05", 10*spd, l03l04, r05, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er07r06 		= new GMEdge(Utility.generateGUID(), "l03er07r06", 10*spd, r07, r06, 	new Direction(Direction.Compass.Northwest), 	l03.getDescription(), myMap);
		GMEdge l03er08r06 		= new GMEdge(Utility.generateGUID(), "l03er08r06", 10*spd, r08, r06, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er09r06 		= new GMEdge(Utility.generateGUID(), "l03er09r06", 10*spd, r09, r06, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er10r06 		= new GMEdge(Utility.generateGUID(), "l03er10r06", 10*spd, r10, r06, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11r06 		= new GMEdge(Utility.generateGUID(), "l03er11r06", 10*spd, r11, r06, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04r06 	= new GMEdge(Utility.generateGUID(), "l03el03l04r06", 10*spd, l03l04, r06, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er08r07 		= new GMEdge(Utility.generateGUID(), "l03er08r07", 10*spd, r08, r07, 	new Direction(Direction.Compass.Northeast), 	l03.getDescription(), myMap);
		GMEdge l03er09r07 		= new GMEdge(Utility.generateGUID(), "l03er09r07", 10*spd, r09, r07, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er10r07 		= new GMEdge(Utility.generateGUID(), "l03er10r07", 10*spd, r10, r07, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11r07 		= new GMEdge(Utility.generateGUID(), "l03er11r07", 10*spd, r11, r07, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04r07 	= new GMEdge(Utility.generateGUID(), "l03el03l04r07", 10*spd, l03l04, r07, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er09r08 		= new GMEdge(Utility.generateGUID(), "l03er09r08", 10*spd, r09, r08, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er10r08 		= new GMEdge(Utility.generateGUID(), "l03er10r08", 10*spd, r10, r08, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11r08 		= new GMEdge(Utility.generateGUID(), "l03er11r08", 10*spd, r11, r08, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04r08 	= new GMEdge(Utility.generateGUID(), "l03el03l04r08", 10*spd, l03l04, r08, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er10r09 		= new GMEdge(Utility.generateGUID(), "l03er10r09", 10*spd, r10, r09, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11r09 		= new GMEdge(Utility.generateGUID(), "l03er11r09", 10*spd, r11, r09, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04r09 	= new GMEdge(Utility.generateGUID(), "l03el03l04r09", 10*spd, l03l04, r09, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03er11r10 		= new GMEdge(Utility.generateGUID(), "l03er11r10", 10*spd, r11, r10, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04r10 	= new GMEdge(Utility.generateGUID(), "l03el03l04r10", 10*spd, l03l04, r10, 	new Direction(Direction.Compass.North), 	l03.getDescription(), myMap);
		GMEdge l03el03l04r11 	= new GMEdge(Utility.generateGUID(), "l03el03l04r11", 10*spd, l03l04, r11, 	new Direction(Direction.Compass.West), 	l03.getDescription(), myMap);
		//lokace l04
		GMEdge l04l03l04r12		= new GMEdge(Utility.generateGUID(), "l04l03l04r12", 10*spd, l03l04, r12,		new Direction(Direction.Compass.Northeast), 	l04.getDescription(), myMap);
		GMEdge l04l03l04r13		= new GMEdge(Utility.generateGUID(), "l04l03l04r13", 10*spd, l03l04, r13,		new Direction(Direction.Compass.East), 	l04.getDescription(), myMap);
		GMEdge l04l03l04l04l05	= new GMEdge(Utility.generateGUID(), "l04l03l04l04l05", 10*spd, l03l04, l04l05,	new Direction(Direction.Compass.East), 	l04.getDescription(), myMap);
		GMEdge l04r12r13		= new GMEdge(Utility.generateGUID(), "l04r12r13", 10*spd, r12, r13,		new Direction(Direction.Compass.East), 	l04.getDescription(), myMap);
		GMEdge l04r12l04l05		= new GMEdge(Utility.generateGUID(), "l04r12l04l05", 10*spd, r12, l04l05,		new Direction(Direction.Compass.East), 	l04.getDescription(), myMap);
		GMEdge l04r13l04l05		= new GMEdge(Utility.generateGUID(), "l04r13l04l05", 10*spd, r13, l04l05,		new Direction(Direction.Compass.Southeast), 	l04.getDescription(), myMap);
		GMEdge l04r12l03l04		= new GMEdge(Utility.generateGUID(), "l04r12l03l04", 10*spd, r12,	l03l04, 	new Direction(Direction.Compass.Southwest), 	l04.getDescription(), myMap);
		GMEdge l04r13l03l04		= new GMEdge(Utility.generateGUID(), "l04r13l03l04", 10*spd, r13,	l03l04, 	new Direction(Direction.Compass.West), 	l04.getDescription(), myMap);
		GMEdge l04l04l05l03l04	= new GMEdge(Utility.generateGUID(), "l04l04l05l03l04", 10*spd, l04l05, l03l04,	new Direction(Direction.Compass.West), 	l04.getDescription(), myMap);
		GMEdge l04r13r12		= new GMEdge(Utility.generateGUID(), "l04r13r12", 10*spd, r13,	r12, 		new Direction(Direction.Compass.West), 	l04.getDescription(), myMap);
		GMEdge l04l04l05r12		= new GMEdge(Utility.generateGUID(), "l04l04l05r12", 10*spd, l04l05, r12, 	new Direction(Direction.Compass.West), 	l04.getDescription(), myMap);
		GMEdge l04l04l05r13		= new GMEdge(Utility.generateGUID(), "l04l04l05r13", 10*spd, l04l05, r13, 	new Direction(Direction.Compass.Northwest), 	l04.getDescription(), myMap);
		//lokace l05
		GMEdge l05l04l05l05l08		= new GMEdge(Utility.generateGUID(), "l05l04l05l05l08", 10*spd, l04l05, l05l08,	new Direction(Direction.Compass.North), 	l05.getDescription(), myMap);
		GMEdge l05l05l08l04l05		= new GMEdge(Utility.generateGUID(), "l05l05l08l04l05", 10*spd, l05l08, 	l04l05,	new Direction(Direction.Compass.South), 	l05.getDescription(), myMap);
		//lokace l06
		GMEdge l06r14l06l08		= new GMEdge(Utility.generateGUID(), "l06r14l06l08", 10*spd, r14, l06l08, 	new Direction(Direction.Compass.North), 	l06.getDescription(), myMap); //Direction.Up
		GMEdge l06l06l08r14		= new GMEdge(Utility.generateGUID(), "l06l06l08r14", 10*spd, l06l08, r14,  	new Direction(Direction.Compass.South), 	l06.getDescription(), myMap); //Direction.Down
		//lokace l07
		GMEdge l07l07l08r16			= new GMEdge(Utility.generateGUID(), "l07l07l08r16", 10*spd, l07l08, r16, 	new Direction(Direction.Compass.East), 	l07.getDescription(), myMap); 
		GMEdge l07l07l08r17			= new GMEdge(Utility.generateGUID(), "l07l07l08r17", 10*spd, l07l08, r17, 	new Direction(Direction.Compass.South), 	l07.getDescription(), myMap); 
		GMEdge l07l07l08l07l13		= new GMEdge(Utility.generateGUID(), "l07l07l08l07l13", 10*spd, l07l08, l07l13, 	new Direction(Direction.Compass.South), 	l07.getDescription(), myMap); 
		GMEdge l07r16r17			= new GMEdge(Utility.generateGUID(), "l07r16r17", 10*spd, r16, r17, 		new Direction(Direction.Compass.South), 	l07.getDescription(), myMap); 
		GMEdge l07r16l07l13			= new GMEdge(Utility.generateGUID(), "l07r16l07l13", 10*spd, r16, l07l13, 	new Direction(Direction.Compass.South), 	l07.getDescription(), myMap); 
		GMEdge l07r17l07l13			= new GMEdge(Utility.generateGUID(), "l07r17l07l13", 10*spd, r17, l07l13, 	new Direction(Direction.Compass.South), 	l07.getDescription(), myMap); 
		GMEdge l07r16l07l08			= new GMEdge(Utility.generateGUID(), "l07r16l07l08", 10*spd, r16, 	l07l08, new Direction(Direction.Compass.West), 	l07.getDescription(), myMap); 
		GMEdge l07r17l07l08			= new GMEdge(Utility.generateGUID(), "l07r17l07l08", 10*spd, r17, 	l07l08, new Direction(Direction.Compass.North), 	l07.getDescription(), myMap); 
		GMEdge l07l07l13l07l08		= new GMEdge(Utility.generateGUID(), "l07l07l13l07l08", 10*spd, l07l13, 	l07l08, new Direction(Direction.Compass.North), 	l07.getDescription(), myMap); 
		GMEdge l07r17r16			= new GMEdge(Utility.generateGUID(), "l07r17r16", 10*spd, r17, 	r16, 	new Direction(Direction.Compass.North), 	l07.getDescription(), myMap); 
		GMEdge l07l07l13r16			= new GMEdge(Utility.generateGUID(), "l07l07l13r16", 10*spd, l07l13, 	r16, 	new Direction(Direction.Compass.North), 	l07.getDescription(), myMap); 
		GMEdge l07l07l13r17			= new GMEdge(Utility.generateGUID(), "l07l07l13r17", 10*spd, l07l13, 	r17, 	new Direction(Direction.Compass.North), 	l07.getDescription(), myMap); 
		//lokace l08
		GMEdge l08l05l08l06l08		= new GMEdge(Utility.generateGUID(), "l08l05l08l06l08", 10*spd, l05l08, l06l08, 	new Direction(Direction.Compass.East), 	l08.getDescription(), myMap); 
		GMEdge l08l05l08l07l08		= new GMEdge(Utility.generateGUID(), "l08l05l08l07l08", 10*spd, l05l08, l07l08, 	new Direction(Direction.Compass.East), 	l08.getDescription(), myMap); 
		GMEdge l08l05l08l08l09		= new GMEdge(Utility.generateGUID(), "l08l05l08l08l09", 10*spd, l05l08, l08l09, 	new Direction(Direction.Compass.East), 	l08.getDescription(), myMap); 
		GMEdge l08l05l08l08l10		= new GMEdge(Utility.generateGUID(), "l08l05l08l08l10", 10*spd, l05l08, l08l10, 	new Direction(Direction.Compass.East), 	l08.getDescription(), myMap); 
		GMEdge l08l06l08l07l08		= new GMEdge(Utility.generateGUID(), "l08l06l08l07l08", 10*spd, l06l08, l07l08, 	new Direction(Direction.Compass.East), 	l08.getDescription(), myMap); 
		GMEdge l08l06l08l08l09		= new GMEdge(Utility.generateGUID(), "l08l06l08l08l09", 10*spd, l06l08, l08l09, 	new Direction(Direction.Compass.Northwest), 	l08.getDescription(), myMap); 
		GMEdge l08l06l08l08l10		= new GMEdge(Utility.generateGUID(), "l08l06l08l08l10", 10*spd, l06l08, l08l10, 	new Direction(Direction.Compass.Northeast), 	l08.getDescription(), myMap); 
		GMEdge l08l07l08l08l09		= new GMEdge(Utility.generateGUID(), "l08l07l08l08l09", 10*spd, l07l08, l08l09, 	new Direction(Direction.Compass.West), 	l08.getDescription(), myMap); 
		GMEdge l08l07l08l08l10		= new GMEdge(Utility.generateGUID(), "l08l07l08l08l10", 10*spd, l07l08, l08l10, 	new Direction(Direction.Compass.Northwest), 	l08.getDescription(), myMap); 
		GMEdge l08l08l09l08l10		= new GMEdge(Utility.generateGUID(), "l08l08l09l08l10", 10*spd, l08l09, l08l10, 	new Direction(Direction.Compass.East), 	l08.getDescription(), myMap); 
		GMEdge l08l06l08l05l08		= new GMEdge(Utility.generateGUID(), "l08l06l08l05l08", 10*spd, l06l08, l05l08, 	new Direction(Direction.Compass.West), 	l08.getDescription(), myMap); 
		GMEdge l08l07l08l05l08		= new GMEdge(Utility.generateGUID(), "l08l07l08l05l08", 10*spd, l07l08, l05l08, 	new Direction(Direction.Compass.West), 	l08.getDescription(), myMap); 
		GMEdge l08l08l09l05l08		= new GMEdge(Utility.generateGUID(), "l08l08l09l05l08", 10*spd, l08l09, l05l08, 	new Direction(Direction.Compass.West), 	l08.getDescription(), myMap); 
		GMEdge l08l08l10l05l08		= new GMEdge(Utility.generateGUID(), "l08l08l10l05l08", 10*spd, l08l10, l05l08, 	new Direction(Direction.Compass.West), 	l08.getDescription(), myMap); 
		GMEdge l08l07l08l06l08		= new GMEdge(Utility.generateGUID(), "l08l07l08l06l08", 10*spd, l07l08, l06l08, 	new Direction(Direction.Compass.West), 	l08.getDescription(), myMap); 
		GMEdge l08l08l09l06l08		= new GMEdge(Utility.generateGUID(), "l08l08l09l06l08", 10*spd, l08l09, l06l08, 	new Direction(Direction.Compass.Southeast), 	l08.getDescription(), myMap); 
		GMEdge l08l08l10l06l08		= new GMEdge(Utility.generateGUID(), "l08l08l10l06l08", 10*spd, l08l10, l06l08, 	new Direction(Direction.Compass.Southwest), 	l08.getDescription(), myMap); 
		GMEdge l08l08l09l07l08		= new GMEdge(Utility.generateGUID(), "l08l08l09l07l08", 10*spd, l08l09, l07l08, 	new Direction(Direction.Compass.East), 	l08.getDescription(), myMap); 
		GMEdge l08l08l10l07l08		= new GMEdge(Utility.generateGUID(), "l08l08l10l07l08", 10*spd, l08l10, l07l08, 	new Direction(Direction.Compass.Southeast), 	l08.getDescription(), myMap); 
		GMEdge l08l08l10l08l09		= new GMEdge(Utility.generateGUID(), "l08l08l10l08l09", 10*spd, l08l10, l08l09, 	new Direction(Direction.Compass.West), 	l08.getDescription(), myMap); 
		//lokace l09
		GMEdge l09l08l09l09l11		= new GMEdge(Utility.generateGUID(), "l09l08l09l09l11", 10*spd, l08l09, l09l11, 	new Direction(Direction.Compass.North), 	l09.getDescription(), myMap); 
		GMEdge l09l09l11l08l09		= new GMEdge(Utility.generateGUID(), "l09l09l11l08l09", 10*spd, l09l11, l08l09, 	new Direction(Direction.Compass.South), 	l09.getDescription(), myMap); 
		//lokace l10
		GMEdge l10l08l10l10l11		= new GMEdge(Utility.generateGUID(), "l10l08l10l10l11", 10*spd, l08l10, l10l11, 	new Direction(Direction.Compass.North), 	l10.getDescription(), myMap); 
		GMEdge l10l10l11l08l10		= new GMEdge(Utility.generateGUID(), "l10l10l11l08l10", 10*spd, l10l11, l08l10, 	new Direction(Direction.Compass.South), 	l10.getDescription(), myMap); 
		//lokace l11
		GMEdge l11l10l11l09l11	= new GMEdge(Utility.generateGUID(), "l11l10l11l09l11", 10*spd, l10l11, l09l11, 	new Direction(Direction.Compass.West), 	l11.getDescription(), myMap); 
		GMEdge l11l10l11l11l12	= new GMEdge(Utility.generateGUID(), "l11l10l11l11l12", 10*spd, l10l11, l11l12, 	new Direction(Direction.Compass.Northwest), 	l11.getDescription(), myMap); 
		GMEdge l11l09l11l11l12	= new GMEdge(Utility.generateGUID(), "l11l09l11l11l12", 10*spd, l09l11, l11l12, 	new Direction(Direction.Compass.North), 	l11.getDescription(), myMap); 
		GMEdge l11l09l11l10l11	= new GMEdge(Utility.generateGUID(), "l11l09l11l10l11", 10*spd, l09l11, l10l11, 	new Direction(Direction.Compass.East), 	l11.getDescription(), myMap); 
		GMEdge l11l11l12l10l11	= new GMEdge(Utility.generateGUID(), "l11l11l12l10l11", 10*spd, l11l12, l10l11, 	new Direction(Direction.Compass.Southeast), 	l11.getDescription(), myMap); 
		GMEdge l11l11l12l09l11	= new GMEdge(Utility.generateGUID(), "l11l11l12l09l11", 10*spd, l11l12, l09l11, 	new Direction(Direction.Compass.South), 	l11.getDescription(), myMap); 
		//lokace l12
		GMEdge l12l11l12r15	= new GMEdge(Utility.generateGUID(), "l12l11l12r15", 10*spd, l11l12, r15, 	new Direction(Direction.Compass.Northwest), 	l12.getDescription(), myMap); 
		GMEdge l12r15l11l12	= new GMEdge(Utility.generateGUID(), "l12r15l11l12", 10*spd, r15, l11l12, 	new Direction(Direction.Compass.Southeast), 	l12.getDescription(), myMap); 

		//lokace l13
		GMEdge l13l07l13r18 	= new GMEdge(Utility.generateGUID(), "l13l07l13r18", 10*spd, l07l13, r18 	, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13l07l13r19 	= new GMEdge(Utility.generateGUID(), "l13l07l13r19", 10*spd, l07l13, r19 	, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13l07l13r20 	= new GMEdge(Utility.generateGUID(), "l13l07l13r20", 10*spd, l07l13, r20 	, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13l07l13l13l14	= new GMEdge(Utility.generateGUID(), "l13l07l13l13l14", 10*spd, l07l13, l13l14, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13r18r19 		= new GMEdge(Utility.generateGUID(), "l13r18r19", 10*spd, r18, r19 	, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13r18r20 		= new GMEdge(Utility.generateGUID(), "l13r18r20", 10*spd, r18, r20 	, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13r18l13l14		= new GMEdge(Utility.generateGUID(), "l13r18l13l14", 10*spd, r18, l13l14, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13r19r20 		= new GMEdge(Utility.generateGUID(), "l13r19r20", 10*spd, r19, r20,	 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13r19l13l14		= new GMEdge(Utility.generateGUID(), "l13r19l13l14", 10*spd, r19, l13l14, 	new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13r20l13l14		= new GMEdge(Utility.generateGUID(), "l13r20l13l14", 10*spd, r20, l13l14,		new Direction(Direction.Compass.East), 	l13.getDescription(), myMap); 
		GMEdge l13r18l07l13	 	= new GMEdge(Utility.generateGUID(), "l13r18l07l13", 10*spd, r18, 	l07l13, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13r19l07l13		= new GMEdge(Utility.generateGUID(), "l13r19l07l13", 10*spd, r19, 	l07l13, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13r20l07l13	 	= new GMEdge(Utility.generateGUID(), "l13r20l07l13", 10*spd, r20, 	l07l13, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13l13l14l07l13	= new GMEdge(Utility.generateGUID(), "l13l13l14l07l13", 10*spd, l13l14, 	l07l13, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13r19r18		= new GMEdge(Utility.generateGUID(), "l13r19r18", 10*spd, r19, 	r18, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13r20r18		= new GMEdge(Utility.generateGUID(), "l13r20r18", 10*spd, r20, 	r18, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13l13l14r18		= new GMEdge(Utility.generateGUID(), "l13l13l14r18", 10*spd, l13l14, 	r18, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13r20r19		= new GMEdge(Utility.generateGUID(), "l13r20r19", 10*spd, r20, 	r19, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13l13l14r19		= new GMEdge(Utility.generateGUID(), "l13l13l14r19", 10*spd, l13l14, 	r19, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		GMEdge l13l13l14r20		= new GMEdge(Utility.generateGUID(), "l13l13l14r20", 10*spd, l13l14,	r20, 	new Direction(Direction.Compass.West), 	l13.getDescription(), myMap); 
		
		//lokace l14
		GMEdge l14l13l14r21 	= new GMEdge(Utility.generateGUID(), "l14l13l14r21", 10*spd, l13l14, r21,	new Direction(Direction.Compass.East), 	l14.getDescription(), myMap); 
		GMEdge l14l13l14r22 	= new GMEdge(Utility.generateGUID(), "l14l13l14r22", 10*spd, l13l14, r22,	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14l13l14r23 	= new GMEdge(Utility.generateGUID(), "l14l13l14r23", 10*spd, l13l14, r23,	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14l13l14r24 	= new GMEdge(Utility.generateGUID(), "l14l13l14r24", 10*spd, l13l14, r24,	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14l13l14r25 	= new GMEdge(Utility.generateGUID(), "l14l13l14r25", 10*spd, l13l14, r25,	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14l13l14r26 	= new GMEdge(Utility.generateGUID(), "l14l13l14r26", 10*spd, l13l14, r26,	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14l13l14r27 	= new GMEdge(Utility.generateGUID(), "l14l13l14r27", 10*spd, l13l14, r27,	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r21r22 	= new GMEdge(Utility.generateGUID(), "l14r21r22", 10*spd, r21, r22, 	new Direction(Direction.Compass.Northwest), 	l14.getDescription(), myMap); 
		GMEdge l14r21r23 	= new GMEdge(Utility.generateGUID(), "l14r21r23", 10*spd, r21, r23, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r21r24 	= new GMEdge(Utility.generateGUID(), "l14r21r24", 10*spd, r21, r24, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r21r25 	= new GMEdge(Utility.generateGUID(), "l14r21r25", 10*spd, r21, r25, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r21r26 	= new GMEdge(Utility.generateGUID(), "l14r21r26", 10*spd, r21, r26, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r21r27 	= new GMEdge(Utility.generateGUID(), "l14r21r27", 10*spd, r21, r27, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r22r23 	= new GMEdge(Utility.generateGUID(), "l14r22r23", 10*spd, r22, r23, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r22r24 	= new GMEdge(Utility.generateGUID(), "l14r22r24", 10*spd, r22, r24, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r22r25 	= new GMEdge(Utility.generateGUID(), "l14r22r25", 10*spd, r22, r25, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r22r26 	= new GMEdge(Utility.generateGUID(), "l14r22r26", 10*spd, r22, r26, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r22r27 	= new GMEdge(Utility.generateGUID(), "l14r22r27", 10*spd, r22, r27, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r23r24 	= new GMEdge(Utility.generateGUID(), "l14r23r24", 10*spd, r23, r24, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r23r25 	= new GMEdge(Utility.generateGUID(), "l14r23r25", 10*spd, r23, r25, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r23r26 	= new GMEdge(Utility.generateGUID(), "l14r23r26", 10*spd, r23, r26, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r23r27 	= new GMEdge(Utility.generateGUID(), "l14r23r27", 10*spd, r23, r27, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r24r25 	= new GMEdge(Utility.generateGUID(), "l14r24r25", 10*spd, r24, r25, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r24r26 	= new GMEdge(Utility.generateGUID(), "l14r24r26", 10*spd, r24, r26, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r24r27 	= new GMEdge(Utility.generateGUID(), "l14r24r27", 10*spd, r24, r27, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r25r26 	= new GMEdge(Utility.generateGUID(), "l14r25r26", 10*spd, r25, r26, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r25r27 	= new GMEdge(Utility.generateGUID(), "l14r25r27", 10*spd, r25, r27, 	new Direction(Direction.Compass.North), 	l14.getDescription(), myMap); 
		GMEdge l14r26r27 	= new GMEdge(Utility.generateGUID(), "l14r26r27", 10*spd, r26, r27, 	new Direction(Direction.Compass.Northwest), 	l14.getDescription(), myMap); 
		GMEdge l14r21l13l14 	= new GMEdge(Utility.generateGUID(), "l14r21l13l14", 10*spd, r21, l13l14,	new Direction(Direction.Compass.West), 	l14.getDescription(), myMap); 
		GMEdge l14r22l13l14 	= new GMEdge(Utility.generateGUID(), "l14r22l13l14", 10*spd, r22, l13l14,	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r23l13l14 	= new GMEdge(Utility.generateGUID(), "l14r23l13l14", 10*spd, r23, l13l14,	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r24l13l14 	= new GMEdge(Utility.generateGUID(), "l14r24l13l14", 10*spd, r24, l13l14,	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r25l13l14 	= new GMEdge(Utility.generateGUID(), "l14r25l13l14", 10*spd, r25, l13l14,	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r26l13l14 	= new GMEdge(Utility.generateGUID(), "l14r26l13l14", 10*spd, r26, l13l14,	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r27l13l14 	= new GMEdge(Utility.generateGUID(), "l14r27l13l14", 10*spd, r27, l13l14,	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r22r21 	= new GMEdge(Utility.generateGUID(), "l14r22r21", 10*spd, r22,r21,  	new Direction(Direction.Compass.Southeast), 	l14.getDescription(), myMap); 
		GMEdge l14r23r21 	= new GMEdge(Utility.generateGUID(), "l14r23r21", 10*spd, r23,r21,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r24r21 	= new GMEdge(Utility.generateGUID(), "l14r24r21", 10*spd, r24,r21,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r25r21 	= new GMEdge(Utility.generateGUID(), "l14r25r21", 10*spd, r25,r21,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r26r21 	= new GMEdge(Utility.generateGUID(), "l14r26r21", 10*spd, r26,r21,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r27r21 	= new GMEdge(Utility.generateGUID(), "l14r27r21", 10*spd, r27,r21,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r23r22 	= new GMEdge(Utility.generateGUID(), "l14r23r22", 10*spd, r23,r22,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r24r22 	= new GMEdge(Utility.generateGUID(), "l14r24r22", 10*spd, r24,r22,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r25r22 	= new GMEdge(Utility.generateGUID(), "l14r25r22", 10*spd, r25,r22,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r26r22 	= new GMEdge(Utility.generateGUID(), "l14r26r22", 10*spd, r26,r22,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r27r22 	= new GMEdge(Utility.generateGUID(), "l14r27r22", 10*spd, r27,r22,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r24r23 	= new GMEdge(Utility.generateGUID(), "l14r24r23", 10*spd, r24,r23,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r25r23 	= new GMEdge(Utility.generateGUID(), "l14r25r23", 10*spd, r25,r23,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r26r23 	= new GMEdge(Utility.generateGUID(), "l14r26r23", 10*spd, r26,r23,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r27r23 	= new GMEdge(Utility.generateGUID(), "l14r27r23", 10*spd, r27,r23,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r25r24 	= new GMEdge(Utility.generateGUID(), "l14r25r24", 10*spd, r25,r24,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r26r24 	= new GMEdge(Utility.generateGUID(), "l14r26r24", 10*spd, r26,r24,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r27r24 	= new GMEdge(Utility.generateGUID(), "l14r27r24", 10*spd, r27,r24,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r26r25 	= new GMEdge(Utility.generateGUID(), "l14r26r25", 10*spd, r26,r25,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r27r25 	= new GMEdge(Utility.generateGUID(), "l14r27r25", 10*spd, r27,r25,  	new Direction(Direction.Compass.South), 	l14.getDescription(), myMap); 
		GMEdge l14r27r26 	= new GMEdge(Utility.generateGUID(), "l14r27r26", 10*spd, r27,r26,  	new Direction(Direction.Compass.Southeast), 	l14.getDescription(), myMap); 

		//lokacel01
		myMap.addEdge(l01er01s01); myMap.addEdge(l01er01s01); myMap.addEdge(l01er01l01l03); myMap.addEdge(l01es01r01);
		myMap.addEdge(l01es01l01l03); myMap.addEdge(l01el01l03r01); myMap.addEdge(l01el01l03s01);
		//lokacel02
		myMap.addEdge(l02el02l03r02); myMap.addEdge(l02el02l03r03); myMap.addEdge(l02el02l03r04); myMap.addEdge(l02er04r02);
		myMap.addEdge(l02er04r03); myMap.addEdge(l02er02r03); myMap.addEdge(l02er02l02l03); myMap.addEdge(l02er03l02l03);
		myMap.addEdge(l02er04l02l03); myMap.addEdge(l02er02r04); myMap.addEdge(l02er03r04); myMap.addEdge(l02er03r02);
		//lokacel03
		myMap.addEdge(l03el01l03l02l03); myMap.addEdge(l03el01l03r05); myMap.addEdge(l03el01l03r06); myMap.addEdge(l03el01l03r07);
		myMap.addEdge(l03el01l03r08); myMap.addEdge(l03el01l03r09); myMap.addEdge(l03el01l03r10); myMap.addEdge(l03el01l03r11);
		myMap.addEdge(l03el01l03l03l04); myMap.addEdge(l03el02l03r05); myMap.addEdge(l03el02l03r06); myMap.addEdge(l03el02l03r07);
		myMap.addEdge(l03el02l03r08); myMap.addEdge(l03el02l03r09); myMap.addEdge(l03el02l03r10); myMap.addEdge(l03el02l03r11);
		myMap.addEdge(l03el02l03l03l04); myMap.addEdge(l03er05r06); myMap.addEdge(l03er05r07); myMap.addEdge(l03er05r08);
		myMap.addEdge(l03er05r09); myMap.addEdge(l03er05r10); myMap.addEdge(l03er05r11); myMap.addEdge(l03er05l03l04);
		myMap.addEdge(l03er06r07); myMap.addEdge(l03er06r08); myMap.addEdge(l03er06r09); myMap.addEdge(l03er06r10);
		myMap.addEdge(l03er06r11); myMap.addEdge(l03er06l03l04); myMap.addEdge(l03er07r08); myMap.addEdge(l03er07r09);
		myMap.addEdge(l03er07r10); myMap.addEdge(l03er07r11); myMap.addEdge(l03er07l03l04); myMap.addEdge(l03er08r09);
		myMap.addEdge(l03er08r10); myMap.addEdge(l03er08r11); myMap.addEdge(l03er08l03l04); myMap.addEdge(l03er09r10);
		myMap.addEdge(l03er09r11); myMap.addEdge(l03er09l03l04); myMap.addEdge(l03er10r11); myMap.addEdge(l03er10l03l04);
		myMap.addEdge(l03er11l03l04); myMap.addEdge(l03el02l03l01l03); myMap.addEdge(l03er05l01l03); myMap.addEdge(l03er06l01l03);
		myMap.addEdge(l03er07l01l03); myMap.addEdge(l03er08l01l03); myMap.addEdge(l03er09l01l03); myMap.addEdge(l03er10l01l03);
		myMap.addEdge(l03er11l01l03); myMap.addEdge(l03el03l04l01l03); myMap.addEdge(l03er05l02l03); myMap.addEdge(l03er06l02l03);
		myMap.addEdge(l03er07l02l03); myMap.addEdge(l03er08l02l03); myMap.addEdge(l03er09l02l03); myMap.addEdge(l03er10l02l03);
		myMap.addEdge(l03er11l02l03); myMap.addEdge(l03el03l04l02l03); myMap.addEdge(l03er06r05); myMap.addEdge(l03er07r05);
		myMap.addEdge(l03er08r05); myMap.addEdge(l03er09r05); myMap.addEdge(l03er10r05); myMap.addEdge(l03er11r05);
		myMap.addEdge(l03el03l04r05); myMap.addEdge(l03er07r06); myMap.addEdge(l03er08r06); myMap.addEdge(l03er09r06);
		myMap.addEdge(l03er10r06); myMap.addEdge(l03er11r06); myMap.addEdge(l03el03l04r06); myMap.addEdge(l03er08r07);
		myMap.addEdge(l03er09r07); myMap.addEdge(l03er10r07); myMap.addEdge(l03er11r07); myMap.addEdge(l03el03l04r07);
		myMap.addEdge(l03er09r08); myMap.addEdge(l03er10r08); myMap.addEdge(l03er11r08); myMap.addEdge(l03el03l04r08);
		myMap.addEdge(l03er10r09); myMap.addEdge(l03er11r09); myMap.addEdge(l03el03l04r09); myMap.addEdge(l03er11r10);
		myMap.addEdge(l03el03l04r10); myMap.addEdge(l03el03l04r11);
		//lokacel04
		myMap.addEdge(l04l03l04r12); myMap.addEdge(l04l03l04r13); myMap.addEdge(l04l03l04l04l05); myMap.addEdge(l04r12r13);
		myMap.addEdge(l04r12l04l05); myMap.addEdge(l04r13l04l05); myMap.addEdge(l04r12l03l04); myMap.addEdge(l04r13l03l04);
		myMap.addEdge(l04l04l05l03l04); myMap.addEdge(l04r13r12); myMap.addEdge(l04l04l05r12); myMap.addEdge(l04l04l05r13);
		//lokace l05
		myMap.addEdge(l05l04l05l05l08); myMap.addEdge(l05l05l08l04l05); 
		//lokace l06
		myMap.addEdge(l06r14l06l08); myMap.addEdge(l06l06l08r14); 
		//lokace l07
		myMap.addEdge(l07l07l08r16); myMap.addEdge(l07l07l08r17); myMap.addEdge(l07l07l08l07l13); myMap.addEdge(l07r16r17); 
		myMap.addEdge(l07r16l07l13); myMap.addEdge(l07r17l07l13); myMap.addEdge(l07r16l07l08); myMap.addEdge(l07r17l07l08); 
		myMap.addEdge(l07l07l13l07l08); myMap.addEdge(l07r17r16); myMap.addEdge(l07l07l13r16); myMap.addEdge(l07l07l13r17); 
		//lokace l08
		myMap.addEdge(l08l05l08l06l08); myMap.addEdge(l08l05l08l07l08); myMap.addEdge(l08l05l08l08l09); myMap.addEdge(l08l05l08l08l10); 
		myMap.addEdge(l08l06l08l07l08); myMap.addEdge(l08l06l08l08l09); myMap.addEdge(l08l06l08l08l10); myMap.addEdge(l08l07l08l08l09); 
		myMap.addEdge(l08l07l08l08l10); myMap.addEdge(l08l08l09l08l10); myMap.addEdge(l08l06l08l05l08); myMap.addEdge(l08l07l08l05l08); 
		myMap.addEdge(l08l08l09l05l08); myMap.addEdge(l08l08l10l05l08); myMap.addEdge(l08l07l08l06l08); myMap.addEdge(l08l08l09l06l08); 
		myMap.addEdge(l08l08l10l06l08); myMap.addEdge(l08l08l09l07l08); myMap.addEdge(l08l08l10l07l08); myMap.addEdge(l08l08l10l08l09); 
		//lokace l09
		myMap.addEdge(l09l08l09l09l11); myMap.addEdge(l09l09l11l08l09); 
		//lokace l10
		myMap.addEdge(l10l08l10l10l11); myMap.addEdge(l10l10l11l08l10); 
		//lokace l11
		myMap.addEdge(l11l10l11l09l11); myMap.addEdge(l11l10l11l11l12); myMap.addEdge(l11l09l11l11l12); myMap.addEdge(l11l09l11l10l11); 
		myMap.addEdge(l11l11l12l10l11); myMap.addEdge(l11l11l12l09l11); 
		//lokace l12
		myMap.addEdge(l12l11l12r15); myMap.addEdge(l12r15l11l12); 
		//lokace l13
		myMap.addEdge(l13l07l13r18); myMap.addEdge(l13l07l13r19); myMap.addEdge(l13l07l13r20); myMap.addEdge(l13l07l13l13l14); 
		myMap.addEdge(l13r18r19); myMap.addEdge(l13r18r20); myMap.addEdge(l13r18l13l14); myMap.addEdge(l13r19r20); 
		myMap.addEdge(l13r19l13l14); myMap.addEdge(l13r20l13l14); myMap.addEdge(l13r18l07l13); myMap.addEdge(l13r19l07l13); 
		myMap.addEdge(l13r20l07l13); myMap.addEdge(l13l13l14l07l13); myMap.addEdge(l13r19r18); myMap.addEdge(l13r20r18); 
		myMap.addEdge(l13l13l14r18); myMap.addEdge(l13r20r19); myMap.addEdge(l13l13l14r19); myMap.addEdge(l13l13l14r20); 
		//lokace l14
		myMap.addEdge(l14l13l14r21); myMap.addEdge(l14l13l14r22); myMap.addEdge(l14l13l14r23); myMap.addEdge(l14l13l14r24); 
		myMap.addEdge(l14l13l14r25); myMap.addEdge(l14l13l14r26); myMap.addEdge(l14l13l14r27); myMap.addEdge(l14r21r22); 
		myMap.addEdge(l14r21r23); myMap.addEdge(l14r21r24); myMap.addEdge(l14r21r25); myMap.addEdge(l14r21r26); 
		myMap.addEdge(l14r21r27); myMap.addEdge(l14r22r23); myMap.addEdge(l14r22r24); myMap.addEdge(l14r22r25); 
		myMap.addEdge(l14r22r26); myMap.addEdge(l14r22r27); myMap.addEdge(l14r23r24); myMap.addEdge(l14r23r25); 
		myMap.addEdge(l14r23r26); myMap.addEdge(l14r23r27); myMap.addEdge(l14r24r25); myMap.addEdge(l14r24r26); 
		myMap.addEdge(l14r24r27); myMap.addEdge(l14r25r26); myMap.addEdge(l14r25r27); myMap.addEdge(l14r26r27); 
		myMap.addEdge(l14r21l13l14); myMap.addEdge(l14r22l13l14); myMap.addEdge(l14r23l13l14); myMap.addEdge(l14r24l13l14); 
		myMap.addEdge(l14r25l13l14); myMap.addEdge(l14r26l13l14); myMap.addEdge(l14r27l13l14); myMap.addEdge(l14r22r21); 
		myMap.addEdge(l14r23r21); myMap.addEdge(l14r24r21); myMap.addEdge(l14r25r21); myMap.addEdge(l14r26r21); 
		myMap.addEdge(l14r27r21); myMap.addEdge(l14r23r22); myMap.addEdge(l14r24r22); myMap.addEdge(l14r25r22); 
		myMap.addEdge(l14r26r22); myMap.addEdge(l14r27r22); myMap.addEdge(l14r24r23); myMap.addEdge(l14r25r23); 
		myMap.addEdge(l14r26r23); myMap.addEdge(l14r27r23); myMap.addEdge(l14r25r24); myMap.addEdge(l14r26r24); 
		myMap.addEdge(l14r27r24); myMap.addEdge(l14r26r25); myMap.addEdge(l14r27r25); myMap.addEdge(l14r27r26); 

		return myMap;
	}
}
