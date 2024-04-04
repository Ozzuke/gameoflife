# GameOfLife

Tekstipõhine Conway Game of Life terminalis

Autorid: Osvald Nigola, Leo-Martin Pala

---

## Kirjeldus

Conway Game of Life on matemaatiline mäng, kus on antud mängulaud, mis koosneb ruutudest, 
millest igaüks võib olla elus või surnud. Mängulaual tekib iga sammuga järgmine põlvkond, 
kus elusad ruudud jäävad ellu, kui neil on 2 või 3 elusat naabrit, muidu surevad. 
Surnud ruudud ärkavad ellu, kui neil on täpselt 3 elusat naabrit. 
Mängu "eesmärk" on leida algseis, mis tekitab huvitavaid mustreid.

## Kasutamine

Kasutamiseks sisesta mängu alguse seis rida haaval.
Mängulaua laius on vaikimisi võrdne pikima sisestatud rea pikkusega ja kõrgus sisestatud ridade arvuga.
Read sisesta ükshaaval, iga rea sisestamise järel vajuta ENTER.
Elusad rakud märgi suvalise tähemärgiga, surnud rakud tühikutega.
Tühja rea sisestamiseks sisesta vähemalt üks tühik ja vajuta ENTER.
Mängu käivitamiseks sisesta tühja rea asemel ainult ENTER.
Mängu lõpetamiseks käimise ajal vajuta ENTER.

Sisendi näide 7x5 mängulaua jaoks, `<E>` märgib ENTER klahvi vajutamist:
```plaintext
   x<E>     - 1
 x xx<E>    - 2
 <E>        - 3
  x  xx<E>  - 4, pikim rea pikkus ehk 7
xx  x<E>    - 5
<E>
```

## Sätted

Mängu seadete muutmiseks kirjuta esimesele reale soovitud sätted kujul `SÄTTENIMI:VÄÄRTUS`.

Muudetavad sätted:

* `FRAMERATE` - mängu värskendussagedus sekundites, vaikimisi `2.5`
* `DEAD_CELL_CHAR` - märk surnud rakkude kuvamiseks, vaikimisi `' '`
* `ALIVE_CELL_CHAR` - märk elusate rakkude kuvamiseks, vaikimis `'█'`
* `WIDTH` - manuaalne mängulaua laius, vaikimisi `0`. Kui `0`, siis laius arvutatakse sisendi põhjal.
* `HEIGHT` - manuaalne mängulaua kõrgus, vaikimisi `0`. Kui `0`, siis kõrgus arvutatakse sisendi põhjal.
* `CHANCE` - elusate rakkude tõenäosus algseisus käsu `RANDOM` puhul, vaikimisi `0.5
* `FILENAME` - faili nimi, millest lugeda seaded, vaikimisi `seaded.txt`

Käsklused:

* `LOAD` - lae seaded failist (toimub automaatselt programmi käivitamisel kuid saab ka käsitsi käivitada peale faili nime muutmist)
* `SAVE` - salvesta seaded faili
* `RANDOM` - genereeri juhuslik algseis

---

## Klassid

Siin on kirjeldatud kasutusel olevaid klasse

### Map

Klass, mis haldab mängulaua olekut ja selle uuenemist. Mängulaud on BitSet, kus iga bit tähistab ühe ruudu olekut.

#### Meetodid

* `Map(int laius, int pikkus)` - loob uue mängulaua laiuse ja kõrgusega `laius` ja `pikkus`
* `printMap(char elusTäht, char surnudTäht)` - väljastab mängulaua oleku loetaval kujul, 
kasutades `elusTäht` ja `surnudTäht` vastavalt elusate ja surnud rakkude märgistamiseks
* `värskenda()` - uuendab mängulaua olekut vastavalt reeglitele
* `olekSõnest(String mapStrings)` - seab mängulaua oleku sõnest
* `nextStep(Map last)` - loob uue mängulaua oleku vastavalt reeglitele ja eelmisele olekule

### Seaded

Klass, mis haldab mängu sätteid.

#### Meetodid

* `Seaded()` - loob uued sätted vaikimisi väärtustega
* `laeFailist()` - laeb sätted failist
* `salvestaFaili()` - salvestab sätted faili
* `muudaSätte(String line)` - muudab sätteid vastavalt sisendile
* `listSeaded()` - prindib sätted

---

## Projeḱti tegemise protsess

Projekti tegime algusest peale kahekesi, kasutades GitHubi versioonihalduseks.
Mõlemad tegelesid mõlema klassi loomise, teistimise ja parandamisega.
Leo keskendus siiski rohkem testimisele, Osvald Ehitamisele.

---

## iga rühma liikme panus (sh tehtud klassid/meetodid) ja ajakulu(orienteeruvalt):

Kõik klassid on koostöös loodud, ajakulu mõlemal liikmel oli ca 10 tundi.

---

## tegemise mured

Ei esinenud suuremaid muresid peale kehva ajaplaneerimise, mistõttu lõpetasime projekti päris viimasel hetkel.

---

## hinnang oma töö lõpptulemusele

Tulemusega võib päris rahul olla, kuid üksikud viimistlused jäid siiski tegemata, kuna ei osanud aega piisavalt hästi planeerida.

---
## Testimine 

Testimiseks lõime Maven projekti, kus kasutasime JUnit 5 raamistikku. Testid on kirjutatud klassidele Map ja Seaded.