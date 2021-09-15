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

		println("{")
		println("'Name': '$name',")
		println("'Credits': '$credits',")
		println("'Projects': [")
		for (i in 0..projects.size - 1) {
			var project: Project = projects.get(i)

			println("{")
			println("'Id': " + project.id.toString() + ",")
			println("'Name': " + "'" + project.name + "',")
			println("'Language': " + "'" + project.language+ "',")


			println("},")

		}
		println("]")
		println("}")


	}
}
