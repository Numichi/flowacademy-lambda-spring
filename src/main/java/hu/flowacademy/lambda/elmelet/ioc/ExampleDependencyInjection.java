package hu.flowacademy.lambda.elmelet.ioc;

import hu.flowacademy.lambda.elmelet.ioc.source.Bean3;
import hu.flowacademy.lambda.elmelet.ioc.source.BeanInterface;
import hu.flowacademy.lambda.elmelet.ioc.source.BeanInterface3;
import hu.flowacademy.lambda.elmelet.ioc.source.ExampleService;
import hu.flowacademy.lambda.elmelet.ioc.source.package1.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * NEM szerkezet helyesen alkottam meg a class-t, mert található attribútúm a metórusok alatt!
 *
 * IntelliJ az attributumos @Autowire-re a következőt írja: "Field injection is not recommended".
 * Nem ajánlja, de ez nem azt jelenti, hogy nem is működik. (Konstruktoros a preferált.)
 */
@Component
public class ExampleDependencyInjection {

    // Konstruktor miatt lehet final
    private final ExampleService exampe1;

    // Ez nem!
    private BeanInterface3 exampe2;

    /**
     * Az @Autowire helyett, lehetséges a konstruktorban is meglehet adni az adott
     * szolgáltatás vagy componens függőségeit.
     *
     * Függőség alatt azt értjük, hogy az itt definiált funkcióknak szükségük van
     * más külső funkciókra. Pl. React-ban is egyszerűbb úgy XHR/AJAX/REST hívást csinálni
     * ha Axios-t használsz. Ott az Axios-t tekinthetjük függőségnek. :)
     *
     * Alapvetően típusként hivatkozunk a függőségre, hogy nekünk ez a típusú objektum kell.
     */
    public ExampleDependencyInjection(ExampleService exampleService) {
        this.exampe1 = exampleService;
    }

    /**
     * Lehetséges setter-ként is, de veszélye, hogy más is meghívhatja!
     * Ha típusnak interfészt adunk meg és csak egy implementációja van, akkor azt fogja behúzni.
     * Ofc, ez a logika működik az @Autowire mind 3 típusánál!!!
     *
     * @see BeanInterface3
     * @see Bean3
     */
    @Autowired
    public void setBean3(BeanInterface3 interface3) {
        exampe2 = interface3; // Bean3 példánya BeanInterface3 típussal.
    }

    /**
     * Előző metórushoz hasonló, de most konkrétan a "class" típusra hivatkozok.
     *
     * Megjegyzés: Azért nem panaszkodik ugyanazon metódus névre, mert MÁS a paraméter típusa, így eldönthető a hívandó metódus.
     */
    @Autowired
    public void setBean3(Bean3 interface3) {
        exampe2 = interface3;
    }

    /**
     * Az @Autowire attribútúm módszere. ()
     */
    @Autowired
    private BeanInterface3 exampe3;

    /**
     * Ha megnézzük a BeanInterface-t, 2 implementációja van. A "Bean1" és a "Bean2", ami az "ExampleBeans"-ben
     * kerültek konfigurálásra.
     *
     * A "BeanInterface3" az ellentétben a "BeanInterface"-nek több megvalósítása van, így nem eldönthető melyre van szükség.
     * Ezért a @Qualifier annotációval pontosítunk.
     *
     * Bean konfiguráció esetén a metódus neve lesz a bean neve! Ezért "almafa".
     *
     * setter van konstruktor esetén így nézne ki: methodName(@Qualifier("almafa") BeanInterface beanInterface)
     *
     * @see hu.flowacademy.lambda.elmelet.ioc.source.ExampleBeans
     * @see hu.flowacademy.lambda.elmelet.ioc.source.BeanInterface
     * @see hu.flowacademy.lambda.elmelet.ioc.source.Bean1
     * @see hu.flowacademy.lambda.elmelet.ioc.source.Bean2
     */
    @Qualifier("almafa")
    @Autowired
    private BeanInterface exampe4;

    /**
     * Hasonló okból, mikor rendes class nevek egyeznek meg, úgy ötközés törénhet.
     * BlockService -> "blockService" lesz a bean név. Így átnevezés szükséges, amit az adott class-ban látható.
     *
     * Miért nem szükséges a @Qualifier?
     * Lásd e fájl 7-ik sorát ==> import hu.flowacademy.lambda.elmelet.ioc.source.package1.BlockService;
     * Tehát eldönthető, melyikre van szükség. Azon a class-on meg szerepel, hogy ő milyen néven fut az IoC-ban.
     *
     * @see hu.flowacademy.lambda.elmelet.ioc.source.package1.BlockService
     * @see hu.flowacademy.lambda.elmelet.ioc.source.package2.BlockService
     */
    @Autowired
    public BlockService exampe5; // Ő lesz: hu.flowacademy.lambda.elmelet.ioc.source.package1.BlockService
}
