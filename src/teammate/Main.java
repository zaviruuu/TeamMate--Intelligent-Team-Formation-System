package teammate;

import teammate.utils.FileHandler;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("--- TeamMate: Intelligent Team Formation System ---");


        // Load participants_sample.csv
        String csvFile = "data/participants_sample.csv";


        // Load the participants
        List<Participant> allParticipants = FileHandler.loadParticipants(csvFile);

        if (allParticipants.isEmpty()) {
            System.out.println("No participants loaded. Exiting.");
            return;
        }

        // Print the first few participants to verify loading
        System.out.println("\nFirst 5 Loaded Participants:");
        for(int i = 0; i < 5 && i < allParticipants.size(); i++) {
            System.out.println(allParticipants.get(i));
        }

    }
}
