<?php


function f_modify($guid,$soubor_puv) {

  
	list($f_guid,$f_name,$f_description,$f_gpscoords,$f_author_name,$f_author_email) = getHeadersFromMap($soubor_puv);	


	$url = 'sprava-map';	
	
  $obsah = '';	   
  $obsah .= '<div style="position: relative; top: 0px;">';	
	$obsah .= '<h3>Upravit mapu</h3>';	
	
  $obsah .= '<form method="post" action="' . $url . '" enctype="multipart/form-data">';
  $obsah .= '<p><br />';
	
	$obsah .= 'Název mapy: <input type="text" name="NewName" maxlenth="80" size="34" value="' . $f_name . '" />';	
	$obsah .= '<br /><br />';
	
	$obsah .= 'GPS souřadnice: <input type="text" name="NewGpsCoords" maxlenth="23" size="30" value="' . $f_gpscoords . '" />';		
	$obsah .= '<br /><br />';	

	$obsah .= 'Nick autora mapy: <input type="text" name="NewAuthorName" maxlenth="50" size="28" value="' . $f_author_name . '" />';		
	$obsah .= '<br /><br />';	
	
	$obsah .= 'Email autora: <input type="text" name="NewAuthorEmail" maxlenth="60" size="34" value="' . $f_author_email . '" />';		
	$obsah .= '<br /><br />';	
	
	if (!empty($f_descrition)) {
		$obsah .= '<textarea name="NewDescription" cols="44" rows="4" maxlength="2000">';	
	} else {
		$obsah .= '<textarea name="NewDescription" cols="44" rows="4" maxlength="2000" placeholder="Sem můžete umístit detail popisující mapu.">';	
	}

	$obsah .= $f_description;
	$obsah .= '</textarea>';
	$obsah .= '<br /><br />';
	
	$obsah .= '<input type="hidden" name="RefGuid" value="' . $guid . '" />';	
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';	

  $obsah .= '<input type="submit" name="provedzmenu" value="ULOŽIT" /></p>';
  $obsah .= '</form>';
  $obsah .= '</div>';

	return $obsah;

}  

// osetreni formulare na stazeni a ulozeni polozky
if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('zmenitpol',$_POST)) && ($_POST['odeslo']==1) ) { 
  	
  $soubor_puv = osetrivstup($_POST['soubor']);
	$soubor_cele = explode('.',$soubor_puv);
	$guid = $soubor_cele[0];
		
	echo f_modify($guid,$soubor_puv);
		
} else {
		
	echo '<span><br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';
	
}
	
  
?>