package teammate.utils;

import teammate.Participant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// This class handles all File I/O operations
public class FileHandler {

    /**
     * Loads participants from a specified CSV file.
     * @param csvPath The path to the participants_sample.csv
     * @return A List of Participant objects
     */
    public static List<Participant> loadParticipants(String csvPath) {
        List<Participant> participants = new ArrayList<>();
        String line = "";



        try (BufferedReader br = new BufferedReader(new FileReader(csvPath))) {

            // Read and skip the header line
            br.readLine();

            // Read each subsequent line
            while ((line = br.readLine()) != null) {
                // Split the line by the comma
                String[] data = line.split(",");

                if (data.length == 8) { // Ensure the row has all 8 expected fields
                    // Create a new Participant object and add it to the list
                    Participant p = new Participant(
                            data[0], data[1], data[2], data[3],
                            data[4], data[5], data[6], data[7]
                    );
                    participants.add(p);
                } else {
                    System.err.println("Skipping malformed line in CSV: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("ERROR: The file was not found at path: " + csvPath);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("ERROR: Could not read the file: " + e.getMessage());
            e.printStackTrace();
        }

        System.out.println("Successfully loaded " + participants.size() + " participants.");
        return participants;
    }

    /**
     * Placeholder for saving teams. Will be implemented later.
     * @param teams A list of Team objects (which we will create later)
     * @param outputPath The path for the output file (e.g., "formed_teams.csv")
     */
    // public static void saveTeams(List<Team> teams, String outputPath) {
    //    // Implementation will go here
    // }
}
