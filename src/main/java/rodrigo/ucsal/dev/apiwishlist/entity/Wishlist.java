package rodrigo.ucsal.dev.apiwishlist.entity;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Getter
@Document(collection = "wishlist")
public class Wishlist {

    @Id
    private String id;
    private String clienteId;
    private Set<String> produtosIds;


    public Wishlist(String clienteId) {
        this.clienteId = clienteId;
        this.produtosIds = new HashSet<>();
    }

    public void addProduto(String produtoId) {
        if (produtosIds.contains(produtoId)) {
            return;
        }
        validarLimiteWishlist();
        this.produtosIds.add(produtoId);
    }

    public void removeProduto(String produtoId) {
        this.produtosIds.remove(produtoId);
    }

    private void validarLimiteWishlist(){
        if (this.produtosIds.size() > 20){
            throw new RuntimeException();
        }
    }
}
