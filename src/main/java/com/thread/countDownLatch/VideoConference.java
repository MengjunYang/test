package com.thread.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class VideoConference implements Runnable {
	
	private final CountDownLatch controller;
	
	@Override
	public void run() {
		System.out.printf("VideoConference:Initialization:%d participants.\n",controller.getCount());
		try {
			controller.await();
			System.out.printf("All the participants have come.\n");
			System.out.printf("VideoConference:Let's start...\n");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public VideoConference(int number){
		controller = new CountDownLatch(number);
	}
	
	public void arrive(String name){
		System.out.printf("%s has arrived.",name);
		controller.countDown();
		System.out.printf("VideoConference: Waiting for %d participants.\n",controller.getCount());
	}
	
	
	
	public static void main(String[] args) {
		VideoConference vc = new VideoConference(10);
		Thread threadConference = new Thread(vc);
		threadConference.start();
		
		for (int i = 0; i < 10; i++) {
			Participant p = new Participant(vc, "Participant"+i);
			Thread t = new Thread(p);
			t.start();
		}
	}
}
class Participant implements Runnable{
	
	private VideoConference conference;
	private String name;
	
	public Participant(VideoConference conference,String name){
		this.conference = conference;
		this.name = name;
	}

	@Override
	public void run() {
		long duration = (long)(Math.random()*10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		conference.arrive(name);
	}
	
}