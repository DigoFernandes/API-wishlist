package rodrigo.ucsal.dev.apiwishlist.service;

import org.springframework.stereotype.Service;
import rodrigo.ucsal.dev.apiwishlist.dto.AdicionarProdutoRequest;
import rodrigo.ucsal.dev.apiwishlist.dto.ListarProdutosResponse;
import rodrigo.ucsal.dev.apiwishlist.entity.Wishlist;
import rodrigo.ucsal.dev.apiwishlist.repository.WishlistRepository;
import rodrigo.ucsal.dev.apiwishlist.repository.projection.ProdutoView;

@Service
public class WishlistService {

    private static final int MAX_PRODUTOS = 20;
    private final WishlistRepository repository;

    public WishlistService(WishlistRepository repository) {
        this.repository = repository;
    }

    public void adicionarProduto(String clienteId, AdicionarProdutoRequest request) {
        Wishlist wishlist = repository.getByClienteId(clienteId)
                .orElse(new Wishlist(clienteId));

        if (wishlist.getProdutosIds().size() >= MAX_PRODUTOS) {
            throw new RuntimeException("Wishlist limit exceeded");
        }

        wishlist.addProduto(request.produtoId());
        repository.save(wishlist);
    }

    public void removerProduto(String clienteId, String produtoId) {
        Wishlist wishlist = repository.getByClienteId(clienteId).orElseThrow(() -> new RuntimeException("Product Not Found in Wishlist"));
        wishlist.removeProduto(produtoId);
        repository.save(wishlist);
    }

    public ListarProdutosResponse listarProdutos(String clienteId) {
        ProdutoView wishlist = repository.findByClienteId(clienteId)
                .orElseThrow(() -> new RuntimeException("Wishlist not found for clienteId: " + clienteId));
        return new ListarProdutosResponse(wishlist.produtosIds());
    }

    public boolean consultarProduto(String produtoId) {

        return repository.existsByProdutosIdsContaining(produtoId);
    }

}
