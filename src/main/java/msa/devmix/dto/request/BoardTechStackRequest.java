package msa.devmix.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import msa.devmix.dto.BoardTechStackDto;

@Data
@AllArgsConstructor
public class BoardTechStackRequest {

    @NotNull
    private String techStackName;

    public BoardTechStackDto toDto() {
        return BoardTechStackDto.of(techStackName, null);
    }

}
