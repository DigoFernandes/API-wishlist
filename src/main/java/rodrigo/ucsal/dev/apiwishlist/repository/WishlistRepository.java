package rodrigo.ucsal.dev.apiwishlist.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import rodrigo.ucsal.dev.apiwishlist.entity.Wishlist;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {

}
