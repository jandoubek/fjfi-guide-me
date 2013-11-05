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


?>