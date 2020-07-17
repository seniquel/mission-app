package dev.mission.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.mission.entite.Mission;

public interface MissionRepository extends JpaRepository<Mission, Integer> {
	
	@Query("select m from Mission m where m.dateDebut >= current_date")
	public List<Mission> findMissionByDate();
	
	@Query("select m from Mission m where m.dateDebut >= current_date and m.tauxJournalier >= ?1")
	public List<Mission> findMissionByDateAndTaux(BigDecimal tauxJournalier);

}
