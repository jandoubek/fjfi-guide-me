<?php

function getGuid($file) {

  $path = './maps/' . $file;
	$xml = simplexml_load_file($path);
		
	try {		
	  $xml->attributes()->guid;				
	} catch (Exception $e) {	
    echo 'Behem zpracovavani souboru se vyskytla chyba: ',  $e->getMessage(), "\n";
		die();
	}
	 	
	$guid = $xml->attributes()->guid;
	return $guid;	
	
}


// 1. osetreni odeslani souboru
if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('nahratsoubor',$_POST)) && ($_POST['odeslo']==1) ) {
	 
	 
   $chyby_uploadu = array(
     1 => 'Soubor překročil velikost <code>upload_max_filesize</code>.',
     2 => 'Soubor překročil velikost <code>MAX_FILE_SIZE</code> definovanou v HTML formuláři.',
     3 => 'Soubor byl na server přenesen jen částečně.',
     4 => 'Nebyl uploadován žádný soubor.',
     6 => 'Chybí adresář pro dočasné soubory.',
     7 => 'Chyba zápisu souboru na disk.',
     8 => 'Upload souboru byl zastaven kvůli nepovolené příponě.'
   );
   
   $ch           = $_FILES['soub']['error'];                    // chyba prenosu
   $jmeno        = $_FILES['soub']['tmp_name'];                 // soubor na serveru
   $jmeno_puv    = $_FILES['soub']['name'];                     // puvodni jmeno
   $typ          = $_FILES['soub']['type'];                     // MIME typ    
   $jmeno      = prevod_do_utf8(bezpecny_nazev_souboru($jmeno));
   $jmeno_puv  = prevod_do_utf8(bezpecny_nazev_souboru($jmeno_puv));
		
   // 2. byl-li soubor zadan	 		
   if (!empty($jmeno)) {
   
    // 3. zjisteni a osetreni hodnot formulare	 
		$name = htmlspecialchars($_POST['Name']);
		$gpscoords = htmlspecialchars($_POST['GpsCoords']);
    $description = htmlspecialchars($_POST['Description']);
		$author = htmlspecialchars($_POST['Author']);

	  $description = str_replace("'","`", $description);	

		$zpr = null;
		
		if (empty($jmeno_puv)) {
			$zpr .= 'Nebyl vybrán soubor.<br />';
		}

		if (empty($name)) {
			$zpr .= 'Je potřeba zadat název mapy.<br />';
		}
		
		if (empty($gpscoords)) {
			$zpr .= 'Je potřeba zadat GPS souřadnice objektu.<br />';
		}

		if (strlen($name)>50) {
			$zpr .= 'Název mapy je příliš dlouhý.<br />';
		}		

		if (strlen($gpscoords)>23) {
			$zpr .= 'Řetězev udávající GPS souřadnice je příliš dlouhý.<br />';
		}		
		
		if (strlen($description)>2000) {
			$zpr .= 'Detailní popis je příliš dlouhý. Je povoleno pouze 2000 znaků.<br />';
		}
		
		if (!empty($zpr)) {					
			echo '<span class="errormsg">Během přípravy ukládání souboru došlo k chybám.<br/>'  . $zpr . '<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';
			die();			
		}
	 	 
		// 5. nastala chyba pri prenosu do docasneho adresare
		if ($ch!=0) {				
			echo '<span class="errormsg">Soubor "<code>' .  $jmeno_puv . '"</code> se nepodařilo přenést na server.<br/>'  . $chyby_uploadu[$ch] . '<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';
			die();		
    }
		
		$new_dest = "./maps/".$_FILES['soub']['name'];				
		
		// 6. presun z docasneho uloziste do trvaleho
		if (!(@move_uploaded_file($_FILES['soub']['tmp_name'],$new_dest))) {
			echo '<span class="errormsg">Během ukládání souboru <code>' .  $jmeno_puv . '</code> došlo k chybě<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';		  						
			die();					
		}
		
		echo 'kuk3';
							
	// 7. nastavit maximalni opravneni
	if (isset($new_dest)) {
		chmod($new_dest, 0777);
	}
	
	// 8. zjisteni GUID
	$guid = getGuid($jmeno_puv);
		
	if (empty($guid)) {
		echo '<span class="errormsg">V souboru nebyl nalezen identifikátor mapy.<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';		  						
		die();	
	}
	
	// 9. test, jestli je identifikator shodny s nazvem souboru
	$jmeno_cele = explode(".",$jmeno_puv);
	
	if ($guid != $jmeno_cele[0]) {
		echo '<span class="errormsg">Jméno souboru a v něm obsažený identifikátor mapy se neshodují.<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';		  						
		die();	
	}
	
	// 10. test, jestli dany soubor jiz neni v databazi
	$maps_guid = db_select('SELECT Guid from GMMap');
	
	foreach ($maps_guid as $key => $val) {	  
		if ($guid == $val['Guid']) {
			echo '<span class="errormsg">Byl nalezen soubor se stejným identifikátorem mapy<br />Před nahráváním této mapy odstraňte mapu se shodným názvem.<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';		  						
			die();		
		}		
	}
	
  // 11. vlozeni mapy do databaze
	$sql = "INSERT INTO `GMMap` (`Guid`, `Name`, `GpsCoords`, `Description`, `AuthorID`) VALUES (";
	$sql.= "'" . $guid . "', " ;	
	$sql.= "'" . $name . "', " ;	
	$sql.= "'" . $gpscoords . "', " ;
	$sql.= "'" . $description . "', " ;
	$sql.= "'" . $author . "'" ;	
	$sql.= ")";	
	
	db_func($sql);
	
	// 12. soubor byl uspesne ulozen
	echo '<span style="position: relative; left: 380px; color: green;">Mapa byla úspěšně nahrána</span>';
	
 } // konec testu, jestli neni jmeno prazdne		
} // konec osetreni formulare na odeslani souboru
	

// FORMULAR pro upload
function f_upload($idu) {

  $obsah = '';	
	$max_velikost_pro_nahrani_MB = 20;
		
  $url = './index.php?p=9';	
  
  $obsah .= '<div style="position: relative; top: -60px;">';	
	$obsah .= '<h3>Nahrát mapu v XML</h3>';	
	
  $obsah .= '<form method="post" action="' . $url . '" enctype="multipart/form-data">';

  $obsah .= '<p><br />';
	$obsah .= '<input type="file" name="soub" id="soub" />';
	$obsah .= '<br /><br />';
	
	$obsah .= 'Název mapy: <input type="text" name="Name" maxlenth="80" size="34" placeholder="Název objektu, který je mapován" />';	
	$obsah .= '<br /><br />';
	$obsah .= 'GPS souřadnice: <input type="text" name="GpsCoords" maxlenth="23" size="30"  placeholder="Formát XXX.XXXXX,YYY.YYYYY"  />';	
	
	$obsah .= '<br /><br />';
	$obsah .= '<textarea name="Description" cols="44" rows="4" maxlength="2000" placeholder="Zde můžete přidat detailní popis mapy, umístění objektu, organizace, které na této adrese sídlí, atp. Je možno využít maximálně 2000 znaků. K oddělení řádků používejte HTML tag <br>">';	
	$obsah .= '</textarea>';
	$obsah .= '<br /><br />';
	
	$obsah .= '<input type="hidden" name="Author" value="' . $idu . '" />';	
  $obsah .= '<input type="hidden" name="MAX_FILE_SIZE" value="' . $max_velikost_pro_nahrani_MB . '" />';
	
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';	

  $obsah .= '<input type="submit" name="nahratsoubor" value="NAHRAJ MAPU" /></p>';
  $obsah .= '</form>';
  $obsah .= '</div>';
	
	return $obsah;

}   
	
echo '<br /><br />';
echo f_upload($idu);


?>