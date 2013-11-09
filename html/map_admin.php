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
	
		$soubor_smazat = htmlspecialchars($_POST['nazev']);			
	
		$nazev_cele = explode('.',$soubor_smazat);
		$naz = $nazev_cele[0];
			
		$sql = "DELETE FROM `GMMap` WHERE `GMMap`.`Guid` = '" . $naz . "'";	
		db_func($sql);
	
		$path = './maps/' . $soubor_smazat;
		unlink($path);
				
	}
	

  // osetreni formulare na stazeni a ulozeni polozky
  if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('stahnoutpolozku',$_POST)) && ($_POST['odeslo']==1) ) { 
  
    $nazev = osetrivstup($_POST['nazev']);
		download_map($nazev);
		
	}
	
	

// STAZENI
// formular pro stazeni polozky
function f_stahnout_polozku($nazev) {

  $obsah = '';
	$url = 'index.php?p=9';

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="nazev" value="' . $nazev . '" />';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="stahnoutpolozku" value="" class="stahnoutpolozku" />';

  $obsah .= '</form>';

  return $obsah;

}

// formular pro zmenu nazvu polozky
function f_zmenit_polozku($nazev) {

  $obsah = '';
	$url = './index.php?p=11';

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="nazev" value="' . $nazev . '" />';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="zmenitpolozku" value="A_" class="tlacitkosmazat" />';

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
function f_serad_dle_nazvu_vzestupne() {

  $obsah = '';
  $url = './index.php?p=9';
	
  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';

  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddlenazvuvzestupne" value="" class="seraditvzestupne" />';

  $obsah .= '</form>';

  return $obsah;

}


// formular
function f_serad_dle_nazvu_sestupne() {

  $obsah = '';
  $url = './index.php?p=9';

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
	
  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddledatavytvorenisestupne" value="" class="seraditsestupne" />';

  $obsah .= '</form>';

  return $obsah;

}


// formular
function f_serad_dle_data_zmeny_vzestupne() {

  $obsah = '';
  $url = './index.php?p=9';

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddledatazmenyvzestupne" value="" class="seraditvzestupne" />';

  $obsah .= '</form>';

  return $obsah;

}


// formular
function f_serad_dle_data_zmeny_sestupne() {

  $obsah = '';
  $url = './index.php?p=9';

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddledatazmenysestupne" value="" class="seraditsestupne" />';

  $obsah .= '</form>';

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
	$obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; text-align: left; min-width: 360px; max-width: 360px; width: 360px;"><table class="tabprochazeni"><tr><td style="font-weight: bold;">&nbsp;Název mapy&nbsp;</td><td>' . f_serad_dle_nazvu_vzestupne() . '</td><td>' . f_serad_dle_nazvu_sestupne() . '</td></tr></table></th>';    
	$obsah .=  '<th style="margin: 0px; padding: 2px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 152px; text-align: left; padding-left: 6px;">Soubor</th>';    
	$obsah .=  '<th style="margin: 0px; padding: 2px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 130px; text-align: left; padding-left: 6px;">GPS souřadnice</th>';    
  $obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 140px; padding-left: 6px;"><table class="tabprochazeni"><tr><td style="font-weight: bold;">Vytvořeno&nbsp;</td><td>' . f_serad_dle_data_vytvoreni_vzestupne() . '</td><td>' . f_serad_dle_data_vytvoreni_sestupne() . '</td></tr></table></th>';  	
	$obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 140px; padding-left: 6px;"><table class="tabprochazeni"><tr><td style="font-weight: bold;">Zmeněno&nbsp;</td><td>' . f_serad_dle_data_zmeny_vzestupne() . '</td><td>' . f_serad_dle_data_zmeny_sestupne() . '</td></tr></table></th>';  
  $obsah .=  '<th style="margin: 0px; padding: 1px; border: 1px solid black; background-color: #ffcc00; font-size: 10px; min-width: 85px;">Velikost</th>';    	  
  $obsah .=  '<th style="margin: 0px; padding: 2px; border: 0px solid black; font-size: 10px;" colspan="3"></th>';
  $obsah .=  '</tr>';
	
	// pokud neni adresar prazdny
  if (!empty($obsahadr)) {

	
    // RAZENI POLI
		$jine_razeni = 1;
		
		if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddlenazvusestupne',$_POST)) && ($_POST['odeslo']==1) ) {
			$jine_razeni = 2;
    }

	  if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddledatavytvorenivzestupne',$_POST)) && ($_POST['odeslo']==1) ) {
			$jine_razeni = 3;
      
    }

    if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddledatavytvorenisestupne',$_POST)) && ($_POST['odeslo']==1) ) {		
			$jine_razeni = 4;
 
    }
		
	  if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddledatazmenyvzestupne',$_POST)) && ($_POST['odeslo']==1) ) {
			$jine_razeni = 5;
      
    }

    if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddledatazmenysestupne',$_POST)) && ($_POST['odeslo']==1) ) {		
			$jine_razeni = 6;
      
    }
		
		
		// vypisovani souboru z adresare	
		$vypis_soub = '';
		
		$vypis = array();
		$j = 0;
 
    for ($i=0; $i < sizeof($obsahadr); $i++) {
		
		  $nazev = $obsahadr[$i]['nazev'];
			$nazev_cele = explode('.',$nazev);
			$naz = $nazev_cele[0];					
		
			// porovnej realne nahrane soubory s databazi 
			$maps_db = db_select('SELECT * from GMMap');

			foreach ($maps_db as $key => $val) {
			
				$guid_db = $val['Guid'];
				
				// shoda
				if ($guid_db==$naz) {
								
					$j++;			
					$nazev_cesta = './maps/' . $nazev;
					$datum_vytvoreni = $obsahadr[$i]['datum_vytvoreni'];
					$zmena = strftime("%d. %m. %Y %H:%M:%S", filemtime($nazev_cesta));	
					$velikost = velikost_vypis($obsahadr[$i]['velikost_b']);			
				
					$name = $val['Name'];
					$gpscoords = $val['GpsCoords'];

					$k = $j-1;
          $vypis[$k]['Name'] = $name;
					$vypis[$k]['File'] = $nazev;
					$vypis[$k]['GpsCoords'] = $gpscoords;
					$vypis[$k]['MapUploaded'] = $datum_vytvoreni;
					$vypis[$k]['MapModified'] = $zmena;
					$vypis[$k]['MapSize'] = $velikost;
					
				}
			}
		}	

    // sestrideni dle vybraneho razeni, pokud neni, serazeno dle nazvu vzestupne
		switch ($jine_razeni) {
		
			case "1" : 
			
				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['Name'];
				}
		
				array_multisort($val, SORT_ASC, $vypis);		
			
			break;
			
			case "2" : 
			
				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['Name'];
				}
		
				array_multisort($val, SORT_DESC, $vypis);		
			
			break;

			case "3" : 
			
				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['MapUploaded'];
				}
		
				array_multisort($val, SORT_ASC, $vypis);		
			
			break;
			
			case "4" : 
			
				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['MapUploaded'];
				}
		
				array_multisort($val, SORT_DESC, $vypis);		
			
			break;
			
			case "5" : 
			
				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['MapModified'];
				}
		
				array_multisort($val, SORT_ASC, $vypis);		
			
			break;
			
			case "6" : 
			
				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['MapModified'];
				}
		
				array_multisort($val, SORT_DESC, $vypis);		
			
			break;			
			
			default :

				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['Name'];
				}
		
				array_multisort($val, SORT_ASC, $vypis);		
			 break;
			 
		}	
		
		foreach ($vypis as $key => $row) {		
			
			$nazev = $row['Name'];			
			$soubor = $row['File'];
			$gps =	$row['GpsCoords'];
		  $datum_vytvoreni = $row['MapUploaded'];
			$zmena = $row['MapModified'];
			$velikost = $row['MapSize'];
			
			$soubor_vypis = substr($soubor, 0, 22) . '..';
			
		  $vypis_soub .= '<tr class="tab">';									
			$vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; text-align: left; vertical-align: center;">&nbsp;' . $nazev . '</td>';
			$vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; text-align: left; vertical-align: center;" title=' . $soubor . '>&nbsp;' . $soubor_vypis . '</td>';			
			$vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;">' . $gps . '</td>';      
			$vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;">' . $datum_vytvoreni . '</td>';      
      $vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;">' . $zmena . '</td>';      
      $vypis_soub .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;">' . $velikost . '</td>';
      $vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 3px 0px 7px;">' . f_stahnout_polozku($soubor) .  '</td>';
      $vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 1px 0px 0px;">' . f_zmenit_polozku($soubor) .  '</td>';
						
			if ( (isset($nazev_s)) && ($nazev_s==$soubor) ) {
				$vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 1px 0px 0px; text-align: left;">' . f_potvrdit_smazani_polozky($soubor). '</td>';
			} else {
				$vypis_soub .= '<td style="margin: 0px; padding: 1px; border: 0px solid black; font-size: 10px; vertical-align: center; padding: 0px 1px 0px 0px; text-align: left;">' . f_smazat_polozku($soubor). '</td>';
			}
			
			$vypis_soub .= '</tr>';			
				
		}
	 
		$obsah .= $vypis_soub;

    } 
		
		if ((!isset($j))||($j==0)) {
		
      $obsah .= '<tr>';
      $obsah .= '<td style="margin: 0px; padding: 2px; border: 1px solid black; font-size: 10px; vertical-align: center;" colspan="7">' . 'V aktuálním adresáři se nenachází žádný soubor.' . '</td>';
      $obsah .= '<td style="margin: 0px; padding: 2px; border: 0px solid black; font-size: 10px;">&nbsp;</td>';
      $obsah .= '</tr>';
		
		}

  $obsah .= '</table>';
	$obsah .= '</div>';	

	return $obsah;
	
} 


echo f_display($nazev_s);



?>