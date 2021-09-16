package services

import models.DevUser
import models.Project

class DevUserService {

	fun createDevUser(): DevUser {

		var devUser: DevUser = DevUser()


		println("Type your name: ")
		var name: String = readLine()!!.toString()
		devUser.name = name;

		println("Do you have any projects? Yes (1) No (2)")
		var op: Int = readLine()!!.toInt()

		if (op == 1) {

			var operation: Int = 1;


			while (operation == 1) {

				println("Type the name of the project: ")
				var projectName: String = readLine()!!.toString()

				println("Type the language of the project: ")
				var projectLanguage: String = readLine()!!.toString()

				var project: Project = Project(projectName, projectLanguage)


				// A way to iterate the projects entity and incremeting 1 into their id's
				project.id = returnTheIdOfProject(devUser)
				devUser.projects.add(project);



				println("Do you still have projects? Yes (1) No (2)")
				operation = readLine()!!.toInt()


			}


		}
		return devUser;
	}


	fun createProject(user: DevUser) {


		println("Type the name of the project: ")
		var name: String = readLine()!!.toString()

		println("Type the language of the project: ")
		var language: String = readLine()!!.toString()

		var project: Project = Project(name, language)

		// A way to iterate the projects entity and incremeting 1 into their id's
		project.id = returnTheIdOfProject(user)
		user.projects.add(project);

	}

	fun deleteProject(user: DevUser) {

		println("Type the ID of the project that you want to delete: ")
		var projectId: Int = readLine()!!.toInt()

		try {
			var project: Project = user.projects.single { it.id == projectId }
			user.projects.remove(project)
		} catch (e: NoSuchElementException) {
			println("This project ID does not exist")
		}

	}
	
	


	fun returnTheIdOfProject(user: DevUser): Int {
		var id: Int = 1;

		for (i in 1..user.projects.size) {

			try {
				user.projects.single { it.id == i }
				id = i + 1;
			} catch (e: NoSuchElementException) {
				return i;
			}
		}

		return id;
	}

}