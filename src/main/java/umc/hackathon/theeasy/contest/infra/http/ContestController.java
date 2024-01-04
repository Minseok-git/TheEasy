package umc.hackathon.theeasy.contest.infra.http;

import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.hackathon.theeasy.contest.application.ContestService;
import umc.hackathon.theeasy.contest.application.dto.ContestDetailsInfo;
import umc.hackathon.theeasy.contest.application.dto.ContestsInfoDto;
import umc.hackathon.theeasy.contest.application.dto.RankedContestInfo;
import umc.hackathon.theeasy.contest.application.dto.SearchedContestsInfoDto;
import umc.hackathon.theeasy.contest.infra.dto.ContestByCategoryDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contest")
@RequiredArgsConstructor
public class ContestController {

    private final ContestService contestService;

    @GetMapping("")
    public List<ContestsInfoDto> getMainContests() {
        return contestService.findContests();
    }

    @GetMapping("/category")
    public List<SearchedContestsInfoDto> getContestByCategory(@Validated @ModelAttribute ContestByCategoryDto contestByCategoryDto) {
        return contestService.findContestsByCategory(contestByCategoryDto.getCategoryId(), contestByCategoryDto.getContestType(), contestByCategoryDto.getLocationId());
    }

    @GetMapping("/{contestId}")
    public ContestDetailsInfo getContestById(@PathVariable Long contestId) throws Exception {
        return contestService.findContestById(contestId);
    }


    @GetMapping("/rank")
    public List<RankedContestInfo> getRankedContests() {
        return contestService.findContestRankedByViews();
    }

    @GetMapping("/list")
    public List<ContestsInfoDto> findContestByName(@RequestParam String name){
        return contestService.findContestsByName(name);
    }

    @GetMapping("{categoryId}/rank")
    public List<RankedContestInfo> getRankedContestsByCategory(@PathVariable Long categoryId) {
        return contestService.findContestRankedByCategory(categoryId);
    }
}
