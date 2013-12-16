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
	public static GMMap Trojanka(UUID guid1, UUID guid2)
	{

		int spd = 1000; // sekunda ma 1000 milisekund - cas pak doplnovat v sekundach nasoben touto konstantou
		GMMap myMap 	= new GMMap();
		myMap.setAuthorName("KBen");
		myMap.setAuthorEmail("email@email.com");
		myMap.setDescription("Mapa budovy FJFI ÈVUT, Trojanova 13, Praha 2");
		myMap.setGuid(Utility.generateGUID());
		myMap.setName("Trojanka");

		UUID locguid = Utility.generateGUID();
		List<UUID> loclist 	= new LinkedList<UUID>();
		loclist.add(locguid);
		Location l01 	= new Location(Utility.generateGUID(), "l01", "chodba", myMap);
		Location l02 	= new Location(Utility.generateGUID(), "l02", "severní chodba KM", myMap);
		Location l03 	= new Location(Utility.generateGUID(), "l03", "hlavní chodba KM", myMap);
		Location l04 	= new Location(Utility.generateGUID(), "l04", "jižní chodba KM", myMap);
		Location l05 	= new Location(Utility.generateGUID(), "l05", "západní chodba u vrátnice", myMap);
		Location l06 	= new Location(Utility.generateGUID(), "l06", "vrátnice", myMap);
		Location l07 	= new Location(Utility.generateGUID(), "l07", "východní chodba u vrátnice", myMap);
		Location l08 	= new Location(Utility.generateGUID(), "l08", "severní chodba u vrátnice", myMap);
		Location l09 	= new Location(Utility.generateGUID(), "l09", "chodba vedoucí k T-101", myMap);
		Location l10 	= new Location(Utility.generateGUID(), "l10", "chodba vedoucí k T-101", myMap);
		Location l11 	= new Location(Utility.generateGUID(), "l11", "chodba vedoucí k T-101", myMap);
		Location l12 	= new Location(Utility.generateGUID(), "l12", "chodba pøed T-101", myMap);
		Location l13 	= new Location(Utility.generateGUID(), "l13", "jižní chodba KFE", myMap);
		Location l14 	= new Location(Utility.generateGUID(), "l14", "hlavní chodba KFE", myMap);

		Location lr01 	= new Location(Utility.generateGUID(), "lr01", "WC", myMap);
		Location lr02 	= new Location(Utility.generateGUID(), "lr02", "T-116", myMap);
		Location lr03 	= new Location(Utility.generateGUID(), "lr03", "T-115", myMap);
		Location lr04 	= new Location(Utility.generateGUID(), "lr04", "T-115B, katedra matematiky", myMap);
		Location lr05 	= new Location(Utility.generateGUID(), "lr05", "T-112", myMap);
		Location lr06 	= new Location(Utility.generateGUID(), "lr06", "T-111", myMap);
		Location lr07 	= new Location(Utility.generateGUID(), "lr07", "T-110", myMap);
		Location lr08 	= new Location(Utility.generateGUID(), "lr08", "T-109", myMap);
		Location lr09 	= new Location(Utility.generateGUID(), "lr09", "T-108", myMap);
		Location lr10 	= new Location(Utility.generateGUID(), "lr10", "T-107", myMap);
		Location lr11 	= new Location(Utility.generateGUID(), "lr11", "T-106", myMap);
		Location lr12 	= new Location(Utility.generateGUID(), "lr12", "T-105", myMap);
		Location lr13 	= new Location(Utility.generateGUID(), "lr13", "T-104", myMap);
		Location lr14 	= new Location(Utility.generateGUID(), "lr14", "vchod", myMap);
		Location lr15 	= new Location(Utility.generateGUID(), "lr15", "T-101", myMap);
		Location lr16 	= new Location(Utility.generateGUID(), "lr16", "...", myMap);
		Location lr17 	= new Location(Utility.generateGUID(), "lr17", "WC", myMap);
		Location lr18 	= new Location(Utility.generateGUID(), "lr18", "T-118", myMap);
		Location lr19 	= new Location(Utility.generateGUID(), "lr19", "T-119, katedra fyzikální elektroniky", myMap);
		Location lr20 	= new Location(Utility.generateGUID(), "lr20", "T-120", myMap);
		Location lr21 	= new Location(Utility.generateGUID(), "lr21", "T-121", myMap);
		Location lr22 	= new Location(Utility.generateGUID(), "lr22", "T-122", myMap);
		Location lr23 	= new Location(Utility.generateGUID(), "lr23", "T-123", myMap);
		Location lr24 	= new Location(Utility.generateGUID(), "lr24", "T-124", myMap);
		Location lr25 	= new Location(Utility.generateGUID(), "lr25", "T-125", myMap);
		Location lr26 	= new Location(Utility.generateGUID(), "lr26", "T-126", myMap);
		Location lr27 	= new Location(Utility.generateGUID(), "lr27", "...", myMap);

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

		GMNode r01 	= new GMNode(guid1, "r01", loclist, l01.getDescription(), myMap);
		GMNode s01 	= new GMNode(Utility.generateGUID(), "s01", loclist, l01.getDescription(), myMap);
		GMNode l01l03 	= new GMNode(Utility.generateGUID(), "l01l03", loclist, "pøechod mezi " + l01.getDescription() + " a " + l03.getDescription(), myMap);
		GMNode r02 	= new GMNode(Utility.generateGUID(), "r02", loclist, l02.getDescription(), myMap);
		GMNode r03 	= new GMNode(Utility.generateGUID(), "r03", loclist, l02.getDescription(), myMap);
		GMNode r04 	= new GMNode(Utility.generateGUID(), "r04", loclist, l02.getDescription(), myMap);
		GMNode l02l03 	= new GMNode(Utility.generateGUID(), "l02l03", loclist, "pøechod mezi " + l02.getDescription() + " a " + l03.getDescription(), myMap);
		GMNode r05 	= new GMNode(Utility.generateGUID(), "r05", loclist, l03.getDescription(), myMap);
		GMNode r06 	= new GMNode(Utility.generateGUID(), "r06", loclist, l03.getDescription(), myMap);
		GMNode r07 	= new GMNode(Utility.generateGUID(), "r07", loclist, l03.getDescription(), myMap);
		GMNode r08 	= new GMNode(Utility.generateGUID(), "r08", loclist, l03.getDescription(), myMap);
		GMNode r09 	= new GMNode(guid2, "r09", loclist, l03.getDescription(), myMap);
		GMNode r10 	= new GMNode(Utility.generateGUID(), "r10", loclist, l03.getDescription(), myMap);
		GMNode r11 	= new GMNode(Utility.generateGUID(), "r11", loclist, l03.getDescription(), myMap); 
		GMNode l03l04 	= new GMNode(Utility.generateGUID(), "l03l04", loclist, "pøechod mezi " + l03.getDescription() + " a " + l04.getDescription(), myMap);
		GMNode r12 	= new GMNode(Utility.generateGUID(), "r12", loclist, l04.getDescription(), myMap);
		GMNode r13 	= new GMNode(Utility.generateGUID(), "r13", loclist, l04.getDescription(), myMap);
		GMNode l04l05 	= new GMNode(Utility.generateGUID(), "l04l05", loclist, "pøechod mezi " + l04.getDescription() + " a " + l05.getDescription(), myMap);
		GMNode l05l08 	= new GMNode(Utility.generateGUID(), "l05l08", loclist, "pøechod mezi " + l05.getDescription() + " a " + l08.getDescription(), myMap);
		GMNode r14 	= new GMNode(Utility.generateGUID(), "r14", loclist, l06.getDescription(), myMap);
		GMNode l06l08 	= new GMNode(Utility.generateGUID(), "l06l08", loclist, "pøechod mezi " + l06.getDescription() + " a " + l08.getDescription(), myMap);
		GMNode r16 	= new GMNode(Utility.generateGUID(), "r16", loclist, l07.getDescription(), myMap);
		GMNode r17 	= new GMNode(Utility.generateGUID(), "r17", loclist, l07.getDescription(), myMap);
		GMNode l07l08 	= new GMNode(Utility.generateGUID(), "l07l08", loclist, "pøechod mezi " + l07.getDescription() + " a " + l08.getDescription(), myMap);
		GMNode l07l13 	= new GMNode(Utility.generateGUID(), "l07l13", loclist, "pøechod mezi " + l07.getDescription() + " a " + l13.getDescription(), myMap);
		GMNode l08l09 	= new GMNode(Utility.generateGUID(), "l08l09", loclist, "pøechod mezi " + l08.getDescription() + " a " + l09.getDescription(), myMap);
		GMNode l08l10 	= new GMNode(Utility.generateGUID(), "l08l10", loclist, "pøechod mezi " + l08.getDescription() + " a " + l10.getDescription(), myMap);
		GMNode l09l11 	= new GMNode(Utility.generateGUID(), "l09l11", loclist, "pøechod mezi " + l09.getDescription() + " a " + l11.getDescription(), myMap);
		GMNode l10l11 	= new GMNode(Utility.generateGUID(), "l10l11", loclist, "pøechod mezi " + l10.getDescription() + " a " + l11.getDescription(), myMap);
		GMNode l11l12 	= new GMNode(Utility.generateGUID(), "l11l12", loclist, "pøechod mezi " + l11.getDescription() + " a " + l12.getDescription(), myMap);
		GMNode r15 	= new GMNode(Utility.generateGUID(), "r15", loclist, l12.getDescription(), myMap);
		GMNode r18 	= new GMNode(Utility.generateGUID(), "r18", loclist, l13.getDescription(), myMap);
		GMNode r19 	= new GMNode(Utility.generateGUID(), "r19", loclist, l13.getDescription(), myMap);
		GMNode r20 	= new GMNode(Utility.generateGUID(), "r20", loclist, l13.getDescription(), myMap);
		GMNode l13l14 	= new GMNode(Utility.generateGUID(), "l13l14", loclist, "pøechod mezi " + l13.getDescription() + " a " + l14.getDescription(), myMap);
		GMNode r21 	= new GMNode(Utility.generateGUID(), "r21", loclist, l14.getDescription(), myMap);
		GMNode r22 	= new GMNode(Utility.generateGUID(), "r22", loclist, l14.getDescription(), myMap);
		GMNode r23 	= new GMNode(Utility.generateGUID(), "r23", loclist, l14.getDescription(), myMap);
		GMNode r24 	= new GMNode(Utility.generateGUID(), "r24", loclist, l14.getDescription(), myMap);
		GMNode r25 	= new GMNode(Utility.generateGUID(), "r25", loclist, l14.getDescription(), myMap);
		GMNode r26 	= new GMNode(Utility.generateGUID(), "r26", loclist, l14.getDescription(), myMap);
		GMNode r27 	= new GMNode(Utility.generateGUID(), "r27", loclist, l14.getDescription(), myMap);

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
		GMEdge l01er01s01 	= new GMEdge(Utility.generateGUID(), "l01er01s01", 	6*spd, r01, s01, new Direction(Direction.Compass.Southeast), l01.getDescription(), myMap);
		GMEdge l01er01l01l03 	= new GMEdge(Utility.generateGUID(), "l01er01l01l03", 	6*spd, r01, l01l03, new Direction(Direction.Compass.South), l01.getDescription(), myMap);
		GMEdge l01es01r01 	= new GMEdge(Utility.generateGUID(), "l01es01r01", 	6*spd, s01, r01, new Direction(Direction.Compass.Northeast), l01.getDescription(), myMap);
		GMEdge l01es01l01l03 	= new GMEdge(Utility.generateGUID(), "l01es01l01l03", 	6*spd, s01, l01l03, new Direction(Direction.Compass.Southwest), l01.getDescription(), myMap);
		GMEdge l01el01l03r01 	= new GMEdge(Utility.generateGUID(), "l01el01l03r01", 	6*spd, l01l03, r01, new Direction(Direction.Compass.North), l01.getDescription(), myMap);
		GMEdge l01el01l03s01 	= new GMEdge(Utility.generateGUID(), "l01el01l03s01", 	6*spd, l01l03, s01, new Direction(Direction.Compass.Northwest), l01.getDescription(), myMap);
		//lokace l02
		GMEdge l02el02l03r02 	= new GMEdge(Utility.generateGUID(), "l02el02l03r02", 	58*spd, l02l03, r02, new Direction(Direction.Compass.East), l02.getDescription(), myMap);
		GMEdge l02el02l03r03 	= new GMEdge(Utility.generateGUID(), "l02el02l03r03", 	54*spd, l02l03, r03, new Direction(Direction.Compass.East), l02.getDescription(), myMap);
		GMEdge l02el02l03r04 	= new GMEdge(Utility.generateGUID(), "l02el02l03r04", 	48*spd, l02l03, r04, new Direction(Direction.Compass.East), l02.getDescription(), myMap);
		GMEdge l02er04r02 	= new GMEdge(Utility.generateGUID(), "l02er04r02", 	10*spd, r04, r02, new Direction(Direction.Compass.East), l02.getDescription(), myMap);
		GMEdge l02er04r03 	= new GMEdge(Utility.generateGUID(), "l02er04r03", 	6*spd, r04, r03, new Direction(Direction.Compass.East), l02.getDescription(), myMap);
		GMEdge l02er02r03 	= new GMEdge(Utility.generateGUID(), "l02er02r03", 	4*spd, r02, r03, new Direction(Direction.Compass.Southwest), l02.getDescription(), myMap);
		GMEdge l02er02l02l03 	= new GMEdge(Utility.generateGUID(), "l02er02l02l03", 	58*spd, r02, l02l03, new Direction(Direction.Compass.West), l02.getDescription(), myMap);
		GMEdge l02er03l02l03 	= new GMEdge(Utility.generateGUID(), "l02er03l02l03", 	54*spd, r03, l02l03, new Direction(Direction.Compass.West), l02.getDescription(), myMap);
		GMEdge l02er04l02l03 	= new GMEdge(Utility.generateGUID(), "l02er04l02l03", 	48*spd, r04, l02l03, new Direction(Direction.Compass.West), l02.getDescription(), myMap);
		GMEdge l02er02r04 	= new GMEdge(Utility.generateGUID(), "l02er02r04", 	10*spd, r02, r04, new Direction(Direction.Compass.West), l02.getDescription(), myMap);
		GMEdge l02er03r04 	= new GMEdge(Utility.generateGUID(), "l02er03r04", 	6*spd, r03, r04, new Direction(Direction.Compass.West), l02.getDescription(), myMap);
		GMEdge l02er03r02 	= new GMEdge(Utility.generateGUID(), "l02er03r02", 	4*spd, r03, r02, new Direction(Direction.Compass.Northeast), l02.getDescription(), myMap);
		//lokace l03
		GMEdge l03el01l03l02l03 	= new GMEdge(Utility.generateGUID(), "l03el01l03l02l03", 	4*spd, l01l03, l02l03, new Direction(Direction.Compass.Southeast), l03.getDescription(), myMap);
		GMEdge l03el01l03r05 	= new GMEdge(Utility.generateGUID(), "l03el01l03r05", 	4*spd, l01l03, r05, new Direction(Direction.Compass.Southwest), l03.getDescription(), myMap);
		GMEdge l03el01l03r06 	= new GMEdge(Utility.generateGUID(), "l03el01l03r06", 	24*spd, l01l03, r06, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el01l03r07 	= new GMEdge(Utility.generateGUID(), "l03el01l03r07", 	28*spd, l01l03, r07, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el01l03r08 	= new GMEdge(Utility.generateGUID(), "l03el01l03r08", 	40*spd, l01l03, r08, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el01l03r09 	= new GMEdge(Utility.generateGUID(), "l03el01l03r09", 	70*spd, l01l03, r09, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el01l03r10 	= new GMEdge(Utility.generateGUID(), "l03el01l03r10", 	120*spd, l01l03, r10, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el01l03r11 	= new GMEdge(Utility.generateGUID(), "l03el01l03r11", 	146*spd, l01l03, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el01l03l03l04 	= new GMEdge(Utility.generateGUID(), "l03el01l03l03l04", 	146*spd, l01l03, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el02l03r05 	= new GMEdge(Utility.generateGUID(), "l03el02l03r05", 	6*spd, l02l03, r05, new Direction(Direction.Compass.West), l03.getDescription(), myMap);
		GMEdge l03el02l03r06 	= new GMEdge(Utility.generateGUID(), "l03el02l03r06", 	20*spd, l02l03, r06, new Direction(Direction.Compass.Southwest), l03.getDescription(), myMap);
		GMEdge l03el02l03r07 	= new GMEdge(Utility.generateGUID(), "l03el02l03r07", 	24*spd, l02l03, r07, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el02l03r08 	= new GMEdge(Utility.generateGUID(), "l03el02l03r08", 	36*spd, l02l03, r08, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el02l03r09 	= new GMEdge(Utility.generateGUID(), "l03el02l03r09", 	66*spd, l02l03, r09, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el02l03r10 	= new GMEdge(Utility.generateGUID(), "l03el02l03r10", 	116*spd, l02l03, r10, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el02l03r11 	= new GMEdge(Utility.generateGUID(), "l03el02l03r11", 	140*spd, l02l03, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03el02l03l03l04 	= new GMEdge(Utility.generateGUID(), "l03el02l03l03l04", 	140*spd, l02l03, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er05r06 	= new GMEdge(Utility.generateGUID(), "l03er05r06", 	20*spd, r05, r06, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er05r07 	= new GMEdge(Utility.generateGUID(), "l03er05r07", 	24*spd, r05, r07, new Direction(Direction.Compass.Southeast), l03.getDescription(), myMap);
		GMEdge l03er05r08 	= new GMEdge(Utility.generateGUID(), "l03er05r08", 	36*spd, r05, r08, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er05r09 	= new GMEdge(Utility.generateGUID(), "l03er05r09", 	66*spd, r05, r09, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er05r10 	= new GMEdge(Utility.generateGUID(), "l03er05r10", 	116*spd, r05, r10, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er05r11 	= new GMEdge(Utility.generateGUID(), "l03er05r11", 	142*spd, r05, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er05l03l04 	= new GMEdge(Utility.generateGUID(), "l03er05l03l04", 	142*spd, r05, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er06r07 	= new GMEdge(Utility.generateGUID(), "l03er06r07", 	6*spd, r06, r07, new Direction(Direction.Compass.Southeast), l03.getDescription(), myMap);
		GMEdge l03er06r08 	= new GMEdge(Utility.generateGUID(), "l03er06r08", 	16*spd, r06, r08, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er06r09 	= new GMEdge(Utility.generateGUID(), "l03er06r09", 	46*spd, r06, r09, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er06r10 	= new GMEdge(Utility.generateGUID(), "l03er06r10", 	96*spd, r06, r10, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er06r11 	= new GMEdge(Utility.generateGUID(), "l03er06r11", 	122*spd, r06, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er06l03l04 	= new GMEdge(Utility.generateGUID(), "l03er06l03l04", 	122*spd, r06, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er07r08 	= new GMEdge(Utility.generateGUID(), "l03er07r08", 	16*spd, r07, r08, new Direction(Direction.Compass.Southwest), l03.getDescription(), myMap);
		GMEdge l03er07r09 	= new GMEdge(Utility.generateGUID(), "l03er07r09", 	46*spd, r07, r09, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er07r10 	= new GMEdge(Utility.generateGUID(), "l03er07r10", 	96*spd, r07, r10, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er07r11 	= new GMEdge(Utility.generateGUID(), "l03er07r11", 	122*spd, r07, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er07l03l04 	= new GMEdge(Utility.generateGUID(), "l03er07l03l04", 	122*spd, r07, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er08r09 	= new GMEdge(Utility.generateGUID(), "l03er08r09", 	30*spd, r08, r09, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er08r10 	= new GMEdge(Utility.generateGUID(), "l03er08r10", 	80*spd, r08, r10, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er08r11 	= new GMEdge(Utility.generateGUID(), "l03er08r11", 	106*spd, r08, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er08l03l04 	= new GMEdge(Utility.generateGUID(), "l03er08l03l04", 	106*spd, r08, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er09r10 	= new GMEdge(Utility.generateGUID(), "l03er09r10", 	50*spd, r09, r10, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er09r11 	= new GMEdge(Utility.generateGUID(), "l03er09r11", 	76*spd, r09, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er09l03l04 	= new GMEdge(Utility.generateGUID(), "l03er09l03l04", 	76*spd, r09, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er10r11 	= new GMEdge(Utility.generateGUID(), "l03er10r11", 	26*spd, r10, r11, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er10l03l04 	= new GMEdge(Utility.generateGUID(), "l03er10l03l04", 	28*spd, r10, l03l04, new Direction(Direction.Compass.South), l03.getDescription(), myMap);
		GMEdge l03er11l03l04 	= new GMEdge(Utility.generateGUID(), "l03er11l03l04", 	6*spd, r11, l03l04, new Direction(Direction.Compass.East), l03.getDescription(), myMap);
		GMEdge l03el02l03l01l03 	= new GMEdge(Utility.generateGUID(), "l03el02l03l01l03", 	4*spd, l02l03, l01l03, new Direction(Direction.Compass.Northwest), l03.getDescription(), myMap);
		GMEdge l03er05l01l03 	= new GMEdge(Utility.generateGUID(), "l03er05l01l03", 	4*spd, r05, l01l03, new Direction(Direction.Compass.Northeast), l03.getDescription(), myMap);
		GMEdge l03er06l01l03 	= new GMEdge(Utility.generateGUID(), "l03er06l01l03", 	24*spd, r06, l01l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er07l01l03 	= new GMEdge(Utility.generateGUID(), "l03er07l01l03", 	28*spd, r07, l01l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er08l01l03 	= new GMEdge(Utility.generateGUID(), "l03er08l01l03", 	40*spd, r08, l01l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er09l01l03 	= new GMEdge(Utility.generateGUID(), "l03er09l01l03", 	70*spd, r09, l01l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er10l01l03 	= new GMEdge(Utility.generateGUID(), "l03er10l01l03", 	120*spd, r10, l01l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11l01l03 	= new GMEdge(Utility.generateGUID(), "l03er11l01l03", 	146*spd, r11, l01l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04l01l03 	= new GMEdge(Utility.generateGUID(), "l03el03l04l01l03", 	146*spd, l03l04, l01l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er05l02l03 	= new GMEdge(Utility.generateGUID(), "l03er05l02l03", 	6*spd, r05, l02l03, new Direction(Direction.Compass.East), l03.getDescription(), myMap);
		GMEdge l03er06l02l03 	= new GMEdge(Utility.generateGUID(), "l03er06l02l03", 	20*spd, r06, l02l03, new Direction(Direction.Compass.Northeast), l03.getDescription(), myMap);
		GMEdge l03er07l02l03 	= new GMEdge(Utility.generateGUID(), "l03er07l02l03", 	24*spd, r07, l02l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er08l02l03 	= new GMEdge(Utility.generateGUID(), "l03er08l02l03", 	36*spd, r08, l02l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er09l02l03 	= new GMEdge(Utility.generateGUID(), "l03er09l02l03", 	66*spd, r09, l02l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er10l02l03 	= new GMEdge(Utility.generateGUID(), "l03er10l02l03", 	116*spd, r10, l02l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11l02l03 	= new GMEdge(Utility.generateGUID(), "l03er11l02l03", 	140*spd, r11, l02l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04l02l03 	= new GMEdge(Utility.generateGUID(), "l03el03l04l02l03", 	140*spd, l03l04, l02l03, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er06r05 	= new GMEdge(Utility.generateGUID(), "l03er06r05", 	20*spd, r06, r05, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er07r05 	= new GMEdge(Utility.generateGUID(), "l03er07r05", 	24*spd, r07, r05, new Direction(Direction.Compass.Northwest), l03.getDescription(), myMap);
		GMEdge l03er08r05 	= new GMEdge(Utility.generateGUID(), "l03er08r05", 	36*spd, r08, r05, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er09r05 	= new GMEdge(Utility.generateGUID(), "l03er09r05", 	66*spd, r09, r05, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er10r05 	= new GMEdge(Utility.generateGUID(), "l03er10r05", 	116*spd, r10, r05, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11r05 	= new GMEdge(Utility.generateGUID(), "l03er11r05", 	142*spd, r11, r05, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04r05 	= new GMEdge(Utility.generateGUID(), "l03el03l04r05", 	142*spd, l03l04, r05, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er07r06 	= new GMEdge(Utility.generateGUID(), "l03er07r06", 	6*spd, r07, r06, new Direction(Direction.Compass.Northwest), l03.getDescription(), myMap);
		GMEdge l03er08r06 	= new GMEdge(Utility.generateGUID(), "l03er08r06", 	16*spd, r08, r06, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er09r06 	= new GMEdge(Utility.generateGUID(), "l03er09r06", 	46*spd, r09, r06, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er10r06 	= new GMEdge(Utility.generateGUID(), "l03er10r06", 	96*spd, r10, r06, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11r06 	= new GMEdge(Utility.generateGUID(), "l03er11r06", 	122*spd, r11, r06, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04r06 	= new GMEdge(Utility.generateGUID(), "l03el03l04r06", 	122*spd, l03l04, r06, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er08r07 	= new GMEdge(Utility.generateGUID(), "l03er08r07", 	16*spd, r08, r07, new Direction(Direction.Compass.Northeast), l03.getDescription(), myMap);
		GMEdge l03er09r07 	= new GMEdge(Utility.generateGUID(), "l03er09r07", 	46*spd, r09, r07, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er10r07 	= new GMEdge(Utility.generateGUID(), "l03er10r07", 	96*spd, r10, r07, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11r07 	= new GMEdge(Utility.generateGUID(), "l03er11r07", 	122*spd, r11, r07, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04r07 	= new GMEdge(Utility.generateGUID(), "l03el03l04r07", 	122*spd, l03l04, r07, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er09r08 	= new GMEdge(Utility.generateGUID(), "l03er09r08", 	30*spd, r09, r08, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er10r08 	= new GMEdge(Utility.generateGUID(), "l03er10r08", 	80*spd, r10, r08, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11r08 	= new GMEdge(Utility.generateGUID(), "l03er11r08", 	106*spd, r11, r08, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04r08 	= new GMEdge(Utility.generateGUID(), "l03el03l04r08", 	106*spd, l03l04, r08, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er10r09 	= new GMEdge(Utility.generateGUID(), "l03er10r09", 	50*spd, r10, r09, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11r09 	= new GMEdge(Utility.generateGUID(), "l03er11r09", 	76*spd, r11, r09, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04r09 	= new GMEdge(Utility.generateGUID(), "l03el03l04r09", 	76*spd, l03l04, r09, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03er11r10 	= new GMEdge(Utility.generateGUID(), "l03er11r10", 	26*spd, r11, r10, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04r10 	= new GMEdge(Utility.generateGUID(), "l03el03l04r10", 	28*spd, l03l04, r10, new Direction(Direction.Compass.North), l03.getDescription(), myMap);
		GMEdge l03el03l04r11 	= new GMEdge(Utility.generateGUID(), "l03el03l04r11", 	6*spd, l03l04, r11, new Direction(Direction.Compass.West), l03.getDescription(), myMap);
		//lokace l04
		GMEdge l04l03l04r12 	= new GMEdge(Utility.generateGUID(), "l04l03l04r12", 	8*spd, l03l04, r12, new Direction(Direction.Compass.Northeast), l04.getDescription(), myMap);
		GMEdge l04l03l04r13 	= new GMEdge(Utility.generateGUID(), "l04l03l04r13", 	8*spd, l03l04, r13, new Direction(Direction.Compass.East), l04.getDescription(), myMap);
		GMEdge l04l03l04l04l05 	= new GMEdge(Utility.generateGUID(), "l04l03l04l04l05", 	8*spd, l03l04, l04l05, new Direction(Direction.Compass.East), l04.getDescription(), myMap);
		GMEdge l04r12r13 	= new GMEdge(Utility.generateGUID(), "l04r12r13", 	8*spd, r12, r13, new Direction(Direction.Compass.East), l04.getDescription(), myMap);
		GMEdge l04r12l04l05 	= new GMEdge(Utility.generateGUID(), "l04r12l04l05", 	8*spd, r12, l04l05, new Direction(Direction.Compass.East), l04.getDescription(), myMap);
		GMEdge l04r13l04l05 	= new GMEdge(Utility.generateGUID(), "l04r13l04l05", 	8*spd, r13, l04l05, new Direction(Direction.Compass.Southeast), l04.getDescription(), myMap);
		GMEdge l04r12l03l04 	= new GMEdge(Utility.generateGUID(), "l04r12l03l04", 	8*spd, r12, l03l04, new Direction(Direction.Compass.Southwest), l04.getDescription(), myMap);
		GMEdge l04r13l03l04 	= new GMEdge(Utility.generateGUID(), "l04r13l03l04", 	8*spd, r13, l03l04, new Direction(Direction.Compass.West), l04.getDescription(), myMap);
		GMEdge l04l04l05l03l04 	= new GMEdge(Utility.generateGUID(), "l04l04l05l03l04", 	8*spd, l04l05, l03l04, new Direction(Direction.Compass.West), l04.getDescription(), myMap);
		GMEdge l04r13r12 	= new GMEdge(Utility.generateGUID(), "l04r13r12", 	8*spd, r13, r12, new Direction(Direction.Compass.West), l04.getDescription(), myMap);
		GMEdge l04l04l05r12 	= new GMEdge(Utility.generateGUID(), "l04l04l05r12", 	8*spd, l04l05, r12, new Direction(Direction.Compass.West), l04.getDescription(), myMap);
		GMEdge l04l04l05r13 	= new GMEdge(Utility.generateGUID(), "l04l04l05r13", 	8*spd, l04l05, r13, new Direction(Direction.Compass.Northwest), l04.getDescription(), myMap);
		//lokace l05
		GMEdge l05l04l05l05l08 	= new GMEdge(Utility.generateGUID(), "l05l04l05l05l08", 	8*spd, l04l05, l05l08, new Direction(Direction.Compass.North), l05.getDescription(), myMap);
		GMEdge l05l05l08l04l05 	= new GMEdge(Utility.generateGUID(), "l05l05l08l04l05", 	8*spd, l05l08, l04l05, new Direction(Direction.Compass.South), l05.getDescription(), myMap);
		//lokace l06
		GMEdge l06r14l06l08 	= new GMEdge(Utility.generateGUID(), "l06r14l06l08", 	8*spd, r14, l06l08, new Direction(Direction.Compass.North, Direction.Vertical.Upwards), l06.getDescription(), myMap); //new Direction(Direction.Compass.Up
		GMEdge l06l06l08r14 	= new GMEdge(Utility.generateGUID(), "l06l06l08r14", 	8*spd, l06l08, r14, new Direction(Direction.Compass.South, Direction.Vertical.Downwards), l06.getDescription(), myMap); //new Direction(Direction.Compass.Down
		//lokace l07
		GMEdge l07l07l08r16 	= new GMEdge(Utility.generateGUID(), "l07l07l08r16", 	8*spd, l07l08, r16, new Direction(Direction.Compass.East), l07.getDescription(), myMap); 
		GMEdge l07l07l08r17 	= new GMEdge(Utility.generateGUID(), "l07l07l08r17", 	8*spd, l07l08, r17, new Direction(Direction.Compass.South), l07.getDescription(), myMap); 
		GMEdge l07l07l08l07l13 	= new GMEdge(Utility.generateGUID(), "l07l07l08l07l13", 	8*spd, l07l08, l07l13, new Direction(Direction.Compass.South), l07.getDescription(), myMap); 
		GMEdge l07r16r17 	= new GMEdge(Utility.generateGUID(), "l07r16r17", 	8*spd, r16, r17, new Direction(Direction.Compass.South), l07.getDescription(), myMap); 
		GMEdge l07r16l07l13 	= new GMEdge(Utility.generateGUID(), "l07r16l07l13", 	8*spd, r16, l07l13, new Direction(Direction.Compass.South), l07.getDescription(), myMap); 
		GMEdge l07r17l07l13 	= new GMEdge(Utility.generateGUID(), "l07r17l07l13", 	8*spd, r17, l07l13, new Direction(Direction.Compass.South), l07.getDescription(), myMap); 
		GMEdge l07r16l07l08 	= new GMEdge(Utility.generateGUID(), "l07r16l07l08", 	8*spd, r16, l07l08, new Direction(Direction.Compass.West), l07.getDescription(), myMap); 
		GMEdge l07r17l07l08 	= new GMEdge(Utility.generateGUID(), "l07r17l07l08", 	8*spd, r17, l07l08, new Direction(Direction.Compass.North), l07.getDescription(), myMap); 
		GMEdge l07l07l13l07l08 	= new GMEdge(Utility.generateGUID(), "l07l07l13l07l08", 	8*spd, l07l13, l07l08, new Direction(Direction.Compass.North), l07.getDescription(), myMap); 
		GMEdge l07r17r16 	= new GMEdge(Utility.generateGUID(), "l07r17r16", 	8*spd, r17, r16, new Direction(Direction.Compass.North), l07.getDescription(), myMap); 
		GMEdge l07l07l13r16 	= new GMEdge(Utility.generateGUID(), "l07l07l13r16", 	8*spd, l07l13, r16, new Direction(Direction.Compass.North), l07.getDescription(), myMap); 
		GMEdge l07l07l13r17 	= new GMEdge(Utility.generateGUID(), "l07l07l13r17", 	8*spd, l07l13, r17, new Direction(Direction.Compass.North), l07.getDescription(), myMap); 
		//lokace l08
		GMEdge l08l05l08l06l08 	= new GMEdge(Utility.generateGUID(), "l08l05l08l06l08", 	8*spd, l05l08, l06l08, new Direction(Direction.Compass.East), l08.getDescription(), myMap); 
		GMEdge l08l05l08l07l08 	= new GMEdge(Utility.generateGUID(), "l08l05l08l07l08", 	8*spd, l05l08, l07l08, new Direction(Direction.Compass.East), l08.getDescription(), myMap); 
		GMEdge l08l05l08l08l09 	= new GMEdge(Utility.generateGUID(), "l08l05l08l08l09", 	8*spd, l05l08, l08l09, new Direction(Direction.Compass.East), l08.getDescription(), myMap); 
		GMEdge l08l05l08l08l10 	= new GMEdge(Utility.generateGUID(), "l08l05l08l08l10", 	8*spd, l05l08, l08l10, new Direction(Direction.Compass.East), l08.getDescription(), myMap); 
		GMEdge l08l06l08l07l08 	= new GMEdge(Utility.generateGUID(), "l08l06l08l07l08", 	8*spd, l06l08, l07l08, new Direction(Direction.Compass.East), l08.getDescription(), myMap); 
		GMEdge l08l06l08l08l09 	= new GMEdge(Utility.generateGUID(), "l08l06l08l08l09", 	8*spd, l06l08, l08l09, new Direction(Direction.Compass.Northwest), l08.getDescription(), myMap); 
		GMEdge l08l06l08l08l10 	= new GMEdge(Utility.generateGUID(), "l08l06l08l08l10", 	8*spd, l06l08, l08l10, new Direction(Direction.Compass.Northeast), l08.getDescription(), myMap); 
		GMEdge l08l07l08l08l09 	= new GMEdge(Utility.generateGUID(), "l08l07l08l08l09", 	8*spd, l07l08, l08l09, new Direction(Direction.Compass.West), l08.getDescription(), myMap); 
		GMEdge l08l07l08l08l10 	= new GMEdge(Utility.generateGUID(), "l08l07l08l08l10", 	8*spd, l07l08, l08l10, new Direction(Direction.Compass.Northwest), l08.getDescription(), myMap); 
		GMEdge l08l08l09l08l10 	= new GMEdge(Utility.generateGUID(), "l08l08l09l08l10", 	8*spd, l08l09, l08l10, new Direction(Direction.Compass.East), l08.getDescription(), myMap); 
		GMEdge l08l06l08l05l08 	= new GMEdge(Utility.generateGUID(), "l08l06l08l05l08", 	8*spd, l06l08, l05l08, new Direction(Direction.Compass.West), l08.getDescription(), myMap); 
		GMEdge l08l07l08l05l08 	= new GMEdge(Utility.generateGUID(), "l08l07l08l05l08", 	8*spd, l07l08, l05l08, new Direction(Direction.Compass.West), l08.getDescription(), myMap); 
		GMEdge l08l08l09l05l08 	= new GMEdge(Utility.generateGUID(), "l08l08l09l05l08", 	8*spd, l08l09, l05l08, new Direction(Direction.Compass.West), l08.getDescription(), myMap); 
		GMEdge l08l08l10l05l08 	= new GMEdge(Utility.generateGUID(), "l08l08l10l05l08", 	8*spd, l08l10, l05l08, new Direction(Direction.Compass.West), l08.getDescription(), myMap); 
		GMEdge l08l07l08l06l08 	= new GMEdge(Utility.generateGUID(), "l08l07l08l06l08", 	8*spd, l07l08, l06l08, new Direction(Direction.Compass.West), l08.getDescription(), myMap); 
		GMEdge l08l08l09l06l08 	= new GMEdge(Utility.generateGUID(), "l08l08l09l06l08", 	8*spd, l08l09, l06l08, new Direction(Direction.Compass.Southeast), l08.getDescription(), myMap); 
		GMEdge l08l08l10l06l08 	= new GMEdge(Utility.generateGUID(), "l08l08l10l06l08", 	8*spd, l08l10, l06l08, new Direction(Direction.Compass.Southwest), l08.getDescription(), myMap); 
		GMEdge l08l08l09l07l08 	= new GMEdge(Utility.generateGUID(), "l08l08l09l07l08", 	8*spd, l08l09, l07l08, new Direction(Direction.Compass.East), l08.getDescription(), myMap); 
		GMEdge l08l08l10l07l08 	= new GMEdge(Utility.generateGUID(), "l08l08l10l07l08", 	8*spd, l08l10, l07l08, new Direction(Direction.Compass.Southeast), l08.getDescription(), myMap); 
		GMEdge l08l08l10l08l09 	= new GMEdge(Utility.generateGUID(), "l08l08l10l08l09", 	8*spd, l08l10, l08l09, new Direction(Direction.Compass.West), l08.getDescription(), myMap); 
		//lokace l09
		GMEdge l09l08l09l09l11 	= new GMEdge(Utility.generateGUID(), "l09l08l09l09l11", 	8*spd, l08l09, l09l11, new Direction(Direction.Compass.North), l09.getDescription(), myMap); 
		GMEdge l09l09l11l08l09 	= new GMEdge(Utility.generateGUID(), "l09l09l11l08l09", 	8*spd, l09l11, l08l09, new Direction(Direction.Compass.South), l09.getDescription(), myMap); 
		//lokace l10
		GMEdge l10l08l10l10l11 	= new GMEdge(Utility.generateGUID(), "l10l08l10l10l11", 	8*spd, l08l10, l10l11, new Direction(Direction.Compass.North), l10.getDescription(), myMap); 
		GMEdge l10l10l11l08l10 	= new GMEdge(Utility.generateGUID(), "l10l10l11l08l10", 	8*spd, l10l11, l08l10, new Direction(Direction.Compass.South), l10.getDescription(), myMap); 
		//lokace l11
		GMEdge l11l10l11l09l11 	= new GMEdge(Utility.generateGUID(), "l11l10l11l09l11", 	8*spd, l10l11, l09l11, new Direction(Direction.Compass.West), l11.getDescription(), myMap); 
		GMEdge l11l10l11l11l12 	= new GMEdge(Utility.generateGUID(), "l11l10l11l11l12", 	8*spd, l10l11, l11l12, new Direction(Direction.Compass.Northwest), l11.getDescription(), myMap); 
		GMEdge l11l09l11l11l12 	= new GMEdge(Utility.generateGUID(), "l11l09l11l11l12", 	8*spd, l09l11, l11l12, new Direction(Direction.Compass.North), l11.getDescription(), myMap); 
		GMEdge l11l09l11l10l11 	= new GMEdge(Utility.generateGUID(), "l11l09l11l10l11", 	8*spd, l09l11, l10l11, new Direction(Direction.Compass.East), l11.getDescription(), myMap); 
		GMEdge l11l11l12l10l11 	= new GMEdge(Utility.generateGUID(), "l11l11l12l10l11", 	8*spd, l11l12, l10l11, new Direction(Direction.Compass.Southeast), l11.getDescription(), myMap); 
		GMEdge l11l11l12l09l11 	= new GMEdge(Utility.generateGUID(), "l11l11l12l09l11", 	8*spd, l11l12, l09l11, new Direction(Direction.Compass.South), l11.getDescription(), myMap); 
		//lokace l12
		GMEdge l12l11l12r15 	= new GMEdge(Utility.generateGUID(), "l12l11l12r15", 	8*spd, l11l12, r15, new Direction(Direction.Compass.Northwest), l12.getDescription(), myMap); 
		GMEdge l12r15l11l12 	= new GMEdge(Utility.generateGUID(), "l12r15l11l12", 	8*spd, r15, l11l12, new Direction(Direction.Compass.Southeast), l12.getDescription(), myMap); 

		//lokace l13
		GMEdge l13l07l13r18 	= new GMEdge(Utility.generateGUID(), "l13l07l13r18", 	8*spd, l07l13, r18, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13l07l13r19 	= new GMEdge(Utility.generateGUID(), "l13l07l13r19", 	8*spd, l07l13, r19, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13l07l13r20 	= new GMEdge(Utility.generateGUID(), "l13l07l13r20", 	8*spd, l07l13, r20, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13l07l13l13l14 	= new GMEdge(Utility.generateGUID(), "l13l07l13l13l14", 	8*spd, l07l13, l13l14, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13r18r19 	= new GMEdge(Utility.generateGUID(), "l13r18r19", 	8*spd, r18, r19, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13r18r20 	= new GMEdge(Utility.generateGUID(), "l13r18r20", 	8*spd, r18, r20, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13r18l13l14 	= new GMEdge(Utility.generateGUID(), "l13r18l13l14", 	8*spd, r18, l13l14, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13r19r20 	= new GMEdge(Utility.generateGUID(), "l13r19r20", 	8*spd, r19, r20, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13r19l13l14 	= new GMEdge(Utility.generateGUID(), "l13r19l13l14", 	8*spd, r19, l13l14, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13r20l13l14 	= new GMEdge(Utility.generateGUID(), "l13r20l13l14", 	8*spd, r20, l13l14, new Direction(Direction.Compass.East), l13.getDescription(), myMap); 
		GMEdge l13r18l07l13 	= new GMEdge(Utility.generateGUID(), "l13r18l07l13", 	8*spd, r18, l07l13, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13r19l07l13 	= new GMEdge(Utility.generateGUID(), "l13r19l07l13", 	8*spd, r19, l07l13, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13r20l07l13 	= new GMEdge(Utility.generateGUID(), "l13r20l07l13", 	8*spd, r20, l07l13, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13l13l14l07l13 	= new GMEdge(Utility.generateGUID(), "l13l13l14l07l13", 	8*spd, l13l14, l07l13, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13r19r18 	= new GMEdge(Utility.generateGUID(), "l13r19r18", 	8*spd, r19, r18, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13r20r18 	= new GMEdge(Utility.generateGUID(), "l13r20r18", 	8*spd, r20, r18, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13l13l14r18 	= new GMEdge(Utility.generateGUID(), "l13l13l14r18", 	8*spd, l13l14, r18, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13r20r19 	= new GMEdge(Utility.generateGUID(), "l13r20r19", 	8*spd, r20, r19, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13l13l14r19 	= new GMEdge(Utility.generateGUID(), "l13l13l14r19", 	8*spd, l13l14, r19, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 
		GMEdge l13l13l14r20 	= new GMEdge(Utility.generateGUID(), "l13l13l14r20", 	8*spd, l13l14, r20, new Direction(Direction.Compass.West), l13.getDescription(), myMap); 

		//lokace l14
		GMEdge l14l13l14r21 	= new GMEdge(Utility.generateGUID(), "l14l13l14r21", 	8*spd, l13l14, r21, new Direction(Direction.Compass.East), l14.getDescription(), myMap); 
		GMEdge l14l13l14r22 	= new GMEdge(Utility.generateGUID(), "l14l13l14r22", 	8*spd, l13l14, r22, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14l13l14r23 	= new GMEdge(Utility.generateGUID(), "l14l13l14r23", 	8*spd, l13l14, r23, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14l13l14r24 	= new GMEdge(Utility.generateGUID(), "l14l13l14r24", 	8*spd, l13l14, r24, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14l13l14r25 	= new GMEdge(Utility.generateGUID(), "l14l13l14r25", 	8*spd, l13l14, r25, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14l13l14r26 	= new GMEdge(Utility.generateGUID(), "l14l13l14r26", 	8*spd, l13l14, r26, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14l13l14r27 	= new GMEdge(Utility.generateGUID(), "l14l13l14r27", 	8*spd, l13l14, r27, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r21r22 	= new GMEdge(Utility.generateGUID(), "l14r21r22", 	8*spd, r21, r22, new Direction(Direction.Compass.Northwest), l14.getDescription(), myMap); 
		GMEdge l14r21r23 	= new GMEdge(Utility.generateGUID(), "l14r21r23", 	8*spd, r21, r23, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r21r24 	= new GMEdge(Utility.generateGUID(), "l14r21r24", 	8*spd, r21, r24, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r21r25 	= new GMEdge(Utility.generateGUID(), "l14r21r25", 	8*spd, r21, r25, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r21r26 	= new GMEdge(Utility.generateGUID(), "l14r21r26", 	8*spd, r21, r26, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r21r27 	= new GMEdge(Utility.generateGUID(), "l14r21r27", 	8*spd, r21, r27, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r22r23 	= new GMEdge(Utility.generateGUID(), "l14r22r23", 	8*spd, r22, r23, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r22r24 	= new GMEdge(Utility.generateGUID(), "l14r22r24", 	8*spd, r22, r24, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r22r25 	= new GMEdge(Utility.generateGUID(), "l14r22r25", 	8*spd, r22, r25, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r22r26 	= new GMEdge(Utility.generateGUID(), "l14r22r26", 	8*spd, r22, r26, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r22r27 	= new GMEdge(Utility.generateGUID(), "l14r22r27", 	8*spd, r22, r27, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r23r24 	= new GMEdge(Utility.generateGUID(), "l14r23r24", 	8*spd, r23, r24, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r23r25 	= new GMEdge(Utility.generateGUID(), "l14r23r25", 	8*spd, r23, r25, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r23r26 	= new GMEdge(Utility.generateGUID(), "l14r23r26", 	8*spd, r23, r26, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r23r27 	= new GMEdge(Utility.generateGUID(), "l14r23r27", 	8*spd, r23, r27, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r24r25 	= new GMEdge(Utility.generateGUID(), "l14r24r25", 	8*spd, r24, r25, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r24r26 	= new GMEdge(Utility.generateGUID(), "l14r24r26", 	8*spd, r24, r26, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r24r27 	= new GMEdge(Utility.generateGUID(), "l14r24r27", 	8*spd, r24, r27, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r25r26 	= new GMEdge(Utility.generateGUID(), "l14r25r26", 	8*spd, r25, r26, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r25r27 	= new GMEdge(Utility.generateGUID(), "l14r25r27", 	8*spd, r25, r27, new Direction(Direction.Compass.North), l14.getDescription(), myMap); 
		GMEdge l14r26r27 	= new GMEdge(Utility.generateGUID(), "l14r26r27", 	8*spd, r26, r27, new Direction(Direction.Compass.Northwest), l14.getDescription(), myMap); 
		GMEdge l14r21l13l14 	= new GMEdge(Utility.generateGUID(), "l14r21l13l14", 	8*spd, r21, l13l14, new Direction(Direction.Compass.West), l14.getDescription(), myMap); 
		GMEdge l14r22l13l14 	= new GMEdge(Utility.generateGUID(), "l14r22l13l14", 	8*spd, r22, l13l14, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r23l13l14 	= new GMEdge(Utility.generateGUID(), "l14r23l13l14", 	8*spd, r23, l13l14, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r24l13l14 	= new GMEdge(Utility.generateGUID(), "l14r24l13l14", 	8*spd, r24, l13l14, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r25l13l14 	= new GMEdge(Utility.generateGUID(), "l14r25l13l14", 	8*spd, r25, l13l14, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r26l13l14 	= new GMEdge(Utility.generateGUID(), "l14r26l13l14", 	8*spd, r26, l13l14, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r27l13l14 	= new GMEdge(Utility.generateGUID(), "l14r27l13l14", 	8*spd, r27, l13l14, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r22r21 	= new GMEdge(Utility.generateGUID(), "l14r22r21", 	8*spd, r22, r21, new Direction(Direction.Compass.Southeast), l14.getDescription(), myMap); 
		GMEdge l14r23r21 	= new GMEdge(Utility.generateGUID(), "l14r23r21", 	8*spd, r23, r21, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r24r21 	= new GMEdge(Utility.generateGUID(), "l14r24r21", 	8*spd, r24, r21, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r25r21 	= new GMEdge(Utility.generateGUID(), "l14r25r21", 	8*spd, r25, r21, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r26r21 	= new GMEdge(Utility.generateGUID(), "l14r26r21", 	8*spd, r26, r21, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r27r21 	= new GMEdge(Utility.generateGUID(), "l14r27r21", 	8*spd, r27, r21, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r23r22 	= new GMEdge(Utility.generateGUID(), "l14r23r22", 	8*spd, r23, r22, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r24r22 	= new GMEdge(Utility.generateGUID(), "l14r24r22", 	8*spd, r24, r22, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r25r22 	= new GMEdge(Utility.generateGUID(), "l14r25r22", 	8*spd, r25, r22, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r26r22 	= new GMEdge(Utility.generateGUID(), "l14r26r22", 	8*spd, r26, r22, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r27r22 	= new GMEdge(Utility.generateGUID(), "l14r27r22", 	8*spd, r27, r22, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r24r23 	= new GMEdge(Utility.generateGUID(), "l14r24r23", 	8*spd, r24, r23, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r25r23 	= new GMEdge(Utility.generateGUID(), "l14r25r23", 	8*spd, r25, r23, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r26r23 	= new GMEdge(Utility.generateGUID(), "l14r26r23", 	8*spd, r26, r23, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r27r23 	= new GMEdge(Utility.generateGUID(), "l14r27r23", 	8*spd, r27, r23, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r25r24 	= new GMEdge(Utility.generateGUID(), "l14r25r24", 	8*spd, r25, r24, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r26r24 	= new GMEdge(Utility.generateGUID(), "l14r26r24", 	8*spd, r26, r24, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r27r24 	= new GMEdge(Utility.generateGUID(), "l14r27r24", 	8*spd, r27, r24, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r26r25 	= new GMEdge(Utility.generateGUID(), "l14r26r25", 	8*spd, r26, r25, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r27r25 	= new GMEdge(Utility.generateGUID(), "l14r27r25", 	8*spd, r27, r25, new Direction(Direction.Compass.South), l14.getDescription(), myMap); 
		GMEdge l14r27r26 	= new GMEdge(Utility.generateGUID(), "l14r27r26", 	8*spd, r27, r26, new Direction(Direction.Compass.Southeast), l14.getDescription(), myMap); 

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

		// II. patro

		Location l15 	= new Location(Utility.generateGUID(), "l15", "schodištì", myMap);
		Location l16 	= new Location(Utility.generateGUID(), "l16", "schodištì", myMap);
		Location l17 	= new Location(Utility.generateGUID(), "l17", "schodištì", myMap);
		Location l18 	= new Location(Utility.generateGUID(), "l18", "chodba v 2. patøe", myMap);
		Location l19 	= new Location(Utility.generateGUID(), "l19", "chodba v 2. patøe", myMap);
		Location l20 	= new Location(Utility.generateGUID(), "l20", "chodba v 2. patøe", myMap);
		Location l21 	= new Location(Utility.generateGUID(), "l21", "chodba v 2. patøe", myMap);
		Location l22 	= new Location(Utility.generateGUID(), "l22", "chodba v 2. patøe", myMap);
		Location l23 	= new Location(Utility.generateGUID(), "l23", "chodba v 2. patøe", myMap);
		Location lr28 	= new Location(Utility.generateGUID(), "lr28", "...", myMap);
		Location lr29 	= new Location(Utility.generateGUID(), "lr29", "WC", myMap);
		Location lr30 	= new Location(Utility.generateGUID(), "lr30", "WC", myMap);
		Location lr31 	= new Location(Utility.generateGUID(), "lr31", "T-228", myMap);
		Location lr32 	= new Location(Utility.generateGUID(), "lr32", "T-204", myMap);
		Location lr33 	= new Location(Utility.generateGUID(), "lr33", "T-205", myMap);
		Location lr34 	= new Location(Utility.generateGUID(), "lr34", "T-206", myMap);
		Location lr35 	= new Location(Utility.generateGUID(), "lr35", "T-207", myMap);
		Location lr36 	= new Location(Utility.generateGUID(), "lr36", "T-208", myMap);
		Location lr37 	= new Location(Utility.generateGUID(), "lr37", "T-209", myMap);
		Location lr38 	= new Location(Utility.generateGUID(), "lr38", "T-210", myMap);
		Location lr39 	= new Location(Utility.generateGUID(), "lr39", "T-211", myMap);
		Location lr40 	= new Location(Utility.generateGUID(), "lr40", "T-212", myMap);
		Location lr41 	= new Location(Utility.generateGUID(), "lr41", "WC", myMap);
		Location lr42 	= new Location(Utility.generateGUID(), "lr42", "T-214, studovna", myMap);
		Location ls02 	= new Location(Utility.generateGUID(), "s02", "schodištì", myMap);

		myMap.addLocation(l15); myMap.addLocation(l16); myMap.addLocation(l17); myMap.addLocation(l18); 
		myMap.addLocation(l19); myMap.addLocation(l20); myMap.addLocation(l21); myMap.addLocation(l22); 
		myMap.addLocation(l23); myMap.addLocation(lr28); myMap.addLocation(lr29); myMap.addLocation(lr30); 
		myMap.addLocation(lr31); myMap.addLocation(lr32); myMap.addLocation(lr33); myMap.addLocation(lr34); 
		myMap.addLocation(lr35); myMap.addLocation(lr36); myMap.addLocation(lr37); myMap.addLocation(lr38); 
		myMap.addLocation(lr39); myMap.addLocation(lr40); myMap.addLocation(lr41); myMap.addLocation(lr42); 
		myMap.addLocation(ls02); 

		GMNode l15l16 	= new GMNode(Utility.generateGUID(), "l15l16", loclist, "pøechod mezi " + l15.getDescription() + " a " + l16.getDescription(), myMap);
		GMNode l15l18 	= new GMNode(Utility.generateGUID(), "l15l18", loclist, "pøechod mezi " + l15.getDescription() + " a " + l18.getDescription(), myMap);
		GMNode l16l17 	= new GMNode(Utility.generateGUID(), "l16l17", loclist, "pøechod mezi " + l16.getDescription() + " a " + l17.getDescription(), myMap);
		//GMNode l16l18 	= new GMNode(Utility.generateGUID(), "l16l18", loclist, "pøechod mezi " + l16.getDescription() + " a " + l18.getDescription(), myMap);
		GMNode l08l16 	= new GMNode(Utility.generateGUID(), "l08l16", loclist, "pøechod mezi " + l08.getDescription() + " a " + l16.getDescription(), myMap);
		GMNode l17l18 	= new GMNode(Utility.generateGUID(), "l17l18", loclist, "pøechod mezi " + l17.getDescription() + " a " + l18.getDescription(), myMap);
		GMNode l18l19 	= new GMNode(Utility.generateGUID(), "l18l19", loclist, "pøechod mezi " + l18.getDescription() + " a " + l19.getDescription(), myMap);
		GMNode l18l20 	= new GMNode(Utility.generateGUID(), "l18l20", loclist, "pøechod mezi " + l18.getDescription() + " a " + l20.getDescription(), myMap);
		GMNode r31 	= new GMNode(Utility.generateGUID(), "r31", loclist, lr31.getDescription(), myMap);
		GMNode l19l21 	= new GMNode(Utility.generateGUID(), "l19l21", loclist, "pøechod mezi " + l19.getDescription() + " a " + l21.getDescription(), myMap);
		GMNode r28 	= new GMNode(Utility.generateGUID(), "r28", loclist, lr28.getDescription(), myMap);
		GMNode r29 	= new GMNode(Utility.generateGUID(), "r29", loclist, lr29.getDescription(), myMap);
		GMNode r30 	= new GMNode(Utility.generateGUID(), "r30", loclist, lr30.getDescription(), myMap);
		GMNode r32 	= new GMNode(Utility.generateGUID(), "r32", loclist, lr32.getDescription(), myMap);
		GMNode r33 	= new GMNode(Utility.generateGUID(), "r33", loclist, lr33.getDescription(), myMap);
		GMNode r34 	= new GMNode(Utility.generateGUID(), "r34", loclist, lr34.getDescription(), myMap);
		GMNode l21l22 	= new GMNode(Utility.generateGUID(), "l21l22", loclist, "pøechod mezi " + l21.getDescription() + " a " + l22.getDescription(), myMap);
		GMNode r35 	= new GMNode(Utility.generateGUID(), "r35", loclist, lr35.getDescription(), myMap);
		GMNode r36 	= new GMNode(Utility.generateGUID(), "r36", loclist, lr36.getDescription(), myMap);
		GMNode r37 	= new GMNode(Utility.generateGUID(), "r37", loclist, lr37.getDescription(), myMap);
		GMNode r38 	= new GMNode(Utility.generateGUID(), "r38", loclist, lr38.getDescription(), myMap);
		GMNode r39 	= new GMNode(Utility.generateGUID(), "r39", loclist, lr39.getDescription(), myMap);
		GMNode r40 	= new GMNode(Utility.generateGUID(), "r40", loclist, lr40.getDescription(), myMap);
		GMNode r41 	= new GMNode(Utility.generateGUID(), "r41", loclist, lr41.getDescription(), myMap);
		GMNode l22l23 	= new GMNode(Utility.generateGUID(), "l22l23", loclist, "pøechod mezi " + l22.getDescription() + " a " + l23.getDescription(), myMap);
		GMNode r42 	= new GMNode(Utility.generateGUID(), "r42", loclist, lr42.getDescription(), myMap);
		GMNode s02 	= new GMNode(Utility.generateGUID(), "s02", loclist, ls02.getDescription(), myMap);

		myMap.addNode(l15l16); myMap.addNode(l15l18); myMap.addNode(l16l17); myMap.addNode(l08l16);//myMap.addNode(l16l18); 
		myMap.addNode(l17l18); myMap.addNode(l18l19); myMap.addNode(l18l20); myMap.addNode(r31); 
		myMap.addNode(l19l21); myMap.addNode(r28); myMap.addNode(r29); myMap.addNode(r30); 
		myMap.addNode(r32); myMap.addNode(r33); myMap.addNode(r34); myMap.addNode(l21l22); 
		myMap.addNode(r35); myMap.addNode(r36); myMap.addNode(r37); myMap.addNode(r38); 
		myMap.addNode(r39); myMap.addNode(r40); myMap.addNode(r41); myMap.addNode(l22l23); 
		myMap.addNode(r42); myMap.addNode(s02); 

		/********************************************************/
		//schodištì mezi 2. a 3. patrem
		Location l35 	= new Location(Utility.generateGUID(), "l35", "schodištì", myMap);
		myMap.addLocation(l35); 
		GMNode l18l35 	= new GMNode(Utility.generateGUID(), "l18l35", loclist, "pøechod mezi " + l18.getDescription() + " a " + l35.getDescription(), myMap);
		myMap.addNode(l18l35);
		/********************************************************/


		//lokace l15
		GMEdge l15l15l16l15l18 	= new GMEdge(Utility.generateGUID(), "l15l15l16l15l18", 	8*spd, l15l16, l15l18, new Direction(Direction.Compass.South, Direction.Vertical.Upwards), l15.getDescription(), myMap);
		GMEdge l15l15l18l15l16 	= new GMEdge(Utility.generateGUID(), "l15l15l18l15l16", 	8*spd, l15l18, l15l16, new Direction(Direction.Compass.North, Direction.Vertical.Downwards), l15.getDescription(), myMap);
		//lokace l16
		GMEdge l16l15l16l16l17 	= new GMEdge(Utility.generateGUID(), "l16l15l16l16l17", 	8*spd, l15l16, l16l17, new Direction(Direction.Compass.East), l16.getDescription(), myMap);
		//GMEdge l16l15l16l16l18 	= new GMEdge(Utility.generateGUID(), "", 	8*spd, l15l16, l16l18, new Direction(Direction.Compass.Southeast), l16.getDescription(), myMap);
		//GMEdge l16l16l17l16l18 	= new GMEdge(Utility.generateGUID(), "", 	8*spd, l16l17, l16l18, new Direction(Direction.Compass.Southwest), l16.getDescription(), myMap);
		GMEdge l16l15l16l08l16 	= new GMEdge(Utility.generateGUID(), "l16l15l16l08l16", 	8*spd, l15l16, l08l16, new Direction(Direction.Compass.Southeast, Direction.Vertical.Downwards), l16.getDescription(), myMap);
		GMEdge l16l16l17l08l16 	= new GMEdge(Utility.generateGUID(), "l16l16l17l08l16", 	8*spd, l16l17, l08l16, new Direction(Direction.Compass.Southwest, Direction.Vertical.Downwards), l16.getDescription(), myMap);
		GMEdge l16l16l17l15l16 	= new GMEdge(Utility.generateGUID(), "l16l16l17l15l16", 	8*spd, l16l17, l15l16, new Direction(Direction.Compass.West), l16.getDescription(), myMap); 
		//GMEdge l16l16l18l15l16 	= new GMEdge(Utility.generateGUID(), "", 	8*spd, l16l18, l15l16, new Direction(Direction.Compass.Northwest), l16.getDescription(), myMap);
		//GMEdge l16l16l18l16l17 	= new GMEdge(Utility.generateGUID(), "", 	8*spd, l16l18, l16l17, new Direction(Direction.Compass.Northeast), l16.getDescription(), myMap);
		GMEdge l16l08l16l15l16 	= new GMEdge(Utility.generateGUID(), "l16l08l16l15l16", 	8*spd, l08l16, l15l16, new Direction(Direction.Compass.Northwest, Direction.Vertical.Upwards), l16.getDescription(), myMap);
		GMEdge l16l08l16l16l17 	= new GMEdge(Utility.generateGUID(), "l16l08l16l16l17", 	8*spd, l08l16, l16l17, new Direction(Direction.Compass.Northeast, Direction.Vertical.Upwards), l16.getDescription(), myMap);
		//lokace l17 
		GMEdge l17l16l17l17l18 	= new GMEdge(Utility.generateGUID(), "l17l16l17l17l18", 	8*spd, l16l17, l17l18, new Direction(Direction.Compass.South, Direction.Vertical.Upwards), l17.getDescription(), myMap);
		GMEdge l17l17l18l16l17 	= new GMEdge(Utility.generateGUID(), "l17l17l18l16l17", 	8*spd, l17l18, l16l17, new Direction(Direction.Compass.North, Direction.Vertical.Downwards), l17.getDescription(), myMap);
		//lokace l18
		//GMEdge l18l15l18l16l18 	= new GMEdge(Utility.generateGUID(), "", 	8*spd, l15l18, l16l18, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l15l18l18l35 	= new GMEdge(Utility.generateGUID(), "l18l15l18l18l35", 	8*spd, l15l18, l18l35, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l15l18l17l18 	= new GMEdge(Utility.generateGUID(), "l18l15l18l17l18", 	8*spd, l15l18, l17l18, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l15l18l18l19 	= new GMEdge(Utility.generateGUID(), "l18l15l18l18l19", 	8*spd, l15l18, l18l19, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l15l18l18l20 	= new GMEdge(Utility.generateGUID(), "l18l15l18l18l20", 	8*spd, l15l18, l18l20, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		//GMEdge l18l16l18l17l18 	= new GMEdge(Utility.generateGUID(), "e l18l16l18l17l", 	8*spd, l16l18, l17l18, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		//GMEdge l18l16l18l18l19 	= new GMEdge(Utility.generateGUID(), "e l18l16l18l18l", 	8*spd, l16l18, l18l19, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		//GMEdge l18l16l18l18l20 	= new GMEdge(Utility.generateGUID(), "e l18l16l18l18l", 	8*spd, l16l18, l18l20, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l18l35l17l18 	= new GMEdge(Utility.generateGUID(), "l18l18l35l17l18", 	8*spd, l18l35, l17l18, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l18l35l18l19 	= new GMEdge(Utility.generateGUID(), "l18l18l35l18l19", 	8*spd, l18l35, l18l19, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l18l35l18l20 	= new GMEdge(Utility.generateGUID(), "l18l18l35l18l20", 	8*spd, l18l35, l18l20, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l17l18l18l19 	= new GMEdge(Utility.generateGUID(), "l18l17l18l18l19", 	8*spd, l17l18, l18l19, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l17l18l18l20 	= new GMEdge(Utility.generateGUID(), "l18l17l18l18l20", 	8*spd, l17l18, l18l20, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l18l19l18l20 	= new GMEdge(Utility.generateGUID(), "l18l18l19l18l20", 	8*spd, l18l19, l18l20, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		//GMEdge l18l16l18l15l18 	= new GMEdge(Utility.generateGUID(), "e l18l16l18l15l", 	8*spd, l16l18, l15l18, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l18l35l15l18 	= new GMEdge(Utility.generateGUID(), "l18l18l35l15l18", 	8*spd, l18l35, l15l18, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l17l18l15l18 	= new GMEdge(Utility.generateGUID(), "l18l17l18l15l18", 	8*spd, l17l18, l15l18, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l18l19l15l18 	= new GMEdge(Utility.generateGUID(), "l18l18l19l15l18", 	8*spd, l18l19, l15l18, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l18l20l15l18 	= new GMEdge(Utility.generateGUID(), "l18l18l20l15l18", 	8*spd, l18l20, l15l18, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		//GMEdge l18l17l18l16l18 	= new GMEdge(Utility.generateGUID(), "e l18l17l18l16l", 	8*spd, l17l18, l16l18, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		//GMEdge l18l18l19l16l18 	= new GMEdge(Utility.generateGUID(), "e l18l18l19l16l", 	8*spd, l18l19, l16l18, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		//GMEdge l18l18l20l16l18 	= new GMEdge(Utility.generateGUID(), "e l18l18l20l16l", 	8*spd, l18l20, l16l18, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l17l18l18l35 	= new GMEdge(Utility.generateGUID(), "l18l17l18l18l35", 	8*spd, l17l18, l18l35, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l18l19l18l35 	= new GMEdge(Utility.generateGUID(), "l18l18l19l18l35", 	8*spd, l18l19, l18l35, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l18l20l18l35 	= new GMEdge(Utility.generateGUID(), "l18l18l20l18l35", 	8*spd, l18l20, l18l35, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l18l19l17l18 	= new GMEdge(Utility.generateGUID(), "l18l18l19l17l18", 	8*spd, l18l19, l17l18, new Direction(Direction.Compass.East), l18.getDescription(), myMap);
		GMEdge l18l18l20l17l18 	= new GMEdge(Utility.generateGUID(), "l18l18l20l17l18", 	8*spd, l18l20, l17l18, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		GMEdge l18l18l20l18l19 	= new GMEdge(Utility.generateGUID(), "l18l18l20l18l19", 	8*spd, l18l20, l18l19, new Direction(Direction.Compass.West), l18.getDescription(), myMap);
		//lokace l19
		GMEdge l19l18l19l19l21 	= new GMEdge(Utility.generateGUID(), "l19l18l19l19l21", 	8*spd, l18l19, l19l21, new Direction(Direction.Compass.South), l19.getDescription(), myMap);
		GMEdge l19l18l19r31 	= new GMEdge(Utility.generateGUID(), "l19l18l19r31", 	8*spd, l18l19, r31, new Direction(Direction.Compass.South), l19.getDescription(), myMap);
		GMEdge l19r31l19l21 	= new GMEdge(Utility.generateGUID(), "l19r31l19l21", 	8*spd, r31, l19l21, new Direction(Direction.Compass.West), l19.getDescription(), myMap); 
		GMEdge l19l19l21l18l19 	= new GMEdge(Utility.generateGUID(), "l19l19l21l18l19", 	8*spd, l19l21, l18l19, new Direction(Direction.Compass.North), l19.getDescription(), myMap);
		GMEdge l19r31l18l19 	= new GMEdge(Utility.generateGUID(), "l19r31l18l19", 	8*spd, r31, l18l19, new Direction(Direction.Compass.North), l19.getDescription(), myMap);
		GMEdge l19l19l21r31 	= new GMEdge(Utility.generateGUID(), "l19l19l21r31", 	8*spd, l19l21, r31, new Direction(Direction.Compass.East), l19.getDescription(), myMap);
		//lokace l20
		GMEdge l20l18l20r28 	= new GMEdge(Utility.generateGUID(), "l20l18l20r28", 	8*spd, l18l20, r28, new Direction(Direction.Compass.South), l20.getDescription(), myMap);
		GMEdge l20l18l20r29 	= new GMEdge(Utility.generateGUID(), "l20l18l20r29", 	8*spd, l18l20, r29, new Direction(Direction.Compass.Southeast), l20.getDescription(), myMap);
		GMEdge l20l18l20r30 	= new GMEdge(Utility.generateGUID(), "l20l18l20r30", 	8*spd, l18l20, r30, new Direction(Direction.Compass.East), l20.getDescription(), myMap);
		GMEdge l20r28r29 	= new GMEdge(Utility.generateGUID(), "l20r28r29", 	8*spd, r28, r29, new Direction(Direction.Compass.North), l20.getDescription(), myMap);
		GMEdge l20r28r30 	= new GMEdge(Utility.generateGUID(), "l20r28r30", 	8*spd, r28, r30, new Direction(Direction.Compass.North), l20.getDescription(), myMap);
		GMEdge l20r29r30 	= new GMEdge(Utility.generateGUID(), "l20r29r30", 	8*spd, r29, r30, new Direction(Direction.Compass.North), l20.getDescription(), myMap); 
		GMEdge l20r28l18l20 	= new GMEdge(Utility.generateGUID(), "l20r28l18l20", 	8*spd, r28, l18l20, new Direction(Direction.Compass.North), l20.getDescription(), myMap);
		GMEdge l20r29l18l20 	= new GMEdge(Utility.generateGUID(), "l20r29l18l20", 	8*spd, r29, l18l20, new Direction(Direction.Compass.Northwest), l20.getDescription(), myMap);
		GMEdge l20r30l18l20 	= new GMEdge(Utility.generateGUID(), "l20r30l18l20", 	8*spd, r30, l18l20, new Direction(Direction.Compass.West), l20.getDescription(), myMap);
		GMEdge l20r29r28 	= new GMEdge(Utility.generateGUID(), "l20r29r28", 	8*spd, r29, r28, new Direction(Direction.Compass.South), l20.getDescription(), myMap);
		GMEdge l20r30r28 	= new GMEdge(Utility.generateGUID(), "l20r30r28", 	8*spd, r30, r28, new Direction(Direction.Compass.South), l20.getDescription(), myMap);
		GMEdge l20r30r29 	= new GMEdge(Utility.generateGUID(), "l20r30r29", 	8*spd, r30, r29, new Direction(Direction.Compass.South), l20.getDescription(), myMap);
		//lokace l21
		GMEdge l21l19l21r32 	= new GMEdge(Utility.generateGUID(), "l21l19l21r32", 	8*spd, l19l21, r32, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21l19l21r33 	= new GMEdge(Utility.generateGUID(), "l21l19l21r33", 	8*spd, l19l21, r33, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21l19l21r34 	= new GMEdge(Utility.generateGUID(), "l21l19l21r34", 	8*spd, l19l21, r34, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21l19l21l21l22 	= new GMEdge(Utility.generateGUID(), "l21l19l21l21l22", 	8*spd, l19l21, l21l22, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21r32r33 	= new GMEdge(Utility.generateGUID(), "l21r32r33", 	8*spd, r32, r33, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21r32r34 	= new GMEdge(Utility.generateGUID(), "l21r32r34", 	8*spd, r32, r34, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21r32l21l22 	= new GMEdge(Utility.generateGUID(), "l21r32l21l22", 	8*spd, r32, l21l22, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21r33r34 	= new GMEdge(Utility.generateGUID(), "l21r33r34", 	8*spd, r33, r34, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21r33l21l22 	= new GMEdge(Utility.generateGUID(), "l21r33l21l22", 	8*spd, r33, l21l22, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21r34l21l22 	= new GMEdge(Utility.generateGUID(), "l21r34l21l22", 	8*spd, r34, l21l22, new Direction(Direction.Compass.West), l21.getDescription(), myMap);
		GMEdge l21r32l19l21 	= new GMEdge(Utility.generateGUID(), "l21r32l19l21", 	8*spd, r32, l19l21, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21r33l19l21 	= new GMEdge(Utility.generateGUID(), "l21r33l19l21", 	8*spd, r33, l19l21, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21r34l19l21 	= new GMEdge(Utility.generateGUID(), "l21r34l19l21", 	8*spd, r34, l19l21, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21l21l22l19l21 	= new GMEdge(Utility.generateGUID(), "l21l21l22l19l21 ", 	8*spd, l21l22, l19l21, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21r33r32 	= new GMEdge(Utility.generateGUID(), "l21r33r32", 	8*spd, r33, r32, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21r34r32 	= new GMEdge(Utility.generateGUID(), "l21r34r32", 	8*spd, r34, r32, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21l21l22r32 	= new GMEdge(Utility.generateGUID(), "l21l21l22r32", 	8*spd, l21l22, r32, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21r34r33 	= new GMEdge(Utility.generateGUID(), "l21r34r33", 	8*spd, r34, r33, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21l21l22r33 	= new GMEdge(Utility.generateGUID(), "l21l21l22r33", 	8*spd, l21l22, r33, new Direction(Direction.Compass.East), l21.getDescription(), myMap);
		GMEdge l21l21l22r34 	= new GMEdge(Utility.generateGUID(), "l21l21l22r34", 	8*spd, l21l22, r34, new Direction(Direction.Compass.East), l21.getDescription(), myMap);

		//lokace l22
		GMEdge l22l21l22r35 	= new GMEdge(Utility.generateGUID(), "l22l21l22r35", 	8*spd, l21l22, r35, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22r36 	= new GMEdge(Utility.generateGUID(), "l22l21l22r36", 	8*spd, l21l22, r36, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22r37 	= new GMEdge(Utility.generateGUID(), "l22l21l22r37", 	8*spd, l21l22, r37, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22r38 	= new GMEdge(Utility.generateGUID(), "l22l21l22r38", 	8*spd, l21l22, r38, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22r39 	= new GMEdge(Utility.generateGUID(), "l22l21l22r39", 	8*spd, l21l22, r39, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22r40 	= new GMEdge(Utility.generateGUID(), "l22l21l22r40", 	8*spd, l21l22, r40, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22r41 	= new GMEdge(Utility.generateGUID(), "l22l21l22r41", 	8*spd, l21l22, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22l22l23 	= new GMEdge(Utility.generateGUID(), "l22l21l22l22l23", 	8*spd, l21l22, l22l23, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22l21l22s02 	= new GMEdge(Utility.generateGUID(), "l22l21l22s02", 	8*spd, l21l22, s02, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35r36 	= new GMEdge(Utility.generateGUID(), "l22r35r36", 	8*spd, r35, r36, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35r37 	= new GMEdge(Utility.generateGUID(), "l22r35r37", 	8*spd, r35, r37, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35r38 	= new GMEdge(Utility.generateGUID(), "l22r35r38", 	8*spd, r35, r38, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35r39 	= new GMEdge(Utility.generateGUID(), "l22r35r39", 	8*spd, r35, r39, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35r40 	= new GMEdge(Utility.generateGUID(), "l22r35r40", 	8*spd, r35, r40, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35r41 	= new GMEdge(Utility.generateGUID(), "l22r35r41", 	8*spd, r35, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35l22l23 	= new GMEdge(Utility.generateGUID(), "l22r35l22l23", 	8*spd, r35, l22l23, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35s02 	= new GMEdge(Utility.generateGUID(), "l22r35s02", 	8*spd, r35, s02, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r36r37 	= new GMEdge(Utility.generateGUID(), "l22r36r37", 	8*spd, r36, r37, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r36r38 	= new GMEdge(Utility.generateGUID(), "l22r36r38", 	8*spd, r36, r38, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r36r39 	= new GMEdge(Utility.generateGUID(), "l22r36r39", 	8*spd, r36, r39, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r36r40 	= new GMEdge(Utility.generateGUID(), "l22r36r40", 	8*spd, r36, r40, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r36r41 	= new GMEdge(Utility.generateGUID(), "l22r36r41", 	8*spd, r36, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r36l22l23 	= new GMEdge(Utility.generateGUID(), "l22r36l22l23", 	8*spd, r36, l22l23, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r36s02 	= new GMEdge(Utility.generateGUID(), "l22r36s02", 	8*spd, r36, s02, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r37r38 	= new GMEdge(Utility.generateGUID(), "l22r37r38", 	8*spd, r37, r38, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r37r39 	= new GMEdge(Utility.generateGUID(), "l22r37r39", 	8*spd, r37, r39, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r37r40 	= new GMEdge(Utility.generateGUID(), "l22r37r40", 	8*spd, r37, r40, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r37r41 	= new GMEdge(Utility.generateGUID(), "l22r37r41", 	8*spd, r37, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r37l22l23 	= new GMEdge(Utility.generateGUID(), "l22r37l22l23", 	8*spd, r37, l22l23, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r37s02 	= new GMEdge(Utility.generateGUID(), "l22r37s02", 	8*spd, r37, s02, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r38r39 	= new GMEdge(Utility.generateGUID(), "l22r38r39", 	8*spd, r38, r39, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r38r40 	= new GMEdge(Utility.generateGUID(), "l22r38r40", 	8*spd, r38, r40, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r38r41 	= new GMEdge(Utility.generateGUID(), "l22r38r41", 	8*spd, r38, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r38l22l23 	= new GMEdge(Utility.generateGUID(), "l22r38l22l23", 	8*spd, r38, l22l23, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r38s02 	= new GMEdge(Utility.generateGUID(), "l22r38s02", 	8*spd, r38, s02, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r39r40 	= new GMEdge(Utility.generateGUID(), "l22r39r40", 	8*spd, r39, r40, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r39r41 	= new GMEdge(Utility.generateGUID(), "l22r39r41", 	8*spd, r39, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r39l22l23 	= new GMEdge(Utility.generateGUID(), "l22r39l22l23", 	8*spd, r39, l22l23, new Direction(Direction.Compass.Northwest), l22.getDescription(), myMap);
		GMEdge l22r39s02 	= new GMEdge(Utility.generateGUID(), "l22r39s02", 	8*spd, r39, s02, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r40r41 	= new GMEdge(Utility.generateGUID(), "l22r40r41", 	8*spd, r40, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r40l22l23 	= new GMEdge(Utility.generateGUID(), "l22r40l22l23", 	8*spd, r40, l22l23, new Direction(Direction.Compass.Southwest), l22.getDescription(), myMap);
		GMEdge l22r40s02 	= new GMEdge(Utility.generateGUID(), "l22r40s02", 	8*spd, r40, s02, new Direction(Direction.Compass.Northwest), l22.getDescription(), myMap);
		GMEdge l22r41l22l23 	= new GMEdge(Utility.generateGUID(), "l22r41l22l23", 	8*spd, r41, l22l23, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41s02 	= new GMEdge(Utility.generateGUID(), "l22r41s02", 	8*spd, r41, s02, new Direction(Direction.Compass.Southwest), l22.getDescription(), myMap);
		GMEdge l22l22l23s02 	= new GMEdge(Utility.generateGUID(), "l22l22l23s02", 	8*spd, l22l23, s02, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22r35l21l22 	= new GMEdge(Utility.generateGUID(), "l22r35l21l22", 	8*spd, r35, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r36l21l22 	= new GMEdge(Utility.generateGUID(), "l22r36l21l22", 	8*spd, r36, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r37l21l22 	= new GMEdge(Utility.generateGUID(), "l22r37l21l22", 	8*spd, r37, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r38l21l22 	= new GMEdge(Utility.generateGUID(), "l22r38l21l22", 	8*spd, r38, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r39l21l22 	= new GMEdge(Utility.generateGUID(), "l22r39l21l22", 	8*spd, r39, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r40l21l22 	= new GMEdge(Utility.generateGUID(), "l22r40l21l22", 	8*spd, r40, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41l21l22 	= new GMEdge(Utility.generateGUID(), "l22r41l21l22", 	8*spd, r41, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22l22l23l21l22 	= new GMEdge(Utility.generateGUID(), "l22l22l23l21l22", 	8*spd, l22l23, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22s02l21l22 	= new GMEdge(Utility.generateGUID(), "l22s02l21l22", 	8*spd, s02, l21l22, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r36r35 	= new GMEdge(Utility.generateGUID(), "l22r36r35", 	8*spd, r36, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r37r35 	= new GMEdge(Utility.generateGUID(), "l22r37r35", 	8*spd, r37, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r38r35 	= new GMEdge(Utility.generateGUID(), "l22r38r35", 	8*spd, r38, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r39r35 	= new GMEdge(Utility.generateGUID(), "l22r39r35", 	8*spd, r39, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r40r35 	= new GMEdge(Utility.generateGUID(), "l22r40r35", 	8*spd, r40, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41r35 	= new GMEdge(Utility.generateGUID(), "l22r41r35", 	8*spd, r41, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22l22l23r35 	= new GMEdge(Utility.generateGUID(), "l22l22l23r35", 	8*spd, l22l23, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22s02r35 	= new GMEdge(Utility.generateGUID(), "l22s02r35", 	8*spd, s02, r35, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r37r36 	= new GMEdge(Utility.generateGUID(), "l22r37r36", 	8*spd, r37, r36, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r38r36 	= new GMEdge(Utility.generateGUID(), "l22r38r36", 	8*spd, r38, r36, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r39r36 	= new GMEdge(Utility.generateGUID(), "l22r39r36", 	8*spd, r39, r36, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r40r36 	= new GMEdge(Utility.generateGUID(), "l22r40r36", 	8*spd, r40, r36, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41r36 	= new GMEdge(Utility.generateGUID(), "l22r41r36", 	8*spd, r41, r36, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22l22l23r36 	= new GMEdge(Utility.generateGUID(), "l22l22l23r36", 	8*spd, l22l23, r36, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22s02r36 	= new GMEdge(Utility.generateGUID(), "l22s02r36", 	8*spd, s02, r36, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r38r37 	= new GMEdge(Utility.generateGUID(), "l22r38r37", 	8*spd, r38, r37, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r39r37 	= new GMEdge(Utility.generateGUID(), "l22r39r37", 	8*spd, r39, r37, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r40r37 	= new GMEdge(Utility.generateGUID(), "l22r40r37", 	8*spd, r40, r37, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41r37 	= new GMEdge(Utility.generateGUID(), "l22r41r37", 	8*spd, r41, r37, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22l22l23r37 	= new GMEdge(Utility.generateGUID(), "l22l22l23r37", 	8*spd, l22l23, r37, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22s02r37 	= new GMEdge(Utility.generateGUID(), "l22s02r37", 	8*spd, s02, r37, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r39r38 	= new GMEdge(Utility.generateGUID(), "l22r39r38", 	8*spd, r39, r38, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r40r38 	= new GMEdge(Utility.generateGUID(), "l22r40r38", 	8*spd, r40, r38, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41r38 	= new GMEdge(Utility.generateGUID(), "l22r41r38", 	8*spd, r41, r38, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22l22l23r38 	= new GMEdge(Utility.generateGUID(), "l22l22l23r38", 	8*spd, l22l23, r38, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22s02r38 	= new GMEdge(Utility.generateGUID(), "l22s02r38", 	8*spd, s02, r38, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r40r39 	= new GMEdge(Utility.generateGUID(), "l22r40r39", 	8*spd, r40, r39, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41r39 	= new GMEdge(Utility.generateGUID(), "l22r41r39", 	8*spd, r41, r39, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22l22l23r39 	= new GMEdge(Utility.generateGUID(), "l22l22l23r39", 	8*spd, l22l23, r39, new Direction(Direction.Compass.Southeast), l22.getDescription(), myMap);
		GMEdge l22s02r39 	= new GMEdge(Utility.generateGUID(), "l22s02r39", 	8*spd, s02, r39, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22r41r40 	= new GMEdge(Utility.generateGUID(), "l22r41r40", 	8*spd, r41, r40, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		GMEdge l22l22l23r40 	= new GMEdge(Utility.generateGUID(), "l22l22l23r40", 	8*spd, l22l23, r40, new Direction(Direction.Compass.Northeast), l22.getDescription(), myMap);
		GMEdge l22s02r40 	= new GMEdge(Utility.generateGUID(), "l22s02r40", 	8*spd, s02, r40, new Direction(Direction.Compass.Southeast), l22.getDescription(), myMap);
		GMEdge l22l22l23r41 	= new GMEdge(Utility.generateGUID(), "l22l22l23r41", 	8*spd, l22l23, r41, new Direction(Direction.Compass.North), l22.getDescription(), myMap);
		GMEdge l22s02r41 	= new GMEdge(Utility.generateGUID(), "l22s02r41", 	8*spd, s02, r41, new Direction(Direction.Compass.Northeast), l22.getDescription(), myMap);
		GMEdge l22s02l22l23 	= new GMEdge(Utility.generateGUID(), "l22s02l22l23", 	8*spd, s02, l22l23, new Direction(Direction.Compass.South), l22.getDescription(), myMap);
		//lokace l23
		GMEdge l23l22l23r42 	= new GMEdge(Utility.generateGUID(), "l23l22l23r42", 	8*spd, l22l23, r42, new Direction(Direction.Compass.East), l23.getDescription(), myMap);
		GMEdge l23r42l22l23 	= new GMEdge(Utility.generateGUID(), "l23r42l22l23", 	8*spd, r42, l22l23, new Direction(Direction.Compass.West), l23.getDescription(), myMap);

		//lokace l15
		myMap.addEdge(l15l15l16l15l18); myMap.addEdge(l15l15l18l15l16); 
		//lokace l16
		myMap.addEdge(l16l15l16l16l17 ); /* myMap.addEdge(l16l15l16l16l18 ); myMap.addEdge(l16l16l17l16l18 ); */ myMap.addEdge(l16l16l17l15l16 ); 
		/* myMap.addEdge(l16l16l18l15l16 ); myMap.addEdge(l16l16l18l16l17 ); */
		//lokace l17
		myMap.addEdge(l17l16l17l17l18); myMap.addEdge(l17l17l18l16l17); 
		//lokace l18
		/* myMap.addEdge(l18l15l18l16l18); */ myMap.addEdge(l18l15l18l17l18); myMap.addEdge(l18l15l18l18l19); myMap.addEdge(l18l15l18l18l20); 
		/* myMap.addEdge(l18l16l18l17l18); myMap.addEdge(l18l16l18l18l19); myMap.addEdge(l18l16l18l18l20); */ myMap.addEdge(l18l17l18l18l19); 
		myMap.addEdge(l18l17l18l18l20); myMap.addEdge(l18l18l19l18l20); /* myMap.addEdge(l18l16l18l15l18); */myMap.addEdge(l18l17l18l15l18); 
		myMap.addEdge(l18l18l19l15l18); myMap.addEdge(l18l18l20l15l18); /* myMap.addEdge(l18l17l18l16l18); myMap.addEdge(l18l18l19l16l18); */
		/* myMap.addEdge(l18l18l20l16l18); */myMap.addEdge(l18l18l19l17l18); myMap.addEdge(l18l18l20l17l18); myMap.addEdge(l18l18l20l18l19); 
		myMap.addEdge(l18l15l18l18l35); myMap.addEdge(l18l18l35l17l18); myMap.addEdge(l18l18l35l18l19); myMap.addEdge(l18l18l35l18l20); 
		myMap.addEdge(l18l18l35l15l18); myMap.addEdge(l18l17l18l18l35); myMap.addEdge(l18l18l19l18l35); myMap.addEdge(l18l18l20l18l35); 
		//lokace l19
		myMap.addEdge(l19l18l19l19l21); myMap.addEdge(l19l18l19r31); myMap.addEdge(l19r31l19l21); myMap.addEdge(l19l19l21l18l19); 
		myMap.addEdge(l19r31l18l19); myMap.addEdge(l19l19l21r31); 
		//lokace l20
		myMap.addEdge(l20l18l20r28); myMap.addEdge(l20l18l20r29); myMap.addEdge(l20l18l20r30); myMap.addEdge(l20r28r29); 
		myMap.addEdge(l20r28r30); myMap.addEdge(l20r29r30); myMap.addEdge(l20r28l18l20); myMap.addEdge(l20r29l18l20); 
		myMap.addEdge(l20r30l18l20); myMap.addEdge(l20r29r28); myMap.addEdge(l20r30r28); myMap.addEdge(l20r30r29); 
		//lokace l21
		myMap.addEdge(l21l19l21r32); myMap.addEdge(l21l19l21r33); myMap.addEdge(l21l19l21r34); myMap.addEdge(l21l19l21l21l22); 
		myMap.addEdge(l21r32r33); myMap.addEdge(l21r32r34); myMap.addEdge(l21r32l21l22); myMap.addEdge(l21r33r34); 
		myMap.addEdge(l21r33l21l22); myMap.addEdge(l21r34l21l22); myMap.addEdge(l21r32l19l21); myMap.addEdge(l21r33l19l21); 
		myMap.addEdge(l21r34l19l21); myMap.addEdge(l21l21l22l19l21); myMap.addEdge(l21r33r32); myMap.addEdge(l21r34r32); 
		myMap.addEdge(l21l21l22r32); myMap.addEdge(l21r34r33); myMap.addEdge(l21l21l22r33); myMap.addEdge(l21l21l22r34); 
		//lokace l22
		myMap.addEdge(l22l21l22r35); myMap.addEdge(l22l21l22r36); myMap.addEdge(l22l21l22r37); myMap.addEdge(l22l21l22r38); 
		myMap.addEdge(l22l21l22r39); myMap.addEdge(l22l21l22r40); myMap.addEdge(l22l21l22r41); myMap.addEdge(l22l21l22l22l23); 
		myMap.addEdge(l22l21l22s02); myMap.addEdge(l22r35r36); myMap.addEdge(l22r35r37); myMap.addEdge(l22r35r38); 
		myMap.addEdge(l22r35r39); myMap.addEdge(l22r35r40); myMap.addEdge(l22r35r41); myMap.addEdge(l22r35l22l23); 
		myMap.addEdge(l22r35s02); myMap.addEdge(l22r36r37); myMap.addEdge(l22r36r38); myMap.addEdge(l22r36r39); 
		myMap.addEdge(l22r36r40); myMap.addEdge(l22r36r41); myMap.addEdge(l22r36l22l23); myMap.addEdge(l22r36s02); 
		myMap.addEdge(l22r37r38); myMap.addEdge(l22r37r39); myMap.addEdge(l22r37r40); myMap.addEdge(l22r37r41); 
		myMap.addEdge(l22r37l22l23); myMap.addEdge(l22r37s02); myMap.addEdge(l22r38r39); myMap.addEdge(l22r38r40); 
		myMap.addEdge(l22r38r41); myMap.addEdge(l22r38l22l23); myMap.addEdge(l22r38s02); myMap.addEdge(l22r39r40); 
		myMap.addEdge(l22r39r41); myMap.addEdge(l22r39l22l23); myMap.addEdge(l22r39s02); myMap.addEdge(l22r40r41); 
		myMap.addEdge(l22r40l22l23); myMap.addEdge(l22r40s02); myMap.addEdge(l22r41l22l23); myMap.addEdge(l22r41s02); 
		myMap.addEdge(l22l22l23s02); myMap.addEdge(l22r35l21l22); myMap.addEdge(l22r36l21l22); myMap.addEdge(l22r37l21l22); 
		myMap.addEdge(l22r38l21l22); myMap.addEdge(l22r39l21l22); myMap.addEdge(l22r40l21l22); myMap.addEdge(l22r41l21l22); 
		myMap.addEdge(l22l22l23l21l22); myMap.addEdge(l22s02l21l22); myMap.addEdge(l22r36r35); myMap.addEdge(l22r37r35); 
		myMap.addEdge(l22r38r35); myMap.addEdge(l22r39r35); myMap.addEdge(l22r40r35); myMap.addEdge(l22r41r35); 
		myMap.addEdge(l22l22l23r35); myMap.addEdge(l22s02r35); myMap.addEdge(l22r37r36); myMap.addEdge(l22r38r36); 
		myMap.addEdge(l22r39r36); myMap.addEdge(l22r40r36); myMap.addEdge(l22r41r36); myMap.addEdge(l22l22l23r36); 
		myMap.addEdge(l22s02r36); myMap.addEdge(l22r38r37); myMap.addEdge(l22r39r37); myMap.addEdge(l22r40r37); 
		myMap.addEdge(l22r41r37); myMap.addEdge(l22l22l23r37); myMap.addEdge(l22s02r37); myMap.addEdge(l22r39r38); 
		myMap.addEdge(l22r40r38); myMap.addEdge(l22r41r38); myMap.addEdge(l22l22l23r38); myMap.addEdge(l22s02r38); 
		myMap.addEdge(l22r40r39); myMap.addEdge(l22r41r39); myMap.addEdge(l22l22l23r39); myMap.addEdge(l22s02r39); 
		myMap.addEdge(l22r41r40); myMap.addEdge(l22l22l23r40); myMap.addEdge(l22s02r40); myMap.addEdge(l22l22l23r41); 
		myMap.addEdge(l22s02r41); myMap.addEdge(l22s02l22l23); 
		//lokace l23
		myMap.addEdge(l23l22l23r42); myMap.addEdge(l23r42l22l23); 
		// doplnìní
		myMap.addEdge(l16l15l16l08l16); myMap.addEdge(l16l16l17l08l16); myMap.addEdge(l16l08l16l15l16); myMap.addEdge(l16l08l16l16l17); 




		//0 patro

		Location l24 	= new Location(Utility.generateGUID(), "l24", "chodba", myMap);
		Location l25 	= new Location(Utility.generateGUID(), "l25", "KSI", myMap);
		Location l26 	= new Location(Utility.generateGUID(), "l26", "prùjezd", myMap);
		Location l27 	= new Location(Utility.generateGUID(), "l27", "KJ", myMap);
		Location l28 	= new Location(Utility.generateGUID(), "l28", "chodba u KJ", myMap);
		Location l29 	= new Location(Utility.generateGUID(), "l29", "chodba", myMap);
		Location l30 	= new Location(Utility.generateGUID(), "l30", "chodba", myMap);
		Location l31 	= new Location(Utility.generateGUID(), "l31", "chodba u KSI", myMap);
		Location l32 	= new Location(Utility.generateGUID(), "l32", "chodba za KJ", myMap);
		Location lr43 	= new Location(Utility.generateGUID(), "lr43", "T-010", myMap);
		Location lr44 	= new Location(Utility.generateGUID(), "lr44", "T-015", myMap);
		Location lr45 	= new Location(Utility.generateGUID(), "lr45", "T-014", myMap);
		Location lr46 	= new Location(Utility.generateGUID(), "lr46", "T-013", myMap);
		Location lr47 	= new Location(Utility.generateGUID(), "lr47", "T-012", myMap);
		Location lr48 	= new Location(Utility.generateGUID(), "lr48", "T-009", myMap);
		Location lr49 	= new Location(Utility.generateGUID(), "lr49", "T-039", myMap);
		Location lr50 	= new Location(Utility.generateGUID(), "lr50", "T-040", myMap);
		Location lr51 	= new Location(Utility.generateGUID(), "lr51", "...", myMap);
		Location lr52 	= new Location(Utility.generateGUID(), "lr52", "T-046", myMap);
		Location lr53 	= new Location(Utility.generateGUID(), "lr53", "T-062", myMap);
		Location lr54 	= new Location(Utility.generateGUID(), "lr54", "T-066", myMap);
		Location lr55 	= new Location(Utility.generateGUID(), "lr55", "T-067", myMap);
		Location lr56 	= new Location(Utility.generateGUID(), "lr56", "T-011", myMap);
		Location lr57 	= new Location(Utility.generateGUID(), "lr57", "WC", myMap);
		Location ls03 	= new Location(Utility.generateGUID(), "ls03", "schodištì", myMap);

		myMap.addLocation(l24); myMap.addLocation(l25); myMap.addLocation(l26); myMap.addLocation(l27); 
		myMap.addLocation(l28); myMap.addLocation(l29); myMap.addLocation(l30); myMap.addLocation(l31); 
		myMap.addLocation(l32); myMap.addLocation(lr43); myMap.addLocation(lr44); myMap.addLocation(lr45); 
		myMap.addLocation(lr46); myMap.addLocation(lr47); myMap.addLocation(lr48); myMap.addLocation(lr49); 
		myMap.addLocation(lr50); myMap.addLocation(lr51); myMap.addLocation(lr52); myMap.addLocation(lr53); 
		myMap.addLocation(lr54); myMap.addLocation(lr55); myMap.addLocation(lr56); myMap.addLocation(lr57); 
		myMap.addLocation(ls03); 

		GMNode s03 	= new GMNode(Utility.generateGUID(), "s03", loclist, ls03.getDescription(), myMap);
		GMNode r43 	= new GMNode(Utility.generateGUID(), "r43", loclist, ls03.getDescription(), myMap);
		GMNode r57 	= new GMNode(Utility.generateGUID(), "r57", loclist, ls03.getDescription(), myMap);
		GMNode l24l25 	= new GMNode(Utility.generateGUID(), "l24l25", loclist, "pøechod mezi " + l24.getDescription() + " a " + l25.getDescription(), myMap);
		GMNode r44 	= new GMNode(Utility.generateGUID(), "r44", loclist, lr44.getDescription(), myMap);
		GMNode r45 	= new GMNode(Utility.generateGUID(), "r45", loclist, lr45.getDescription(), myMap);
		GMNode r46 	= new GMNode(Utility.generateGUID(), "r46", loclist, lr46.getDescription(), myMap);
		GMNode r47 	= new GMNode(Utility.generateGUID(), "r47", loclist, lr47.getDescription(), myMap);
		GMNode r56 	= new GMNode(Utility.generateGUID(), "r56", loclist, lr56.getDescription(), myMap);
		GMNode r48 	= new GMNode(Utility.generateGUID(), "r48", loclist, lr48.getDescription(), myMap);
		GMNode r49 	= new GMNode(Utility.generateGUID(), "r49", loclist, lr49.getDescription(), myMap);
		GMNode r50 	= new GMNode(Utility.generateGUID(), "r50", loclist, lr50.getDescription(), myMap);
		GMNode l26l31 	= new GMNode(Utility.generateGUID(), "l26l31", loclist, "pøechod mezi " + l26.getDescription() + " a " + l31.getDescription(), myMap);
		GMNode l26l32 	= new GMNode(Utility.generateGUID(), "l26l32", loclist, "pøechod mezi " + l26.getDescription() + " a " + l32.getDescription(), myMap);
		GMNode r51 	= new GMNode(Utility.generateGUID(), "r51", loclist, lr51.getDescription(), myMap);
		GMNode r52 	= new GMNode(Utility.generateGUID(), "r52", loclist, lr52.getDescription(), myMap);
		GMNode l27l32 	= new GMNode(Utility.generateGUID(), "l27l32", loclist, "pøechod mezi " + l27.getDescription() + " a " + l32.getDescription(), myMap);
		GMNode r53 	= new GMNode(Utility.generateGUID(), "r53", loclist, lr53.getDescription(), myMap);
		GMNode r54 	= new GMNode(Utility.generateGUID(), "r54", loclist, lr54.getDescription(), myMap);
		GMNode r55 	= new GMNode(Utility.generateGUID(), "r55", loclist, lr55.getDescription(), myMap);
		GMNode l27l28 	= new GMNode(Utility.generateGUID(), "l27l28", loclist, "pøechod mezi " + l27.getDescription() + " a " + l28.getDescription(), myMap);
		GMNode l28n01 	= new GMNode(Utility.generateGUID(), "l28n01", loclist, l27.getDescription(), myMap);
		GMNode l28n02 	= new GMNode(Utility.generateGUID(), "l28n02", loclist, l27.getDescription(), myMap);
		GMNode l06l2801 	= new GMNode(Utility.generateGUID(), "l06l2801", loclist, "pøechod mezi " + l06.getDescription() + " a " + l28.getDescription(), myMap);
		GMNode l06l2802 	= new GMNode(Utility.generateGUID(), "l06l2802", loclist, "pøechod mezi " + l06.getDescription() + " a " + l28.getDescription(), myMap);
		GMNode l28l29 	= new GMNode(Utility.generateGUID(), "l28l29", loclist, "pøechod mezi " + l28.getDescription() + " a " + l29.getDescription(), myMap);

		myMap.addNode(s03); myMap.addNode(r43); myMap.addNode(r57); myMap.addNode(l24l25); 
		myMap.addNode(r44); myMap.addNode(r45); myMap.addNode(r46); myMap.addNode(r47); 
		myMap.addNode(r56); myMap.addNode(r48); myMap.addNode(r49); myMap.addNode(r50); 
		myMap.addNode(l26l31); myMap.addNode(l26l32); myMap.addNode(r51); myMap.addNode(r52); 
		myMap.addNode(l27l32); myMap.addNode(r53); myMap.addNode(r54); myMap.addNode(r55); 
		myMap.addNode(l27l28); myMap.addNode(l28n01); myMap.addNode(l28n02); myMap.addNode(l06l2801); 
		myMap.addNode(l06l2802); myMap.addNode(l28l29); 

		//lokace l24
		GMEdge l24s03r43 	= new GMEdge(Utility.generateGUID(), "l24s03r43", 	8*spd, s03, r43, new Direction(Direction.Compass.West), l24.getDescription(), myMap);
		GMEdge l24s03r57 	= new GMEdge(Utility.generateGUID(), "l24s03r57", 	8*spd, s03, r57, new Direction(Direction.Compass.Northwest), l24.getDescription(), myMap);
		GMEdge l24s03l24l25 	= new GMEdge(Utility.generateGUID(), "l24s03l24l25", 	8*spd, s03, l24l25, new Direction(Direction.Compass.South), l24.getDescription(), myMap);
		GMEdge l24r43r57 	= new GMEdge(Utility.generateGUID(), "l24r43r57", 	8*spd, r43, r57, new Direction(Direction.Compass.Northeast), l24.getDescription(), myMap);
		GMEdge l24r43l24l25 	= new GMEdge(Utility.generateGUID(), "l24r43l24l25", 	8*spd, r43, l24l25, new Direction(Direction.Compass.Southeast), l24.getDescription(), myMap);
		GMEdge l24r57l24l25 	= new GMEdge(Utility.generateGUID(), "l24r57l24l25", 	8*spd, r57, l24l25, new Direction(Direction.Compass.South), l24.getDescription(), myMap);
		GMEdge l24r43s03 	= new GMEdge(Utility.generateGUID(), "l24r43s03", 	8*spd, r43, s03, new Direction(Direction.Compass.East), l24.getDescription(), myMap);
		GMEdge l24r57s03 	= new GMEdge(Utility.generateGUID(), "l24r57s03", 	8*spd, r57, s03, new Direction(Direction.Compass.Southeast), l24.getDescription(), myMap);
		GMEdge l24l24l25s03 	= new GMEdge(Utility.generateGUID(), "l24l24l25s03", 	8*spd, l24l25, s03, new Direction(Direction.Compass.North), l24.getDescription(), myMap);
		GMEdge l24r57r43 	= new GMEdge(Utility.generateGUID(), "l24r57r43", 	8*spd, r57, r43, new Direction(Direction.Compass.Southwest), l24.getDescription(), myMap);
		GMEdge l24l24l25r43 	= new GMEdge(Utility.generateGUID(), "l24l24l25r43", 	8*spd, l24l25, r43, new Direction(Direction.Compass.Northwest), l24.getDescription(), myMap);
		GMEdge l24l24l25r57 	= new GMEdge(Utility.generateGUID(), "l24l24l25r57", 	8*spd, l24l25, r57, new Direction(Direction.Compass.North), l24.getDescription(), myMap);
		//lokace l25
		GMEdge l25l24l25r44 	= new GMEdge(Utility.generateGUID(), "l25l24l25r44", 	8*spd, l24l25, r44, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25l24l25r45 	= new GMEdge(Utility.generateGUID(), "l25l24l25r45", 	8*spd, l24l25, r45, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25l24l25r46 	= new GMEdge(Utility.generateGUID(), "l25l24l25r46", 	8*spd, l24l25, r46, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25l24l25r47 	= new GMEdge(Utility.generateGUID(), "l25l24l25r47", 	8*spd, l24l25, r47, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25l24l25r56 	= new GMEdge(Utility.generateGUID(), "l25l24l25r56", 	8*spd, l24l25, r56, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r44r45 	= new GMEdge(Utility.generateGUID(), "l25r44r45", 	8*spd, r44, r45, new Direction(Direction.Compass.Southwest), l25.getDescription(), myMap);
		GMEdge l25r44r46 	= new GMEdge(Utility.generateGUID(), "l25r44r46", 	8*spd, r44, r46, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r44r47 	= new GMEdge(Utility.generateGUID(), "l25r44r47", 	8*spd, r44, r47, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r44r56 	= new GMEdge(Utility.generateGUID(), "l25r44r56", 	8*spd, r44, r56, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r45r46 	= new GMEdge(Utility.generateGUID(), "l25r45r46", 	8*spd, r45, r46, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r45r47 	= new GMEdge(Utility.generateGUID(), "l25r45r47", 	8*spd, r45, r47, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r45r56 	= new GMEdge(Utility.generateGUID(), "l25r45r56", 	8*spd, r45, r56, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r46r47 	= new GMEdge(Utility.generateGUID(), "l25r46r47", 	8*spd, r46, r47, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r46r56 	= new GMEdge(Utility.generateGUID(), "l25r46r56", 	8*spd, r46, r56, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r47r56 	= new GMEdge(Utility.generateGUID(), "l25r47r56", 	8*spd, r47, r56, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r44l24l25 	= new GMEdge(Utility.generateGUID(), "l25r44l24l25", 	8*spd, r44, l24l25, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r45l24l25 	= new GMEdge(Utility.generateGUID(), "l25r45l24l25", 	8*spd, r45, l24l25, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r46l24l25 	= new GMEdge(Utility.generateGUID(), "l25r46l24l25", 	8*spd, r46, l24l25, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r47l24l25 	= new GMEdge(Utility.generateGUID(), "l25r47l24l25", 	8*spd, r47, l24l25, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r56l24l25 	= new GMEdge(Utility.generateGUID(), "l25r56l24l25", 	8*spd, r56, l24l25, new Direction(Direction.Compass.West), l25.getDescription(), myMap);
		GMEdge l25r45r44 	= new GMEdge(Utility.generateGUID(), "l25r45r44", 	8*spd, r45, r44, new Direction(Direction.Compass.Northeast), l25.getDescription(), myMap);
		GMEdge l25r46r44 	= new GMEdge(Utility.generateGUID(), "l25r46r44", 	8*spd, r46, r44, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r47r44 	= new GMEdge(Utility.generateGUID(), "l25r47r44", 	8*spd, r47, r44, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r56r44 	= new GMEdge(Utility.generateGUID(), "l25r56r44", 	8*spd, r56, r44, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r46r45 	= new GMEdge(Utility.generateGUID(), "l25r46r45", 	8*spd, r46, r45, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r47r45 	= new GMEdge(Utility.generateGUID(), "l25r47r45", 	8*spd, r47, r45, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r56r45 	= new GMEdge(Utility.generateGUID(), "l25r56r45", 	8*spd, r56, r45, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r47r46 	= new GMEdge(Utility.generateGUID(), "l25r47r46", 	8*spd, r47, r46, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r56r46 	= new GMEdge(Utility.generateGUID(), "l25r56r46", 	8*spd, r56, r46, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		GMEdge l25r56r47 	= new GMEdge(Utility.generateGUID(), "l25r56r47", 	8*spd, r56, r47, new Direction(Direction.Compass.East), l25.getDescription(), myMap);
		//lokace l26
		GMEdge l26l26l31l26l32 	= new GMEdge(Utility.generateGUID(), "l26l26l31l26l32", 	8*spd, l26l31, l26l32, new Direction(Direction.Compass.South), l26.getDescription(), myMap);
		GMEdge l26l26l32l26l31 	= new GMEdge(Utility.generateGUID(), "l26l26l32l26l31", 	8*spd, l26l32, l26l31, new Direction(Direction.Compass.North), l26.getDescription(), myMap); 
		//lokace l27
		GMEdge l27l27l32r53 	= new GMEdge(Utility.generateGUID(), "l27l27l32r53", 	8*spd, l27l32, r53, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27l27l32r54 	= new GMEdge(Utility.generateGUID(), "l27l27l32r54", 	8*spd, l27l32, r54, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27l27l32r55 	= new GMEdge(Utility.generateGUID(), "l27l27l32r55", 	8*spd, l27l32, r55, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27l27l32l27l28 	= new GMEdge(Utility.generateGUID(), "l27l27l32l27l28", 	8*spd, l27l32, l27l28, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27r53r54 	= new GMEdge(Utility.generateGUID(), "l27r53r54", 	8*spd, r53, r54, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27r53r55 	= new GMEdge(Utility.generateGUID(), "l27r53r55", 	8*spd, r53, r55, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27r53l27l28 	= new GMEdge(Utility.generateGUID(), "l27r53l27l28", 	8*spd, r53, l27l28, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27r54r55 	= new GMEdge(Utility.generateGUID(), "l27r54r55", 	8*spd, r54, r55, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27r54l27l28 	= new GMEdge(Utility.generateGUID(), "l27r54l27l28", 	8*spd, r54, l27l28, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27r55l27l28 	= new GMEdge(Utility.generateGUID(), "l27r55l27l28", 	8*spd, r55, l27l28, new Direction(Direction.Compass.East), l27.getDescription(), myMap); 
		GMEdge l27r53l27l32 	= new GMEdge(Utility.generateGUID(), "l27r53l27l32", 	8*spd, r53, l27l32, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27r54l27l32 	= new GMEdge(Utility.generateGUID(), "l27r54l27l32", 	8*spd, r54, l27l32, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27r55l27l32 	= new GMEdge(Utility.generateGUID(), "l27r55l27l32", 	8*spd, r55, l27l32, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27l27l28l27l32 	= new GMEdge(Utility.generateGUID(), "l27l27l28l27l32", 	8*spd, l27l28, l27l32, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27r54r53 	= new GMEdge(Utility.generateGUID(), "l27r54r53", 	8*spd, r54, r53, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27r55r53 	= new GMEdge(Utility.generateGUID(), "l27r55r53", 	8*spd, r55, r53, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27l27l28r53 	= new GMEdge(Utility.generateGUID(), "l27l27l28r53", 	8*spd, l27l28, r53, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27r55r54 	= new GMEdge(Utility.generateGUID(), "l27r55r54", 	8*spd, r55, r54, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27l27l28r54 	= new GMEdge(Utility.generateGUID(), "l27l27l28r54", 	8*spd, l27l28, r54, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		GMEdge l27l27l28r55 	= new GMEdge(Utility.generateGUID(), "l27l27l28r55", 	8*spd, l27l28, r55, new Direction(Direction.Compass.West), l27.getDescription(), myMap); 
		//lokace l28
		GMEdge l28l27l28l28n01 	= new GMEdge(Utility.generateGUID(), "l28l27l28l28n01", 	8*spd, l27l28, l28n01, new Direction(Direction.Compass.North), l28.getDescription(), myMap); 
		GMEdge l28l27l28l06l2801 	= new GMEdge(Utility.generateGUID(), "l28l27l28l06l2801", 	8*spd, l27l28, l06l2801, new Direction(Direction.Compass.East), l28.getDescription(), myMap); 
		GMEdge l28l28n01l06l2801 	= new GMEdge(Utility.generateGUID(), "l28l28n01l06l2801", 	8*spd, l28n01, l06l2801, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l28n01l28n02 	= new GMEdge(Utility.generateGUID(), "l28l28n01l28n02", 	8*spd, l28n01, l28n02, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l28n02l06l2802 	= new GMEdge(Utility.generateGUID(), "l28l28n02l06l2802", 	8*spd, l28n02, l06l2802, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l28n02l28l29 	= new GMEdge(Utility.generateGUID(), "l28l28n02l28l29", 	8*spd, l28n02, l28l29, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l06l2802l28l29 	= new GMEdge(Utility.generateGUID(), "l28l06l2802l28l29", 	8*spd, l06l2802, l28l29, new Direction(Direction.Compass.East), l28.getDescription(), myMap); 
		GMEdge l28l28n01l27l28 	= new GMEdge(Utility.generateGUID(), "l28l28n01l27l28", 	8*spd, l28n01, l27l28, new Direction(Direction.Compass.North), l28.getDescription(), myMap); 
		GMEdge l28l06l2801l27l28 	= new GMEdge(Utility.generateGUID(), "l28l06l2801l27l28", 	8*spd, l06l2801, l27l28, new Direction(Direction.Compass.East), l28.getDescription(), myMap); 
		GMEdge l28l06l2801l28n01 	= new GMEdge(Utility.generateGUID(), "l28l06l2801l28n01", 	8*spd, l06l2801, l28n01, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l28n02l28n01 	= new GMEdge(Utility.generateGUID(), "l28l28n02l28n01", 	8*spd, l28n02, l28n01, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l06l2802l28n02 	= new GMEdge(Utility.generateGUID(), "l28l06l2802l28n02", 	8*spd, l06l2802, l28n02, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l28l29l28n02 	= new GMEdge(Utility.generateGUID(), "l28l28l29l28n02", 	8*spd, l28l29, l28n02, new Direction(Direction.Compass.South), l28.getDescription(), myMap); 
		GMEdge l28l28l29l06l2802 	= new GMEdge(Utility.generateGUID(), "l28l28l29l06l2802", 	8*spd, l28l29, l06l2802, new Direction(Direction.Compass.East), l28.getDescription(), myMap); 
		//lokace l31
		GMEdge l31r48l24l25 	= new GMEdge(Utility.generateGUID(), "l31r48l24l25", 	8*spd, r48, l24l25, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31r49l24l25 	= new GMEdge(Utility.generateGUID(), "l31r49l24l25", 	8*spd, r49, l24l25, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31r50l24l25 	= new GMEdge(Utility.generateGUID(), "l31r50l24l25", 	8*spd, r50, l24l25, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31l26l31l24l25 	= new GMEdge(Utility.generateGUID(), "l31l26l31l24l25", 	8*spd, l26l31, l24l25, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31r49r48 	= new GMEdge(Utility.generateGUID(), "l31r49r48", 	8*spd, r49, r48, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31r50r48 	= new GMEdge(Utility.generateGUID(), "l31r50r48", 	8*spd, r50, r48, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31l26l31r48 	= new GMEdge(Utility.generateGUID(), "l31l26l31r48", 	8*spd, l26l31, r48, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31r50r49 	= new GMEdge(Utility.generateGUID(), "l31r50r49", 	8*spd, r50, r49, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31l26l31r49 	= new GMEdge(Utility.generateGUID(), "l31l26l31r49", 	8*spd, l26l31, r49, new Direction(Direction.Compass.South), l31.getDescription(), myMap);
		GMEdge l31l26l31r50 	= new GMEdge(Utility.generateGUID(), "l31l26l31r50", 	8*spd, l26l31, r50, new Direction(Direction.Compass.Southwest), l31.getDescription(), myMap); 
		GMEdge l31l24l25r48 	= new GMEdge(Utility.generateGUID(), "l31r48l24l25", 	8*spd, l24l25, r48, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31l24l25r49 	= new GMEdge(Utility.generateGUID(), "l31r49l24l25", 	8*spd, l24l25, r49, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31l24l25r50 	= new GMEdge(Utility.generateGUID(), "l31r50l24l25", 	8*spd, l24l25, r50, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31l24l25l26l31 	= new GMEdge(Utility.generateGUID(), "l31l26l31l24l25", 	8*spd, l24l25, l26l31, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31r48r49 	= new GMEdge(Utility.generateGUID(), "l31r49r48", 	8*spd, r48, r49, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31r48r50 	= new GMEdge(Utility.generateGUID(), "l31r50r48", 	8*spd, r48, r50, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31r48l26l31 	= new GMEdge(Utility.generateGUID(), "l31l26l31r48", 	8*spd, r48, l26l31, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31r49r50 	= new GMEdge(Utility.generateGUID(), "l31r50r49", 	8*spd, r49, r50, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31r49l26l31 	= new GMEdge(Utility.generateGUID(), "l31l26l31r49", 	8*spd, r49, l26l31, new Direction(Direction.Compass.North), l31.getDescription(), myMap);
		GMEdge l31r50l26l31 	= new GMEdge(Utility.generateGUID(), "l31l26l31r50", 	8*spd, r50, l26l31, new Direction(Direction.Compass.Northeast), l31.getDescription(), myMap);
		//lokace l32
		GMEdge l32l26l32r51 	= new GMEdge(Utility.generateGUID(), "l32l26l32r51", 	8*spd, l26l32, r51, new Direction(Direction.Compass.South), l32.getDescription(), myMap);
		GMEdge l32l26l32r52 	= new GMEdge(Utility.generateGUID(), "l32l26l32r52", 	8*spd, l26l32, r52, new Direction(Direction.Compass.South), l32.getDescription(), myMap);
		GMEdge l32l26l32l27l32 	= new GMEdge(Utility.generateGUID(), "l32l26l32l27l32", 	8*spd, l26l32, l27l32, new Direction(Direction.Compass.South), l32.getDescription(), myMap);
		GMEdge l32r51r52 	= new GMEdge(Utility.generateGUID(), "l32r51r52", 	8*spd, r51, r52, new Direction(Direction.Compass.South), l32.getDescription(), myMap);
		GMEdge l32r51l27l32 	= new GMEdge(Utility.generateGUID(), "l32r51l27l32", 	8*spd, r51, l27l32, new Direction(Direction.Compass.South), l32.getDescription(), myMap);
		GMEdge l32r52l27l32 	= new GMEdge(Utility.generateGUID(), "l32r52l27l32", 	8*spd, r52, l27l32, new Direction(Direction.Compass.East), l32.getDescription(), myMap);
		GMEdge l32r51l26l32 	= new GMEdge(Utility.generateGUID(), "l32r51l26l32", 	8*spd, r51, l26l32, new Direction(Direction.Compass.North), l32.getDescription(), myMap);
		GMEdge l32r52l26l32 	= new GMEdge(Utility.generateGUID(), "l32r52l26l32", 	8*spd, r52, l26l32, new Direction(Direction.Compass.North), l32.getDescription(), myMap);
		GMEdge l32l27l32l26l32 	= new GMEdge(Utility.generateGUID(), "l32l27l32l26l32", 	8*spd, l27l32, l26l32, new Direction(Direction.Compass.North), l32.getDescription(), myMap);
		GMEdge l32r52r51 	= new GMEdge(Utility.generateGUID(), "l32r52r51", 	8*spd, r52, r51, new Direction(Direction.Compass.North), l32.getDescription(), myMap);
		GMEdge l32l27l32r51 	= new GMEdge(Utility.generateGUID(), "l32l27l32r51", 	8*spd, l27l32, r51, new Direction(Direction.Compass.North), l32.getDescription(), myMap);
		GMEdge l32l27l32r52 	= new GMEdge(Utility.generateGUID(), "l32l27l32r52", 	8*spd, l27l32, r52, new Direction(Direction.Compass.West), l32.getDescription(), myMap);

		//lokace l24
		myMap.addEdge(l24s03r43); myMap.addEdge(l24s03r57); myMap.addEdge(l24s03l24l25); myMap.addEdge(l24r43r57); 
		myMap.addEdge(l24r43l24l25); myMap.addEdge(l24r57l24l25); myMap.addEdge(l24r43s03); myMap.addEdge(l24r57s03); 
		myMap.addEdge(l24l24l25s03); myMap.addEdge(l24r57r43); myMap.addEdge(l24l24l25r43); myMap.addEdge(l24l24l25r57); 
		//lokace l25
		myMap.addEdge(l25l24l25r44); myMap.addEdge(l25l24l25r45); myMap.addEdge(l25l24l25r46); myMap.addEdge(l25l24l25r47); 
		myMap.addEdge(l25l24l25r56); myMap.addEdge(l25r44r45); myMap.addEdge(l25r44r46); myMap.addEdge(l25r44r47); 
		myMap.addEdge(l25r44r56); myMap.addEdge(l25r45r46); myMap.addEdge(l25r45r47); myMap.addEdge(l25r45r56); 
		myMap.addEdge(l25r46r47); myMap.addEdge(l25r46r56); myMap.addEdge(l25r47r56); myMap.addEdge(l25r44l24l25); 
		myMap.addEdge(l25r45l24l25); myMap.addEdge(l25r46l24l25); myMap.addEdge(l25r47l24l25); myMap.addEdge(l25r56l24l25); 
		myMap.addEdge(l25r45r44); myMap.addEdge(l25r46r44); myMap.addEdge(l25r47r44); myMap.addEdge(l25r56r44); 
		myMap.addEdge(l25r46r45); myMap.addEdge(l25r47r45); myMap.addEdge(l25r56r45); myMap.addEdge(l25r47r46); 
		myMap.addEdge(l25r56r46); myMap.addEdge(l25r56r47); 
		//lokace l26
		myMap.addEdge(l26l26l31l26l32); myMap.addEdge(l26l26l32l26l31); 
		//lokace l27
		myMap.addEdge(l27l27l32r53); myMap.addEdge(l27l27l32r54); myMap.addEdge(l27l27l32r55); myMap.addEdge(l27l27l32l27l28); 
		myMap.addEdge(l27r53r54); myMap.addEdge(l27r53r55); myMap.addEdge(l27r53l27l28); myMap.addEdge(l27r54r55); 
		myMap.addEdge(l27r54l27l28); myMap.addEdge(l27r55l27l28); myMap.addEdge(l27r53l27l32); myMap.addEdge(l27r54l27l32); 
		myMap.addEdge(l27r55l27l32); myMap.addEdge(l27l27l28l27l32); myMap.addEdge(l27r54r53); myMap.addEdge(l27r55r53); 
		myMap.addEdge(l27l27l28r53); myMap.addEdge(l27r55r54); myMap.addEdge(l27l27l28r54); myMap.addEdge(l27l27l28r55); 
		//lokace l28 
		myMap.addEdge(l28l27l28l28n01) ; myMap.addEdge(l28l27l28l06l2801); myMap.addEdge(l28l28n01l06l2801); myMap.addEdge(l28l28n01l28n02) ; 
		myMap.addEdge(l28l28n02l06l2802); myMap.addEdge(l28l28n02l28l29) ; myMap.addEdge(l28l06l2802l28l29); myMap.addEdge(l28l28n01l27l28); 
		myMap.addEdge(l28l06l2801l27l28); myMap.addEdge(l28l06l2801l28n01); myMap.addEdge(l28l28n02l28n01); myMap.addEdge(l28l06l2802l28n02); 
		myMap.addEdge(l28l28l29l28n02); myMap.addEdge(l28l28l29l06l2802); 
		//lokace l31
		myMap.addEdge(l31r48l24l25); myMap.addEdge(l31r49l24l25); myMap.addEdge(l31r50l24l25); myMap.addEdge(l31l26l31l24l25); 
		myMap.addEdge(l31r49r48); myMap.addEdge(l31r50r48); myMap.addEdge(l31l26l31r48); myMap.addEdge(l31r50r49); 
		myMap.addEdge(l31l26l31r49); myMap.addEdge(l31l26l31r50); myMap.addEdge(l31l24l25r48); myMap.addEdge(l31l24l25r49); 
		myMap.addEdge(l31l24l25r50); myMap.addEdge(l31l24l25l26l31); myMap.addEdge(l31r48r49); myMap.addEdge(l31r48r50); 
		myMap.addEdge(l31r48l26l31); myMap.addEdge(l31r49r50); myMap.addEdge(l31r49l26l31); myMap.addEdge(l31r50l26l31); 
		//lokace l32
		myMap.addEdge(l32l26l32r51); myMap.addEdge(l32l26l32r52); myMap.addEdge(l32l26l32l27l32); myMap.addEdge(l32r51r52); 
		myMap.addEdge(l32r51l27l32); myMap.addEdge(l32r52l27l32); myMap.addEdge(l32r51l26l32); myMap.addEdge(l32r52l26l32); 
		myMap.addEdge(l32l27l32l26l32); myMap.addEdge(l32r52r51); myMap.addEdge(l32l27l32r51); myMap.addEdge(l32l27l32r52); 

		// 3. patro
		Location l33 	= new Location(Utility.generateGUID(), "l33", "chodba", myMap);
		Location lr58 	= new Location(Utility.generateGUID(), "lr58", "KIPl", myMap);
		Location lr59 	= new Location(Utility.generateGUID(), "lr59", "KMAT", myMap);
		Location lr60 	= new Location(Utility.generateGUID(), "lr60", "T-302", myMap);
		Location lr61 	= new Location(Utility.generateGUID(), "lr61", "T-301", myMap);
		Location lr62 	= new Location(Utility.generateGUID(), "lr62", "WC", myMap);
		Location lr63 	= new Location(Utility.generateGUID(), "lr63", "WC", myMap);

		myMap.addLocation(l33); myMap.addLocation(lr58); myMap.addLocation(lr59); myMap.addLocation(lr60); 
		myMap.addLocation(lr61); myMap.addLocation(lr62); myMap.addLocation(lr63); 

		GMNode r58 	= new GMNode(Utility.generateGUID(), "r58", loclist, lr58.getDescription(), myMap);
		GMNode r59 	= new GMNode(Utility.generateGUID(), "r59", loclist, lr59.getDescription(), myMap);
		GMNode r60 	= new GMNode(Utility.generateGUID(), "r60", loclist, lr60.getDescription(), myMap);
		GMNode r61 	= new GMNode(Utility.generateGUID(), "r61", loclist, lr61.getDescription(), myMap);
		GMNode r62 	= new GMNode(Utility.generateGUID(), "r62", loclist, lr62.getDescription(), myMap);
		GMNode r63 	= new GMNode(Utility.generateGUID(), "r63", loclist, lr63.getDescription(), myMap);
		GMNode l33n01 	= new GMNode(Utility.generateGUID(), "l33n01", loclist, l33.getDescription(), myMap);
		GMNode l33n02 	= new GMNode(Utility.generateGUID(), "l33n02", loclist, l33.getDescription(), myMap); 

		myMap.addNode(r58); myMap.addNode(r59); myMap.addNode(r60); myMap.addNode(r61); 
		myMap.addNode(r62); myMap.addNode(r63); myMap.addNode(l33n01); myMap.addNode(l33n02); 

		GMEdge l33r62r58 	= new GMEdge(Utility.generateGUID(), "l33r62r58", 	8*spd, r62, r58, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33r63r58 	= new GMEdge(Utility.generateGUID(), "l33r63r58", 	8*spd, r63, r58, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33l33n01r58 	= new GMEdge(Utility.generateGUID(), "l33l33n01r58", 	8*spd, l33n01, r58, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33r63r62 	= new GMEdge(Utility.generateGUID(), "l33r63r62", 	8*spd, r63, r62, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33l33n01r62 	= new GMEdge(Utility.generateGUID(), "l33l33n01r62", 	8*spd, l33n01, r62, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33l33n01r63 	= new GMEdge(Utility.generateGUID(), "l33l33n01r63", 	8*spd, l33n01, r63, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33r60l33n01 	= new GMEdge(Utility.generateGUID(), "l33r60l33n01", 	8*spd, r60, l33n01, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33r61l33n01 	= new GMEdge(Utility.generateGUID(), "l33r61l33n01", 	8*spd, r61, l33n01, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33l33n02l33n01 	= new GMEdge(Utility.generateGUID(), "l33l33n02l33n01", 	8*spd, l33n02, l33n01, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33r61r60 	= new GMEdge(Utility.generateGUID(), "l33r61r60", 	8*spd, r61, r60, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33l33n02r60 	= new GMEdge(Utility.generateGUID(), "l33l33n02r60", 	8*spd, l33n02, r60, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33l33n02r61 	= new GMEdge(Utility.generateGUID(), "l33l33n02r61", 	8*spd, l33n02, r61, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33r59l33n02 	= new GMEdge(Utility.generateGUID(), "l33r59l33n02", 	8*spd, r59, l33n02, new Direction(Direction.Compass.North), l33.getDescription(), myMap); 
		GMEdge l33r58r62 	= new GMEdge(Utility.generateGUID(), "l33r58r62", 	8*spd, r58, r62, new Direction(Direction.Compass.North), l33.getDescription(), myMap);
		GMEdge l33r58r63 	= new GMEdge(Utility.generateGUID(), "l33r58r63", 	8*spd, r58, r63, new Direction(Direction.Compass.North), l33.getDescription(), myMap);
		GMEdge l33r58l33n01 	= new GMEdge(Utility.generateGUID(), "l33r58l33n01", 	8*spd, r58, l33n01, new Direction(Direction.Compass.North), l33.getDescription(), myMap);
		GMEdge l33r62r63 	= new GMEdge(Utility.generateGUID(), "l33r62r63", 	8*spd, r62, r63, new Direction(Direction.Compass.North), l33.getDescription(), myMap);
		GMEdge l33r62l33n01 	= new GMEdge(Utility.generateGUID(), "l33r62l33n01", 	8*spd, r62, l33n01, new Direction(Direction.Compass.North), l33.getDescription(), myMap);
		GMEdge l33r63l33n01 	= new GMEdge(Utility.generateGUID(), "l33r63l33n01", 	8*spd, r63, l33n01, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33n01r60 	= new GMEdge(Utility.generateGUID(), "l33l33n01r60", 	8*spd, l33n01, r60, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33n01r61 	= new GMEdge(Utility.generateGUID(), "l33l33n01r61", 	8*spd, l33n01, r61, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33n01l33n02 	= new GMEdge(Utility.generateGUID(), "l33l33n01l33n02", 	8*spd, l33n01, l33n02, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33r60r61 	= new GMEdge(Utility.generateGUID(), "l33r60r61", 	8*spd, r60, r61, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33r60l33n02 	= new GMEdge(Utility.generateGUID(), "l33r60l33n02", 	8*spd, r60, l33n02, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33r61l33n02 	= new GMEdge(Utility.generateGUID(), "l33r61l33n02", 	8*spd, r61, l33n02, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33n02r59 	= new GMEdge(Utility.generateGUID(), "l33l33n02r59", 	8*spd, l33n02, r59, new Direction(Direction.Compass.South), l33.getDescription(), myMap);

		myMap.addEdge(l33r62r58); myMap.addEdge(l33r63r58); myMap.addEdge(l33l33n01r58); myMap.addEdge(l33r63r62); 
		myMap.addEdge(l33l33n01r62); myMap.addEdge(l33l33n01r63); myMap.addEdge(l33r60l33n01); myMap.addEdge(l33r61l33n01); 
		myMap.addEdge(l33l33n02l33n01); myMap.addEdge(l33r61r60); myMap.addEdge(l33l33n02r60); myMap.addEdge(l33l33n02r61); 
		myMap.addEdge(l33r59l33n02); myMap.addEdge(l33r58r62); myMap.addEdge(l33r58r63); myMap.addEdge(l33r58l33n01); 
		myMap.addEdge(l33r62r63); myMap.addEdge(l33r62l33n01); myMap.addEdge(l33r63l33n01); myMap.addEdge(l33l33n01r60); 
		myMap.addEdge(l33l33n01r61); myMap.addEdge(l33l33n01l33n02); myMap.addEdge(l33r60r61); myMap.addEdge(l33r60l33n02); 
		myMap.addEdge(l33r61l33n02); myMap.addEdge(l33l33n02r59); 



		//schodištì mezi 2. a 3. patrem
		Location l34 	= new Location(Utility.generateGUID(), "l34", "schodištì", myMap);
		Location l36 	= new Location(Utility.generateGUID(), "l36", "schodištì", myMap);
		Location l37 	= new Location(Utility.generateGUID(), "l37", "chodba pøed T-201", myMap);
		Location lr64 	= new Location(Utility.generateGUID(), "lr64", "T-201", myMap);
		myMap.addLocation(l34); myMap.addLocation(l36); myMap.addLocation(l37); 
		myMap.addLocation(lr64); 

		//GMNode l18l35 	= new GMNode(Utility.generateGUID(), "l18l35", loclist, "pøechod mezi " + l18.getDescription() + " a " + l35.getDescription(), myMap);
		GMNode l35l37 	= new GMNode(Utility.generateGUID(), "l35l37", loclist, "pøechod mezi " + l35.getDescription() + " a " + l37.getDescription(), myMap);
		GMNode l33l34 	= new GMNode(Utility.generateGUID(), "l33l34", loclist, "pøechod mezi " + l33.getDescription() + " a " + l34.getDescription(), myMap);
		GMNode l33l36 	= new GMNode(Utility.generateGUID(), "l33l36", loclist, "pøechod mezi " + l33.getDescription() + " a " + l36.getDescription(), myMap);
		GMNode r64 	= new GMNode(Utility.generateGUID(), "r64", loclist, lr64.getDescription(), myMap);
		/* myMap.addNode(l18l35); */myMap.addNode(l35l37); myMap.addNode(l33l34); myMap.addNode(l33l36); 
		myMap.addNode(r64); 

		GMEdge l34l33l34l35l37 	= new GMEdge(Utility.generateGUID(), "l34l33l34l35l37", 	8*spd, l33l34, l35l37, new Direction(Direction.Compass.Northeast, Direction.Vertical.Downwards), l34.getDescription(), myMap);
		GMEdge l35l18l35l35l37 	= new GMEdge(Utility.generateGUID(), "l35l18l35l35l37", 	8*spd, l18l35, l35l37, new Direction(Direction.Compass.North, Direction.Vertical.Upwards), l35.getDescription(), myMap);
		GMEdge l36l33l36l35l37 	= new GMEdge(Utility.generateGUID(), "l36l33l36l35l37", 	8*spd, l33l36, l35l37, new Direction(Direction.Compass.Northwest, Direction.Vertical.Downwards), l36.getDescription(), myMap);
		GMEdge l37l35l37r64 	= new GMEdge(Utility.generateGUID(), "l37l35l37r64", 	8*spd, l35l37, r64, new Direction(Direction.Compass.Northwest), l37.getDescription(), myMap); 
		GMEdge l34l35l37l33l34 	= new GMEdge(Utility.generateGUID(), "l34l35l37l33l34", 	8*spd, l35l37, l33l34, new Direction(Direction.Compass.Southwest, Direction.Vertical.Upwards), l34.getDescription(), myMap);
		GMEdge l35l35l37l18l35 	= new GMEdge(Utility.generateGUID(), "l35l35l37l18l35", 	8*spd, l35l37, l18l35, new Direction(Direction.Compass.South, Direction.Vertical.Downwards), l35.getDescription(), myMap);
		GMEdge l36l35l37l33l36 	= new GMEdge(Utility.generateGUID(), "l36l35l37l33l36", 	8*spd, l35l37, l33l36, new Direction(Direction.Compass.Southeast, Direction.Vertical.Upwards), l36.getDescription(), myMap);
		GMEdge l37r64l35l37 	= new GMEdge(Utility.generateGUID(), "l37r64l35l37", 	8*spd, r64, l35l37, new Direction(Direction.Compass.Southeast), l37.getDescription(), myMap);
		myMap.addEdge(l34l33l34l35l37); myMap.addEdge(l35l18l35l35l37); myMap.addEdge(l36l33l36l35l37); myMap.addEdge(l37l35l37r64);
		myMap.addEdge(l34l35l37l33l34); myMap.addEdge(l35l35l37l18l35); myMap.addEdge(l36l35l37l33l36); myMap.addEdge(l37r64l35l37);

		//3. patro doplnìní schodištì 
		GMEdge l33l33l34l33n01 	= new GMEdge(Utility.generateGUID(), "l33l33l34l33n01", 	8*spd, l33l34, l33n01, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33l33l34r60 	= new GMEdge(Utility.generateGUID(), "l33l33l34r60", 	8*spd, l33l34, r60, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33l33l34r61 	= new GMEdge(Utility.generateGUID(), "l33l33l34r61", 	8*spd, l33l34, r61, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33l33l34l33n02 	= new GMEdge(Utility.generateGUID(), "l33l33l34l33n02", 	8*spd, l33l34, l33n02, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33l36l33n01 	= new GMEdge(Utility.generateGUID(), "l33l33l36l33n01", 	8*spd, l33l36, l33n01, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33l33l36r60 	= new GMEdge(Utility.generateGUID(), "l33l33l36r60", 	8*spd, l33l36, r60, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33l33l36r61 	= new GMEdge(Utility.generateGUID(), "l33l33l36r61", 	8*spd, l33l36, r61, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33l36l33n02 	= new GMEdge(Utility.generateGUID(), "l33l33l36l33n02", 	8*spd, l33l36, l33n02, new Direction(Direction.Compass.West), l33.getDescription(), myMap); 
		GMEdge l33l33n01l33l34 	= new GMEdge(Utility.generateGUID(), "l33l33n01l33l34", 	8*spd, l33n01, l33l34, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33r60l33l34 	= new GMEdge(Utility.generateGUID(), "l33r60l33l34", 	8*spd, r60, l33l34, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33r61l33l34 	= new GMEdge(Utility.generateGUID(), "l33r61l33l34", 	8*spd, r61, l33l34, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33l33n02l33l34 	= new GMEdge(Utility.generateGUID(), "l33l33n02l33l34", 	8*spd, l33n02, l33l34, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33n01l33l36 	= new GMEdge(Utility.generateGUID(), "l33l33n01l33l36", 	8*spd, l33n01, l33l36, new Direction(Direction.Compass.East), l33.getDescription(), myMap);
		GMEdge l33r60l33l36 	= new GMEdge(Utility.generateGUID(), "l33r60l33l36", 	8*spd, r60, l33l36, new Direction(Direction.Compass.South), l33.getDescription(), myMap);
		GMEdge l33r61l33l36 	= new GMEdge(Utility.generateGUID(), "l33r61l33l36", 	8*spd, r61, l33l36, new Direction(Direction.Compass.West), l33.getDescription(), myMap);
		GMEdge l33l33n02l33l36 	= new GMEdge(Utility.generateGUID(), "l33l33n02l33l36", 	8*spd, l33n02, l33l36, new Direction(Direction.Compass.West), l33.getDescription(), myMap);

		myMap.addEdge(l33l33l34l33n01); myMap.addEdge(l33l33l34r60); myMap.addEdge(l33l33l34r61); myMap.addEdge(l33l33l34l33n02); 
		myMap.addEdge(l33l33l36l33n01); myMap.addEdge(l33l33l36r60); myMap.addEdge(l33l33l36r61); myMap.addEdge(l33l33l36l33n02); 
		myMap.addEdge(l33l33n01l33l34); myMap.addEdge(l33r60l33l34); myMap.addEdge(l33r61l33l34); myMap.addEdge(l33l33n02l33l34); 
		myMap.addEdge(l33l33n01l33l36); myMap.addEdge(l33r60l33l36); myMap.addEdge(l33r61l33l36); myMap.addEdge(l33l33n02l33l36); 

		//propojení severozápadního schodištì
		GMNode ns01s02 	= new GMNode(Utility.generateGUID(), "ns01s02", loclist, l01.getDescription(), myMap);
		GMNode ns02s03 	= new GMNode(Utility.generateGUID(), "ns02s03", loclist, ls02.getDescription(), myMap);
		myMap.addNode(ns01s02); myMap.addNode(ns02s03); 

		GMEdge es01s021 	= new GMEdge(Utility.generateGUID(), "es01s021", 	8*spd, s01, ns01s02, new Direction(Direction.Compass.East, Direction.Vertical.Upwards), l01.getDescription(), myMap);
		GMEdge es01s022 	= new GMEdge(Utility.generateGUID(), "es01s022", 	8*spd, ns01s02, s02, new Direction(Direction.Compass.West, Direction.Vertical.Upwards), l01.getDescription(), myMap);
		GMEdge es02s031 	= new GMEdge(Utility.generateGUID(), "es02s031", 	8*spd, s02, ns02s03, new Direction(Direction.Compass.East, Direction.Vertical.Upwards), ls02.getDescription(), myMap);
		GMEdge es02s032 	= new GMEdge(Utility.generateGUID(), "es02s032", 	8*spd, ns02s03, s03, new Direction(Direction.Compass.West, Direction.Vertical.Upwards), ls02.getDescription(), myMap); 
		GMEdge es02s011 	= new GMEdge(Utility.generateGUID(), "es01s021", 	8*spd, ns01s02, s01, new Direction(Direction.Compass.East, Direction.Vertical.Downwards), l01.getDescription(), myMap);
		GMEdge es02s012 	= new GMEdge(Utility.generateGUID(), "es01s022", 	8*spd, s02, ns01s02, new Direction(Direction.Compass.West, Direction.Vertical.Downwards), l01.getDescription(), myMap);
		GMEdge es03s021 	= new GMEdge(Utility.generateGUID(), "es02s031", 	8*spd, ns02s03, s02, new Direction(Direction.Compass.East, Direction.Vertical.Downwards), ls02.getDescription(), myMap);
		GMEdge es03s022 	= new GMEdge(Utility.generateGUID(), "es02s032", 	8*spd, s03, ns02s03, new Direction(Direction.Compass.West, Direction.Vertical.Downwards), ls02.getDescription(), myMap);
		myMap.addEdge(es01s021); myMap.addEdge(es01s022); myMap.addEdge(es02s031); myMap.addEdge(es02s032); 
		myMap.addEdge(es02s011); myMap.addEdge(es02s012); myMap.addEdge(es03s021); myMap.addEdge(es03s022); 

		GMEdge l06l06l2801r14 	= new GMEdge(Utility.generateGUID(), "l06l06l2801r14", 	8*spd, l06l2801, r14, new Direction(Direction.Compass.East), l06.getDescription(), myMap);
		GMEdge l06l06l2801l06l08	= new GMEdge(Utility.generateGUID(), "l06l06l2801l06l08", 	8*spd, l06l2801, l06l08, new Direction(Direction.Compass.Northeast, Direction.Vertical.Upwards), l06.getDescription(), myMap);
		GMEdge l06l06l2801l06l2802 	= new GMEdge(Utility.generateGUID(), "l06l06l2801l06l2802", 	8*spd, l06l2801, l06l2802, new Direction(Direction.Compass.East), l06.getDescription(), myMap);
		GMEdge l06r14l06l2802	= new GMEdge(Utility.generateGUID(), "l06r14l06l2802", 	8*spd, r14, l06l2802, new Direction(Direction.Compass.East), l06.getDescription(), myMap);
		GMEdge l06l06l2802l06l08 	= new GMEdge(Utility.generateGUID(), "l06l06l2802l06l08", 	8*spd, l06l2802, l06l08, new Direction(Direction.Compass.Northwest, Direction.Vertical.Upwards), l06.getDescription(), myMap);		
		GMEdge l06r14l06l2801	= new GMEdge(Utility.generateGUID(), "l06r14l06l2801", 	8*spd, r14, l06l2801, new Direction(Direction.Compass.West), l06.getDescription(), myMap);
		GMEdge l06l06l08l06l2801  	= new GMEdge(Utility.generateGUID(), "l06l06l08l06l2801", 	8*spd, l06l08, l06l2801, new Direction(Direction.Compass.Southwest, Direction.Vertical.Downwards), l06.getDescription(), myMap);
		GMEdge l06l06l2802l06l2801 	= new GMEdge(Utility.generateGUID(), "l06l06l2802l06l2801", 	8*spd, l06l2802, l06l2801, new Direction(Direction.Compass.West), l06.getDescription(), myMap);
		GMEdge l06l06l2802r14 	= new GMEdge(Utility.generateGUID(), "l06l06l2802r14", 	8*spd, l06l2802, r14, new Direction(Direction.Compass.West), l06.getDescription(), myMap);
		GMEdge l06l06l08l06l2802 	= new GMEdge(Utility.generateGUID(), "l06l06l08l06l2802", 	8*spd, l06l08, l06l2802, new Direction(Direction.Compass.Southeast, Direction.Vertical.Downwards), l06.getDescription(), myMap);		
		myMap.addEdge(l06l06l2801r14); myMap.addEdge(l06l06l2801l06l08); myMap.addEdge(l06l06l2801l06l2802); myMap.addEdge(l06r14l06l2802); 
		myMap.addEdge(l06l06l2802l06l08); myMap.addEdge(l06r14l06l2801); myMap.addEdge(l06l06l08l06l2801); myMap.addEdge(l06l06l2802l06l2801); 
		myMap.addEdge(l06l06l2802r14); myMap.addEdge(l06l06l08l06l2802); 
				
		return myMap;
	}
	
	/**
	 * Exports Trojanka map to XML on drive C.
	 */
	public static void exportTrojankaToXML()
	{
		GMMap test = Trojanka(Utility.generateGUID(), Utility.generateGUID());
		String myXML = test.exportXML().toString();
		test.exportXML(new File("C:\\Trojanka.xml"));
		
		
	}
	
	public static void main(String... args)
	{
		exportTrojankaToXML();
	}
}