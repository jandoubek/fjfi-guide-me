<?php

echo '<b>Dokumentace k aplikaci guide.me</b>';

echo '<ol>';
echo '  <li><span style="color: navy; cursor: pointer;" onClick="javascript:document.getElementById(\'doc1\').style.display=\'block\'">Stažení a instalace</span></li>';

echo '
<span style="display: none;" id="doc1" onClick="this.style.display=\'none\'"><br />

<br />
• Ověřte, zdali máte telefon se systémem Google Android verze 2.0 nebo vyšší.<br />
<br />
• Stáhněte si aktuální verzi aplikace na stránce <a href="stahnout">Download</a>.<br />
<br />
• Ověřte, jestli máte na telefonu povolenou instalaci aplikací pocházející i z jiných zdrojů, než z Google Play<br />
<br />
&nbsp;&nbsp;&nbsp;Postup: Hlavní menu - Nastavení - Nastavení aplikací - zaškrtnout Neznámé zdroje<br />
&nbsp;&nbsp;&nbsp;(Povoluje instalaci aplikací, které nepocházejí ze služby Market)<br />
<br />
&nbsp;&nbsp;&nbsp;Postup pro anglickou verzi systému Android: Main menu - Settings - Applications - check the checkbox Unknown Sources<br />
&nbsp;&nbsp;&nbsp;(Allow instalation on non-Market applications)<br />
<br />
• Stáhnutý soubor zkopírujte do telefunu (např. pomocí USB kabelu, Wi-fi, Bluetooth).<br />
<br />
• Ve Správci souborů najděte zkopírovaný soubor ve Vašem telefonu (či SD kartě)<br />
<br />
• Tento soubor spusťe pomocí Nástroje pro instalaci balíčků. Instalace bude nainstalována.<br />
<br />
• Spusťte aplikaci<br />
<br />
</span>
';

echo '  <li>Získání a výběr mapy</li>';

echo '  <li>Navigace</li>';

echo '  <li>Nastavení</li>';

echo '  <li>Tvorba vlastních map</li>';

echo '</ol>';

?>