package services

import models.DevUser
import models.User
import models.Project

class DevUserService : AbstractService() {
	fun createUser(): DevUser {

		var user: DevUser = DevUser()

		println("Type your name: ")
		var name: String = readLine()!!.toString()
		user.name = name;

		println("Do you have any projects? Yes (1) No (2)")
		var op: Int = readLine()!!.toInt()

		if (op == 1) {

			var operation: Int = 1;


			while (operation == 1) {

				var project: Project = Project()

				println("Type the name of the project: ")
				project.name = readLine()!!.toString()

				println("Type the language of the project: ")
				project.language = readLine()!!.toString()

				project.id = user.projects.size + 1;
				user.projects.add(project);

				println("Do you still have projects? Yes (1) No (2)")
				operation = readLine()!!.toInt()

			}

		}

		return user;
	}

}