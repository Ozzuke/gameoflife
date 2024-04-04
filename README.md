# GameOfLife

Tekstipõhine Conway Game of Life terminalis

---

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
