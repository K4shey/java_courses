package academy.devonline.java.basic.section11_decomposition;

import java.util.Arrays;
import java.util.Locale;

public class VerifierForGitCommitMessages {

    public static void main(String[] args) {
        String commitMessage =
                "Summarize changes in around 50 characters or less\n" +
                        "\n" +
                        "More detailed explanatory text, if necessary. Wrap it to about 72\n" +
                        "characters or so. In some contexts, the first line is treated as the\n" +
                        "subject of the commit and the rest of the text as the body. The\n" +
                        "blank line separating the summary from the body is critical (unless\n" +
                        "you omit the body entirely); various tools like `log`, `shortlog`\n" +
                        "and `rebase` can get confused if you run the two together.\n" +
                        "\n" +
                        "Explain the problem that this commit is solving. Focus on why you\n" +
                        "are making this change as opposed to how (the code explains that).\n" +
                        "Are there side effects or other unintuitive consequences of this\n" +
                        "change? Here's the place to explain them.";
        validateGitCommitMessage(commitMessage);
    }

    private static void validateGitCommitMessage(final String commitMessage) {
        // Your impl must be here
        String[] array = getSplitText(commitMessage);
        String subject = array[0];
        if (subject.isEmpty()) {
            System.out.println("The subject is empty");
            return;
        }
        if (subject.length() > 50) {
            System.out.println("The subject's length is greater then 50 characters");
            return;
        }
        if (!subjectBeginsCapitalLetter(subject)) {
            System.out.println("Subject is not begins from capital letter");
            return;
        }
        if (subjectEndsByDot(subject)) {
            System.out.println("Subject ends by dot");
            return;
        }
        if (!firstWordIsCorrect(subject)) {
            System.out.println("First subject's word is not verb in imperative mood");
            return;
        }
        if (array.length > 2 && !bodyIsCorrect(array)) {
            System.out.println("There are strings of body than has length greater than 72 characters");
            return;
        }
        System.out.println("Message is valid!");
    }

    private static String[] getSplitText(String commitMessage) {
        StringBuilder str = new StringBuilder();
        String[] array = new String[commitMessage.length() / 2];
        int index = 0;
        for (int i = 0; i < commitMessage.length(); i++) {
            if (commitMessage.charAt(i) != '\n') {
                str.append(commitMessage.charAt(i));
//            } else if (str.length() > 0) {
            } else {
                array[index++] = str.toString();
                str.setLength(0);
            }
        }
//        System.out.println(Arrays.toString(array));
        return array;
    }

    private static boolean subjectBeginsCapitalLetter(String subject) {
        return (subject.charAt(0) >= 'A' && subject.charAt(0) <= 'Z');
    }

    private static boolean subjectEndsByDot(String subject) {
        return (subject.charAt(subject.length() - 1) == '.');
    }

    private static boolean firstWordIsCorrect(String subject) {
        String verb = firstWordOfSubject(subject);
        return verbInImperativeMood(verb);
    }

    private static String firstWordOfSubject(String subject) {
        StringBuilder verb = new StringBuilder();
        for (int i = 0; i < subject.length(); i++) {
            if (subject.charAt(i) != ' ') {
                verb.append(subject.charAt(i));
            } else {
                break;
            }
        }
//        System.out.println(verb.toString());
        return verb.toString();
    }

    private static boolean verbInImperativeMood(String verb) {
        String[] arrayOfVerbs = {"refactor", "update", "remove", "release", "merge", "summarize"};
        boolean result = false;
        for (String currentVerb : arrayOfVerbs) {
            if (currentVerb.equals(verb.toLowerCase(Locale.ROOT))) {
                result = true;
                break;
            }
        }
        return result;
    }

    private static boolean bodyIsCorrect(String[] array) {
        boolean result = true;
        for (int i = 2; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            if (array[i].length() > 72) {
//                System.out.println("No = " + i);
                result = false;
                break;
            }
        }
        return result;
    }
}