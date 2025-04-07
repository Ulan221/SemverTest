import com.github.zafarkhaja.semver.Version;

import static org.example.VersionMatcher.matches;

public class Main {
    public static void main(String[] args) {
        Version version = Version.valueOf("1.11.2");

        System.out.println(matches(version, "1.11.2"));
        System.out.println(matches(version, "1.11.*"));
        System.out.println(matches(version, "1.11>="));
        System.out.println(matches(version, "1.11<="));
        System.out.println(matches(version, ">1.11"));
        System.out.println(matches(version, "1.11<"));
        System.out.println(matches(version, "1.11>"));
        System.out.println(matches(version, "1.10.*"));
    }
}

