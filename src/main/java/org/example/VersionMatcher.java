package org.example;

import com.github.zafarkhaja.semver.Version;

public class VersionMatcher {

    public static boolean matches(Version version, String condition) {
        if (condition.endsWith("*")) {
            String[] parts = condition.replace(".*", "").split("\\.");
            if (parts.length != 2) return false;

            int major = Integer.parseInt(parts[0]);
            int minor = Integer.parseInt(parts[1]);

            return version.getMajorVersion() == major &&
                    version.getMinorVersion() == minor;
        } else if (condition.endsWith(">=")) {
            String versionStr = condition.substring(0, condition.length() - 2);
            return version.greaterThanOrEqualTo(parseVersion(versionStr));
        } else if (condition.endsWith("<=")) {
            String versionStr = condition.substring(0, condition.length() - 2);
            return version.lessThanOrEqualTo(parseVersion(versionStr));
        } else if (condition.endsWith(">")) {
            String versionStr = condition.substring(0, condition.length() - 1);
            return version.greaterThanOrEqualTo(parseVersion(versionStr));
        } else if (condition.endsWith("<")) {
            String versionStr = condition.substring(0, condition.length() - 1);
            return version.lessThanOrEqualTo(parseVersion(versionStr));
        } else if (condition.startsWith(">")) {
            String versionStr = condition.substring(1);
            return version.greaterThan(parseVersion(versionStr));
        } else if (condition.startsWith("<")) {
            String versionStr = condition.substring(1);
            return version.lessThan(parseVersion(versionStr));
        }

        return version.equals(parseVersion(condition));
    }

    private static Version parseVersion(String versionStr) {
        if (versionStr.split("\\.").length == 2) {
            versionStr += ".0";
        }
        return Version.valueOf(versionStr);
    }
}
