package teammate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// This class represents a single formed team.
public class Team {

    private String teamName;
    private List<Participant> members;
    private int teamSize;

    // --- Constructor ---
    public Team(String teamName, int teamSize) {
        this.teamName = teamName;
        this.teamSize = teamSize;
        this.members = new ArrayList<>();
    }

    // --- Core Methods ---

    /**
     * Adds a member to the team.
     * @return true if added successfully, false if the team is full.
     */
    public boolean addMember(Participant participant) {
        if (members.size() < teamSize) {
            members.add(participant);
            return true;
        }
        return false; // Team is full
    }

    /**
     * Checks if the team has reached its target size.
     */
    public boolean isFull() {
        return members.size() == teamSize;
    }

    // --- Helper Methods for Validation ---

    /**
     * Gets a count of each personality type currently in the team.
     * @return A Map, e.g., {"Leader": 1, "Thinker": 2}
     */
    public Map<String, Integer> getPersonalityCounts() {
        Map<String, Integer> counts = new HashMap<>();
        for (Participant p : members) {
            counts.put(p.getPersonalityType(), counts.getOrDefault(p.getPersonalityType(), 0) + 1);
        }
        return counts;
    }

    /**
     * Gets a count of each role currently in the team.
     * @return A Map, e.g., {"Attacker": 2, "Defender": 1}
     */
    public Map<String, Integer> getRoleCounts() {
        Map<String, Integer> counts = new HashMap<>();
        for (Participant p : members) {
            counts.put(p.getPreferredRole(), counts.getOrDefault(p.getPreferredRole(), 0) + 1);
        }
        return counts;
    }

    /**
     * Gets a count of each preferred game currently in the team.
     * @return A Map, e.g., {"FIFA": 2, "CS:GO": 1}
     */
    public Map<String, Integer> getGameCounts() {
        Map<String, Integer> counts = new HashMap<>();
        for (Participant p : members) {
            counts.put(p.getPreferredGame(), counts.getOrDefault(p.getPreferredGame(), 0) + 1);
        }
        return counts;
    }

    /**
     * Calculates the average skill level of the team.
     */
    public double getAverageSkill() {
        if (members.isEmpty()) {
            return 0;
        }
        int totalSkill = 0;
        for (Participant p : members) {
            totalSkill += p.getSkillLevel();
        }
        return (double) totalSkill / members.size();
    }

    // --- Getters and toString ---

    public String getTeamName() {
        return teamName;
    }

    public List<Participant> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        // Builds a summary string for the team
        StringBuilder sb = new StringBuilder();
        sb.append(teamName).append(" (Avg Skill: ").append(String.format("%.2f", getAverageSkill())).append(")\n");
        for (Participant p : members) {
            sb.append("  - ").append(p.getName())
                    .append(" (").append(p.getPersonalityType())
                    .append(", ").append(p.getPreferredRole())
                    .append(", Skill: ").append(p.getSkillLevel())
                    .append(")\n");
        }
        return sb.toString();
    }
}
