<?php


// prostredi, jazyk, kodovani
date_default_timezone_set('Europe/Prague');
setlocale(LC_ALL, 'cs_CZ.UTF-8');
iconv_set_encoding('internal_encoding', 'UTF-8');
iconv_set_encoding('output_encoding', 'UTF-8');
mb_internal_encoding('utf-8');


// konstanta POUZE_PRO_LADENI
// 1 = stranky jsou v modu ladeni, jsou striktne vypisovany vsechny chyby + dostupne nektere dalsi funkce
// cokoli jineho znamena produknci mod provozu webu, nejsou vypisovana chybova hlaseni 
if (!defined('POUZE_PRO_LADENI')) {define('POUZE_PRO_LADENI', 1);}


// NASTAVENI MODU LADENI 
if (constant("POUZE_PRO_LADENI")==1) {
  
  error_reporting(E_ALL | E_STRICT);
  if (!ini_get('display_errors')) {ini_set('display_errors', 1);}
  
} else {

  error_reporting(0);
  if (!ini_get('display_errors')) {ini_set('display_errors', 0);} 
  
}


// MENU
if (array_key_exists('p', $_GET)) {

  $pg = htmlspecialchars($_GET['p']);	
	
	switch ($pg) {
		case "1"    : $page = "home.php"           ; break;
		case "2"    : $page = "guideme.php"        ; break;
		case "3"    : $page = "download.php"       ; break;
		case "4"    : $page = "maps.php"           ; break;
		case "5"    : $page = "documentation.php"  ; break;
		case "6"    : $page = "about.php"          ; break;
		case "7"    : $page = "policy.php"         ; break;
		case "8"    : $page = "contact.php"        ; break;	
		case "9"    : $page = "addmap.php"         ; break;
		case "10"   : $page = "deletemap.php"      ; break;
		case "11"   : $page = "modifymap.php"      ; break;
		default     : $page = "home.php"           ; break;
	}	
	
} else {

  $page = 'home.php';
	
}

if (!file_exists($page)) {
  $page = "home.php";
}


require_once('app_fce.php');
require_once('head.php');

$dbfile = 'db.php';

if (file_exists($dbfile)) {
  require_once($dbfile);
} else {
  echo 'V projektu chybí skript ' . $dbfile . '<br />Kontaktujte správce webu';
	die();
}



require_once('menu.php');
require_once($page);
require_once('foot.php');


?>