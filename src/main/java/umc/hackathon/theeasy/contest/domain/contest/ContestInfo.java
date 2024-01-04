package umc.hackathon.theeasy.contest.domain.contest;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
public class ContestInfo {

    @Column(name = "qualificatoin")
    private String qualification;
    @Column(name = "cost")
    private int cost;
    @Column(name = "content")
    private String content;
    @Column(name = "hyperlink")
    private String hyperlink;
    @Column(name = "notice")
    private String notice;

    @Builder
    public ContestInfo(String qualification, int cost, String content, String hyperlink, String detailInfo) {
        this.qualification = qualification;
        this.cost = cost;
        this.content = content;
        this.hyperlink = hyperlink;
        this.notice = detailInfo;
    }
}
