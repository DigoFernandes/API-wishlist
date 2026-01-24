package rodrigo.ucsal.dev.apiwishlist.service;

import org.springframework.stereotype.Service;
import rodrigo.ucsal.dev.apiwishlist.entity.Wishlist;
import rodrigo.ucsal.dev.apiwishlist.repository.WishlistRepository;


@Service
public class WishlistService {

    private final WishlistRepository repository;

    public WishlistService(WishlistRepository repository) {
        this.repository = repository;
    }

    public void adicionarProduto(String clienteId, String produtoId){
        Wishlist wishlist = repository.findByClienteId(clienteId)
                .orElse(new Wishlist(clienteId));

        if (wishlist.getProdutos().size() >= 20) {

        throw new IllegalStateException("Limite de 20 produtos atingidos na wishlist");
        }

        wishlist.getProdutos().add(produtoId);
        repository.save(wishlist);
    }

    public void removerProduto(String clienteId, String produtoId){
        repository.findByClienteId(clienteId).ifPresent(wishlist -> {{
        wishlist.getProdutos().remove(produtoId);
        repository.save(wishlist);}
        });
    }
}
