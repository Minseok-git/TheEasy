package umc.hackathon.theeasy.contest.domain.contest;

import lombok.Getter;

@Getter
public enum ContestType {
    CONFERENCE("컨퍼런스"),
    ACADEMY("학회"),
    ;

    private final String type;

    ContestType(String status) {
        this.type = status;
    }

    public static ContestType of(String contestType) {
        for (ContestType ct : ContestType.values()) {
            if (ct.type.equals(contestType)) {
                return ct;
            }
        }

        return null;
    }
}
