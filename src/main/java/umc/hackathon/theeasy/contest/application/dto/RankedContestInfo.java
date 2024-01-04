package umc.hackathon.theeasy.contest.application.dto;

import lombok.Data;
import umc.hackathon.theeasy.contest.domain.contest.Contest;

@Data
public class RankedContestInfo {

    String name;
    String imgUrl;

    public RankedContestInfo(Contest contest) {
        this.name = contest.getName();
        this.imgUrl = contest.getImageUrl();
    }
}
