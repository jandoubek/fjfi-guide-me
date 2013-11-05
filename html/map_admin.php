<?php


  // priprava na formular s potvrzenim smazani souboru
  if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('smazatpolozku',$_POST)) && ($_POST['odeslo']==1) ) {
		$nazev_s = $_POST['nazev'];
	}
	else {
	  $nazev_s = null;
	}
	
	
	// smazat soubor
	if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('potvrditsmazani',$_POST)) && ($_POST['odeslo']==1) ) {
	
		$soubor_smazat = $_POST['nazev'];
				
		unlink('./maps/' . $soubor_smazat);
				
	}
	
	
	
//
// osetreni odeslani souboru
//
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

   $text = '';
		
   $ch           = $_FILES['soub']['error'];                    // chyba prenosu
   $jmeno        = $_FILES['soub']['tmp_name'];                 // soubor na serveru
   $jmeno_puv    = $_FILES['soub']['name'];                     // puvodni jmeno
   $typ          = $_FILES['soub']['type'];                     // MIME typ    
   $jmeno      = prevod_do_utf8(bezpecny_nazev_souboru($jmeno));
   $jmeno_puv  = prevod_do_utf8(bezpecny_nazev_souboru($jmeno_puv));
			
   if (!empty($jmeno)) {
   // byl-li soubor zadan
				
		if ($ch != 0) {
		// nastala chyba pri prenosu

      $text .= 'Soubor "<code>' .  $jmeno_puv . '"</code> se nepodařilo přenést na server' . $chyby_uploadu[$ch];
			
    } else {
    // nenastala zadna chyba pri prenosu do docasneho adresare

		$new_dest = "./maps/".$_FILES['soub']['name'];		
		
      // presun z docasneho uloziste do trvaleho
      if ( @move_uploaded_file($_FILES['soub']['tmp_name'],$new_dest) ) {
				$text .= 'Soubor <code>' .  $jmeno_puv . '</code> byl úspěšně uložen';				
      } else {
        $text .= 'Během ukládání souboru <code>' .  $jmeno_puv . '</code> došlo k chybě';		  			
      }  // konec testu chyby pri presunu
			
    }  // konec testu chyby pri prenosu
		
  } // konec testu, jestli neni jmeno prazdne
	
	echo '<span style="position: relative; left: 380px;">'  . $text . '</span>';
	
  } // konec osetreni formulare na odeslani souboru
	
	if (isset($new_dest)) {
		chmod($new_dest, 0777);
	}

	
	
  //
  // osetreni formulare na stazeni a ulozeni polozky
  //
  if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('stahnoutpolozku',$_POST)) && ($_POST['odeslo']==1) ) { 
  
    $nazev = osetrivstup($_POST['nazev']);
		$cesta_nazev = './maps/' . $nazev;		
		$velikost    = filesize($cesta_nazev);
    $cesta_pole  = pathinfo($cesta_nazev);
    $pripona     = strtolower($cesta_pole["extension"]);

    if(ini_get('zlib.output_compression')) {ini_set('zlib.output_compression', 'Off');}  // nektere prohlizece vyzaduji 

        header("Pragma: public");
        header("Expires: 0");
        header("Cache-control: private", false);                                        // urcite prohlizece vyzaduji
        header("Cache-Control: no-cache, must-revalidate, post-check=0, pre-check=0");  // HTTP/1.1
        header("Expires: Sat, 26 Jul 1997 05:00:00 GMT");                               // datum v minulosti (nekdy zakaze cacheovani)
        header("Content-Description: File Transfer");
        header("Content-Disposition: attachment; filename=\"".$cesta_pole["basename"]."\"");      
        header("Content-Type: text/xml");
        header('Content-Transfer-Encoding: binary');                      
        header("Content-Length: $velikost");
  
     ob_clean();
     flush();

      readfile($cesta_nazev);
     exit;
 
	}
	
	
//
// FUNKCE PRO VYPSANI OBSAHU ADRESARE DO POLE
//
function zjisti_obsah_adresare($adresar='') {

  if (trim($adresar)=='') {return;}
  if (!is_readable($adresar)) {return;}

  $vypis = '';
  $adr = new DirectoryIterator($adresar);
  $i = 0;
  
  while ($adr->valid()) {
  
    $polozka = $adr->current();
    $typ = $polozka->getType();
        
    if (!in_array($polozka->__toString(), array('.','..'))) {      // . a .. ignorujeme

		  /*
      if ($typ=="dir") {   // jedna se o adresar

        $vypis[$i]['typ'] = 'adr';
        $vypis[$i]['nazev'] = prevod_do_utf8($polozka->__toString());
        $vypis[$i]['datum_vytvoreni'] = date('d. m. Y H:i:s', $polozka->getMTime()); 
        $vypis[$i]['velikost_b'] = 0;
        
        $retezec = $polozka->__toString();
      }
			*/

      if ($typ=="file") {  // jedna se o soubor

        $vypis[$i]['typ'] = 'soub';
        $vypis[$i]['nazev'] = prevod_do_utf8($polozka->__toString());
        $vypis[$i]['datum_vytvoreni'] = date('d. m. Y H:i:s', $polozka->getMTime());
        $vypis[$i]['velikost_b'] = $polozka->getSize();

        $retezec = $polozka->__toString();
        
      }

      $i++;              // dalsi index

    } // konec testu na . a .. 

    $adr->next();        // dalsi prvek   
    
  } // konec cyklu while 

  return $vypis;

} 


// STAZENI, ZMENA NAZVU

// formular pro stazeni polozky
function f_stahnout_polozku($nazev) {

  $obsah = '';
	$url = 'index.php?p=9';
//  $url = 'index.php?a=' . urlencode($GLOBALS['akce']);

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="nazev" value="' . $nazev . '" />';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="stahnoutpolozku" value="" class="stahnoutpolozku" />';

  $obsah .= '</form>';

  return $obsah;

}

// formular pro zmenu nazvu polozky
function f_prejmenovat_polozku($nazev) {

  $obsah = '';
	  $url = './index.php?p=9';
//  $url = 'index.php?a=zmenitnazevpolozky';

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="nazev" value="' . $nazev . '" />';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="prejmenovatpolozku" value="A_" class="tlacitkosmazat" />';

  $obsah .= '</form>';

  return $obsah;

}

// formular pro smazani polozky
function f_smazat_polozku($nazev) {

  $obsah = '';
  $url = './index.php?p=9';	

	$obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
	$obsah .= '<input type="hidden" name="nazev" value="' . $nazev . '" />';
	$obsah .= '<input type="hidden" name="odeslo" value="1" />';
	$obsah .= '<input type="submit" name="smazatpolozku" value="X" class="tlacitkosmazat" />';

	$obsah .= '</form>';
	
  return $obsah;

}


// formular pro potvrzeni smazani polozky
function f_potvrdit_smazani_polozky($nazev) {

  $obsah = '';
  $url = './index.php?p=9';	
	
	$obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
	$obsah .= '<input type="hidden" name="nazev" value="' . $nazev . '" />';
	$obsah .= '<input type="hidden" name="odeslo" value="1" />';
	$obsah .= '<input type="submit" name="potvrditsmazani" value="POTVRDIT SMAZÁNÍ" class="tlacitkosmazat" />';

  return $obsah;

}



// SERAZENI
// formular
function f_serad_dle_popisu_vzestupne() {

  $obsah = '';
  $url = './index.php?p=9';
  //$url = 'index.php?a=' . urlencode($GLOBALS['akce']);
	

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';

  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddlenazvuvzestupne" value="" class="seraditvzestupne" />';

  $obsah .= '</form>';

  return $obsah;

}


// formular
function f_serad_dle_popisu_sestupne() {

  $obsah = '';
  $url = './index.php?p=9';
  //$url = 'index.php?a=' . urlencode($GLOBALS['akce']);
	
  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddlenazvusestupne" value="" class="seraditsestupne" />';

  $obsah .= '</form>';

  return $obsah;

}


// formular
function f_serad_dle_data_vytvoreni_vzestupne() {

  $obsah = '';
  $url = './index.php?p=9';
  //$url = 'index.php?a=' . urlencode($GLOBALS['akce']);


  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddledatavytvorenivzestupne" value="" class="seraditvzestupne" />';

  $obsah .= '</form>';

  return $obsah;

}


// formular
function f_serad_dle_data_vytvoreni_sestupne() {

  $obsah = '';
  $url = './index.php?p=9';
  //$url = 'index.php?a=' . urlencode($GLOBALS['akce']);
	
  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddledatavytvorenisestupne" value="" class="seraditsestupne" />';

  $obsah .= '</form>';

  return $obsah;

}


// FORMULAR pro upload
function f_upload() {

  $obsah = '';	
	$max_velikost_pro_nahrani_MB = 20;
		
  $url = './index.php?p=9';
	//$url = './index.php?a=9?action=' . urlencode($GLOBALS['akce']);
  
  $obsah .= '<div style="position: relative; top: -40px;">';	
	$obsah .= '<h3>Nahrát mapu v XML</h3>';	
  $obsah .= '<form method="post" action="' . $url . '" enctype="multipart/form-data">';

  $obsah .= '<p><input type="file" name="soub" id="soub" />&nbsp;';
  $obsah .= '<input type="hidden" name="MAX_FILE_SIZE" value="' . $max_velikost_pro_nahrani_MB . '" />';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';

  $obsah .= '<br /><br /><input type="submit" name="nahratsoubor" value="NAHRAJ MAPU" /></p>';
  $obsah .= '</form>';
  $obsah .= '</div>';
	
	return $obsah;

}   


// VYPIS OBSAHU
function f_display($nazev_s) {
 
  $obsah = '';
  $obsah .= '<div style="position: relative; top: -20px;">';	
	$obsah .= '<h3>Nahrané mapy</h3>';	
	
	$obsahadr = zjisti_obsah_adresare('./maps/');
	
  $obsah .=  '<table style="border-collapse: collapse; font-size: 10px; text-align: center;">';

  $obsah .=  '<tr>';
	$obsah .=  '<th style="margin: 0px; padding: 2px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 200px; text-align: left; padding-left: 6px;">Soubor</th>';    
	$obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; text-align: left; min-width: 360px;"><table class="tabprochazeni"><tr><td style="font-weight: bold;">&nbsp;Popis mapy&nbsp;</td><td>' . f_serad_dle_popisu_vzestupne() . '</td><td>' . f_serad_dle_popisu_sestupne() . '</td></tr></table></th>';    
  $obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 145px; padding-left: 6px;"><table class="tabprochazeni"><tr><td style="font-weight: bold;">Vytvořeno&nbsp;</td><td>' . f_serad_dle_data_vytvoreni_vzestupne() . '</td><td>' . f_serad_dle_data_vytvoreni_sestupne() . '</td></tr></table></th>';  
	$obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 145px;">Změněno</th>'; 
  $obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 85px;">Velikost</th>';    	  
  $obsah .=  '<th style="margin: 0px; padding: 2px; border: 0px solid black; font-size: 10px;" colspan="3"></th>';
  $obsah .=  '</tr>';
	
	// pokud neni adresar prazdny
  if (!empty($obsahadr)) {

	
    // RAZENI POLI
    if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddlepopisuvzestupne',$_POST)) && ($_POST['odeslo']==1) ) {
      //usort($obsahadr, "sort_popis_vzestup");
    }

    if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddlepopisusestupne',$_POST)) && ($_POST['odeslo']==1) ) {
      //usort($obsahadr, "sort_popis_sestup");
    }
	
	  if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddledatavytvorenivzestupne',$_POST)) && ($_POST['odeslo']==1) ) {
      //usort($obsahadr, "sort_datum_vytvoreni_vzestup");
    }

    if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddledatavytvorenisestupne',$_POST)) && ($_POST['odeslo']==1) ) {		
      //usort($obsahadr, "sort_datum_vytvoreni_sestup");
    }
		
	
   // vypisovani souboru z adresare	
		$vypis_soub = '';
 
    for ($i=0; $i < sizeof($obsahadr); $i++) {
		
      $nazev = $obsahadr[$i]['nazev'];
			$nazev_cesta = './maps/' . $nazev;
			$datum_vytvoreni = $obsahadr[$i]['datum_vytvoreni'];
      $zmena = strftime("%d. %m. %Y %H:%M:%S", filemtime($nazev_cesta));			
			$velikost = velikost_vypis($obsahadr[$i]['velikost_b']);
			
			$vypis_soub .= '<tr class="tab">';
      $vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; text-align: left; vertical-align: center;">&nbsp;' . $nazev . '</td>';
      $vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; text-align: left; vertical-align: center; padding-left: 6px;">' . 'Popis' . '</td>';
			$vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;">' . $datum_vytvoreni . '</td>';      
      $vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;">' . $zmena . '</td>';      
      $vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;">' . $velikost . '</td>';
      $vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 3px 0px 7px;">' . f_stahnout_polozku($nazev) .  '</td>';
      $vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 1px 0px 0px;">' . f_prejmenovat_polozku($nazev) .  '</td>';
				
				
			if ( (isset($nazev_s)) && ($nazev_s==$nazev) ) {
				$vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 1px 0px 0px; text-align: left;">' . f_potvrdit_smazani_polozky($nazev). '</td>';
			} else {
				$vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 1px 0px 0px; text-align: left;">' . f_smazat_polozku($nazev). '</td>';
			}

			
      $vypis_soub .= '</tr>';   
			
		}
				
 
		$obsah .= $vypis_soub;
				

    } else {
    
      $obsah .= '<tr>';
      $obsah .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;" colspan="6">' . 'V aktuálním adresáři se nenachází žádný soubor.' . '</td>';
      $obsah .= '<td style="margin: 0px; padding: 2px; border: 0px solid black; font-size: 10px;">&nbsp;</td>';
      $obsah .= '</tr>';
    
    }
        
  $obsah .= '</table>';
	$obsah .= '</div>';	

	return $obsah;
	
} 



echo f_upload();

echo f_display($nazev_s);



?>