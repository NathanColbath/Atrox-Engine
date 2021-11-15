package com.atrox.components;

import com.atrox.controllers.FileManager;
import com.atrox.main.GameContainer;
import com.atrox.tools.Debug;
import com.atrox.tools.Timer;

import java.io.File;



public class Animation extends GameComponent {

	private Sprite[] subImages;
	private String[] filePaths;
	private int frameCount;
	private int currentFrameIndex;
	
	private String pathToAnimationPackage;
	
	private Sprite currentImage;
	
	private float timeBetweenFrames = 1;
	
	private float timer  = 0;

	private Timer changeTimer = new Timer(10);
	
	private boolean loop;
	private boolean endOfAnimation;
	
	private File file;

	public Animation(File file) {
		this.file = file;
		currentImage = null;
		loop = true;
		endOfAnimation = false;
		init();

	}
	
	

	public void init() {



		frameCount = file.list().length;
		filePaths = new String[frameCount];
		subImages = new Sprite[frameCount];
		
		if(file == null) {
			File file = FileManager.readFile(pathToAnimationPackage);

			
			for(int i = 0; i < frameCount; i ++) {
				filePaths[i] = FileManager.getWorkingDirectory() + pathToAnimationPackage + "/" + file.list()[i];
				subImages[i] = new Sprite(filePaths[i]);

				subImages[i].gameObject = gameObject;
				//System.out.println(filePaths[i]);
			}
		}else {
			for(int i = 0; i < frameCount; i ++) {
				filePaths[i] = file.getPath() + "/" + file.list()[i];
				subImages[i] = new Sprite(filePaths[i]);
				subImages[i].gameObject = gameObject;
				//System.out.println(filePaths[i]);
			}
		}
		
		

		
		
		
		
		currentImage = subImages[0];


		
		
	}
	
	public Sprite getCurrentImage() {
		return subImages[currentFrameIndex];
	}

	
	public void setTimeBetweenFrames(float time) {
		timeBetweenFrames = time;
	}
	
	public int getCurrentFrameIndex() {
		return currentFrameIndex;
	}
	
	public int getNumberOfFrames() {
		return frameCount;
	}
	
	public void setLoop(boolean loop) {
		this.loop = loop;
	}

	public Sprite[] getAllFrames(){
		return subImages;
	}


	@Override
	public void run() {

		changeTimer.tick();
		//Debug.logln(changeTimer.isTriggered());


		if(changeTimer.isTriggered()) {
			//timer = 0;

			currentFrameIndex += 1;
			if(loop) {
				if(currentFrameIndex >= frameCount) {
					currentFrameIndex = 0;
				}
			}else {
				endOfAnimation = true;
				currentFrameIndex = frameCount-1;
			}
		}
	}
}
