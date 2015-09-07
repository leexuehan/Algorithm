package com.study;

interface Skills {  
	public void act();
}

class Kungfu implements Skills {
	public void act() {
		System.out.println("易阳指");
	}
}

class Hong extends Kungfu{
	
    Skills skills;
    public Hong(Skills skills) {
    	this.skills = skills;
    }
    
    public void act() {
    	skills.act();
    	addSkills();
    }
    
    public void addSkills() {
    	System.out.println("九阳神功");
    }

}

class Guo implements Skills {
	public void act() {
		System.out.println("蹲马步");
	}
}

public class DecorateDemo {
	public static void main(String[] args) {
		Skills skills = new Guo();
		skills.act();
		Skills skill2 = new Hong(skills);
		skill2.act();
	}
}
