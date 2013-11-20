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
		int timeCard = 
		GMMap myMap = new GMMap();
		myMap.setAuthorName("KBen");
		myMap.setAuthorEmail("email@email.com");
		myMap.setDescription("Mapa budovy FJFI ČVUT, Trojanova 13, Praha 2");
		myMap.setGuid(Utility.generateGUID());
		myMap.setName("Trojanka");
		
		UUID locguid = Utility.generateGUID();
		List<UUID> loclist = new LinkedList<UUID>();
		loclist.add(locguid);
		Location NAL = new Location(Utility.generateGUID(),"NAL","jiná lokace, neautomaticky zpracovávaná", myMap);
		Location l01 = new Location(Utility.generateGUID(),"l01","chodba", myMap);
		Location l02 = new Location(Utility.generateGUID(),"l02","severní chodba KM", myMap);
		Location l03 = new Location(Utility.generateGUID(),"l03","hlavní chodba KM", myMap);
		Location l04 = new Location(Utility.generateGUID(),"l04","jižní chodba KM", myMap);
		myMap.addLocation(l01);
		myMap.addLocation(l02);
		myMap.addLocation(l03);
		myMap.addLocation(l04);
		
		GMNode l01n01 = new GMNode(guid1,				   "l01n01", loclist, l01.description, myMap);
		GMNode l01n02 = new GMNode(Utility.generateGUID(), "l01n02", loclist, l01.description, myMap);
		GMNode l01n03 = new GMNode(Utility.generateGUID(), "l01n03", loclist, l01.description, myMap);
		GMNode l02n01 = new GMNode(Utility.generateGUID(), "l02n01", loclist, l02.description, myMap);
		GMNode l02n02 = new GMNode(Utility.generateGUID(), "l02n02", loclist, l02.description, myMap);
		GMNode l02n03 = new GMNode(Utility.generateGUID(), "l02n03", loclist, l02.description, myMap);
		GMNode l02n04 = new GMNode(Utility.generateGUID(), "l02n04", loclist, l02.description, myMap);
		GMNode l03n01 = new GMNode(Utility.generateGUID(), "l03n01", loclist, l03.description, myMap);
		GMNode l03n02 = new GMNode(Utility.generateGUID(), "l03n02", loclist, l03.description, myMap);
		GMNode l03n03 = new GMNode(Utility.generateGUID(), "l03n03", loclist, l03.description, myMap);
		GMNode l03n04 = new GMNode(Utility.generateGUID(), "l03n04", loclist, l03.description, myMap);
		GMNode l03n05 = new GMNode(Utility.generateGUID(), "l03n05", loclist, l03.description, myMap);
		GMNode l03n06 = new GMNode(Utility.generateGUID(), "l03n06", loclist, l03.description, myMap);
		GMNode l03n07 = new GMNode(Utility.generateGUID(), "l03n07", loclist, l03.description, myMap);
		GMNode l03n08 = new GMNode(Utility.generateGUID(), "l03n08", loclist, l03.description, myMap);
		GMNode l03n09 = new GMNode(Utility.generateGUID(), "l03n09", loclist, l03.description, myMap);
		GMNode l03n10 = new GMNode(Utility.generateGUID(), "l03n10", loclist, l03.description, myMap);
		GMNode l04n01 = new GMNode(Utility.generateGUID(), "l04n01", loclist, l04.description, myMap);
		GMNode l04n02 = new GMNode(Utility.generateGUID(), "l04n02", loclist, l04.description, myMap);
		GMNode l04n03 = new GMNode(Utility.generateGUID(), "l04n03", loclist, l04.description, myMap);
		GMNode l04n04 = new GMNode(guid2,				   "l04n04", loclist, l04.description, myMap);
		GMNode r01 = new GMNode(Utility.generateGUID(), "r01", loclist, "WC", myMap);
		GMNode r02 = new GMNode(Utility.generateGUID(), "r02", loclist, "T-116", myMap);
		GMNode r03 = new GMNode(Utility.generateGUID(), "r03", loclist, "T-115", myMap);
		GMNode r04 = new GMNode(Utility.generateGUID(), "r04", loclist, "T-115b", myMap);
		GMNode r05 = new GMNode(Utility.generateGUID(), "r05", loclist, "T-112", myMap);
		GMNode r06 = new GMNode(Utility.generateGUID(), "r06", loclist, "T-111", myMap);
		GMNode r07 = new GMNode(Utility.generateGUID(), "r07", loclist, "T-110", myMap);
		GMNode r08 = new GMNode(Utility.generateGUID(), "r08", loclist, "T-109", myMap);
		GMNode r09 = new GMNode(Utility.generateGUID(), "r09", loclist, "T-108", myMap);
		GMNode r10 = new GMNode(Utility.generateGUID(), "r10", loclist, "T-107", myMap);
		GMNode r11 = new GMNode(Utility.generateGUID(), "r11", loclist, "T-106", myMap);
		GMNode r12 = new GMNode(Utility.generateGUID(), "r12", loclist, "T-105", myMap);
		GMNode r13 = new GMNode(Utility.generateGUID(), "r13", loclist, "T-104", myMap);
		GMNode s01 = new GMNode(Utility.generateGUID(), "s01", loclist, "Schodiště", myMap);
		myMap.addNode(l01n01);
		myMap.addNode(l01n02);
		myMap.addNode(l01n03);
		myMap.addNode(l02n01);
		myMap.addNode(l02n02);
		myMap.addNode(l02n03);
		myMap.addNode(l02n04);
		myMap.addNode(l03n01);
		myMap.addNode(l03n02);
		myMap.addNode(l03n03);
		myMap.addNode(l03n04);
		myMap.addNode(l03n05);
		myMap.addNode(l03n06);
		myMap.addNode(l03n07);
		myMap.addNode(l03n08);
		myMap.addNode(l03n09);
		myMap.addNode(l03n10);
		myMap.addNode(l04n01);
		myMap.addNode(l04n02);
		myMap.addNode(l04n03);
		myMap.addNode(l04n04);
		myMap.addNode(r01);
		myMap.addNode(r02);
		myMap.addNode(r03);
		myMap.addNode(r04);
		myMap.addNode(r05);
		myMap.addNode(r06);
		myMap.addNode(r07);
		myMap.addNode(r08);
		myMap.addNode(r09);
		myMap.addNode(r10);
		myMap.addNode(r11);
		myMap.addNode(r12);
		myMap.addNode(r13);
		myMap.addNode(s01);
		
		//lokace l01
		GMEdge l01e0102 = new GMEdge(Utility.generateGUID(), "l01e0102", 2000, n01, n02, Direction.Southeast, l01.description, myMap);
		GMEdge l01e0103 = new GMEdge(Utility.generateGUID(), "l01e0103", 1600, n01, n03, Direction.South, 	  l01.description, myMap);
		GMEdge l01e0201 = new GMEdge(Utility.generateGUID(), "l01e0201", 2000, n02, n01, Direction.Northeast, l01.description, myMap);
		GMEdge l01e0203 = new GMEdge(Utility.generateGUID(), "l01e0203", 2000, n02, n03, Direction.Southwest, l01.description, myMap);
		GMEdge l01e0301 = new GMEdge(Utility.generateGUID(), "l01e0301", 1600, n03, n01, Direction.North, 	  l01.description, myMap);
		GMEdge l01e0302 = new GMEdge(Utility.generateGUID(), "l01e0302", 2000, n03, n02, Direction.Northwest, l01.description, myMap);

		GMEdge r01e01 = new GMEdge(Utility.generateGUID(), "r01e01", 0, r01, e01, Direction.South, "odchod z " + r01.description , myMap);
		GMEdge s01e02 = new GMEdge(Utility.generateGUID(), "s01e02", 0, s01, e02, Direction.West,  "odchod z " + s01.description , myMap);
		GMEdge e01r01 = new GMEdge(Utility.generateGUID(), "e01r01", 0, e01, r01, Direction.North, "příchod na " + r01.description, myMap);
		GMEdge e02s01 = new GMEdge(Utility.generateGUID(), "e02s01", 0, e02, s01, Direction.East,  "příchod na " + s01.description, myMap);
		
		GMEdge l01l03 = new GMEdge(Utility.generateGUID(), "l01l03", timeCard, l01e03, l03e01, Direction.South, "přechod z " + l01.description + " do " + l03.description, myMap);
		GMEdge l03l01 = new GMEdge(Utility.generateGUID(), "l03l01", timeCard, l03e01, l01e03, Direction.North, "přechod z " + l03.description + " do " + l01.description, myMap);

		myMap.addEdge(l01e0102);
		myMap.addEdge(l01e0103);
		myMap.addEdge(l01e0201);	
		myMap.addEdge(l01e0203);
		myMap.addEdge(l01e0301);	
		myMap.addEdge(l01e0302);	
		myMap.addEdge(r01e01);
		myMap.addEdge(s01e02);	
		myMap.addEdge(e01r01);
		myMap.addEdge(e02s01);		
		myMap.addEdge(l01l03);		
		myMap.addEdge(l03l01);
		
		return myMap;
	}
}
