<?php
	
$file = './app/guideme_cz.zip';
	
echo '	    <div class="downloadpart">';
						
echo '				<div id="download1">';
		
echo '					<div class="button">';
echo '						<a href="' . $file .'">Download</a>';
echo '					</div>';
					
echo '					<br />';

echo '					ver. 0.0.130, ' . str_replace(',','.',velikost_vypis(filesize($file))) . ', česky';
echo '					<br /><br />';

echo '				</div>';
			

echo '				<div id="download2">';

echo '					<span style="position: relative; left: 28px; top: 1px;">Minimální požadavky</span><br/>';
					
echo '					<ul>';
echo '						<li>Android 2.0 Froyo nebo vyšší verze</li>';
echo '						<li>Alespoň 1.5 MB volné paměti telefonu a volné místo na mapy</li>';
echo '						<li>Dostupné internetové připojení při stahování map</li>';
echo '					</ul>';		
			
echo '				</div>';

echo '      <br /><br /><br /><br />';
								
echo '			</div>';



?>