package umc.hackathon.theeasy.contest.application.dto;


import lombok.Data;
import umc.hackathon.theeasy.contest.domain.contest.Contest;

@Data
public class ContestDetailsInfo {
    private ContestsInfoDto contestsInfoDto;
    private String content;  //상세 정보
    private String hyperLink;   //하이퍼링크
    private int cost;   //등록 비용
    private String notice; // 주의사항

    public ContestDetailsInfo(Contest contest) {
        this.contestsInfoDto = new ContestsInfoDto(contest);
        this.content = contest.getContestInfo().getContent();
        this.hyperLink = contest.getContestInfo().getHyperlink();
        this.cost = contest.getContestInfo().getCost();
        this.notice = contest.getContestInfo().getNotice();
    }
}

