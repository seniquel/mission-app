package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("lister-par-tjm")
public class ListerProchainesMissionsParTJM implements Runnable {

	private MissionRepository missionRepository;
	@Value("${data.tjm}")
	private BigDecimal TJM;
	
	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}
	
	@Override
	public void run() {
		List<Mission> missions = missionRepository.findMissionByDateAndTaux(TJM);
		
		System.out.println("Libelle\t\tTaux\tDébut\t\tFin");
		System.out.println();
		missions.forEach(m -> System.out.println(m.getLibelle()+"\t"
				+ m.getTauxJournalier()+"\t"
				+ m.getDateDebut()+"\t"
				+ m.getDateFin()));
		
	}

}
