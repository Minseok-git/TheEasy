package umc.hackathon.theeasy.contest.infra;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.hackathon.theeasy.contest.domain.ContestRespository;
import umc.hackathon.theeasy.contest.domain.LocationType;
import umc.hackathon.theeasy.contest.domain.contest.Contest;
import umc.hackathon.theeasy.contest.domain.contest.ContestType;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ContestJpaRepository implements ContestRespository {

    private final EntityManager em;

    // 최신순 전체 조회(6개)
    @Override
    public List<Contest> findContestsSortedByDate() {

        return em.createQuery(
                "select c from Contest c" +
                        " join fetch c.category ct" +
                        " join fetch c.locationInfo.nation n" +
                        " order by c.createdAt desc", Contest.class
        )
                .setMaxResults(6)
                .getResultList();
    }

    // 카테고리별 조회
    @Override
    public List<Contest> findContestsByCategory(Long categoryId, ContestType contestType, LocationType locationType) {

        return em.createQuery(
                        "select c from Contest c" +
                                " join fetch c.category ct" +
                                " join fetch c.locationInfo.nation n" +
                                " where ct.id = :categoryId" +
                                " and c.contestType = :contestType" +
                                " and c.locationInfo.locationType = :locationType", Contest.class
                )
                .setParameter("categoryId", categoryId)
                .setParameter("contestType", contestType)
                .setParameter("locationType", locationType)
                .setMaxResults(6)
                .getResultList();
    }

    // 상세 조회
    @Override
    public Optional<Contest> findContestById(Long contestId) {

        List<Contest> contests = em.createQuery(
                "select c from Contest c" +
                        " join fetch c.category ct" +
                        " join fetch c.locationInfo.nation n" +
                        " where c.id = :contestId", Contest.class
        )
                .setParameter("contestId", contestId)
                .getResultList();

        return contests.stream().findAny();
    }

    @Override
    public List<Contest> findContestsByTitle(String title) {
        return em.createQuery(
                        "select c from Contest c" +
                                " join fetch c.category ct" +
                                " join fetch c.locationInfo.nation n" +
                                " where c.name like :title" +
                                " order by c.createdAt desc", Contest.class
                )
                .setParameter("title", "%" + title + "%")
                .setMaxResults(6)
                .getResultList();
    }

    @Override
    public List<Contest> findContestsByRegion(String region) {
        return null;
    }

    // 조회수별 랭킹
    @Override
    public List<Contest> findContestsSortedByViews() {
        return em.createQuery(
                        "select c from Contest c" +
                                " join fetch c.category ct" +
                                " join fetch c.locationInfo.nation n" +
                                " order by c.views desc", Contest.class
                )
                .setMaxResults(5)
                .getResultList();
    }

    // 카테고리별 랭킹
    @Override
    public List<Contest> findContestRankedByCategory(Long categoryId) {
        return em.createQuery(
                        "select c from Contest c" +
                                " join fetch c.category ct" +
                                " join fetch c.locationInfo.nation n" +
                                " where ct.id = :categoryId" +
                                " order by c.views desc", Contest.class
                )
                .setParameter("categoryId", categoryId)
                .setMaxResults(10)
                .getResultList();
    }
}
