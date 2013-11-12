<?php

session_start();
header("Cache-control: private");

if ($_SESSION["prihlasen"] == 1) {

	$idu = $_SESSION["idu"];

  $sql = "SELECT Name, Surname, Sex from Author WHERE ID = '" . $idu . "'";
	$row = db_selectrow($sql);

	$user_fullname = $row['Name'] . ' ' . $row['Surname'];	
	$user_sex = $row['Sex'];		  

} else {

	$idu = null;
	$user_fullname = null;
	$user_sex = null;

	header("Location: prihlasit");	
	exit();	

}

?>