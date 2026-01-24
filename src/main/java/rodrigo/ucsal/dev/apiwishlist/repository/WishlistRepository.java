package rodrigo.ucsal.dev.apiwishlist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rodrigo.ucsal.dev.apiwishlist.entity.Wishlist;

import java.util.Optional;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {
    Optional<Wishlist> findByClienteId(String clienteId);
}
