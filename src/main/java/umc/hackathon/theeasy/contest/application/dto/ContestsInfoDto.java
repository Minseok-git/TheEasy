package umc.hackathon.theeasy.contest.application.dto;

import lombok.Data;
import umc.hackathon.theeasy.contest.domain.contest.Contest;

@Data
public class ContestsInfoDto {

    private Long contestId;
    private String name;
    private String categoryName;
    private String locationType;
    private String contestType;
    private NationInfo nationInfo;
    private String period;
    private String imgUrl;

    public ContestsInfoDto(Contest contest) {
        this.contestId = contest.getId();
        this.name = contest.getName();
        this.categoryName = contest.getCategoryName();
        this.locationType = contest.getLocationTypeInfo();
        this.contestType = contest.getContestType().getType();
        this.nationInfo = new NationInfo(contest.getNationInfo());
        this.period = contest.getPeriod();
        this.imgUrl = contest.getImageUrl();
    }
}
