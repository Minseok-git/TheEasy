package umc.hackathon.theeasy.contest.domain.contest;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import umc.hackathon.theeasy.common.BaseEntity;
import umc.hackathon.theeasy.contest.domain.Category;
import umc.hackathon.theeasy.contest.domain.Company;
import umc.hackathon.theeasy.contest.domain.LocationInfo;
import umc.hackathon.theeasy.contest.domain.Nation;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Getter
public class Contest extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "img_url")
    private String imageUrl;
    @Enumerated(EnumType.STRING)
    @Column(name = "contest_type")
    private ContestType contestType;
    @Column(name = "views")
    private int views;
    @Column(name = "period")
    private String period;
    @Embedded
    private LocationInfo locationInfo;
    @Embedded
    private ContestInfo contestInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Builder
    public Contest(String name, String imageUrl, String contestType, String period, LocationInfo locationInfo, ContestInfo contestInfo) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.contestType = ContestType.of(contestType);
        this.period = period;
        this.views = 0;
        this.locationInfo = locationInfo;
        this.contestInfo = contestInfo;
    }

    public String getCategoryName() {
        return category.getName();
    }

    public String getLocationTypeInfo() {
        return locationInfo.getLocationType().toString();
    }

    public Nation getNationInfo() {
        return locationInfo.getNation();
    }
}
