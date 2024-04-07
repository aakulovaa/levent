package db;

public class TheatersConst {
    public static final String THEATERS_TABLE = "theaters";

    public static final String THEATER_ID = "theater_id";
    public static final String THEATER_NAME = "theater_name";
    public static final String THEATER_ADDRESS = "theater_address";
    public static final String THEATER_PERFORMANCE_ID = "theater_performance_id";
    public static final String THEATER_THEATERS_SESSIONS_ID = "theater_theaters_sessions_id";

    public static final String PERFORMANCES_TABLE = "performances";

    public static final String PERFORMANCE_ID = "performance_id";
    public static final String PERFORMANCE_NAME = "performance_name";
    public static final String PERFORMANCE_KIND = "performance_kind";
    public static final String PERFORMANCE_LENGTH = "performance_length";
    public static final String PERFORMANCE_AGE_LIMIT = "performance_age_limit";
    public static final String PERFORMANCE_DESCRIPTION = "performance_description";

    public static final String THEATERS_SESSIONS_TABLE = "theaters_sessions";

    public static final String THEATERS_SESSION_ID = "theaters_session_id";
    public static final String THEATERS_SESSION_START_DATE_TIME = "theaters_session_start_date_time";
    public static final String THEATERS_SESSION_PERFORMANCE_ID = "theaters_session_performance_id";
    public static final String THEATERS_SESSION_THEATER_ID = "theaters_session_theater_id";

}
