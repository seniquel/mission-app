package dev.mission.exec;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import dev.mission.entite.Mission;
import dev.mission.repository.MissionRepository;

@Controller
@Profile("lister-par-tjm")
public class ListerProchainesMissionsParTJM implements CommandLineRunner {

	private MissionRepository missionRepository;
	
	public ListerProchainesMissionsParTJM(MissionRepository missionRepository) {
		super();
		this.missionRepository = missionRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		List<Mission> missions = missionRepository.findMissionByDateAndTaux(new BigDecimal(args[1]));
		
		System.out.println("Libelle\t\tTaux\tDébut\t\tFin");
		System.out.println();
		missions.forEach(m -> System.out.println(m.getLibelle()+"\t"
				+ m.getTauxJournalier()+"\t"
				+ m.getDateDebut()+"\t"
				+ m.getDateFin()));
		
	}

}
