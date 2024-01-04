package umc.hackathon.theeasy.contest.application.dto;

import lombok.Data;
import umc.hackathon.theeasy.contest.domain.contest.Contest;

@Data
public class SearchedContestsInfoDto {

    private Long contestId;
    private String name;
    private NationInfo nationInfo;
    private String period;
    private String imgUrl;

    public SearchedContestsInfoDto(Contest contest) {
        this.contestId = contest.getId();
        this.name = contest.getName();
        this.nationInfo = new NationInfo(contest.getNationInfo());
        this.period = contest.getPeriod();
        this.imgUrl = contest.getImageUrl();
    }
}
