4. Készíts egy listát a PracticeController-ba ami egy olyan új osztályt[Log] tárol el, ami tartalmazza a /hull request body-ját és a response-át, ezen kívül az aktuális időpontot[timestamp] is.
      Módosítsd úgy az előző endpointot, hogy minden request-response párost eltárol a listában.

- 4.1.    Legyen egy GET /logs endpoint ami visszaadja a lista teljes tartalmát időrendi sorrenben.
- 4.2.    Legyen egy GET /log/{​​​​​kind}​​​​​ ami path variable-ben megkap egy kind-ot és visszaadja azokat a logokat amik requestje ilyennel rendelkezik.
- 4.3.    Alakítsd át úgy a GET /logs endpointot, hogy headerben megkaphat egy idő intervallumot ami között kilistázza az összes logot. Az idő intervallumra kelleni fog egy külön osztály ami egy start és end date-et tartalmaz.
- 4.4.    Alakítsd át úgy a GET /logs endpointot, hogy Request paramban megkap egy limit értéket, ami nem kötelező. Ha adott, akkor csak az első limit darab elemet adja vissza, ha nincs, akkor az összeset.
- 4.5.    Legyen egy DELETE /log endpoint ami headerben várja a korábban is használt idő intervallumot. Ebben az intervallumban lévő elemeket töröljük a listából.