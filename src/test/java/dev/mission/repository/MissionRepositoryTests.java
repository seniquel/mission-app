package dev.mission.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.transaction.annotation.Transactional;

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
		assertThat(missionRepository.findAll()).contains(mission);
		assertThat(missionRepository.findAll()).doesNotContain(mission2);
	}
	@Test
	void findByDateDebutGreaterThanEqualAndTauxJournalierGreaterThanEqual() {
		// TODO insérer des données avec `entityManager`
		// TODO exécuter la requête
		// TODO vérifier le résultat
	}
}
