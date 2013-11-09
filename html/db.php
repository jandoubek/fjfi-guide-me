<?php

function db_select($sql) {

		$res = Array();
		
	  $connstr = 'mysql:host=localhost;dbname=fortpet2_guideme;';
		$user = 'fortpet2';
		$pass = 'guidenav1';		
		
		$dbh = new PDO($connstr, $user, $pass, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));						
		$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);
		
		$sth = $dbh->prepare($sql);
    $sth->execute();			

    $res = $sth->fetchall(PDO::FETCH_ASSOC);				
		$sth = null;
		$dbh = null;
		
		return $res;
		
	// try {
	// } catch (PDOException $e) {	
	// 	print "Behem cteni databaze nastala chyba!: " . $e->getMessage() . "<br/>";
	//  die();			
	// }
			
}


function db_selectrow($sql) {

		$res = Array();
		
	  $connstr = 'mysql:host=localhost;dbname=fortpet2_guideme;';
		$user = 'fortpet2';
		$pass = 'guidenav1';		
		
		$dbh = new PDO($connstr, $user, $pass, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));						
		$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);
		$dbh->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
		
		$sth = $dbh->prepare($sql);
    $sth->execute();			

    $res = $sth->fetch(PDO::FETCH_ASSOC);				
		$sth = null;
		$dbh = null;
		
		return $res;
		
	// try {
	// } catch (PDOException $e) {	
	// 	print "Behem cteni databaze nastala chyba!: " . $e->getMessage() . "<br/>";
	//  die();			
	// }
			
}


function db_func($sql) {
		
	  $connstr = 'mysql:host=localhost;dbname=fortpet2_guideme;';
		$user = 'fortpet2';
		$pass = 'guidenav1';		
		
		$dbh = new PDO($connstr, $user, $pass, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));
		$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);
		$dbh->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);
		   
		// alternativa: $dbh->exec($sql);		
		$sth = $dbh->prepare($sql);
    $sth->execute();			
		
		$dbh = null;
			
}

db_func("SET NAMES utf8 COLLATE utf8_czech_ci");


//$neco = db_select('SELECT * from GMMap');
//print_r($neco);

//db_func("INSERT INTO `fortpet2_guideme`.`GMMap` (`Guid`, `Name`, `GpsCoords`, `Description`, `AuthorID`) VALUES ('l8xt2fb6nvi1u9ps0s82sxujq7vwcgz586t1m27yy2eugsjn4j84ft7xu2z8clg', 'ČVUT FJFI v Trojanově ulici', '50.074494,14.416797', 'Trojanova 13 120 00 Praha 2, Česká republika +420 224 351 111 cvut.cz‎  České Vysoké Učení Technické V Praze, fakulta jaderná a fyzikálně inženýrská<br> <br> ulice Trojanova 339/13<br> čtvrť Praha 2<br> 120 00 Praha, Nové Město<br> okres Hlavní město Praha<br> kraj Hlavní město Praha <br> Česká republika<br> <br> +420 224 351 111<br> cvut.cz‎<br> <br> Katedra inženýrství pevných látek Fakulty jaderné a fyzikálně inženýrské<br> Katedra jazyků Fakulty jaderné a fyzikálně inženýrské<br> Katedra matematiky Fakulty jaderné a fyzikálně inženýrské<br> Katedra materiálů Fakulty jaderné a fyzikálně inženýrské<br> Katedra softwarového inženýrství v ekonomii Fakulty jaderné a fyzikálně inženýrské<br>', '0');");
  
?>