package umc.hackathon.theeasy.contest.domain;

public enum LocationType {
        OVERSEAS,
        DOMESTIC,
        ONLINE,
    ;
    public static LocationType of(Long locationTypeId) {
        if (locationTypeId == 0) {
            return OVERSEAS;
        } else if (locationTypeId == 1) {
            return DOMESTIC;
        } else {
            return ONLINE;
        }
    }
}
