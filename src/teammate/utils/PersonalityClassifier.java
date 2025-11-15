package teammate.utils;

// This class implements the logic from Personality Type Classification.docx
public class PersonalityClassifier {

    /**
     * Scales the raw 5-question survey score (5-25) to the 100-point scale.
     * @param rawScore The sum of Q1-Q5 (range 5-25)
     * @return The scaled score (range 20-100)
     */
    public static int scaleScore(int rawScore) {
        return rawScore * 4;
    }

    /**
     * Classifies a 100-point scale score into a personality type.
     * @param scaledScore The score from 20-100
     * @return "Leader", "Balanced", "Thinker", or "Undefined"
     */
    public static String classify(int scaledScore) {
        if (scaledScore >= 90 && scaledScore <= 100) {
            return "Leader";
        } else if (scaledScore >= 70 && scaledScore <= 89) {
            return "Balanced";
        } else if (scaledScore >= 50 && scaledScore <= 69) {
            return "Thinker";
        } else {
            // As per the brief, scores can be 50-100.
            // The CSV has scores lower, but the rules only specify 50-100.
            // Default to the lowest category for scores outside range.
            return "Thinker";
        }
    }
}
