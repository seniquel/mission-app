package dev.mission.exec;

import java.util.List;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("lister")
public class ListerProchainesMissions implements Runnable {
	
	private MissionRepository missionRepository;
	
	public ListerProchainesMissions(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run() {
		List<Mission> missions = missionRepository.findMissionByDate();
		
		System.out.println("Libelle\t\tTaux\tDébut\t\tFin");
		System.out.println();
		missions.forEach(m -> System.out.println(m.getLibelle()+"\t"
				+ m.getTauxJournalier()+"\t"
				+ m.getDateDebut()+"\t"
				+ m.getDateFin()));
		
	}
}
