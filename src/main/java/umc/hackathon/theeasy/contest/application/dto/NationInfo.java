package umc.hackathon.theeasy.contest.application.dto;

import lombok.Data;
import umc.hackathon.theeasy.contest.domain.Nation;

@Data
public class NationInfo {

    String nation;
    String city;

    public NationInfo(Nation nation) {
        this.nation = nation.getName();
        this.city = nation.getCity();
    }
}
