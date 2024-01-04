package umc.hackathon.theeasy.contest.domain;

import umc.hackathon.theeasy.contest.domain.contest.Contest;
import umc.hackathon.theeasy.contest.domain.contest.ContestType;

import java.util.List;
import java.util.Optional;

public interface ContestRespository {
    // 전체 조회
    List<Contest> findContestsSortedByDate();

    // 카테고리별 컨퍼런스 조회
    List<Contest> findContestsByCategory(Long categoryId, ContestType contestType, LocationType locationType);

    // 상세 조회
    Optional<Contest> findContestById(Long contestId);

    // 컨퍼런스 조회 - 이름
    List<Contest> findContestsByTitle(String title);

    // 지역별 위치 정보 조회
    List<Contest> findContestsByRegion(String region);

    // 랭킹 조회 - 조회수
    List<Contest> findContestsSortedByViews();

    // 랭킹 조회 - 분야별
    List<Contest> findContestRankedByCategory(Long categoryId);
}
