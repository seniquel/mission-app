package dev.mission.exec;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("insert")
public class InsererMission implements Runnable {
	
	private MissionRepository missionRepository;
	
	public InsererMission(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		Mission mission = new Mission();
		mission.setLibelle("Mission 1");
		mission.setTauxJournalier(new BigDecimal("100.90"));
		mission.setDateDebut(LocalDate.of(2019, 1, 1));
		mission.setDateFin(LocalDate.of(2019, 3, 4));		
		this.missionRepository.save(mission);
		
		Mission mission2 = new Mission();
		mission2.setLibelle("Mission 2");
		mission2.setTauxJournalier(new BigDecimal("50.70"));
		mission2.setDateDebut(LocalDate.of(2019, 2, 17));
		mission2.setDateFin(LocalDate.of(2019, 2, 24));
		this.missionRepository.save(mission2);
		
		Mission mission3 = new Mission();
		mission3.setLibelle("Mission 3");
		mission3.setTauxJournalier(new BigDecimal("200.12"));
		mission3.setDateDebut(LocalDate.of(2020, 12, 24));
		mission3.setDateFin(LocalDate.of(2021, 2, 10));
		this.missionRepository.save(mission3);
		
		Mission mission4 = new Mission();
		mission4.setLibelle("Mission 4");
		mission4.setTauxJournalier(new BigDecimal("123.40"));
		mission4.setDateDebut(LocalDate.of(2020, 8, 9));
		mission4.setDateFin(LocalDate.of(2020, 10, 11));
		this.missionRepository.save(mission4);
		

	}
}