package ahk.catalog;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/** Un restaurante con su menú embebido: un único documento en Mongo. */
@Document("restaurants")
public record Restaurant(
        @Id String id, String name, double lat, double lon, int prepMinutes, List<MenuItem> menu) {}
