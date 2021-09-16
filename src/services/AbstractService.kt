package services

import models.DevUser
import models.Project
import models.User

open class AbstractService {

	

	fun createProject(user: User) {


		println("Type the name of the project: ")
		var name: String = readLine()!!.toString()

		println("Type the language of the project: ")
		var language: String = readLine()!!.toString()

		var project: Project = Project(name, language)

		// A way to iterate the projects entity and incremeting 1 into their id's
		project.id = returnTheIdOfProject(user)
		user.projects.add(project);


	}

	fun deleteProject(user: User) {

		println("Type the ID of the project that you want to delete: ")
		var projectId: Int = readLine()!!.toInt()

		try {
			var project: Project = user.projects.single { it.id == projectId }
			user.projects.remove(project)
		} catch (e: NoSuchElementException) {
			println("This project ID does not exist")
		}

	}

	fun returnTheIdOfProject(user: User): Int {
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