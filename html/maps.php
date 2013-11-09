<?php

// osetreni formulare na stazeni a ulozeni polozky
if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('stahnoutmapu',$_POST)) && ($_POST['odeslo']==1) ) { 
    
	$soubor = osetrivstup($_POST['soubor']);
	download_map($soubor);
		
}
	
	
// STAZENI - formular pro stazeni polozky
function f_stahni_mapu($nazev,$soubor) {

  $obsah = '';
	$url = 'index.php?p=4';

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250" class="stahnoutmapu">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
	$obsah .= '<input type="hidden" name="soubor" value="' . $soubor . '" />';
  $obsah .= '<input type="submit" name="stahnoutmapu" value=" ' . $nazev . '" />';
  $obsah .= '</form>';

  return $obsah;

}


// SERAZENI - formular
function f_serad_dle_nazvu_vzestupne() {

  $obsah = '';
  $url = './index.php?p=4';
	
  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddlenazvuvzestupne" value="" class="seraditvzestupne" />';
  $obsah .= '</form>';

  return $obsah;

}


// SERAZENI - formular
function f_serad_dle_nazvu_sestupne() {

  $obsah = '';
  $url = './index.php?p=4';

  $obsah .= '<form method="post" action="' . $url . '" accept-charset="UTF-8 iso-8859-2 windows-1250">';
  $obsah .= '<input type="hidden" name="odeslo" value="1" />';
  $obsah .= '<input type="submit" name="seraddlenazvusestupne" value="" class="seraditsestupne" />';
  $obsah .= '</form>';

  return $obsah;

}


// VYPIS OBSAHU
function f_maps() {
 
  $obsah = '';
  $obsah .= '<div style="position: relative; top: -40px;">';
	$obsah .= '<h3>Seznam dostupných map ke stažení</h3>';	
	
	
  $obsah .=	'<span style="position: relative; top: -38px; left: 350px">'; 	
	$obsah .=	'<table style="border: 0px; margin: 2px; padding: 0px;">';
	$obsah .=	'<tr>';
	$obsah .=	'<td>';
	$obsah .=	f_serad_dle_nazvu_vzestupne();
 	$obsah .=	'</td>';
	$obsah .=	'<td>';
  $obsah .=	f_serad_dle_nazvu_sestupne();
	$obsah .=	'</td>';
	$obsah .=	'</tr>';
	$obsah .=	'</table>';
	$obsah .=	'</span>'; 
	$obsah .= '</div>';	
	
  $obsah .= '<div style="position: relative; top: -70px;">';
	$obsahadr = zjisti_obsah_adresare('./maps/');
		
	// pokud neni adresar prazdny
  if (!empty($obsahadr)) {

	
    // RAZENI POLI - priprava
		if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('seraddlenazvusestupne',$_POST)) && ($_POST['odeslo']==1) ) {
			$jine_razeni = 2;
    } else {
		  $jine_razeni = 1;
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
					$description = $val['Description'];

					$k = $j-1;
          $vypis[$k]['Name'] = $name;
					$vypis[$k]['File'] = $nazev;
					$vypis[$k]['GpsCoords'] = $gpscoords;
					$vypis[$k]['Description'] = $description;
					$vypis[$k]['MapUploaded'] = $datum_vytvoreni;					
					$vypis[$k]['MapModified'] = $zmena;
					$vypis[$k]['MapSize'] = $velikost;
					
				}
			}
		}	
		
		// sestrideni dle vybraneho razeni, pokud neni, serazeno dle nazvu vzestupne
		if ($jine_razeni==2) {

				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['Name'];
				}
		
				array_multisort($val, SORT_DESC, $vypis);	
		
		} else {

				$val = array();
				foreach ($vypis as $key => $row) {
					$val[$key] = $row['Name'];
				}
		
				array_multisort($val, SORT_ASC, $vypis);	
		
		}			
		
		// vypis z pripraveneho pole
		foreach ($vypis as $key => $row) {		
			
			
			
			$nazev = $row['Name'];			
			$soubor = $row['File'];
			$gps =	$row['GpsCoords'];
		  $vytvoreni = $row['MapUploaded'];
			$zmena = $row['MapModified'];
			$velikost = $row['MapSize'];
			$detail = $row['Description'];
			
			$detail_vypis = str_replace('&lt;br&gt;','<br />',$detail);
			$detail_vypis = str_replace('&lt;br &gt;','<br />',$detail_vypis);
			$detail_vypis = str_replace('&lt;br /&gt;','<br />',$detail_vypis);		
			
			$dat_vytvoreni = substr($vytvoreni,0,12);
			$dat_zmeny = substr($zmena,0,12);			
			$id_detail_label = 'mapdet_' . $key;
			
			$vypis_soub .= '<div class="mapdload">';
			$vypis_soub .= '  <h2><a href="./maps/' . $soubor . '" target="_blank"><span class="maplabel">' . f_stahni_mapu($nazev,$soubor) . '</span></a></h2>';
			$vypis_soub .= '  <h4>GPS: ' . $gps . '</h4>';
			
			if (empty($detail)) {
				$vypis_soub .= '<span style="color: #ffcc33;">&darr; Detail &darr;</span>&nbsp;&nbsp; ';
			} else {
  			$vypis_soub .= '<span style="color: navy; cursor: pointer;" onClick="javascript:document.getElementById(\'' . $id_detail_label . '\').style.display=\'block\'">&darr; Detail &darr;</span>&nbsp;&nbsp; ';		
			}
			
      $vypis_soub .= 'Poslední změna: ' . $dat_zmeny . ' &nbsp;&nbsp; Mapa vytvořena: ' . $dat_vytvoreni . ' &nbsp;&nbsp; Velikost: ' . $velikost .'<br>';						
			$vypis_soub .= '<span style="display: none;" id="' . $id_detail_label . '" onClick="this.style.display=\'none\'"><br />' . $detail_vypis . '</span>';	

			$vypis_soub .= '</div>';
				
		}
	 
		$obsah .= $vypis_soub;

    } 

	$obsah .= '</div>';
	return $obsah;
		
}



echo f_maps();


?>