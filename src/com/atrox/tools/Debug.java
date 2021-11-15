package com.atrox.tools;

public class Debug {

    //TODO Add the ablility to log to a a console window
    public static void log(String out){
        System.out.print(out);
    }

    public static void logln(String out){
        System.out.println(out);
    }

    public static void log(int out){
        log(""+out);
    }

    public static void log(long out){
        log(""+out);
    }

    public static void log(double out){
        log(""+out);
    }

    public static void log(float out){
        log(""+out);
    }

    public static void log(boolean out){
        log(""+out);
    }

    public static void log(Object out){
        log(""+out);
    }

    public static void logln(int out){
        logln(""+out);
    }

    public static void logln(long out){
        logln(""+out);
    }

    public static void logln(float out){
        logln(""+out);
    }

    public static void logln(double out){
        logln(""+out);
    }

    public static void logln(boolean out){
        logln(""+out);
    }

    public static void logln(Object out){
        logln(""+out);
    }

    public static void error(String error){System.err.println("[ERROR]: " + error);System.exit(1);}

}
