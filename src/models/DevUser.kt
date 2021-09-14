package models

class DevUser : User {

	var manager: ManagerUser = ManagerUser()


	constructor() {}
	constructor(id: Int, name: String, credits: Int, manager: ManagerUser, projects: Array<Project>) {
		this.id = id
		this.name = name
		this.credits = credits
		this.manager = manager
		this.projects.addAll(projects)
	}


	fun returnProfile() {

		println("Name: $name")
		println("Credits: $credits")
		println("Projects: [")
		for (i in 0..projects.size - 1) {
			println(projects.get(i).id.toString() + "-" + projects.get(i).name + "|" + projects.get(i).language)
		}
		println("]")


	}
}
