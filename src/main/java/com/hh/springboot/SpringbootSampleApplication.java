package com.hh.springboot;

import com.hh.springboot.state.Events;
import com.hh.springboot.state.States;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.statemachine.StateMachine;

import javax.annotation.Resource;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringbootSampleApplication implements CommandLineRunner {



	public static void main(String[] args) {
		SpringApplication.run(SpringbootSampleApplication.class, args);
	}

	@Resource
	private StateMachine<States, Events> stateMachine;

	@Override
	public void run(String... args) throws Exception {
		stateMachine.start();
		stateMachine.sendEvent(Events.PAY);
		stateMachine.sendEvent(Events.RECEIVE);
	}
}
