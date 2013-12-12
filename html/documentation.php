<?php

echo '<b>Dokumentace k aplikaci guide.me</b>';

echo '<ol>';

echo '  <li><span style="color: navy; cursor: pointer;" onClick="javascript:document.getElementById(\'doc1\').style.display=\'block\'">Stažení a instalace</span></li>';

echo '
<span style="display: none;" id="doc1" onClick="this.style.display=\'none\'"><br />

<br />
• Ověřte, zdali Vaše zařízení splňuje minimální požadavky. Telefon musí obsahovat operační systém Google Android verze 2.3 (kódové označení Gingerbread) nebo vyšší, mít alespoň 1.5 MB volné paměti telefonu, alespoň 3.3" dotykový displej, volné místo na mapy míst k navigaci a při stahování nových map dostupné internetové připojení.<br />
<br />
• Stáhněte si aktuální verzi aplikace na stránce <a href="stahnout">Download</a>.<br />
<br />
• Ověřte, jestli máte na telefonu povolenou instalaci aplikací pocházející i z jiných zdrojů, než z Google Play.<br />
<br />
&nbsp;&nbsp;&nbsp;Postup: Hlavní menu - Nastavení - Nastavení aplikací - zaškrtnout Neznámé zdroje<br />
&nbsp;&nbsp;&nbsp;(Povoluje instalaci aplikací, které nepocházejí ze služby Market)<br />
<br />
&nbsp;&nbsp;&nbsp;Postup pro anglickou verzi systému Android: Main menu - Settings - Applications - check the checkbox Unknown Sources<br />
&nbsp;&nbsp;&nbsp;(Allow instalation on non-Market applications)<br />
<br />
• Stáhnutý soubor zkopírujte do telefunu (např. pomocí USB kabelu, Wi-fi, Bluetooth).<br />
<br />
• Ve Správci souborů najděte zkopírovaný soubor ve Vašem telefonu (či SD kartě).<br />
<br />
• Tento soubor spusťe pomocí Nástroje pro instalaci balíčků. Instalace bude nainstalována.<br />
<br />
• Spusťte aplikaci GuideME.<br />
<br />
</span>
';


echo '  <li><span style="color: navy; cursor: pointer;" onClick="javascript:document.getElementById(\'doc2\').style.display=\'block\'">První navigace</span></li>';

echo '
<span style="display: none;" id="doc2" onClick="this.style.display=\'none\'"><br />
<br />
• Stikněte tlačítko Navigovat.<br />
<br />
• Nemáte-li zatím staženou žádnou mapu, je nutné stáhnout alespoň jednu mapu pomocí této aplikace.<br />
Ověřte, zdali je zařízení připojené k internetu a stikněte tlačítko Stáhnout mapu.<br />
<br />
</span>
';



echo '  <li><span style="color: navy; cursor: pointer;" onClick="javascript:document.getElementById(\'doc3\').style.display=\'block\'">Získání a výběr mapy</span></li>';

echo '
<span style="display: none;" id="doc3" onClick="this.style.display=\'none\'"><br />
<br />
• Aktuální seznam dostupných map se automaticky načte se serveru.<br />
<br />
• Vyberte ze seznamu mapu, která odpovídá objektu, po kterém chcete navigovat.<br />Můžete použít také fulltextové hledání podle názvu.<br />
<br />
• Vybraná mapa bude stažena ze serveru a bude zobrazena po návratu na obrazovce s výběrem mapy.
<br />
<br />
</span>
';



echo '  <li><span style="color: navy; cursor: pointer;" onClick="javascript:document.getElementById(\'doc4\').style.display=\'block\'">Výběr počátečního a koncového bodu</span></li>';

echo '
<span style="display: none;" id="doc4" onClick="this.style.display=\'none\'"><br />
<br />
• Po výběru mapy je třeba zadat počáteční a koncový bod navigace.<br />
<br />
• Napřed bude zobrazen dialog pro výběr počátečního bodu. Stiknutím názvu bodu jej vyberete. Můžete použít fulltextové vyhledání mezi názvy bodů.<br />
<br />
• Poté bude zobrazen dialog pro výběr koncového bodu. Stiknutím názvu bodu jej vyberete. Můžete použít fulltextové vyhledání mezi názvy bodů.<br />
<br />
• Není možné zadat shodný počáteční a koncový bod. Pokud je tato podmínka splněna, spustí se okno navigace.<br />
<br />
</span>
';



echo '  <li><span style="color: navy; cursor: pointer;" onClick="javascript:document.getElementById(\'doc5\').style.display=\'block\'">Navigace</span></li>';

echo '
<span style="display: none;" id="doc5" onClick="this.style.display=\'none\'"><br />
<br />
• Klikáním na tlačítka Další a Přechozí se přesouváme mezi body, které jsme již reálně prošli.<br />
<br />
• U bodů zobrazován předpokládaný čas, za který dojdeme do dalšího bodu.<br />
<br />
</span>
';


echo '</ol>';


?>