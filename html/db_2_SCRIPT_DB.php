<?php

function db_select($sql) {

		$res = Array();
		
		// note 1:
		// put your login to mysql server here	
    // and then rename this file to "db.php"		
		//
			
	  $connstr = 'mysql:host=localhost;dbname=fortpet2_guideme;';
		$user = 'username';
		$pass = 'password';		
		
		// note 2:
		// to create database you can use file GMMap.sql
		//
		
		$dbh = new PDO($connstr, $user, $pass, array(PDO::MYSQL_ATTR_INIT_COMMAND => "SET NAMES utf8"));						
		$dbh->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_WARNING);
		
		$sth = $dbh->prepare($sql);
    $sth->execute();			

    $res = $sth->fetchall(PDO::FETCH_ASSOC);				
		$sth = null;
		$dbh = null;
		
		return $res;	
			
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
  
?>