package teammate;

// This class holds the data for one Participant.
// It's an "entity" class.
public class Participant {

    // --- Attributes ---
    // All attributes are private to ensure encapsulation.
    private String id;
    private String name;
    private String email;
    private String preferredGame;
    private int skillLevel; // Stored as int for calculations
    private String preferredRole;
    private int personalityScore; // The raw score from CSV
    private String personalityType;

    // --- Constructor ---
    // A constructor to create a Participant object from a CSV line.
    // It takes all fields as Strings and converts them as needed.
    public Participant(String id, String name, String email, String preferredGame,
                       String skillLevel, String preferredRole, String personalityScore,
                       String personalityType) {

        this.id = id;
        this.name = name;
        this.email = email;
        this.preferredGame = preferredGame;
        this.preferredRole = preferredRole;
        this.personalityType = personalityType;

        // --- Exception Handling ---
        // It wraps number conversions in try-catch blocks.
        try {
            this.skillLevel = Integer.parseInt(skillLevel);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing skill level for " + name + ": " + e.getMessage());
            this.skillLevel = 0; // Set a default value
        }

        try {
            this.personalityScore = Integer.parseInt(personalityScore);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing personality score for " + name + ": " + e.getMessage());
            this.personalityScore = 0; // Set a default value
        }
    }

    // --- Getters ---
    // Public methods to access the private data.
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreferredGame() {
        return preferredGame;
    }

    public int getSkillLevel() {
        return skillLevel;
    }

    public String getPreferredRole() {
        return preferredRole;
    }

    public int getPersonalityScore() {
        return personalityScore;
    }

    public String getPersonalityType() {
        return personalityType;
    }

    // --- toString() Method ---
    // Useful for debugging and printing.
    @Override
    public String toString() {
        return "Participant[" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + preferredRole + '\'' +
                ", type='" + personalityType + '\'' +
                ", skill=" + skillLevel +
                ']';
    }
}

