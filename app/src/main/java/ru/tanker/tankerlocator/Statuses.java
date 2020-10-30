package ru.tanker.tankerlocator;

public class Statuses {
    private static String[] statuses = {
            "на ходу с использованием двигателя",
            "на якоре",
            "не под командованием",
            "restricted maneuverability",
            "constrained by her draught",
            "moored",
            "aground",
            "engaged in fishing",
            "under way sailing",
            "reserved for future",
            "reserved for future",
            "power-driven vessel towing astern",
            "power-driven vessel pushing ahead or towing alongside",
            "reserved for future",
            "AIS-SART",
            "undefined"
    };

    public static String getStatusString(int status) {
        try {
            return statuses[status];
        } catch (IndexOutOfBoundsException e) {
            return "неизвестный статус";
        }
    }
}


