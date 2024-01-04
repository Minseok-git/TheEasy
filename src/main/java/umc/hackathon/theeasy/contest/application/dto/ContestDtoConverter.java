package umc.hackathon.theeasy.contest.application.dto;

import org.springframework.stereotype.Component;
import umc.hackathon.theeasy.contest.domain.contest.Contest;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContestDtoConverter {
    public List<ContestsInfoDto> convertToInfoDtos(List<Contest> contests) {
        List<ContestsInfoDto> contestsInfoDtos = new ArrayList<>();
        for (Contest contest : contests) {
            contestsInfoDtos.add(new ContestsInfoDto(contest));
        }
        return contestsInfoDtos;
    }

    public List<SearchedContestsInfoDto> convertToSearchedInfoDtos(List<Contest> contests) {
        List<SearchedContestsInfoDto> searchedContestsInfoDtos = new ArrayList<>();
        for (Contest contest : contests) {
            searchedContestsInfoDtos.add(new SearchedContestsInfoDto(contest));
        }
        return searchedContestsInfoDtos;
    }

    public List<RankedContestInfo> convertToRankedInfos(List<Contest> contests) {
        List<RankedContestInfo> rankedContestInfos = new ArrayList<>();
        for (Contest contest : contests) {
            rankedContestInfos.add(new RankedContestInfo(contest));
        }
        return rankedContestInfos;
    }
}
