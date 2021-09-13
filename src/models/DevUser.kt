package models

class DevUser: User {
	
	var manager: ManagerUser = ManagerUser()
	
	
	constructor(id: Int, name: String, credits: Int, manager: ManagerUser, projects: Array<Project>){
		this.id = id
		this.name = name
		this.credits = credits
		this.manager = manager
		this.projects.addAll(projects)
	}
}
