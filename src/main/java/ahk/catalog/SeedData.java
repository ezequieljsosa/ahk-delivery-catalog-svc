package ahk.catalog;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/** Carga unos restaurantes de ejemplo si la colección está vacía. */
@Component
public class SeedData implements CommandLineRunner {

    private final RestaurantRepository repository;

    public SeedData(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) {
        if (repository.count() > 0) {
            return;
        }
        repository.saveAll(
                List.of(
                        new Restaurant(
                                "rest-pizza",
                                "Pizzería Don Luigi",
                                -34.603,
                                -58.381,
                                15,
                                List.of(
                                        new MenuItem("PIZZA-MUZA", "Pizza muzzarella", 9000),
                                        new MenuItem("PIZZA-FUGA", "Pizza fugazzeta", 11000),
                                        new MenuItem("EMP-CARNE", "Empanada de carne", 1800))),
                        new Restaurant(
                                "rest-sushi",
                                "Sushi Kenzo",
                                -34.590,
                                -58.400,
                                25,
                                List.of(
                                        new MenuItem("SUSHI-12", "Combo 12 piezas", 14000),
                                        new MenuItem("SUSHI-24", "Combo 24 piezas", 26000))),
                        new Restaurant(
                                "rest-parrilla",
                                "Parrilla El Gaucho",
                                -34.615,
                                -58.370,
                                30,
                                List.of(
                                        new MenuItem("BIFE", "Bife de chorizo", 16000),
                                        new MenuItem("ASADO", "Tira de asado", 15000),
                                        new MenuItem("PROV", "Provoleta", 6000)))));
    }
}
