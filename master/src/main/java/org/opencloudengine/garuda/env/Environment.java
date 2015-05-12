package org.opencloudengine.garuda.env;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Environment
 *
 * @author Sang Wook, Song
 *
 */
public class Environment {
	
	private static Logger logger;
	
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final String PATH_SEPARATOR = System.getProperty("path.separator");
	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	public static final String OS_NAME = System.getProperty("os.name");
	
	private String home = "";
	private File homeFile;
	
	private SettingManager settingManager;
	
	public Environment(String homeDirPath){
		home = homeDirPath;
		homeFile= new File(homeDirPath);
		
		if (home.length() > 0 && !home.endsWith(FILE_SEPARATOR)) {
			home = home + FILE_SEPARATOR;
		}
		
		System.setProperty("logback.configurationFile", new File(new File(homeFile, "conf"), "logback.xml").getAbsolutePath());
		System.setProperty("log.path", new File(homeFile, "logs").getAbsolutePath());
		
		logger = LoggerFactory.getLogger(Environment.class);
		 
		logger.info("JAVA >> {} {}", System.getProperty("java.vendor"), System.getProperty("java.version"));
		logger.info("Setting Home = {}", home);
		logger.info("logback.configurationFile = {}", new File(new File(homeFile, "conf"), "logback.xml").getAbsolutePath());
	}
	
	public Environment init() {
		settingManager = new SettingManager(this);
		return this;
	}
	
	public String home() {
		return home;
	}
	public File homeFile() {
		return homeFile;
	}
	
	public SettingManager settingManager(){
		return settingManager;
	}
	
	public Path filePaths(){
		return new Path(homeFile);
	}

}