<?php


// FUNKCE PRO ODSTRANENI DIAKRITIKY
function odstran_diakritiku($retezec) {

  $prevod_diakritika_tab = Array(  'ä'=>'a',  'Ä'=>'A',  'á'=>'a',  'Á'=>'A',  'à'=>'a',  'À'=>'A',  'ã'=>'a',  'Ã'=>'A',  'â'=>'a',  'Â'=>'A',  'č'=>'c',  'Č'=>'C',  'ć'=>'c',  'Ć'=>'C',  'ď'=>'d',  'Ď'=>'D',  'ě'=>'e',  'Ě'=>'E',  'é'=>'e',  'É'=>'E',  'ë'=>'e',  'Ë'=>'E',  'è'=>'e',  'È'=>'E',  'ê'=>'e',  'Ê'=>'E',  'í'=>'i',  'Í'=>'I',  'ï'=>'i',  'Ï'=>'I',  'ì'=>'i',  'Ì'=>'I',  'î'=>'i',  'Î'=>'I',  'ľ'=>'l',  'Ľ'=>'L',  'ĺ'=>'l',  'Ĺ'=>'L',  'ń'=>'n',  'Ń'=>'N',  'ň'=>'n',  'Ň'=>'N',  'ñ'=>'n',  'Ñ'=>'N',  'ó'=>'o',  'Ó'=>'O',  'ö'=>'o',  'Ö'=>'O',  'ô'=>'o',  'Ô'=>'O',  'ò'=>'o',  'Ò'=>'O',  'õ'=>'o',  'Õ'=>'O',  'ő'=>'o',  'Ő'=>'O',  'ř'=>'r',  'Ř'=>'R',  'ŕ'=>'r',  'Ŕ'=>'R',  'š'=>'s',  'Š'=>'S',  'ś'=>'s',  'Ś'=>'S',  'ť'=>'t',  'Ť'=>'T',  'ú'=>'u',  'Ú'=>'U',  'ů'=>'u',  'Ů'=>'U',  'ü'=>'u',  'Ü'=>'U',  'ù'=>'u',  'Ù'=>'U',  'ũ'=>'u',  'Ũ'=>'U',  'û'=>'u',  'Û'=>'U',  'ý'=>'y',  'Ý'=>'Y',  'ž'=>'z',  'Ž'=>'Z',  'ź'=>'z',  'Ź'=>'Z', '–'=>'-' );
  $retezec = strtolower(strtr($retezec, $prevod_diakritika_tab));  // odstraneni diakritiky

  return $retezec;
   
}


// FUNKCE PRO OSETRENI VSTUPU
function osetrivstup($vstup) {

  $vystup = NULL;  
  $mezi1 = NULL;
  $mezi2 = NULL;
  $mezi3 = NULL;
  $mezi4 = NULL;
  $mezi5 = NULL;

  // uprav vystup
  $mezi1 = trim(strip_tags(htmlspecialchars(($vstup))));

  // odstran obecne zakazane znaky
  $zakazane = array("{", "}", "[", "]");
  $mezi2 = str_replace($zakazane, "", $mezi1);

  // na Windows platforme odstran zpetna lomitka navic
  $mezi3 = str_replace("\n.", "\n..", $mezi2);

  // odstran prebytecna zpetna lomitka
  if (get_magic_quotes_gpc()) {
    $mezi4 = stripslashes($mezi3);
  } else {
    $mezi4 = $mezi3;
  } 

  $vystup = $mezi4;
  
  return $vystup;
  
}



// PREVOD DATA Z ISO DO CESKEHO FORMATU d. m. R. PRO VYPIS 
function iso_do_cz_datum($dat) {

  //prazdne datum
  if (empty($dat)) {return '';}
  
  if (preg_match('/(\d{4})-(\d{1,2})-(\d{1,2})/', $dat, $cast)) {
    
    $datum = "{$cast[3]}. {$cast[2]}. {$cast[1]}";
    
    // odstran nuly ze zacatku nazvu dnu a mesicu
    if (substr($datum,0,1)=='0') {$datum = substr($datum,1,strlen($datum));}
    $datum = str_replace(". 0", ". ", $datum);    
        
    return $datum;
    
  }
  
  // datum nevyhovelo nerugarnimu vyrazu (test puvodniho ISO zapisu)
  return $dat;

}


// FUNKCE PRO PREVOD DATA Z ISO DO FORMATU den. mesic. rok
function cz_datum($en_datum){ 
  if (empty($en_datum))
    return '';
    
  if (preg_match('/(\d{4})-(\d{1,2})-(\d{1,2})/',$en_datum,$cast))
    return "{$cast[3]}. {$cast[2]}. {$cast[1]}";   // format d. m. R
    
  return $en_datum;                                // datum nevyhovelo reg. vyrazu
                                                                
}




// FUNKCE PRO ODSTRANENI ZAKAZANYCH ZNAKU Z RETEZCU
function odstran_zakazane_znaky($retezec) {

  $zakazane = Array('('=>'', ')'=>'', '{'=>'', '}'=>'', '['=>'', ']'=>'', '$'=>'', '?'=>'', '!'=>'', '='=>'', ':'=>'', '%'=>'', '+'=>'', '&'=>'', '%'=>'', '<'=>'', '>'=>'', '/'=>'', '%'=>'', '*'=>'');
  
  $retezec = strtr($retezec, $zakazane);     
     
  return $retezec;
   
}

// FUNKCE PRO OVERENI, JESTLI JE EMAIL ZADAN VE SPRAVNEM TVARU
function jemail($mail) {

  // oproti zdroji prepsano do PCRE syntaxe regularnich vyrazu
  if ((preg_match("^[[:alnum:]][a-z0-9_.-]*@[a-z0-9.-]+\.[a-z]{2,4}$^", $mail)) == true) return true;
  else return false;

}


// FUNKCE PRO OSETRENI PROTI SPAMU (s vyuzitim javascriptu)
function antispam($email) {

  $zakodovane = "<script type=\"text/javascript\"><!--\ndocument.write('<a href=\"' + 'mailto:' + '";
  $adresa = null;
  
  for($i=0; $i<strlen($email); $i++) {
    $adresa .= $email{$i} == '@' ? "' + '&#".ord("@")."' + '"
                                     : "&#".ord($email{$i}).";";
  }

  $zakodovane .= $adresa . "' + '\">' + '" . $adresa . "' + '<\/a>');\n--></script>";

  return $zakodovane;
	
}




// FUNKCE PRO ODSTRANENI CHYBNE INTERPRETOVANYCH ZNAKU Z NAZVU SOUBORU
function bezpecny_nazev_souboru($retezec) {
  
  $prevod_diakritika_tab = Array( 'ä'=>'a',  'Ä'=>'A',  'á'=>'a',  'Á'=>'A',  'à'=>'a',  'À'=>'A',  'ã'=>'a',  'Ã'=>'A',  'â'=>'a',  'Â'=>'A',  'č'=>'c',  'Č'=>'C',  'ć'=>'c',  'Ć'=>'C',  'ď'=>'d',  'Ď'=>'D',  'ě'=>'e',  'Ě'=>'E',  'é'=>'e',  'É'=>'E',  'ë'=>'e',  'Ë'=>'E',  'è'=>'e',  'È'=>'E',  'ê'=>'e',  'Ê'=>'E',  'í'=>'i',  'Í'=>'I',  'ï'=>'i',  'Ï'=>'I',  'ì'=>'i',  'Ì'=>'I',  'î'=>'i',  'Î'=>'I',  'ľ'=>'l',  'Ľ'=>'L',  'ĺ'=>'l',  'Ĺ'=>'L',  'ń'=>'n',  'Ń'=>'N',  'ň'=>'n',  'Ň'=>'N',  'ñ'=>'n',  'Ñ'=>'N',  'ó'=>'o',  'Ó'=>'O',  'ö'=>'o',  'Ö'=>'O',  'ô'=>'o',  'Ô'=>'O',  'ò'=>'o',  'Ò'=>'O',  'õ'=>'o',  'Õ'=>'O',  'ő'=>'o',  'Ő'=>'O',  'ř'=>'r',  'Ř'=>'R',  'ŕ'=>'r',  'Ŕ'=>'R',  'š'=>'s',  'Š'=>'S',  'ś'=>'s',  'Ś'=>'S',  'ť'=>'t',  'Ť'=>'T',  'ú'=>'u',  'Ú'=>'U',  'ů'=>'u',  'Ů'=>'U',  'ü'=>'u',  'Ü'=>'U',  'ù'=>'u',  'Ù'=>'U',  'ũ'=>'u',  'Ũ'=>'U',  'û'=>'u',  'Û'=>'U',  'ý'=>'y',  'Ý'=>'Y',  'ž'=>'z',  'Ž'=>'Z',  'ź'=>'z',  'Ź'=>'Z');
  $retezec = strtr($retezec, $prevod_diakritika_tab);             // odstraneni diakritiky                            
  
  $max_delka_nazvu_souboru = 128;
                                                                                                                                                 
  $retezec = substr($retezec, 0, $max_delka_nazvu_souboru);       // zkraceni na max. mozny pocet znaku  
  
  $retezec = str_replace("#", "No.", $retezec);                 
  $retezec = str_replace("$", "Dollar", $retezec);                             
  $retezec = str_replace("&", " a ", $retezec);
  
  // ostraneni zakazanych a jinych problemovych znaku z retezce
  $zakazane = Array('/'=>'', '*'=>'', '?'=>'', '|'=>'', '<'=>'', '>'=>'', '"'=>'', '^'=>'', '–'=>'-' );
  $retezec = strtr($retezec , $zakazane);     
                                                           
  return $retezec;
                                                           
}


// FUNKCE PRO UPRAVU VYPISU VELIKOSTI SOUBORU V PRIMERENYCH JEDNOTKACH
function velikost_vypis($velikost) {

  $velikost = (int)$velikost;

  if ($velikost<=100) {
  
    $velikost_vypis = $velikost . ' B';
    
  } elseif ($velikost<100000) {
  
    $velikost_vypis = round($velikost/1024, 2) . ' kB';
           
  } elseif ($velikost<1000000000) {
  
    $velikost_vypis = round(($velikost/1024)/1024, 2) . ' MB'; 
      
  } else {
  
    $velikost_vypis = round((($velikost/1024)/1024)/1024, 2) . ' GB';   
    
  }

  return $velikost_vypis; 

}



// FUNKCE PREVOD RETEZCE DO KODOVANI UTF-8
function prevod_do_utf8($retezec='') {

 if (function_exists('mb_convert_encoding')) {
 
  return mb_convert_encoding($retezec, "UTF-8", mb_detect_encoding($retezec, "ISO-8859-2, UTF-8, CP1251, ASCII", true));
  //(poznamka: nefunguji tyto znaky: Ž, ž, Š, š, Ť, ť, dlouha windowsovska pomlcka, samotny hacek)
  
 } else {
 
  return $retezec;
  
 }
    
}


//
// STAZENI VYBRANE MAPY
//
function download_map($nazev) {

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


function authors() {

  $authors = array();
	$authors = db_select('SELECT * from Author');

	return $authors;	
	
}



// returns an headers from an specified XML file
function getHeadersFromMap($file) {
  
  $path = './maps/' . $file;
	$xml = simplexml_load_file($path);

	try {		    
	  $guid = $xml->attributes()->guid;		
	} catch (Exception $e) {	
    echo 'Behem zpracovavani souboru se vyskytla chyba: ',  $e->getMessage(), "\n";
		die();
	}

	$guid         = $xml->attributes()->guid;		
	$name         = $xml->name;		
	$description  = $xml->description;
	$gpscoords    = $xml->gpscoords;
	$author_name  = $xml->author->attributes()->name;
	$author_email = $xml->author->attributes()->email;	
	
	return array($guid,$name,$description,$gpscoords,$author_name,$author_email);

}



// function for update headings.xml with structured headings of maps
function update_headings() {

  $obsahadr = zjisti_obsah_adresare('./maps/');

  if (!empty($obsahadr)) {
		  		
	  for ($i=0; $i < sizeof($obsahadr); $i++) {
	
	    $nazev = $obsahadr[$i]['nazev'];
	  	list($guid,$name,$description,$gpscoords,$author_name,$author_email) = getHeadersFromMap($nazev);
		
			$vypis[$i]['Guid'] = $guid;
      $vypis[$i]['Name'] = $name;
			$vypis[$i]['GpsCoords'] = $gpscoords;
			$vypis[$i]['Description'] = $description;
			$vypis[$i]['AuthorName'] = $author_name;
			$vypis[$i]['AuthorEmail'] = $author_email;
		
		
	  }

		// sort
		$val = array();
		foreach ($vypis as $key => $row) {
			$val[$key] = $row['Name'];
		}
		
		array_multisort($val, SORT_ASC, $vypis);		
				
  } else
	{
	  $vypis = Array();
	}
	
		// to xml
		$xml = new SimpleXMLElement('<?xml version="1.0" encoding="utf-8"?><headers></headers>');
	  $xml->addAttribute('version', '1.0');
	
		foreach ($vypis as $key => $row) {		
						
			$guid = $row['Guid'];					
			$nazev = $row['Name'];	  // htmlentities($row['Name']);	
			$detail = $row['Description'];
			$gps =	$row['GpsCoords'];
      $autor = $row['AuthorName'];
			$autor_email = $row['AuthorEmail'];
			
			// prepare xml			
			$guidnode = $xml->addChild('map');
			$guidnode->addAttribute('guid', $guid);
			$guidnode->addChild('name',$nazev);
			$guidnode->addChild('description',$detail);
			$guidnode->addChild('gpscoords',$gps);
			$autnode = $guidnode->addChild('author');
			$autnode->addAttribute('name',$autor);
			$autnode->addAttribute('email',$autor_email);
							
		}	
		
	$xml->asXML('./headings.xml');

}





?>