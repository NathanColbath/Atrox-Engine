package com.atrox.controllers;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import com.atrox.components.Sprite;
import com.atrox.main.GameContainer;


public class ResourceManager {
	
	private static HashMap<String, Object> resources;
	private static String spriteDir;
	private static GameContainer gc;
	
	public ResourceManager(GameContainer gc) {
		resources = new HashMap<String,Object> ();
		this.gc = gc;
		spriteDir = "";
	}
	
	public static void setSpriteDirectory(String path) {
		spriteDir = path;
	}
	
	public static void addSprite(File file) {
		resources.put(file.getName(), new Sprite(file));
		if(resources.containsKey(file.getName())) {
			return;
		}
	}
	
	public static void addSprite(String fileName) {
		
		File file = gc.getFileManager().readFile(fileName);
		if(resources.containsKey(fileName)) {
			return;
		}
		resources.put(file.getName(), new Sprite(file));
	}
	
	public static void addAudioClipt(String fileName) {
		File file = gc.getFileManager().readFile("/" + fileName);
		if(resources.containsKey(fileName)) {
			return;
		}
		Clip clip = null;
		try {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(audioIn);
		}catch(Exception e) {
			
		}
		
				
		resources.put(file.getName(), clip);
	}
	
	public static Clip getAudioClip(String clipName) {
		return (Clip)resources.get(clipName);
	}
	
	public static Sprite getSprite(String spriteName) {
		Sprite toReturn = (Sprite)resources.get(spriteName);
		return toReturn.copy();
	}
	
	public static File getAnimationPackage(String fileName) {
		return (File)resources.get(fileName);
	}
	
	public static void addAnimationPackage(File file) {
		resources.put(file.getName(), file);
		if(resources.containsKey(file.getName())) {
			return;
		}
	}
	
	public static void addAnimationPackage(String fileName) {
		File file = gc.getFileManager().readFile("/" + fileName);
		if(resources.containsKey(fileName)) {
			return;
		}
		resources.put(file.getName(), file);
	}

}
