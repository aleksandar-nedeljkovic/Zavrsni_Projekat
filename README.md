# Zavrsni_Projekat
 IT Bootcamp
Završni rad

Kreirati program koji vrši procesiranje knjiga i izvlači metriku različitog tipa. Program realizovati kao sistem klasa u kome su osnovne klase detaljnije opisane u nastavku.

Klasa Rečnik u sebi sadrži podatake na osnovu tabele Rečnik iz SQLite baze podataka. Tabela je napravljena tako da pored imena sadrži informacije detaljnoj definiciji date reči.

Кlasa Knjiga modeluje jednu knjigu koju program koristi u obradi. Sadržaj svake knjige nalazi se u jedinstvenom tekstualnom fajlu. 

Od neophodne statističke obrade realizovati: 
-	Mogućnost da se pronađu i zapamte sve reči koje postoje u knjizi, a ne nalaze se u rečniku. Bazu proširiti novom tabelom koja će se korisiti za potrebe čuvanja novih reči koje se ne nalaze u inicijalnoj tabeli u cilju potencijalnog usavršavanja postojećeg rečnika.
-	Za svaku reč koja se nalazi u rečniku pronaći koliko puta se u knjizi pojavljuje
-	Pronaći 20 najčešće korišćenih reči
-	Upisati u fajl sve reči koje su i poznate i nove u tekstualni fajl ali tako da budu leksikografski sortirane.
