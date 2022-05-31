package com.working.jjpractice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.working.jjpractice.controller.FirstController;
import com.working.jjpractice.controller.GarbageTest;
import com.working.jjpractice.controller.SecondController;
import com.working.jjpractice.controller.ThirdController;


//use below command on cmd to find process with 8080 port
//netstat -ano | findstr 8080

//cmd command to kill process id: 27536
//taskkill /F /pid 27536



@SpringBootApplication
public class JjpracticeApplication {

	public static void main(String[] args) {
		//ConfigurableApplicationContext is 
		ConfigurableApplicationContext context= SpringApplication.run(JjpracticeApplication.class, args);
		
		
		//Singleton object creation 
		FirstClass fc= context.getBean(FirstClass.class);
		FirstClass fc1= context.getBean(FirstClass.class);
		FirstClass fc2= context.getBean(FirstClass.class);
		FirstClass fc3= context.getBean(FirstClass.class);
		
		// below call will demonstrate Singleton behavior 
		fc.showAll();
		fc1.showAll();
		fc2.showAll();
		fc3.showAll();
		
		//Defaulted to Singleton object creation
		FirstController ff=context.getBean(FirstController.class);
		FirstController ff1=context.getBean(FirstController.class);
		System.out.println(ff.getString());
		System.out.println(ff1.getString());
		
		//prototype object creation(created new object using below calls)
		SecondController ss=context.getBean(SecondController.class);
		SecondController ss2=context.getBean(SecondController.class);
		SecondController ss3=context.getBean(SecondController.class);
		SecondController ss4=context.getBean(SecondController.class);
		
		// below two lines will demonstrate prototype behavior 
		System.out.println(ss.getString());
		System.out.println(ss2.getString());
		
		
		//System.out.println(context.getApplicationName());
		//System.out.println(context.getDisplayName());
		//System.out.println(context);
		System.out.println("-------------------------------");
		
		
		//Demonstrate How @Autowired will call very first object created
		//and will not create new object even when source is prototype
		ThirdController tt=context.getBean(ThirdController.class);
		tt.showThird();
		
		
		GarbageTest gg=new GarbageTest();
		System.out.println("gg id:"+gg.getId());

		gg.showG();
		GarbageTest gg1=new GarbageTest();
		System.out.println("gg id:"+gg1.getId());

		gg.showG();
		GarbageTest gg2=new GarbageTest();
		System.out.println("gg id:"+gg2.getId());

		gg.showG();
		GarbageTest gg3=new GarbageTest();
		System.out.println("gg id:"+gg3.getId());

		gg.showG();
		GarbageTest gg4=new GarbageTest();
		System.out.println("gg id:"+gg4.getId());
		
		gg.showG();
		
		{
		GarbageTest gg5=new GarbageTest();
		System.out.println("gg id:"+gg.getId());

		gg.showG();
		GarbageTest gg6=new GarbageTest();
		System.out.println("gg id:"+gg.getId());

		gg.showG();
		GarbageTest gg7=new GarbageTest();
		System.out.println("gg id:"+gg.getId());

		gg.showG();
		
		
		//as we make objects null they qualify for garbage collection 
		gg5=gg6=gg7=null;
		
		//below system calls will initiate garbage collection and 
		//will trigger number of times finalize function in respective classes
		//whose objects are made null
		System.gc();
		System.runFinalization();
		
		}

		gg.showG();

	}

}
