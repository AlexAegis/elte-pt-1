# elte-progtech-1

### ELTE Programozási Technológia 1 - 2016/2017-1

Készítsünk osztálydiagrammot és implementáljuk a következő feladatot.
Adott egy iskolai osztály, melybe n tanuló jár és ők m tantárgyat tanulnak.

* Subject, egy egyszerű adattároló osztály a tantárgyaknak.
    * Attribútumai: a tantárgy neve, és a tantárgyra kapott érdemjegy.
    * Műveletei: getter- és setter függvények a tantárgy nevéhez és az érdemjegyhez. Az érdemjegy egy 1 és 5 közötti szám lehet.
* Student nevű osztály a tanulóknak.
    * Attribútumai: a tanuló neve és az általa tanult tantárgyak listája.
    * Műveletei: getter- és setter függvény a tanuló nevéhez. Getter függvény a tanuló átlagának kiszámításához (getAverage). Egy addSubject nevű függvény, mellyel megadható, hogy a tanuló milyen nevű tantárgyból milyen érdemjegyet szerzett.
* A SchoolClass osztály valósítsa meg az iskolai osztályt.
    * Attribútumai: az iskolai osztály neve és az iskolai osztályba járó tanulók listája
    * Műveletei: getter- és setter függvény az iskolai osztály nevéhez. Egy addStudent nevű függvény, mellyel egy tanuló objektum vehető fel az iskolai osztályhoz. Egy getAverages függvény, mely visszaadja az osztály tanulói átlagainak listáját.