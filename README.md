# GameOfLife

Tekstipõhine Conway Game of Life terminalis

Autorid: Osvald Nigola, Leo-Martin Pala

---

## Kirjeldus

Conway Game of Life on matemaatiline mäng, kus on antud mängulaud, mis koosneb ruutudest, millest igaüks võib olla elus või surnud. Mängulaual toimub iga sammuga järgmine põlvkond, kus elusad ruudud jäävad ellu, kui neil on 2 või 3 elusat naabrit, ja surevad muidu. Surnud ruudud ärkavad ellu, kui neil on täpselt 3 elusat naabrit. Mängu eesmärk on leida algseis, mis tekitab huvitavaid mustreid.

## Kasutamine

Kasutamiseks sisesta mängu alguse seis rida haaval.
Mängulaua laius on võrdne pikima sisestatud rea pikkusega ja kõrgus sisestatud ridade arvuga.
Read sisesta ükshaaval, iga rea sisestamise järel vajuta ENTER.
Elusad rakud märgi suvalise tähemärgiga, surnud rakud tühikutega.
Tühja rea sisestamiseks sisesta vähemalt üks tühik ja vajuta ENTER.
Mängu käivitamiseks sisesta tühja rea asemel ainult ENTER.
Mängu lõpetamiseks käimise ajal vajuta ENTER.

Sisendi näide 7x5 mängulaua jaoks, \<E> märgib ENTER klahvi vajutamist:
```plaintext
   x<E>     - 1
 x xx<E>    - 2
 <E>        - 3
  x  xx<E>  - 4, rea pikkus 7
xx  x<E>    - 5
<E>
```

## Sätted

Mängu sättete muutmiseks kirjuta esimesele reale soovitud sätted kujul `SÄTTENIMI:VÄÄRTUS`.

Muudetavad sätted:

* `FRAMERATE` - mängu värskendussagedus sekundites, vaikimisi `2.5`
* `DEAD_CELL_CHAR` - märk surnud rakkude kuvamiseks, vaikimisi `' '`
* `ALIVE_CELL_CHAR` - märk elusate rakkude kuvamiseks, vaikimis `'█'`
* `WIDTH` - manuaalne mängulaua laius, vaikimisi `0`. Kui `0`, siis laius arvutatakse sisendi põhjal.
* `HEIGHT` - manuaalne mängulaua kõrgus, vaikimisi `0`. Kui `0`, siis kõrgus arvutatakse sisendi põhjal.
* `FILENAME` - faili nimi, millest lugeda seaded, vaikimisi `settings.txt`

Käsklused:

* `LOAD` - lae seaded failist (toimub automaatselt programmi käivitamisel kuid saab ka käsitsi käivitada peale faili nime muutmist)
* `SAVE` - salvesta seaded faili

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

