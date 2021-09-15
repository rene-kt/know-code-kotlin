package services

import models.ManagerUser

import models.DevUser
import models.Project

class ManagerUserService {


	fun createManagerUser(): ManagerUser {

		var managerUser: ManagerUser = ManagerUser()
		var devService: DevUserService = DevUserService()


		println("Type your name: ")
		var name: String = readLine()!!.toString()
		managerUser.name = name;

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
				project.id = managerUser.projects.size + 1;
				managerUser.projects.add(project);



				println("Do you still have projects? Yes (1) No (2)")
				operation = readLine()!!.toInt()


			}


		}


		println("Do you have any developers that work with you? Yes (1) No (2) ")
		var operation: Int = readLine()!!.toInt()


		if (operation == 1) {
			var option: Int = 0;

			while (option != 2) {
				var devUser: DevUser = devService.createDevUser()

				devUser.id = managerUser.devs.size + 1;
				managerUser.devs.add(devUser);

				println("Do you still have devs? Yes (1) No (2)")
				option = readLine()!!.toInt()
			}

		}

		return managerUser;
	}

	fun findDevById(manager: ManagerUser, id: Int): DevUser {
		var dev: DevUser = DevUser()
		try {
			return manager.devs.single { it.id == id }
		} catch (e: NoSuchElementException) {
			println("This ID does not exist")
			return dev;
		}
	}


	fun changeOwnCredits(manager: ManagerUser) {

		println("Do you want to add (1) or remove (2) your credits?")
		var op: Int = readLine()!!.toInt()

		when (op) {
			1 -> addOwnCredits(manager)
			2 -> removeOwnCredits(manager)
		}


	}

	fun changeDevsCredits(manager: ManagerUser) {


		println("Type the dev's ID: ")
		var id: Int = readLine()!!.toInt()
		var dev: DevUser = findDevById(manager, id)

		println("Do you want to add (1) or remove (2) their credits?")
		var op: Int = readLine()!!.toInt()

		when (op) {
			1 -> addDevsCredits(dev)
			2 -> removeDevsCredits(dev)
		}


	}


	fun addOwnCredits(manager: ManagerUser) {
		println("How much do you want to add?")
		var credits: Int = readLine()!!.toInt()
		manager.credits += credits;

	}

	fun removeOwnCredits(manager: ManagerUser) {
		println("How much do you want to remove?")
		var credits: Int = readLine()!!.toInt()
		manager.credits -= credits;

	}

	fun addDevsCredits(dev: DevUser) {
		println("How much do you want to add?")
		var credits: Int = readLine()!!.toInt()
		dev.credits += credits;

	}

	fun removeDevsCredits(dev: DevUser) {
		println("How much do you want to remove?")
		var credits: Int = readLine()!!.toInt()
		dev.credits -= credits;

	}


	fun createProject(manager: ManagerUser, project: Project) {

		// A way to iterate the projects entity and incremeting 1 into their id's
		project.id = returnTheIdOfProject(manager)
		manager.projects.add(project);

	}

	fun deleteProject(manager: ManagerUser, projectId: Int) {
		manager.projects.removeAt(projectId - 1)


		// Avoid the duplicate IDs after the delete
		for (i in projectId - 1..manager.projects.size - 1) {
			manager.projects.get(i).id -= 1;
		}
	}
	
	fun createDev(manager: ManagerUser){
		var devService: DevUserService = DevUserService()
		var dev: DevUser
		
		dev = devService.createDevUser()
		dev.id = returnTheIdOfDevs(manager)
		manager.devs.add(dev)
	}
	
	fun deleteDev(manager: ManagerUser){
		println("Type the ID of the dev that you want to delete: ")
		var devId: Int = readLine()!!.toInt()
		manager.devs.remove(findDevById(manager, devId))
	}
	
	
	fun returnTheIdOfProject(user: ManagerUser): Int {
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
	
		fun returnTheIdOfDevs(user: ManagerUser): Int {
		var id: Int = 1;

		for (i in 1..user.devs.size) {

			try {
				user.devs.single { it.id == i }
				id = i + 1;
			} catch (e: NoSuchElementException) {
				return i;
			}
		}

		return id;
	}

}