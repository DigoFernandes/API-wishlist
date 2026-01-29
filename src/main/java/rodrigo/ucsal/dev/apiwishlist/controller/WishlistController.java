package rodrigo.ucsal.dev.apiwishlist.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rodrigo.ucsal.dev.apiwishlist.dto.AdicionarProdutoRequest;
import rodrigo.ucsal.dev.apiwishlist.dto.ListarProdutosResponse;
import rodrigo.ucsal.dev.apiwishlist.service.WishlistService;
import rodrigo.ucsal.dev.apiwishlist.dto.RemoverProdutoRequest;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    private final WishlistService wishlistService;

    public WishlistController(WishlistService wishlistService) {
        this.wishlistService = wishlistService;
    }


    @PostMapping("/{clienteId}/produtos")
    public ResponseEntity<Void> adicionarProduto(
            @PathVariable String clienteId,
            @RequestBody @Valid AdicionarProdutoRequest request //
    ) {
        wishlistService.adicionarProduto(clienteId, request);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/{clienteId}/produtos/{produtoId}")
    public ResponseEntity<Void> removerProduto(
            @PathVariable String clienteId,
            @RequestBody @Valid RemoverProdutoRequest request) {
        wishlistService.removerProduto(clienteId, request.produtoId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{clienteId}/produtos")
    public ResponseEntity<ListarProdutosResponse> listarProdutos(@PathVariable String clienteId) {
        ListarProdutosResponse response = wishlistService.listarProdutos(clienteId);
        return ResponseEntity.ok(response);
    }
}