package models


class ManagerUser: User {
	
	var devs: ArrayList<DevUser> = ArrayList<DevUser>();
	
	constructor(){}
	
	constructor(id: Int, name: String, credits: Int, devs: Array<DevUser>){
		this.id = id
		this.name = name
		this.credits = credits
		this.devs.addAll(devs)
	}
	
}