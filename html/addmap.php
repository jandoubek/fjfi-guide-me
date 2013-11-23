<?php

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
		
		// 3. nastala chyba pri prenosu do docasneho adresare
		if ($ch!=0) {				
			echo '<span class="errormsg">Soubor "<code>' .  $jmeno_puv . '"</code> se nepodařilo přenést na server.<br/>'  . $chyby_uploadu[$ch] . '<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';
			die();		
    }
		
		$new_dest = "./maps/".$_FILES['soub']['name'];				
		
		// 4. presun z docasneho uloziste do trvaleho
		if (!(@move_uploaded_file($_FILES['soub']['tmp_name'],$new_dest))) {
			echo '<span class="errormsg">Během ukládání souboru <code>' .  $jmeno_puv . '</code> došlo k chybě<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';		  						
			die();					
		}
			

  // 5. zjistit ze souboru udaje  
	list($guid,$name,$description,$gpscoords,$author_name,$author_email) = getHeadersFromMap($jmeno_puv);
	
	// 6. nastavit maximalni opravneni
	if (isset($new_dest)) {
		chmod($new_dest, 0777);
	}	
	
	// 7. test, jestli je identifikator shodny s nazvem souboru
	$jmeno_cele = explode(".",$jmeno_puv);
	
	if ($guid != $jmeno_cele[0]) {
		echo '<span class="errormsg">Jméno souboru a v něm obsažený identifikátor mapy se neshodují.<br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a></span>';		  						
		die();	
	}

	// 8. aktualizace hlavicek
	update_headings();		
	
	// 9. soubor byl uspesne ulozen
	echo '<span style="position: relative; left: 380px; color: green;">Mapa byla úspěšně nahrána</span>';
	
 } // konec testu, jestli neni jmeno prazdne		
} // konec osetreni formulare na odeslani souboru
	

// FORMULAR pro upload
function f_upload($idu) {

  $obsah = '';	
	$max_velikost_pro_nahrani_MB = 20;
		
  $url = 'pridat-mapu';	
  
  $obsah .= '<div style="position: relative; top: -60px;">';	
	$obsah .= '<h3>Nahrát mapu v XML</h3>';	
	
  $obsah .= '<form method="post" action="' . $url . '" enctype="multipart/form-data">';

  $obsah .= '<p><br />';
	$obsah .= '<input type="file" name="soub" id="soub" />';

  $obsah .= '<input type="hidden" name="MAX_FILE_SIZE" value="' . $max_velikost_pro_nahrani_MB . '" />';	
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';	
	$obsah .= '<br /><br />';
  $obsah .= '<input type="submit" name="nahratsoubor" value="NAHRAJ MAPU" /></p>';
  $obsah .= '</form>';
  $obsah .= '</div>';
	
	return $obsah;

}   
	
echo '<br /><br />';
echo f_upload($idu);


?>