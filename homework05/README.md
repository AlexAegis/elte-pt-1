
Készítsünk osztálydiagrammot és implementáljuk a következő feladatot.  

Készítsünk egy programot különböző típusú bankszámlák kezelésére.  
Az alap bankszámla osztály neve legyen: BankAccount. Az osztály legyen absztrakt. A kezdeti egyenleg mindig 0 forint.  

A bankszámlák egyenlegét lehessen módosítani (befizetés, pénzfelvétel) és lekérdezni, tartsuk számon a számla történetét: egy listában tároljuk a történet bejegyzéseket (HistoryEntry), amelyek tartalmazzák az egyenleg változás irányát (befizetés, vagy pénzfelvétel történt), az egyenleg változás mértékét és a módosítás dátumát.  


A számlatörténet lehessen lekérdezni a List<Integer> getHistory() metódussal, a visszaadott listát ne lehessen módosítani.  
A számlának legyen egy azonosítószáma és ehhez egy getter: getAccountNumber  

Számlatípusok:  

*   Megtakarítási számla SavingsAccount

*   Attribútumai: Kamat — interest
*   Megtakarítási számla nem mehet mínuszba.

*   Normál számla NormalAccount

*   Attribútumai: Hitelkeret overdraftLimit — maximum ennyivel mehet 0 alá az egyenleg.

Teszteléshez hozzunk létre egy Bank osztályt, amelyben legyen egy lista néhány számlával. Továbbá legyen egy `update` metódus a Bank osztályban, ami minden megtakarítási számla egyenlegét megnöveli a kamattal, illetve kilistázza a negatív egyenlegű normál számlákat.  

Hozzunk létre egy metódust, amely kiírja az 5 legtöbbször módosított bankszámla azonosítóját és egyenlegét, egyenlegük szerint csökkenő sorrendben.