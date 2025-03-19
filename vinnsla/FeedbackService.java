package vinnsla;
/******************************************************************************
 *  Nafn    : Kristín Sesselja Róbertsdóttir
 *  T-póstur: ksr11@hi.is
 *  Viðmótsforritun 2025
 *
 *  FeedbackService
 *  getur:
 *
 *  -- gefið svör (feedback)
 *****************************************************************************/

public class FeedbackService {

    /**
     * @param answer svar
     * @return feedback
     */
    public static String provideFeedback(String answer) {
        if (answer == null || answer.trim().isEmpty()) {
            return "Svarið er of stutt, reyndu aftur";
        }
        if (answer.toLowerCase().contains("já")) {
            return "frábært!";
        }
        if (answer.toLowerCase().contains("nei")) {
            return "Allt í góðu";
        }
        return "Vinsamlegast svaraðu já eða nei";
    }
    public static void main(String[] args) {
        String userResponse = "já";
        System.out.println(provideFeedback(userResponse));
    }
}
