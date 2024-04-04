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
* `FILENAME` - faili nimi, millest lugeda seaded, vaikimisi `settings.txt`

Käsklused:

* `LOAD` - lae seaded failist (toimub automaatselt programmi käivitamisel kuid saab ka käsitsi käivitada peale faili nime muutmist)
* `SAVE` - salvesta seaded faili
* `RANDOM` - genereeri juhuslik algseis

---

## Klassid

siin me kirjeldame klasside funktsionaalsust

### Map

Klass, mis haldab mängulaua olekut ja selle uuendamist.

#### Meetodid

* `Map(int width, int height)` - loob uue mängulaua laiuse ja kõrgusega `width` ja `height`
* `printMap(char aliveChar, char deadChar)` - prindib mängulaua konsooli, kasutades `aliveChar` ja `deadChar` vastavalt elusate ja surnud rakkude märgistamiseks
* `update()` - uuendab mängulaua olekut vastavalt reeglitele
* `fromString(String[] mapStrings)` - loob mängulaua oleku massiivist `mapStrings`
* `nextStep(Map last)` - loob uue mängulaua oleku vastavalt reeglitele ja eelmisele olekule `last`

### Settings

Klass, mis haldab mängu sätteid.

#### Meetodid

* `Settings()` - loob uued sätted vaikimisi väärtustega
* `loadFromFile()` - laeb sätted failist
* `saveToFile()` - salvestab sätted faili
* `changeSetting(String line)` - muudab sätteid vastavalt sisendile
* `listSettings()` - prindib sätted konsooli

---

## Projeḱti tegemise protsess

Projekti tegemise protsessi käigus jagasime tööd kaheks: 
Osvald tegeles mängulaua ja selle uuendamise loomisega, Leo-Martin aga sätete haldamisega. 
Mõlemad töötasid eraldi failides, kuid kasutasid ühist mängulaua klassi. 
Kui mõlemad olid oma osa valmis saanud, ühendasime koodi ja tegime lõplikud parandused.

---

## iga rühma liikme panus (sh tehtud klassid/meetodid) ja ajakulu(orienteeruvalt):

Leo-Martin Pala: Settings klass, Settings meetodid, Settings klassi testid, Settings klassi dokumentatsioon
Osvald Nigola: Map klass, Map meetod

---

## tegemise mured

Mõlemad liikmed olid alguses hõivatud teiste projektidega, mistõttu ei saanud projekti kallal kohe tööd alustada. 
Kui töö alustati, siis oli keeruline leida aega, kus mõlemad saaksid koos töötada. 
Kuna mõlemad liikmed olid algajad Java kasutajad, siis oli keeruline mõista, 
kuidas klassid omavahel suhtlevad ja kuidas neid kasutada. 
Kui klassid olid valmis, siis oli keeruline neid ühendada ja teha lõplikud parandused.

---

## hinnang oma töö lõpptulemusele

Oleme rahul oma töö lõpptulemusega, kuid oleksime tahtnud lisada mängulaua genereerimise juhuslikest väärtustest 
ja mängu salvestamise ja laadimise funktsionaalsuse. Arendamist vajab ka mängu kasutajaliides, mis on praegu väga lihtne.

---
## Testimine

Testimiseks kasutasime JUnit raamistikku. 
Testisime mõlemat klassi eraldi, kasutades erinevaid sisendeid ja kontrollides väljundit. 
Testid olid edukad ja kõik meetodid töötasid ootuspäraselt.