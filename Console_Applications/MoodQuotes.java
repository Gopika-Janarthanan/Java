import java.util.*;

public class MoodQuotes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> moodQuotes = new HashMap<>();
        moodQuotes.put("sad", Arrays.asList("Keep going. Everything you need will come."));
        moodQuotes.put("anxious", Arrays.asList(
            "You are enough just as you are.",
            "Take a deep breath. You got this."
        ));
        moodQuotes.put("tired", Arrays.asList("Every day is a second chance."));
        moodQuotes.put("unmotivated", Arrays.asList("You were born to do great things."));
        moodQuotes.put("stressed", Arrays.asList("Progress, not perfection."));
        moodQuotes.put("focused", Arrays.asList("Stay focused and never give up."));
        System.out.println("What's your mood today?");
        System.out.print("Enter (1.sad \n 2.anxious \n 3tired \n 4.unmotivated \n 5. stressed \n 6.focused): ");
        String mood = scanner.nextLine().toLowerCase();

        if (moodQuotes.containsKey(mood)) {
            List<String> quotes = moodQuotes.get(mood);
            String randomQuote = quotes.get(new Random().nextInt(quotes.size()));
            System.out.println("\n🌟 Here's something for you:");
            System.out.println("\"" + randomQuote + "\"");
        } else {
            System.out.println("\nOops! Mood not recognized. Try again with listed moods.");
        }

        scanner.close();
    }
}
