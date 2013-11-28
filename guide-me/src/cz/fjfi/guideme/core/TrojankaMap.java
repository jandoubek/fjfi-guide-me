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
		int timeCard = 8000; 
		int spd = 1; 
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
		
		
		//lokace l01
		GMEdge l01er01s01 		= new GMEdge(Utility.generateGUID(), "l01er01s01", 2000*spd, r01, s01, 	Direction.Southeast, 	l01.getDescription(), myMap);
		GMEdge l01er01l01l03 	= new GMEdge(Utility.generateGUID(), "l01er01l01l03", 2000*spd, r01, l01l03, Direction.South, 		l01.getDescription(), myMap);
		GMEdge l01es01r01 		= new GMEdge(Utility.generateGUID(), "l01es01r01", 2000*spd, s01, r01, 	Direction.Northeast, 	l01.getDescription(), myMap);
		GMEdge l01es01l01l03 	= new GMEdge(Utility.generateGUID(), "l01es01l01l03", 2000*spd, s01, l01l03, Direction.Southwest, 	l01.getDescription(), myMap);
		GMEdge l01el01l03r01 	= new GMEdge(Utility.generateGUID(), "l01el01l03r01", 2000*spd, l01l03, r01, Direction.North, 		l01.getDescription(), myMap);
		GMEdge l01el01l03s01 	= new GMEdge(Utility.generateGUID(), "l01el01l03s01", 2000*spd, l01l03, s01, Direction.Northwest, 	l01.getDescription(), myMap);
		//lokace l02
		GMEdge l02el02l03r02	= new GMEdge(Utility.generateGUID(), "l02el02l03r02", 2000*spd, l02l03, r02,	Direction.East, 	l02.getDescription(), myMap);
		GMEdge l02el02l03r03 	= new GMEdge(Utility.generateGUID(), "l02el02l03r03", 2000*spd, l02l03, r03,	Direction.East, 	l02.getDescription(), myMap);
		GMEdge l02el02l03r04 	= new GMEdge(Utility.generateGUID(), "l02el02l03r04", 2000*spd, l02l03, r04,	Direction.East, 	l02.getDescription(), myMap);
		GMEdge l02er04r02 		= new GMEdge(Utility.generateGUID(), "l02er04r02", 2000*spd, r04, r02, 	Direction.East, 	l02.getDescription(), myMap);
		GMEdge l02er04r03 		= new GMEdge(Utility.generateGUID(), "l02er04r03", 2000*spd, r04, r03, 	Direction.East, 	l02.getDescription(), myMap);
		GMEdge l02er02r03 		= new GMEdge(Utility.generateGUID(), "l02er02r03", 2000*spd, r02, r03, 	Direction.Southwest,l02.getDescription(), myMap);
		GMEdge l02er02l02l03	= new GMEdge(Utility.generateGUID(), "l02er02l02l03", 2000*spd, r02, l02l03,	Direction.West, 	l02.getDescription(), myMap);
		GMEdge l02er03l02l03 	= new GMEdge(Utility.generateGUID(), "l02er03l02l03", 2000*spd, r03, l02l03,	Direction.West, 	l02.getDescription(), myMap);
		GMEdge l02er04l02l03 	= new GMEdge(Utility.generateGUID(), "l02er04l02l03", 2000*spd, r04, l02l03,	Direction.West, 	l02.getDescription(), myMap);
		GMEdge l02er02r04 		= new GMEdge(Utility.generateGUID(), "l02er02r04", 2000*spd, r02, r04, 	Direction.West, 	l02.getDescription(), myMap);
		GMEdge l02er03r04 		= new GMEdge(Utility.generateGUID(), "l02er03r04", 2000*spd, r03, r04, 	Direction.West, 	l02.getDescription(), myMap);
		GMEdge l02er03r02 		= new GMEdge(Utility.generateGUID(), "l02er03r02", 2000*spd, r03, r02, 	Direction.Northeast,l02.getDescription(), myMap);
		//lokace l03
		GMEdge l03el01l03l02l03		= new GMEdge(Utility.generateGUID(), "l03el01l03l02l03", 2000*spd, l01l03, l02l03,	Direction.Southeast, 	l03.getDescription(), myMap);
		GMEdge l03el01l03r05		= new GMEdge(Utility.generateGUID(), "l03el01l03r05", 2000*spd, l01l03, r05,		Direction.Southwest, 	l03.getDescription(), myMap);
		GMEdge l03el01l03r06		= new GMEdge(Utility.generateGUID(), "l03el01l03r06", 2000*spd, l01l03, r06,		Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el01l03r07		= new GMEdge(Utility.generateGUID(), "l03el01l03r07", 2000*spd, l01l03, r07,		Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el01l03r08		= new GMEdge(Utility.generateGUID(), "l03el01l03r08", 2000*spd, l01l03, r08,		Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el01l03r09		= new GMEdge(Utility.generateGUID(), "l03el01l03r09", 2000*spd, l01l03, r09,		Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el01l03r10		= new GMEdge(Utility.generateGUID(), "l03el01l03r10", 2000*spd, l01l03, r10,		Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el01l03r11		= new GMEdge(Utility.generateGUID(), "l03el01l03r11", 2000*spd, l01l03, r11,		Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el01l03l03l04		= new GMEdge(Utility.generateGUID(), "l03el01l03l03l04", 2000*spd, l01l03, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el02l03r05		= new GMEdge(Utility.generateGUID(), "l03el02l03r05", 2000*spd, l02l03, r05,	Direction.West, 	l03.getDescription(), myMap);
		GMEdge l03el02l03r06		= new GMEdge(Utility.generateGUID(), "l03el02l03r06", 2000*spd, l02l03, r06,	Direction.Southwest, 	l03.getDescription(), myMap);
		GMEdge l03el02l03r07		= new GMEdge(Utility.generateGUID(), "l03el02l03r07", 2000*spd, l02l03, r07,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el02l03r08		= new GMEdge(Utility.generateGUID(), "l03el02l03r08", 2000*spd, l02l03, r08,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el02l03r09		= new GMEdge(Utility.generateGUID(), "l03el02l03r09", 2000*spd, l02l03, r09,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el02l03r10		= new GMEdge(Utility.generateGUID(), "l03el02l03r10", 2000*spd, l02l03, r10,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el02l03r11		= new GMEdge(Utility.generateGUID(), "l03el02l03r11", 2000*spd, l02l03, r11,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03el02l03l03l04		= new GMEdge(Utility.generateGUID(), "l03el02l03l03l04", 2000*spd, l02l03, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er05r06		= new GMEdge(Utility.generateGUID(), "l03er05r06", 2000*spd, r05, r06,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er05r07		= new GMEdge(Utility.generateGUID(), "l03er05r07", 2000*spd, r05, r07,	Direction.Southeast, 	l03.getDescription(), myMap);
		GMEdge l03er05r08		= new GMEdge(Utility.generateGUID(), "l03er05r08", 2000*spd, r05, r08,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er05r09		= new GMEdge(Utility.generateGUID(), "l03er05r09", 2000*spd, r05, r09,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er05r10		= new GMEdge(Utility.generateGUID(), "l03er05r10", 2000*spd, r05, r10,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er05r11		= new GMEdge(Utility.generateGUID(), "l03er05r11", 2000*spd, r05, r11,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er05l03l04	= new GMEdge(Utility.generateGUID(), "l03er05l03l04", 2000*spd, r05, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er06r07		= new GMEdge(Utility.generateGUID(), "l03er06r07", 2000*spd, r06, r07,	Direction.Southeast, 	l03.getDescription(), myMap);
		GMEdge l03er06r08		= new GMEdge(Utility.generateGUID(), "l03er06r08", 2000*spd, r06, r08,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er06r09		= new GMEdge(Utility.generateGUID(), "l03er06r09", 2000*spd, r06, r09,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er06r10		= new GMEdge(Utility.generateGUID(), "l03er06r10", 2000*spd, r06, r10,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er06r11		= new GMEdge(Utility.generateGUID(), "l03er06r11", 2000*spd, r06, r11,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er06l03l04	= new GMEdge(Utility.generateGUID(), "l03er06l03l04", 2000*spd, r06, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er07r08		= new GMEdge(Utility.generateGUID(), "l03er07r08", 2000*spd, r07, r08,	Direction.Southwest, 	l03.getDescription(), myMap);
		GMEdge l03er07r09		= new GMEdge(Utility.generateGUID(), "l03er07r09", 2000*spd, r07, r09,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er07r10		= new GMEdge(Utility.generateGUID(), "l03er07r10", 2000*spd, r07, r10,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er07r11		= new GMEdge(Utility.generateGUID(), "l03er07r11", 2000*spd, r07, r11,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er07l03l04	= new GMEdge(Utility.generateGUID(), "l03er07l03l04", 2000*spd, r07, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er08r09		= new GMEdge(Utility.generateGUID(), "l03er08r09", 2000*spd, r08, r09,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er08r10		= new GMEdge(Utility.generateGUID(), "l03er08r10", 2000*spd, r08, r10,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er08r11		= new GMEdge(Utility.generateGUID(), "l03er08r11", 2000*spd, r08, r11,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er08l03l04	= new GMEdge(Utility.generateGUID(), "l03er08l03l04", 2000*spd, r08, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er09r10		= new GMEdge(Utility.generateGUID(), "l03er09r10", 2000*spd, r09, r10,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er09r11		= new GMEdge(Utility.generateGUID(), "l03er09r11", 2000*spd, r09, r11,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er09l03l04	= new GMEdge(Utility.generateGUID(), "l03er09l03l04", 2000*spd, r09, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er10r11		= new GMEdge(Utility.generateGUID(), "l03er10r11", 2000*spd, r10, r11,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er10l03l04	= new GMEdge(Utility.generateGUID(), "l03er10l03l04", 2000*spd, r10, l03l04,	Direction.South, 	l03.getDescription(), myMap);
		GMEdge l03er11l03l04	= new GMEdge(Utility.generateGUID(), "l03er11l03l04", 2000*spd, r11, l03l04,	Direction.East, 	l03.getDescription(), myMap);
		GMEdge l03el02l03l01l03 	= new GMEdge(Utility.generateGUID(), "l03el02l03l01l03", 2000*spd, l02l03, l01l03, 		Direction.Northwest, 	l03.getDescription(), myMap);
		GMEdge l03er05l01l03		= new GMEdge(Utility.generateGUID(), "l03er05l01l03", 2000*spd, r05, l01l03, 	Direction.Northeast, 	l03.getDescription(), myMap);
		GMEdge l03er06l01l03		= new GMEdge(Utility.generateGUID(), "l03er06l01l03", 2000*spd, r06, l01l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er07l01l03		= new GMEdge(Utility.generateGUID(), "l03er07l01l03", 2000*spd, r07, l01l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er08l01l03		= new GMEdge(Utility.generateGUID(), "l03er08l01l03", 2000*spd, r08, l01l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er09l01l03		= new GMEdge(Utility.generateGUID(), "l03er09l01l03", 2000*spd, r09, l01l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er10l01l03		= new GMEdge(Utility.generateGUID(), "l03er10l01l03", 2000*spd, r10, l01l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11l01l03		= new GMEdge(Utility.generateGUID(), "l03er11l01l03", 2000*spd, r11, l01l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04l01l03 	= new GMEdge(Utility.generateGUID(), "l03el03l04l01l03", 2000*spd, l03l04, l01l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er05l02l03 		= new GMEdge(Utility.generateGUID(), "l03er05l02l03", 2000*spd, r05, l02l03, 	Direction.East, 	l03.getDescription(), myMap);
		GMEdge l03er06l02l03 		= new GMEdge(Utility.generateGUID(), "l03er06l02l03", 2000*spd, r06, l02l03, 	Direction.Northeast, 	l03.getDescription(), myMap);
		GMEdge l03er07l02l03 		= new GMEdge(Utility.generateGUID(), "l03er07l02l03", 2000*spd, r07, l02l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er08l02l03 		= new GMEdge(Utility.generateGUID(), "l03er08l02l03", 2000*spd, r08, l02l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er09l02l03 		= new GMEdge(Utility.generateGUID(), "l03er09l02l03", 2000*spd, r09, l02l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er10l02l03 		= new GMEdge(Utility.generateGUID(), "l03er10l02l03", 2000*spd, r10, l02l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11l02l03 		= new GMEdge(Utility.generateGUID(), "l03er11l02l03", 2000*spd, r11, l02l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04l02l03 	= new GMEdge(Utility.generateGUID(), "l03el03l04l02l03", 2000*spd, l03l04, l02l03, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er06r05 		= new GMEdge(Utility.generateGUID(), "l03er06r05", 2000*spd, r06, r05, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er07r05 		= new GMEdge(Utility.generateGUID(), "l03er07r05", 2000*spd, r07, r05, 	Direction.Northwest, 	l03.getDescription(), myMap);
		GMEdge l03er08r05 		= new GMEdge(Utility.generateGUID(), "l03er08r05", 2000*spd, r08, r05, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er09r05 		= new GMEdge(Utility.generateGUID(), "l03er09r05", 2000*spd, r09, r05, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er10r05 		= new GMEdge(Utility.generateGUID(), "l03er10r05", 2000*spd, r10, r05, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11r05 		= new GMEdge(Utility.generateGUID(), "l03er11r05", 2000*spd, r11, r05, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04r05 	= new GMEdge(Utility.generateGUID(), "l03el03l04r05", 2000*spd, l03l04, r05, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er07r06 		= new GMEdge(Utility.generateGUID(), "l03er07r06", 2000*spd, r07, r06, 	Direction.Northwest, 	l03.getDescription(), myMap);
		GMEdge l03er08r06 		= new GMEdge(Utility.generateGUID(), "l03er08r06", 2000*spd, r08, r06, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er09r06 		= new GMEdge(Utility.generateGUID(), "l03er09r06", 2000*spd, r09, r06, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er10r06 		= new GMEdge(Utility.generateGUID(), "l03er10r06", 2000*spd, r10, r06, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11r06 		= new GMEdge(Utility.generateGUID(), "l03er11r06", 2000*spd, r11, r06, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04r06 	= new GMEdge(Utility.generateGUID(), "l03el03l04r06", 2000*spd, l03l04, r06, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er08r07 		= new GMEdge(Utility.generateGUID(), "l03er08r07", 2000*spd, r08, r07, 	Direction.Northeast, 	l03.getDescription(), myMap);
		GMEdge l03er09r07 		= new GMEdge(Utility.generateGUID(), "l03er09r07", 2000*spd, r09, r07, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er10r07 		= new GMEdge(Utility.generateGUID(), "l03er10r07", 2000*spd, r10, r07, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11r07 		= new GMEdge(Utility.generateGUID(), "l03er11r07", 2000*spd, r11, r07, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04r07 	= new GMEdge(Utility.generateGUID(), "l03el03l04r07", 2000*spd, l03l04, r07, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er09r08 		= new GMEdge(Utility.generateGUID(), "l03er09r08", 2000*spd, r09, r08, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er10r08 		= new GMEdge(Utility.generateGUID(), "l03er10r08", 2000*spd, r10, r08, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11r08 		= new GMEdge(Utility.generateGUID(), "l03er11r08", 2000*spd, r11, r08, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04r08 	= new GMEdge(Utility.generateGUID(), "l03el03l04r08", 2000*spd, l03l04, r08, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er10r09 		= new GMEdge(Utility.generateGUID(), "l03er10r09", 2000*spd, r10, r09, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11r09 		= new GMEdge(Utility.generateGUID(), "l03er11r09", 2000*spd, r11, r09, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04r09 	= new GMEdge(Utility.generateGUID(), "l03el03l04r09", 2000*spd, l03l04, r09, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03er11r10 		= new GMEdge(Utility.generateGUID(), "l03er11r10", 2000*spd, r11, r10, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04r10 	= new GMEdge(Utility.generateGUID(), "l03el03l04r10", 2000*spd, l03l04, r10, 	Direction.North, 	l03.getDescription(), myMap);
		GMEdge l03el03l04r11 	= new GMEdge(Utility.generateGUID(), "l03el03l04r11", 2000*spd, l03l04, r11, 	Direction.West, 	l03.getDescription(), myMap);
		//lokace l04
		GMEdge l04l03l04r12		= new GMEdge(Utility.generateGUID(), "l04l03l04r12", 2000*spd, l03l04, r12,		Direction.Northeast, 	l04.getDescription(), myMap);
		GMEdge l04l03l04r13		= new GMEdge(Utility.generateGUID(), "l04l03l04r13", 2000*spd, l03l04, r13,		Direction.East, 	l04.getDescription(), myMap);
		GMEdge l04l03l04l04l05	= new GMEdge(Utility.generateGUID(), "l04l03l04l04l05", 2000*spd, l03l04, l04l05,	Direction.East, 	l04.getDescription(), myMap);
		GMEdge l04r12r13		= new GMEdge(Utility.generateGUID(), "l04r12r13", 2000*spd, r12, r13,		Direction.East, 	l04.getDescription(), myMap);
		GMEdge l04r12l04l05		= new GMEdge(Utility.generateGUID(), "l04r12l04l05", 2000*spd, r12, l04l05,		Direction.East, 	l04.getDescription(), myMap);
		GMEdge l04r13l04l05		= new GMEdge(Utility.generateGUID(), "l04r13l04l05", 2000*spd, r13, l04l05,		Direction.Southeast, 	l04.getDescription(), myMap);
		GMEdge l04r12l03l04		= new GMEdge(Utility.generateGUID(), "l04r12l03l04", 2000*spd, r12,	l03l04, 	Direction.Southwest, 	l04.getDescription(), myMap);
		GMEdge l04r13l03l04		= new GMEdge(Utility.generateGUID(), "l04r13l03l04", 2000*spd, r13,	l03l04, 	Direction.West, 	l04.getDescription(), myMap);
		GMEdge l04l04l05l03l04	= new GMEdge(Utility.generateGUID(), "l04l04l05l03l04", 2000*spd, l04l05, l03l04,	Direction.West, 	l04.getDescription(), myMap);
		GMEdge l04r13r12		= new GMEdge(Utility.generateGUID(), "l04r13r12", 2000*spd, r13,	r12, 		Direction.West, 	l04.getDescription(), myMap);
		GMEdge l04l04l05r12		= new GMEdge(Utility.generateGUID(), "l04l04l05r12", 2000*spd, l04l05, r12, 	Direction.West, 	l04.getDescription(), myMap);
		GMEdge l04l04l05r13		= new GMEdge(Utility.generateGUID(), "l04l04l05r13", 2000*spd, l04l05, r13, 	Direction.Northwest, 	l04.getDescription(), myMap);
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
		
 
		

		
		
		return myMap;
	}
}
