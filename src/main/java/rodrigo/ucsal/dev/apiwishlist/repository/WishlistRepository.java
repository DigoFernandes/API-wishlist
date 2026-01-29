package rodrigo.ucsal.dev.apiwishlist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rodrigo.ucsal.dev.apiwishlist.entity.Wishlist;
import rodrigo.ucsal.dev.apiwishlist.repository.projection.ProdutoView;

import java.util.Optional;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {
    Optional<ProdutoView> findByClienteId(String clienteId);
    Optional<Wishlist> getByClienteId(String clienteId);
    boolean existsByProdutosIdsContaining(String produtoId);

}
