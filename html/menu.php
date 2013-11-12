<?php

echo '		<nav>';
		
echo '			<div class="wrapper">';
echo '				<div class="container">';
echo '					<ul class="menu" rel="sam1">';


if (empty($idu)) {

	echo '						<li'; if (((isset($pg))&&($pg=="1"))|| (!isset($pg))) {echo ' class="active"';} echo '><a href="uvod">Home</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="2")) {echo ' class="active"';} echo '><a href="o-projektu">O projektu</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="3")) {echo ' class="active"';} echo '><a href="stahnout">Download</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="4")) {echo ' class="active"';} echo '><a href="mapy">Mapy</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="5")) {echo ' class="active"';} echo '><a href="dokumentace">Dokumentace</a></li>';
	echo '						<li><a href="https://github.com/jandoubek/fjfi-guide-me/wiki" target="_blank" hreflang="cs">Wiki</a></li>';	

} else {  

	echo '<li '; if ((isset($pg))&&($pg=="10")) {echo ' class="active"';} echo '><a href="sprava-map">Správa map</a></li>';	
	echo '<li '; if ((isset($pg))&&($pg=="9")) {echo ' class="active"';} echo '><a href="pridat-mapu">Přidat mapu</a></li>';	
	echo '<li '; if ((isset($pg))&&($pg=="12")) {echo ' class="active"';} echo '><a href="profil">Profil</a></li>';	
	echo '<li><a href="logout.php">Odhlásit</a></li>';	
	
}

echo '					</ul>';
echo '				</div>';
echo '			</div>';
			
echo '		</nav>';

echo '	</header>';

echo '<article>';

?>