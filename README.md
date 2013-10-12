fjfi-guide-me
=============

**Pár poznámek ke GitHubu:**

Sem do repozitáøe samotného pokud mono pøidávejte opravdu jen vìci, které se tıkají samotného projektu: zdrojáky, dokumentaci, XMLka a takové vìci. Pro návody, loga a všechno co se tıká návrhu projektu by mìlo jít na wiki. Stránky na wiki lze editovat pøímo pøes web, ale bohuel pøes web nejdou pøidat obrázky. Dobrá zpráva je, e wiki má vlastní repozitáø s vlastní adresáøovou strukturou, kam to všechno lze nahrát. Špatná zpráva je, e klient GitHub for Windows neumoòuje pøímı pøístup (adresa repozitáøe má toti pøíponu .wiki.git, a ten klient si neumí poradit s tím, e tam jsou dvì teèky). Dobrá zpráva je, e to jde pøes pøíkazovou øádku. Pokud to tak chcete udìlat, tak se to dìlá takhle:

  - otevøete GitHub for Windows
  - v **local repositories** kliknìte pravım tlaèítkem a vyberte *open a shell here*
  - pomocí `cd` se odposouvejte do adresáøe, kam chcete umístit lokální kopii wiki
  - zadejte `git clone git@github.com:jandoubek/fjfi-guide-me.wiki.git`
  - zavøete konzoli (`exit`) a vrate se do GitHub for Windows
  - v **local repositories** by se mìl objevit novı repozitáø **fjfi-guide-me.wiki**, a máme hotovo