package umc.hackathon.theeasy.contest.domain;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
@Getter
public class LocationInfo {

    @Column(name = "latitude")
    private Double latitude;
    @Column(name = "longitude")
    private Double longitude;
    @Column(name = "region")
    private String address;
    @Enumerated(EnumType.STRING)
    @Column(name = "location_type")
    private LocationType locationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nation_id")
    private Nation nation;

    @Builder
    public LocationInfo(String address, Double latitude, Double longitude, LocationType locationType) {
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationType = locationType;
    }
}
