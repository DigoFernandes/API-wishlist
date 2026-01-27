package rodrigo.ucsal.dev.apiwishlist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AdicionarProdutoRequest(
        @NotBlank
        @Size(min = 1, max = 20, message = "O ID deve ser entre 1 e 20 chars.")
        String produtoId
) {}