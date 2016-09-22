package com.github.alexaegis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private Main() {

    }

    public static void main( String[] args ) throws Exception {
		if (args.length != 0 && args[0].equals("task01")) {
			com.github.alexaegis.task01.Main.main(args);
		} else if (args.length != 0 && args[0].equals("task02")) {
			com.github.alexaegis.task02.Main.main(args);
		} else if (args.length != 0 && args[0].equals("task03")) {
			com.github.alexaegis.task03.Main.main(args);
		} else {
			logger.info("No such project found.");
		}
    }
}