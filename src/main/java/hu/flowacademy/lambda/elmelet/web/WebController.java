package hu.flowacademy.lambda.elmelet.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * A @RestController kvázi mindig kötelező. Vagy @Controller és @ResponseBody együtteség használod.
 * Ha csak a @Controller-t használod, akkor szerver oldali front-end renderelést hajtana végre és "text/html" típusú
 * választ adna Content-Type-ban.
 *
 * A @RequestMapping-el meg szabályozni tudod, hogy mely request-ekre legyen érvényes az alábbi osztály.
 * Használata javasolt, mert ha ez nincs, akkor egy másik (valamelyik) controllerrel URL alapján akár ütközhet, mert
 * két azonos "/home" és "/home" nem szerepelhet az EGÉSZ alkalmazásban. (Köhöm: úgy is megáll, ha futtatni akarod.)
 *
 * Jellemzően a @RequestMapping-el URL prefix-et szoktunk beállítani class szinten. Lehet mást is, de azzal majd otthon
 * eljátszotok és hogy reagál rá az alkalmazás. :)
 *
 * Vegyük alapértelmezetnek, hogy localhost-on fut és 8080 porton.
 *
 * RequestBody-t csak a: POST, PUT, PATCH tartalmazhat! Ofc, nem kötelező.
 */
@RestController
@RequestMapping("elmelet/web/")
public class WebController {

    /**
     * Ha nincs @[valami]Mapping után paraméter, akkor a HTTP metódus és a prefix lesz az útvonala.
     *
     * GET http://localhost:8080/elmelet/web
     *
     * ResponseEntity-vel TE magad tudod definiálni a válasz mikéntjét.
     * - További "Response Header"-t tudsz konfigurálni. (Van más lehetőségek is erre, de ez az egyik.)
     * - Státusz kódot beállítani. Jellemzően a sűrűn használtakra van metódus is, lásd az alábbi "ok"-ot.
     * Ha kézzel teszed össze, akkor egy úgy nevezett Build patternnel hajtod végre, amire majd hívni kell a .build()-et.
     */
    @GetMapping
    public ResponseEntity<String> getValue() {
        return ResponseEntity.ok("value");
    }

    /**
     * DELETE http://localhost:8080/elmelet/web
     */
    @DeleteMapping
    public void removeValue() {
    }

    /**
     * GET http://localhost:8080/elmelet/web/10
     *
     * Response: 10
     *
     * Értelem szerűen a String lehetne "int"-is. De alábbi metódusoknál lesz visszautalás erre.
     */
    @GetMapping("{id}")
    public String getById(@PathVariable String id) {
        return id;
    }

    /**
     * Ha ez @GetMapping lenne, akkor ötközne az egyel fentebb lévővel!
     *
     * Ha változó neve nem egyezik meg a {}-ban foglaltal, akkor külön kell jelezni.
     * - removeValue(@PathVariable("id") int willBeDeleted)
     * - removeValue(@PathVariable int id)
     *
     * Persze több {xy}-t is elbít.
     */
    @DeleteMapping("{id}")
    public boolean removeValue(@PathVariable("id") int willBeDeleted) {
        return willBeDeleted % 2 == 0;
    }

    /**
     * FIGYELEM! Ha getById feletti "{id}"-val NEM fog ütközni. Igaz, az is String-et nyer ki és a
     * GET http://localhost:8080/elmelet/web/page hívásra is illeszkedik, de NEM FOG ÜTKÖZNI!!!
     * Mert, mivel itt be lett állítva a "page" így ez kitüntetett szereplő, azaz:
     *
     * GET http://localhost:8080/elmelet/web/page => ez fog lefutni
     * GET http://localhost:8080/elmelet/web/alma => getById fog lefutni
     * GET http://localhost:8080/elmelet/web/10 => getById fog lefutni
     */
    @GetMapping("page")
    public String getById() {
        return "page";
    }

    /**
     * A @RequestBody-val jelzed, hogy beérkező JSON-t szeretnél feldolgozni.
     * A @Valid-al meg jelzed, hogy van tartalmi ellenőrzési igényed.
     *
     * A @ResponseStatus válasz kódot tudod megadni.
     * - Paraméter nélkül HTTP500 (Internal Server Error)
     * - Ha nincs is ilyen annotáció: HTTP200 (OK)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void postMapping(@RequestBody @Valid DataModel model) {
    }

    /**
     * Minden kérésnek van header-je, ami alapvető vagy egyénileg konfigurált információt közvetít.
     * Annak kinyerésére szolgál.
     */
    @GetMapping("header")
    public String header(@RequestHeader("host") String h) {
        return h; // Response: "localhost:8080"
    }

    /**
     * GET http://localhost:8080/elmelet/web/query?foo=xxx&bar=yyy
     *
     * Persze a paraméter sorrend nem számít, de ez igaz a többi annotációra is.
     */
    @GetMapping("query")
    public String query(@RequestParam String foo, @RequestParam("bar") String asd) {
        return foo + asd; // Response: "xxxyyy"
    }
}
