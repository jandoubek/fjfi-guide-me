package cz.fjfi.guideme.core;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import cz.fjfi.guideme.core.GMMap;

public class tst {

	/**
	 * @param args
	 */
	public static GMMap testmap(UUID guid1, UUID guid2) // potÞebujeme vr‡tit mapu
	{
		GMMap myMap = new GMMap();
		myMap.setAuthorName("Martin");
		myMap.setAuthorEmail("email@email.com");
		myMap.setDescription("test map");
		myMap.setGuid(Utility.generateGUID());
		myMap.setName("my map");
		
		UUID locguid = Utility.generateGUID();
		List<UUID> loclist = new LinkedList<UUID>();
		loclist.add(locguid);
		Location loc = new Location(Utility.generateGUID(),"loc","test location", myMap);
		myMap.addLocation(loc);
		
		GMNode n1 = new GMNode(guid1,new String("n1"),loclist,new String("start - bod A"),myMap);
		//System.out.print(n1.exportXML());
		GMNode n2 = new GMNode(Utility.generateGUID(),"n2",loclist,"zahnete do leva tam co byval Pytlicek",myMap);
		GMNode n3 = new GMNode(Utility.generateGUID(),"n3",loclist,"zahnete do leva (u Palantova)",myMap);
		GMNode n4 = new GMNode(guid2,"n4",loclist,"cil - bod B",myMap);
		myMap.addNode(n1);
		myMap.addNode(n2);
		myMap.addNode(n3);
		myMap.addNode(n4);
		
		GMEdge e1 = new GMEdge(Utility.generateGUID(),"e1", 15000, n1, n2, new Direction(Direction.Compass.Northeast), "severn’ chodba KM",myMap);
		GMEdge e2 = new GMEdge(Utility.generateGUID(),"e2", 27000, n2, n3, new Direction(Direction.Compass.Southeast), "hlavn’ chodba KM",myMap);
		GMEdge e3 = new GMEdge(Utility.generateGUID(),"e3", 18000, n3, n4, new Direction(Direction.Compass.Southwest), "jiìn’ chotba KM",myMap);
		//System.out.print(e1.exportXML());
		myMap.addEdge(e1);
		myMap.addEdge(e2);
		myMap.addEdge(e3);
		//File out = new File();//"D:\\adt-bundle-windows-x86-20130917\\adt-bundle-windows-x86-20130917\\workspace\\GitHub\\fjfi-guide-me\\out.txt");
		//myMap.exportXML(null);
		return myMap;
	}
}
