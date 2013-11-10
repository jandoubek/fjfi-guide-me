<?php

echo '		<nav>';
		
echo '			<div class="wrapper">';
echo '				<div class="container">';
echo '					<ul class="menu" rel="sam1">';


if (empty($idu)) {

	echo '						<li'; if (((isset($pg))&&($pg=="1"))|| (!isset($pg))) {echo ' class="active"';} echo '><a href="./index.php">Home</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="2")) {echo ' class="active"';} echo '><a href="./index.php?p=2">O projektu</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="3")) {echo ' class="active"';} echo '><a href="./index.php?p=3">Download</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="4")) {echo ' class="active"';} echo '><a href="./index.php?p=4">Mapy</a></li>';
	echo '						<li'; if ((isset($pg))&&($pg=="5")) {echo ' class="active"';} echo '><a href="./index.php?p=5">Dokumentace</a></li>';
	echo '						<li><a href="https://github.com/jandoubek/fjfi-guide-me/wiki" target="_blank" hreflang="cs">Wiki</a></li>';	

} else {  

	echo '<li '; if ((isset($pg))&&($pg=="10")) {echo ' class="active"';} echo '><a href="./index.php?p=10">Správa map</a></li>';	
	echo '<li '; if ((isset($pg))&&($pg=="9")) {echo ' class="active"';} echo '><a href="./index.php?p=9">Přidat mapu</a></li>';	
	echo '<li '; if ((isset($pg))&&($pg=="12")) {echo ' class="active"';} echo '><a href="./index.php?p=12">Profil</a></li>';	
	echo '<li><a href="logout.php">Odhlásit</a></li>';	
	
}

echo '					</ul>';
echo '				</div>';
echo '			</div>';
			
echo '		</nav>';

echo '	</header>';

echo '<article>';

?>