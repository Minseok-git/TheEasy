package umc.hackathon.theeasy.contest.infra.dto;

import com.google.firebase.database.annotations.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ContestByCategoryDto {
    @NotNull
    Long categoryId;
    @NotNull
    String contestType;
    @NotNull
    Long locationId;
}
