package rodrigo.ucsal.dev.apiwishlist.service;

import org.springframework.stereotype.Service;
import rodrigo.ucsal.dev.apiwishlist.dto.AdicionarProdutoRequest;
import rodrigo.ucsal.dev.apiwishlist.entity.Wishlist;
import rodrigo.ucsal.dev.apiwishlist.repository.WishlistRepository;


@Service
public class WishlistService {

    private final WishlistRepository repository;

    public WishlistService(WishlistRepository repository) {
        this.repository = repository;
    }

    public void adicionarProduto(String clienteId, AdicionarProdutoRequest request) {
        Wishlist wishlist = repository.findByClienteId(clienteId)
                .orElse(new Wishlist(clienteId));

        wishlist.addProduto(request.produtoId());
        repository.save(wishlist);
    }

    public void removerProduto(String clienteId, String produtoId) {
        Wishlist wishlist = repository.findByClienteId(clienteId).orElseThrow(() -> new RuntimeException());
        wishlist.removeProduto(produtoId);
        repository.save(wishlist);
    }
}
