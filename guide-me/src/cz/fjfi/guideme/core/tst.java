package cz.fjfi.guideme.core;
import java.io.File;
import java.util.ArrayList;

import cz.fjfi.guideme.core.GMMap;

public class tst {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GMMap myMap = new GMMap();
		myMap.setAuthorName("Martin");
		myMap.setAuthorEmail("email@email.com");
		myMap.setDescription("test map");
		myMap.setGuid(Utility.generateGUID());
		myMap.setName("my map");
		
		Location loc = new Location(Utility.generateGUID(),"loc","test location", myMap);
		myMap.addLocation(loc);
		
		GMNode n1 = new GMNode(Utility.generateGUID(),new String("n1"),myMap.getLocations(),new String("desc"),myMap);
		//System.out.print(n1.exportXML());
		GMNode n2 = new GMNode(Utility.generateGUID(),"n2",myMap.getLocations(),"desc",myMap);
		GMNode n3 = new GMNode(Utility.generateGUID(),"n3",myMap.getLocations(),"desc",myMap);
		GMNode n4 = new GMNode(Utility.generateGUID(),"n4",myMap.getLocations(),"desc",myMap);
		myMap.addNode(n1);
		myMap.addNode(n2);
		myMap.addNode(n3);
		myMap.addNode(n4);
		
		GMEdge e1 = new GMEdge(Utility.generateGUID(),"e1", 5, n1, n2, Direction.Northeast, "edge e1",myMap, myMap.getLocations());
		GMEdge e2 = new GMEdge(Utility.generateGUID(),"e2", 6, n2, n3, Direction.Southeast, "edge e2",myMap, myMap.getLocations());
		GMEdge e3 = new GMEdge(Utility.generateGUID(),"e3", 8, n3, n4, Direction.Southwest, "edge e3",myMap, myMap.getLocations());
		//System.out.print(e1.exportXML());
		myMap.addEdge(e1);
		myMap.addEdge(e2);
		myMap.addEdge(e3);
		//File out = new File();//"D:\\adt-bundle-windows-x86-20130917\\adt-bundle-windows-x86-20130917\\workspace\\GitHub\\fjfi-guide-me\\out.txt");
		myMap.exportXML(null);
	}

}
