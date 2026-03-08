package com.rolfandco.weaponry_expansion;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

import static com.rolfandco.weaponry_expansion.WeaponryExpansion.MODID;

public class Logger { // RIPPED STRAIGHT FROM [https://github.com/Choonster-Minecraft-Mods/TestMod3/blob/700d68e99199c54086ecab33c7a90102a3fee03b/src/main/java/choonster/testmod3/Logger.java]. Many thanks!
    public static final Marker MOD_MARKER = MarkerManager.getMarker(MODID);

    private static org.apache.logging.log4j.Logger logger;

    public static void log(Level level, String format, Object... data) {
        logger.printf(level, format, data);
    }

    public static void log(Level level, Throwable throwable, String format, Object... data) {
        logger.log(level, String.format(format, data), throwable);
    }

    public static void log(Level level, Marker marker, String format, Object... data) {
        logger.printf(level, marker, format, data);
    }

    public static void log(Level level, Marker marker, Throwable throwable, String format, Object... data) {
        logger.log(level, marker, String.format(format, data), throwable);
    }

    public static void fatal(String format, Object... data) {
        log(Level.FATAL, format, data);
    }

    public static void fatal(Marker marker, String format, Object... data) {
        log(Level.FATAL, marker, format, data);
    }

    public static void fatal(Throwable throwable, String format,
                             Object... data) {
        log(Level.FATAL, throwable, format, data);
    }

    public static void fatal(Marker marker, Throwable throwable, String format,
                             Object... data) {
        log(Level.FATAL, marker, throwable, format, data);
    }

    public static void error(String format, Object... data) {
        log(Level.ERROR, format, data);
    }

    public static void error(Marker marker, String format, Object... data) {
        log(Level.ERROR, marker, format, data);
    }

    public static void error(Throwable throwable, String format,
                             Object... data) {
        log(Level.ERROR, throwable, format, data);
    }

    public static void error(Marker marker, Throwable throwable, String format,
                             Object... data) {
        log(Level.ERROR, marker, throwable, format, data);
    }

    public static void warn(String format, Object... data) {
        log(Level.WARN, format, data);
    }

    public static void warn(Marker marker, String format, Object... data) {
        log(Level.WARN, marker, format, data);
    }

    public static void info(String format, Object... data) {
        log(Level.INFO, format, data);
    }

    public static void info(Marker marker, String format, Object... data) {
        log(Level.INFO, marker, format, data);
    }

    public static void info(Throwable throwable, String format,
                            Object... data) {
        log(Level.INFO, throwable, format, data);
    }

    public static void info(Marker marker, Throwable throwable, String format,
                            Object... data) {
        log(Level.INFO, marker, throwable, format, data);
    }

    public static void debug(String format, Object... data) {
        log(Level.DEBUG, format, data);
    }

    public static void debug(Marker marker, String format, Object... data) {
        log(Level.DEBUG, marker, format, data);
    }

    public static void debug(Marker marker, Throwable throwable, String format,
                             Object... data) {
        log(Level.DEBUG, marker, throwable, format, data);
    }

    public static void setLogger(org.apache.logging.log4j.Logger logger) {
        if (Logger.logger != null) {
            throw new IllegalStateException("Attempt to replace logger");
        }

        Logger.logger = logger;
    }


}