package umc.hackathon.theeasy.contest.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.hackathon.theeasy.contest.application.dto.*;
import umc.hackathon.theeasy.contest.domain.ContestRespository;
import umc.hackathon.theeasy.contest.domain.LocationType;
import umc.hackathon.theeasy.contest.domain.contest.Contest;
import umc.hackathon.theeasy.contest.domain.contest.ContestType;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ContestService {

    private final ContestRespository contestRespository;
    private final ContestDtoConverter contestDtoConverter;

    public List<ContestsInfoDto> findContests() {
        List<Contest> contests = contestRespository.findContestsSortedByDate();
        return contestDtoConverter.convertToInfoDtos(contests);
    }

    public List<SearchedContestsInfoDto> findContestsByCategory(Long categoryId, String contestType, Long locationInfoId) {
        List<Contest> contests = contestRespository.findContestsByCategory(categoryId, ContestType.of(contestType), LocationType.of(locationInfoId));
        return contestDtoConverter.convertToSearchedInfoDtos(contests);
    }

    public ContestDetailsInfo findContestById(Long contestId) throws Exception {
        Contest contest = contestRespository.findContestById(contestId)
                .orElseThrow(() -> new Exception("cannot find Contest"));
        return new ContestDetailsInfo(contest);
    }

    public List<RankedContestInfo> findContestRankedByViews() {
        List<Contest> contests = contestRespository.findContestsSortedByViews();
        return contestDtoConverter.convertToRankedInfos(contests);
    }

    public List<RankedContestInfo> findContestRankedByCategory(Long categoryId) {
        List<Contest> contests = contestRespository.findContestRankedByCategory(categoryId);
        return contestDtoConverter.convertToRankedInfos(contests);
    }

    public List<ContestsInfoDto> findContestsByName(String name) {
        List<Contest> contests = contestRespository.findContestsByTitle(name);
        return contestDtoConverter.convertToInfoDtos(contests);
    }
}
