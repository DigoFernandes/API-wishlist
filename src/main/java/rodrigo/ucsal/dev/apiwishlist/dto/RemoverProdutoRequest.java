package rodrigo.ucsal.dev.apiwishlist.dto;

import jakarta.validation.constraints.NotBlank;

public record RemoverProdutoRequest(
        @NotBlank(message = "O ID do produto é obrigatório")
        String produtoId
) {}