<?php

function dbvalues($guid) {

	$sql = "SELECT Name, Description, GpsCoords from GMMap WHERE Guid = '" . $guid . "'";
	$map_db = db_selectrow($sql);

	$name_db = $map_db['Name'];
	$descrition_db = $map_db['Description'];
	$gpscoords_db = $map_db['GpsCoords'];			

	$res = array($name_db,$descrition_db,$gpscoords_db);
	
	return $res;
	
}


function f_modify($guid,$nazev_puv,$gps_puv) {

  $dbvalues = dbvalues($guid);	
	$name_db = $dbvalues[0];
	$descrition_db = $dbvalues[1];
	$gpscoords_db = $dbvalues[2];	

	$url = './index.php?p=10';	
	
  $obsah = '';	   
  $obsah .= '<div style="position: relative; top: -40px;">';	
	$obsah .= '<br />';
	$obsah .= '<h3>Upravit mapu</h3>';	
		
  $obsah .= '<form method="post" action="' . $url . '" enctype="multipart/form-data">';
  $obsah .= '<p>';
	$obsah .= 'Název mapy: <input type="text" name="NewName" maxlenth="80" size="34" value="' . $name_db . '" />';	
	$obsah .= '<br /><br />';
	$obsah .= 'GPS souřadnice: <input type="text" name="NewGpsCoords" maxlenth="23" size="30" value="' . $gpscoords_db . '" />';	
	
	$obsah .= '<br /><br />';
	$obsah .= '<textarea name="NewDescription" cols="44" rows="4" maxlength="2000">';	
	$obsah .= $descrition_db;
	$obsah .= '</textarea>';
	$obsah .= '<br /><br />';
	
	$obsah .= '<input type="hidden" name="RefGuid" value="' . $guid . '" />';	
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';	

  $obsah .= '<br /><input type="submit" name="provedzmenu" value="ULOŽIT" /></p>';
  $obsah .= '</form>';
  $obsah .= '</div>';

	return $obsah;

}  

// osetreni formulare na stazeni a ulozeni polozky
if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('zmenitpol',$_POST)) && ($_POST['odeslo']==1) ) { 
  	
  $soubor_puv = osetrivstup($_POST['soubor']);
	$nazev_puv = osetrivstup($_POST['nazev']);
	$gps_puv = osetrivstup($_POST['gps']);
		
	$soubor_cele = explode('.',$soubor_puv);
	$guid = $soubor_cele[0];
		
	echo f_modify($guid,$nazev_puv,$gps_puv);
		
} else {
		
	echo '<span><br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';
	
}
	
  
?>