<?php

function db_select($sql) {

		$res = Array();
		
TOP SECRET
		
		$dbh = new PDO($connstr, $user, $pass);

		$v = $dbh->query($sql);
    $row = 0;
      
    while($zaznam = $v->fetch(PDO::FETCH_ASSOC)) {  // chceme asoc. pole
                            
      if ($row==0)                         // prvni zaznam
				$res[0] = array_keys($zaznam);     // nazvy sloupcu
				$res[] = array_values($zaznam);    // data kazdeho zaznamu
				$row++;
				
		}		
		
		$dbh = null;
		return $res;

	// try {
	// } catch (PDOException $e) {	
	// 	print "Behem cteni databaze nastala chyba!: " . $e->getMessage() . "<br/>";
	//  die();			
	// }
			
}

function db_func($sql) {
		
	  $connstr = 'mysql:host=localhost;dbname=fortpet2_guideme';
		$user = 'fortpet2';
		$pass = 'guidenav1';
		
		$dbh = new PDO($connstr, $user, $pass);

		$dbh->exec($sql);
		
		$dbh = null;
			
}


 //$neco = db_select('SELECT * from GMMap');
 //print_r($neco);
 
 //db_func("INSERT INTO `fortpet2_guideme`.`GMMap` (`Guid`, `Name`, `GpsCoords`, `Description`, `AuthorEmail`) VALUES ('y8xt2fb6nvi1u9ps0s82sxujq7vwcgz586t1m27yy2eugsjn4j84ft7xu2z8clg', 'ČVUT FJFI v Trojanově ulici', '50.074494,14.416797', 'Trojanova 13 120 00 Praha 2, Česká republika +420 224 351 111 cvut.cz‎  České Vysoké Učení Technické V Praze, fakulta jaderná a fyzikálně inženýrská<br> <br> ulice Trojanova 339/13<br> čtvrť Praha 2<br> 120 00 Praha, Nové Město<br> okres Hlavní město Praha<br> kraj Hlavní město Praha <br> Česká republika<br> <br> +420 224 351 111<br> cvut.cz‎<br> <br> Katedra inženýrství pevných látek Fakulty jaderné a fyzikálně inženýrské<br> Katedra jazyků Fakulty jaderné a fyzikálně inženýrské<br> Katedra matematiky Fakulty jaderné a fyzikálně inženýrské<br> Katedra materiálů Fakulty jaderné a fyzikálně inženýrské<br> Katedra softwarového inženýrství v ekonomii Fakulty jaderné a fyzikálně inženýrské<br>', '');");
 
 
?>