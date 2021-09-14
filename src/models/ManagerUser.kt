package models


class ManagerUser : User {

	var devs: ArrayList<DevUser> = ArrayList<DevUser>();

	constructor() {}

	constructor(id: Int, name: String, credits: Int, devs: Array<DevUser>, projects: Array<Project>) {
		this.id = id
		this.name = name
		this.credits = credits
		this.devs.addAll(devs)
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
			println("'id': " + project.id.toString() + ",")
			println("'name': " + "'" + project.name + "',")
			println("'language': " + "'" + project.language + "',")


			println("},")

		}
		println("]")

		println("'Devs': [")
		for (i in 0..devs.size - 1) {
			var dev: DevUser = devs.get(i)

			println("{")
			println("'id': " + dev.id.toString() + ",")
			println("'name': " + "'" + dev.name + "',")
			println("'credits': " + "'" + dev.credits.toString() + "'")

			println("},")

		}
		println("]")
		println("}")


	}

}