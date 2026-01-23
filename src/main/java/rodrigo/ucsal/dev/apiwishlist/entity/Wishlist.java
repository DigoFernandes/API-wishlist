package rodrigo.ucsal.dev.apiwishlist.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "wishlist")
public class Wishlist {

    @Id
    private String id;
    private String clienteId;
    private Set<String> produtos = new HashSet<>();


    public Wishlist(String clienteId) {
        this.clienteId = clienteId;
    }

}
