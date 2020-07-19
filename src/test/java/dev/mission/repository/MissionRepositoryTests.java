package dev.mission.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import dev.mission.entite.Mission;

@DataJpaTest
public class MissionRepositoryTests {
	@Autowired
	TestEntityManager entityManager;
	
	@Autowired
	MissionRepository missionRepository;
	
	@Test
	void findByDateDebutGreaterThanEqual() {
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("100"));
		mission.setDateDebut(LocalDate.of(2500, 1, 1));
		mission.setDateFin(LocalDate.of(2500, 1, 2));
		
		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 2");
		mission2.setTauxJournalier(new BigDecimal("100"));
		mission2.setDateDebut(LocalDate.of(1500, 1, 1));
		mission2.setDateFin(LocalDate.of(1500, 1, 2));
		
		entityManager.getEntityManager().persist(mission);
		entityManager.getEntityManager().persist(mission2);
		List<Mission> missions = missionRepository.findMissionByDate();
		assertThat(missions).contains(mission);
		assertThat(missions).doesNotContain(mission2);
	}
	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		//Mission valide
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("100"));
		mission.setDateDebut(LocalDate.of(2500, 1, 1));
		mission.setDateFin(LocalDate.of(2500, 1, 2));
		
		//Mission avec date invalide
		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 2");
		mission2.setTauxJournalier(new BigDecimal("100"));
		mission2.setDateDebut(LocalDate.of(1500, 1, 1));
		mission2.setDateFin(LocalDate.of(1500, 1, 2));
		
		//Mission avec taux journalier invalide
		Mission mission3 = new Mission();
		mission3.setLibelle("Mission 2");
		mission3.setTauxJournalier(new BigDecimal("50"));
		mission3.setDateDebut(LocalDate.of(2500, 1, 1));
		mission3.setDateFin(LocalDate.of(2500, 1, 2));
		
		entityManager.getEntityManager().persist(mission);
		entityManager.getEntityManager().persist(mission2);
		entityManager.getEntityManager().persist(mission3);
		List<Mission> missions = missionRepository.findMissionByDateAndTaux(new BigDecimal(100));
		assertThat(missions).contains(mission);
		assertThat(missions).doesNotContain(mission2);
		assertThat(missions).doesNotContain(mission3);
	}
}
