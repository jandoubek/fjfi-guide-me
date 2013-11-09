<?php

date_default_timezone_set('Europe/Prague');
setlocale(LC_ALL, 'cs_CZ.UTF-8');
iconv_set_encoding('internal_encoding', 'UTF-8');
iconv_set_encoding('output_encoding', 'UTF-8');
mb_internal_encoding('utf-8');

if (!ini_get('display_errors')) {ini_set('display_errors', 0);} 


//header('Content-type: text/xml;  charset:UTF-8; ');
$dbfile = 'db.php';

if (file_exists($dbfile)) {
  require_once($dbfile);
} else {
  echo 'V projektu chybí skript ' . $dbfile . '<br />Kontaktujte správce webu';
	die();
}

require_once('app_fce.php');
require_once('head.php');


$obsahadr = zjisti_obsah_adresare('./maps/');
		
// pokud neni adresar prazdny
  if (!empty($obsahadr)) {
		
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

					$name = $val['Name'];
					$gpscoords = $val['GpsCoords'];
					$description = $val['Description'];
					$author = $val['Author'];

					$k = $j-1;
					$vypis[$k]['Guid'] = $guid_db;
          $vypis[$k]['Name'] = $name;
					$vypis[$k]['GpsCoords'] = $gpscoords;
					$vypis[$k]['Description'] = $description;
					$vypis[$k]['Author'] = $author;
					
				}
			}
		}	
		
		// setrideni
		$val = array();
		foreach ($vypis as $key => $row) {
			$val[$key] = $row['Name'];
		}
		
		array_multisort($val, SORT_ASC, $vypis);		
		
		
		
		
		// to xml
		$xml = new SimpleXMLElement('<?xml version="1.0" encoding="utf-8"?><map></map>');
	  $xml->addAttribute('version', '1.0');
	
		foreach ($vypis as $key => $row) {		
						
			$guid = $row['Guid'];		
			//$nazev = htmlentities($row['Name']);	
			$nazev = $row['Name'];	
			//$detail = iconv('ISO-8859-2', 'UTF-8', $row['Description']);
			$detail = $row['Description'];
			$gps =	$row['GpsCoords'];
      $autor = $row['Author'];

			//echo  $guid . '&nbsp;' . $nazev . '&nbsp;' . $soubor . '&nbsp;' . $gps  . '&nbsp;' . $autor . '<br><br>';
				
			$guidnode = $xml->addChild('Guid', $guid);
			$guidnode->addChild('Name',$nazev);
			$guidnode->addChild('Description',$detail);
			$guidnode->addChild('GpsCoords',$gps);
			$guidnode->addChild('Author',$autor);
							
		}	
		
$xml->asXML('./headings.xml');

print $xml->asXML;
			
}

require_once('foot.php');

?>