<?php


// osetreni odeslani formulare
if ( (array_key_exists('odeslo',$_POST)) && (array_key_exists('prihlaseni',$_POST)) && ($_POST['odeslo']==1) ) {

	 $form_email = htmlspecialchars($_POST['email']);
	 $form_pass = htmlspecialchars($_POST['password']);	 
	 $form_pass_enc = base64_encode($form_pass);	 

	 $chyb = 0;

	if (empty($form_email)) {
		 $chyb++;		
	}
	 
	if (!jemail($form_email)) {
	  $chyb++;		
	}

	if (empty($form_pass_enc)) {
		$chyb++;		
	}
		
	if ($chyb!=0) {
		echo '<span class="errormsg">Přihlašovašovací formulář obsahuje chyby.</span><br /><br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a>';
		die();
	}
		
	$authors = authors();
		
	$uspech = 0;
		
	foreach ($authors as $key => $val) {
		
		$idu = $val['ID'];
		$email = $val['Email'];
		$heslo = $val['Password'];

		if (($form_email==$email) && ($form_pass_enc==$heslo)) {							
			$uspech = 1;
			$id_authored = $val['ID'];
		}		
				
	}

	if ($uspech==1) {
	
				header("Cache-control: private");
			
				session_start();			
				$_SESSION["prihlasen"] = 1;			
				$_SESSION["idu"] = $id_authored;
			 
				header("Location: index.php?p=10");	 
				
	} else {
			
		echo '<span class="errormsg">Přihlašovašovací jméno nebo heslo je nesprávné.</span><br /><br /><a href="javascript:history.back(1)">&lt; &lt; Zpět</a>';
			
	}		
				
} // konec osetreni formulare
	
	
// FORMULAR
function f_login() {

  $obsah = '';	
	$max_velikost_pro_nahrani_MB = 20;
		
  $url = './index.php?p=13';	
  
  $obsah .= '<div style="position: relative; top: -40px;">';	
	$obsah .= '<h3>Přihlásit uživatele</h3>';	
  $obsah .= '<form method="post" action="' . $url . '" enctype="multipart/form-data">';

  $obsah .= '<p>';
	$obsah .= '<br />';
	
	$obsah .= 'Email: <input type="text" name="email" maxlenth="80" size="30" value="" />';	
	$obsah .= '<br /><br />';
	$obsah .= 'Heslo: <input type="password" name="password" maxlenth="50" size="30" value="" />';	

  $obsah .= '<input type="hidden" name="odeslo" value="1" />';	

  $obsah .= '<br /><br /><input type="submit" name="prihlaseni" value="Přihlásit" /></p>';
  $obsah .= '</form>';
  $obsah .= '</div>';
	
	return $obsah;

}   
	
echo f_login();


?>