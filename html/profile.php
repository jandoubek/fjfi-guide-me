<?php

function dbvalues($idu) {

	$sql = "SELECT * from Author WHERE ID = '" . $idu . "'";
	$row = db_selectrow($sql);
		
	$db_name = $row['Name'];
	$db_surname = $row['Surname'];	
	$db_pass = $row['Password'];
	$db_sex = $row['Sex'];		  
	$db_contact = $row['Contact'];	

	$res = array($db_name,$db_surname,$db_pass,$db_sex,$db_contact);	
	
	return $res;
	
}

function f_profile($idu) {

  $dbvalues = dbvalues($idu);	
	$name_db = $dbvalues[0];
	$surname_db = $dbvalues[1];
	$pass_db = $dbvalues[2];
	$sex_db = $dbvalues[3];
	$contact_db = $dbvalues[4];

	$url = './index.php?p=12';	
	
  $obsah = '';	   
  $obsah .= '<div style="position: relative; top: -60px;">';	
	$obsah .= '<br />';
	$obsah .= '<h3>Upravit uživatelský profil</h3>';	
		
  $obsah .= '<form method="post" action="' . $url . '" enctype="multipart/form-data">';
  $obsah .= '<p><br />';
	$obsah .= 'Jméno: <input type="text" name="NewName" maxlenth="80" size="34" value="' . $name_db . '" />';	
	$obsah .= '<br /><div style="cleaner"></div>';
	$obsah .= 'Příjmení: <input type="text" name="NewSurname" maxlenth="80" size="32" value="' . $surname_db . '" />';	
	$obsah .= '<br /><br />';
	$obsah .= 'Heslo: <input type="password" name="NewPass" maxlenth="80" size="35" value="' . base64_decode($pass_db) . '" />';	
	$obsah .= '<br /><br />';
	$obsah .= 'Pohlaví: ';
	
	$obsah .= '<select name="NewSex">';	
		
	if ($sex_db=='f') {
		$obsah .= '<option value="m">Muž</option>';
		$obsah .= '<option value="f" selected="selected">Žena</option>';
	} else {
		$obsah .= '<option value="m" selected="selected">Muž</option>';
		$obsah .= '<option value="f">Žena</option>';	
	}

	$obsah .= '</select>';
	$obsah .= '<br /><br />';

	if (!empty($contact_db)) {
		$obsah .= '<textarea name="NewContact" cols="44" rows="4" maxlength="2000">';	
	} else {
		$obsah .= '<textarea name="NewContact" cols="44" rows="4" maxlength="2000" placeholder="Sem můžete umístit doplňující informace o sobě. např. kontakt.">';	
	}
	
	$obsah .= $contact_db;
	$obsah .= '</textarea>';
	$obsah .= '<br />';	
	
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';	

  $obsah .= '<br /><input type="submit" name="ulozprofil" value="ULOŽIT" /></p>';
  $obsah .= '</form>';
  $obsah .= '</div>';

	return $obsah;

}  

// osetreni formulare na stazeni a ulozeni polozky
if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('ulozprofil',$_POST)) && ($_POST['odeslo']==1) ) { 
  	
  $name_new = osetrivstup($_POST['NewName']);
	$surname_new = osetrivstup($_POST['NewSurname']);
	$pass_new = osetrivstup($_POST['NewPass']);
	$sex_new = osetrivstup($_POST['NewSex']);
	$contact_new = osetrivstup($_POST['NewContact']);
	
  $pass_new = base64_encode($pass_new);
	
	$sql = "UPDATE `Author` SET ";	
	$sql.= "`Name` = '" . $name_new . "', ";		
	$sql.= "`Surname` = '" . $surname_new . "', ";		
	$sql.= "`Password` = '" . $pass_new . "', ";		
	$sql.= "`Sex` = '" . $sex_new . "', ";		
	$sql.= "`Contact` = '" . $contact_new . "' " ;	
	$sql.= "WHERE `ID` =  '" . $idu . "' ";
	
		db_func($sql);
		
}

	echo f_profile($idu);

?>